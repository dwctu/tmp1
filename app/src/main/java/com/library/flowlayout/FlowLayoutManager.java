package com.library.flowlayout;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final FlowLayoutManager a = this;
    public int g = 0;
    public int h = 0;
    public b i = new b(this);
    public List<b> j = new ArrayList();
    public SparseArray<Rect> k = new SparseArray<>();

    public class a {
        public int a;
        public View b;
        public Rect c;

        public a(FlowLayoutManager flowLayoutManager, int i, View view, Rect rect) {
            this.a = i;
            this.b = view;
            this.c = rect;
        }

        public void a(Rect rect) {
            this.c = rect;
        }
    }

    public class b {
        public float a;
        public float b;
        public List<a> c = new ArrayList();

        public b(FlowLayoutManager flowLayoutManager) {
        }

        public void a(a aVar) {
            this.c.add(aVar);
        }

        public void b(float f) {
            this.a = f;
        }

        public void c(float f) {
            this.b = f;
        }
    }

    public FlowLayoutManager() {
        setAutoMeasureEnabled(true);
    }

    public final void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.g, getWidth() - getPaddingRight(), this.g + (getHeight() - getPaddingBottom()));
        for (int i = 0; i < this.j.size(); i++) {
            b bVar = this.j.get(i);
            float f = bVar.a;
            float f2 = bVar.b;
            List<a> list = bVar.c;
            for (int i2 = 0; i2 < list.size(); i2++) {
                View view = list.get(i2).b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i2).c;
                int i3 = rect.left;
                int i4 = rect.top;
                int i5 = this.g;
                layoutDecoratedWithMargins(view, i3, i4 - i5, rect.right, rect.bottom - i5);
            }
        }
    }

    public final void b() {
        List<a> list = this.i.c;
        for (int i = 0; i < list.size(); i++) {
            a aVar = list.get(i);
            int position = getPosition(aVar.b);
            float f = this.k.get(position).top;
            b bVar = this.i;
            if (f < bVar.a + ((bVar.b - list.get(i).a) / 2.0f)) {
                Rect rect = this.k.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i2 = this.k.get(position).left;
                b bVar2 = this.i;
                int i3 = (int) (bVar2.a + ((bVar2.b - list.get(i).a) / 2.0f));
                int i4 = this.k.get(position).right;
                b bVar3 = this.i;
                rect.set(i2, i3, i4, (int) (bVar3.a + ((bVar3.b - list.get(i).a) / 2.0f) + getDecoratedMeasuredHeight(r3)));
                this.k.put(position, rect);
                aVar.a(rect);
                list.set(i, aVar);
            }
        }
        b bVar4 = this.i;
        bVar4.c = list;
        this.j.add(bVar4);
        this.i = new b(this);
    }

    public int c() {
        return this.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    public final int d() {
        return (this.a.getHeight() - this.a.getPaddingBottom()) - this.a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.h = 0;
        int i = this.d;
        this.i = new b(this);
        this.j.clear();
        this.k.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.g = 0;
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        if (getChildCount() == 0) {
            this.b = getWidth();
            getHeight();
            this.c = getPaddingLeft();
            this.e = getPaddingRight();
            this.d = getPaddingTop();
            this.f = (this.b - this.c) - this.e;
        }
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            String str = "index:" + i3;
            View viewForPosition = recycler.getViewForPosition(i3);
            if (8 != viewForPosition.getVisibility()) {
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int i4 = i2 + decoratedMeasuredWidth;
                if (i4 <= this.f) {
                    int i5 = this.c + i2;
                    Rect rect = this.k.get(i3);
                    if (rect == null) {
                        rect = new Rect();
                    }
                    rect.set(i5, i, decoratedMeasuredWidth + i5, i + decoratedMeasuredHeight);
                    this.k.put(i3, rect);
                    iMax = Math.max(iMax, decoratedMeasuredHeight);
                    this.i.a(new a(this, decoratedMeasuredHeight, viewForPosition, rect));
                    this.i.b(i);
                    this.i.c(iMax);
                    i2 = i4;
                } else {
                    b();
                    i += iMax;
                    this.h += iMax;
                    int i6 = this.c;
                    Rect rect2 = this.k.get(i3);
                    if (rect2 == null) {
                        rect2 = new Rect();
                    }
                    rect2.set(i6, i, i6 + decoratedMeasuredWidth, i + decoratedMeasuredHeight);
                    this.k.put(i3, rect2);
                    this.i.a(new a(this, decoratedMeasuredHeight, viewForPosition, rect2));
                    this.i.b(i);
                    this.i.c(decoratedMeasuredHeight);
                    i2 = decoratedMeasuredWidth;
                    iMax = decoratedMeasuredHeight;
                }
                if (i3 == getItemCount() - 1) {
                    b();
                    this.h += iMax;
                }
            }
        }
        this.h = Math.max(this.h, d());
        String str2 = "onLayoutChildren totalHeight:" + this.h;
        a(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        String str = "totalHeight:" + this.h;
        int i2 = this.g;
        if (i2 + i < 0) {
            i = -i2;
        } else if (i2 + i > this.h - d()) {
            i = (this.h - d()) - this.g;
        }
        this.g += i;
        offsetChildrenVertical(-i);
        a(recycler, state);
        return i;
    }
}
