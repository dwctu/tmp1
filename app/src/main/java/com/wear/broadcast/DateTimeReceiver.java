package com.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dc.hu3;

/* loaded from: classes3.dex */
public class DateTimeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.TIMEZONE_CHANGED".equals(action)) {
            hu3.q0();
        }
        "android.intent.action.TIME_SET".equals(action);
    }
}
