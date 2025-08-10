package com.wear.widget.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.wear.bean.AnalyticsBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.gg3;

/* loaded from: classes4.dex */
public class FingerTouchView extends View implements View.OnTouchListener {
    public FingerImageView a;

    public FingerTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
        gg3.e(context);
    }

    public final void a() {
        MyApplication myApplication = WearUtils.x;
        AnalyticsBean analyticsBean = myApplication.r;
        if (analyticsBean == null || !analyticsBean.usedTouchPannel) {
            return;
        }
        analyticsBean.usedTouchPannel = false;
        myApplication.q(analyticsBean.getEvenString(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f3  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerTouchView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setFingerImageView(FingerImageView fingerImageView) {
        this.a = fingerImageView;
    }
}
