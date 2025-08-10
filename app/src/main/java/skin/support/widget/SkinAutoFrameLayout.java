package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.zhy.autolayout.AutoFrameLayout;
import dc.aj4;
import dc.si4;

/* loaded from: classes5.dex */
public class SkinAutoFrameLayout extends AutoFrameLayout implements aj4 {
    public si4 b;

    public SkinAutoFrameLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    public SkinAutoFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinAutoFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.b = si4Var;
        si4Var.c(attributeSet, i);
    }
}
