package dc;

import android.view.View;

/* compiled from: PaddingTopAttr.java */
/* loaded from: classes4.dex */
public class tv3 extends ev3 {
    public tv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static tv3 j(int i, int i2) {
        tv3 tv3Var;
        if (i2 == 1) {
            tv3Var = new tv3(i, 1024, 0);
        } else if (i2 == 2) {
            tv3Var = new tv3(i, 0, 1024);
        } else {
            if (i2 != 3) {
                return null;
            }
            tv3Var = new tv3(i, 0, 0);
        }
        return tv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 1024;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
    }
}
