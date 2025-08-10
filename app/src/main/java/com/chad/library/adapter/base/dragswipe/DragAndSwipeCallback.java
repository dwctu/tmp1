package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import dc.aq;
import dc.fr;

/* loaded from: classes.dex */
public class DragAndSwipeCallback extends ItemTouchHelper.Callback {
    public fr a;
    public float b;
    public float c;
    public int d;
    public int e;

    public final boolean a(@NonNull RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        int i = aq.BaseQuickAdapter_dragging_support;
        if (view.getTag(i) != null && ((Boolean) viewHolder.itemView.getTag(i)).booleanValue()) {
            fr frVar = this.a;
            if (frVar != null) {
                frVar.f(viewHolder);
            }
            viewHolder.itemView.setTag(i, Boolean.FALSE);
        }
        View view2 = viewHolder.itemView;
        int i2 = aq.BaseQuickAdapter_swiping_support;
        if (view2.getTag(i2) == null || !((Boolean) viewHolder.itemView.getTag(i2)).booleanValue()) {
            return;
        }
        fr frVar2 = this.a;
        if (frVar2 != null) {
            frVar2.i(viewHolder);
        }
        viewHolder.itemView.setTag(i2, Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder) ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        fr frVar = this.a;
        if (frVar != null) {
            return frVar.e();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        fr frVar = this.a;
        return (frVar == null || !frVar.d() || this.a.b()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (i != 1 || a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        canvas.save();
        if (f > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f, view.getTop());
        }
        fr frVar = this.a;
        if (frVar != null) {
            frVar.l(canvas, viewHolder, f, f2, z);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
        super.onMoved(recyclerView, viewHolder, i, viewHolder2, i2, i3, i4);
        fr frVar = this.a;
        if (frVar != null) {
            frVar.g(viewHolder, viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 2 && !a(viewHolder)) {
            fr frVar = this.a;
            if (frVar != null) {
                frVar.h(viewHolder);
            }
            viewHolder.itemView.setTag(aq.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i == 1 && !a(viewHolder)) {
            fr frVar2 = this.a;
            if (frVar2 != null) {
                frVar2.j(viewHolder);
            }
            viewHolder.itemView.setTag(aq.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        fr frVar;
        if (a(viewHolder) || (frVar = this.a) == null) {
            return;
        }
        frVar.k(viewHolder);
    }
}
