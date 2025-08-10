package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.si4;
import dc.vi4;
import dc.xh4;

/* loaded from: classes5.dex */
public class SkinMaterialCollapsingToolbarLayout extends CollapsingToolbarLayout implements aj4 {
    public int a;
    public int b;
    public si4 c;

    public SkinMaterialCollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        a();
        b();
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    public final void a() {
        Drawable drawableA;
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA == 0 || (drawableA = xh4.a(getContext(), this.a)) == null) {
            return;
        }
        setContentScrim(drawableA);
    }

    public final void b() {
        Drawable drawableA;
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA == 0 || (drawableA = xh4.a(getContext(), this.b)) == null) {
            return;
        }
        setStatusBarScrim(drawableA);
    }

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.CollapsingToolbarLayout, i, bi4.Widget_Design_CollapsingToolbar);
        this.a = typedArrayObtainStyledAttributes.getResourceId(ci4.CollapsingToolbarLayout_contentScrim, 0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(ci4.CollapsingToolbarLayout_statusBarScrim, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
        b();
        si4 si4Var = new si4(this);
        this.c = si4Var;
        si4Var.c(attributeSet, 0);
    }
}
