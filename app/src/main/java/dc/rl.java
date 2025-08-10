package dc;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import dc.ql;
import dc.xl;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class rl {
    public static final zg<tg> f = zg.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", tg.DEFAULT);
    public static final zg<bh> g = zg.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", bh.SRGB);

    @Deprecated
    public static final zg<ql> h = ql.f;
    public static final zg<Boolean> i;
    public static final zg<Boolean> j;
    public static final Set<String> k;
    public static final b l;
    public static final Set<ImageHeaderParser.ImageType> m;
    public static final Queue<BitmapFactory.Options> n;
    public final cj a;
    public final DisplayMetrics b;
    public final zi c;
    public final List<ImageHeaderParser> d;
    public final wl e = wl.a();

    /* compiled from: Downsampler.java */
    public class a implements b {
        @Override // dc.rl.b
        public void a(cj cjVar, Bitmap bitmap) {
        }

        @Override // dc.rl.b
        public void b() {
        }
    }

    /* compiled from: Downsampler.java */
    public interface b {
        void a(cj cjVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = zg.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = zg.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = wp.f(0);
    }

    public rl(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, cj cjVar, zi ziVar) {
        this.d = list;
        vp.d(displayMetrics);
        this.b = displayMetrics;
        vp.d(cjVar);
        this.a = cjVar;
        vp.d(ziVar);
        this.c = ziVar;
    }

    public static int a(double d) {
        return x((d / (r1 / r0)) * x(l(d) * d));
    }

    public static void c(ImageHeaderParser.ImageType imageType, xl xlVar, b bVar, cj cjVar, ql qlVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                String str = "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]";
                return;
            }
            return;
        }
        if (r(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = qlVar.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + qlVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        ql.e eVarA = qlVar.a(i7, i8, i5, i6);
        if (eVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int iX = i7 / x(fB * f2);
        int iX2 = i8 / x(fB * f3);
        ql.e eVar = ql.e.MEMORY;
        int iMax = eVarA == eVar ? Math.max(iX, iX2) : Math.min(iX, iX2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 23 || !k.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            if (eVarA == eVar && iMax2 < 1.0f / fB) {
                iMax2 <<= 1;
            }
            i9 = iMax2;
        } else {
            i9 = 1;
        }
        options.inSampleSize = i9;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i9, 8);
            iFloor = (int) Math.ceil(f2 / fMin);
            iRound = (int) Math.ceil(f3 / fMin);
            int i11 = i9 / 8;
            if (i11 > 0) {
                iFloor /= i11;
                iRound /= i11;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = i9;
                iFloor = (int) Math.floor(f2 / f4);
                dFloor = Math.floor(f3 / f4);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i10 >= 24) {
                    float f5 = i9;
                    iFloor = Math.round(f2 / f5);
                    iRound = Math.round(f3 / f5);
                } else {
                    float f6 = i9;
                    iFloor = (int) Math.floor(f2 / f6);
                    dFloor = Math.floor(f3 / f6);
                }
            } else if (i7 % i9 == 0 && i8 % i9 == 0) {
                iFloor = i7 / i9;
                iRound = i8 / i9;
            } else {
                int[] iArrM = m(xlVar, options, bVar, cjVar);
                iFloor = iArrM[0];
                iRound = iArrM[1];
            }
            iRound = (int) dFloor;
        }
        double dB = qlVar.b(iFloor, iRound, i5, i6);
        if (i10 >= 19) {
            options.inTargetDensity = a(dB);
            options.inDensity = l(dB);
        }
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            String str2 = "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + i9 + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap i(dc.xl r4, android.graphics.BitmapFactory.Options r5, dc.rl.b r6, dc.cj r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.b()
            r4.b()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = dc.fm.i()
            r3.lock()
            android.graphics.Bitmap r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalArgumentException -> L25
            java.util.concurrent.locks.Lock r5 = dc.fm.i()
            r5.unlock()
            return r4
        L23:
            r4 = move-exception
            goto L49
        L25:
            r3 = move-exception
            java.io.IOException r0 = u(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L23
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L48
            r7.c(r1)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            android.graphics.Bitmap r4 = i(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            java.util.concurrent.locks.Lock r5 = dc.fm.i()
            r5.unlock()
            return r4
        L47:
            throw r0     // Catch: java.lang.Throwable -> L23
        L48:
            throw r0     // Catch: java.lang.Throwable -> L23
        L49:
            java.util.concurrent.locks.Lock r5 = dc.fm.i()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.rl.i(dc.xl, android.graphics.BitmapFactory$Options, dc.rl$b, dc.cj):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    public static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = n;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            w(optionsPoll);
        }
        return optionsPoll;
    }

    public static int l(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static int[] m(xl xlVar, BitmapFactory.Options options, b bVar, cj cjVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(xlVar, options, bVar, cjVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    public static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        String str2 = "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + rp.a(j2);
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    public static void y(BitmapFactory.Options options, cj cjVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = cjVar.e(i2, i3, config);
    }

    public final void b(xl xlVar, tg tgVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.e.e(i2, i3, options, z, z2)) {
            return;
        }
        if (tgVar == tg.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = xlVar.d().hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable("Downsampler", 3)) {
                String str = "Cannot determine whether the image has alpha or not from header, format " + tgVar;
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    @RequiresApi(21)
    public ti<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, ah ahVar) throws IOException {
        return e(new xl.b(parcelFileDescriptor, this.d, this.c), i2, i3, ahVar, l);
    }

    public final ti<Bitmap> e(xl xlVar, int i2, int i3, ah ahVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.c.c(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        tg tgVar = (tg) ahVar.c(f);
        bh bhVar = (bh) ahVar.c(g);
        ql qlVar = (ql) ahVar.c(ql.f);
        boolean zBooleanValue = ((Boolean) ahVar.c(i)).booleanValue();
        zg<Boolean> zgVar = j;
        try {
            return jl.d(h(xlVar, optionsK, qlVar, tgVar, bhVar, ahVar.c(zgVar) != null && ((Boolean) ahVar.c(zgVar)).booleanValue(), i2, i3, zBooleanValue, bVar), this.a);
        } finally {
            v(optionsK);
            this.c.put(bArr);
        }
    }

    public ti<Bitmap> f(InputStream inputStream, int i2, int i3, ah ahVar) throws IOException {
        return g(inputStream, i2, i3, ahVar, l);
    }

    public ti<Bitmap> g(InputStream inputStream, int i2, int i3, ah ahVar, b bVar) throws IOException {
        return e(new xl.a(inputStream, this.d, this.c), i2, i3, ahVar, bVar);
    }

    public final Bitmap h(xl xlVar, BitmapFactory.Options options, ql qlVar, tg tgVar, bh bhVar, boolean z, int i2, int i3, boolean z2, b bVar) throws IOException {
        int i4;
        int i5;
        rl rlVar;
        int iRound;
        int iRound2;
        int i6;
        ColorSpace colorSpace;
        long jB = rp.b();
        int[] iArrM = m(xlVar, options, bVar, this.a);
        boolean z3 = false;
        int i7 = iArrM[0];
        int i8 = iArrM[1];
        String str = options.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int iC = xlVar.c();
        int iJ = fm.j(iC);
        boolean zM = fm.m(iC);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = r(iJ) ? i8 : i7;
        } else {
            i4 = i3;
            i5 = i2;
        }
        int i9 = i4 == Integer.MIN_VALUE ? r(iJ) ? i7 : i8 : i4;
        ImageHeaderParser.ImageType imageTypeD = xlVar.d();
        c(imageTypeD, xlVar, bVar, this.a, qlVar, iJ, i7, i8, i5, i9, options);
        b(xlVar, tgVar, z4, zM, options, i5, i9);
        int i10 = Build.VERSION.SDK_INT;
        boolean z5 = i10 >= 19;
        if (options.inSampleSize == 1 || z5) {
            rlVar = this;
            if (rlVar.z(imageTypeD)) {
                if (i7 < 0 || i8 < 0 || !z2 || !z5) {
                    float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i11 = options.inSampleSize;
                    float f3 = i11;
                    float f4 = f2;
                    int iCeil = (int) Math.ceil(i7 / f3);
                    int iCeil2 = (int) Math.ceil(i8 / f3);
                    iRound = Math.round(iCeil * f4);
                    iRound2 = Math.round(iCeil2 * f4);
                    if (Log.isLoggable("Downsampler", 2)) {
                        String str2 = "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f4;
                    }
                } else {
                    iRound = i5;
                    iRound2 = i9;
                }
                if (iRound > 0 && iRound2 > 0) {
                    y(options, rlVar.a, iRound, iRound2);
                }
            }
        } else {
            rlVar = this;
        }
        if (i10 >= 28) {
            if (bhVar == bh.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i10 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapI = i(xlVar, options, bVar, rlVar.a);
        bVar.a(rlVar.a, bitmapI);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = iC;
            t(i7, i8, str, options, bitmapI, i2, i3, jB);
        } else {
            i6 = iC;
        }
        Bitmap bitmapN = null;
        if (bitmapI != null) {
            bitmapI.setDensity(rlVar.b.densityDpi);
            bitmapN = fm.n(rlVar.a, bitmapI, i6);
            if (!bitmapI.equals(bitmapN)) {
                rlVar.a.c(bitmapI);
            }
        }
        return bitmapN;
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return rh.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return m.contains(imageType);
    }
}
