package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes4.dex */
public class ChatDSControlBottomControlView extends SkinCompatLinearLayout {
    public View c;
    public View d;

    public ChatDSControlBottomControlView(Context context) {
        super(context);
    }

    public View getControlMenuFoldView() {
        return this.c;
    }

    public View getControlMenuFoldViewLine() {
        return this.d;
    }

    public void setControlMenuFoldView(View view) {
        this.c = view;
    }

    public void setControlMenuFoldViewLine(View view) {
        this.d = view;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.c;
        if (view != null) {
            if (i == 0) {
                view.setVisibility(4);
            } else if (i == 8) {
                view.setVisibility(0);
            }
        }
        View view2 = this.d;
        if (view2 != null) {
            if (i == 0) {
                view2.setVisibility(4);
            } else if (i == 8) {
                view2.setVisibility(0);
            }
        }
    }

    public ChatDSControlBottomControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatDSControlBottomControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
