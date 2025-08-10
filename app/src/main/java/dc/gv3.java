package dc;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: MarginAttr.java */
/* loaded from: classes4.dex */
public class gv3 extends ev3 {
    public gv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    @Override // dc.ev3
    public void a(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            if (!i()) {
                super.a(view);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int iH = h();
            marginLayoutParams.rightMargin = iH;
            marginLayoutParams.leftMargin = iH;
            int iG = g();
            marginLayoutParams.bottomMargin = iG;
            marginLayoutParams.topMargin = iG;
        }
    }

    @Override // dc.ev3
    public int b() {
        return 16;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = i;
        marginLayoutParams.topMargin = i;
        marginLayoutParams.rightMargin = i;
        marginLayoutParams.leftMargin = i;
    }
}
