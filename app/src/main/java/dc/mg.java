package dc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpImage;
import dc.wf;
import java.nio.ByteBuffer;

/* compiled from: WebpDecoder.java */
/* loaded from: classes.dex */
public class mg implements wf {
    public ByteBuffer a;
    public WebpImage b;
    public final wf.a c;
    public int d;
    public final int[] e;
    public final bg[] f;
    public int g;
    public int h;
    public int i;
    public final Paint j;
    public qg k;
    public Bitmap.Config l;
    public final LruCache<Integer, Bitmap> m;

    /* compiled from: WebpDecoder.java */
    public class a extends LruCache<Integer, Bitmap> {
        public a(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
            if (bitmap != null) {
                mg.this.c.a(bitmap);
            }
        }
    }

    public mg(wf.a aVar, WebpImage webpImage, ByteBuffer byteBuffer, int i) {
        this(aVar, webpImage, byteBuffer, i, qg.c);
    }

    @Override // dc.wf
    public void a() {
        this.d = (this.d + 1) % this.b.getFrameCount();
    }

    @Override // dc.wf
    public int b() {
        return this.b.getFrameCount();
    }

    @Override // dc.wf
    public void c(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            this.l = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    @Override // dc.wf
    public void clear() {
        this.b.dispose();
        this.b = null;
        this.m.evictAll();
        this.a = null;
    }

    @Override // dc.wf
    public int d() {
        int i;
        if (this.e.length == 0 || (i = this.d) < 0) {
            return 0;
        }
        return l(i);
    }

    @Override // dc.wf
    public void e() {
        this.d = -1;
    }

    @Override // dc.wf
    public int f() {
        return this.d;
    }

    @Override // dc.wf
    public int g() {
        return this.b.getSizeInBytes();
    }

    @Override // dc.wf
    public ByteBuffer getData() {
        return this.a;
    }

    @Override // dc.wf
    public Bitmap getNextFrame() {
        Bitmap bitmap;
        int iF = f();
        Bitmap bitmapC = this.c.c(this.i, this.h, Bitmap.Config.ARGB_8888);
        bitmapC.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            bitmapC.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(bitmapC);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!this.k.c() && (bitmap = this.m.get(Integer.valueOf(iF))) != null) {
            if (Log.isLoggable("WebpDecoder", 3)) {
                String str = "hit frame bitmap from memory cache, frameNumber=" + iF;
            }
            bitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return bitmapC;
        }
        int iO = !n(iF) ? o(iF - 1, canvas) : iF;
        if (Log.isLoggable("WebpDecoder", 3)) {
            String str2 = "frameNumber=" + iF + ", nextIndex=" + iO;
        }
        while (iO < iF) {
            bg bgVar = this.f[iO];
            if (!bgVar.g) {
                j(canvas, bgVar);
            }
            p(iO, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                String str3 = "renderFrame, index=" + iO + ", blend=" + bgVar.g + ", dispose=" + bgVar.h;
            }
            if (bgVar.h) {
                j(canvas, bgVar);
            }
            iO++;
        }
        bg bgVar2 = this.f[iF];
        if (!bgVar2.g) {
            j(canvas, bgVar2);
        }
        p(iF, canvas);
        if (Log.isLoggable("WebpDecoder", 3)) {
            String str4 = "renderFrame, index=" + iF + ", blend=" + bgVar2.g + ", dispose=" + bgVar2.h;
        }
        i(iF, bitmapC);
        return bitmapC;
    }

    public final void i(int i, Bitmap bitmap) {
        this.m.remove(Integer.valueOf(i));
        Bitmap bitmapC = this.c.c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        bitmapC.eraseColor(0);
        bitmapC.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(bitmapC);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.m.put(Integer.valueOf(i), bitmapC);
    }

    public final void j(Canvas canvas, bg bgVar) {
        int i = bgVar.b;
        int i2 = this.g;
        int i3 = bgVar.c;
        canvas.drawRect(i / i2, i3 / i2, (i + bgVar.d) / i2, (i3 + bgVar.e) / i2, this.j);
    }

    public qg k() {
        return this.k;
    }

    public int l(int i) {
        if (i >= 0) {
            int[] iArr = this.e;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    public final boolean m(bg bgVar) {
        return bgVar.b == 0 && bgVar.c == 0 && bgVar.d == this.b.getWidth() && bgVar.e == this.b.getHeight();
    }

    public final boolean n(int i) {
        if (i == 0) {
            return true;
        }
        bg[] bgVarArr = this.f;
        bg bgVar = bgVarArr[i];
        bg bgVar2 = bgVarArr[i - 1];
        if (bgVar.g || !m(bgVar)) {
            return bgVar2.h && m(bgVar2);
        }
        return true;
    }

    public final int o(int i, Canvas canvas) {
        while (i >= 0) {
            bg bgVar = this.f[i];
            if (bgVar.h && m(bgVar)) {
                return i + 1;
            }
            Bitmap bitmap = this.m.get(Integer.valueOf(i));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (bgVar.h) {
                    j(canvas, bgVar);
                }
                return i + 1;
            }
            if (n(i)) {
                return i;
            }
            i--;
        }
        return 0;
    }

    public final void p(int i, Canvas canvas) {
        bg bgVar = this.f[i];
        int i2 = bgVar.d;
        int i3 = this.g;
        int i4 = i2 / i3;
        int i5 = bgVar.e / i3;
        int i6 = bgVar.b / i3;
        int i7 = bgVar.c / i3;
        WebpFrame frame = this.b.getFrame(i);
        try {
            try {
                Bitmap bitmapC = this.c.c(i4, i5, this.l);
                bitmapC.eraseColor(0);
                bitmapC.setDensity(canvas.getDensity());
                frame.renderFrame(i4, i5, bitmapC);
                canvas.drawBitmap(bitmapC, i6, i7, (Paint) null);
                this.c.a(bitmapC);
            } catch (IllegalStateException unused) {
                String str = "Rendering of frame failed. Frame number: " + i;
            }
        } finally {
            frame.dispose();
        }
    }

    public void q(yf yfVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int iHighestOneBit = Integer.highestOneBit(i);
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.a = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.g = iHighestOneBit;
        this.i = this.b.getWidth() / iHighestOneBit;
        this.h = this.b.getHeight() / iHighestOneBit;
    }

    public mg(wf.a aVar, WebpImage webpImage, ByteBuffer byteBuffer, int i, qg qgVar) {
        this.d = -1;
        this.l = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.b = webpImage;
        this.e = webpImage.getFrameDurations();
        this.f = new bg[webpImage.getFrameCount()];
        for (int i2 = 0; i2 < this.b.getFrameCount(); i2++) {
            this.f[i2] = this.b.getFrameInfo(i2);
            if (Log.isLoggable("WebpDecoder", 3)) {
                String str = "mFrameInfos: " + this.f[i2].toString();
            }
        }
        this.k = qgVar;
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.m = new a(this.k.a() ? webpImage.getFrameCount() : Math.max(5, this.k.b()));
        q(new yf(), byteBuffer, i);
    }
}
