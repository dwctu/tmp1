package com.wear.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public SpaceItemDecoration(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        if (recyclerView.getChildLayoutPosition(view) == 0 && (i = this.a) != 0) {
            rect.top = i;
        }
        int i2 = this.b;
        if (i2 != 0) {
            rect.top = i2;
        }
        int i3 = this.c;
        if (i3 != 0) {
            rect.bottom = i3;
        }
        int i4 = this.d;
        if (i4 != 0) {
            rect.left = i4;
        }
        int i5 = this.e;
        if (i5 != 0) {
            rect.right = i5;
        }
    }

    public SpaceItemDecoration(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }
}
