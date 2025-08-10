package skin.support.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import dc.aj4;
import dc.bj4;
import dc.kh4;
import dc.si4;
import dc.vi4;
import dc.xh4;

/* loaded from: classes5.dex */
public class SkinCompatMultiAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView implements aj4 {
    public static final int[] d = {R.attr.popupBackground};
    public int a;
    public bj4 b;
    public si4 c;

    public SkinCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.d();
        }
        a();
    }

    public final void a() {
        Drawable drawableA;
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA == 0 || (drawableA = xh4.a(getContext(), this.a)) == null) {
            return;
        }
        setDropDownBackgroundDrawable(drawableA);
    }

    @Override // androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.l(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.m(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView, android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int i) {
        super.setDropDownBackgroundResource(i);
        this.a = i;
        a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.editTextStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.n(context, i);
        }
    }

    public SkinCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.a = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        a();
        si4 si4Var = new si4(this);
        this.c = si4Var;
        si4Var.c(attributeSet, i);
        bj4 bj4VarH = bj4.h(this);
        this.b = bj4VarH;
        bj4VarH.k(attributeSet, i);
    }
}
