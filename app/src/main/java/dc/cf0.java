package dc;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: IsoFile.java */
/* loaded from: classes.dex */
public class cf0 extends h41 implements Closeable {
    static {
        g51.a(cf0.class);
    }

    public static byte[] y(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    @Override // dc.h41, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // dc.h41
    public String toString() {
        return "model(" + this.b.toString() + ")";
    }
}
