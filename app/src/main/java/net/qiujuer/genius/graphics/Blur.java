package net.qiujuer.genius.graphics;

import android.graphics.Bitmap;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class Blur {
    static {
        System.loadLibrary("genius_graphics");
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i < 0 || i > 256) {
            throw new RuntimeException("Blur bitmap radius must >= 1 and <=256.");
        }
        Objects.requireNonNull(bitmap, "Blur bitmap original isn't null.");
        if (bitmap.isRecycled()) {
            throw new RuntimeException("Blur bitmap can't blur a recycled bitmap.");
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            return bitmap;
        }
        throw new RuntimeException("Blur bitmap only supported Bitmap.Config.ARGB_8888 and Bitmap.Config.RGB_565.");
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        a(bitmap, i);
        if (i == 1) {
            return bitmap;
        }
        nativeStackBlurBitmap(bitmap, i);
        return bitmap;
    }

    public static int[] c(int[] iArr, int i, int i2, int i3) {
        if (i3 < 0 || i3 > 256) {
            throw new RuntimeException("Blur bitmap radius must >= 1 and <=256.");
        }
        if (iArr == null) {
            throw new RuntimeException("Blur bitmap pix isn't null.");
        }
        if (iArr.length < i * i2) {
            throw new RuntimeException("Blur bitmap pix length must >= w * h.");
        }
        nativeStackBlurPixels(iArr, i, i2, i3);
        return iArr;
    }

    private static native void nativeStackBlurBitmap(Bitmap bitmap, int i);

    private static native void nativeStackBlurBitmapClip(Bitmap bitmap, int i, int i2);

    private static native void nativeStackBlurPixels(int[] iArr, int i, int i2, int i3);
}
