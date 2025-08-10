package com.wear.main.closeRange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class PatternPlaySpeedOptionsAdapter extends RecyclerView.Adapter<b> {
    public double[] a;
    public String b;
    public a c = null;

    public interface a {
        void a(double d, int i);
    }

    public class b extends RecyclerView.ViewHolder {
        public TextView a;
        public ConstraintLayout b;
        public ImageView c;

        public b(@NonNull PatternPlaySpeedOptionsAdapter patternPlaySpeedOptionsAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.speed_text_view);
            this.b = (ConstraintLayout) view.findViewById(R.id.item_layout);
            this.c = (ImageView) view.findViewById(R.id.ic_check);
        }
    }

    public PatternPlaySpeedOptionsAdapter(double[] dArr, String str) {
        this.a = null;
        this.b = "1";
        this.a = dArr;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(double d, int i, View view) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(d, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, final int i) {
        final double d = this.a[i];
        String str = d + "";
        if (d > 1.0d) {
            str = ((int) d) + "";
        }
        if (d == 1.0d) {
            str = bVar.a.getContext().getString(R.string.common_pattern_speed_normal) + " " + str;
        }
        if (i == Integer.parseInt(this.b)) {
            bVar.c.setVisibility(0);
        } else {
            bVar.c.setVisibility(8);
        }
        bVar.a.setText(str + "x");
        bVar.b.setOnClickListener(new View.OnClickListener() { // from class: dc.s02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m(d, i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pattern_speed_item_layout, viewGroup, false));
    }

    public void p(a aVar) {
        this.c = aVar;
    }
}
