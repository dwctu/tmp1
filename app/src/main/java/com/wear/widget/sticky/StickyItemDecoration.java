package com.wear.widget.sticky;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import dc.et3;

/* loaded from: classes4.dex */
public class StickyItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;
    public int[] d;
    public RecyclerView.Adapter e;
    public StickyHeadContainer f;
    public boolean g = true;
    public et3 h;

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            StickyItemDecoration.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            StickyItemDecoration.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            StickyItemDecoration.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            StickyItemDecoration.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            StickyItemDecoration.this.h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            StickyItemDecoration.this.h();
        }
    }

    public StickyItemDecoration(StickyHeadContainer stickyHeadContainer, int i) {
        this.f = stickyHeadContainer;
        this.a = i;
    }

    public final void b(RecyclerView recyclerView) {
        int iD = d(recyclerView.getLayoutManager());
        this.b = iD;
        int iE = e(iD);
        if (iE < 0 || this.c == iE) {
            return;
        }
        this.c = iE;
    }

    public final void c(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (this.e != adapter) {
            this.e = adapter;
            this.c = -1;
            adapter.registerAdapterDataObserver(new a());
        }
    }

    public final int d(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        this.d = iArr;
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        int iMin = Integer.MAX_VALUE;
        for (int i : this.d) {
            iMin = Math.min(i, iMin);
        }
        return iMin;
    }

    public final int e(int i) {
        while (i >= 0) {
            if (g(this.e.getItemViewType(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public final boolean f(RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return false;
        }
        return g(this.e.getItemViewType(childAdapterPosition));
    }

    public final boolean g(int i) {
        return this.a == i;
    }

    public final void h() {
        this.f.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        c(recyclerView);
        if (this.e == null) {
            return;
        }
        b(recyclerView);
        if (this.g) {
            int i = this.b;
            int i2 = this.c;
            if (i >= i2 && i2 != -1) {
                View viewFindChildViewUnder = recyclerView.findChildViewUnder(canvas.getWidth() / 2, this.f.getChildHeight() + 0.01f);
                this.f.a(this.c);
                int top = (!f(recyclerView, viewFindChildViewUnder) || viewFindChildViewUnder.getTop() <= 0) ? 0 : viewFindChildViewUnder.getTop() - this.f.getChildHeight();
                et3 et3Var = this.h;
                if (et3Var != null) {
                    et3Var.b(top);
                    return;
                }
                return;
            }
        }
        et3 et3Var2 = this.h;
        if (et3Var2 != null) {
            et3Var2.a();
        }
    }
}
