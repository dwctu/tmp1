package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import dc.aj4;
import dc.kh4;
import dc.zi4;

/* loaded from: classes5.dex */
public class SkinCompatSeekBar extends AppCompatSeekBar implements aj4 {
    public zi4 a;

    public SkinCompatSeekBar(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        zi4 zi4Var = this.a;
        if (zi4Var != null) {
            zi4Var.b();
        }
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.seekBarStyle);
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        zi4 zi4Var = new zi4(this);
        this.a = zi4Var;
        zi4Var.e(attributeSet, i);
    }
}
