package dc;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

/* compiled from: ArrowDrawable.java */
/* loaded from: classes3.dex */
public class md1 extends kd1 {
    public int b = 0;
    public int c = 0;
    public final Path d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.b != iWidth || this.c != iHeight) {
            int i = (iWidth * 30) / HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION;
            this.d.reset();
            float f = i;
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = iWidth;
            float f5 = f4 / 2.0f;
            float f6 = iHeight;
            this.d.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.d.lineTo(0.0f, f7);
            float f8 = f7 - f2;
            this.d.lineTo(f2, f8);
            float f9 = f / 2.0f;
            float f10 = f5 - f9;
            float f11 = (f6 - f3) - f9;
            this.d.lineTo(f10, f11);
            this.d.lineTo(f10, 0.0f);
            float f12 = f5 + f9;
            this.d.lineTo(f12, 0.0f);
            this.d.lineTo(f12, f11);
            this.d.lineTo(f4 - f2, f8);
            this.d.lineTo(f4, f7);
            this.d.close();
            this.b = iWidth;
            this.c = iHeight;
        }
        canvas.drawPath(this.d, this.a);
    }
}
