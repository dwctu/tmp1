package dc;

import android.view.View;

/* compiled from: PaddingRightAttr.java */
/* loaded from: classes4.dex */
public class sv3 extends ev3 {
    public sv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static sv3 j(int i, int i2) {
        sv3 sv3Var;
        if (i2 == 1) {
            sv3Var = new sv3(i, 2048, 0);
        } else if (i2 == 2) {
            sv3Var = new sv3(i, 0, 2048);
        } else {
            if (i2 != 3) {
                return null;
            }
            sv3Var = new sv3(i, 0, 0);
        }
        return sv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 2048;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
    }
}
