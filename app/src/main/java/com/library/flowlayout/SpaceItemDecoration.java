package com.library.flowlayout;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public int a;

    public SpaceItemDecoration(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.a;
        rect.top = i;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
    }
}
