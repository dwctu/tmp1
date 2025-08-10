package com.scwang.smart.refresh.layout.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import dc.ae1;
import dc.ce1;
import dc.de1;
import dc.vd1;
import dc.xd1;
import dc.yd1;
import dc.zd1;

/* loaded from: classes3.dex */
public abstract class SimpleComponent extends RelativeLayout implements vd1 {
    public View a;
    public de1 b;
    public vd1 c;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComponent(@NonNull View view) {
        this(view, view instanceof vd1 ? (vd1) view : null);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean b(boolean z) {
        vd1 vd1Var = this.c;
        return (vd1Var instanceof xd1) && ((xd1) vd1Var).b(z);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof vd1) && getView() == ((vd1) obj).getView();
    }

    public int f(@NonNull ae1 ae1Var, boolean z) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return 0;
        }
        return vd1Var.f(ae1Var, z);
    }

    public void g(@NonNull zd1 zd1Var, int i, int i2) {
        vd1 vd1Var = this.c;
        if (vd1Var != null && vd1Var != this) {
            vd1Var.g(zd1Var, i, i2);
            return;
        }
        View view = this.a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                zd1Var.e(this, ((SmartRefreshLayout.LayoutParams) layoutParams).a);
            }
        }
    }

    @Override // dc.vd1
    @NonNull
    public de1 getSpinnerStyle() {
        int i;
        de1 de1Var = this.b;
        if (de1Var != null) {
            return de1Var;
        }
        vd1 vd1Var = this.c;
        if (vd1Var != null && vd1Var != this) {
            return vd1Var.getSpinnerStyle();
        }
        View view = this.a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                de1 de1Var2 = ((SmartRefreshLayout.LayoutParams) layoutParams).b;
                this.b = de1Var2;
                if (de1Var2 != null) {
                    return de1Var2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (de1 de1Var3 : de1.i) {
                    if (de1Var3.c) {
                        this.b = de1Var3;
                        return de1Var3;
                    }
                }
            }
        }
        de1 de1Var4 = de1.d;
        this.b = de1Var4;
        return de1Var4;
    }

    @Override // dc.vd1
    @NonNull
    public View getView() {
        View view = this.a;
        return view == null ? this : view;
    }

    public void h(@NonNull ae1 ae1Var, @NonNull ce1 ce1Var, @NonNull ce1 ce1Var2) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        if ((this instanceof xd1) && (vd1Var instanceof yd1)) {
            if (ce1Var.isFooter) {
                ce1Var = ce1Var.toHeader();
            }
            if (ce1Var2.isFooter) {
                ce1Var2 = ce1Var2.toHeader();
            }
        } else if ((this instanceof yd1) && (vd1Var instanceof xd1)) {
            if (ce1Var.isHeader) {
                ce1Var = ce1Var.toFooter();
            }
            if (ce1Var2.isHeader) {
                ce1Var2 = ce1Var2.toFooter();
            }
        }
        vd1 vd1Var2 = this.c;
        if (vd1Var2 != null) {
            vd1Var2.h(ae1Var, ce1Var, ce1Var2);
        }
    }

    public void i(@NonNull ae1 ae1Var, int i, int i2) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        vd1Var.i(ae1Var, i, i2);
    }

    public void j(@NonNull ae1 ae1Var, int i, int i2) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        vd1Var.j(ae1Var, i, i2);
    }

    @Override // dc.vd1
    public void k(float f, int i, int i2) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        vd1Var.k(f, i, i2);
    }

    @Override // dc.vd1
    public boolean m() {
        vd1 vd1Var = this.c;
        return (vd1Var == null || vd1Var == this || !vd1Var.m()) ? false : true;
    }

    @Override // dc.vd1
    public void q(boolean z, float f, int i, int i2, int i3) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        vd1Var.q(z, f, i, i2, i3);
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        vd1 vd1Var = this.c;
        if (vd1Var == null || vd1Var == this) {
            return;
        }
        vd1Var.setPrimaryColors(iArr);
    }

    public SimpleComponent(@NonNull View view, @Nullable vd1 vd1Var) {
        super(view.getContext(), null, 0);
        this.a = view;
        this.c = vd1Var;
        if ((this instanceof xd1) && (vd1Var instanceof yd1) && vd1Var.getSpinnerStyle() == de1.h) {
            vd1Var.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof yd1) {
            vd1 vd1Var2 = this.c;
            if ((vd1Var2 instanceof xd1) && vd1Var2.getSpinnerStyle() == de1.h) {
                vd1Var.getView().setScaleY(-1.0f);
            }
        }
    }

    public SimpleComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
