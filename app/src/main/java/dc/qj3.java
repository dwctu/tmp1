package dc;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MBaseAdapter.java */
/* loaded from: classes4.dex */
public class qj3<T> extends BaseAdapter {
    public Context a;
    public ArrayList<T> b;

    public qj3(Context context, ArrayList<T> arrayList) {
        this.a = context;
        if (arrayList == null) {
            this.b = new ArrayList<>();
        } else {
            this.b = arrayList;
        }
    }

    public void a(List<T> list) {
        if (list == null) {
            return;
        }
        this.b.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<T> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
