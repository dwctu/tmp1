package io.agora.rtc2.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class VolumeChangeReceiver extends BroadcastReceiver {
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    private static final String TAG = VolumeChangeReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!TextUtils.equals(intent.getAction(), ACTION_VOLUME_CHANGED)) {
            Logging.w(TAG, "not volume change action");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int mode = audioManager.getMode();
        String str = TAG;
        Logging.d(str, "current audio mode is: " + mode);
        int i = 3;
        if (mode == 3) {
            i = 0;
        } else if (mode != 0) {
            Logging.w(str, "invalid audio mode");
            return;
        }
        int streamVolume = audioManager.getStreamVolume(i);
        Logging.d(str, "current volume is: " + streamVolume);
        HardwareEarMonitorController.getInstance().setHardwareEarMonitorVolume((streamVolume * 100) / 15);
    }
}
