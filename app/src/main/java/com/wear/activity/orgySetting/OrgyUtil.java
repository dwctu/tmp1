package com.wear.activity.orgySetting;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.activity.orgySetting.OrgyActivityBean;
import com.wear.bean.Orgy;
import com.wear.broadcast.NotificationSyncService;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.eg3;
import dc.nd3;
import dc.og3;
import dc.xe3;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class OrgyUtil {
    public static String TAG = "OrgyTestLogo";
    private static volatile OrgyUtil instance = null;
    public static boolean isCreated = false;

    public interface OrgySaveListen {
        void orgySaveImageResult();
    }

    public static void clearActivityData() {
        eg3.m(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY);
        DaoUtils.getOrgyDao().delById(ch3.n().r());
        OrgySetting.getInstance().checkTimer();
    }

    public static void createNotification(Date date) {
        try {
            if (WearUtils.x.f0() && !isCreated) {
                long time = date.getTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis <= time || jCurrentTimeMillis - time <= 110000) {
                    isCreated = true;
                    boolean zB = og3.b(2) & WearUtils.M;
                    if (WearUtils.x == null) {
                        return;
                    }
                    Intent intent = new Intent(WearUtils.x, (Class<?>) NotificationSyncService.class);
                    intent.setAction("com.wear.chat.NOTIFICATION_SYNC");
                    PendingIntent service = PendingIntent.getService(WearUtils.x, 1, intent, 201326592);
                    if (Build.VERSION.SDK_INT >= 26) {
                        createrNotificationAndroid0("Come share your pleasure with the world!", "The Lovense Orgy has started. ", service, zB, WearUtils.x);
                    } else {
                        createrNotificationAndroid("Come share your pleasure with the world!", "The Lovense Orgy has started. ", service, zB, WearUtils.x);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createrNotificationAndroid(String str, String str2, PendingIntent pendingIntent, boolean z, Application application) {
        NotificationManager notificationManager = (NotificationManager) application.getSystemService("notification");
        NotificationCompat.Builder number = new NotificationCompat.Builder(application).setSmallIcon(R.drawable.notif_launcher).setColor(application.getResources().getColor(R.color.notification_color)).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(100166);
        number.setContentTitle(str2);
        number.setContentText(str);
        if (z) {
            number.setDefaults(-1);
        }
        MyApplication.k0.put(100166, "100166");
        notificationManager.notify("100166", 100166, number.build());
    }

    @RequiresApi(api = 26)
    private static void createrNotificationAndroid0(String str, String str2, PendingIntent pendingIntent, boolean z, Application application) {
        String str3;
        NotificationManager notificationManager = (NotificationManager) application.getSystemService("notification");
        if (z) {
            str3 = "com.lovense.wear.notic.sound";
            NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.sound", "RemoteNotificationSound", 5);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setDescription("description of this notification");
            notificationChannel.setLightColor(-16711936);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setName("RemoteNotificationSound");
            notificationChannel.setShowBadge(true);
            notificationChannel.setSound(WearUtils.S(), notificationChannel.getAudioAttributes());
            notificationManager.createNotificationChannel(notificationChannel);
        } else {
            str3 = "com.lovense.wear.notic.silence";
            NotificationChannel notificationChannel2 = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
            notificationChannel2.setLockscreenVisibility(-1);
            notificationChannel2.setDescription("description of this notification");
            notificationChannel2.setName("RemoteNotificationSilence");
            notificationChannel2.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
        NotificationCompat.Builder number = new NotificationCompat.Builder(application, str3).setSmallIcon(R.drawable.icon_notification).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(100166);
        number.setContentTitle(str2);
        number.setContentText(str);
        MyApplication.k0.put(100166, "100166");
        notificationManager.notify("100166", 100166, number.build());
    }

    public static synchronized OrgyUtil getInstance() {
        if (instance == null) {
            synchronized (OrgyUtil.class) {
                if (instance == null) {
                    instance = new OrgyUtil();
                }
            }
        }
        return instance;
    }

    public static String getShowBannerStatus(int i, String str) {
        HashMap map;
        Orgy orgy = DaoUtils.getOrgyDao().getOrgy(ch3.n().r(), str);
        if (orgy == null) {
            return "1";
        }
        String showBanner = orgy.getShowBanner();
        if (!WearUtils.e1(showBanner) && (map = (HashMap) WearUtils.A.fromJson(showBanner, HashMap.class)) != null) {
            if (map.get(i + "") != null) {
                return (String) map.get(i + "");
            }
        }
        return "1";
    }

    private void imageSave(List<String> list, final List<String> list2, final OrgySaveListen orgySaveListen) {
        for (final String str : list) {
            File file = ImageLoader.getInstance().getDiskCache().get(str);
            if (file == null || !file.exists()) {
                ImageLoader.getInstance().loadImage(str, MyApplication.Y, new SimpleImageLoadingListener() { // from class: com.wear.activity.orgySetting.OrgyUtil.2
                    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                        xe3.a(OrgyUtil.TAG, "保存成功! 活动图片" + str2 + "");
                        synchronized (list2) {
                            list2.remove(str);
                            if (list2.size() == 0) {
                                orgySaveListen.orgySaveImageResult();
                            }
                        }
                    }

                    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        xe3.a(OrgyUtil.TAG, "保存失败! 活动图片" + str2 + "");
                        synchronized (list2) {
                            list2.remove(str);
                            if (list2.size() == 0) {
                                orgySaveListen.orgySaveImageResult();
                            }
                        }
                    }
                });
            } else {
                synchronized (list2) {
                    list2.remove(str);
                    if (list2.size() == 0) {
                        orgySaveListen.orgySaveImageResult();
                    }
                }
            }
        }
    }

    public static boolean isBetween(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        xe3.a(TAG, "isBetween: " + jCurrentTimeMillis + "   " + j + "   " + j2);
        long j3 = jCurrentTimeMillis / 1000;
        return j3 >= j / 1000 && j3 <= j2 / 1000;
    }

    public static void updateShowBannerStatus(OrgyActivityBean.StageListBean stageListBean, int i, String str) {
        HashMap<String, String> map = new HashMap<String, String>(i) { // from class: com.wear.activity.orgySetting.OrgyUtil.3
            public final /* synthetic */ int val$showOrgyBanner;

            {
                this.val$showOrgyBanner = i;
                put(this.val$orgyStageBean.getPhaseId() + "", i + "");
            }
        };
        Orgy orgy = DaoUtils.getOrgyDao().getOrgy(ch3.n().r(), str);
        if (orgy == null) {
            orgy = new Orgy(ch3.n().r(), str);
            orgy.setShowBanner(map);
        } else {
            String showBanner = orgy.getShowBanner();
            if (WearUtils.e1(showBanner)) {
                orgy.setShowBanner(map);
            } else {
                HashMap map2 = (HashMap) WearUtils.A.fromJson(showBanner, HashMap.class);
                map2.put(stageListBean.getPhaseId() + "", i + "");
                orgy.setShowBanner(map2);
            }
        }
        DaoUtils.getOrgyDao().updateOrAdd(orgy);
    }

    public OrgyActivityBean.StageListBean getPhaseData(OrgyActivityBean orgyActivityBean) {
        if (orgyActivityBean == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis >= orgyActivityBean.getStartTime() && jCurrentTimeMillis <= orgyActivityBean.getEndTime()) {
            List<OrgyActivityBean.StageListBean> stageList = orgyActivityBean.getStageList();
            for (int i = 0; i < stageList.size(); i++) {
                OrgyActivityBean.StageListBean stageListBean = stageList.get(i);
                if (jCurrentTimeMillis > stageListBean.getPhaseStartTime() && jCurrentTimeMillis < stageListBean.getPhaseEndTime()) {
                    return stageListBean;
                }
            }
        }
        return null;
    }

    public void saveOrgyActivity(final OrgyActivityBean orgyActivityBean) {
        String strValueOf = String.valueOf(eg3.b(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY, ""));
        if (!WearUtils.e1(strValueOf)) {
            String strI = nd3.i(strValueOf);
            if (!WearUtils.e1(strI)) {
                xe3.a(TAG, "更新活动数据！ " + strI);
                OrgyActivityBean orgyActivityBean2 = (OrgyActivityBean) WearUtils.A.fromJson(strI, OrgyActivityBean.class);
                if (orgyActivityBean2.getId() == orgyActivityBean.getId()) {
                    for (OrgyActivityBean.StageListBean stageListBean : orgyActivityBean2.getStageList()) {
                        List<OrgyActivityBean.StageListBean.AppStartImgBean> appStartImg = stageListBean.getAppStartImg();
                        for (int i = 0; i < appStartImg.size(); i++) {
                            OrgyActivityBean.StageListBean.AppStartImgBean appStartImgBean = appStartImg.get(i);
                            for (OrgyActivityBean.StageListBean stageListBean2 : orgyActivityBean.getStageList()) {
                                if (stageListBean2.getPhaseId() == stageListBean.getPhaseId()) {
                                    stageListBean2.setShowCount(stageListBean.getShowCount());
                                    stageListBean2.setEachDay(stageListBean.getEachDay());
                                    List<OrgyActivityBean.StageListBean.AppStartImgBean> appStartImg2 = stageListBean2.getAppStartImg();
                                    for (int i2 = 0; i2 < appStartImg2.size(); i2++) {
                                        if (appStartImg2.get(i2).getUrl().equals(appStartImgBean.getUrl())) {
                                            appStartImg2.get(i2).setCount(appStartImgBean.getCount());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    eg3.i(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY, nd3.u(WearUtils.A.toJson(orgyActivityBean)));
                }
            }
        }
        List<OrgyActivityBean.StageListBean> stageList = orgyActivityBean.getStageList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < stageList.size(); i3++) {
            OrgyActivityBean.StageListBean stageListBean3 = stageList.get(i3);
            List<OrgyActivityBean.StageListBean.AppStartImgBean> appStartImg3 = stageListBean3.getAppStartImg();
            for (int i4 = 0; i4 < appStartImg3.size(); i4++) {
                OrgyActivityBean.StageListBean.AppStartImgBean appStartImgBean2 = appStartImg3.get(i4);
                arrayList.add(appStartImgBean2.getUrl());
                arrayList2.add(appStartImgBean2.getUrl());
            }
            if (stageListBean3.getFixedBtnImg().size() >= 1 && !WearUtils.e1(stageListBean3.getFixedBtnImg().get(0).getUrl())) {
                arrayList.add(stageListBean3.getFixedBtnImg().get(0).getUrl());
                arrayList2.add(stageListBean3.getFixedBtnImg().get(0).getUrl());
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            imageSave(arrayList, arrayList2, new OrgySaveListen() { // from class: com.wear.activity.orgySetting.OrgyUtil.1
                @Override // com.wear.activity.orgySetting.OrgyUtil.OrgySaveListen
                public void orgySaveImageResult() {
                    xe3.a(OrgyUtil.TAG, "活动图片保存成功: ");
                    eg3.i(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY, nd3.u(WearUtils.A.toJson(orgyActivityBean)));
                }
            });
        } else {
            xe3.a(TAG, "没有活动图片，保存数据 ");
            eg3.i(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY, nd3.u(WearUtils.A.toJson(orgyActivityBean)));
        }
    }
}
