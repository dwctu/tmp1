package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import dc.aj4;
import dc.si4;
import dc.wi4;

/* loaded from: classes5.dex */
public class SkinCompatImageView extends AppCompatImageView implements aj4 {
    public si4 a;
    public wi4 b;

    public SkinCompatImageView(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
        wi4 wi4Var = this.b;
        if (wi4Var != null) {
            wi4Var.b();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        wi4 wi4Var = this.b;
        if (wi4Var != null) {
            wi4Var.d(i);
        }
    }

    public SkinCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
        wi4 wi4Var = new wi4(this);
        this.b = wi4Var;
        wi4Var.c(attributeSet, i);
    }
}
