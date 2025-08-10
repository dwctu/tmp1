package com.wear.adapter.toy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.main.toy.AddVirtualToyActivity;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyAddVirtualAdapter extends RecyclerView.Adapter<ToyHolder> {
    public AddVirtualToyActivity a;
    public List<ToyConfigInfoBean> b;

    public class ToyHolder extends RecyclerView.ViewHolder {
        public TextView a;
        public LinearLayout b;

        public ToyHolder(@NonNull ToyAddVirtualAdapter toyAddVirtualAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_toy_name);
            this.b = (LinearLayout) view.findViewById(R.id.item_view);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ ToyConfigInfoBean a;

        public a(ToyConfigInfoBean toyConfigInfoBean) {
            this.a = toyConfigInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyAddVirtualAdapter.this.a.s4(this.a);
        }
    }

    public ToyAddVirtualAdapter(AddVirtualToyActivity addVirtualToyActivity, List<ToyConfigInfoBean> list) {
        this.a = addVirtualToyActivity;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ToyConfigInfoBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ToyHolder toyHolder, int i) {
        ToyConfigInfoBean toyConfigInfoBean = this.b.get(i);
        toyHolder.a.setText(toyConfigInfoBean.getShowName());
        toyHolder.b.setOnClickListener(new a(toyConfigInfoBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ToyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ToyHolder(this, LayoutInflater.from(this.a).inflate(R.layout.item_add_virtual_toy, viewGroup, false));
    }
}
