package dc;

import android.view.View;

/* compiled from: WidthAttr.java */
/* loaded from: classes4.dex */
public class vv3 extends ev3 {
    public vv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static vv3 j(int i, int i2) {
        vv3 vv3Var;
        if (i2 == 1) {
            vv3Var = new vv3(i, 1, 0);
        } else if (i2 == 2) {
            vv3Var = new vv3(i, 0, 1);
        } else {
            if (i2 != 3) {
                return null;
            }
            vv3Var = new vv3(i, 0, 0);
        }
        return vv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 1;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.getLayoutParams().width = i;
    }
}
