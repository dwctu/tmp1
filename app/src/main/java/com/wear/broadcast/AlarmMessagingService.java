package com.wear.broadcast;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.lovense.wear.R;
import com.wear.bean.AlarmListItems;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.main.MainActivity;
import com.wear.protocol.EntityAlarm;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.au3;
import dc.be3;
import dc.jf3;
import dc.og3;
import dc.xe3;
import dc.zt3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class AlarmMessagingService extends Service {

    public class a implements au3 {
        public final /* synthetic */ AlarmListItems a;

        public a(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // dc.au3
        public void a() throws ParseException {
            AlarmMessagingService.this.c(this.a);
        }

        @Override // dc.au3
        public void b() {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ AlarmListItems a;

        public b(AlarmMessagingService alarmMessagingService, AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setRingTime(null);
            this.a.setIsSelected(0);
            DaoUtils.getAlarmListDao().update((AlarmListDao) this.a);
        }
    }

    public static boolean b(EntityAlarm entityAlarm) throws ParseException {
        try {
            if (!entityAlarm.getPattern().getFrequency().equals("customer")) {
                return false;
            }
            Date date = null;
            String[] dates = entityAlarm.getPattern().getDates();
            if (dates != null && !WearUtils.e1(entityAlarm.getPattern().getTime()) && WearUtils.Z0(dates[0])) {
                date = be3.j.parse(dates[0].trim() + " " + entityAlarm.getPattern().getTime().trim());
            }
            if (date != null) {
                return be3.B(be3.I(), date, 0);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void d(String str, boolean z) {
        Intent intent = new Intent(WearUtils.x, (Class<?>) AlarmMessagingService.class);
        intent.setAction("com.wear.alarm.MESSAGING_EVENT");
        intent.putExtra("com.wear.alarm.EXTRA_ALARM_ID", str);
        ((AlarmManager) WearUtils.x.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(WearUtils.x, str.hashCode(), intent, 335544320));
        if (z) {
            zt3.m.l(str);
        }
    }

    public final void c(AlarmListItems alarmListItems) throws ParseException {
        if (!alarmListItems.getFrequency().equals("customer")) {
            if (alarmListItems.getSnoozeCount() == 0) {
                zt3.t(this, alarmListItems.getId(), false, false, false);
            } else if (alarmListItems.getSnoozeCount() == 0 || alarmListItems.getHaveSnoozeCount() <= alarmListItems.getSnoozeCount()) {
                alarmListItems.setHaveSnoozeCount(alarmListItems.getHaveSnoozeCount() + 1);
                DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
            } else {
                zt3.t(this, alarmListItems.getId(), false, false, false);
            }
            EventBus.getDefault().post(alarmListItems);
            return;
        }
        alarmListItems.setIsSelected(0);
        if (alarmListItems.getSnoozeCount() == 0) {
            d(alarmListItems.getId(), false);
            e(alarmListItems);
        } else if (alarmListItems.getSnoozeCount() == 0 || alarmListItems.getHaveSnoozeCount() <= alarmListItems.getSnoozeCount()) {
            alarmListItems.setHaveSnoozeCount(alarmListItems.getHaveSnoozeCount() + 1);
            DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
        } else {
            d(alarmListItems.getId(), false);
            e(alarmListItems);
        }
        EventBus.getDefault().post(alarmListItems);
    }

    public final void e(AlarmListItems alarmListItems) {
        MyApplication myApplication = WearUtils.x;
        if (myApplication != null) {
            myApplication.l.postDelayed(new b(this, alarmListItems), 1500L);
        }
    }

    public final void f(String str, String str2) {
        if (og3.b(1)) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.addFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
            try {
                str2 = jf3.c(URLDecoder.decode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this).setAutoCancel(true);
            if (str == null) {
                str = ah4.e(R.string.app_name);
            }
            NotificationCompat.Builder contentTitle = autoCancel.setContentTitle(str);
            if (str2 == null) {
                str2 = "";
            }
            ((NotificationManager) getSystemService("notification")).notify(0, contentTitle.setContentText(str2).setSmallIcon(R.drawable.ic_launcher).setContentIntent(activity).build());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        xe3.a("Wear.App", "AlarmMessagingService onCreate");
        System.out.println("AlarmMessagingService.onCreate()!");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.out.println("AlarmMessagingService.onDestroy()!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) throws ParseException {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.wear.alarm.MESSAGING_EVENT")) {
            String stringExtra = intent.getStringExtra("com.wear.alarm.EXTRA_ALARM_ID");
            zt3.m.l(stringExtra);
            AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(stringExtra);
            if (alarmListItemsFindById != null) {
                String str = "getSnoozeCount==" + alarmListItemsFindById.getSnoozeCount() + "getHaveSnoozeCount==" + alarmListItemsFindById.getHaveSnoozeCount();
                if (alarmListItemsFindById.getReceiveFlag() == 1) {
                    MyApplication myApplication = WearUtils.x;
                    if (myApplication == null || (myApplication != null && WearUtils.y.u() == null)) {
                        f(ah4.e(R.string.alarm_notice_title), "");
                    } else if (alarmListItemsFindById.getDuration() == 0) {
                        zt3.k(alarmListItemsFindById, new a(alarmListItemsFindById));
                    } else {
                        c(alarmListItemsFindById);
                    }
                } else if (alarmListItemsFindById.getReceiveFlag() == 0) {
                    if (alarmListItemsFindById.getFrequency().equals("customer")) {
                        alarmListItemsFindById.setIsSelected(0);
                        if (alarmListItemsFindById.getSnoozeCount() == 0) {
                            d(stringExtra, false);
                            e(alarmListItemsFindById);
                        } else if (alarmListItemsFindById.getSnoozeCount() == 0 || alarmListItemsFindById.getHaveSnoozeCount() <= alarmListItemsFindById.getSnoozeCount()) {
                            alarmListItemsFindById.setHaveSnoozeCount(alarmListItemsFindById.getHaveSnoozeCount() + 1);
                            DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItemsFindById);
                        } else {
                            d(stringExtra, false);
                            e(alarmListItemsFindById);
                        }
                    } else if (alarmListItemsFindById.getSnoozeCount() == 0) {
                        zt3.t(this, stringExtra, false, false, true);
                    } else if (alarmListItemsFindById.getSnoozeCount() == 0 || alarmListItemsFindById.getHaveSnoozeCount() <= alarmListItemsFindById.getSnoozeCount()) {
                        alarmListItemsFindById.setHaveSnoozeCount(alarmListItemsFindById.getHaveSnoozeCount() + 1);
                        DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItemsFindById);
                    } else {
                        zt3.t(this, stringExtra, false, false, true);
                    }
                    if (!WearUtils.e1(alarmListItemsFindById.getFriendEmail())) {
                        zt3.l(stringExtra, alarmListItemsFindById.getTime(), alarmListItemsFindById.getFriendEmail());
                    }
                    EventBus.getDefault().post(alarmListItemsFindById);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
