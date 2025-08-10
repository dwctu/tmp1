package dc;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: MinWidthAttr.java */
/* loaded from: classes4.dex */
public class ov3 extends ev3 {
    public ov3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static ov3 j(int i, int i2) {
        ov3 ov3Var;
        if (i2 == 1) {
            ov3Var = new ov3(i, 8192, 0);
        } else if (i2 == 2) {
            ov3Var = new ov3(i, 0, 8192);
        } else {
            if (i2 != 3) {
                return null;
            }
            ov3Var = new ov3(i, 0, 0);
        }
        return ov3Var;
    }

    public static int k(View view) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        try {
            Field field = view.getClass().getField("mMinWidth");
            field.setAccessible(true);
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // dc.ev3
    public int b() {
        return 8192;
    }

    @Override // dc.ev3
    public boolean e() {
        return true;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        view.setMinimumWidth(i);
    }
}
