package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;
import dc.ah4;
import dc.aj4;
import dc.bh4;
import dc.bj4;
import dc.ch4;
import dc.si4;
import dc.vi4;

/* loaded from: classes5.dex */
public class SkinCompatEditText extends AppCompatEditText implements aj4, bh4 {
    public bj4 a;
    public si4 b;
    public int c;
    public Object[] d;

    public SkinCompatEditText(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.b();
        }
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.d();
        }
    }

    @Override // dc.bh4
    public void a() {
        Object[] objArr = this.d;
        if (objArr == null || objArr.length == 0) {
            int i = this.c;
            if (i != 0) {
                setHint(ah4.e(i));
                return;
            }
            return;
        }
        this.a.o(0);
        Object[] objArr2 = new Object[this.d.length];
        int i2 = 0;
        while (true) {
            Object[] objArr3 = this.d;
            if (i2 >= objArr3.length) {
                setHint(String.format(ah4.e(this.c), objArr2));
                return;
            }
            if (objArr3[i2] instanceof Integer) {
                this.c = 0;
                objArr2[i2] = ah4.e(((Integer) objArr3[i2]).intValue());
            } else {
                objArr2[i2] = objArr3[i2];
            }
            i2++;
        }
    }

    public int getTextColorResId() {
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            return bj4Var.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.d(i);
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

    @Override // dc.bh4
    public void setTextResId(int i, Object... objArr) {
        this.d = objArr;
        this.c = vi4.a(i);
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.o(i);
        }
        a();
    }

    public SkinCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        bj4 bj4Var = this.a;
        if (bj4Var != null) {
            bj4Var.n(context, i);
        }
    }

    public SkinCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.b = si4Var;
        si4Var.c(attributeSet, i);
        bj4 bj4VarH = bj4.h(this);
        this.a = bj4VarH;
        bj4VarH.k(attributeSet, i);
        this.c = this.a.j();
        ah4.c.add(new ch4(this));
    }
}
