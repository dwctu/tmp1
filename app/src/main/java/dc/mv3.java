package dc;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MaxWidthAttr.java */
/* loaded from: classes4.dex */
public class mv3 extends ev3 {
    public mv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static mv3 j(int i, int i2) {
        mv3 mv3Var;
        if (i2 == 1) {
            mv3Var = new mv3(i, 16384, 0);
        } else if (i2 == 2) {
            mv3Var = new mv3(i, 0, 16384);
        } else {
            if (i2 != 3) {
                return null;
            }
            mv3Var = new mv3(i, 0, 0);
        }
        return mv3Var;
    }

    public static int k(View view) {
        try {
            return ((Integer) view.getClass().getMethod("getMaxWidth", new Class[0]).invoke(view, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // dc.ev3
    public int b() {
        return 16384;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            view.getClass().getMethod("setMaxWidth", Integer.TYPE).invoke(view, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }
}
