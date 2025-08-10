package dc;

import java.util.List;

/* compiled from: ArrayWheelAdapter.java */
/* loaded from: classes.dex */
public class te<T> implements ve {
    public List<T> a;

    public te(List<T> list, int i) {
        this.a = list;
    }

    @Override // dc.ve
    public int a() {
        return this.a.size();
    }

    @Override // dc.ve
    public Object getItem(int i) {
        return (i < 0 || i >= this.a.size()) ? "" : this.a.get(i);
    }

    @Override // dc.ve
    public int indexOf(Object obj) {
        return this.a.indexOf(obj);
    }

    public te(List<T> list) {
        this(list, 4);
    }
}
