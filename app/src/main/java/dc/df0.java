package dc;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: IsoTypeReader.java */
/* loaded from: classes.dex */
public final class df0 {
    public static int a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static String b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static double c(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK)) | ((r0[1] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK)) | ((r0[2] << 8) & 65280)) | (r0[3] & 255)) / 1.073741824E9d;
    }

    public static double d(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK)) | ((r0[1] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK)) | ((r0[2] << 8) & 65280)) | (r0[3] & 255)) / 65536.0d;
    }

    public static float e(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[2]);
        return ((short) (((short) (0 | ((r0[0] << 8) & 65280))) | (r0[1] & 255))) / 256.0f;
    }

    public static String f(ByteBuffer byteBuffer) {
        int iH = h(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((iH >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    public static String g(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return ff0.a(bArr);
    }

    public static int h(ByteBuffer byteBuffer) {
        return (a(byteBuffer.get()) << 8) + 0 + a(byteBuffer.get());
    }

    public static int i(ByteBuffer byteBuffer) {
        return (h(byteBuffer) << 8) + 0 + a(byteBuffer.get());
    }

    public static long j(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static long k(ByteBuffer byteBuffer) {
        long j = (j(byteBuffer) << 32) + 0;
        if (j >= 0) {
            return j + j(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static int l(ByteBuffer byteBuffer) {
        return a(byteBuffer.get());
    }
}
