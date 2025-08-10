package dc;

/* compiled from: ZipCryptoEngine.java */
/* loaded from: classes5.dex */
public class m84 {
    public static final int[] b = new int[256];
    public final int[] a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            b[i] = i2;
        }
    }

    public final int a(int i, byte b2) {
        return b[(i ^ b2) & 255] ^ (i >>> 8);
    }

    public byte b() {
        int i = this.a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }

    public void c(char[] cArr, boolean z) {
        int[] iArr = this.a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b2 : ja4.a(cArr, z)) {
            d((byte) (b2 & 255));
        }
    }

    public void d(byte b2) {
        int[] iArr = this.a;
        iArr[0] = a(iArr[0], b2);
        int[] iArr2 = this.a;
        iArr2[1] = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = (iArr2[1] * 134775813) + 1;
        iArr2[2] = a(iArr2[2], (byte) (iArr2[1] >> 24));
    }
}
