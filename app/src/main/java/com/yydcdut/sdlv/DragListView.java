package com.yydcdut.sdlv;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ru3;
import dc.wu3;
import dc.xu3;

/* loaded from: classes4.dex */
public class DragListView extends ListView {
    public SlideAndDragListView.a a;
    public ru3 b;
    public ru3 c;
    public wu3 d;

    public DragListView(Context context) {
        this(context, null);
    }

    public final View i(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (i2 >= childAt.getTop() && i2 <= childAt.getBottom() && i >= childAt.getLeft() && i <= childAt.getRight()) {
                return childAt;
            }
        }
        return null;
    }

    public void j(int i, int i2) {
        ru3 ru3Var = this.b;
        if (ru3Var != null) {
            ru3Var.g(i, i2, this.a);
        }
        ru3 ru3Var2 = this.c;
        if (ru3Var2 != null) {
            ru3Var2.g(i, i2, null);
        }
    }

    public void k(int i, int i2) {
        View viewI = i(i, i2);
        if (viewI == null) {
            return;
        }
        ru3 ru3Var = this.b;
        if (ru3Var != null) {
            ru3Var.b(i, i2, viewI, this.a);
        }
        ru3 ru3Var2 = this.c;
        if (ru3Var2 != null) {
            ru3Var2.b(i, i2, viewI, null);
        }
    }

    public void l(int i, int i2) {
        View viewI = i(i, i2);
        if (viewI == null) {
            return;
        }
        ru3 ru3Var = this.b;
        boolean zD = ru3Var != null ? ru3Var.d(i, i2, viewI) : false;
        ru3 ru3Var2 = this.c;
        if (ru3Var2 != null && zD) {
            ru3Var2.d(i, i2, viewI);
        }
        SlideAndDragListView.a aVar = this.a;
        if (aVar == null || !zD) {
            return;
        }
        aVar.c(getPositionForView(viewI) - getHeaderViewsCount());
    }

    public boolean m() {
        return this.d.t();
    }

    public void n(ru3 ru3Var) {
        this.b = ru3Var;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.d.u(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d.v();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.d.w(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void setDragPosition(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (this.a == null || !(childAt instanceof xu3)) {
            return;
        }
        xu3 xu3Var = (xu3) getChildAt(i - getFirstVisiblePosition());
        xu3Var.g().setVisibility(8);
        xu3Var.h().setVisibility(8);
        this.d.x(true);
    }

    public void setListDragDropListener(ru3 ru3Var) {
        this.c = ru3Var;
    }

    public void setOnDragDropListener(SlideAndDragListView.a aVar) {
        this.a = aVar;
    }

    public DragListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new wu3(context, this, context instanceof Activity ? (ViewGroup) ((Activity) context).getWindow().getDecorView() : null);
    }
}
