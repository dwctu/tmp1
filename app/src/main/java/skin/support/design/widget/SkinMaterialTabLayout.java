package skin.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.si4;
import dc.th4;
import dc.vi4;

/* loaded from: classes5.dex */
public class SkinMaterialTabLayout extends TabLayout implements aj4 {
    public int a;
    public int b;
    public int c;
    public si4 d;

    public SkinMaterialTabLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA != 0) {
            setSelectedTabIndicatorColor(th4.b(getContext(), this.a));
        }
        int iA2 = vi4.a(this.b);
        this.b = iA2;
        if (iA2 != 0) {
            setTabTextColors(th4.c(getContext(), this.b));
        }
        int iA3 = vi4.a(this.c);
        this.c = iA3;
        if (iA3 != 0) {
            int iB = th4.b(getContext(), this.c);
            if (getTabTextColors() != null) {
                setTabTextColors(getTabTextColors().getDefaultColor(), iB);
            }
        }
        si4 si4Var = this.d;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.TabLayout, i, 0);
        this.a = typedArrayObtainStyledAttributes.getResourceId(ci4.TabLayout_tabIndicatorColor, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(typedArrayObtainStyledAttributes.getResourceId(ci4.TabLayout_tabTextAppearance, bi4.TextAppearance_Design_Tab), ci4.SkinTextAppearance);
        try {
            this.b = typedArrayObtainStyledAttributes2.getResourceId(ci4.SkinTextAppearance_android_textColor, 0);
            typedArrayObtainStyledAttributes2.recycle();
            int i2 = ci4.TabLayout_tabTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            int i3 = ci4.TabLayout_tabSelectedTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.c = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            }
            si4 si4Var = new si4(this);
            this.d = si4Var;
            si4Var.c(attributeSet, i);
            typedArrayObtainStyledAttributes.recycle();
            P1();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }
}
