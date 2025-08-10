package com.huawei.hms.scankit.drawable;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.p.Qc;
import com.huawei.hms.scankit.p.Rc;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ScanDrawable extends Drawable implements Animatable {
    private static final int[] a = {13625597, 357325};
    private static final Interpolator b = new a(0.4f, 0.0f, 0.4f, 1.0f);
    private static final Interpolator c = new a(0.4f, 0.0f, 0.7f, 1.0f);
    private static final Interpolator d = new a(0.25f, 0.0f, 0.4f, 1.0f);
    private AnimatorSet A;
    private final ValueAnimator e;
    private final ValueAnimator f;
    private final Matrix g;
    private final Paint h;
    private final Paint i;
    private final ColorMatrix j;
    private final Matrix k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private int p;
    private int q;
    private float r;
    private boolean s;
    private float t;
    private int u;
    private Qc v;
    private float w;
    private boolean x;
    private Bitmap y;
    private Bitmap z;

    public ScanDrawable() {
        this.e = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = new Matrix();
        this.h = new Paint();
        this.i = new Paint();
        this.j = new ColorMatrix();
        this.k = new Matrix();
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.r = 0.5f;
        this.s = false;
        this.t = 0.0f;
        this.x = true;
        this.A = new AnimatorSet();
        d();
    }

    private void e() {
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setRepeatMode(2);
        this.e.setRepeatCount(-1);
        this.e.setDuration(500L);
        this.e.setStartDelay(200L);
        this.e.addListener(new d(this));
    }

    private void f() {
        this.f.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setRepeatCount(-1);
        this.f.setRepeatMode(2);
        this.f.addUpdateListener(new b(this));
        this.f.addListener(new c(this));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isRunning() || canvas == null) {
            return;
        }
        if (this.s) {
            int i = this.u;
            this.m.set(0, i, getBounds().right, ((int) (this.q * this.t * 0.5f)) + i);
            int i2 = this.u;
            this.n.set(0, i2, getBounds().right, ((int) (this.q * this.t)) + i2);
        } else {
            int i3 = this.u;
            this.m.set(0, i3, getBounds().right, i3 - ((int) ((this.q * this.t) * 0.5f)));
            int i4 = this.u;
            this.n.set(0, i4, getBounds().right, i4 - ((int) (this.q * this.t)));
        }
        a(canvas, this.n);
        b(canvas);
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (resources == null || xmlPullParser == null || attributeSet == null) {
            return;
        }
        a(resources);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.A.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.s = false;
        this.x = true;
        a(getBounds());
        this.A.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.A.end();
            this.v = null;
        }
    }

    private void d() {
        f();
        e();
        AnimatorSet animatorSet = new AnimatorSet();
        this.A = animatorSet;
        animatorSet.playTogether(this.f, this.e);
    }

    private void b(Canvas canvas) {
        Qc qc = this.v;
        if (qc == null) {
            return;
        }
        qc.a(canvas, this.m);
    }

    private void a(Resources resources) {
        if (resources == null) {
            return;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_light);
        this.z = Bitmap.createBitmap(bitmapDecodeResource.getWidth() * 2, bitmapDecodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(this.z);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        paint.setShader(new BitmapShader(bitmapDecodeResource, tileMode, tileMode));
        canvas.drawRect(0.0f, 0.0f, bitmapDecodeResource.getWidth() * 2, bitmapDecodeResource.getHeight() * 2, paint);
        this.y = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_tail);
        this.w = resources.getDisplayMetrics().density;
    }

    private void a(Rect rect) {
        if (rect.height() == 0) {
            return;
        }
        this.o.set(rect);
        this.o.inset(0, (int) (rect.height() * 0.1f));
        this.p = (int) (rect.height() * 0.18f);
        this.q = (int) (rect.height() * 0.36f);
        Rect rect2 = new Rect(rect);
        rect2.inset((int) (rect.width() * 0.2f), 0);
        float f = this.w;
        int iWidth = (int) ((f != 0.0f ? 0.001f / (f * f) : 0.001f) * rect2.width() * rect2.height());
        this.v = new Qc(new Rc(iWidth, 500L).a(0.33f, 1.0f).a(0, -1, 0L, 100L, new LinearInterpolator()).a(-1, 0, 400L, 500L, new LinearInterpolator()), rect2, iWidth, this.w * 2.0f, a);
    }

    public ScanDrawable(Resources resources) {
        this();
        a(resources);
    }

    private void a(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.y;
        if (bitmap == null || bitmap.getWidth() == 0 || this.y.getHeight() == 0) {
            return;
        }
        this.g.setScale(rect.width() / this.y.getWidth(), rect.height() / this.y.getHeight());
        this.g.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.y, this.g, this.h);
        this.g.reset();
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.z;
        if (bitmap == null || bitmap.getWidth() == 0 || this.z.getHeight() == 0) {
            return;
        }
        float fFloatValue = (this.t * 0.5f) + (((Float) this.e.getAnimatedValue()).floatValue() * this.r);
        float f = (1.5f - fFloatValue) * 0.05f;
        float f2 = f + 1.0f;
        this.j.set(new float[]{1.0f, f, f, f, 0.0f, f, f2, f, f, 0.0f, f, f, f2, f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.i.setColorFilter(new ColorMatrixColorFilter(this.j));
        int i = (int) (this.p * ((fFloatValue * 0.2f) + 0.4f));
        if (this.s) {
            int i2 = this.u;
            this.l.set(0, i2 + i, getBounds().right, i2 - i);
        } else {
            int i3 = this.u;
            this.l.set(0, i3 - i, getBounds().right, i3 + i);
        }
        this.k.setScale(this.l.width() / this.z.getWidth(), this.l.height() / this.z.getHeight());
        Matrix matrix = this.k;
        Rect rect = this.l;
        matrix.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.z, this.k, this.i);
        this.k.reset();
    }
}
