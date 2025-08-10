package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.zhy.autolayout.AutoLinearLayout;
import dc.aj4;
import dc.si4;
import dc.ui4;

/* loaded from: classes5.dex */
public class SkinAutoLinearLayout extends AutoLinearLayout implements aj4 {
    public si4 b;
    public ui4 c;

    public SkinAutoLinearLayout(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.b();
        }
        ui4 ui4Var = this.c;
        if (ui4Var != null) {
            ui4Var.b();
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

    public SkinAutoLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinAutoLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.b = si4Var;
        si4Var.c(attributeSet, i);
        ui4 ui4Var = new ui4(this);
        this.c = ui4Var;
        ui4Var.c(attributeSet, i);
    }
}
