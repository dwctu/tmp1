package com.wear.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

/* loaded from: classes4.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    public final Intent a(String str) {
        Intent intent = new Intent("com.wear.music.notify.play_state");
        intent.setPackage(WearUtils.x.getPackageName());
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return;
        }
        String str = "Action ---->" + action + "  KeyEvent----->" + keyEvent.toString();
        int action2 = keyEvent.getAction();
        if ("android.intent.action.MEDIA_BUTTON".equals(action) && action2 == 0) {
            int keyCode = keyEvent.getKeyCode();
            String str2 = "Action keyCode---->" + keyCode;
            if (keyCode == 79) {
                context.sendBroadcast(a("com.wear.music.notify.play_state"));
                return;
            }
            if (keyCode == 85) {
                context.sendBroadcast(a("com.wear.music.notify.play_state"));
            } else if (keyCode == 126) {
                context.sendBroadcast(a("com.wear.music.notify.play_state"));
            } else {
                if (keyCode != 127) {
                    return;
                }
                context.sendBroadcast(a("com.wear.music.notify.play_state"));
            }
        }
    }
}
