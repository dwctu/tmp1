package com.wear.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Parcelable;
import dc.db2;
import dc.gd2;
import dc.h32;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public class NetWorkStateReceiver extends BroadcastReceiver {
    public long a = System.currentTimeMillis();

    public class a implements Runnable {
        public a(NetWorkStateReceiver netWorkStateReceiver) {
        }

        @Override // java.lang.Runnable
        public void run() {
            h32.i().z();
            if (db2.A().b != null) {
                db2.A().b.o();
            }
        }
    }

    public final void a() {
        Handler handler;
        EventBus.getDefault().post(this);
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null || (handler = myApplication.l) == null) {
            return;
        }
        handler.postDelayed(new a(this), 1200L);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Parcelable parcelableExtra;
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            intent.getIntExtra("wifi_state", 0);
        }
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
            String str = "isConnected:  " + (((NetworkInfo) parcelableExtra).getState() == NetworkInfo.State.CONNECTED);
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            String str2 = "onReceive connectChangeTime: " + this.a;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                EventBus.getDefault().post(new gd2(-2));
                a();
                return;
            }
            if (!activeNetworkInfo.isConnected()) {
                EventBus.getDefault().post(new gd2(-1));
            } else if (activeNetworkInfo.getType() == 1) {
                EventBus.getDefault().post(new gd2(1));
            } else if (activeNetworkInfo.getType() == 0) {
                EventBus.getDefault().post(new gd2(0));
            }
            a();
            if (System.currentTimeMillis() - 5000 > this.a) {
                this.a = System.currentTimeMillis();
                MyApplication.l0();
            }
        }
    }
}
