package com.wear.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import dc.yv3;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    public b a;
    public List<T> b;
    public Context c;

    @DrawableRes
    public int f;
    public CharSequence g;
    public int h;
    public boolean e = false;
    public boolean i = false;
    public HashMap<Integer, Integer> d = new HashMap<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SparseArray<View> a;
        public int b;

        public ViewHolder(@NonNull View view, int i) {
            super(view);
            this.a = new SparseArray<>();
            this.b = i;
        }

        public ViewHolder a(int i, CharSequence charSequence) {
            ((TextView) getView(i)).setText(charSequence);
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View getView(int i) {
            View view = this.a.get(i);
            if (view != null) {
                return view;
            }
            View viewFindViewById = this.itemView.findViewById(i);
            this.a.put(i, viewFindViewById);
            return viewFindViewById;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseAdapter.this.e) {
                return;
            }
            int size = BaseAdapter.this.b.size();
            int i = this.a;
            if (size > i) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.a.a0(baseAdapter.b.get(i), this.a, view);
            }
        }
    }

    public interface b<T> {
        void a0(T t, int i, View view);
    }

    public BaseAdapter(List<T> list, int i) {
        this.b = list;
        q();
        if (!m()) {
            this.d.put(-1, Integer.valueOf(R.layout.view_recyclerview_no_data));
        }
        this.d.put(0, Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.b;
        return (list == null || list.size() == 0) ? this.i ? 1 : 0 : this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        List<T> list = this.b;
        if ((list == null || list.size() == 0) && this.i) {
            return -1;
        }
        return n(i);
    }

    public boolean m() {
        return false;
    }

    public int n(int i) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int i2 = viewHolder.b;
        if (i2 != -1) {
            if (i2 != 0) {
                v(viewHolder, this.b.get(i), i);
                return;
            }
            y(viewHolder, this.b.get(i), i);
            if (this.a == null || this.e) {
                return;
            }
            viewHolder.itemView.setOnClickListener(new a(i));
            return;
        }
        if (m()) {
            u(viewHolder);
            return;
        }
        ((ImageView) viewHolder.getView(R.id.iv_img)).setImageResource(this.f);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_text);
        textView.setText(this.g);
        int i3 = this.h;
        if (i3 != 0) {
            textView.setTextColor(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.c = viewGroup.getContext();
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.d.get(Integer.valueOf(i)).intValue(), viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate, i);
        yv3.a(viewInflate);
        return viewHolder;
    }

    public void q() {
    }

    public void r(int i) {
        try {
            this.b.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, this.b.size() - i);
        } catch (Exception e) {
            e.printStackTrace();
            notifyDataSetChanged();
        }
    }

    public void s(b<T> bVar) {
        this.a = bVar;
    }

    public BaseAdapter t(CharSequence charSequence) {
        this.g = charSequence;
        this.i = true;
        return this;
    }

    public void u(ViewHolder viewHolder) {
    }

    public void v(ViewHolder viewHolder, T t, int i) {
    }

    public void w(boolean z) {
        this.i = z;
    }

    public BaseAdapter x(int i) {
        this.h = i;
        return this;
    }

    public abstract void y(ViewHolder viewHolder, T t, int i);
}
