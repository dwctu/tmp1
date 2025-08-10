package dc;

import android.view.View;

/* compiled from: PaddingAttr.java */
/* loaded from: classes4.dex */
public class pv3 extends ev3 {
    public pv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    @Override // dc.ev3
    public void a(View view) {
        if (!i()) {
            super.a(view);
            return;
        }
        int iH = h();
        int iG = g();
        view.setPadding(iH, iG, iH, iG);
    }

    @Override // dc.ev3
    public int b() {
        return 8;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setPadding(i, i, i, i);
    }
}
