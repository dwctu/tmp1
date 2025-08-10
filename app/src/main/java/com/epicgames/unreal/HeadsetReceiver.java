package com.epicgames.unreal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* loaded from: classes.dex */
public class HeadsetReceiver extends BroadcastReceiver {
    public static IntentFilter filter;
    public static HeadsetReceiver receiver;

    public static void startReceiver(Activity activity) {
        GameActivity.Log.debug("Registering headset receiver");
        if (filter == null) {
            filter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        }
        if (receiver == null) {
            receiver = new HeadsetReceiver();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(receiver, filter, 2);
        } else {
            activity.registerReceiver(receiver, filter);
        }
        int intExtra = activity.getIntent().getIntExtra("state", 0);
        GameActivity.Log.debug("startHeadsetReceiver: " + intExtra);
        stateChanged(intExtra);
    }

    private static native void stateChanged(int i);

    public static void stopReceiver(Activity activity) {
        GameActivity.Log.debug("Unregistering headset receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GameActivity.Log.debug("headsetReceiver::onReceive");
        if (intent.hasExtra("state")) {
            stateChanged(intent.getIntExtra("state", 0));
        }
    }
}
