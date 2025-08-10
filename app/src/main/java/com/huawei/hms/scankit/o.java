package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import io.agora.rtc2.Constants;

/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes3.dex */
public class o extends OrientationEventListener {
    public final /* synthetic */ q a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, Context context) {
        super(context);
        this.a = qVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int rotation = ((Activity) this.a.e).getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            this.a.a(90);
            return;
        }
        if (rotation == 1) {
            this.a.a(0);
        } else if (rotation == 2) {
            this.a.a(Constants.VIDEO_ORIENTATION_270);
        } else {
            if (rotation != 3) {
                return;
            }
            this.a.a(180);
        }
    }
}
