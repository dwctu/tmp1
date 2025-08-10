package com.wear.broadcast;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.lovense.wear.R;
import com.wear.main.MainActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.df3;
import dc.og3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.bouncycastle.i18n.MessageBundle;

/* loaded from: classes3.dex */
public class WearFirebaseMessagingService extends FirebaseMessagingService {
    public final void a(String str, String str2, PendingIntent pendingIntent, String str3, boolean z) {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationCompat.Builder number = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.notification_color)).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(str3));
            if (z) {
                number.setContentTitle(str2);
                number.setContentText(str);
            } else {
                number.setContentTitle(str);
            }
            if (og3.b(2)) {
                number.setDefaults(-1);
            }
            notificationManager.notify(str3.hashCode() + "", str3.hashCode(), number.build());
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = 26)
    public final void b(String str, String str2, PendingIntent pendingIntent, String str3, boolean z) {
        String str4;
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (!og3.b(2) || !WearUtils.M) {
                str4 = "com.lovense.wear.notic.silence";
                NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
                notificationChannel.setLockscreenVisibility(-1);
                notificationChannel.setDescription("description of this notification");
                notificationChannel.setName("RemoteNotificationSilence");
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
            } else {
                str4 = "com.lovense.wear.notic.sound";
                NotificationChannel notificationChannel2 = new NotificationChannel("com.lovense.wear.notic.sound", "RemoteNotificationSound", 5);
                notificationChannel2.setLockscreenVisibility(-1);
                notificationChannel2.setDescription("description of this notification");
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.enableLights(true);
                notificationChannel2.setName("RemoteNotificationSound");
                notificationChannel2.setShowBadge(true);
                notificationChannel2.setSound(WearUtils.S(), notificationChannel2.getAudioAttributes());
                notificationManager.createNotificationChannel(notificationChannel2);
            }
            NotificationCompat.Builder number = new NotificationCompat.Builder(this, str4).setSmallIcon(R.drawable.icon_notification).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(str3));
            if (z) {
                number.setContentTitle(str2);
                number.setContentText(str);
            } else if (!TextUtils.equals(str3, "official_msg")) {
                number.setContentText(str);
            } else {
                if (!MyApplication.N().g0()) {
                    return;
                }
                number.setContentTitle(str2);
                TextUtils.isEmpty(str);
            }
            notificationManager.notify(str3.hashCode() + "", str3.hashCode(), number.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(String str, String str2, String str3) throws UnsupportedEncodingException {
        try {
            if (og3.b(1)) {
                Intent intent = new Intent(this, (Class<?>) MainActivity.class);
                if (TextUtils.equals("official_msg", str3)) {
                    intent = new Intent(this, (Class<?>) OfficialAccountActivity.class);
                    if (MyApplication.O) {
                        OfficialaCountModel.g.a().H(true);
                    }
                    intent.putExtra("official_msg", str3);
                    if (!MyApplication.N().g0()) {
                        return;
                    }
                }
                intent.addFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
                try {
                    str2 = URLDecoder.decode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                boolean zB = og3.b(4);
                if (!zB) {
                    str2 = ah4.e(R.string.system_new_message);
                }
                String str4 = str2;
                if (Build.VERSION.SDK_INT >= 26) {
                    b(str4, str, activity, str3, zB);
                } else {
                    a(str4, str, activity, str3, zB);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        System.out.println("WearFirebaseMessagingService.onCreate()!");
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.out.println("WearFirebaseMessagingService.onDestroy()!");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str = "From: " + remoteMessage.getFrom();
        System.out.println("WearFirebaseMessagingService.onMessageReceived(" + remoteMessage.getFrom() + ")!");
        if (remoteMessage.getData().size() > 0) {
            String str2 = "Message data payload: " + remoteMessage.getData();
        }
        if (remoteMessage.getNotification() != null) {
            String str3 = "Message Notification Body: " + remoteMessage.getNotification().getBody();
        }
        try {
            if (remoteMessage.getData() != null && remoteMessage.getData().get("type") != null && "official_msg".equals(remoteMessage.getData().get("type"))) {
                String str4 = remoteMessage.getData().get("body");
                if (str4 == null) {
                    str4 = "[Recieve a new notification]";
                }
                c(remoteMessage.getData().get(MessageBundle.TITLE_ENTRY), str4, "official_msg");
                return;
            }
            if (remoteMessage.getData() != null && remoteMessage.getData().get("type") != null && "chat".equals(remoteMessage.getData().get("type"))) {
                c(remoteMessage.getNotification().getTitle(), NotificationCompat.CATEGORY_MESSAGE, remoteMessage.getFrom());
                return;
            }
            if (remoteMessage.getData() != null && remoteMessage.getData().get("body") != null) {
                c(remoteMessage.getData().get(MessageBundle.TITLE_ENTRY), remoteMessage.getData().get("body"), remoteMessage.getFrom());
            } else {
                if (remoteMessage.getNotification() == null || remoteMessage.getNotification().getBody() == null) {
                    return;
                }
                c(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), remoteMessage.getFrom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        System.out.println("WearFirebaseMessagingService.onUnbind()!");
        return super.onUnbind(intent);
    }
}
