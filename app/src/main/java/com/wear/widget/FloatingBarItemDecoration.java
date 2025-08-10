package com.wear.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;

/* loaded from: classes4.dex */
public class FloatingBarItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public Paint b;
    public Paint c;
    public int d;
    public int e;
    public int f;
    public Map<Integer, String> g;

    public final void a(Canvas canvas, int i, int i2, View view, RecyclerView.LayoutParams layoutParams, int i3) {
        canvas.drawRect(i, r0 - this.a, i2, view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, this.b);
        canvas.drawText(this.g.get(Integer.valueOf(i3)), view.getPaddingLeft() + this.f, (r0 - ((this.a - this.d) / 2)) - this.e, this.c);
    }

    public final String b(int i) {
        while (i >= 0) {
            if (this.g.containsKey(Integer.valueOf(i))) {
                return this.g.get(Integer.valueOf(i));
            }
            i--;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, this.g.containsKey(Integer.valueOf(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition())) ? this.a : 0, 0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewAdapterPosition = layoutParams.getViewAdapterPosition();
            if (this.g.containsKey(Integer.valueOf(viewAdapterPosition))) {
                a(canvas, paddingLeft, width, childAt, layoutParams, viewAdapterPosition);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        View view = recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition).itemView;
        String strB = b(iFindFirstVisibleItemPosition);
        if (strB == null) {
            return;
        }
        boolean z = false;
        int i = iFindFirstVisibleItemPosition + 1;
        if (b(i) != null && !strB.equals(b(i)) && view.getHeight() + view.getTop() < this.a) {
            canvas.save();
            canvas.translate(0.0f, (view.getHeight() + view.getTop()) - this.a);
            z = true;
        }
        canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.a, this.b);
        float paddingLeft = view.getPaddingLeft() + this.f;
        int paddingTop = recyclerView.getPaddingTop();
        int i2 = this.a;
        canvas.drawText(strB, paddingLeft, ((paddingTop + i2) - ((i2 - this.d) / 2)) - this.e, this.c);
        if (z) {
            canvas.restore();
        }
    }
}
