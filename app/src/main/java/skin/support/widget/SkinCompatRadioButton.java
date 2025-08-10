package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatRadioButton;
import dc.aj4;
import dc.bj4;
import dc.kh4;
import dc.si4;
import dc.ti4;

/* loaded from: classes5.dex */
public class SkinCompatRadioButton extends AppCompatRadioButton implements aj4 {
    public bj4 a;
    public ti4 b;
    public si4 c;

    public SkinCompatRadioButton(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
        ti4 ti4Var = this.b;
        if (ti4Var != null) {
            ti4Var.b();
        }
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRadioButton, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRadioButton, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        super.setButtonDrawable(i);
        ti4 ti4Var = this.b;
        if (ti4Var != null) {
            ti4Var.d(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.l(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.m(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.radioButtonStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.n(context, i);
        }
    }

    public SkinCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ti4 ti4Var = new ti4(this);
        this.b = ti4Var;
        ti4Var.c(attributeSet, i);
        bj4 bj4VarH = bj4.h(this);
        this.a = bj4VarH;
        bj4VarH.k(attributeSet, i);
        si4 si4Var = new si4(this);
        this.c = si4Var;
        si4Var.c(attributeSet, i);
    }
}
