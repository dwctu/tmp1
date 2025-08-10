package dc;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: ViewHolder.java */
/* loaded from: classes3.dex */
public class wj1 {
    public SparseArray<View> a = new SparseArray<>();
    public View b;

    public wj1(Context context, ViewGroup viewGroup, int i, int i2) {
        View viewInflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
        this.b = viewInflate;
        viewInflate.setTag(this);
    }

    public static wj1 c(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        return view == null ? new wj1(context, viewGroup, i, i2) : (wj1) view.getTag();
    }

    public View a() {
        return this.b;
    }

    public <T extends View> T b(int i) {
        T t = (T) this.a.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.b.findViewById(i);
        this.a.put(i, t2);
        return t2;
    }

    public wj1 d(int i, CharSequence charSequence) {
        ((TextView) b(i)).setText(charSequence);
        return this;
    }
}
