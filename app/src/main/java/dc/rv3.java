package dc;

import android.view.View;

/* compiled from: PaddingLeftAttr.java */
/* loaded from: classes4.dex */
public class rv3 extends ev3 {
    public rv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static rv3 j(int i, int i2) {
        rv3 rv3Var;
        if (i2 == 1) {
            rv3Var = new rv3(i, 512, 0);
        } else if (i2 == 2) {
            rv3Var = new rv3(i, 0, 512);
        } else {
            if (i2 != 3) {
                return null;
            }
            rv3Var = new rv3(i, 0, 0);
        }
        return rv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 512;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
