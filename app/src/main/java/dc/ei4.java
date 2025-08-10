package dc;

/* compiled from: ColorUtils.java */
/* loaded from: classes5.dex */
public final class ei4 {
    public static int a(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
