package com.huawei.hms.scankit;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class n implements View.OnTouchListener {
    public final /* synthetic */ q a;

    public n(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.h.a(motionEvent);
        return true;
    }
}
