package com.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wear.bean.User;
import com.wear.main.longDistance.ChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class ChatMessageBroadcastReceiver extends BroadcastReceiver {
    public ChatActivity a;
    public MyApplication b;

    public ChatMessageBroadcastReceiver(ChatActivity chatActivity, MyApplication myApplication) {
        this.a = chatActivity;
        this.b = myApplication;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatActivity chatActivity = this.a;
        if (chatActivity == null || chatActivity.z == null) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("ACTION_TOY_UPDATE")) {
            if (this.b.G().P().size() <= 0 || !WearUtils.y1(this.a.z.getToyStatus())) {
                this.a.S8(1, false);
                return;
            }
            User user = this.a.z;
            if (user == null || !user.isOnline()) {
                this.a.S8(1, false);
            } else {
                this.a.S8(1, true);
            }
        }
    }
}
