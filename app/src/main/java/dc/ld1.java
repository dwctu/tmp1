package dc;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;

/* compiled from: ProgressDrawable.java */
/* loaded from: classes3.dex */
public class ld1 extends kd1 implements Animatable, ValueAnimator.AnimatorUpdateListener {
    public ValueAnimator e;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public Path f = new Path();

    public ld1() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(30, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
        this.e = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(10000L);
        this.e.setInterpolator(null);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f = iWidth;
        float fMax = Math.max(1.0f, f / 22.0f);
        if (this.b != iWidth || this.c != iHeight) {
            this.f.reset();
            float f2 = f - fMax;
            float f3 = iHeight / 2.0f;
            this.f.addCircle(f2, f3, fMax, Path.Direction.CW);
            float f4 = f - (5.0f * fMax);
            this.f.addRect(f4, f3 - fMax, f2, f3 + fMax, Path.Direction.CW);
            this.f.addCircle(f4, f3, fMax, Path.Direction.CW);
            this.b = iWidth;
            this.c = iHeight;
        }
        canvas.save();
        float f5 = f / 2.0f;
        float f6 = iHeight / 2.0f;
        canvas.rotate(this.d, f5, f6);
        for (int i = 0; i < 12; i++) {
            this.a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f, this.a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.e.isRunning()) {
            return;
        }
        this.e.addUpdateListener(this);
        this.e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
