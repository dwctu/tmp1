package com.epicgames.unreal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;

/* loaded from: classes.dex */
public class MulticastBroadcastReceiver extends BroadcastReceiver {
    public static Logger Log = new Logger("UE", "BroadcastReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.debug("MulticastBroadcastReceiver onReceive intent " + action);
        if (action == null) {
            return;
        }
        String name = getClass().getName();
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(action), 0)) {
            if (resolveInfo.activityInfo.packageName.equals(context.getPackageName()) && !resolveInfo.activityInfo.name.equals(name)) {
                Log.debug("Broadcasting intent " + action + " to " + resolveInfo.activityInfo.name);
                try {
                    ((BroadcastReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()).onReceive(context, intent);
                } catch (Throwable unused) {
                    Log.debug("Broadcasting intent " + action + " failed for " + resolveInfo.activityInfo.name);
                }
            }
        }
    }
}
