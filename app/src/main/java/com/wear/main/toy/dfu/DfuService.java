package com.wear.main.toy.dfu;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public Class<? extends Activity> getNotificationTarget() {
        return NotificationActivity.class;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public boolean isDebug() {
        return true;
    }
}
