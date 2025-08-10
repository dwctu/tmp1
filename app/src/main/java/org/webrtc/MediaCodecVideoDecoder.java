package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import dc.lg4;
import dc.pg4;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;

@Deprecated
/* loaded from: classes5.dex */
public class MediaCodecVideoDecoder {
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final long MAX_DECODE_TIME_MS = 200;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors = 0;

    @Nullable
    private static EglBase eglBase = null;

    @Nullable
    private static MediaCodecVideoDecoderErrorCallback errorCallback = null;

    @Nullable
    private static MediaCodecVideoDecoder runningInstance = null;
    private static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
    private static final String supportedMediaTekH264HighProfileHwCodecPrefix = "OMX.MTK.";
    private static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
    private int colorFormat;
    private final Queue<TimeStamps> decodeStartTimeMs = new ArrayDeque();
    private final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ArrayDeque();
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    private ByteBuffer[] inputBuffers;

    @Nullable
    private MediaCodec mediaCodec;

    @Nullable
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;

    @Nullable
    private Surface surface;

    @Nullable
    private TextureListener textureListener;
    private int width;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    private static final List<Integer> supportedColorList = Arrays.asList(19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876);

    public static class DecodedOutputBuffer {
        private final long decodeTimeMs;
        private final long endDecodeTimeMs;
        private final int index;
        private final long ntpTimeStampMs;
        private final int offset;
        private final long presentationTimeStampMs;
        private final int size;
        private final long timeStampMs;

        public DecodedOutputBuffer(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.endDecodeTimeMs = j5;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getIndex() {
            return this.index;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getOffset() {
            return this.offset;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        public int getSize() {
            return this.size;
        }

        @CalledByNative("DecodedOutputBuffer")
        public long getTimestampMs() {
            return this.timeStampMs;
        }
    }

    public static class DecodedTextureBuffer {
        private final long decodeTimeMs;
        private final long frameDelayMs;
        private final long ntpTimeStampMs;
        private final long presentationTimeStampMs;
        private final long timeStampMs;
        private final VideoFrame.Buffer videoFrameBuffer;

        public DecodedTextureBuffer(VideoFrame.Buffer buffer, long j, long j2, long j3, long j4, long j5) {
            this.videoFrameBuffer = buffer;
            this.presentationTimeStampMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.frameDelayMs = j5;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getFrameDelayMs() {
            return this.frameDelayMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public long getTimeStampMs() {
            return this.timeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        public VideoFrame.Buffer getVideoFrameBuffer() {
            return this.videoFrameBuffer;
        }
    }

    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i) {
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    public static class HwDecoderFactory implements VideoDecoderFactory {
        private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

        private static VideoCodecInfo[] getSupportedHardwareCodecs() {
            ArrayList arrayList = new ArrayList();
            if (MediaCodecVideoDecoder.isVp8HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "VP8 HW Decoder supported.");
                arrayList.add(new VideoCodecInfo("VP8", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isVp9HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "VP9 HW Decoder supported.");
                arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isH264HighProfileHwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "H.264 High Profile HW Decoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
            }
            if (MediaCodecVideoDecoder.isH264HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "H.264 HW Decoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
            }
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
        }

        private static boolean isCodecSupported(VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo videoCodecInfo) {
            for (VideoCodecInfo videoCodecInfo2 : videoCodecInfoArr) {
                if (isSameCodec(videoCodecInfo2, videoCodecInfo)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isSameCodec(VideoCodecInfo videoCodecInfo, VideoCodecInfo videoCodecInfo2) {
            if (!videoCodecInfo.name.equalsIgnoreCase(videoCodecInfo2.name)) {
                return false;
            }
            if (videoCodecInfo.name.equalsIgnoreCase("H264")) {
                return H264Utils.isSameH264Profile(videoCodecInfo.params, videoCodecInfo2.params);
            }
            return true;
        }

        @Override // org.webrtc.VideoDecoderFactory
        public /* synthetic */ VideoDecoder createDecoder(String str) {
            return pg4.$default$createDecoder(this, str);
        }

        @Override // org.webrtc.VideoDecoderFactory
        @Nullable
        public VideoDecoder createDecoder(final VideoCodecInfo videoCodecInfo) {
            if (isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                Logging.d(MediaCodecVideoDecoder.TAG, "Create HW video decoder for " + videoCodecInfo.name);
                return new WrappedNativeVideoDecoder() { // from class: org.webrtc.MediaCodecVideoDecoder.HwDecoderFactory.1
                    @Override // org.webrtc.WrappedNativeVideoDecoder, org.webrtc.VideoDecoder
                    public long createNativeVideoDecoder() {
                        return MediaCodecVideoDecoder.nativeCreateDecoder(videoCodecInfo.name, MediaCodecVideoDecoder.useSurface());
                    }
                };
            }
            Logging.d(MediaCodecVideoDecoder.TAG, "No HW video decoder for codec " + videoCodecInfo.name);
            return null;
        }

        @Override // org.webrtc.VideoDecoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            return this.supportedHardwareCodecs;
        }
    }

    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i);
    }

    public class TextureListener implements VideoSink {

        @Nullable
        private DecodedOutputBuffer bufferToRender;
        private final Object newFrameLock = new Object();

        @Nullable
        private DecodedTextureBuffer renderedBuffer;
        private final SurfaceTextureHelper surfaceTextureHelper;

        public TextureListener(SurfaceTextureHelper surfaceTextureHelper) {
            this.surfaceTextureHelper = surfaceTextureHelper;
            surfaceTextureHelper.startListening(this);
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            if (this.bufferToRender == null) {
                this.bufferToRender = decodedOutputBuffer;
            } else {
                Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected addBufferToRender() called while waiting for a texture.");
                throw new IllegalStateException("Waiting for a texture.");
            }
        }

        @Nullable
        public DecodedTextureBuffer dequeueTextureBuffer(int i) {
            DecodedTextureBuffer decodedTextureBuffer;
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer == null && i > 0 && isWaitingForTexture()) {
                    try {
                        this.newFrameLock.wait(i);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                    decodedTextureBuffer = this.renderedBuffer;
                    this.renderedBuffer = null;
                } else {
                    decodedTextureBuffer = this.renderedBuffer;
                    this.renderedBuffer = null;
                }
            }
            return decodedTextureBuffer;
        }

        public boolean isWaitingForTexture() {
            boolean z;
            synchronized (this.newFrameLock) {
                z = this.bufferToRender != null;
            }
            return z;
        }

        @Override // org.webrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer != null) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected onFrame() called while already holding a texture.");
                    throw new IllegalStateException("Already holding a texture.");
                }
                VideoFrame.Buffer buffer = videoFrame.getBuffer();
                buffer.retain();
                this.renderedBuffer = new DecodedTextureBuffer(buffer, this.bufferToRender.presentationTimeStampMs, this.bufferToRender.timeStampMs, this.bufferToRender.ntpTimeStampMs, this.bufferToRender.decodeTimeMs, SystemClock.elapsedRealtime() - this.bufferToRender.endDecodeTimeMs);
                this.bufferToRender = null;
                this.newFrameLock.notifyAll();
            }
        }

        public void release() {
            this.surfaceTextureHelper.stopListening();
            synchronized (this.newFrameLock) {
                DecodedTextureBuffer decodedTextureBuffer = this.renderedBuffer;
                if (decodedTextureBuffer != null) {
                    decodedTextureBuffer.getVideoFrameBuffer().release();
                    this.renderedBuffer = null;
                }
            }
            this.surfaceTextureHelper.dispose();
        }

        public void setSize(int i, int i2) {
            this.surfaceTextureHelper.setTextureSize(i, i2);
        }
    }

    public static class TimeStamps {
        private final long decodeStartTimeMs;
        private final long ntpTimeStampMs;
        private final long timeStampMs;

        public TimeStamps(long j, long j2, long j3) {
            this.decodeStartTimeMs = j;
            this.timeStampMs = j2;
            this.ntpTimeStampMs = j3;
        }
    }

    public enum VideoCodecType {
        VIDEO_CODEC_UNKNOWN,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264;

        @CalledByNative("VideoCodecType")
        public static VideoCodecType fromNativeIndex(int i) {
            return values()[i];
        }
    }

    @CalledByNative
    public MediaCodecVideoDecoder() {
    }

    private void MaybeRenderDecodedTextureBuffer() {
        if (this.dequeuedSurfaceOutputBuffers.isEmpty() || this.textureListener.isWaitingForTexture()) {
            return;
        }
        DecodedOutputBuffer decodedOutputBufferRemove = this.dequeuedSurfaceOutputBuffers.remove();
        this.textureListener.addBufferToRender(decodedOutputBufferRemove);
        this.mediaCodec.releaseOutputBuffer(decodedOutputBufferRemove.index, true);
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    public static VideoDecoderFactory createFactory() {
        return new DefaultVideoDecoderFactory(new HwDecoderFactory());
    }

    @CalledByNativeUnchecked
    private int dequeueInputBuffer() throws IllegalStateException {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0130, code lost:
    
        throw new java.lang.RuntimeException("Unexpected size change. Configured " + r22.width + "*" + r22.height + ". New " + r8 + "*" + r7);
     */
    @androidx.annotation.Nullable
    @org.webrtc.CalledByNativeUnchecked
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.webrtc.MediaCodecVideoDecoder.DecodedOutputBuffer dequeueOutputBuffer(int r23) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.webrtc.MediaCodecVideoDecoder.dequeueOutputBuffer(int):org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer");
    }

    @Nullable
    @CalledByNativeUnchecked
    private DecodedTextureBuffer dequeueTextureBuffer(int i) throws IllegalStateException {
        checkOnMediaCodecThread();
        if (!useSurface()) {
            throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
        }
        DecodedOutputBuffer decodedOutputBufferDequeueOutputBuffer = dequeueOutputBuffer(i);
        if (decodedOutputBufferDequeueOutputBuffer != null) {
            this.dequeuedSurfaceOutputBuffers.add(decodedOutputBufferDequeueOutputBuffer);
        }
        MaybeRenderDecodedTextureBuffer();
        DecodedTextureBuffer decodedTextureBufferDequeueTextureBuffer = this.textureListener.dequeueTextureBuffer(i);
        if (decodedTextureBufferDequeueTextureBuffer != null) {
            MaybeRenderDecodedTextureBuffer();
            return decodedTextureBufferDequeueTextureBuffer;
        }
        if (this.dequeuedSurfaceOutputBuffers.size() < Math.min(3, this.outputBuffers.length) && (i <= 0 || this.dequeuedSurfaceOutputBuffers.isEmpty())) {
            return null;
        }
        this.droppedFrames++;
        DecodedOutputBuffer decodedOutputBufferRemove = this.dequeuedSurfaceOutputBuffers.remove();
        if (i > 0) {
            Logging.w(TAG, "Draining decoder. Dropping frame with TS: " + decodedOutputBufferRemove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
        } else {
            Logging.w(TAG, "Too many output buffers " + this.dequeuedSurfaceOutputBuffers.size() + ". Dropping frame with TS: " + decodedOutputBufferRemove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
        }
        this.mediaCodec.releaseOutputBuffer(decodedOutputBufferRemove.index, false);
        return new DecodedTextureBuffer(null, decodedOutputBufferRemove.presentationTimeStampMs, decodedOutputBufferRemove.timeStampMs, decodedOutputBufferRemove.ntpTimeStampMs, decodedOutputBufferRemove.decodeTimeMs, SystemClock.elapsedRealtime() - decodedOutputBufferRemove.endDecodeTimeMs);
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    public static void disposeEglContext() {
        EglBase eglBase2 = eglBase;
        if (eglBase2 != null) {
            eglBase2.release();
            eglBase = null;
        }
    }

    @Nullable
    private static DecoderProperties findDecoder(String str, String[] strArr) {
        MediaCodecInfo codecInfoAt;
        String name;
        boolean z;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        Logging.d(TAG, "Trying to find HW decoder for mime " + str);
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            try {
                codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e);
                codecInfoAt = null;
            }
            if (codecInfoAt != null && !codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        name = null;
                        break;
                    }
                    if (supportedTypes[i2].equals(str)) {
                        name = codecInfoAt.getName();
                        break;
                    }
                    i2++;
                }
                if (name == null) {
                    continue;
                } else {
                    Logging.d(TAG, "Found candidate decoder " + name);
                    int length2 = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z = false;
                            break;
                        }
                        if (name.startsWith(strArr[i3])) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (z) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                            for (int i4 : capabilitiesForType.colorFormats) {
                                Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i4));
                            }
                            Iterator<Integer> it = supportedColorList.iterator();
                            while (it.hasNext()) {
                                int iIntValue = it.next().intValue();
                                for (int i5 : capabilitiesForType.colorFormats) {
                                    if (i5 == iIntValue) {
                                        Logging.d(TAG, "Found target decoder " + name + ". Color: 0x" + Integer.toHexString(i5));
                                        return new DecoderProperties(name, i5);
                                    }
                                }
                            }
                        } catch (IllegalArgumentException e2) {
                            Logging.e(TAG, "Cannot retrieve decoder capabilities", e2);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        Logging.d(TAG, "No HW decoder found for mime " + str);
        return null;
    }

    @CalledByNativeUnchecked
    private boolean initDecode(VideoCodecType videoCodecType, int i, int i2) {
        String[] strArrSupportedH264HwCodecPrefixes;
        String str;
        SurfaceTextureHelper surfaceTextureHelperCreate;
        if (this.mediaCodecThread != null) {
            throw new RuntimeException("initDecode: Forgot to release()?");
        }
        if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
            strArrSupportedH264HwCodecPrefixes = supportedVp8HwCodecPrefixes();
            str = "video/x-vnd.on2.vp8";
        } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
            strArrSupportedH264HwCodecPrefixes = supportedVp9HwCodecPrefixes;
            str = "video/x-vnd.on2.vp9";
        } else {
            if (videoCodecType != VideoCodecType.VIDEO_CODEC_H264) {
                throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
            }
            strArrSupportedH264HwCodecPrefixes = supportedH264HwCodecPrefixes();
            str = "video/avc";
        }
        DecoderProperties decoderPropertiesFindDecoder = findDecoder(str, strArrSupportedH264HwCodecPrefixes);
        if (decoderPropertiesFindDecoder == null) {
            throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
        }
        Logging.d(TAG, "Java initDecode: " + videoCodecType + " : " + i + " x " + i2 + ". Color: 0x" + Integer.toHexString(decoderPropertiesFindDecoder.colorFormat) + ". Use Surface: " + useSurface());
        runningInstance = this;
        this.mediaCodecThread = Thread.currentThread();
        try {
            this.width = i;
            this.height = i2;
            this.stride = i;
            this.sliceHeight = i2;
            if (useSurface() && (surfaceTextureHelperCreate = SurfaceTextureHelper.create("Decoder SurfaceTextureHelper", eglBase.getEglBaseContext())) != null) {
                TextureListener textureListener = new TextureListener(surfaceTextureHelperCreate);
                this.textureListener = textureListener;
                textureListener.setSize(i, i2);
                this.surface = new Surface(surfaceTextureHelperCreate.getSurfaceTexture());
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
            if (!useSurface()) {
                mediaFormatCreateVideoFormat.setInteger("color-format", decoderPropertiesFindDecoder.colorFormat);
            }
            Logging.d(TAG, "  Format: " + mediaFormatCreateVideoFormat);
            MediaCodec mediaCodecCreateByCodecName = MediaCodecVideoEncoder.createByCodecName(decoderPropertiesFindDecoder.codecName);
            this.mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodecCreateByCodecName == null) {
                Logging.e(TAG, "Can not create media decoder");
                return false;
            }
            mediaCodecCreateByCodecName.configure(mediaFormatCreateVideoFormat, this.surface, (MediaCrypto) null, 0);
            this.mediaCodec.start();
            this.colorFormat = decoderPropertiesFindDecoder.colorFormat;
            this.outputBuffers = this.mediaCodec.getOutputBuffers();
            this.inputBuffers = this.mediaCodec.getInputBuffers();
            this.decodeStartTimeMs.clear();
            this.hasDecodedFirstFrame = false;
            this.dequeuedSurfaceOutputBuffers.clear();
            this.droppedFrames = 0;
            Logging.d(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "initDecode failed", e);
            return false;
        }
    }

    public static boolean isH264HighProfileHwSupported() {
        if (hwDecoderDisabledTypes.contains("video/avc")) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && findDecoder("video/avc", new String[]{"OMX.qcom."}) != null) {
            return true;
        }
        if (i < 23 || findDecoder("video/avc", new String[]{"OMX.Exynos."}) == null) {
            return PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED) && i >= 27 && findDecoder("video/avc", new String[]{"OMX.MTK."}) != null;
        }
        return true;
    }

    public static boolean isH264HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/avc") || findDecoder("video/avc", supportedH264HwCodecPrefixes()) == null) ? false : true;
    }

    public static boolean isVp8HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes()) == null) ? false : true;
    }

    public static boolean isVp9HwSupported() {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateDecoder(String str, boolean z);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.d(TAG, "MediaCodecVideoDecoder stacks trace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.d(TAG, stackTraceElement.toString());
            }
        }
    }

    @CalledByNativeUnchecked
    private boolean queueInputBuffer(int i, int i2, long j, long j2, long j3) throws IllegalStateException, MediaCodec.CryptoException {
        checkOnMediaCodecThread();
        try {
            this.inputBuffers[i].position(0);
            this.inputBuffers[i].limit(i2);
            this.decodeStartTimeMs.add(new TimeStamps(SystemClock.elapsedRealtime(), j2, j3));
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "decode failed", e);
            return false;
        }
    }

    @CalledByNativeUnchecked
    private void release() throws IllegalStateException {
        Logging.d(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
        checkOnMediaCodecThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: org.webrtc.MediaCodecVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                    MediaCodecVideoDecoder.this.mediaCodec.stop();
                    MediaCodecVideoDecoder.this.mediaCodec.release();
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                } catch (Exception e) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e);
                }
                countDownLatch.countDown();
            }
        }).start();
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
            Logging.e(TAG, "Media decoder release timeout");
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
            }
        }
        this.mediaCodec = null;
        this.mediaCodecThread = null;
        runningInstance = null;
        if (useSurface()) {
            this.surface.release();
            this.surface = null;
            this.textureListener.release();
        }
        Logging.d(TAG, "Java releaseDecoder done");
    }

    @CalledByNativeUnchecked
    private void reset(int i, int i2) {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
        Logging.d(TAG, "Java reset: " + i + " x " + i2);
        this.mediaCodec.flush();
        this.width = i;
        this.height = i2;
        TextureListener textureListener = this.textureListener;
        if (textureListener != null) {
            textureListener.setSize(i, i2);
        }
        this.decodeStartTimeMs.clear();
        this.dequeuedSurfaceOutputBuffers.clear();
        this.hasDecodedFirstFrame = false;
        this.droppedFrames = 0;
    }

    @CalledByNativeUnchecked
    private void returnDecodedOutputBuffer(int i) throws IllegalStateException {
        checkOnMediaCodecThread();
        if (useSurface()) {
            throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
        }
        this.mediaCodec.releaseOutputBuffer(i, false);
    }

    public static void setEglContext(EglBase.Context context) {
        if (eglBase != null) {
            Logging.w(TAG, "Egl context already set.");
            eglBase.release();
        }
        eglBase = lg4.c(context);
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    private static final String[] supportedH264HwCodecPrefixes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("OMX.qcom.");
        arrayList.add("OMX.Intel.");
        arrayList.add("OMX.Exynos.");
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED) && Build.VERSION.SDK_INT >= 27) {
            arrayList.add("OMX.MTK.");
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static final String[] supportedVp8HwCodecPrefixes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("OMX.qcom.");
        arrayList.add("OMX.Nvidia.");
        arrayList.add("OMX.Exynos.");
        arrayList.add("OMX.Intel.");
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekVP8").equals(PeerConnectionFactory.TRIAL_ENABLED) && Build.VERSION.SDK_INT >= 24) {
            arrayList.add("OMX.MTK.");
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean useSurface() {
        return eglBase != null;
    }

    @CalledByNative
    public int getColorFormat() {
        return this.colorFormat;
    }

    @CalledByNative
    public int getHeight() {
        return this.height;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        return this.inputBuffers;
    }

    @CalledByNative
    public ByteBuffer[] getOutputBuffers() {
        return this.outputBuffers;
    }

    @CalledByNative
    public int getSliceHeight() {
        return this.sliceHeight;
    }

    @CalledByNative
    public int getStride() {
        return this.stride;
    }

    @CalledByNative
    public int getWidth() {
        return this.width;
    }
}
