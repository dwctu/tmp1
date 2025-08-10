package dc;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: MarginTopAttr.java */
/* loaded from: classes4.dex */
public class kv3 extends ev3 {
    public kv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static kv3 j(int i, int i2) {
        kv3 kv3Var;
        if (i2 == 1) {
            kv3Var = new kv3(i, 64, 0);
        } else if (i2 == 2) {
            kv3Var = new kv3(i, 0, 64);
        } else {
            if (i2 != 3) {
                return null;
            }
            kv3Var = new kv3(i, 0, 0);
        }
        return kv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 64;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = i;
        }
    }
}
