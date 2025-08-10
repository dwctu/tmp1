package dc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AutoLayoutInfo.java */
/* loaded from: classes4.dex */
public class cv3 {
    public List<ev3> a = new ArrayList();

    public static cv3 c(View view, int i, int i2) {
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        cv3 cv3Var = new cv3();
        if ((i & 1) != 0 && (i4 = layoutParams.width) > 0) {
            cv3Var.a(vv3.j(i4, i2));
        }
        if ((i & 2) != 0 && (i3 = layoutParams.height) > 0) {
            cv3Var.a(fv3.j(i3, i2));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if ((i & 16) != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                cv3Var.a(iv3.j(marginLayoutParams.leftMargin, i2));
                cv3Var.a(kv3.j(marginLayoutParams.topMargin, i2));
                cv3Var.a(jv3.j(marginLayoutParams.rightMargin, i2));
                cv3Var.a(hv3.j(marginLayoutParams.bottomMargin, i2));
            }
            if ((i & 32) != 0) {
                cv3Var.a(iv3.j(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2));
            }
            if ((i & 64) != 0) {
                cv3Var.a(kv3.j(((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i2));
            }
            if ((i & 128) != 0) {
                cv3Var.a(jv3.j(((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i2));
            }
            if ((i & 256) != 0) {
                cv3Var.a(hv3.j(((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, i2));
            }
        }
        if ((i & 8) != 0) {
            cv3Var.a(rv3.j(view.getPaddingLeft(), i2));
            cv3Var.a(tv3.j(view.getPaddingTop(), i2));
            cv3Var.a(sv3.j(view.getPaddingRight(), i2));
            cv3Var.a(qv3.j(view.getPaddingBottom(), i2));
        }
        if ((i & 512) != 0) {
            cv3Var.a(iv3.j(view.getPaddingLeft(), i2));
        }
        if ((i & 1024) != 0) {
            cv3Var.a(kv3.j(view.getPaddingTop(), i2));
        }
        if ((i & 2048) != 0) {
            cv3Var.a(jv3.j(view.getPaddingRight(), i2));
        }
        if ((i & 4096) != 0) {
            cv3Var.a(hv3.j(view.getPaddingBottom(), i2));
        }
        if ((i & 8192) != 0) {
            cv3Var.a(ov3.j(ov3.k(view), i2));
        }
        if ((i & 16384) != 0) {
            cv3Var.a(mv3.j(mv3.k(view), i2));
        }
        if ((32768 & i) != 0) {
            cv3Var.a(nv3.j(nv3.k(view), i2));
        }
        if ((65536 & i) != 0) {
            cv3Var.a(lv3.j(lv3.k(view), i2));
        }
        if ((view instanceof TextView) && (i & 4) != 0) {
            cv3Var.a(uv3.j((int) ((TextView) view).getTextSize(), i2));
        }
        return cv3Var;
    }

    public void a(ev3 ev3Var) {
        this.a.add(ev3Var);
    }

    public void b(View view) {
        Iterator<ev3> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
    }

    public String toString() {
        return "AutoLayoutInfo{autoAttrs=" + this.a + MessageFormatter.DELIM_STOP;
    }
}
