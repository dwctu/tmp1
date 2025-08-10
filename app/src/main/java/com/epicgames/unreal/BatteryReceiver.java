package com.epicgames.unreal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class BatteryReceiver extends BroadcastReceiver {
    public static IntentFilter filter;
    public static BatteryReceiver receiver;
    private int batteryLevel = 0;
    private int batteryStatus = 0;
    private int batteryTemperature = 0;
    private long lastLogTime = 0;

    private static native void dispatchEvent(int i, int i2, int i3);

    private void processIntent(Intent intent) {
        int i = 0;
        if (intent.getBooleanExtra("present", false)) {
            int intExtra = intent.getIntExtra("status", 0);
            int intExtra2 = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra3 = intent.getIntExtra("scale", -1);
            int intExtra4 = intent.getIntExtra("temperature", 0);
            if (intExtra2 >= 0 && intExtra3 > 0) {
                i = (intExtra2 * 100) / intExtra3;
            }
            if (intExtra == this.batteryStatus && i == this.batteryLevel && intExtra4 == this.batteryTemperature) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (i != this.batteryLevel || intExtra4 != this.batteryTemperature || jCurrentTimeMillis - this.lastLogTime > 60000) {
                GameActivity.Log.debug("Battery: status = " + intExtra + ", rawlevel = " + intExtra2 + ", scale = " + intExtra3);
                this.lastLogTime = jCurrentTimeMillis;
            }
            this.batteryStatus = intExtra;
            this.batteryLevel = i;
            this.batteryTemperature = intExtra4;
            dispatchEvent(intExtra, i, intExtra4);
        }
    }

    public static void startReceiver(Activity activity) {
        GameActivity.Log.debug("Registering battery receiver");
        if (filter == null) {
            filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        }
        if (receiver == null) {
            receiver = new BatteryReceiver();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(receiver, filter, 2);
        } else {
            activity.registerReceiver(receiver, filter);
        }
        receiver.processIntent(activity.getIntent());
    }

    public static void stopReceiver(Activity activity) {
        GameActivity.Log.debug("Unregistering battery receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        processIntent(intent);
    }
}
