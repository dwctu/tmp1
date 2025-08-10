package com.wear.broadcast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.lovense.wear.R;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.LanApiPlatformChangeEvent;
import com.wear.util.WearUtils;
import dc.ah4;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class LanApiService extends Service {
    public static boolean e = false;
    public NotificationManager a;
    public NotificationCompat.Builder b;
    public Notification c;
    public Handler d = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LanApiService lanApiService = LanApiService.this;
            lanApiService.startForeground(1231, lanApiService.c);
        }
    }

    public final void a() {
        stopForeground(true);
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1231);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            this.a = (NotificationManager) getSystemService("notification");
            Intent intent = new Intent(WearUtils.x, (Class<?>) NotificationSyncService.class);
            intent.setAction("com.wear.chat.NOTIFICATION_SYNC");
            PendingIntent service = PendingIntent.getService(this, 0, intent, 201326592);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("com.wear.remote.lan Api", "RemoteNotificationLanApi", 3);
                notificationChannel.setDescription(ah4.e(R.string.app_name));
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setShowBadge(false);
                notificationChannel.setSound(null, null);
                this.a.createNotificationChannel(notificationChannel);
                this.b = new NotificationCompat.Builder(this, "LanAipService").setSmallIcon(R.drawable.startup_logo).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOngoing(true).setChannelId(notificationChannel.getId()).setContentTitle("The Lovense Service is running");
            } else {
                this.b = new NotificationCompat.Builder(this, "LanAipService").setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.orgy_background_color)).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOnlyAlertOnce(true).setVibrate(new long[]{0}).setSound(null).setOngoing(true).setContentTitle("The Lovense Service is running");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void c() {
        this.d.removeCallbacksAndMessages(null);
        this.d.postDelayed(new a(), 16L);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        e = true;
        EventBus.getDefault().register(this);
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e = false;
        a();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LanApiControlEvent lanApiControlEvent) {
        if (lanApiControlEvent.isOpen()) {
            return;
        }
        e = false;
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str = "onStartCommand: " + this.c;
        if (this.c != null) {
            return 2;
        }
        Notification notificationBuild = this.b.build();
        this.c = notificationBuild;
        this.a.notify(1231, notificationBuild);
        c();
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LanApiPlatformChangeEvent lanApiPlatformChangeEvent) {
        NotificationCompat.Builder builder;
        if (e && (builder = this.b) != null) {
            builder.setContentTitle("The Lovense Service is running");
            this.a.notify(1231, this.b.build());
        }
    }
}
