package com.wear.widget.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import dc.vs3;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class AutoRVAdapter extends RecyclerView.Adapter<RVHolder> {
    public List<?> a;
    public Context b;
    public c c;
    public d d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ RVHolder b;

        public a(int i, RVHolder rVHolder) {
            this.a = i;
            this.b = rVHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoRVAdapter.this.c.a(this.a, this.b);
        }
    }

    public class b implements View.OnLongClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ RVHolder b;

        public b(int i, RVHolder rVHolder) {
            this.a = i;
            this.b = rVHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AutoRVAdapter.this.d.a(this.a, this.b);
            return true;
        }
    }

    public interface c {
        void a(int i, RVHolder rVHolder);
    }

    public interface d {
        void a(int i, RVHolder rVHolder);
    }

    public AutoRVAdapter(Context context, List<?> list) {
        this.a = list;
        this.b = context;
    }

    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<?> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RVHolder rVHolder, int i) {
        o(rVHolder.a(), i);
        if (this.c != null) {
            rVHolder.itemView.setOnClickListener(new a(i, rVHolder));
        }
        if (this.d != null) {
            rVHolder.itemView.setOnLongClickListener(new b(i, rVHolder));
        }
    }

    public abstract void o(vs3 vs3Var, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public RVHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RVHolder(LayoutInflater.from(this.b).inflate(q(i), viewGroup, false));
    }

    public abstract int q(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(RVHolder rVHolder) {
        super.onViewRecycled(rVHolder);
    }

    public abstract void s(String str);

    public void t(c cVar) {
        this.c = cVar;
    }

    public void u(d dVar) {
        this.d = dVar;
    }
}
