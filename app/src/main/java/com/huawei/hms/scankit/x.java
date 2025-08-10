package com.huawei.hms.scankit;

import android.view.View;
import android.widget.TextView;

/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class x implements View.OnClickListener {
    public final /* synthetic */ y a;

    public x(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.isSelected()) {
            this.a.g();
            this.a.m();
            this.a.B.setContentDescription(this.a.B.getResources().getString(R.string.scankit_light));
        } else {
            this.a.h();
            view.setSelected(true);
            TextView textView = this.a.C;
            int i = R.string.scankit_light_off;
            textView.setText(i);
            this.a.B.setContentDescription(this.a.B.getResources().getString(i));
        }
    }
}
