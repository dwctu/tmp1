package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* loaded from: classes.dex */
public class SkeletonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public int f;

    public class a extends RecyclerView.ViewHolder {
        public a(SkeletonAdapter skeletonAdapter, View view) {
            super(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a;
    }

    public void l(int i) {
        this.a = i;
    }

    public void m(int i) {
        this.b = i;
    }

    public void n(@IntRange(from = 0, to = 30) int i) {
        this.f = i;
    }

    public void o(int i) {
        this.c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.d) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) viewHolder.itemView;
            shimmerLayout.setShimmerAnimationDuration(this.e);
            shimmerLayout.setShimmerAngle(this.f);
            shimmerLayout.setShimmerColor(this.c);
            shimmerLayout.n();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        return this.d ? new ShimmerViewHolder(layoutInflaterFrom, viewGroup, this.b) : new a(this, layoutInflaterFrom.inflate(this.b, viewGroup, false));
    }

    public void p(int i) {
        this.e = i;
    }

    public void q(boolean z) {
        this.d = z;
    }
}
