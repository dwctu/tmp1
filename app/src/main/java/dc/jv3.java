package dc;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: MarginRightAttr.java */
/* loaded from: classes4.dex */
public class jv3 extends ev3 {
    public jv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static jv3 j(int i, int i2) {
        jv3 jv3Var;
        if (i2 == 1) {
            jv3Var = new jv3(i, 128, 0);
        } else if (i2 == 2) {
            jv3Var = new jv3(i, 0, 128);
        } else {
            if (i2 != 3) {
                return null;
            }
            jv3Var = new jv3(i, 0, 0);
        }
        return jv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 128;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin = i;
        }
    }
}
