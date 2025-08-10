package dc;

import android.view.View;
import android.widget.TextView;

/* compiled from: TextSizeAttr.java */
/* loaded from: classes4.dex */
public class uv3 extends ev3 {
    public uv3(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static uv3 j(int i, int i2) {
        uv3 uv3Var;
        if (i2 == 1) {
            uv3Var = new uv3(i, 4, 0);
        } else if (i2 == 2) {
            uv3Var = new uv3(i, 0, 4);
        } else {
            if (i2 != 3) {
                return null;
            }
            uv3Var = new uv3(i, 0, 0);
        }
        return uv3Var;
    }

    @Override // dc.ev3
    public int b() {
        return 4;
    }

    @Override // dc.ev3
    public boolean e() {
        return false;
    }

    @Override // dc.ev3
    public void f(View view, int i) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setIncludeFontPadding(false);
            textView.setTextSize(0, i);
        }
    }
}
