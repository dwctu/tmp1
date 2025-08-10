package com.wear.adapter.patterns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.PatternFilterToyBean;
import dc.th4;
import dc.uu1;
import java.util.List;

/* loaded from: classes3.dex */
public class PatternFilterToyAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<PatternFilterToyBean> a;
    public Context b;
    public LayoutInflater c;
    public b d;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public ViewHolder(View view) {
            super(view);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ PatternFilterToyBean a;
        public final /* synthetic */ int b;

        public a(PatternFilterToyBean patternFilterToyBean, int i) {
            this.a = patternFilterToyBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PatternFilterToyAdapter.this.d != null) {
                PatternFilterToyAdapter.this.d.a(this.a, this.b);
            }
        }
    }

    public interface b {
        void a(PatternFilterToyBean patternFilterToyBean, int i);
    }

    public PatternFilterToyAdapter(Context context, List<PatternFilterToyBean> list) {
        this.b = context;
        this.c = LayoutInflater.from(context);
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PatternFilterToyBean patternFilterToyBean = this.a.get(i);
        viewHolder.a.setText(uu1.a(patternFilterToyBean.getToyName(), 1));
        if (patternFilterToyBean.isSelect()) {
            viewHolder.a.setBackground(th4.d(this.b, R.drawable.shape_pattern_filter_select));
            viewHolder.a.setTextColor(th4.b(this.b, R.color.white));
        } else {
            viewHolder.a.setBackground(th4.d(this.b, R.drawable.shape_pattern_filter));
            viewHolder.a.setTextColor(th4.b(this.b, R.color.text_color_b45_wo));
        }
        viewHolder.a.setOnClickListener(new a(patternFilterToyBean, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = this.c.inflate(R.layout.item_pattern_filter_pop_toy_tag, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.a = (TextView) viewInflate.findViewById(R.id.tv_tag);
        return viewHolder;
    }

    public void o(b bVar) {
        this.d = bVar;
    }
}
