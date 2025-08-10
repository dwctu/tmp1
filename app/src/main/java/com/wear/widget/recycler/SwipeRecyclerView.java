package com.wear.widget.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.lovense.wear.R;
import com.wear.widget.recycler.footerView.BaseFooterView;
import com.wear.widget.recycler.footerView.SimpleFooterView;

/* loaded from: classes4.dex */
public class SwipeRecyclerView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {
    public View a;
    public BaseFooterView b;
    public RecyclerView c;
    public SwipeRefreshLayout d;
    public RecyclerView.LayoutManager e;
    public d f;
    public GridLayoutManager.SpanSizeLookup g;
    public b h;
    public e i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public RecyclerView.Adapter o;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (!SwipeRecyclerView.this.l || SwipeRecyclerView.this.r() || SwipeRecyclerView.this.k) {
                return;
            }
            SwipeRecyclerView.this.e = recyclerView.getLayoutManager();
            if (SwipeRecyclerView.this.e instanceof LinearLayoutManager) {
                SwipeRecyclerView swipeRecyclerView = SwipeRecyclerView.this;
                swipeRecyclerView.n = ((LinearLayoutManager) swipeRecyclerView.e).findLastVisibleItemPosition();
            } else if (SwipeRecyclerView.this.e instanceof GridLayoutManager) {
                SwipeRecyclerView swipeRecyclerView2 = SwipeRecyclerView.this;
                swipeRecyclerView2.n = ((GridLayoutManager) swipeRecyclerView2.e).findLastCompletelyVisibleItemPosition();
            } else if (SwipeRecyclerView.this.e instanceof StaggeredGridLayoutManager) {
                int[] iArr = new int[((StaggeredGridLayoutManager) SwipeRecyclerView.this.e).getSpanCount()];
                ((StaggeredGridLayoutManager) SwipeRecyclerView.this.e).findLastVisibleItemPositions(iArr);
                SwipeRecyclerView swipeRecyclerView3 = SwipeRecyclerView.this;
                swipeRecyclerView3.n = swipeRecyclerView3.q(iArr);
            }
            int itemCount = SwipeRecyclerView.this.i == null ? 0 : SwipeRecyclerView.this.i.getItemCount();
            if (itemCount <= 1 || SwipeRecyclerView.this.n != itemCount - 1 || SwipeRecyclerView.this.f == null) {
                return;
            }
            SwipeRecyclerView.this.k = true;
            SwipeRecyclerView.this.f.a();
        }
    }

    public class b extends RecyclerView.AdapterDataObserver {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            RecyclerView.Adapter adapter = SwipeRecyclerView.this.c.getAdapter();
            if (adapter != null && SwipeRecyclerView.this.a != null) {
                if (adapter.getItemCount() == ((!SwipeRecyclerView.this.l || adapter.getItemCount() == 0) ? 0 : 1)) {
                    SwipeRecyclerView.this.j = true;
                    if (SwipeRecyclerView.this.a.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        SwipeRecyclerView swipeRecyclerView = SwipeRecyclerView.this;
                        swipeRecyclerView.addView(swipeRecyclerView.a, layoutParams);
                    }
                    SwipeRecyclerView.this.c.setVisibility(8);
                    SwipeRecyclerView.this.a.setVisibility(0);
                } else {
                    SwipeRecyclerView.this.j = false;
                    SwipeRecyclerView.this.a.setVisibility(8);
                    SwipeRecyclerView.this.c.setVisibility(0);
                }
            }
            SwipeRecyclerView.this.i.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            SwipeRecyclerView.this.i.notifyItemRangeChanged(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            SwipeRecyclerView.this.i.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            SwipeRecyclerView.this.i.notifyItemRangeRemoved(i, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            SwipeRecyclerView.this.i.notifyItemRangeRemoved(i, i2);
        }
    }

    public class c extends RecyclerView.ViewHolder {
        public c(SwipeRecyclerView swipeRecyclerView, View view) {
            super(view);
        }
    }

    public interface d {
        void a();

        void onRefresh();
    }

    public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public RecyclerView.Adapter<RecyclerView.ViewHolder> a;

        public class a extends GridLayoutManager.SpanSizeLookup {
            public final /* synthetic */ GridLayoutManager a;

            public a(GridLayoutManager gridLayoutManager) {
                this.a = gridLayoutManager;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                boolean zL = e.this.l(i);
                if (SwipeRecyclerView.this.g != null && !zL) {
                    return SwipeRecyclerView.this.g.getSpanSize(i);
                }
                if (zL) {
                    return this.a.getSpanCount();
                }
                return 1;
            }
        }

        public e(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
            this.a = adapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.a;
            int itemCount = adapter == null ? 0 : adapter.getItemCount();
            if (itemCount == 0) {
                return 0;
            }
            return SwipeRecyclerView.this.l ? itemCount + 1 : itemCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.a.getItemId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (l(i)) {
                return 256;
            }
            return this.a.getItemViewType(i);
        }

        public boolean l(int i) {
            return SwipeRecyclerView.this.l && i == getItemCount() - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
            }
            this.a.onAttachedToRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (l(i)) {
                return;
            }
            this.a.onBindViewHolder(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (256 != i) {
                return this.a.onCreateViewHolder(viewGroup, i);
            }
            SwipeRecyclerView swipeRecyclerView = SwipeRecyclerView.this;
            return new c(swipeRecyclerView, swipeRecyclerView.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            this.a.onDetachedFromRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
            return this.a.onFailedToRecycleView(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && l(viewHolder.getLayoutPosition())) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            this.a.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            this.a.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder instanceof RVHolder) {
                this.a.onViewRecycled(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.a.registerAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.a.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    public boolean getLoadMoreEnable() {
        return this.l;
    }

    public RecyclerView getRecyclerView() {
        return this.c;
    }

    public boolean getRefreshEnable() {
        return this.m;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return this.d;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (this.f != null) {
            BaseFooterView baseFooterView = this.b;
            if (baseFooterView != null) {
                baseFooterView.a();
            }
            this.f.onRefresh();
        }
    }

    public void p() {
        this.d.setRefreshing(false);
        w();
    }

    public final int q(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public boolean r() {
        return this.d.isRefreshing();
    }

    public void s() {
        this.i.notifyDataSetChanged();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            if (this.h == null) {
                this.h = new b();
            }
            e eVar = new e(adapter);
            this.i = eVar;
            this.c.setAdapter(eVar);
            adapter.registerAdapterDataObserver(this.h);
            this.h.onChanged();
        }
        this.o = adapter;
    }

    public void setAdapterSimple(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            x(adapter);
            e eVar = new e(adapter);
            this.i = eVar;
            this.c.setAdapter(eVar);
            u(adapter);
            this.h.onChanged();
        }
        this.o = adapter;
    }

    public void setEmptyView(View view) {
        View view2 = this.a;
        if (view2 != null) {
            removeView(view2);
        }
        this.a = view;
        b bVar = this.h;
        if (bVar != null) {
            bVar.onChanged();
        }
    }

    public void setFooterView(BaseFooterView baseFooterView) {
        if (baseFooterView != null) {
            this.b = baseFooterView;
        }
    }

    public void setLoadMoreEnable(boolean z) {
        if (!z) {
            w();
        }
        this.l = z;
    }

    public void setOnLoadListener(d dVar) {
        this.f = dVar;
    }

    public void setRefreshEnable(boolean z) {
        this.m = z;
        this.d.setEnabled(z);
    }

    public void setRefreshing(boolean z) {
        d dVar;
        this.d.setRefreshing(z);
        if (!z || this.k || (dVar = this.f) == null) {
            return;
        }
        dVar.onRefresh();
    }

    public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.g = spanSizeLookup;
    }

    public void t(int i) {
        this.o.notifyItemChanged(i);
    }

    public void u(RecyclerView.Adapter adapter) {
        if (this.h == null) {
            this.h = new b();
        }
        adapter.registerAdapterDataObserver(this.h);
    }

    public final void v() {
        this.m = true;
        this.k = false;
        this.l = true;
        this.b = new SimpleFooterView(getContext());
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_swipe_recyclerview, this);
        this.d = (SwipeRefreshLayout) viewInflate.findViewById(R.id.swipeRefresh);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recyclerView);
        this.c = recyclerView;
        this.e = recyclerView.getLayoutManager();
        this.d.setOnRefreshListener(this);
        RecyclerView.ItemAnimator itemAnimator = this.c.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.c.setOnScrollListener(new a());
    }

    public void w() {
        this.k = false;
        e eVar = this.i;
        if (eVar != null) {
            eVar.notifyItemRemoved(eVar.getItemCount());
        }
    }

    public void x(RecyclerView.Adapter adapter) {
        b bVar = this.h;
        if (bVar != null) {
            adapter.unregisterAdapterDataObserver(bVar);
        }
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0;
        this.o = null;
        v();
    }
}
