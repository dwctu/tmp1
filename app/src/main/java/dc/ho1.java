package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MusicSearchAdapter.java */
/* loaded from: classes3.dex */
public class ho1 extends BaseAdapter {
    public Context a;
    public LayoutInflater b;
    public List<a> c = new ArrayList();

    /* compiled from: MusicSearchAdapter.java */
    public class a {
        public String a;

        public a(ho1 ho1Var, String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    /* compiled from: MusicSearchAdapter.java */
    public class b {
        public TextView a;

        public b(ho1 ho1Var) {
        }
    }

    public ho1(Context context) {
        this.b = null;
        this.a = context;
        this.b = LayoutInflater.from(context);
        String strH = eg3.h(context, "music_search_histroys", "");
        if (WearUtils.e1(strH)) {
            return;
        }
        for (String str : strH.split("\\$#\\|#\\$")) {
            this.c.add(new a(this, str));
        }
    }

    public void a(String str) {
        if (this.c.size() <= 0 || !this.c.get(0).a().equals(str)) {
            if (this.c.size() > 5) {
                this.c.remove(r0.size() - 1);
            }
            this.c.add(0, new a(this, str));
            Iterator<a> it = this.c.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + it.next().a() + "$#|#$";
            }
            if (str2.length() > 0) {
                eg3.i(this.a, "music_search_histroys", str2.substring(0, str2.length() - 5));
            }
            notifyDataSetChanged();
        }
    }

    public void b() {
        this.c.clear();
        eg3.i(this.a, "music_search_histroys", "");
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        a item = getItem(i);
        if (view == null) {
            bVar = new b(this);
            viewInflate = this.b.inflate(R.layout.music_search_histroy_item, (ViewGroup) null);
            bVar.a = (TextView) viewInflate.findViewById(R.id.music_histroy_text);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.a.setText(item.a());
        return viewInflate;
    }
}
