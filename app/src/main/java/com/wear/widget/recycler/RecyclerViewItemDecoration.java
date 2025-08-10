package com.wear.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
    public int a;

    public RecyclerViewItemDecoration(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (childAdapterPosition == 0 || childAdapterPosition == itemCount - 1) {
            return;
        }
        int i = this.a;
        rect.left = i;
        rect.right = i;
    }
}
