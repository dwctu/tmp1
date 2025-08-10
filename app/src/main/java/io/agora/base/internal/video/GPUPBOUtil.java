package io.agora.base.internal.video;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class GPUPBOUtil {
    private long nativeHandle = nativeObjectInit();

    private native long nativeObjectInit();

    private native boolean nativeReadFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer);

    private native void nativeRelease(long j);

    public boolean readFrame(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return nativeReadFrame(j, i, i2, i3, i4, i5, i6, byteBuffer);
    }

    public void release() {
        long j = this.nativeHandle;
        if (j != 0) {
            nativeRelease(j);
            this.nativeHandle = 0L;
        }
    }
}
