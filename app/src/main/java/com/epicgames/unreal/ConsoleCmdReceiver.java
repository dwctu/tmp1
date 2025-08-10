package com.epicgames.unreal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class ConsoleCmdReceiver extends BroadcastReceiver {
    private GameActivity gameActivity;

    public ConsoleCmdReceiver(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        String action = intent.getAction();
        if (action == null || action != "android.intent.action.RUN" || (stringExtra = intent.getStringExtra("cmd")) == null) {
            return;
        }
        this.gameActivity.nativeConsoleCommand(stringExtra);
    }
}
