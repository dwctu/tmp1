package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.kyleduo.switchbutton.SwitchButton;

/* loaded from: classes4.dex */
public class InterceptSwitchButton extends SwitchButton {
    public boolean a;
    public a b;

    public interface a {
        void a();
    }

    public InterceptSwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kyleduo.switchbutton.SwitchButton, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            return super.onTouchEvent(motionEvent);
        }
        a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return false;
    }

    public void setIntercept(boolean z) {
        this.a = z;
    }

    public void setListener(a aVar) {
        this.b = aVar;
    }

    public InterceptSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptSwitchButton(Context context) {
        super(context);
    }
}
