package io.agora.base.internal.video;

/* loaded from: classes4.dex */
public class VP8Encoder extends WrappedNativeVideoEncoder {
    public static native long nativeCreateEncoder();

    @Override // io.agora.base.internal.video.WrappedNativeVideoEncoder, io.agora.base.internal.video.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }

    @Override // io.agora.base.internal.video.WrappedNativeVideoEncoder, io.agora.base.internal.video.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }
}
