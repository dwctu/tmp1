package io.agora.base.internal.video;

import androidx.annotation.Nullable;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.video.EncodedImage;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public interface VideoEncoder {

    public @interface BitrateAdjustment {
        public static final int ACTUAL_FRAMERATE_ADJUSTMENT = 2;
        public static final int DYNAMIC_ADJUSTMENT = 3;
        public static final int FRAMERATE_ADJUSTMENT = 1;
        public static final int NO_ADJUSTMENT = 0;
    }

    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative("BitrateAllocation")
        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int i = 0;
            for (int[] iArr : this.bitratesBbs) {
                for (int i2 : iArr) {
                    i += i2;
                }
            }
            return i;
        }
    }

    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, int i, int i2, CodecSpecificInfo codecSpecificInfo);
    }

    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative("EncodeInfo")
        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    public static class EncoderStyle {
        public boolean highProfileSupported;
        public int bitrateAdjustment = 0;
        public boolean isNeedResetWhenDownBps = false;
        public int bitrateAdjustNumerator = 1;
        public int bitrateAdjustDenominator = 1;

        @CalledByNative("EncoderStyle")
        public int getBitrateAdjustDenominator() {
            return this.bitrateAdjustDenominator;
        }

        @CalledByNative("EncoderStyle")
        public int getBitrateAdjustNumerator() {
            return this.bitrateAdjustNumerator;
        }

        @CalledByNative("EncoderStyle")
        public int getBitrateAdjustment() {
            return this.bitrateAdjustment;
        }

        @CalledByNative("EncoderStyle")
        public boolean isNeedResetWhenDownBps() {
            return this.isNeedResetWhenDownBps;
        }

        public String toString() {
            return "EncoderStyle{bitrateAdjustment=" + this.bitrateAdjustment + ", isNeedResetWhenDownBps=" + this.isNeedResetWhenDownBps + ", highProfileSupported=" + this.highProfileSupported + MessageFormatter.DELIM_STOP;
        }
    }

    @CalledByNative
    VideoCodecStatus attachProxyThread();

    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus detachProxyThread();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo, CodecSpecificInfo codecSpecificInfo);

    @Nullable
    @CalledByNative
    EncoderStyle getEncoderStyle();

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    long getResetCoolDownTimeMs();

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    boolean isQcomHardware();

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setChannelParameters(short s, long j);

    @CalledByNative
    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i);

    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();

        @Nullable
        public final Integer high;

        @Nullable
        public final Integer low;
        public final boolean on;

        public ScalingSettings(int i, int i2) {
            this.on = true;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        public String toString() {
            if (!this.on) {
                return "OFF";
            }
            return "[ " + this.low + ", " + this.high + " ]";
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z) {
            this.on = z;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z, int i, int i2) {
            this.on = z;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }
    }

    public static class Settings {
        public final boolean automaticResizeOn;
        public final int height;
        public final int keyFrameInterval;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int rateControlMode;
        public final int startBitrate;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8) {
            this.numberOfCores = i;
            this.width = i2;
            this.height = i3;
            this.startBitrate = i4;
            this.maxFramerate = i5;
            this.numberOfSimulcastStreams = i6;
            this.automaticResizeOn = z;
            this.keyFrameInterval = i7;
            this.rateControlMode = i8;
        }

        public Settings(int i, int i2, int i3, int i4, int i5, boolean z) {
            this(i, i2, i3, i4, i5, 1, z, 0, -1);
        }
    }
}
