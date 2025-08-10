package dc;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;

/* compiled from: SkinCompatTextHelperV17.java */
@RequiresApi(17)
@TargetApi(17)
/* loaded from: classes5.dex */
public class cj4 extends bj4 {
    public int i;
    public int j;

    public cj4(TextView textView) {
        super(textView);
        this.i = 0;
        this.j = 0;
    }

    @Override // dc.bj4
    public void b() {
        int iA = vi4.a(this.e);
        this.e = iA;
        Drawable drawableA = iA != 0 ? xh4.a(this.a.getContext(), this.e) : null;
        int iA2 = vi4.a(this.g);
        this.g = iA2;
        Drawable drawableA2 = iA2 != 0 ? xh4.a(this.a.getContext(), this.g) : null;
        int iA3 = vi4.a(this.f);
        this.f = iA3;
        Drawable drawableA3 = iA3 != 0 ? xh4.a(this.a.getContext(), this.f) : null;
        int iA4 = vi4.a(this.d);
        this.d = iA4;
        Drawable drawableA4 = iA4 != 0 ? xh4.a(this.a.getContext(), this.d) : null;
        Drawable drawableA5 = this.i != 0 ? xh4.a(this.a.getContext(), this.i) : null;
        if (drawableA5 != null) {
            drawableA = drawableA5;
        }
        Drawable drawableA6 = this.j != 0 ? xh4.a(this.a.getContext(), this.j) : null;
        if (drawableA6 != null) {
            drawableA3 = drawableA6;
        }
        if (this.e == 0 && this.g == 0 && this.f == 0 && this.d == 0 && this.i == 0 && this.j == 0) {
            return;
        }
        this.a.setCompoundDrawablesWithIntrinsicBounds(drawableA, drawableA2, drawableA3, drawableA4);
    }

    @Override // dc.bj4
    public void k(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinCompatTextHelper, i, 0);
        int i2 = yg4.SkinCompatTextHelper_android_drawableStart;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            this.i = resourceId;
            this.i = vi4.a(resourceId);
        }
        int i3 = yg4.SkinCompatTextHelper_android_drawableEnd;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            this.j = resourceId2;
            this.j = vi4.a(resourceId2);
        }
        typedArrayObtainStyledAttributes.recycle();
        super.k(attributeSet, i);
    }

    @Override // dc.bj4
    public void l(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.i = i;
        this.g = i2;
        this.j = i3;
        this.d = i4;
        b();
    }
}
