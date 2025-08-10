package dc;

import java.nio.ByteBuffer;

/* compiled from: Parser.java */
/* loaded from: classes4.dex */
public class yw3 {
    public static byte[] a(byte[][] bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        return b(bArr, length);
    }

    public static byte[] b(byte[][] bArr, int i) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        for (byte[] bArr2 : bArr) {
            byteBufferAllocate.put(bArr2);
        }
        return byteBufferAllocate.array();
    }
}
