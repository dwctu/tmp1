package com.wear.adapter.patterns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldRadioButton;
import dc.ah4;
import dc.be3;
import dc.hf3;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class PatternGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;
    public LayoutInflater b;
    public List<c> c = new ArrayList();
    public int d = 0;
    public RadioButton e;
    public b f;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public MediumBoldRadioButton a;
        public View b;
        public TextView c;

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
                PatternGalleryAdapter.this.notifyDataSetChanged();
                return;
            }
            PatternGalleryAdapter patternGalleryAdapter = PatternGalleryAdapter.this;
            patternGalleryAdapter.d = this.a;
            if (patternGalleryAdapter.e != null) {
                PatternGalleryAdapter.this.e.setChecked(false);
            }
            PatternGalleryAdapter.this.e = this.b.a;
            PatternGalleryAdapter.this.notifyDataSetChanged();
            PatternGalleryAdapter.this.f.a(this.b.itemView, (c) PatternGalleryAdapter.this.c.get(this.a), this.a);
        }
    }

    public interface b {
        void a(View view, c cVar, int i);
    }

    public class c {
        public String a;
        public String b;

        public c(PatternGalleryAdapter patternGalleryAdapter, String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    public PatternGalleryAdapter(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(context);
        this.c.clear();
        this.c.add(new c(this, ah4.e(R.string.common_Recommended), "Recommended"));
        this.c.add(new c(this, ah4.e(R.string.patterns_latest), "Popular"));
        this.c.add(new c(this, ah4.e(R.string.common_recent), "Recent"));
        this.c.add(new c(this, ah4.e(R.string.pattern_lovense_picks), "Pick"));
        this.c.add(new c(this, ah4.e(R.string.common_liked), "Liked"));
        this.c.add(new c(this, ah4.e(R.string.common_Mine), "Mine"));
        if (be3.D()) {
            Collections.swap(this.c, 3, 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public List<c> p() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.a.setText(this.c.get(i).a());
        boolean z = be3.D() && i == 1;
        viewHolder.c.setText(ah4.e(R.string.patterns_vday_special));
        viewHolder.c.setVisibility(z ? 0 : 8);
        if (this.d == i) {
            viewHolder.b.setVisibility(0);
            viewHolder.a.setTextColor(th4.b(this.a, R.color.select_text_color));
            viewHolder.a.setChecked(true);
        } else {
            viewHolder.b.setVisibility(8);
            viewHolder.a.setTextColor(th4.b(this.a, R.color.text_color_65));
            viewHolder.a.setChecked(false);
        }
        viewHolder.itemView.setTag(this.c.get(i).b());
        if (this.f != null) {
            viewHolder.a.setOnClickListener(new a(i, viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = this.b.inflate(R.layout.item_pattern_type_gallery, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.a = (MediumBoldRadioButton) viewInflate.findViewById(R.id.toy_type_name);
        viewHolder.b = viewInflate.findViewById(R.id.red_dot);
        viewHolder.c = (TextView) viewInflate.findViewById(R.id.tv_loves_pick_special);
        return viewHolder;
    }

    public void s(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void t(b bVar) {
        this.f = bVar;
    }
}
