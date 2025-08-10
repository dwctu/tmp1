package com.wear.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.wear.SyncAccessActivity;
import com.wear.bean.OpenAppBean;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.eg3;
import io.agora.rtc2.internal.AudioRoutingController;

/* loaded from: classes3.dex */
public class NotificationSyncService extends Service {
    public String a = "com.wear.chat.NOTIFICATION_SYNC";

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        System.out.println("NotificationSyncService.onCreate()!");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.out.println("NotificationSyncService.onDestroy()!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals(this.a)) {
            String stringExtra = intent.getStringExtra("userId");
            if (WearUtils.y.u() == null) {
                Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
                OpenAppBean openAppBean = new OpenAppBean();
                openAppBean.type = -1;
                openAppBean.userId = stringExtra;
                MyApplication.v0(openAppBean);
                intent2.setFlags(268435456);
                startActivity(intent2);
            } else if (WearUtils.e1(eg3.h(WearUtils.x, "gen_token_Key", ""))) {
                Intent intent3 = new Intent(WearUtils.x, (Class<?>) LoginActivity.class);
                intent3.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                FragmentActivity fragmentActivityH = MyApplication.H();
                if (fragmentActivityH != null) {
                    fragmentActivityH.startActivity(intent3);
                }
            } else {
                Intent intent4 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                intent4.putExtra("userId", stringExtra);
                intent4.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                FragmentActivity fragmentActivityH2 = MyApplication.H();
                if (fragmentActivityH2 != null) {
                    fragmentActivityH2.startActivity(intent4);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
