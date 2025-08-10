package dc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* compiled from: MyBaseAdapter.java */
/* loaded from: classes3.dex */
public abstract class vj1<T> extends BaseAdapter {
    public List<T> a;
    public Context b;
    public int c;

    public vj1(List<T> list, Context context, int i) {
        this.a = list;
        this.b = context;
        this.c = i;
    }

    public boolean a() {
        return true;
    }

    public abstract void b(wj1 wj1Var, T t, int i);

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        wj1 wj1VarC = a() ? wj1.c(this.b, view, viewGroup, this.c, i) : wj1.c(this.b, null, viewGroup, this.c, i);
        b(wj1VarC, this.a.get(i), i);
        return wj1VarC.a();
    }
}
