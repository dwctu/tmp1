package dc;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: MarginBottomAttr.java */
/* loaded from: classes4.dex */
public class hv3 extends ev3 {
    public hv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static hv3 j(int i, int i2) {
        hv3 hv3Var;
        if (i2 == 1) {
            hv3Var = new hv3(i, 256, 0);
        } else if (i2 == 2) {
            hv3Var = new hv3(i, 0, 256);
        } else {
            if (i2 != 3) {
                return null;
            }
            hv3Var = new hv3(i, 0, 0);
        }
        return hv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 256;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = i;
        }
    }
}
