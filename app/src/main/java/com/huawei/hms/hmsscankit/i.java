package com.huawei.hms.hmsscankit;

import android.view.View;
import com.huawei.hms.hmsscankit.RemoteView;

/* compiled from: RemoteView.java */
/* loaded from: classes3.dex */
public class i implements View.OnClickListener {
    public final /* synthetic */ RemoteView.a a;

    public i(RemoteView.a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RemoteView.a aVar = this.a;
        RemoteView.this.startPhotoCode(aVar.g);
    }
}
