package dc;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: SkinCompatBackgroundHelper.java */
/* loaded from: classes5.dex */
public class si4 extends vi4 {
    public final View a;
    public int b = 0;

    public si4(View view) {
        this.a = view;
    }

    public void b() {
        Drawable drawableA;
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA == 0 || (drawableA = xh4.a(this.a.getContext(), this.b)) == null) {
            return;
        }
        int paddingLeft = this.a.getPaddingLeft();
        int paddingTop = this.a.getPaddingTop();
        int paddingRight = this.a.getPaddingRight();
        int paddingBottom = this.a.getPaddingBottom();
        ViewCompat.setBackground(this.a, drawableA);
        this.a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinBackgroundHelper, i, 0);
        try {
            int i2 = yg4.SkinBackgroundHelper_android_background;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            b();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(int i) {
        this.b = i;
        b();
    }
}
