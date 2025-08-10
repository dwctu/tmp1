package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import dc.aj4;
import dc.bj4;
import dc.kh4;
import dc.si4;
import dc.ti4;

/* loaded from: classes5.dex */
public class SkinCompatCheckBox extends AppCompatCheckBox implements aj4 {
    public ti4 a;
    public bj4 b;
    public si4 c;

    public SkinCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        ti4 ti4Var = this.a;
        if (ti4Var != null) {
            ti4Var.b();
        }
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        super.setButtonDrawable(i);
        ti4 ti4Var = this.a;
        if (ti4Var != null) {
            ti4Var.d(i);
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

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.checkboxStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        bj4 bj4Var = this.b;
        if (bj4Var != null) {
            bj4Var.n(context, i);
        }
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ti4 ti4Var = new ti4(this);
        this.a = ti4Var;
        ti4Var.c(attributeSet, i);
        si4 si4Var = new si4(this);
        this.c = si4Var;
        si4Var.c(attributeSet, i);
        bj4 bj4VarH = bj4.h(this);
        this.b = bj4VarH;
        bj4VarH.k(attributeSet, i);
    }
}
