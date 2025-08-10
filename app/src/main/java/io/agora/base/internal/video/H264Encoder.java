package io.agora.base.internal.video;

/* loaded from: classes4.dex */
public class H264Encoder extends WrappedNativeVideoEncoder {
    public static native long nativeCreateEncoder();

    public static native boolean nativeIsSupported();

    @Override // io.agora.base.internal.video.WrappedNativeVideoEncoder, io.agora.base.internal.video.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }

    @Override // io.agora.base.internal.video.WrappedNativeVideoEncoder, io.agora.base.internal.video.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }
}
