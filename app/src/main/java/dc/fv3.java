package dc;

import android.view.View;

/* compiled from: HeightAttr.java */
/* loaded from: classes4.dex */
public class fv3 extends ev3 {
    public fv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static fv3 j(int i, int i2) {
        fv3 fv3Var;
        if (i2 == 1) {
            fv3Var = new fv3(i, 2, 0);
        } else if (i2 == 2) {
            fv3Var = new fv3(i, 0, 2);
        } else {
            if (i2 != 3) {
                return null;
            }
            fv3Var = new fv3(i, 0, 0);
        }
        return fv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 2;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.getLayoutParams().height = i;
    }
}
