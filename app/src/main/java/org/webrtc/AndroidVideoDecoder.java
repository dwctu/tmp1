package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import dc.og4;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.webrtc.EglBase;
import org.webrtc.EncodedImage;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoFrame;

/* loaded from: classes5.dex */
public class AndroidVideoDecoder implements VideoDecoder, VideoSink {
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "AndroidVideoDecoder";

    @Nullable
    private VideoDecoder.Callback callback;

    @Nullable
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecType codecType;
    private int colorFormat;
    private ThreadUtils.ThreadChecker decoderThreadChecker;
    private final BlockingDeque<FrameInfo> frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean keyFrameRequired;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

    @Nullable
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;

    @Nullable
    private DecodedTextureMetadata renderedTextureMetadata;
    private volatile boolean running;

    @Nullable
    private final EglBase.Context sharedContext;

    @Nullable
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;

    @Nullable
    private Surface surface;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper;
    private int width;
    private final Object dimensionLock = new Object();
    private final Object renderedTextureMetadataLock = new Object();

    public static class DecodedTextureMetadata {
        public final Integer decodeTimeMs;
        public final long presentationTimestampUs;

        public DecodedTextureMetadata(long j, Integer num) {
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

    public AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, int i, @Nullable EglBase.Context context) {
        if (!isSupportedColorFormat(i)) {
            throw new IllegalArgumentException("Unsupported color format: " + i);
        }
        Logging.d(TAG, "ctor name: " + str + " type: " + videoCodecType + " color format: " + i + " context: " + context);
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.colorFormat = i;
        this.sharedContext = context;
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

    private Thread createOutputThread() {
        return new Thread("AndroidVideoDecoder.outputThread") { // from class: org.webrtc.AndroidVideoDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                AndroidVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (AndroidVideoDecoder.this.running) {
                    AndroidVideoDecoder.this.deliverDecodedFrame();
                }
                AndroidVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private void deliverByteFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        int i5;
        int i6;
        synchronized (this.dimensionLock) {
            i3 = this.width;
            i4 = this.height;
            i5 = this.stride;
            i6 = this.sliceHeight;
        }
        int i7 = bufferInfo.size;
        if (i7 < ((i3 * i4) * 3) / 2) {
            Logging.e(TAG, "Insufficient output buffer size: " + bufferInfo.size);
            return;
        }
        int i8 = (i7 >= ((i5 * i4) * 3) / 2 || i6 != i4 || i5 <= i3) ? i5 : (i7 * 2) / (i4 * 3);
        ByteBuffer byteBuffer = this.codec.getOutputBuffers()[i];
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        VideoFrame.Buffer bufferCopyI420Buffer = this.colorFormat == 19 ? copyI420Buffer(byteBufferSlice, i8, i6, i3, i4) : copyNV12ToI420Buffer(byteBufferSlice, i8, i6, i3, i4);
        this.codec.releaseOutputBuffer(i, false);
        VideoFrame videoFrame = new VideoFrame(bufferCopyI420Buffer, i2, bufferInfo.presentationTimeUs * 1000);
        this.callback.onDecodedFrame(videoFrame, num, null);
        videoFrame.release();
    }

    private void deliverTextureFrame(int i, MediaCodec.BufferInfo bufferInfo, int i2, Integer num) {
        int i3;
        int i4;
        synchronized (this.dimensionLock) {
            i3 = this.width;
            i4 = this.height;
        }
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata != null) {
                this.codec.releaseOutputBuffer(i, false);
                return;
            }
            this.surfaceTextureHelper.setTextureSize(i3, i4);
            this.surfaceTextureHelper.setFrameRotation(i2);
            this.renderedTextureMetadata = new DecodedTextureMetadata(bufferInfo.presentationTimeUs, num);
            this.codec.releaseOutputBuffer(i, true);
        }
    }

    private VideoCodecStatus initDecodeInternal(int i, int i2) {
        this.decoderThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + i + " height: " + i2);
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
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i, i2);
                if (this.sharedContext == null) {
                    mediaFormatCreateVideoFormat.setInteger("color-format", this.colorFormat);
                }
                this.codec.configure(mediaFormatCreateVideoFormat, this.surface, null, 0);
                this.codec.start();
                this.running = true;
                Thread threadCreateOutputThread = createOutputThread();
                this.outputThread = threadCreateOutputThread;
                threadCreateOutputThread.start();
                Logging.d(TAG, "initDecodeInternal done");
                return VideoCodecStatus.OK;
            } catch (IllegalStateException e) {
                Logging.e(TAG, "initDecode failed", e);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            Logging.e(TAG, "Cannot create media decoder " + this.codecName);
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
            if (this.surfaceTextureHelper == null && mediaFormat.containsKey("color-format")) {
                this.colorFormat = mediaFormat.getInteger("color-format");
                Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
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
        this.decoderThreadChecker.checkIsOnValidThread();
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        return videoCodecStatusReleaseInternal != VideoCodecStatus.OK ? videoCodecStatusReleaseInternal : initDecodeInternal(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
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

    public void copyPlane(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4) {
        YuvHelper.copyPlane(byteBuffer, i, byteBuffer2, i2, i3, i4);
    }

    @Override // org.webrtc.VideoDecoder
    public /* synthetic */ long createNativeVideoDecoder() {
        return og4.$default$createNativeVideoDecoder(this);
    }

    public SurfaceTextureHelper createSurfaceTextureHelper() {
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        int i;
        int i2;
        VideoCodecStatus videoCodecStatusReinitDecode;
        this.decoderThreadChecker.checkIsOnValidThread();
        if (this.codec == null || this.callback == null) {
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
        int iRemaining = byteBuffer.remaining();
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
            int iDequeueInputBuffer = this.codec.dequeueInputBuffer(500000L);
            if (iDequeueInputBuffer < 0) {
                Logging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
                return VideoCodecStatus.ERROR;
            }
            try {
                ByteBuffer byteBuffer2 = this.codec.getInputBuffers()[iDequeueInputBuffer];
                if (byteBuffer2.capacity() < iRemaining) {
                    Logging.e(TAG, "decode() - HW buffer too small");
                    return VideoCodecStatus.ERROR;
                }
                byteBuffer2.put(encodedImage.buffer);
                this.frameInfos.offer(new FrameInfo(SystemClock.elapsedRealtime(), encodedImage.rotation));
                try {
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, iRemaining, TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs), 0);
                    if (this.keyFrameRequired) {
                        this.keyFrameRequired = false;
                    }
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "queueInputBuffer failed", e);
                    this.frameInfos.pollLast();
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "getInputBuffers failed", e2);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e3) {
            Logging.e(TAG, "dequeueInputBuffer failed", e3);
            return VideoCodecStatus.ERROR;
        }
    }

    public void deliverDecodedFrame() {
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
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
            if (this.surfaceTextureHelper != null) {
                deliverTextureFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            } else {
                deliverByteFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            }
        } catch (IllegalStateException e) {
            Logging.e(TAG, "deliverDecodedFrame failed", e);
        }
    }

    @Override // org.webrtc.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // org.webrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
        this.callback = callback;
        if (this.sharedContext != null) {
            this.surfaceTextureHelper = createSurfaceTextureHelper();
            this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
            this.surfaceTextureHelper.startListening(this);
        }
        return initDecodeInternal(settings.width, settings.height);
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        long j;
        Integer num;
        synchronized (this.renderedTextureMetadataLock) {
            DecodedTextureMetadata decodedTextureMetadata = this.renderedTextureMetadata;
            if (decodedTextureMetadata == null) {
                throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
            }
            j = decodedTextureMetadata.presentationTimestampUs * 1000;
            num = decodedTextureMetadata.decodeTimeMs;
            this.renderedTextureMetadata = null;
        }
        this.callback.onDecodedFrame(new VideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), j), num, null);
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus release() {
        Logging.d(TAG, "release");
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        if (this.surface != null) {
            releaseSurface();
            this.surface = null;
            this.surfaceTextureHelper.stopListening();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        synchronized (this.renderedTextureMetadataLock) {
            this.renderedTextureMetadata = null;
        }
        this.callback = null;
        this.frameInfos.clear();
        return videoCodecStatusReleaseInternal;
    }

    public void releaseSurface() {
        this.surface.release();
    }
}
