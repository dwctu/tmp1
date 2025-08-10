package com.wear.main.ninja.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.TestValue;
import com.wear.bean.event.NinjaLiveChangeEvent;
import com.wear.bean.event.NinjaMusicChangeEvent;
import com.wear.bean.event.NinjaPatternChangeEvent;
import com.wear.bean.event.NinjaRemoteChangeEvent;
import com.wear.bean.event.NinjaSoundChangeEvent;
import com.wear.bean.event.NinjaSpeedModeChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationLiveCloseEvent;
import com.wear.bean.event.NotificationMusicCloseEvent;
import com.wear.bean.event.NotificationPatternCloseEvent;
import com.wear.bean.event.NotificationRemoteCloseEvent;
import com.wear.bean.event.NotificationSoundCloseEvent;
import com.wear.bean.event.NotificationSpeedModeCloseEvent;
import com.wear.bean.event.OpenLockEvent;
import com.wear.broadcast.NotificationChatService;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.nd2;
import dc.nd3;
import dc.zt3;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PlayService extends Service {
    public static boolean R = false;
    public String F;
    public String G;
    public int K;
    public String L;
    public boolean M;
    public int N;
    public ScreenBroadcastReceiver a;
    public NotificationManager d;
    public NotificationCompat.Builder e;
    public Notification f;
    public RemoteViews g;
    public RemoteViews h;
    public IntentFilter i;
    public int b = -1;
    public Handler c = new Handler();
    public int j = R.drawable.widget_minimize_cover_music;
    public int k = R.drawable.widget_cover_music;
    public int l = R.drawable.widget_minimize_cover_pattern;
    public int m = R.drawable.widget_cover_pattern;
    public int n = R.drawable.widget_minimize_cover_speedmode;
    public int o = R.drawable.widget_cover_speedmode;
    public int p = R.drawable.cover_sound_control;
    public int q = R.drawable.widget_cover_sound_control;
    public int r = R.drawable.cover_remote_control;
    public int s = R.drawable.widget_cover_remote_control;
    public int t = R.drawable.cover_live_control;
    public int u = R.drawable.widget_cover_live_control;
    public int v = R.color.black;
    public int w = R.drawable.widget_loop_random_dark;
    public int x = R.drawable.widget_loop_single_dark;
    public int y = R.drawable.widget_loop_all_dark;
    public int z = R.drawable.widget_pause_dark;
    public int A = R.drawable.widget_play_dark;
    public int B = R.drawable.widget_close_dark;
    public int C = R.drawable.widget_next_dark;
    public int D = R.drawable.widget_previous_dark;
    public int E = 0;
    public int O = -1;
    public boolean P = false;
    public boolean Q = true;

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (!"android.intent.action.SCREEN_OFF".equals(action) && "android.intent.action.SCREEN_ON".equals(action) && PlayService.this.Q && !PlayService.this.M && PlayService.this.p()) {
                    Intent intent2 = null;
                    if (PlayService.this.b == 0) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.setAction("music_lock");
                        intent2.putExtra("music_cover", PlayService.this.L);
                        intent2.putExtra("music_duration", PlayService.this.N);
                    } else if (PlayService.this.b == 1) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.setAction("play_lock");
                    } else if (PlayService.this.b == 2) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.setAction("speed_mode_lock");
                        intent2.putExtra("speed_mode_sensitivity", PlayService.this.O);
                    } else if (PlayService.this.b == 3) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.putExtra("sound_sensitivity", PlayService.this.O);
                        intent2.setAction("sound_lock");
                    } else if (PlayService.this.b == 4) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.putExtra("remote_sensitivity", PlayService.this.O);
                        intent2.setAction("remote_lock");
                    } else if (PlayService.this.b == 5) {
                        intent2 = new Intent(PlayService.this, (Class<?>) NinjaLockActivity.class);
                        intent2.putExtra("live_sensitivity", PlayService.this.O);
                        intent2.setAction("live_lock");
                    }
                    intent2.putExtra("play_name", PlayService.this.F);
                    intent2.putExtra("play_author", PlayService.this.G);
                    intent2.putExtra("play_mode", PlayService.this.E);
                    intent2.putExtra("pattern_pause", PlayService.this.M);
                    intent2.addFlags(268435456);
                    PlayService.this.startActivity(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a extends SimpleImageLoadingListener {
        public a() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            try {
                if (PlayService.this.g != null) {
                    PlayService.this.g.setImageViewBitmap(R.id.custom_song_icon, bitmap);
                }
                if (PlayService.this.h != null) {
                    PlayService.this.h.setImageViewBitmap(R.id.custom_song_icon, bitmap);
                }
                PlayService.this.d.notify(1231, PlayService.this.e.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            try {
                if (PlayService.this.g != null) {
                    PlayService.this.g.setImageViewResource(R.id.custom_song_icon, PlayService.this.j);
                }
                if (PlayService.this.h != null) {
                    PlayService.this.h.setImageViewResource(R.id.custom_song_icon, PlayService.this.k);
                }
                PlayService.this.d.notify(1231, PlayService.this.e.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayService.this.d.notify(1231, PlayService.this.e.build());
        }
    }

    public final void o() {
        stopForeground(true);
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1231);
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            EventBus.getDefault().register(this);
            s();
            r();
            boolean z = true;
            R = true;
            if (!p()) {
                this.Q = false;
                return;
            }
            TestValue existKey = DaoUtils.getTestValueDao().getExistKey(nd3.u(zt3.k), TestValueDao.NINJA_MODE_SWITCH_TYPE);
            if (existKey == null) {
                this.Q = true;
                return;
            }
            String strI = nd3.i(existKey.getValue());
            if (strI != null && !strI.equals("1")) {
                z = false;
            }
            this.Q = z;
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        R = false;
        this.c.removeCallbacksAndMessages(null);
        this.g = null;
        this.h = null;
        this.f = null;
        this.e = null;
        this.d = null;
        o();
        unregisterReceiver(this.a);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaPatternChangeEvent ninjaPatternChangeEvent) {
        this.b = 1;
        y(ninjaPatternChangeEvent.getChangeStatus(), ninjaPatternChangeEvent.getPatternName(), ninjaPatternChangeEvent.getPatternAuthor(), ninjaPatternChangeEvent.isPlayOrPause(), ninjaPatternChangeEvent.getNowMode(), null, -1, -1, -1);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        this.F = intent.getStringExtra("play_name");
        this.G = intent.getStringExtra("play_author");
        this.K = intent.getIntExtra("play_music_type", 0);
        this.E = intent.getIntExtra("play_mode", 0);
        this.M = intent.getBooleanExtra("pattern_pause", false);
        if ("pattern_start".equals(action)) {
            this.b = 1;
            if (this.f == null) {
                Notification notificationBuild = this.e.build();
                this.f = notificationBuild;
                startForeground(1231, notificationBuild);
            }
            y(99, this.F, this.G, this.M, this.E, null, -1, -1, this.K);
        } else if ("music_start".equals(action)) {
            this.b = 0;
            this.L = intent.getStringExtra("music_cover");
            this.N = intent.getIntExtra("music_duration", 100);
            if (this.f == null) {
                Notification notificationBuild2 = this.e.build();
                this.f = notificationBuild2;
                startForeground(1231, notificationBuild2);
            }
            y(99, this.F, this.G, this.M, this.E, this.L, this.N, -1, this.K);
        } else if ("speed_mode_start".equals(action)) {
            this.b = 2;
            this.O = intent.getIntExtra("speed_mode_sensitivity", 0);
            if (this.f == null) {
                Notification notificationBuild3 = this.e.build();
                this.f = notificationBuild3;
                startForeground(1231, notificationBuild3);
            }
            y(99, this.F, "", this.M, 0, "", -1, this.O, this.K);
        } else if ("sound_start".equals(action)) {
            this.b = 3;
            this.O = intent.getIntExtra("sound_sensitivity", 0);
            if (this.f == null) {
                Notification notificationBuild4 = this.e.build();
                this.f = notificationBuild4;
                startForeground(1231, notificationBuild4);
            }
            y(99, this.F, "", this.M, 0, "", -1, this.O, this.K);
        } else if ("remote_start".equals(action)) {
            this.b = 4;
            this.O = intent.getIntExtra("remote_sensitivity", 0);
            if (this.f == null) {
                Notification notificationBuild5 = this.e.build();
                this.f = notificationBuild5;
                startForeground(1231, notificationBuild5);
            }
            y(99, this.F, "", this.M, 0, "", -1, this.O, this.K);
        } else if ("live_start".equals(action)) {
            this.b = 5;
            this.O = intent.getIntExtra("live_sensitivity", 0);
            if (this.f == null) {
                Notification notificationBuild6 = this.e.build();
                this.f = notificationBuild6;
                startForeground(1231, notificationBuild6);
            }
            y(99, this.F, "", this.M, 0, "", -1, this.O, this.K);
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        Intent intent2 = new Intent("com.wear.music.notify.close");
        intent2.setPackage(WearUtils.x.getPackageName());
        sendBroadcast(intent2);
        super.onTaskRemoved(intent);
    }

    public final boolean p() {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this);
    }

    public final Intent q(PlayService playService, String str) {
        Intent intent = new Intent(str);
        intent.setPackage(playService.getPackageName());
        return intent;
    }

    public final void r() {
        this.g = null;
        this.h = null;
        this.g = new RemoteViews(getPackageName(), R.layout.view_notify_small);
        this.h = new RemoteViews(getPackageName(), R.layout.view_notify_big);
        this.d = (NotificationManager) getSystemService("notification");
        Intent intent = new Intent(this, (Class<?>) NotificationChatService.class);
        intent.setAction("com.wear.chat.NOTIFICATION_CHAT");
        intent.putExtra("isPlayService", true);
        PendingIntent service = PendingIntent.getService(this, 0, intent, 201326592);
        if (Build.VERSION.SDK_INT < 26) {
            this.e = new NotificationCompat.Builder(this, "playServiceControl").setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.notification_color)).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOnlyAlertOnce(true).setVibrate(new long[]{0}).setSound(null).setOngoing(true);
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notice.ninja", "RemoteNotificationNinja", 3);
        notificationChannel.setDescription("Notification");
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        this.d.createNotificationChannel(notificationChannel);
        this.e = new NotificationCompat.Builder(this, "playServiceControl").setSmallIcon(R.drawable.icon_notification).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(service).setPriority(2).setTicker(ah4.e(R.string.app_name)).setOngoing(true).setChannelId(notificationChannel.getId());
    }

    public final void s() {
        IntentFilter intentFilter = new IntentFilter();
        this.i = intentFilter;
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.i.addAction("android.intent.action.SCREEN_ON");
        ScreenBroadcastReceiver screenBroadcastReceiver = new ScreenBroadcastReceiver();
        this.a = screenBroadcastReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(screenBroadcastReceiver, this.i, 2);
        } else {
            registerReceiver(screenBroadcastReceiver, this.i);
        }
    }

    public final void t() {
        this.g = null;
        this.h = null;
        this.g = new RemoteViews(getPackageName(), R.layout.view_notify_small);
        this.h = new RemoteViews(getPackageName(), R.layout.view_notify_big);
        this.e.setCustomContentView(this.g);
        this.e.setCustomBigContentView(this.h);
        w();
    }

    public final void u(String str, String str2, boolean z, int i, String str3, int i2, int i3, RemoteViews remoteViews, int i4) {
        this.F = str;
        this.G = str2;
        this.L = str3;
        this.E = i;
        this.M = z;
        this.N = i2;
        this.O = i3;
        this.K = i4;
        remoteViews.setTextViewText(R.id.tv_custom_title, str.replace("/*!/", ""));
        remoteViews.setTextViewText(R.id.tv_custom_content, str2);
        if ((ah4.e(R.string.patterns_under_review) + "/*!/").equals(str)) {
            remoteViews.setViewVisibility(R.id.iv_under_preview, 0);
        } else {
            remoteViews.setViewVisibility(R.id.iv_under_preview, 8);
        }
        if (i == 1) {
            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.w);
        } else if (i != 2) {
            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.y);
        } else {
            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.x);
        }
        remoteViews.setViewVisibility(R.id.music_loading_1, 8);
        remoteViews.setViewVisibility(R.id.btn_custom_play, 0);
        if (z) {
            remoteViews.setImageViewResource(R.id.btn_custom_play, this.A);
        } else {
            remoteViews.setImageViewResource(R.id.btn_custom_play, this.z);
        }
        remoteViews.setTextColor(R.id.tv_custom_title, getResources().getColor(this.v));
        remoteViews.setImageViewResource(R.id.btn_custom_close, this.B);
        remoteViews.setImageViewResource(R.id.btn_custom_next, this.C);
        remoteViews.setImageViewResource(R.id.btn_custom_prev, this.D);
        int i5 = R.drawable.widget_next_dark_disable;
        int i6 = R.drawable.widget_previous_dark_disable;
        if (i3 != -1) {
            int i7 = R.drawable.widget_next;
            if (i3 == 0) {
                remoteViews.setImageViewResource(R.id.btn_custom_prev, this.P ? R.drawable.widget_previous_dark_disable : R.drawable.widget_previous_light_disable);
                if (!this.P) {
                    i7 = R.drawable.widget_next_dark;
                }
                remoteViews.setImageViewResource(R.id.btn_custom_next, i7);
            } else {
                int i8 = R.drawable.widget_previous;
                if (i3 == 100) {
                    if (!this.P) {
                        i8 = R.drawable.widget_previous_dark;
                    }
                    remoteViews.setImageViewResource(R.id.btn_custom_prev, i8);
                    remoteViews.setImageViewResource(R.id.btn_custom_next, this.P ? R.drawable.widget_next_dark_disable : R.drawable.widget_next_light_disable);
                } else {
                    if (!this.P) {
                        i8 = R.drawable.widget_previous_dark;
                    }
                    remoteViews.setImageViewResource(R.id.btn_custom_prev, i8);
                    if (!this.P) {
                        i7 = R.drawable.widget_next_dark;
                    }
                    remoteViews.setImageViewResource(R.id.btn_custom_next, i7);
                }
            }
        }
        if (this.b == 2 || i4 == 2) {
            if (!this.P) {
                i6 = R.drawable.widget_previous_light_disable;
            }
            remoteViews.setImageViewResource(R.id.btn_custom_prev, i6);
            if (!this.P) {
                i5 = R.drawable.widget_next_light_disable;
            }
            remoteViews.setImageViewResource(R.id.btn_custom_next, i5);
        }
    }

    public final void v(RemoteViews remoteViews) {
        remoteViews.setTextColor(R.id.tv_custom_title, getResources().getColor(this.v));
        remoteViews.setImageViewResource(R.id.btn_custom_close, this.B);
        remoteViews.setImageViewResource(R.id.btn_custom_play, this.M ? this.z : this.A);
        remoteViews.setImageViewResource(R.id.btn_custom_loop, this.y);
        remoteViews.setImageViewResource(R.id.btn_custom_next, this.C);
        remoteViews.setImageViewResource(R.id.btn_custom_prev, this.D);
    }

    public final void w() {
        try {
            nd2 nd2Var = new nd2(this);
            nd2Var.b();
            if (nd2.l(nd2Var.i())) {
                this.P = true;
                this.v = R.color.white;
                this.w = R.drawable.widget_loop_random;
                this.x = R.drawable.widget_loop_single;
                this.y = R.drawable.widget_loop_all;
                this.z = R.drawable.widget_pause;
                this.A = R.drawable.widget_play;
                this.B = R.drawable.widget_close;
                this.C = R.drawable.widget_next;
                this.D = R.drawable.widget_previous;
            } else {
                this.P = false;
                this.v = R.color.black;
                this.w = R.drawable.widget_loop_random_dark;
                this.x = R.drawable.widget_loop_single_dark;
                this.y = R.drawable.widget_loop_all_dark;
                this.z = R.drawable.widget_pause_dark;
                this.A = R.drawable.widget_play_dark;
                this.B = R.drawable.widget_close_dark;
                this.C = R.drawable.widget_next_dark;
                this.D = R.drawable.widget_previous_dark;
            }
            v(this.g);
            v(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void x(RemoteViews remoteViews) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i = this.b;
        String str9 = "";
        if (i == 0) {
            str9 = "com.wear.music.notify.prev";
            str6 = "com.wear.music.notify.play_state";
            str7 = "com.wear.music.notify.next";
            str8 = "com.wear.music.notify.loop";
            str4 = "com.wear.music.notify.close";
        } else {
            if (i != 1) {
                if (i == 2) {
                    str5 = "com.wear.speed_mode.notify.prev";
                    str2 = "com.wear.speed_mode.notify.play_state";
                    str3 = "com.wear.speed_mode.notify.next";
                    str4 = "com.wear.speed_mode.notify.close";
                } else if (i == 3) {
                    str5 = "com.wear.sound.notify.prev";
                    str2 = "com.wear.sound.notify.play_state";
                    str3 = "com.wear.sound.notify.next";
                    str4 = "com.wear.sound.notify.close";
                } else if (i == 4) {
                    str5 = "com.wear.remote.notify.prev";
                    str2 = "com.wear.remote.notify.play_state";
                    str3 = "com.wear.remote.notify.next";
                    str4 = "com.wear.remote.notify.close";
                } else {
                    if (i != 5) {
                        str = "";
                        str2 = str;
                        str3 = str2;
                        str4 = str3;
                        PendingIntent broadcast = PendingIntent.getBroadcast(this, 1, q(this, str9), 201326592);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, 2, q(this, str2), 201326592);
                        PendingIntent broadcast3 = PendingIntent.getBroadcast(this, 3, q(this, str3), 201326592);
                        PendingIntent broadcast4 = PendingIntent.getBroadcast(this, 4, q(this, str), 201326592);
                        PendingIntent broadcast5 = PendingIntent.getBroadcast(this, 5, q(this, str4), 201326592);
                        remoteViews.setOnClickPendingIntent(R.id.ll_custom_prev, broadcast);
                        remoteViews.setOnClickPendingIntent(R.id.btn_custom_play, broadcast2);
                        remoteViews.setOnClickPendingIntent(R.id.ll_custom_next, broadcast3);
                        remoteViews.setOnClickPendingIntent(R.id.btn_custom_loop, broadcast4);
                        remoteViews.setOnClickPendingIntent(R.id.btn_custom_close, broadcast5);
                    }
                    str5 = "com.wear.live.notify.prev";
                    str2 = "com.wear.live.notify.play_state";
                    str3 = "com.wear.live.notify.next";
                    str4 = "com.wear.live.notify.close";
                }
                str9 = str5;
                str = "";
                PendingIntent broadcast6 = PendingIntent.getBroadcast(this, 1, q(this, str9), 201326592);
                PendingIntent broadcast22 = PendingIntent.getBroadcast(this, 2, q(this, str2), 201326592);
                PendingIntent broadcast32 = PendingIntent.getBroadcast(this, 3, q(this, str3), 201326592);
                PendingIntent broadcast42 = PendingIntent.getBroadcast(this, 4, q(this, str), 201326592);
                PendingIntent broadcast52 = PendingIntent.getBroadcast(this, 5, q(this, str4), 201326592);
                remoteViews.setOnClickPendingIntent(R.id.ll_custom_prev, broadcast6);
                remoteViews.setOnClickPendingIntent(R.id.btn_custom_play, broadcast22);
                remoteViews.setOnClickPendingIntent(R.id.ll_custom_next, broadcast32);
                remoteViews.setOnClickPendingIntent(R.id.btn_custom_loop, broadcast42);
                remoteViews.setOnClickPendingIntent(R.id.btn_custom_close, broadcast52);
            }
            str9 = "com.wear.pattern.notify.prev";
            str6 = "com.wear.pattern.notify.play_state";
            str7 = "com.wear.pattern.notify.next";
            str8 = "com.wear.pattern.notify.loop";
            str4 = "com.wear.pattern.notify.close";
        }
        String str10 = str7;
        str2 = str6;
        str = str8;
        str3 = str10;
        PendingIntent broadcast62 = PendingIntent.getBroadcast(this, 1, q(this, str9), 201326592);
        PendingIntent broadcast222 = PendingIntent.getBroadcast(this, 2, q(this, str2), 201326592);
        PendingIntent broadcast322 = PendingIntent.getBroadcast(this, 3, q(this, str3), 201326592);
        PendingIntent broadcast422 = PendingIntent.getBroadcast(this, 4, q(this, str), 201326592);
        PendingIntent broadcast522 = PendingIntent.getBroadcast(this, 5, q(this, str4), 201326592);
        remoteViews.setOnClickPendingIntent(R.id.ll_custom_prev, broadcast62);
        remoteViews.setOnClickPendingIntent(R.id.btn_custom_play, broadcast222);
        remoteViews.setOnClickPendingIntent(R.id.ll_custom_next, broadcast322);
        remoteViews.setOnClickPendingIntent(R.id.btn_custom_loop, broadcast422);
        remoteViews.setOnClickPendingIntent(R.id.btn_custom_close, broadcast522);
    }

    public final synchronized void y(int i, String str, String str2, boolean z, int i2, String str3, int i3, int i4, int i5) {
        try {
            String str4 = "mNotificationManager update: " + i;
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        if (R) {
            if (this.e == null) {
                return;
            }
            if (i == 0 || i == 99) {
                t();
            }
            z(i, str, str2, z, i2, str3, i3, i4, this.g, i5);
            z(i, str, str2, z, i2, str3, i3, i4, this.h, i5);
            if (i == 0 || i == 99) {
                if (WearUtils.e1(str3)) {
                    int i6 = this.b;
                    int i7 = 4;
                    if (i6 == 0) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.j);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.k);
                    } else if (i6 == 1) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.l);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.m);
                    } else if (i6 == 2) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.n);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.o);
                    } else if (i6 == 3) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.p);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.q);
                    } else if (i6 == 4) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.r);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.s);
                    } else if (i6 == 5) {
                        this.g.setImageViewResource(R.id.custom_song_icon, this.t);
                        this.h.setImageViewResource(R.id.custom_song_icon, this.u);
                    }
                    RemoteViews remoteViews = this.h;
                    int i8 = this.b;
                    if (i8 != 2 && i8 != 3 && i8 != 4 && i8 != 5) {
                        i7 = 0;
                    }
                    remoteViews.setViewVisibility(R.id.btn_custom_loop, i7);
                } else {
                    String str5 = "setNotification: " + str3;
                    ImageLoader.getInstance().loadImage(str3, MyApplication.Y, new a());
                }
            }
            String str6 = ": mNotificationManager   5555 " + i;
            this.d.notify(1231, this.e.build());
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.c.postDelayed(new b(), 500L);
            }
        }
    }

    public final void z(int i, String str, String str2, boolean z, int i2, String str3, int i3, int i4, RemoteViews remoteViews, int i5) {
        if (this.e == null) {
            return;
        }
        if (remoteViews != null) {
            if (i != 99) {
                int i6 = R.drawable.widget_previous_dark_disable;
                switch (i) {
                    case 0:
                        u(str, str2, z, i2, str3, i3, i4, remoteViews, i5);
                        break;
                    case 1:
                        remoteViews.setViewVisibility(R.id.music_loading_1, 8);
                        remoteViews.setViewVisibility(R.id.btn_custom_play, 0);
                        if (z) {
                            remoteViews.setImageViewResource(R.id.btn_custom_play, this.A);
                        } else {
                            remoteViews.setImageViewResource(R.id.btn_custom_play, this.z);
                        }
                        this.M = z;
                        break;
                    case 2:
                        this.E = i2;
                        if (i2 == 1) {
                            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.w);
                            break;
                        } else if (i2 == 2) {
                            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.x);
                            break;
                        } else {
                            remoteViews.setImageViewResource(R.id.btn_custom_loop, this.y);
                            break;
                        }
                    case 3:
                        remoteViews.setViewVisibility(R.id.music_loading_1, 0);
                        remoteViews.setViewVisibility(R.id.btn_custom_play, 8);
                        break;
                    case 4:
                    case 7:
                        if (!this.P) {
                            i6 = R.drawable.widget_previous_light_disable;
                        }
                        remoteViews.setImageViewResource(R.id.btn_custom_prev, i6);
                        remoteViews.setImageViewResource(R.id.btn_custom_next, this.P ? R.drawable.widget_next_dark_disable : R.drawable.widget_next_light_disable);
                        break;
                    case 5:
                    case 6:
                        this.O = i4;
                        int i7 = R.drawable.widget_next;
                        if (i4 != 0) {
                            int i8 = R.drawable.widget_previous;
                            if (i4 != 100) {
                                if (!this.P) {
                                    i8 = R.drawable.widget_previous_dark;
                                }
                                remoteViews.setImageViewResource(R.id.btn_custom_prev, i8);
                                if (!this.P) {
                                    i7 = R.drawable.widget_next_dark;
                                }
                                remoteViews.setImageViewResource(R.id.btn_custom_next, i7);
                                break;
                            } else {
                                if (!this.P) {
                                    i8 = R.drawable.widget_previous_dark;
                                }
                                remoteViews.setImageViewResource(R.id.btn_custom_prev, i8);
                                remoteViews.setImageViewResource(R.id.btn_custom_next, this.P ? R.drawable.widget_next_dark_disable : R.drawable.widget_next_light_disable);
                                break;
                            }
                        } else {
                            if (!this.P) {
                                i6 = R.drawable.widget_previous_light_disable;
                            }
                            remoteViews.setImageViewResource(R.id.btn_custom_prev, i6);
                            if (!this.P) {
                                i7 = R.drawable.widget_next_dark;
                            }
                            remoteViews.setImageViewResource(R.id.btn_custom_next, i7);
                            break;
                        }
                }
            } else {
                u(str, str2, z, i2, str3, i3, i4, remoteViews, i5);
            }
        }
        if (i == 0 || i == 99) {
            x(remoteViews);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaMusicChangeEvent ninjaMusicChangeEvent) {
        this.b = 0;
        y(ninjaMusicChangeEvent.getChangeStatus(), ninjaMusicChangeEvent.getPatternName(), ninjaMusicChangeEvent.getPatternAuthor(), ninjaMusicChangeEvent.isPlayOrPause(), ninjaMusicChangeEvent.getNowMode(), ninjaMusicChangeEvent.getImagePath(), ninjaMusicChangeEvent.getMusicDuration(), -1, ninjaMusicChangeEvent.getMusicType());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaSpeedModeChangeEvent ninjaSpeedModeChangeEvent) {
        this.b = 2;
        y(ninjaSpeedModeChangeEvent.getChangeStatus(), ah4.e(R.string.discover_speed_mode), "", ninjaSpeedModeChangeEvent.isPlayOrPause(), 0, null, -1, ninjaSpeedModeChangeEvent.getSensitivity(), -1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaSoundChangeEvent ninjaSoundChangeEvent) {
        this.b = 3;
        y(ninjaSoundChangeEvent.getChangeStatus(), ninjaSoundChangeEvent.getTitle(), "", ninjaSoundChangeEvent.isPlayOrPause(), 0, null, -1, ninjaSoundChangeEvent.getSensitivity(), -1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaRemoteChangeEvent ninjaRemoteChangeEvent) {
        this.b = 4;
        y(ninjaRemoteChangeEvent.getChangeStatus(), ninjaRemoteChangeEvent.getTitle(), "", ninjaRemoteChangeEvent.isPlayOrPause(), 0, null, -1, ninjaRemoteChangeEvent.getSensitivity(), -1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaLiveChangeEvent ninjaLiveChangeEvent) {
        this.b = 5;
        y(ninjaLiveChangeEvent.getChangeStatus(), ninjaLiveChangeEvent.getTitle(), "", ninjaLiveChangeEvent.isPlayOrPause(), 0, null, -1, ninjaLiveChangeEvent.getSensitivity(), -1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(OpenLockEvent openLockEvent) {
        this.Q = openLockEvent.isCheck();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationCloseEvent notificationCloseEvent) {
        R = false;
        stopSelf();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationMusicCloseEvent notificationMusicCloseEvent) {
        if (this.b == 0) {
            R = false;
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationPatternCloseEvent notificationPatternCloseEvent) {
        if (this.b == 1) {
            R = false;
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationSpeedModeCloseEvent notificationSpeedModeCloseEvent) {
        if (this.b == 2) {
            R = false;
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationSoundCloseEvent notificationSoundCloseEvent) {
        if (this.b == 3) {
            R = false;
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationRemoteCloseEvent notificationRemoteCloseEvent) {
        if (this.b == 4) {
            R = false;
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationLiveCloseEvent notificationLiveCloseEvent) {
        if (this.b == 5) {
            R = false;
            stopSelf();
        }
    }
}
