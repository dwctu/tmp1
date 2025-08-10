package skin.support.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import dc.aj4;
import dc.kh4;
import dc.lh4;
import dc.si4;
import dc.th4;
import dc.vi4;
import dc.xh4;

/* loaded from: classes5.dex */
public class SkinCompatToolbar extends Toolbar implements aj4 {
    public int a;
    public int b;
    public int c;
    public si4 d;

    public SkinCompatToolbar(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.d;
        if (si4Var != null) {
            si4Var.b();
        }
        c();
        b();
        a();
    }

    public final void a() {
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA != 0) {
            setNavigationIcon(xh4.a(getContext(), this.c));
        }
    }

    public final void b() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            setSubtitleTextColor(th4.b(getContext(), this.b));
        }
    }

    public final void c() {
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA != 0) {
            setTitleTextColor(th4.b(getContext(), this.a));
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.d;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@DrawableRes int i) {
        super.setNavigationIcon(i);
        this.c = i;
        a();
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, kh4.toolbarStyle);
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        si4 si4Var = new si4(this);
        this.d = si4Var;
        si4Var.c(attributeSet, i);
        int[] iArr = lh4.Toolbar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.c = typedArrayObtainStyledAttributes.getResourceId(lh4.Toolbar_navigationIcon, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(lh4.Toolbar_titleTextAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(lh4.Toolbar_subtitleTextAppearance, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, lh4.SkinTextAppearance);
            this.a = typedArrayObtainStyledAttributes2.getResourceId(lh4.SkinTextAppearance_android_textColor, 0);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(resourceId2, lh4.SkinTextAppearance);
            this.b = typedArrayObtainStyledAttributes3.getResourceId(lh4.SkinTextAppearance_android_textColor, 0);
            typedArrayObtainStyledAttributes3.recycle();
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        int i2 = lh4.Toolbar_titleTextColor;
        if (typedArrayObtainStyledAttributes4.hasValue(i2)) {
            this.a = typedArrayObtainStyledAttributes4.getResourceId(i2, 0);
        }
        int i3 = lh4.Toolbar_subtitleTextColor;
        if (typedArrayObtainStyledAttributes4.hasValue(i3)) {
            this.b = typedArrayObtainStyledAttributes4.getResourceId(i3, 0);
        }
        typedArrayObtainStyledAttributes4.recycle();
        c();
        b();
        a();
    }
}
