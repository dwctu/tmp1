package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: IRemoteLocalViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class u implements View.OnClickListener {
    public final /* synthetic */ v a;

    public u(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context = this.a.e;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
