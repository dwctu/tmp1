package dc;

import android.view.View;

/* compiled from: PaddingBottomAttr.java */
/* loaded from: classes4.dex */
public class qv3 extends ev3 {
    public qv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static qv3 j(int i, int i2) {
        qv3 qv3Var;
        if (i2 == 1) {
            qv3Var = new qv3(i, 4096, 0);
        } else if (i2 == 2) {
            qv3Var = new qv3(i, 0, 4096);
        } else {
            if (i2 != 3) {
                return null;
            }
            qv3Var = new qv3(i, 0, 0);
        }
        return qv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 4096;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }
}
