package com.wear.adapter.patterns;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.hf3;
import dc.sg3;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    public LayoutInflater a;
    public List<c> b;
    public int c;
    public RadioButton d;
    public b e;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RadioButton a;

        public ViewHolder(View view) {
            super(view);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ ViewHolder b;

        public a(int i, ViewHolder viewHolder) {
            this.a = i;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hf3.d(WearUtils.x)) {
                sg3.h(R.string.net_connect_error_tip);
                ToyGalleryAdapter.this.notifyDataSetChanged();
                return;
            }
            ToyGalleryAdapter toyGalleryAdapter = ToyGalleryAdapter.this;
            toyGalleryAdapter.c = this.a;
            if (toyGalleryAdapter.d != null) {
                ToyGalleryAdapter.this.d.setChecked(false);
            }
            ToyGalleryAdapter.this.d = this.b.a;
            ToyGalleryAdapter.this.notifyDataSetChanged();
            ToyGalleryAdapter.this.e.a(this.b.itemView, (c) ToyGalleryAdapter.this.b.get(this.a), this.a);
        }
    }

    public interface b {
        void a(View view, c cVar, int i);
    }

    public class c {
        public String a;
        public String b;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.a.setText(this.b.get(i).a());
        if (this.c == i) {
            viewHolder.a.setChecked(true);
        } else {
            viewHolder.a.setChecked(false);
        }
        viewHolder.itemView.setTag(this.b.get(i).b());
        if (this.e != null) {
            viewHolder.a.setOnClickListener(new a(i, viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = this.a.inflate(R.layout.item_toy_type_gallery, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.a = (RadioButton) viewInflate.findViewById(R.id.toy_type_name);
        return viewHolder;
    }
}
