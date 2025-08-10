package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import dc.aj4;
import dc.si4;
import dc.wi4;

/* loaded from: classes5.dex */
public class SkinCompatImageButton extends AppCompatImageButton implements aj4 {
    public si4 a;
    public wi4 b;

    public SkinCompatImageButton(Context context) {
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

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        wi4 wi4Var = this.b;
        if (wi4Var != null) {
            wi4Var.d(i);
        }
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
        wi4 wi4Var = new wi4(this);
        this.b = wi4Var;
        wi4Var.c(attributeSet, i);
    }
}
