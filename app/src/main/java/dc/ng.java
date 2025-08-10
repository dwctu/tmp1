package dc;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import dc.dg;
import dc.ql;
import dc.rl;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: WebpDownsampler.java */
/* loaded from: classes.dex */
public final class ng {
    public static final zg<Boolean> e = zg.f("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
    public static final rl.b f = new a();
    public static final Queue<BitmapFactory.Options> g = wp.f(0);
    public final cj a;
    public final DisplayMetrics b;
    public final zi c;
    public final List<ImageHeaderParser> d;

    /* compiled from: WebpDownsampler.java */
    public static class a implements rl.b {
        @Override // dc.rl.b
        public void a(cj cjVar, Bitmap bitmap) throws IOException {
        }

        @Override // dc.rl.b
        public void b() {
        }
    }

    public ng(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, cj cjVar, zi ziVar) {
        this.d = list;
        vp.d(displayMetrics);
        this.b = displayMetrics;
        vp.d(cjVar);
        this.a = cjVar;
        vp.d(ziVar);
        this.c = ziVar;
    }

    public static int a(double d) {
        return s((d / (r0 / 1.0E9f)) * s(1.0E9d * d));
    }

    public static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, rl.b bVar, cj cjVar, ql qlVar, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int iFloor;
        double dFloor;
        int iRound;
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        float fB = (i == 90 || i == 270) ? qlVar.b(i3, i2, i4, i5) : qlVar.b(i2, i3, i4, i5);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + qlVar + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        ql.e eVarA = qlVar.a(i2, i3, i4, i5);
        if (eVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i2;
        float f3 = i3;
        int iS = i2 / s(fB * f2);
        int iS2 = i3 / s(fB * f3);
        ql.e eVar = ql.e.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(eVarA == eVar ? Math.max(iS, iS2) : Math.min(iS, iS2)));
        if (eVarA == eVar && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f2 / fMin);
            iRound = (int) Math.ceil(f3 / fMin);
            int i6 = iMax / 8;
            if (i6 > 0) {
                iFloor /= i6;
                iRound /= i6;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = iMax;
                iFloor = (int) Math.floor(f2 / f4);
                dFloor = Math.floor(f3 / f4);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f5 = iMax;
                    iFloor = Math.round(f2 / f5);
                    iRound = Math.round(f3 / f5);
                } else {
                    float f6 = iMax;
                    iFloor = (int) Math.floor(f2 / f6);
                    dFloor = Math.floor(f3 / f6);
                }
            } else if (i2 % iMax == 0 && i3 % iMax == 0) {
                iFloor = i2 / iMax;
                iRound = i3 / iMax;
            } else {
                int[] iArrJ = j(inputStream, options, bVar, cjVar);
                iFloor = iArrJ[0];
                iRound = iArrJ[1];
            }
            iRound = (int) dFloor;
        }
        double dB = qlVar.b(iFloor, iRound, i4, i5);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = a(dB);
            options.inDensity = 1000000000;
        }
        if (n(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("WebpDownsampler", 2)) {
            String str = "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap g(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, dc.rl.b r7, dc.cj r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto La
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto Ld
        La:
            r7.b()
        Ld:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = dc.fm.i()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r7 = com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeStream(r5, r3, r6)     // Catch: java.lang.Throwable -> L2e java.lang.IllegalArgumentException -> L30
            java.util.concurrent.locks.Lock r8 = dc.fm.i()
            r8.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L2d
            r5.reset()
        L2d:
            return r7
        L2e:
            r5 = move-exception
            goto L58
        L30:
            r4 = move-exception
            java.io.IOException r0 = p(r4, r0, r1, r2, r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = "WebpDownsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L2e
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L57
            r5.reset()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L56
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L56
            r8.c(r1)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L56
            r6.inBitmap = r3     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L56
            android.graphics.Bitmap r5 = g(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L56
            java.util.concurrent.locks.Lock r6 = dc.fm.i()
            r6.unlock()
            return r5
        L56:
            throw r0     // Catch: java.lang.Throwable -> L2e
        L57:
            throw r0     // Catch: java.lang.Throwable -> L2e
        L58:
            java.util.concurrent.locks.Lock r6 = dc.fm.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ng.g(java.io.InputStream, android.graphics.BitmapFactory$Options, dc.rl$b, dc.cj):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    public static String h(Bitmap bitmap) {
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

    public static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = g;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            r(optionsPoll);
        }
        return optionsPoll;
    }

    public static int[] j(InputStream inputStream, BitmapFactory.Options options, rl.b bVar, cj cjVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, cjVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String k(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    public static boolean n(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    public static void o(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        String str2 = "Decoded " + h(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + k(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + rp.a(j);
    }

    public static IOException p(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + k(options), illegalArgumentException);
    }

    public static void q(BitmapFactory.Options options) {
        r(options);
        Queue<BitmapFactory.Options> queue = g;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void r(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int s(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    public static void t(BitmapFactory.Options options, cj cjVar, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = cjVar.e(i, i2, options.inPreferredConfig);
        }
    }

    public final void b(InputStream inputStream, tg tgVar, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) throws IOException {
        if (tgVar == tg.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = wg.e(this.d, inputStream, this.c).hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable("WebpDownsampler", 3)) {
                String str = "Cannot determine whether the image has alpha or not from header, format " + tgVar;
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    public ti<Bitmap> d(InputStream inputStream, int i, int i2, ah ahVar) throws IOException {
        return e(inputStream, i, i2, ahVar, f);
    }

    public ti<Bitmap> e(InputStream inputStream, int i, int i2, ah ahVar, rl.b bVar) throws IOException {
        vp.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.c.c(65536, byte[].class);
        BitmapFactory.Options optionsI = i();
        optionsI.inTempStorage = bArr;
        tg tgVar = (tg) ahVar.c(rl.f);
        ql qlVar = (ql) ahVar.c(rl.h);
        boolean zBooleanValue = ((Boolean) ahVar.c(rl.i)).booleanValue();
        zg<Boolean> zgVar = rl.j;
        try {
            return jl.d(f(inputStream, optionsI, qlVar, tgVar, ahVar.c(zgVar) != null && ((Boolean) ahVar.c(zgVar)).booleanValue(), i, i2, zBooleanValue, bVar), this.a);
        } finally {
            q(optionsI);
            this.c.e(bArr, byte[].class);
        }
    }

    public final Bitmap f(InputStream inputStream, BitmapFactory.Options options, ql qlVar, tg tgVar, boolean z, int i, int i2, boolean z2, rl.b bVar) throws IOException {
        ng ngVar;
        int iRound;
        int iRound2;
        int i3;
        long jB = rp.b();
        int[] iArrJ = j(inputStream, options, bVar, this.a);
        int i4 = iArrJ[0];
        int i5 = iArrJ[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int iB = wg.b(this.d, inputStream, this.c);
        int iJ = fm.j(iB);
        boolean zM = fm.m(iB);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        ImageHeaderParser.ImageType imageTypeE = wg.e(this.d, inputStream, this.c);
        c(imageTypeE, inputStream, bVar, this.a, qlVar, iJ, i4, i5, i6, i7, options);
        b(inputStream, tgVar, z3, zM, options, i6, i7);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            ngVar = this;
            if (ngVar.u(imageTypeE)) {
                if (z2 && z4) {
                    iRound = i6;
                    iRound2 = i7;
                } else {
                    float f2 = n(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i8 = options.inSampleSize;
                    float f3 = i8;
                    int iCeil = (int) Math.ceil(i4 / f3);
                    int iCeil2 = (int) Math.ceil(i5 / f3);
                    iRound = Math.round(iCeil * f2);
                    iRound2 = Math.round(iCeil2 * f2);
                    if (Log.isLoggable("WebpDownsampler", 2)) {
                        String str2 = "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2;
                    }
                }
                if (iRound > 0 && iRound2 > 0) {
                    t(options, ngVar.a, iRound, iRound2);
                }
            }
        } else {
            ngVar = this;
        }
        Bitmap bitmapG = g(inputStream, options, bVar, ngVar.a);
        bVar.a(ngVar.a, bitmapG);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            i3 = iB;
            o(i4, i5, str, options, bitmapG, i, i2, jB);
        } else {
            i3 = iB;
        }
        Bitmap bitmapN = null;
        if (bitmapG != null) {
            bitmapG.setDensity(ngVar.b.densityDpi);
            bitmapN = fm.n(ngVar.a, bitmapG, i3);
            if (!bitmapG.equals(bitmapN)) {
                ngVar.a.c(bitmapG);
            }
        }
        return bitmapN;
    }

    public boolean l(InputStream inputStream, ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(e)).booleanValue() || dg.a) {
            return false;
        }
        dg.e eVarB = dg.b(inputStream, this.c);
        return dg.h(eVarB) && eVarB != dg.e.WEBP_SIMPLE;
    }

    public boolean m(ByteBuffer byteBuffer, ah ahVar) throws IOException {
        if (((Boolean) ahVar.c(e)).booleanValue() || dg.a) {
            return false;
        }
        dg.e eVarC = dg.c(byteBuffer);
        return dg.h(eVarC) && eVarC != dg.e.WEBP_SIMPLE;
    }

    public final boolean u(ImageHeaderParser.ImageType imageType) throws IOException {
        return Build.VERSION.SDK_INT >= 19;
    }
}
