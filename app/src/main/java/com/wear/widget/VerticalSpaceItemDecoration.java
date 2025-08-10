package com.wear.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.bottom = this.a;
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.top = this.a;
        }
    }
}
