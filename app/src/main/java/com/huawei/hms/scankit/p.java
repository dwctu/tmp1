package com.huawei.hms.scankit;

import android.view.View;

/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class p implements View.OnClickListener {
    public final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.o.dismiss();
    }
}
