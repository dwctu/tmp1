package com.wear.ui.discover.wishlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.response.WishListBean;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyTagAdapter extends RecyclerView.Adapter<a> {
    public List<WishListBean.DataBean.WishToyListBean> a;

    public class a extends RecyclerView.ViewHolder {
        public TextView a;

        public a(@NonNull ToyTagAdapter toyTagAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.toy_name_view);
        }
    }

    public ToyTagAdapter(List<WishListBean.DataBean.WishToyListBean> list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        aVar.a.setText(this.a.get(i).getToyName().trim());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wish_list_toy_item, viewGroup, false));
    }
}
