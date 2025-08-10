package skin.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import com.google.android.material.navigation.NavigationView;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.si4;
import dc.th4;
import dc.uh4;
import dc.vi4;
import dc.wh4;
import dc.xh4;

/* loaded from: classes5.dex */
public class SkinMaterialNavigationView extends NavigationView implements aj4 {
    public static final int[] f = {R.attr.state_checked};
    public static final int[] g = {-16842910};
    public int a;
    public int b;
    public int c;
    public int d;
    public si4 e;

    public SkinMaterialNavigationView(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.e;
        if (si4Var != null) {
            si4Var.b();
        }
        b();
        c();
        a();
    }

    public final void a() {
        Drawable drawableA;
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA == 0 || (drawableA = xh4.a(getContext(), this.a)) == null) {
            return;
        }
        setItemBackground(drawableA);
    }

    public final void b() {
        int iA = vi4.a(this.d);
        this.d = iA;
        if (iA != 0) {
            setItemIconTintList(th4.c(getContext(), this.d));
            return;
        }
        int iA2 = vi4.a(this.c);
        this.c = iA2;
        if (iA2 != 0) {
            setItemIconTintList(createDefaultColorStateList(R.attr.textColorSecondary));
        }
    }

    public final void c() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            setItemTextColor(th4.c(getContext(), this.b));
            return;
        }
        int iA2 = vi4.a(this.c);
        this.c = iA2;
        if (iA2 != 0) {
            setItemTextColor(createDefaultColorStateList(R.attr.textColorPrimary));
        }
    }

    public final ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListC = th4.c(getContext(), typedValue.resourceId);
        int iB = th4.b(getContext(), this.c);
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = g;
        return new ColorStateList(new int[][]{iArr, f, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), iB, defaultColor});
    }

    @Override // com.google.android.material.navigation.NavigationView
    public void setItemBackgroundResource(@DrawableRes int i) {
        super.setItemBackgroundResource(i);
        this.a = i;
        a();
    }

    @Override // com.google.android.material.navigation.NavigationView
    public void setItemTextAppearance(@StyleRes int i) throws Resources.NotFoundException {
        super.setItemTextAppearance(i);
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(i, ci4.SkinTextAppearance);
            int i2 = ci4.SkinTextAppearance_android_textColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            c();
        }
    }

    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        int resourceId;
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        si4 si4Var = new si4(this);
        this.e = si4Var;
        si4Var.c(attributeSet, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.NavigationView, i, bi4.Widget_Design_NavigationView);
        int i2 = ci4.NavigationView_itemIconTint;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.d = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        } else {
            this.c = wh4.a(context);
        }
        int i3 = ci4.NavigationView_itemTextAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i3) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, 0)) != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, ci4.SkinTextAppearance);
            int i4 = ci4.SkinTextAppearance_android_textColor;
            if (typedArrayObtainStyledAttributes2.hasValue(i4)) {
                this.b = typedArrayObtainStyledAttributes2.getResourceId(i4, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        int i5 = ci4.NavigationView_itemTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.b = typedArrayObtainStyledAttributes.getResourceId(i5, 0);
        } else {
            this.c = wh4.a(context);
        }
        if (this.b == 0) {
            this.b = uh4.c(context);
        }
        this.a = typedArrayObtainStyledAttributes.getResourceId(ci4.NavigationView_itemBackground, 0);
        typedArrayObtainStyledAttributes.recycle();
        b();
        c();
        a();
    }
}
