package com.huawei.hms.scankit;

import android.view.View;

/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class w implements View.OnClickListener {
    public final /* synthetic */ y a;

    public w(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.a.k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
