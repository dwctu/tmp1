package dc;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: MinHeightAttr.java */
/* loaded from: classes4.dex */
public class nv3 extends ev3 {
    public nv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static nv3 j(int i, int i2) {
        nv3 nv3Var;
        if (i2 == 1) {
            nv3Var = new nv3(i, 32768, 0);
        } else if (i2 == 2) {
            nv3Var = new nv3(i, 0, 32768);
        } else {
            if (i2 != 3) {
                return null;
            }
            nv3Var = new nv3(i, 0, 0);
        }
        return nv3Var;
    }

    public static int k(View view) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        try {
            Field field = view.getClass().getField("mMinHeight");
            field.setAccessible(true);
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // dc.ev3
    public int b() {
        return 32768;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        try {
            view.setMinimumHeight(i);
        } catch (Exception unused) {
        }
    }
}
