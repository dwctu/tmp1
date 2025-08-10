package skin.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.si4;
import dc.th4;
import dc.vi4;
import dc.zh4;

/* loaded from: classes5.dex */
public class SkinMaterialBottomNavigationView extends BottomNavigationView implements aj4 {
    public static final int[] e = {-16842910};
    public static final int[] f = {R.attr.state_checked};
    public si4 a;
    public int b;
    public int c;
    public int d;

    public SkinMaterialBottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
        a();
        b();
    }

    public final void a() {
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA != 0) {
            setItemIconTintList(th4.c(getContext(), this.c));
            return;
        }
        int iA2 = vi4.a(this.d);
        this.d = iA2;
        if (iA2 != 0) {
            setItemIconTintList(c(R.attr.textColorSecondary));
        }
    }

    public final void b() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            setItemTextColor(th4.c(getContext(), this.b));
            return;
        }
        int iA2 = vi4.a(this.d);
        this.d = iA2;
        if (iA2 != 0) {
            setItemTextColor(c(R.attr.textColorSecondary));
        }
    }

    public final ColorStateList c(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListC = th4.c(getContext(), typedValue.resourceId);
        int iB = th4.b(getContext(), this.d);
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = e;
        return new ColorStateList(new int[][]{iArr, f, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), iB, defaultColor});
    }

    public final int d() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(zh4.colorPrimary, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    public SkinMaterialBottomNavigationView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.BottomNavigationView, i, bi4.Widget_Design_BottomNavigationView);
        int i2 = ci4.BottomNavigationView_itemIconTint;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.c = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        } else {
            this.d = d();
        }
        int i3 = ci4.BottomNavigationView_itemTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.b = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        } else {
            this.d = d();
        }
        typedArrayObtainStyledAttributes.recycle();
        a();
        b();
    }
}
