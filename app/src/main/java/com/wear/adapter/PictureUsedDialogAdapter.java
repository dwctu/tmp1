package com.wear.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.PictureUsedBean;
import com.wear.util.WearUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class PictureUsedDialogAdapter extends RecyclerView.Adapter {
    public LayoutInflater a;
    public List<PictureUsedBean> b;
    public b c;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView a;
        public ImageView b;

        public ViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.used_tv);
            this.b = (ImageView) view.findViewById(R.id.share_iv);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PictureUsedDialogAdapter.this.c.a(this.a);
        }
    }

    public interface b {
        void a(int i);
    }

    public PictureUsedDialogAdapter(Context context, List<PictureUsedBean> list) {
        this.a = null;
        this.b = list;
        this.a = LayoutInflater.from(WearUtils.x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void m(b bVar) {
        this.c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (i == 3 && this.b.get(i).isHidden()) {
            viewHolder2.b.setImageResource(R.drawable.light_nav_add_unhide);
            viewHolder2.a.setText(R.string.comman_unhide);
        } else {
            viewHolder2.b.setImageResource(this.b.get(i).getUserImg());
            viewHolder2.a.setText(this.b.get(i).getUsedName());
        }
        viewHolder2.itemView.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this.a.inflate(R.layout.item_picture_view, viewGroup, false));
    }
}
