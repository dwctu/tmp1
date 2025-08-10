package dc;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MaxHeightAttr.java */
/* loaded from: classes4.dex */
public class lv3 extends ev3 {
    public lv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static lv3 j(int i, int i2) {
        lv3 lv3Var;
        if (i2 == 1) {
            lv3Var = new lv3(i, 65536, 0);
        } else if (i2 == 2) {
            lv3Var = new lv3(i, 0, 65536);
        } else {
            if (i2 != 3) {
                return null;
            }
            lv3Var = new lv3(i, 0, 0);
        }
        return lv3Var;
    }

    public static int k(View view) {
        try {
            return ((Integer) view.getClass().getMethod("getMaxHeight", new Class[0]).invoke(view, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // dc.ev3
    public int b() {
        return 65536;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            view.getClass().getMethod("setMaxHeight", Integer.TYPE).invoke(view, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }
}
