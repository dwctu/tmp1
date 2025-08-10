package com.wear.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.NetWorkLocalEvent;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ep1;
import dc.ne3;
import dc.re3;
import dc.se3;
import dc.uf2;
import dc.ye3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class NetworkReceiver extends BroadcastReceiver {
    public Handler a = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(NetworkReceiver networkReceiver, Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MyApplication.P && MyApplication.Q != 0) {
                ep1.b().p();
            }
            uf2.v().B();
            MyApplication.z0(this.a);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            ne3.a.a();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                this.a.removeCallbacksAndMessages(null);
            } else {
                this.a.postDelayed(new a(this, context), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        } else {
            this.a.removeCallbacksAndMessages(null);
        }
        NetWorkLocalEvent netWorkLocalEvent = new NetWorkLocalEvent();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null) {
            if (NetworkInfo.State.CONNECTED != networkInfo.getState() || !networkInfo.isAvailable()) {
                EventBus.getDefault().post(new NetworkInfoEvent(false));
                MyApplication myApplication = WearUtils.x;
                if (myApplication != null) {
                    myApplication.t0();
                }
            } else if (networkInfo.getType() == 1 || networkInfo.getType() == 0 || networkInfo.getType() == 17) {
                EventBus.getDefault().post(new NetworkInfoEvent(true));
                if (networkInfo.getType() == 1) {
                    netWorkLocalEvent.isWifi = true;
                }
                re3.s();
                re3.r();
                ye3.l(se3.a(context));
            } else {
                EventBus.getDefault().post(new NetworkInfoEvent(false));
            }
        }
        EventBus.getDefault().post(new LoginStatusActionEvent());
        EventBus.getDefault().post(netWorkLocalEvent);
    }
}
