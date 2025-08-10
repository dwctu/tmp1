package com.epicgames.unreal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes.dex */
public class VolumeReceiver extends BroadcastReceiver {
    private static String STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static String STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static IntentFilter filter;
    private static VolumeReceiver receiver;

    public static void startReceiver(Activity activity) {
        GameActivity.Log.debug("Registering volume receiver");
        if (filter == null) {
            IntentFilter intentFilter = new IntentFilter();
            filter = intentFilter;
            intentFilter.addAction(VOLUME_CHANGED_ACTION);
        }
        if (receiver == null) {
            receiver = new VolumeReceiver();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(receiver, filter, 2);
        } else {
            activity.registerReceiver(receiver, filter);
        }
        int streamVolume = ((AudioManager) activity.getSystemService("audio")).getStreamVolume(3);
        GameActivity.Log.debug("startVolumeReceiver: " + streamVolume);
        volumeChanged(streamVolume);
    }

    public static void stopReceiver(Activity activity) {
        GameActivity.Log.debug("Unregistering volume receiver");
        activity.unregisterReceiver(receiver);
    }

    private static native void volumeChanged(int i);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GameActivity.Log.debug("OnReceive VOLUME_CHANGED_ACTION");
        int iIntValue = ((Integer) intent.getExtras().get(STREAM_TYPE)).intValue();
        int iIntValue2 = ((Integer) intent.getExtras().get(STREAM_VALUE)).intValue();
        if (iIntValue == 3) {
            volumeChanged(iIntValue2);
            return;
        }
        GameActivity.Log.debug("skipping volume change from stream " + iIntValue);
    }
}
