package io.agora.base.internal.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import io.agora.base.JavaI420Buffer;
import io.agora.base.NV12Buffer;
import io.agora.base.NV21Buffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EncodedImage;
import io.agora.base.internal.video.VideoDecoder;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

@TargetApi(16)
/* loaded from: classes4.dex */
public class HardwareVideoDecoder implements VideoDecoder, VideoSink {
    private static final boolean DEBUG = false;
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MAX_DECODE_TIME_MS = 2000;
    private static final int MAX_DEQUEUED_OUTPUTBUFFERS = 3;
    private static final int MAX_TEXTURE_BUFFER_COUNT = 16;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "HardwareVideoDecoder";

    @Nullable
    private VideoDecoder.Callback callback;
    private final String codecName;
    private final VideoCodecType codecType;
    private int colorFormat;

    @Nullable
    private String customConfigJson;
    private Surface directSurface;
    private final BlockingDeque<FrameInfo> frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean keyFrameRequired;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

    @Nullable
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private final Map<String, String> params;

    @Nullable
    private Handler proxyThreadHandler;

    @Nullable
    private DecodedTextureMetadata renderedTextureMetadata;
    private final EglBase.Context sharedContext;
    private int sliceHeight;
    private int stride;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper;
    private int width;
    private final Queue<TimeStamps> decodeTimeStamps = new ConcurrentLinkedQueue();
    private volatile boolean running = false;

    @Nullable
    private volatile Exception shutdownException = null;
    private final Object dimensionLock = new Object();
    private boolean isHisiCodec = false;

    @Nullable
    private Surface surface = null;
    private final Object textureMetadataLock = new Object();
    private final Queue<DecodedTextureMetadata> dequeuedSurfaceOutputBuffers = new LinkedList();

    @Nullable
    private MediaCodecWrapper codec = null;
    private Map<Long, CodecSpecificInfo> codecSpecificInfoMap = new HashMap();

    public static class DecodedTextureMetadata {
        public final Integer decodeTimeMs;
        public final int height;
        public final int outputBufferIndex;
        public final long presentationTimestampUs;
        public final int rotation;
        public final int width;

        public DecodedTextureMetadata(int i, int i2, int i3, int i4, long j, Integer num) {
            this.outputBufferIndex = i;
            this.width = i2;
            this.height = i3;
            this.rotation = i4;
            this.presentationTimestampUs = j;
            this.decodeTimeMs = num;
        }
    }

    public static class FrameInfo {
        public final long decodeStartTimeMs;
        public final int rotation;

        public FrameInfo(long j, int i) {
            this.decodeStartTimeMs = j;
            this.rotation = i;
        }
    }

    public static class TimeStamps {
        private final long decodeStartTimeMs;
        private final long presentationTimeStampUs;

        public TimeStamps(long j, long j2) {
            this.decodeStartTimeMs = j;
            this.presentationTimeStampUs = j2;
        }
    }

    public HardwareVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, Map<String, String> map, int i, EglBase.Context context, Surface surface) {
        if (!isSupportedColorFormat(i)) {
            throw new IllegalArgumentException("Unsupported color format: " + i);
        }
        VideoDecoderUtils.isSupportHwDecoderByTypeAndProfile(VideoCodecType.H265.name(), VideoCodecProfile.HEVCMain10HDR10.name());
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.colorFormat = i;
        this.params = map;
        this.sharedContext = context;
        this.directSurface = surface;
        this.frameInfos = new LinkedBlockingDeque();
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        if (i % 2 != 0) {
            throw new AssertionError("Stride is not divisible by two: " + i);
        }
        int i5 = (i3 + 1) / 2;
        int i6 = i2 % 2;
        int i7 = i6 == 0 ? (i4 + 1) / 2 : i4 / 2;
        int i8 = i / 2;
        int i9 = (i * i2) + 0;
        int i10 = i8 * i7;
        int i11 = i9 + ((i8 * i2) / 2);
        int i12 = i11 + i10;
        VideoFrame.I420Buffer i420BufferAllocateI420Buffer = allocateI420Buffer(i3, i4);
        byteBuffer.limit((i * i4) + 0);
        byteBuffer.position(0);
        copyPlane(byteBuffer.slice(), i, i420BufferAllocateI420Buffer.getDataY(), i420BufferAllocateI420Buffer.getStrideY(), i3, i4);
        byteBuffer.limit(i9 + i10);
        byteBuffer.position(i9);
        copyPlane(byteBuffer.slice(), i8, i420BufferAllocateI420Buffer.getDataU(), i420BufferAllocateI420Buffer.getStrideU(), i5, i7);
        if (i6 == 1) {
            byteBuffer.position(i9 + ((i7 - 1) * i8));
            ByteBuffer dataU = i420BufferAllocateI420Buffer.getDataU();
            dataU.position(i420BufferAllocateI420Buffer.getStrideU() * i7);
            dataU.put(byteBuffer);
        }
        byteBuffer.limit(i12);
        byteBuffer.position(i11);
        copyPlane(byteBuffer.slice(), i8, i420BufferAllocateI420Buffer.getDataV(), i420BufferAllocateI420Buffer.getStrideV(), i5, i7);
        if (i6 == 1) {
            byteBuffer.position(i11 + (i8 * (i7 - 1)));
            ByteBuffer dataV = i420BufferAllocateI420Buffer.getDataV();
            dataV.position(i420BufferAllocateI420Buffer.getStrideV() * i7);
            dataV.put(byteBuffer);
        }
        return i420BufferAllocateI420Buffer;
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return new NV12Buffer(i3, i4, i, i2, byteBuffer, null).toI420();
    }

    private VideoFrame.Buffer copyNV21ToI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return new NV21Buffer(i3, i4, i, i2, byteBuffer, null).toI420();
    }

    private Thread createOutputThread() {
        return new Thread("HardwareVideoDecoder.outputThread") { // from class: io.agora.base.internal.video.HardwareVideoDecoder.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HardwareVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (HardwareVideoDecoder.this.running) {
                    HardwareVideoDecoder.this.deliverDecodedFrame();
                }
                HardwareVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debug_log(String str) {
    }

    private void deliverByteFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        int i5;
        int i6;
        ByteBuffer byteBuffer;
        int i7;
        synchronized (this.dimensionLock) {
            i3 = this.width;
            i4 = this.height;
            i5 = this.stride;
            i6 = this.sliceHeight;
        }
        int i8 = bufferInfo.size;
        if (i8 < ((i3 * i4) * 3) / 2) {
            Logging.e(TAG, "Insufficient output buffer size: " + bufferInfo.size);
            return;
        }
        int i9 = (i8 >= ((i5 * i4) * 3) / 2 || i6 != i4 || i5 <= i3) ? i5 : (i8 * 2) / (i4 * 3);
        TimeStamps timeStampsPoll = null;
        try {
            byteBuffer = this.codec.getOutputBuffers()[i];
        } catch (IllegalStateException e) {
            Logging.e(TAG, "getOutputBuffers failed", e);
            byteBuffer = null;
        }
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        int i10 = this.colorFormat;
        VideoFrame.Buffer bufferCopyI420Buffer = i10 == 19 ? copyI420Buffer(byteBufferSlice, i9, i6, i3, i4) : (this.isHisiCodec && i10 == 39) ? copyNV21ToI420Buffer(byteBufferSlice, i9, i6, i3, i4) : copyNV12ToI420Buffer(byteBufferSlice, i9, i6, i3, i4);
        try {
            this.codec.releaseOutputBuffer(i, false);
        } catch (IllegalStateException e2) {
            Logging.e(TAG, "deliverByteFrame failed", e2);
        } catch (Exception e3) {
            Logging.e(TAG, "deliverByteFrame error", e3);
        }
        VideoFrame videoFrame = new VideoFrame(bufferCopyI420Buffer, i2, bufferInfo.presentationTimeUs * 1000);
        CodecSpecificInfo codecSpecificInfoRemove = this.codecSpecificInfoMap.remove(Long.valueOf(bufferInfo.presentationTimeUs));
        int size = this.decodeTimeStamps.size();
        while (!this.decodeTimeStamps.isEmpty() && (timeStampsPoll = this.decodeTimeStamps.poll()) != null && timeStampsPoll.presentationTimeStampUs != bufferInfo.presentationTimeUs) {
            Logging.d(TAG, "decodeTimeStamps remove: " + timeStampsPoll.presentationTimeStampUs + " , cannot find presentationTimeUs: " + bufferInfo.presentationTimeUs);
        }
        if (timeStampsPoll == null) {
            Logging.e(TAG, "decodeTimeStamps empty. cannot find: " + bufferInfo.presentationTimeUs);
            i7 = -1;
        } else {
            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - timeStampsPoll.decodeStartTimeMs);
            if (iElapsedRealtime > 2000) {
                Logging.w(TAG, "Very high decode time: " + iElapsedRealtime + "ms.");
                i7 = 2000;
            } else {
                i7 = iElapsedRealtime;
            }
        }
        this.callback.onDecodedFrame(videoFrame, num, null, i7, size, codecSpecificInfoRemove);
        videoFrame.release();
    }

    private void deliverTextureFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        synchronized (this.dimensionLock) {
            i3 = this.width;
            i4 = this.height;
        }
        DecodedTextureMetadata decodedTextureMetadata = new DecodedTextureMetadata(i, i3, i4, i2, bufferInfo.presentationTimeUs, num);
        synchronized (this.textureMetadataLock) {
            this.dequeuedSurfaceOutputBuffers.offer(decodedTextureMetadata);
            maybeRenderDecodedTextureBuffer();
            if (this.dequeuedSurfaceOutputBuffers.size() >= 3) {
                DecodedTextureMetadata decodedTextureMetadataPoll = this.dequeuedSurfaceOutputBuffers.poll();
                debug_log("drop the oldest output frame in cache, pts_us: " + decodedTextureMetadataPoll.presentationTimestampUs);
                try {
                    this.codec.releaseOutputBuffer(decodedTextureMetadataPoll.outputBufferIndex, false);
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "deliverTextureFrame failed", e);
                }
            }
        }
    }

    private void deliverToDirectSurface(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        try {
            this.codec.releaseOutputBuffer(i, true);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "deliverToDirectSurface failed", e);
        }
    }

    private VideoCodecStatus initDecodeInternal(int i, int i2) throws JSONException {
        String str;
        Logging.d(TAG, "initDecodeInternal");
        if (this.proxyThreadHandler == null) {
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        if (this.outputThread != null) {
            Logging.e(TAG, "initDecodeInternal called while the codec is already running");
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = i;
        this.height = i2;
        this.stride = i;
        this.sliceHeight = i2;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        this.decodeTimeStamps.clear();
        String str2 = this.codecName;
        if (str2 == null || (str = Build.HARDWARE) == null || !str2.startsWith(MediaCodecUtils.HISI_PREFIX) || !str.startsWith("bigfish")) {
            this.isHisiCodec = false;
        } else {
            this.isHisiCodec = true;
            Logging.d(TAG, " bigfish isHisiCodec: " + this.isHisiCodec);
        }
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoDecoder.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    VideoCodecStatus videoCodecStatus2 = VideoCodecStatus.OK;
                    try {
                        HardwareVideoDecoder hardwareVideoDecoder = HardwareVideoDecoder.this;
                        hardwareVideoDecoder.codec = hardwareVideoDecoder.mediaCodecWrapperFactory.createByCodecName(HardwareVideoDecoder.this.codecName);
                        return videoCodecStatus2;
                    } catch (Exception unused) {
                        Logging.e(HardwareVideoDecoder.TAG, "Cannot create media decoder " + HardwareVideoDecoder.this.codecName);
                        return VideoCodecStatus.FALLBACK_SOFTWARE;
                    }
                }
            });
            if (videoCodecStatus == null) {
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            VideoCodecStatus videoCodecStatus2 = VideoCodecStatus.OK;
            if (videoCodecStatus != videoCodecStatus2) {
                return videoCodecStatus;
            }
            readVideoCapabilities();
            final MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i, i2);
            if (this.sharedContext == null && this.directSurface == null) {
                mediaFormatCreateVideoFormat.setInteger("color-format", this.colorFormat);
            }
            String str3 = this.params.get(VideoCodecInfo.KEY_AV_DEC_VIDEO_HWDEC_CONFIG);
            this.customConfigJson = str3;
            MediaCodecUtils.applyCustomConfig(mediaFormatCreateVideoFormat, str3);
            try {
                VideoCodecStatus videoCodecStatus3 = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoDecoder.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public VideoCodecStatus call() throws Exception {
                        try {
                            HardwareVideoDecoder.this.codec.configure(mediaFormatCreateVideoFormat, HardwareVideoDecoder.this.surface, null, MediaCodecUtils.applyCustomFlags(HardwareVideoDecoder.this.customConfigJson));
                            HardwareVideoDecoder.this.codec.start();
                            return VideoCodecStatus.OK;
                        } catch (Throwable th) {
                            Logging.e(HardwareVideoDecoder.TAG, "initDecode failed" + th.getMessage());
                            HardwareVideoDecoder.this.release();
                            return VideoCodecStatus.FALLBACK_SOFTWARE;
                        }
                    }
                });
                if (videoCodecStatus3 == null) {
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
                if (videoCodecStatus3 != videoCodecStatus2) {
                    return videoCodecStatus3;
                }
                synchronized (this.textureMetadataLock) {
                    this.dequeuedSurfaceOutputBuffers.clear();
                }
                this.running = true;
                Thread threadCreateOutputThread = createOutputThread();
                this.outputThread = threadCreateOutputThread;
                threadCreateOutputThread.start();
                Logging.w(TAG, "initDecodeInternal " + this.codecType.mimeType() + " done, format: " + mediaFormatCreateVideoFormat);
                return videoCodecStatus2;
            } catch (Exception unused) {
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (Exception unused2) {
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private boolean isSupportedColorFormat(int i) {
        for (int i2 : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isSupportedColorFormatHDR(int i) {
        for (int i2 : MediaCodecUtils.DECODER_COLOR_FORMATS_HDR) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void maybeRenderDecodedTextureBuffer() {
        if (this.renderedTextureMetadata != null) {
            return;
        }
        if (!this.running) {
            Logging.d(TAG, "RenderTexture: Decoder is not running.");
            return;
        }
        DecodedTextureMetadata decodedTextureMetadataPoll = this.dequeuedSurfaceOutputBuffers.poll();
        if (decodedTextureMetadataPoll == null) {
            return;
        }
        try {
            this.surfaceTextureHelper.setTextureSize(decodedTextureMetadataPoll.width, decodedTextureMetadataPoll.height);
        } catch (IllegalArgumentException e) {
            Logging.e(TAG, "setTextureSize:", e);
        }
        this.surfaceTextureHelper.setFrameRotation(decodedTextureMetadataPoll.rotation);
        this.renderedTextureMetadata = decodedTextureMetadataPoll;
        debug_log("render output buffer to surface, pts_us: " + decodedTextureMetadataPoll.presentationTimestampUs);
        try {
            this.codec.releaseOutputBuffer(decodedTextureMetadataPoll.outputBufferIndex, true);
        } catch (IllegalStateException e2) {
            Logging.e(TAG, "deliverToDirectSurface failed", e2);
        } catch (Exception e3) {
            Logging.e(TAG, "deliverToDirectSurface error", e3);
        }
    }

    private void readVideoCapabilities() {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        MediaCodecInfo.CodecCapabilities codecInfo = null;
        try {
            codecInfo = this.codec.getCodecInfo(this.codecType.mimeType());
        } catch (Exception unused) {
            Logging.e(TAG, "Cannot get CodecInfo " + this.codecName);
        }
        if (codecInfo == null || (videoCapabilities = codecInfo.getVideoCapabilities()) == null) {
            return;
        }
        Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        int iIntValue4 = 0;
        if (supportedWidths != null) {
            iIntValue2 = ((Integer) supportedWidths.getUpper()).intValue();
            iIntValue = ((Integer) supportedWidths.getLower()).intValue();
        } else {
            iIntValue = 0;
            iIntValue2 = 0;
        }
        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        if (supportedHeights != null) {
            iIntValue4 = ((Integer) supportedHeights.getUpper()).intValue();
            iIntValue3 = ((Integer) supportedHeights.getLower()).intValue();
        } else {
            iIntValue3 = 0;
        }
        Logging.d(TAG, this.codecType.mimeType() + "  max supported size:" + iIntValue2 + "x" + iIntValue4 + " min supported size:" + iIntValue + "x" + iIntValue3);
        if (Build.VERSION.SDK_INT >= 23) {
            Logging.d(TAG, "max supported instance: " + codecInfo.getMaxSupportedInstances());
        }
    }

    private void reformat(MediaFormat mediaFormat) {
        int integer;
        int integer2;
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Decoder format changed: " + mediaFormat.toString());
        if (mediaFormat.containsKey(MEDIA_FORMAT_KEY_CROP_LEFT) && mediaFormat.containsKey(MEDIA_FORMAT_KEY_CROP_RIGHT) && mediaFormat.containsKey(MEDIA_FORMAT_KEY_CROP_BOTTOM) && mediaFormat.containsKey(MEDIA_FORMAT_KEY_CROP_TOP)) {
            integer = (mediaFormat.getInteger(MEDIA_FORMAT_KEY_CROP_RIGHT) + 1) - mediaFormat.getInteger(MEDIA_FORMAT_KEY_CROP_LEFT);
            integer2 = (mediaFormat.getInteger(MEDIA_FORMAT_KEY_CROP_BOTTOM) + 1) - mediaFormat.getInteger(MEDIA_FORMAT_KEY_CROP_TOP);
        } else {
            integer = mediaFormat.getInteger(VideoCaptureFormat.keyWidth);
            integer2 = mediaFormat.getInteger(VideoCaptureFormat.keyHeight);
        }
        synchronized (this.dimensionLock) {
            if (this.hasDecodedFirstFrame && (this.width != integer || this.height != integer2)) {
                stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2));
                return;
            }
            this.width = integer;
            this.height = integer2;
            if (this.surfaceTextureHelper == null && this.directSurface == null && mediaFormat.containsKey("color-format")) {
                int integer3 = mediaFormat.getInteger("color-format");
                Logging.d(TAG, "reformat, Color: 0x" + Integer.toHexString(integer3));
                if (this.isHisiCodec && integer3 == 47 && Build.VERSION.SDK_INT >= 21) {
                    this.colorFormat = 39;
                } else {
                    this.colorFormat = integer3;
                }
                if (!isSupportedColorFormat(this.colorFormat)) {
                    stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
                    return;
                }
            }
            synchronized (this.dimensionLock) {
                if (mediaFormat.containsKey(MEDIA_FORMAT_KEY_STRIDE)) {
                    this.stride = mediaFormat.getInteger(MEDIA_FORMAT_KEY_STRIDE);
                }
                if (mediaFormat.containsKey(MEDIA_FORMAT_KEY_SLICE_HEIGHT)) {
                    this.sliceHeight = mediaFormat.getInteger(MEDIA_FORMAT_KEY_SLICE_HEIGHT);
                }
                Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                this.sliceHeight = Math.max(this.height, this.sliceHeight);
            }
        }
    }

    private VideoCodecStatus reinitDecode(int i, int i2) {
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        return videoCodecStatusReleaseInternal != VideoCodecStatus.OK ? videoCodecStatusReleaseInternal : initDecodeInternal(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
        synchronized (this.textureMetadataLock) {
            this.dequeuedSurfaceOutputBuffers.clear();
        }
        try {
            this.codec.stop();
        } catch (Exception e) {
            Logging.e(TAG, "Media decoder stop failed", e);
        }
        try {
            this.codec.release();
        } catch (Exception e2) {
            Logging.e(TAG, "Media decoder release failed", e2);
            this.shutdownException = e2;
        }
        Logging.d(TAG, "Release on output thread done");
    }

    private VideoCodecStatus releaseInternal() {
        if (!this.running) {
            Logging.d(TAG, "release: Decoder is not running.");
            return VideoCodecStatus.OK;
        }
        try {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                Logging.e(TAG, "Media decoder release timeout", new RuntimeException());
                return VideoCodecStatus.TIMEOUT;
            }
            if (this.shutdownException != null) {
                Logging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
                this.shutdownException = null;
                return VideoCodecStatus.ERROR;
            }
            this.codec = null;
            this.outputThread = null;
            return VideoCodecStatus.OK;
        } finally {
            this.codec = null;
            this.outputThread = null;
        }
    }

    private void stopOnOutputThread(Exception exc) {
        this.outputThreadChecker.checkIsOnValidThread();
        this.running = false;
        this.shutdownException = exc;
    }

    public VideoFrame.I420Buffer allocateI420Buffer(int i, int i2) {
        return JavaI420Buffer.allocate(i, i2);
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public VideoCodecStatus attachProxyThread() {
        if (this.proxyThreadHandler == null) {
            HandlerThread handlerThread = new HandlerThread("proxyThread-Decoder");
            handlerThread.start();
            this.proxyThreadHandler = new Handler(handlerThread.getLooper());
        }
        return VideoCodecStatus.OK;
    }

    public void copyPlane(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4) {
        YuvHelper.copyPlane(byteBuffer, i, byteBuffer2, i2, i3, i4);
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public long createNativeVideoDecoder() {
        return 0L;
    }

    @Nullable
    public SurfaceTextureHelper createSurfaceTextureHelper() {
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext, 16);
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public VideoCodecStatus decode(final EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo, final CodecSpecificInfo codecSpecificInfo) {
        int i;
        int i2;
        VideoCodecStatus videoCodecStatusReinitDecode;
        if (this.codec == null || this.callback == null || this.proxyThreadHandler == null || !this.running) {
            StringBuilder sb = new StringBuilder();
            sb.append("decode uninitalized, codec: ");
            sb.append(this.codec != null);
            sb.append(", callback: ");
            sb.append(this.callback);
            Logging.d(TAG, sb.toString());
            return VideoCodecStatus.UNINITIALIZED;
        }
        ByteBuffer byteBuffer = encodedImage.buffer;
        if (byteBuffer == null) {
            Logging.e(TAG, "decode() - no input data");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        final int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            Logging.e(TAG, "decode() - input buffer empty");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
        }
        int i3 = encodedImage.encodedWidth;
        int i4 = encodedImage.encodedHeight;
        if (i3 * i4 > 0 && ((i3 != i || i4 != i2) && (videoCodecStatusReinitDecode = reinitDecode(i3, i4)) != VideoCodecStatus.OK)) {
            return videoCodecStatusReinitDecode;
        }
        if (this.keyFrameRequired) {
            if (encodedImage.frameType != EncodedImage.FrameType.VideoFrameKey) {
                Logging.e(TAG, "decode() - key frame required first");
                return VideoCodecStatus.NO_OUTPUT;
            }
            if (!encodedImage.completeFrame) {
                Logging.e(TAG, "decode() - complete frame required first");
                return VideoCodecStatus.NO_OUTPUT;
            }
        }
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoDecoder.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    try {
                        int iDequeueInputBuffer = HardwareVideoDecoder.this.codec.dequeueInputBuffer(500000L);
                        if (iDequeueInputBuffer < 0) {
                            Logging.e(HardwareVideoDecoder.TAG, "decode() - no HW buffers available; decoder falling behind");
                            return VideoCodecStatus.ERROR;
                        }
                        try {
                            ByteBuffer byteBuffer2 = HardwareVideoDecoder.this.codec.getInputBuffers()[iDequeueInputBuffer];
                            if (byteBuffer2.capacity() < iRemaining) {
                                Logging.e(HardwareVideoDecoder.TAG, "decode() - HW buffer too small");
                                return VideoCodecStatus.ERROR;
                            }
                            byteBuffer2.put(encodedImage.buffer);
                            HardwareVideoDecoder.this.frameInfos.offer(new FrameInfo(SystemClock.elapsedRealtime(), encodedImage.rotation));
                            long micros = TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs);
                            try {
                                if (codecSpecificInfo != null) {
                                    HardwareVideoDecoder.this.codecSpecificInfoMap.put(Long.valueOf(micros), codecSpecificInfo);
                                }
                                TimeStamps timeStamps = new TimeStamps(SystemClock.elapsedRealtime(), micros);
                                HardwareVideoDecoder.this.decodeTimeStamps.add(timeStamps);
                                HardwareVideoDecoder.debug_log("queue input buffer, pts_us: " + timeStamps.presentationTimeStampUs);
                                HardwareVideoDecoder.this.codec.queueInputBuffer(iDequeueInputBuffer, 0, iRemaining, micros, 0);
                                if (HardwareVideoDecoder.this.keyFrameRequired) {
                                    HardwareVideoDecoder.this.keyFrameRequired = false;
                                }
                                return VideoCodecStatus.OK;
                            } catch (RuntimeException e) {
                                Logging.e(HardwareVideoDecoder.TAG, "queueInputBuffer failed", e);
                                HardwareVideoDecoder.this.frameInfos.pollLast();
                                HardwareVideoDecoder.this.codecSpecificInfoMap.remove(Long.valueOf(micros));
                                return VideoCodecStatus.ERROR;
                            }
                        } catch (IllegalStateException e2) {
                            Logging.e(HardwareVideoDecoder.TAG, "getInputBuffers failed", e2);
                            return VideoCodecStatus.ERROR;
                        }
                    } catch (IllegalStateException e3) {
                        Logging.e(HardwareVideoDecoder.TAG, "dequeueInputBuffer failed", e3);
                        return VideoCodecStatus.ERROR;
                    }
                }
            });
            return videoCodecStatus == null ? VideoCodecStatus.ERROR : videoCodecStatus;
        } catch (Exception unused) {
            return VideoCodecStatus.ERROR;
        }
    }

    public void deliverDecodedFrame() {
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
            debug_log("dequeue output buffer, pts_us: " + bufferInfo.presentationTimeUs + " result: " + iDequeueOutputBuffer);
            if (iDequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
                return;
            }
            if (iDequeueOutputBuffer < 0) {
                Logging.v(TAG, "dequeueOutputBuffer returned " + iDequeueOutputBuffer);
                return;
            }
            FrameInfo frameInfoPoll = this.frameInfos.poll();
            Integer numValueOf = null;
            int i = 0;
            if (frameInfoPoll != null) {
                numValueOf = Integer.valueOf((int) (SystemClock.elapsedRealtime() - frameInfoPoll.decodeStartTimeMs));
                i = frameInfoPoll.rotation;
            }
            this.hasDecodedFirstFrame = true;
            if (this.directSurface != null) {
                deliverToDirectSurface(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            } else if (this.surfaceTextureHelper != null) {
                deliverTextureFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            } else {
                deliverByteFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            }
        } catch (IllegalStateException e) {
            Logging.e(TAG, "deliverDecodedFrame failed", e);
        }
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public VideoCodecStatus detachProxyThread() {
        Handler handler = this.proxyThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.proxyThreadHandler.getLooper().quitSafely();
            this.proxyThreadHandler = null;
        }
        return VideoCodecStatus.OK;
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public String getImplementationName() {
        return "HWDecoder";
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        if (this.running) {
            Logging.w(TAG, "already initialized!");
            return VideoCodecStatus.OK;
        }
        this.callback = callback;
        Surface surface = this.directSurface;
        if (surface != null) {
            this.surface = surface;
        } else if (this.sharedContext != null) {
            SurfaceTextureHelper surfaceTextureHelperCreateSurfaceTextureHelper = createSurfaceTextureHelper();
            this.surfaceTextureHelper = surfaceTextureHelperCreateSurfaceTextureHelper;
            if (surfaceTextureHelperCreateSurfaceTextureHelper == null) {
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
            this.surfaceTextureHelper.startListening(this);
        }
        return initDecodeInternal(settings.width, settings.height);
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public boolean isHardwareDecoder() {
        return true;
    }

    @Override // io.agora.base.internal.video.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        long j;
        long j2;
        int iIntValue;
        CodecSpecificInfo codecSpecificInfoRemove;
        TimeStamps timeStampsPoll;
        int i;
        synchronized (this.textureMetadataLock) {
            DecodedTextureMetadata decodedTextureMetadata = this.renderedTextureMetadata;
            if (decodedTextureMetadata == null) {
                throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
            }
            j = decodedTextureMetadata.presentationTimestampUs;
            j2 = 1000 * j;
            iIntValue = decodedTextureMetadata.decodeTimeMs.intValue();
            codecSpecificInfoRemove = this.codecSpecificInfoMap.remove(Long.valueOf(this.renderedTextureMetadata.presentationTimestampUs));
            timeStampsPoll = null;
            this.renderedTextureMetadata = null;
            maybeRenderDecodedTextureBuffer();
        }
        VideoFrame videoFrame2 = new VideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), j2);
        int size = this.decodeTimeStamps.size();
        while (!this.decodeTimeStamps.isEmpty() && (timeStampsPoll = this.decodeTimeStamps.poll()) != null && timeStampsPoll.presentationTimeStampUs != j) {
            Logging.d(TAG, "decodeTimeStamps remove: " + timeStampsPoll.presentationTimeStampUs + " , cannot find presentationTimeUs: " + j);
        }
        if (timeStampsPoll == null) {
            Logging.e(TAG, "decodeTimeStamps empty. cannot find: " + j);
            i = -1;
        } else {
            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - timeStampsPoll.decodeStartTimeMs);
            if (iElapsedRealtime > 2000) {
                Logging.w(TAG, "Very high decode time: " + iElapsedRealtime + "ms.");
                i = 2000;
            } else {
                i = iElapsedRealtime;
            }
        }
        boolean z = false;
        if (codecSpecificInfoRemove != null && codecSpecificInfoRemove.getVideoCodecType() == VideoCodecType.H265 && (codecSpecificInfoRemove.getVideoCodecProfile() == VideoCodecProfile.HEVCMain10 || codecSpecificInfoRemove.getVideoCodecProfile() == VideoCodecProfile.HEVCMain10HDR10 || codecSpecificInfoRemove.getVideoCodecProfile() == VideoCodecProfile.HEVCMain10HDR10Plus)) {
            z = true;
        }
        if (z) {
            VideoFrame videoFrame3 = new VideoFrame(videoFrame2.getBuffer(), videoFrame2.getRotation(), videoFrame2.getTimestampNs());
            this.callback.onDecodedFrame(videoFrame3, Integer.valueOf(iIntValue), null, i, size, codecSpecificInfoRemove);
            videoFrame3.release();
            debug_log("frame delivered to native by direct oes, pts_us: " + j);
            return;
        }
        VideoFrame.TextureBuffer textureBufferTextureCopy = this.surfaceTextureHelper.textureCopy((VideoFrame.TextureBuffer) videoFrame2.getBuffer());
        if (textureBufferTextureCopy == null) {
            debug_log("failed to copy texture buffer, drop frame");
            return;
        }
        VideoFrame videoFrame4 = new VideoFrame(textureBufferTextureCopy, videoFrame2.getRotation(), videoFrame2.getTimestampNs());
        this.callback.onDecodedFrame(videoFrame4, Integer.valueOf(iIntValue), null, i, size, codecSpecificInfoRemove);
        videoFrame4.release();
        debug_log("frame delivered to native, pts_us: " + j);
    }

    @Override // io.agora.base.internal.video.VideoDecoder
    public VideoCodecStatus release() {
        Logging.d(TAG, "release");
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        if (this.surface != null && this.directSurface == null) {
            releaseSurface();
            this.surface = null;
            this.surfaceTextureHelper.stopListening();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        synchronized (this.textureMetadataLock) {
            this.renderedTextureMetadata = null;
        }
        this.callback = null;
        this.frameInfos.clear();
        this.decodeTimeStamps.clear();
        return videoCodecStatusReleaseInternal;
    }

    public void releaseSurface() {
        this.surface.release();
    }
}
