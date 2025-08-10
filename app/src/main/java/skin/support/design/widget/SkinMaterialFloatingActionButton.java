package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.th4;
import dc.vi4;
import dc.wi4;

/* loaded from: classes5.dex */
public class SkinMaterialFloatingActionButton extends FloatingActionButton implements aj4 {
    public int a;
    public int b;
    public wi4 c;

    public SkinMaterialFloatingActionButton(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        a();
        b();
        wi4 wi4Var = this.c;
        if (wi4Var != null) {
            wi4Var.b();
        }
    }

    public final void a() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            setBackgroundTintList(th4.c(getContext(), this.b));
        }
    }

    public final void b() {
        int iA = vi4.a(this.a);
        this.a = iA;
        if (iA != 0) {
            setRippleColor(th4.b(getContext(), this.a));
        }
    }

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.FloatingActionButton, i, bi4.Widget_Design_FloatingActionButton);
        this.b = typedArrayObtainStyledAttributes.getResourceId(ci4.FloatingActionButton_backgroundTint, 0);
        this.a = typedArrayObtainStyledAttributes.getResourceId(ci4.FloatingActionButton_rippleColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
        b();
        wi4 wi4Var = new wi4(this);
        this.c = wi4Var;
        wi4Var.c(attributeSet, i);
    }
}
