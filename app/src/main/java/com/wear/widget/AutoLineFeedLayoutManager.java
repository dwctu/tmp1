package com.wear.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AutoLineFeedLayoutManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/wear/widget/AutoLineFeedLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "()V", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AutoLineFeedLayoutManager extends RecyclerView.LayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        int width = getWidth();
        int itemCount = getItemCount();
        int i = 0;
        int iMax = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < itemCount; i3++) {
            View viewForPosition = recycler.getViewForPosition(i3);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(i)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int i4 = i + decoratedMeasuredWidth;
            if (i4 <= width) {
                layoutDecorated(viewForPosition, i4 - decoratedMeasuredWidth, i2, i4, i2 + decoratedMeasuredHeight);
                iMax = Math.max(iMax, decoratedMeasuredHeight);
                i = i4;
            } else {
                if (iMax == 0) {
                    iMax = decoratedMeasuredHeight;
                }
                i2 += iMax;
                layoutDecorated(viewForPosition, 0, i2, decoratedMeasuredWidth, i2 + decoratedMeasuredHeight);
                i = decoratedMeasuredWidth;
                iMax = decoratedMeasuredHeight;
            }
        }
    }
}
