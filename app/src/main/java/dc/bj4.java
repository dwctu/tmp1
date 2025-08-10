package dc;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;

/* compiled from: SkinCompatTextHelper.java */
/* loaded from: classes5.dex */
public class bj4 extends vi4 {
    public final TextView a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;

    public bj4(TextView textView) {
        this.a = textView;
    }

    public static bj4 h(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new cj4(textView) : new bj4(textView);
    }

    public void b() {
        c();
    }

    public void c() {
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
        if (this.e == 0 && this.g == 0 && this.f == 0 && this.d == 0) {
            return;
        }
        this.a.setCompoundDrawablesWithIntrinsicBounds(drawableA, drawableA2, drawableA3, drawableA4);
    }

    public void d() {
        b();
        f();
        e();
        g();
    }

    public final void e() {
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA != 0) {
            try {
                this.a.setHintTextColor(th4.c(this.a.getContext(), this.c));
            } catch (Exception unused) {
            }
        }
    }

    public final void f() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            try {
                this.a.setTextColor(th4.c(this.a.getContext(), this.b));
            } catch (Exception unused) {
            }
        }
    }

    public final void g() {
        int iA = vi4.a(this.h);
        this.h = iA;
        if (iA != 0) {
            String string = this.a.getText().toString();
            TextView textView = this.a;
            if (textView instanceof EditText) {
                textView.setHint(ah4.e(this.h));
            } else {
                textView.setText(ah4.b(this.h, string));
            }
        }
    }

    public int i() {
        return this.b;
    }

    public int j() {
        return this.h;
    }

    public void k(AttributeSet attributeSet, int i) {
        Context context = this.a.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, yg4.SkinCompatTextHelper, i, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinCompatTextHelper_android_textAppearance, 0);
        int i2 = yg4.SkinCompatTextHelper_android_drawableLeft;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.e = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        }
        int i3 = yg4.SkinCompatTextHelper_android_drawableTop;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.g = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        }
        int i4 = yg4.SkinCompatTextHelper_android_drawableRight;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f = typedArrayObtainStyledAttributes.getResourceId(i4, 0);
        }
        int i5 = yg4.SkinCompatTextHelper_android_drawableBottom;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.d = typedArrayObtainStyledAttributes.getResourceId(i5, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, yg4.SkinTextAppearance, i, 0);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, new int[]{R.attr.textColor});
            this.b = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
            typedArrayObtainStyledAttributes3.recycle();
        }
        int i6 = yg4.SkinTextAppearance_android_textColor;
        if (typedArrayObtainStyledAttributes2.hasValue(i6)) {
            this.b = typedArrayObtainStyledAttributes2.getResourceId(i6, 0);
        }
        if (this.a instanceof EditText) {
            int i7 = yg4.SkinTextAppearance_android_hint;
            if (typedArrayObtainStyledAttributes2.hasValue(i7)) {
                this.h = typedArrayObtainStyledAttributes2.getResourceId(i7, 0);
            }
        } else {
            int i8 = yg4.SkinTextAppearance_android_text;
            if (typedArrayObtainStyledAttributes2.hasValue(i8)) {
                this.h = typedArrayObtainStyledAttributes2.getResourceId(i8, 0);
            }
        }
        int i9 = yg4.SkinTextAppearance_android_textColorHint;
        if (typedArrayObtainStyledAttributes2.hasValue(i9)) {
            this.c = typedArrayObtainStyledAttributes2.getResourceId(i9, 0);
        }
        typedArrayObtainStyledAttributes2.recycle();
        d();
    }

    public void l(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.e = i;
        this.g = i2;
        this.f = i3;
        this.d = i4;
        b();
    }

    public void m(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.e = i;
        this.g = i2;
        this.f = i3;
        this.d = i4;
        c();
    }

    public void n(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, yg4.SkinTextAppearance);
        int i2 = yg4.SkinTextAppearance_android_textColor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        }
        int i3 = yg4.SkinTextAppearance_android_textColorHint;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.c = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        f();
        e();
    }

    public void o(int i) {
        this.h = i;
    }
}
