package dc;

import android.util.SparseArray;
import android.view.View;

/* compiled from: ViewHolder.java */
/* loaded from: classes4.dex */
public class vs3 {
    public SparseArray<View> a;
    public View b;

    public vs3(View view) {
        this.b = view;
        SparseArray<View> sparseArray = new SparseArray<>();
        this.a = sparseArray;
        view.setTag(sparseArray);
    }

    public static vs3 b(View view) {
        vs3 vs3Var = (vs3) view.getTag();
        if (vs3Var != null) {
            return vs3Var;
        }
        vs3 vs3Var2 = new vs3(view);
        view.setTag(vs3Var2);
        return vs3Var2;
    }

    public <T extends View> T a(int i) {
        T t = (T) this.a.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.b.findViewById(i);
        this.a.put(i, t2);
        return t2;
    }
}
