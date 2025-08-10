package com.wear.ui.chat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dc.kt2;

/* loaded from: classes3.dex */
public class AutoHidePanelRecyclerView extends RecyclerView {
    public kt2 a;

    public AutoHidePanelRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        kt2 kt2Var;
        if (motionEvent != null && motionEvent.getAction() != 3 && (kt2Var = this.a) != null) {
            kt2Var.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPanelSwitchHelper(kt2 kt2Var) {
        this.a = kt2Var;
    }

    public AutoHidePanelRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoHidePanelRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context));
    }
}
