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
import com.wear.util.WearUtils;
import dc.ah4;

/* loaded from: classes3.dex */
public class GameModeService extends Service {
    public static final String e = GameModeService.class.getName();
    public static boolean f = false;
    public NotificationManager a;
    public NotificationCompat.Builder b;
    public Notification c;
    public Handler d = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GameModeService gameModeService = GameModeService.this;
            gameModeService.startForeground(1232, gameModeService.c);
            String unused = GameModeService.e;
        }
    }

    public final void c() {
        stopForeground(true);
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1232);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        try {
            this.a = (NotificationManager) getSystemService("notification");
            Intent intent = new Intent(WearUtils.x, (Class<?>) NotificationSyncService.class);
            intent.setAction("com.wear.chat.NOTIFICATION_SYNC");
            PendingIntent service = PendingIntent.getService(this, 0, intent, 201326592);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("com.wear.remote.game_mode", "RemoteNotificationGameMode", 3);
                notificationChannel.setDescription(ah4.e(R.string.app_name));
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setShowBadge(false);
                notificationChannel.setSound(null, null);
                this.a.createNotificationChannel(notificationChannel);
                this.b = new NotificationCompat.Builder(this, "GameModeService").setSmallIcon(R.drawable.startup_logo).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOngoing(true).setChannelId(notificationChannel.getId()).setContentTitle("The Lovense Service is running");
            } else {
                this.b = new NotificationCompat.Builder(this, "GameModeService").setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.orgy_background_color)).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOnlyAlertOnce(true).setVibrate(new long[]{0}).setSound(null).setOngoing(true).setContentTitle("The Lovense Service is running");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void e() {
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
        f = true;
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        f = false;
        c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str = "onStartCommand: " + this.c;
        if (this.c == null) {
            Notification notificationBuild = this.b.build();
            this.c = notificationBuild;
            this.a.notify(1232, notificationBuild);
            e();
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }
}
