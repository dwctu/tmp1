package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import dc.aj4;
import dc.kh4;
import dc.xi4;

/* loaded from: classes5.dex */
public class SkinCompatRatingBar extends AppCompatRatingBar implements aj4 {
    public xi4 a;

    public SkinCompatRatingBar(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        xi4 xi4Var = this.a;
        if (xi4Var != null) {
            xi4Var.b();
        }
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.ratingBarStyle);
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        xi4 xi4Var = new xi4(this);
        this.a = xi4Var;
        xi4Var.e(attributeSet, i);
    }
}
