package com.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class BatteryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MyApplication myApplication;
        if (intent != null) {
            String action = intent.getAction();
            if (WearUtils.e1(action)) {
                return;
            }
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                if (intExtra == 0 || (myApplication = WearUtils.x) == null) {
                    return;
                }
                myApplication.a = intExtra;
                return;
            }
            if ("android.intent.action.BATTERY_LOW".equals(action)) {
                MyApplication myApplication2 = WearUtils.x;
                if (myApplication2 != null) {
                    myApplication2.b = false;
                }
                if (intExtra == 0 || myApplication2 == null) {
                    return;
                }
                myApplication2.a = intExtra;
                return;
            }
            if ("android.intent.action.BATTERY_OKAY".equals(action)) {
                MyApplication myApplication3 = WearUtils.x;
                if (myApplication3 != null) {
                    myApplication3.b = true;
                }
                if (intExtra == 0 || myApplication3 == null) {
                    return;
                }
                myApplication3.a = intExtra;
            }
        }
    }
}
