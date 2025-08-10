package io.agora.base.internal.video;

import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.video.VideoEncoder;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class VideoEncoderWrapper {
    @CalledByNative
    public static VideoEncoder.Callback createEncoderCallback(final long j) {
        return new VideoEncoder.Callback() { // from class: io.agora.base.internal.video.VideoEncoderWrapper.1
            @Override // io.agora.base.internal.video.VideoEncoder.Callback
            public void onEncodedFrame(EncodedImage encodedImage, int i, int i2, CodecSpecificInfo codecSpecificInfo) {
                VideoEncoderWrapper.nativeOnEncodedFrame(j, encodedImage.buffer, encodedImage.encodedWidth, encodedImage.encodedHeight, encodedImage.captureTimeNs, encodedImage.frameType.getNative(), encodedImage.rotation, encodedImage.completeFrame, encodedImage.qp, i, i2, codecSpecificInfo);
            }
        };
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.high;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.low;
    }

    @CalledByNative
    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.on;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnEncodedFrame(long j, ByteBuffer byteBuffer, int i, int i2, long j2, int i3, int i4, boolean z, Integer num, int i5, int i6, CodecSpecificInfo codecSpecificInfo);

    private static native int nativeRewriteSpsInConfigBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2);

    private static native boolean nativeShouldUseBaseline();

    public static int rewriteSpsInConfigBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2) {
        return nativeRewriteSpsInConfigBuffer(byteBuffer, byteBuffer2, i, i2);
    }

    public static boolean shouldUseBaseline() {
        return nativeShouldUseBaseline();
    }
}
