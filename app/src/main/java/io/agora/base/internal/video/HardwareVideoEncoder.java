package io.agora.base.internal.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase10;
import io.agora.base.internal.video.EglBase14;
import io.agora.base.internal.video.EncodedImage;
import io.agora.base.internal.video.VideoEncoder;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

@TargetApi(19)
/* loaded from: classes4.dex */
public class HardwareVideoEncoder implements VideoEncoder {
    private static final int DEFAULT_HEIGHT_ALIGNMENT = 4;
    private static final int DEFAULT_WIDTH_ALIGNMENT = 16;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int INT_INTERVAL_UPPER_LIMIT = 100;
    private static final int INT_SETTING_INTERVAL_VALUE = 10;
    private static final String KEY_AV_ENC_VIDEO_FORCE_ALIGNMENT = "av_enc_video_force_alignment";
    private static final String KEY_AV_ENC_VIDEO_HEIGHT_ALIGNMENT = "av_enc_video_height_alignment";
    private static final String KEY_AV_ENC_VIDEO_WIDTH_ALIGNMENT = "av_enc_video_width_alignment";
    private static final String KEY_BITRATE_MODE = "bitrate-mode";
    private static final int MAX_ENCODER_Q_SIZE = 5;
    private static final int MAX_ENCODER_Q_WAIT_TIMEOUT_MS = 2000;
    private static final int MAX_ENCODE_TIME_MS = 2000;
    private static final int MAX_VIDEO_FRAMERATE = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private static final int VIDEO_AVC_LEVEL_3_1 = 512;
    private static final int VIDEO_AVC_PROFILE_HIGH = 8;
    private static final int VIDEO_ControlQualityConstant = 0;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateVariable = 1;
    private static final int VIDEO_HEVC_MAINLEVEL_31 = 256;
    private static final int VIDEO_HEVC_PROFILE_MAIN = 1;
    private static final int kMaxVuiSpsIncrease = 64;

    @VisibleForTesting
    private static boolean mockEncoderQueueFull = false;
    private int adjustedBitrate;
    private int alignedHeight;
    private int alignedWidth;
    private boolean automaticResizeOn;
    private final BitrateAdjuster bitrateAdjuster;
    private int bitrateMode;
    private VideoEncoder.Callback callback;

    @Nullable
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecType codecType;

    @Nullable
    private String customConfigJson;
    private boolean deliveredVideoFrame;

    @Nullable
    private VideoEncoder.EncoderStyle encoderStyle;
    private final long forcedKeyFrameNs;
    private int height;
    private int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

    @Nullable
    private Thread outputThread;
    private final Map<String, String> params;

    @Nullable
    private Handler proxyThreadHandler;

    @Nullable
    private EglBase.Context sharedContext;
    private boolean shouldFallbackSoftware;
    private boolean shouldResetCodec;
    private boolean shouldUseBaseline;
    private final Integer surfaceColorFormat;

    @Nullable
    private EglBase textureEglBase;

    @Nullable
    private Surface textureInputSurface;
    private boolean useSurfaceMode;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private static final Object lock = new Object();
    private static final String[] H264_HW_EXCEPTION_MODELS = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    private static final String[] INTERVAL_HW_EXCEPTION_MODELS = {"vivo X21A", "MI 8", "MI 6", "MI 8 Lite", "Redmi Note 7"};
    private int maxSupportedWidth = 32768;
    private int maxSupportedHeight = 32768;
    private int minSupportedWidth = 2;
    private int minSupportedHeight = 2;
    private int maxSupportedBitrate = 0;
    private int minSupportedBitrate = 0;
    private int widthAlignment = 16;
    private int heightAlignment = 4;
    private boolean forceAlignment = true;
    private final GlRectDrawer textureDrawer = new GlRectDrawer();
    private final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
    private final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();
    private final Queue<TimeStamps> encodeTimeStamps = new ConcurrentLinkedQueue();

    @Nullable
    private ByteBuffer configBuffer = null;
    private volatile boolean running = false;

    @Nullable
    private volatile Exception shutdownException = null;
    private Map<Long, CodecSpecificInfo> codecSpecificInfoMap = new HashMap();
    private long firstEncoderQueueFullMs = -1;

    public static class TimeStamps {
        private final long encodecStartTimeMs;
        private final long presentationTimeStampUs;

        public TimeStamps(long j, long j2) {
            this.encodecStartTimeMs = j;
            this.presentationTimeStampUs = j2;
        }
    }

    public enum YuvFormat {
        I420 { // from class: io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat.1
            @Override // io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, int i, int i2, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                int i3 = (i + 1) / 2;
                int i4 = i * i2;
                int i5 = ((i2 + 1) / 2) * i3;
                int i6 = (i5 * 2) + i4;
                if (byteBuffer.capacity() < i6) {
                    throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i6 + " was " + byteBuffer.capacity());
                }
                byteBuffer.position(0);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBuffer.position(i4);
                ByteBuffer byteBufferSlice2 = byteBuffer.slice();
                byteBuffer.position(i5 + i4);
                YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBufferSlice, i, byteBufferSlice2, i3, byteBuffer.slice(), i3, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        },
        NV12 { // from class: io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat.2
            @Override // io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, int i, int i2, VideoFrame.Buffer buffer) {
                YuvFormat.fillNV12Buffer(byteBuffer, i, i2, buffer, false);
            }
        },
        NV21 { // from class: io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat.3
            @Override // io.agora.base.internal.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer byteBuffer, int i, int i2, VideoFrame.Buffer buffer) {
                YuvFormat.fillNV12Buffer(byteBuffer, i, i2, buffer, true);
            }
        };

        public static void fillNV12Buffer(ByteBuffer byteBuffer, int i, int i2, VideoFrame.Buffer buffer, boolean z) {
            VideoFrame.I420Buffer i420 = buffer.toI420();
            int i3 = (i + 1) / 2;
            int i4 = i * i2;
            int i5 = (((i2 + 1) / 2) * i3 * 2) + i4;
            if (byteBuffer.capacity() < i5) {
                throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i5 + " was " + byteBuffer.capacity());
            }
            byteBuffer.position(0);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBuffer.position(i4);
            YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), z ? i420.getDataV() : i420.getDataU(), z ? i420.getStrideV() : i420.getStrideU(), z ? i420.getDataU() : i420.getDataV(), z ? i420.getStrideU() : i420.getStrideV(), byteBufferSlice, i, byteBuffer.slice(), i3 * 2, i420.getWidth(), i420.getHeight());
            i420.release();
        }

        public abstract void fillBuffer(ByteBuffer byteBuffer, int i, int i2, VideoFrame.Buffer buffer);

        public static YuvFormat valueOf(int i, boolean z) {
            if (i == 19) {
                return I420;
            }
            if (i == 21 || i == 2141391872 || i == 2141391876) {
                return z ? NV21 : NV12;
            }
            throw new IllegalArgumentException("Unsupported colorFormat: " + i);
        }
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, Integer num, Integer num2, Map<String, String> map, int i, int i2, BitrateAdjuster bitrateAdjuster, EglBase.Context context) {
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.surfaceColorFormat = num;
        this.yuvColorFormat = num2;
        this.yuvFormat = YuvFormat.valueOf(num2.intValue(), MediaCodecUtils.yuv420spPreferNV21(str));
        this.params = map;
        this.keyFrameIntervalSec = i;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(i2);
        this.bitrateAdjuster = bitrateAdjuster;
        this.sharedContext = context;
    }

    private boolean canUseSurface(EglBase.Context context) {
        return (context == null || this.surfaceColorFormat == null) ? false : true;
    }

    private Thread createOutputThread() {
        return new Thread() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
            }
        };
    }

    private VideoCodecStatus encodeByteBuffer(final VideoFrame videoFrame, final VideoFrame.Buffer buffer, final int i, final CodecSpecificInfo codecSpecificInfo) {
        if (this.proxyThreadHandler == null) {
            return VideoCodecStatus.ERROR;
        }
        if (!this.running) {
            Logging.e(TAG, "encodeByteBuffer fail, encoder is not initialized!");
            return VideoCodecStatus.ERROR;
        }
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    long timestampNs = (videoFrame.getTimestampNs() + 500) / 1000;
                    try {
                        int iDequeueInputBuffer = HardwareVideoEncoder.this.codec.dequeueInputBuffer(0L);
                        if (iDequeueInputBuffer == -1) {
                            Logging.d(HardwareVideoEncoder.TAG, "Dropped frame, no input buffers available");
                            return VideoCodecStatus.NO_OUTPUT;
                        }
                        try {
                            HardwareVideoEncoder.this.fillInputBuffer(HardwareVideoEncoder.this.codec.getInputBuffers()[iDequeueInputBuffer], buffer);
                            TimeStamps timeStamps = new TimeStamps(SystemClock.elapsedRealtime(), timestampNs);
                            try {
                                if (codecSpecificInfo != null) {
                                    HardwareVideoEncoder.this.codecSpecificInfoMap.put(Long.valueOf(timestampNs), codecSpecificInfo);
                                }
                                HardwareVideoEncoder.this.codec.queueInputBuffer(iDequeueInputBuffer, 0, i, timestampNs, 0);
                                HardwareVideoEncoder.this.encodeTimeStamps.add(timeStamps);
                                return VideoCodecStatus.OK;
                            } catch (RuntimeException e) {
                                Logging.e(HardwareVideoEncoder.TAG, "queueInputBuffer failed", e);
                                HardwareVideoEncoder.this.codecSpecificInfoMap.remove(Long.valueOf(timestampNs));
                                HardwareVideoEncoder.this.encodeTimeStamps.remove(timeStamps);
                                return !HardwareVideoEncoder.this.deliveredVideoFrame ? VideoCodecStatus.FALLBACK_SOFTWARE : MediaCodecUtils.isMediaCodecException(e);
                            }
                        } catch (IllegalStateException e2) {
                            Logging.e(HardwareVideoEncoder.TAG, "getInputBuffers failed", e2);
                            return !HardwareVideoEncoder.this.deliveredVideoFrame ? VideoCodecStatus.FALLBACK_SOFTWARE : MediaCodecUtils.isMediaCodecException(e2);
                        }
                    } catch (IllegalStateException e3) {
                        Logging.e(HardwareVideoEncoder.TAG, "dequeueInputBuffer failed", e3);
                        return !HardwareVideoEncoder.this.deliveredVideoFrame ? VideoCodecStatus.FALLBACK_SOFTWARE : MediaCodecUtils.isMediaCodecException(e3);
                    }
                }
            });
            return videoCodecStatus != null ? videoCodecStatus : VideoCodecStatus.FALLBACK_SOFTWARE;
        } catch (Exception unused) {
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus encodeTextureBuffer(final VideoFrame videoFrame, final CodecSpecificInfo codecSpecificInfo) {
        if (this.proxyThreadHandler == null) {
            return VideoCodecStatus.ERROR;
        }
        if (!this.running) {
            Logging.e(TAG, "encodeTextureBuffer fail, encoder is not initialized!");
            return VideoCodecStatus.ERROR;
        }
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    long timestampNs = (videoFrame.getTimestampNs() + 500) / 1000;
                    TimeStamps timeStamps = new TimeStamps(SystemClock.elapsedRealtime(), timestampNs);
                    HardwareVideoEncoder.this.encodeTimeStamps.add(timeStamps);
                    try {
                        if (codecSpecificInfo != null) {
                            HardwareVideoEncoder.this.codecSpecificInfoMap.put(Long.valueOf(timestampNs), codecSpecificInfo);
                        }
                        GLES20.glClear(16384);
                        HardwareVideoEncoder.this.videoFrameDrawer.drawFrame(new VideoFrame(videoFrame.getBuffer(), 0, videoFrame.getTimestampNs()), HardwareVideoEncoder.this.textureDrawer, null);
                        HardwareVideoEncoder.this.textureEglBase.swapBuffers(videoFrame.getTimestampNs());
                        return VideoCodecStatus.OK;
                    } catch (RuntimeException e) {
                        Logging.e(HardwareVideoEncoder.TAG, "encodeTexture failed", e);
                        HardwareVideoEncoder.this.codecSpecificInfoMap.remove(Long.valueOf(timestampNs));
                        HardwareVideoEncoder.this.encodeTimeStamps.remove(timeStamps);
                        return VideoCodecStatus.ERROR;
                    }
                }
            });
            return videoCodecStatus != null ? videoCodecStatus : VideoCodecStatus.ERROR;
        } catch (Exception unused) {
            return VideoCodecStatus.ERROR;
        }
    }

    private VideoCodecStatus initEncodeInternal() throws JSONException {
        if (this.outputThread != null) {
            Logging.e(TAG, "initEncodeInternal called while the codec is already running");
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        if (this.proxyThreadHandler == null) {
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.lastKeyFrameNs = -1L;
        this.firstEncoderQueueFullMs = -1L;
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    VideoCodecStatus videoCodecStatus2 = VideoCodecStatus.OK;
                    try {
                        HardwareVideoEncoder hardwareVideoEncoder = HardwareVideoEncoder.this;
                        hardwareVideoEncoder.codec = hardwareVideoEncoder.mediaCodecWrapperFactory.createByCodecName(HardwareVideoEncoder.this.codecName);
                        return videoCodecStatus2;
                    } catch (Exception unused) {
                        Logging.e(HardwareVideoEncoder.TAG, "Cannot create media encoder " + HardwareVideoEncoder.this.codecName);
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
            resolutionAlignmentChecker();
            if (Build.VERSION.SDK_INT >= 21) {
                int i = this.alignedHeight;
                int i2 = this.alignedWidth;
                if (i * i2 > this.maxSupportedHeight * this.maxSupportedWidth || Math.max(i2, i) > Math.max(this.maxSupportedHeight, this.maxSupportedWidth)) {
                    Logging.w(TAG, "initEncode: Not supported size " + this.alignedHeight + "x" + this.alignedWidth);
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
                int i3 = this.alignedHeight;
                int i4 = this.alignedWidth;
                if (i3 * i4 < this.minSupportedHeight * this.minSupportedWidth || Math.min(i4, i3) < Math.min(this.minSupportedHeight, this.minSupportedWidth)) {
                    Logging.w(TAG, "initEncode: Not supported size " + this.alignedHeight + "x" + this.alignedWidth);
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            }
            int iIntValue = (this.useSurfaceMode ? this.surfaceColorFormat : this.yuvColorFormat).intValue();
            final MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), this.alignedWidth, this.alignedHeight);
            mediaFormatCreateVideoFormat.setInteger("bitrate", this.adjustedBitrate);
            mediaFormatCreateVideoFormat.setInteger(KEY_BITRATE_MODE, this.bitrateMode);
            mediaFormatCreateVideoFormat.setInteger("color-format", iIntValue);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", this.bitrateAdjuster.getCodecConfigFramerate());
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", this.keyFrameIntervalSec);
            VideoCodecType videoCodecType = this.codecType;
            final String str = "";
            if (videoCodecType == VideoCodecType.H264) {
                String str2 = this.params.get("profile-level-id");
                String str3 = this.params.get(VideoCodecInfo.H264_IS_HIGH_PROFILE_SUPPORTED);
                if (str2 != null) {
                    Logging.d(TAG, "h264_profile:" + str2);
                }
                if (str3 != null) {
                    Logging.d(TAG, "is-highprofile-supported:" + str3);
                }
                if (str2 != null && str3 != null && !str3.equals("false") && !this.shouldUseBaseline) {
                    str = str2;
                }
                if ("640c1f".equals(str)) {
                    mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 8);
                    mediaFormatCreateVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, 512);
                } else if (VideoCodecInfo.H264_CONSTRAINED_MAIN_3_1.equals(str)) {
                    mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 2);
                } else if ("42e01f".equals(str)) {
                    mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 1);
                } else {
                    Logging.w(TAG, "Unknown profile level id: " + str);
                }
            } else if (videoCodecType == VideoCodecType.H265) {
                mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 1);
                mediaFormatCreateVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, 256);
                mediaFormatCreateVideoFormat.setInteger(KEY_BITRATE_MODE, 1);
            }
            String str4 = this.params.get(VideoCodecInfo.KEY_AV_ENC_VIDEO_HWENC_CONFIG);
            this.customConfigJson = str4;
            MediaCodecUtils.applyCustomConfig(mediaFormatCreateVideoFormat, str4);
            Logging.w(TAG, "Format: " + mediaFormatCreateVideoFormat);
            try {
                VideoCodecStatus videoCodecStatus3 = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public VideoCodecStatus call() throws Exception {
                        try {
                            HardwareVideoEncoder.this.codec.configure(mediaFormatCreateVideoFormat, null, null, 1);
                            if (HardwareVideoEncoder.this.useSurfaceMode) {
                                if (HardwareVideoEncoder.this.sharedContext instanceof EglBase10.Context) {
                                    Logging.w(HardwareVideoEncoder.TAG, "Encoders will use EglBase10");
                                    HardwareVideoEncoder.this.textureEglBase = new EglBase10((EglBase10.Context) HardwareVideoEncoder.this.sharedContext, EglBase.CONFIG_RECORDABLE);
                                } else {
                                    Logging.w(HardwareVideoEncoder.TAG, "Encoders will use EglBase14");
                                    HardwareVideoEncoder.this.textureEglBase = new EglBase14((EglBase14.Context) HardwareVideoEncoder.this.sharedContext, EglBase.CONFIG_RECORDABLE);
                                }
                                HardwareVideoEncoder hardwareVideoEncoder = HardwareVideoEncoder.this;
                                hardwareVideoEncoder.textureInputSurface = hardwareVideoEncoder.codec.createInputSurface();
                                HardwareVideoEncoder.this.textureEglBase.createSurface(HardwareVideoEncoder.this.textureInputSurface);
                                HardwareVideoEncoder.this.textureEglBase.makeCurrent();
                            }
                            HardwareVideoEncoder.this.codec.start();
                            return VideoCodecStatus.OK;
                        } catch (Throwable th) {
                            Logging.e(HardwareVideoEncoder.TAG, "initEncodeInternal failed. " + th.getMessage());
                            HardwareVideoEncoder.this.release();
                            return ((th instanceof RuntimeException) && !TextUtils.isEmpty(str) && MediaCodecUtils.isMediaCodecException(th) == VideoCodecStatus.ERROR) ? VideoCodecStatus.FALLBACK_DEFAULT_PROFILE : VideoCodecStatus.FALLBACK_SOFTWARE;
                        }
                    }
                });
                if (videoCodecStatus3 == null) {
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
                if (videoCodecStatus3 != videoCodecStatus2) {
                    return videoCodecStatus3;
                }
                this.running = true;
                Thread threadCreateOutputThread = createOutputThread();
                this.outputThread = threadCreateOutputThread;
                threadCreateOutputThread.start();
                return videoCodecStatus3;
            } catch (Exception unused) {
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (Exception unused2) {
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    public static boolean objectsEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private int parseAdjustmentTypeFromParam() {
        int i;
        try {
            String str = this.params.get(VideoCodecInfo.KEY_AV_DEC_VIDEO_BITRATE_ADJUSTMENT_TYPE);
            if (str == null || (i = Integer.parseInt(str)) < 0 || i > 3) {
                return -1;
            }
            Logging.d(TAG, "parse from param, bitrate adjustment type: " + str);
            return i;
        } catch (Exception unused) {
            Logging.d(TAG, "fail to convert adjustmentType.");
            return -1;
        }
    }

    private boolean parseAlignmentFromParam() {
        try {
            String str = this.params.get(KEY_AV_ENC_VIDEO_WIDTH_ALIGNMENT);
            String str2 = this.params.get(KEY_AV_ENC_VIDEO_HEIGHT_ALIGNMENT);
            String str3 = this.params.get(KEY_AV_ENC_VIDEO_FORCE_ALIGNMENT);
            if (str != null) {
                this.widthAlignment = Integer.parseInt(str);
            }
            if (str2 != null) {
                this.heightAlignment = Integer.parseInt(str2);
            }
            if (str3 != null) {
                this.forceAlignment = Boolean.parseBoolean(str3);
            }
            return (str == null || str2 == null) ? false : true;
        } catch (Exception unused) {
            Logging.d(TAG, "fail to convert alignment");
            return false;
        }
    }

    private void readVideoCapabilities() {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        boolean alignmentFromParam = parseAlignmentFromParam();
        if (alignmentFromParam) {
            Logging.w(TAG, "parse from param, align size: " + this.widthAlignment + "x" + this.heightAlignment + " ");
        }
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
        if (!alignmentFromParam) {
            this.widthAlignment = Math.max(videoCapabilities.getWidthAlignment(), 16);
            this.heightAlignment = Math.max(videoCapabilities.getHeightAlignment(), 4);
        }
        Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        if (supportedWidths != null) {
            this.maxSupportedWidth = ((Integer) supportedWidths.getUpper()).intValue();
            this.minSupportedWidth = ((Integer) supportedWidths.getLower()).intValue();
        }
        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        if (supportedHeights != null) {
            this.maxSupportedHeight = ((Integer) supportedHeights.getUpper()).intValue();
            this.minSupportedHeight = ((Integer) supportedHeights.getLower()).intValue();
        }
        Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
        if (bitrateRange != null) {
            this.maxSupportedBitrate = ((Integer) bitrateRange.getUpper()).intValue();
            this.minSupportedBitrate = ((Integer) bitrateRange.getLower()).intValue();
        }
        Logging.w(TAG, this.codecType.mimeType() + "  max supported size:" + this.maxSupportedWidth + "x" + this.maxSupportedHeight + " min supported size:" + this.minSupportedWidth + "x" + this.minSupportedHeight + " align size: " + this.widthAlignment + "x" + this.heightAlignment + " bitrate range: " + this.maxSupportedBitrate + " -> " + this.minSupportedBitrate);
        if (Build.VERSION.SDK_INT >= 23) {
            Logging.w(TAG, "max supported instance: " + codecInfo.getMaxSupportedInstances());
        }
    }

    private VideoCodecStatus releaseInternal() {
        if (this.proxyThreadHandler == null) {
            return VideoCodecStatus.ERROR;
        }
        if (!this.running) {
            Logging.w(TAG, "release: encoder is not running.");
            return VideoCodecStatus.NO_OUTPUT;
        }
        if (this.outputThread == null) {
            return VideoCodecStatus.NO_OUTPUT;
        }
        this.running = false;
        try {
            VideoCodecStatus videoCodecStatus = (VideoCodecStatus) ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, 5000L, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.3
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Finally extract failed */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    VideoCodecStatus videoCodecStatus2;
                    synchronized (HardwareVideoEncoder.lock) {
                        try {
                            try {
                                HardwareVideoEncoder.this.codec.stop();
                                HardwareVideoEncoder.this.codec.release();
                                HardwareVideoEncoder.this.textureDrawer.release();
                                HardwareVideoEncoder.this.videoFrameDrawer.release();
                                if (HardwareVideoEncoder.this.textureEglBase != null) {
                                    HardwareVideoEncoder.this.textureEglBase.release();
                                    HardwareVideoEncoder.this.textureEglBase = null;
                                }
                                if (HardwareVideoEncoder.this.textureInputSurface != null) {
                                    HardwareVideoEncoder.this.textureInputSurface.release();
                                    HardwareVideoEncoder.this.textureInputSurface = null;
                                }
                                HardwareVideoEncoder.this.codec = null;
                                HardwareVideoEncoder.this.outputThread = null;
                                HardwareVideoEncoder.this.configBuffer = null;
                                videoCodecStatus2 = VideoCodecStatus.OK;
                            } catch (Throwable th) {
                                HardwareVideoEncoder.this.textureDrawer.release();
                                HardwareVideoEncoder.this.videoFrameDrawer.release();
                                if (HardwareVideoEncoder.this.textureEglBase != null) {
                                    HardwareVideoEncoder.this.textureEglBase.release();
                                    HardwareVideoEncoder.this.textureEglBase = null;
                                }
                                if (HardwareVideoEncoder.this.textureInputSurface != null) {
                                    HardwareVideoEncoder.this.textureInputSurface.release();
                                    HardwareVideoEncoder.this.textureInputSurface = null;
                                }
                                HardwareVideoEncoder.this.codec = null;
                                HardwareVideoEncoder.this.outputThread = null;
                                HardwareVideoEncoder.this.configBuffer = null;
                                throw th;
                            }
                        } catch (Exception e) {
                            Logging.e(HardwareVideoEncoder.TAG, "Media encoder release failed", e);
                            VideoCodecStatus videoCodecStatus3 = VideoCodecStatus.ERROR;
                            HardwareVideoEncoder.this.textureDrawer.release();
                            HardwareVideoEncoder.this.videoFrameDrawer.release();
                            if (HardwareVideoEncoder.this.textureEglBase != null) {
                                HardwareVideoEncoder.this.textureEglBase.release();
                                HardwareVideoEncoder.this.textureEglBase = null;
                            }
                            if (HardwareVideoEncoder.this.textureInputSurface != null) {
                                HardwareVideoEncoder.this.textureInputSurface.release();
                                HardwareVideoEncoder.this.textureInputSurface = null;
                            }
                            HardwareVideoEncoder.this.codec = null;
                            HardwareVideoEncoder.this.outputThread = null;
                            HardwareVideoEncoder.this.configBuffer = null;
                            return videoCodecStatus3;
                        }
                    }
                    return videoCodecStatus2;
                }
            });
            return videoCodecStatus != null ? videoCodecStatus : VideoCodecStatus.ERROR;
        } catch (Exception unused) {
            return VideoCodecStatus.ERROR;
        }
    }

    private void requestKeyFrame(final long j) {
        if (this.proxyThreadHandler == null) {
            return;
        }
        if (!this.running) {
            Logging.e(TAG, "requestKeyFrame fail, encoder is not initialized!");
            return;
        }
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.proxyThreadHandler, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new Callable<VideoCodecStatus>() { // from class: io.agora.base.internal.video.HardwareVideoEncoder.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoCodecStatus call() throws Exception {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("request-sync", 0);
                        HardwareVideoEncoder.this.codec.setParameters(bundle);
                        HardwareVideoEncoder.this.lastKeyFrameNs = j;
                        return VideoCodecStatus.OK;
                    } catch (IllegalStateException e) {
                        Logging.e(HardwareVideoEncoder.TAG, "requestKeyFrame failed", e);
                        return VideoCodecStatus.ERROR;
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, "requestKeyFrame failed", e);
        }
    }

    private VideoCodecStatus resetCodec(int i, int i2, boolean z, boolean z2, EglBase.Context context) {
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        if (videoCodecStatusReleaseInternal != VideoCodecStatus.OK) {
            return videoCodecStatusReleaseInternal;
        }
        this.width = i;
        this.height = i2;
        this.sharedContext = context;
        this.useSurfaceMode = z;
        this.shouldUseBaseline = z2;
        if (context != null) {
            Logging.d(TAG, "resetCodec. contains shared EglBase.Context. Encoders will use texture mode.");
        } else {
            Logging.w(TAG, "resetCodec. No shared EglBase.Context. Encoders will not use texture mode.");
        }
        return initEncodeInternal();
    }

    private void resolutionAlignmentChecker() {
        if (this.useSurfaceMode) {
            if (!this.forceAlignment) {
                return;
            } else {
                Logging.w(TAG, "force resolution alignment in surface mode");
            }
        }
        int i = this.width;
        int i2 = this.widthAlignment;
        this.alignedWidth = (((i + i2) - 1) / i2) * i2;
        int i3 = this.height;
        int i4 = this.heightAlignment;
        this.alignedHeight = (((i3 + i4) - 1) / i4) * i4;
        Logging.v(TAG, "resolutionAlignmentChecker, alignedWidth : " + this.alignedWidth + ", alignedHeight: " + this.alignedHeight);
    }

    @VisibleForTesting
    public static void setMockEncoderQueueFull(boolean z) {
        mockEncoderQueueFull = z;
    }

    private boolean shouldForceKeyFrame(long j) {
        long j2 = this.forcedKeyFrameNs;
        return j2 > 0 && j > this.lastKeyFrameNs + j2;
    }

    private VideoCodecStatus updateBitrate() {
        if (!this.running) {
            Logging.e(TAG, "update bitrate fail, encoder is not initialized!");
            return VideoCodecStatus.NO_OUTPUT;
        }
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.adjustedBitrate);
            this.codec.setParameters(bundle);
            return VideoCodecStatus.OK;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "updateBitrate failed", e);
            return MediaCodecUtils.isMediaCodecException(e);
        }
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus attachProxyThread() {
        if (this.proxyThreadHandler == null) {
            HandlerThread handlerThread = new HandlerThread("proxyThread-Encoder");
            handlerThread.start();
            this.proxyThreadHandler = new Handler(handlerThread.getLooper());
        }
        return VideoCodecStatus.OK;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public long createNativeVideoEncoder() {
        return 0L;
    }

    public void deliverEncodedImage() {
        MediaCodec.BufferInfo bufferInfo;
        int iDequeueOutputBuffer;
        ByteBuffer byteBufferSlice;
        VideoCodecType videoCodecType;
        synchronized (lock) {
            if (!this.running) {
                Logging.e(TAG, "deliverEncodedImage fail, encoder is not initialized!");
                return;
            }
            try {
                bufferInfo = new MediaCodec.BufferInfo();
                iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
            } catch (IllegalStateException e) {
                Logging.e(TAG, "deliverOutput failed", e);
                if (this.deliveredVideoFrame && MediaCodecUtils.isMediaCodecException(e) == VideoCodecStatus.ERROR) {
                    this.shouldResetCodec = true;
                } else {
                    this.shouldFallbackSoftware = true;
                }
            } catch (Exception e2) {
                this.shouldFallbackSoftware = true;
                Logging.e(TAG, "deliverOutput error", e2);
            }
            if (iDequeueOutputBuffer < 0) {
                return;
            }
            ByteBuffer byteBuffer = this.codec.getOutputBuffers()[iDequeueOutputBuffer];
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            if ((bufferInfo.flags & 2) != 0) {
                Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                this.configBuffer = byteBufferAllocateDirect;
                byteBufferAllocateDirect.put(byteBuffer);
            } else {
                this.bitrateAdjuster.reportEncodedFrame(bufferInfo.size);
                if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps()) {
                    updateBitrate();
                }
                boolean z = (bufferInfo.flags & 1) != 0;
                if (z) {
                    Logging.d(TAG, "Sync frame generated");
                }
                if (z && ((videoCodecType = this.codecType) == VideoCodecType.H264 || videoCodecType == VideoCodecType.H265)) {
                    Logging.d(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                    byteBufferSlice = ByteBuffer.allocateDirect(bufferInfo.size + this.configBuffer.capacity());
                    this.configBuffer.rewind();
                    byteBufferSlice.put(this.configBuffer);
                    byteBufferSlice.put(byteBuffer);
                    byteBufferSlice.flip();
                } else {
                    byteBufferSlice = byteBuffer.slice();
                }
                EncodedImage.FrameType frameType = z ? EncodedImage.FrameType.VideoFrameKey : EncodedImage.FrameType.VideoFrameDelta;
                EncodedImage.Builder builderPoll = this.outputBuilders.poll();
                builderPoll.setBuffer(byteBufferSlice).setFrameType(frameType);
                CodecSpecificInfo codecSpecificInfoRemove = this.codecSpecificInfoMap.remove(Long.valueOf(bufferInfo.presentationTimeUs));
                if (codecSpecificInfoRemove == null) {
                    codecSpecificInfoRemove = new CodecSpecificInfo();
                } else {
                    Logging.d(TAG, "pass codecSpecificInfo info");
                }
                TimeStamps timeStampsPoll = null;
                int size = this.encodeTimeStamps.size();
                while (!this.encodeTimeStamps.isEmpty() && (timeStampsPoll = this.encodeTimeStamps.poll()) != null && timeStampsPoll.presentationTimeStampUs != bufferInfo.presentationTimeUs) {
                    Logging.d(TAG, "HW encodeTimeStamps. cannot find: " + timeStampsPoll.presentationTimeStampUs + "  presentationTimeUs: " + bufferInfo.presentationTimeUs);
                }
                int iElapsedRealtime = -1;
                if (timeStampsPoll == null) {
                    Logging.e(TAG, "HW encodeTimeStamps empty. cannot find: " + bufferInfo.presentationTimeUs);
                } else {
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - timeStampsPoll.encodecStartTimeMs);
                    if (iElapsedRealtime > 2000) {
                        Logging.w(TAG, "Very high encode time: " + iElapsedRealtime + "ms.");
                        iElapsedRealtime = 2000;
                    }
                }
                this.callback.onEncodedFrame(builderPoll.createEncodedImage(), iElapsedRealtime, size, codecSpecificInfoRemove);
            }
            this.codec.releaseOutputBuffer(iDequeueOutputBuffer, false);
            this.deliveredVideoFrame = true;
        }
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus detachProxyThread() {
        Handler handler = this.proxyThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.proxyThreadHandler.getLooper().quitSafely();
            this.proxyThreadHandler = null;
        }
        return VideoCodecStatus.OK;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo, CodecSpecificInfo codecSpecificInfo) {
        VideoCodecStatus videoCodecStatusResetCodec;
        if (this.codec == null || this.callback == null || this.proxyThreadHandler == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("encode uninitalized, codec: ");
            sb.append(this.codec != null);
            sb.append(", callback: ");
            sb.append(this.callback);
            Logging.d(TAG, sb.toString());
            return VideoCodecStatus.UNINITIALIZED;
        }
        if (videoFrame.getBuffer() == null) {
            Logging.e(TAG, "encode() - no input data");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        boolean z = buffer instanceof VideoFrame.TextureBuffer;
        EglBase.Context eglBaseContext = z ? ((VideoFrame.TextureBuffer) buffer).getEglBaseContext() : null;
        int width = videoFrame.getBuffer().getWidth();
        int height = videoFrame.getBuffer().getHeight();
        boolean z2 = z && canUseSurface(eglBaseContext);
        boolean z3 = !objectsEquals(this.sharedContext, eglBaseContext);
        boolean zShouldUseBaseline = VideoEncoderWrapper.shouldUseBaseline();
        if ((width != this.width || height != this.height || z2 != this.useSurfaceMode || z3 || this.shouldUseBaseline != zShouldUseBaseline || this.shouldResetCodec) && (videoCodecStatusResetCodec = resetCodec(width, height, z2, zShouldUseBaseline, eglBaseContext)) != VideoCodecStatus.OK) {
            return videoCodecStatusResetCodec;
        }
        if (this.shouldFallbackSoftware) {
            release();
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        if (this.outputBuilders.size() > 5 || mockEncoderQueueFull) {
            Logging.e(TAG, "Dropped frame, encoder queue full");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.firstEncoderQueueFullMs < 0) {
                this.firstEncoderQueueFullMs = jCurrentTimeMillis;
            }
            if (jCurrentTimeMillis - this.firstEncoderQueueFullMs <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                return VideoCodecStatus.NO_OUTPUT;
            }
            Logging.e(TAG, "Fallback to software, encoder queue full");
            release();
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.firstEncoderQueueFullMs = -1L;
        EncodedImage.FrameType[] frameTypeArr = encodeInfo.frameTypes;
        int length = frameTypeArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (frameTypeArr[i] == EncodedImage.FrameType.VideoFrameKey) {
                z = true;
                break;
            }
            i++;
        }
        boolean zShouldForceKeyFrame = shouldForceKeyFrame(videoFrame.getTimestampNs());
        if (z || zShouldForceKeyFrame) {
            Logging.d(TAG, "request KeyFrame: " + z + ". shouldForce KeyFrame: " + zShouldForceKeyFrame);
            requestKeyFrame(videoFrame.getTimestampNs());
        }
        int i2 = ((this.alignedWidth * this.alignedHeight) * 3) / 2;
        this.outputBuilders.offer(EncodedImage.builder().setCaptureTimeNs(videoFrame.getTimestampNs()).setCompleteFrame(true).setEncodedWidth(this.width).setEncodedHeight(this.height).setRotation(videoFrame.getRotation()));
        VideoCodecStatus videoCodecStatusEncodeTextureBuffer = this.useSurfaceMode ? encodeTextureBuffer(videoFrame, codecSpecificInfo) : encodeByteBuffer(videoFrame, buffer, i2, codecSpecificInfo);
        if (videoCodecStatusEncodeTextureBuffer != VideoCodecStatus.OK) {
            this.outputBuilders.pollLast();
        }
        return videoCodecStatusEncodeTextureBuffer;
    }

    public void fillInputBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
        this.yuvFormat.fillBuffer(byteBuffer, this.alignedWidth, this.alignedHeight, buffer);
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    @Nullable
    @SuppressLint({"DefaultLocale"})
    public VideoEncoder.EncoderStyle getEncoderStyle() {
        VideoEncoder.EncoderStyle encoderStyle = this.encoderStyle;
        if (encoderStyle != null) {
            return encoderStyle;
        }
        this.encoderStyle = BitrateAdjusterHelper.getEncoderStyle(this.codecName);
        int adjustmentTypeFromParam = parseAdjustmentTypeFromParam();
        if (adjustmentTypeFromParam >= 0) {
            this.encoderStyle.bitrateAdjustment = adjustmentTypeFromParam;
        }
        Logging.d(TAG, "encoderStyle: " + this.encoderStyle);
        BitrateAdjuster bitrateAdjuster = this.bitrateAdjuster;
        if (bitrateAdjuster instanceof FactorBitrateAdjuster) {
            VideoEncoder.EncoderStyle encoderStyle2 = this.encoderStyle;
            encoderStyle2.bitrateAdjustNumerator = FactorBitrateAdjuster.FACTOR_LEVEL1;
            encoderStyle2.bitrateAdjustDenominator = 1000;
        }
        return this.encoderStyle;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public String getImplementationName() {
        return "HWEncoder";
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public long getResetCoolDownTimeMs() {
        return ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
        if (this.automaticResizeOn) {
            VideoCodecType videoCodecType = this.codecType;
            if (videoCodecType == VideoCodecType.VP8) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (videoCodecType == VideoCodecType.H264) {
                return new VideoEncoder.ScalingSettings(28, 35);
            }
        }
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        int i;
        if (this.running) {
            Logging.w(TAG, "already initialized!");
            return VideoCodecStatus.OK;
        }
        this.callback = callback;
        this.automaticResizeOn = settings.automaticResizeOn;
        int i2 = settings.width;
        this.width = i2;
        int i3 = settings.height;
        this.height = i3;
        this.alignedWidth = i2;
        this.alignedHeight = i3;
        this.encodeTimeStamps.clear();
        int i4 = settings.rateControlMode;
        if (i4 >= 0) {
            this.bitrateMode = i4;
        } else {
            this.bitrateMode = 1;
        }
        this.useSurfaceMode = canUseSurface(this.sharedContext);
        this.shouldUseBaseline = VideoEncoderWrapper.shouldUseBaseline();
        this.shouldFallbackSoftware = false;
        this.shouldResetCodec = false;
        this.deliveredVideoFrame = false;
        int i5 = settings.startBitrate;
        if (i5 != 0 && (i = settings.maxFramerate) != 0) {
            this.bitrateAdjuster.setTargets(i5 * 1000, i);
        }
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        int i6 = settings.keyFrameInterval;
        if (i6 != 0 && settings.maxFramerate != 0) {
            this.keyFrameIntervalSec = i6;
        }
        List listAsList = Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
        String str = Build.MODEL;
        if (listAsList.contains(str) && this.keyFrameIntervalSec >= 100) {
            Logging.d(TAG, "Model: " + str + " , need to modify interval. original keyInterval: " + this.keyFrameIntervalSec);
            this.keyFrameIntervalSec = 10;
        }
        Logging.w(TAG, "initEncode: " + this.width + " x " + this.height + ". @ " + settings.startBitrate + "kbps. Fps: " + settings.maxFramerate + " Use surface mode: " + this.useSurfaceMode + " keyFrameIntervalSec: " + this.keyFrameIntervalSec + " bitrateMode: " + this.bitrateMode);
        return initEncodeInternal();
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public boolean isHardwareEncoder() {
        return true;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public boolean isQcomHardware() {
        Logging.w(TAG, "[qualcom hardware] codecName:" + this.codecName);
        return this.codecName.startsWith("OMX.qcom") || this.codecName.startsWith("c2.qti.");
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus release() {
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        if (videoCodecStatusReleaseInternal != VideoCodecStatus.OK) {
            return videoCodecStatusReleaseInternal;
        }
        this.outputBuilders.clear();
        this.encodeTimeStamps.clear();
        this.codecSpecificInfoMap.clear();
        this.shouldFallbackSoftware = false;
        this.shouldResetCodec = false;
        this.deliveredVideoFrame = false;
        Logging.w(TAG, "Release Media encoder done");
        return videoCodecStatusReleaseInternal;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus setChannelParameters(short s, long j) {
        return VideoCodecStatus.OK;
    }

    @Override // io.agora.base.internal.video.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
        if (i > 30) {
            i = 30;
        }
        this.bitrateAdjuster.setTargets(bitrateAllocation.getSum(), i);
        return VideoCodecStatus.OK;
    }
}
