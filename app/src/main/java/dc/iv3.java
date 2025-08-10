package dc;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: MarginLeftAttr.java */
/* loaded from: classes4.dex */
public class iv3 extends ev3 {
    public iv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static iv3 j(int i, int i2) {
        iv3 iv3Var;
        if (i2 == 1) {
            iv3Var = new iv3(i, 32, 0);
        } else if (i2 == 2) {
            iv3Var = new iv3(i, 0, 32);
        } else {
            if (i2 != 3) {
                return null;
            }
            iv3Var = new iv3(i, 0, 0);
        }
        return iv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 32;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin = i;
        }
    }
}
