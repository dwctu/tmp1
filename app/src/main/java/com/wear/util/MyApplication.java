package com.wear.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.alibaba.fastjson.JSON;
import com.dx.log.logapplication.service.ILogRemoteAidlInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.L;
import com.wear.SyncAccessActivity;
import com.wear.bean.AccountSetting;
import com.wear.bean.Alarm;
import com.wear.bean.AnalyticsBean;
import com.wear.bean.ControlIdBean;
import com.wear.bean.GiftCard;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.OpenAppBean;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.SensitiveWord;
import com.wear.bean.Setting;
import com.wear.bean.SwitchBean;
import com.wear.bean.TimestampBean;
import com.wear.bean.Toy;
import com.wear.bean.UpdateVersionBean;
import com.wear.bean.User;
import com.wear.bean.VMShareDataBean;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.GiftCardEvent;
import com.wear.bean.event.VersionUpdataEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.request.VersionHistoryRequest;
import com.wear.bean.response.GiftCardResponse;
import com.wear.bean.response.SensitiveWordResponse;
import com.wear.bean.response.VersionHistoryResponse;
import com.wear.broadcast.NetworkReceiver;
import com.wear.broadcast.NotificationChatService;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.main.FlashActivity;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityGiftCard;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.widget.MyActionBar;
import dc.a12;
import dc.ad4;
import dc.ah4;
import dc.cj3;
import dc.db2;
import dc.dd2;
import dc.df3;
import dc.di4;
import dc.ee3;
import dc.eg3;
import dc.f71;
import dc.fh3;
import dc.fh4;
import dc.fl3;
import dc.fo3;
import dc.gl2;
import dc.gu3;
import dc.hu3;
import dc.il2;
import dc.lg3;
import dc.mk3;
import dc.ml2;
import dc.n82;
import dc.nd3;
import dc.nf3;
import dc.nn3;
import dc.ob2;
import dc.og3;
import dc.pc1;
import dc.pd3;
import dc.pe3;
import dc.pz;
import dc.qg3;
import dc.re3;
import dc.rn3;
import dc.sg3;
import dc.sz1;
import dc.ti1;
import dc.tn2;
import dc.tt1;
import dc.vg3;
import dc.wi2;
import dc.wn2;
import dc.xe3;
import dc.y12;
import dc.yd3;
import dc.ye3;
import dc.yn2;
import dc.zg4;
import dc.zn2;
import dc.zt3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* loaded from: classes4.dex */
public class MyApplication extends MultiDexApplication {
    public static FragmentActivity K;
    public static Activity L;
    public static MainActivity M;
    public static VersionUpdataEvent S;
    public static OpenAppBean U;
    public static VMShareDataBean V;
    public static String W;
    public static fh3 X;
    public static DisplayImageOptions Y;
    public static boolean a0;
    public static String b0;
    public static FirebaseAuth c0;
    public static boolean l0;
    public static int m0;
    public static MyActionBar o0;
    public static FirebaseAuth.AuthStateListener p0;
    public static gl2 r0;
    public static MyApplication s0;
    public ILogRemoteAidlInterface A;
    public Configuration B;
    public boolean b;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public Handler l;
    public Handler m;
    public boolean p;
    public AnalyticsBean r;
    public String w;
    public pc1 x;
    public HeadsetPlugReceiver y;
    public NetWorkStateReceiver z;
    public static final Integer C = 15000;
    public static final String D = MyApplication.class.getSimpleName();
    public static final String E = WearUtils.r0("configToyDev");
    public static final String F = WearUtils.r0("configToyRes");
    public static ScanQRDataBean G = null;
    public static boolean N = false;
    public static boolean O = false;
    public static boolean P = false;
    public static int Q = 0;
    public static boolean R = false;
    public static boolean T = true;
    public static boolean Z = true;
    public static db2 d0 = null;
    public static a12 e0 = null;
    public static Map<Integer, SwitchBean.ToEntity> f0 = new HashMap();
    public static boolean g0 = false;
    public static boolean h0 = false;
    public static boolean i0 = false;
    public static boolean j0 = false;
    public static Map<Integer, String> k0 = new HashMap();
    public static boolean n0 = true;
    public static boolean q0 = false;
    public int a = 100;
    public int c = -1;
    public n82 i = new n82();
    public int j = -1;
    public AudioManager k = null;
    public boolean n = false;
    public boolean o = false;
    public Stack<Activity> q = new j();
    public boolean s = false;
    public boolean t = false;
    public Setting u = null;
    public Map<String, Object> v = new HashMap();

    public class BluetoothConnectionReceiver extends BroadcastReceiver {
        public BluetoothConnectionReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                if (intExtra == 2 || intExtra == 0) {
                    if (intExtra == 2) {
                        MyApplication.this.o0(false);
                        return;
                    } else {
                        MyApplication.this.o0(true);
                        MusicControl.h0().p0();
                        return;
                    }
                }
                return;
            }
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra2 == 13) {
                    ye3.d("S0003", "蓝牙关闭中。。。。。");
                    return;
                }
                if (intExtra2 == 10) {
                    ye3.d("S0003", "蓝牙成功关闭");
                    MyApplication.this.x.A();
                } else if (intExtra2 == 12) {
                    ye3.d("S0003", "蓝牙成功开启");
                } else if (intExtra2 == 11) {
                    ye3.d("S0003", "蓝牙开启中。。。。。");
                }
            }
        }
    }

    public class HeadsetPlugReceiver extends BroadcastReceiver {
        public HeadsetPlugReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = MyApplication.D;
            String str2 = "onReceive: " + intent.getAction() + "   " + intent.getIntExtra("state", -1);
            MyApplication myApplication = MyApplication.this;
            if (!myApplication.t) {
                myApplication.t = true;
                return;
            }
            if (intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 0) {
                    MyApplication.this.o0(true);
                    MusicControl.h0().p0();
                } else if (intent.getIntExtra("state", 0) == 1) {
                    MyApplication.this.o0(false);
                }
            }
        }
    }

    public class MediaButtonAReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = MyApplication.D;
            String str2 = "onReceive: " + intent.getAction() + "   " + intent.getIntExtra("state", -1);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                Thread.sleep(3000L);
                AudioManager audioManager = MyApplication.this.k;
                if (audioManager == null) {
                    return;
                }
                if (!this.a) {
                    audioManager.setSpeakerphoneOn(false);
                    MyApplication.this.k.setMode(0);
                } else if (!audioManager.isWiredHeadsetOn() && !MyApplication.this.k.isBluetoothA2dpOn() && !MyApplication.this.k.isBluetoothScoOn()) {
                    MyApplication.this.k.setSpeakerphoneOn(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements zn2<String> {

        public class a implements fo3.c {
            public final /* synthetic */ UpdateVersionBean a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ String c;

            /* renamed from: com.wear.util.MyApplication$b$a$a, reason: collision with other inner class name */
            public class C0157a implements nn3.e {
                public C0157a() {
                }

                @Override // dc.nn3.e
                public void doCancel() {
                    MyApplication.R = true;
                    if (a.this.b) {
                        MyApplication.D();
                    }
                }
            }

            public a(b bVar, UpdateVersionBean updateVersionBean, boolean z, String str) {
                this.a = updateVersionBean;
                this.b = z;
                this.c = str;
            }

            @Override // dc.fo3.c
            public void a() {
                if (WearUtils.M(MyApplication.H()).contains("remote")) {
                    new nn3(MyApplication.H(), this.a.getApkUrl(), this.b, new C0157a()).show();
                    return;
                }
                MyApplication.R = true;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.c));
                MyApplication.H().startActivity(intent);
                MyApplication.D();
            }

            @Override // dc.fo3.c
            public void doCancel() {
                MyApplication.R = true;
                if (this.b) {
                    MyApplication.D();
                }
            }
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            String str2 = MyApplication.D;
            String str3 = "onSuccess: " + str;
            if (MyApplication.H() == null || WearUtils.e1(str)) {
                return;
            }
            try {
                UpdateVersionBean updateVersionBean = (UpdateVersionBean) JSON.parseObject(str, UpdateVersionBean.class);
                if (updateVersionBean == null) {
                    return;
                }
                if (!updateVersionBean.isHasUpdate()) {
                    MyApplication.R = true;
                    ee3.l();
                    return;
                }
                boolean zIsForce = updateVersionBean.isForce();
                String url = updateVersionBean.getUrl();
                ah4.e(R.string.common_cancel);
                if (zIsForce) {
                    ah4.e(R.string.common_exit);
                } else {
                    MyApplication.R = true;
                    if (WearUtils.e1(updateVersionBean.getVersion())) {
                        updateVersionBean.setVersion(updateVersionBean.getUrl());
                    }
                    MyApplication.S = null;
                    AccountSetting accountSetting = DaoUtils.getAccountSettingDao().getAccountSetting(zt3.k, updateVersionBean.getVersion());
                    if (accountSetting == null || !accountSetting.isTip()) {
                        MyApplication.S = new VersionUpdataEvent(updateVersionBean, true);
                    } else {
                        MyApplication.S = new VersionUpdataEvent(updateVersionBean, false);
                    }
                    EventBus.getDefault().post(MyApplication.S);
                }
                new fo3(MyApplication.H(), updateVersionBean.getChanges(), zIsForce, new a(this, updateVersionBean, zIsForce, url)).show();
            } catch (Exception unused) {
                MyApplication.R = true;
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class c implements Runnable {
        public c(MyApplication myApplication) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyApplication.H() != null && hu3.z(MyApplication.H()) != null) {
                hu3.z(MyApplication.H()).w(true);
            }
            if (MusicControl.h0().e != null) {
                MusicControl.h0().e.G();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageType messageType;
            try {
                if (MyApplication.this.v == null || MyApplication.this.v.size() <= 0) {
                    return;
                }
                for (Map.Entry entry : MyApplication.this.v.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof rn3) {
                        rn3 rn3Var = (rn3) value;
                        rn3Var.c();
                        sz1.d().s(rn3Var);
                        String str = (String) entry.getKey();
                        if (gu3.j.getAvailable() != null && (gu3.j.getAvailable().equals(ControlIdBean.Status.cancel) || gu3.j.getAvailable().equals(ControlIdBean.Status.end))) {
                            MyApplication.this.k0(str);
                            return;
                        }
                        MessageType messageType2 = MessageType.live;
                        if (str.endsWith(messageType2.toString())) {
                            messageType = messageType2;
                        } else {
                            messageType = MessageType.sync;
                            if (!str.endsWith(messageType.toString())) {
                                messageType = MessageType.video;
                                if (!str.endsWith(messageType.toString())) {
                                    messageType = MessageType.voice;
                                    if (!str.endsWith(messageType.toString())) {
                                        return;
                                    }
                                }
                            }
                        }
                        String strSubstring = str.substring(0, str.length() - messageType.toString().length());
                        if (messageType == messageType2) {
                            EntityLive entityLive = new EntityLive();
                            entityLive.setType(EntityLive.LiveOPTType.networkError.toString());
                            entityLive.setId(gu3.j.getControlId());
                            hu3.u(entityLive, strSubstring, WearUtils.y.p());
                        } else if (messageType == MessageType.sync) {
                            EntitySync entitySync = new EntitySync();
                            entitySync.setType(EntitySync.SyncOPTType.networkError.toString());
                            entitySync.setId(gu3.j.getControlId());
                            hu3.u(entitySync, strSubstring, WearUtils.y.p());
                        } else if (messageType == MessageType.video) {
                            WearUtils.z2();
                            EntityVideo entityVideo = new EntityVideo();
                            entityVideo.setType(EntityVideo.VideoOPTType.networkError.toString());
                            entityVideo.setId(gu3.j.getControlId());
                            hu3.u(entityVideo, strSubstring, WearUtils.y.p());
                        } else if (messageType == MessageType.voice) {
                            WearUtils.z2();
                            EntityVoice entityVoice = new EntityVoice();
                            entityVoice.setType(EntityVoice.VoiceOPTType.networkError.toString());
                            entityVoice.setId(gu3.j.getControlId());
                            hu3.u(entityVoice, strSubstring, WearUtils.y.p());
                        }
                        MyApplication.this.k0(str);
                        gu3.j.setAvailable(ControlIdBean.Status.cancel);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements zn2<String> {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse;
            if (WearUtils.e1(str) || (normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class)) == null || !normalResponse.isResult() || normalResponse.getData() == null || WearUtils.e1(normalResponse.getData().toString())) {
                return;
            }
            eg3.i(MyApplication.this, this.a, normalResponse.getData());
            String strH = nd3.h((String) normalResponse.getData());
            xe3.a("TOY_CONFIG_UPDATE", strH);
            if (strH != null) {
                Toy.setToyConfig(strH);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            String str = MyApplication.D;
            String str2 = "getToyConfig error :" + netException.getMessage();
        }
    }

    public class f implements yn2<SensitiveWordResponse> {
        public f(MyApplication myApplication) {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SensitiveWordResponse sensitiveWordResponse) {
            if (sensitiveWordResponse != null) {
                String str = "onSuccess: 敏感词列表=" + sensitiveWordResponse.toString();
                if (!sensitiveWordResponse.isResult().booleanValue() || sensitiveWordResponse.getData() == null) {
                    return;
                }
                DaoUtils.getSensitiveWordDao().clear();
                List<SensitiveWord> data = sensitiveWordResponse.getData();
                if (data != null && data.size() > 0) {
                    Iterator<SensitiveWord> it = data.iterator();
                    while (it.hasNext()) {
                        it.next().initData();
                    }
                }
                DaoUtils.getSensitiveWordDao().add(data);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String str = "onError: 敏感词错误：" + netException.getMessage();
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class g implements yn2<VersionHistoryResponse> {
        public final /* synthetic */ wn2 a;

        public g(wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(VersionHistoryResponse versionHistoryResponse) {
            String str = "onSuccess: versionHistory=" + versionHistoryResponse.toString();
            if (!versionHistoryResponse.getResult().booleanValue() || versionHistoryResponse.getData() == null) {
                this.a.d(new NetException("-1", "data error"), true);
            } else {
                this.a.a(true, versionHistoryResponse.getData());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.d(netException, true);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class h implements yn2<GiftCardResponse> {
        public final /* synthetic */ wn2 a;

        public h(wn2 wn2Var) {
            this.a = wn2Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GiftCardResponse giftCardResponse) {
            if (!giftCardResponse.getResult().booleanValue()) {
                onError(null);
                return;
            }
            if (giftCardResponse.getData() == null) {
                onError(null);
                return;
            }
            List<GiftCard> list = giftCardResponse.getData().getList();
            EventBus.getDefault().post(new GiftCardEvent(giftCardResponse.getData().getAcceptedNum()));
            if (list.size() > 0) {
                DaoUtils.getGiftCardDao().clear();
                DaoUtils.getGiftCardDao().add(list);
                MyApplication.this.B0(DaoUtils.getGiftCardDao().findAll());
            }
            wn2 wn2Var = this.a;
            if (wn2Var != null) {
                wn2Var.a(true, DaoUtils.getGiftCardDao().findAll());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            List<GiftCard> listFindAll = DaoUtils.getGiftCardDao().findAll();
            wn2 wn2Var = this.a;
            if (wn2Var != null) {
                wn2Var.a(true, listFindAll);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class i implements yn2<TimestampBean> {
        public i() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(TimestampBean timestampBean) {
            MyApplication.this.g = System.currentTimeMillis();
            if (timestampBean == null || !timestampBean.isResult()) {
                return;
            }
            long data = timestampBean.getData();
            if (data != 0) {
                MyApplication myApplication = MyApplication.this;
                long j = myApplication.d;
                if (j != 0) {
                    long j2 = myApplication.e;
                    if (j2 != 0) {
                        myApplication.h = (int) (data - (j + (r2 / 2)));
                        String str = "requestTime:" + MyApplication.this.d + ", responseTime:" + MyApplication.this.e + ", times=" + ((int) (j2 - j)) + ",timestamp:" + data + ", offsetTime:" + MyApplication.this.h;
                        return;
                    }
                }
            }
            MyApplication myApplication2 = MyApplication.this;
            long j3 = myApplication2.g;
            long j4 = myApplication2.f;
            myApplication2.h = (int) (data - (j4 + (((int) (j3 - j4)) / 2)));
            String str2 = "requestTimeNew:" + MyApplication.this.f + ", responseTimeNew:" + MyApplication.this.g + ", timestamp:" + data + ", offsetTime:" + MyApplication.this.h;
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class j extends Stack<Activity> {
        public j() {
        }

        @Override // java.util.Vector, java.util.AbstractCollection
        @NonNull
        public synchronized String toString() {
            StringBuilder sb;
            sb = new StringBuilder();
            for (Object obj : ((Stack) this).elementData) {
                if (obj instanceof Activity) {
                    sb.append(((Activity) obj).getLocalClassName());
                    sb.append("],[");
                }
            }
            return sb.substring(0, sb.length() - 2).toString();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MyApplication.this.l.postDelayed(this, MyApplication.C.intValue());
                wi2.e().f("MyApplication");
            } catch (Exception e) {
                String str = MyApplication.D;
                e.toString();
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
            tt1.a().c(MyApplication.this.getApplicationContext());
            MyApplication.X = new fh3(false);
            L.writeLogs(false);
            MyApplication.this.a0();
            re3.s();
            re3.r();
            yd3.c();
            yd3.d();
            qg3.f(MyApplication.s0);
            MyApplication.this.O();
            MyApplication.Y = new DisplayImageOptions.Builder().showImageOnFail(R.drawable.content_icon_picture_loading).cacheInMemory(false).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
            BluetoothConnectionReceiver bluetoothConnectionReceiver = MyApplication.this.new BluetoothConnectionReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                MyApplication.this.registerReceiver(bluetoothConnectionReceiver, intentFilter, 2);
            } else {
                MyApplication.this.registerReceiver(bluetoothConnectionReceiver, intentFilter);
            }
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.HEADSET_PLUG");
            MyApplication.this.y = MyApplication.this.new HeadsetPlugReceiver();
            if (i >= 33) {
                MyApplication myApplication = MyApplication.this;
                myApplication.registerReceiver(myApplication.y, intentFilter2, 2);
            } else {
                MyApplication myApplication2 = MyApplication.this;
                myApplication2.registerReceiver(myApplication2.y, intentFilter2);
            }
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            NetworkReceiver networkReceiver = new NetworkReceiver();
            if (i >= 33) {
                MyApplication.this.registerReceiver(networkReceiver, intentFilter3, 2);
            } else {
                MyApplication.this.registerReceiver(networkReceiver, intentFilter3);
            }
            if (MyApplication.this.z == null) {
                MyApplication.this.z = new NetWorkStateReceiver();
            }
            IntentFilter intentFilter4 = new IntentFilter();
            intentFilter4.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter4.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter4.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter4.addAction("android.net.wifi.STATE_CHANGE");
            if (i >= 33) {
                MyApplication myApplication3 = MyApplication.this;
                myApplication3.registerReceiver(myApplication3.z, intentFilter4, 2);
            } else {
                MyApplication myApplication4 = MyApplication.this;
                myApplication4.registerReceiver(myApplication4.z, intentFilter4);
            }
            MyApplication.this.j0();
            dd2.F().y(false);
            MyApplication.this.s();
        }
    }

    public class m implements Application.ActivityLifecycleCallbacks {
        public m() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            String str = "onActivityCreated: " + activity.getLocalClassName();
            MyApplication.this.q.push(activity);
            String str2 = "stack=: " + MyApplication.this.q.toString();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            String str = "onActivityDestroyed: " + activity.getLocalClassName();
            MyApplication.this.q.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            String str = "onActivityPaused: " + activity.getLocalClassName();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            String str = "onActivityResumed: " + activity.getLocalClassName();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            String str = "onActivitySaveInstanceState: " + activity.getLocalClassName();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            String str = "onActivityStarted: " + activity.getLocalClassName();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            String str = "onActivityStopped: " + activity.getLocalClassName();
        }
    }

    public class n implements FirebaseAuth.AuthStateListener {
        public n(MyApplication myApplication) {
        }

        @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser == null) {
                String str = MyApplication.D;
                return;
            }
            String str2 = MyApplication.D;
            String str3 = "onAuthStateChanged:signed_in:" + currentUser.getUid();
        }
    }

    public class o implements zg4.b {
        public o(MyApplication myApplication) {
        }

        @Override // dc.zg4.b
        public void a(String str) {
            String str2 = MyApplication.D;
            String str3 = "onFailed: " + str;
        }

        @Override // dc.zg4.b
        public void onStart() {
            String str = MyApplication.D;
        }

        @Override // dc.zg4.b
        public void onSuccess() {
            String str = MyApplication.D;
        }
    }

    public class p implements nf3.e {
        @Override // dc.nf3.e
        public void a(ad4 ad4Var, Exception exc) {
            if (ad4Var == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("测试主域名失败：");
                sb.append(exc != null ? exc.getMessage() : " 空");
                xe3.a("Request", sb.toString());
                MyApplication.A0();
                return;
            }
            if (ad4Var.f() != 200) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("测试主域名失败：");
                sb2.append(exc != null ? exc.getMessage() : " 空");
                xe3.a("Request", sb2.toString());
                MyApplication.A0();
                return;
            }
            MyApplication.n0 = true;
            pe3.h("userDefault", Boolean.TRUE);
            xe3.a("Request", "测试主域名成功啦：" + MyApplication.n0);
            WearUtils.e();
            boolean unused = MyApplication.q0 = false;
        }
    }

    public class q implements nf3.e {
        @Override // dc.nf3.e
        public void a(ad4 ad4Var, Exception exc) {
            if (ad4Var == null) {
                MyApplication.n0 = true;
                pe3.h("userDefault", Boolean.TRUE);
                xe3.a("Request", "测试备用域名失败：" + MyApplication.n0);
                WearUtils.e();
                boolean unused = MyApplication.q0 = false;
                return;
            }
            if (ad4Var.f() == 200) {
                MyApplication.n0 = false;
                pe3.h("userDefault", Boolean.FALSE);
                xe3.a("Request", "测试备用域名成功：" + MyApplication.n0);
                boolean unused2 = MyApplication.q0 = false;
                WearUtils.e();
                return;
            }
            MyApplication.n0 = true;
            pe3.h("userDefault", Boolean.TRUE);
            xe3.a("Request", "测试备用域名失败：" + MyApplication.n0);
            WearUtils.e();
            boolean unused3 = MyApplication.q0 = false;
        }
    }

    public class r implements ServiceConnection {
        public r() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyApplication.n(true);
            MyApplication.this.A = ILogRemoteAidlInterface.a.d(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MyApplication.this.A = null;
        }
    }

    static {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,SSLv3");
        System.getProperties().setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    }

    public MyApplication() {
        new HashMap();
    }

    public static void A0() {
        xe3.a("Request", "测试备用域名开始：" + n0);
        nf3.f("https://apps-dir.lovense.com/", new q());
    }

    public static void D() {
        d0.K();
        e0.h();
        f0.clear();
        if (p0 != null) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("notification");
            FirebaseAuth firebaseAuth = c0;
            if (firebaseAuth != null) {
                firebaseAuth.removeAuthStateListener(p0);
            }
        }
        Activity activity = L;
        if (activity != null) {
            activity.finish();
        }
        if (WearUtils.G != null) {
            WearUtils.x.unregisterReceiver(WearUtils.G);
        }
        Process.killProcess(Process.myTid());
    }

    public static gl2 F() {
        return r0;
    }

    public static FragmentActivity H() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (K == null && (runningTasks = ((ActivityManager) N().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningTasks(1)) != null && !runningTasks.isEmpty()) {
            try {
                K = (FragmentActivity) Class.forName(runningTasks.get(0).topActivity.getClassName()).newInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return K;
    }

    public static MyApplication N() {
        return s0;
    }

    public static PackageInfo Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int U() {
        try {
            return WearUtils.x.getPackageManager().getPackageInfo(WearUtils.x.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void V(VersionHistoryRequest versionHistoryRequest, wn2<VersionHistoryResponse.DataDTO> wn2Var) {
        String str = "getVersionHistory: request=" + versionHistoryRequest.toString();
        HashMap map = new HashMap();
        map.put("pf", versionHistoryRequest.getPf());
        map.put("lang", versionHistoryRequest.getLang());
        map.put(DataLayout.ELEMENT, versionHistoryRequest.getPage());
        map.put("pageSize", versionHistoryRequest.getPageSize());
        tn2.x(N()).j("/api/remote/getPlatform", map, new g(wn2Var));
    }

    public static boolean W() {
        UpdateVersionBean updateVersionBean;
        VersionUpdataEvent versionUpdataEvent = S;
        if (versionUpdataEvent == null || (updateVersionBean = versionUpdataEvent.versionBean) == null) {
            return true;
        }
        return updateVersionBean.isForce();
    }

    public static void l0() {
        ScanQRDataBean scanQRDataBean = G;
        if (scanQRDataBean != null) {
            scanQRDataBean.reportToService();
        }
    }

    public static /* synthetic */ boolean n(boolean z) {
        return z;
    }

    public static void r() {
        String country = WearUtils.x.getResources().getConfiguration().locale.getCountry();
        HashMap map = new HashMap();
        map.put("appType", "wearable");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("lan", country);
        map.put(PSOProgramService.VS_Key, ye3.s());
        tn2.x(WearUtils.x).t("/app/getUpdate/remote/android", map, new b());
    }

    public static void u0(MainActivity mainActivity) {
        M = mainActivity;
    }

    public static void v0(OpenAppBean openAppBean) {
        U = openAppBean;
    }

    public static void x0(VMShareDataBean vMShareDataBean) {
        V = vMShareDataBean;
    }

    public static void y0(Context context, String str) {
        try {
            String str2 = "startBrowser: 跳转浏览器url=" + str;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), "text/html");
            intent.addFlags(268435456);
            intent.addCategory("android.intent.category.BROWSABLE");
            context.startActivity(intent);
        } catch (Exception e2) {
            sg3.l("This link is not supported !");
            e2.printStackTrace();
        }
    }

    public static synchronized void z0(Context context) {
        if (!q0 && s0 != null) {
            q0 = true;
            n0 = pe3.c("userDefault", true);
            String string = context.getString(R.string.app_server);
            xe3.a("Request", "测试主域名开始：" + n0);
            nf3.f(string + "/", new p());
        }
    }

    @RequiresApi(api = 26)
    public final void A(String str, Group group, PendingIntent pendingIntent, GroupMember groupMember, boolean z, int i2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setDescription("description of this notification");
        notificationChannel.setName("RemoteNotificationSilence");
        notificationChannel.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannel);
        String showName = group.getShowNickName();
        NotificationCompat.Builder content = new NotificationCompat.Builder(this, "com.lovense.wear.notic.silence").setSmallIcon(R.drawable.icon_notification).setTicker(showName).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(group.getId())).setContent(d0(pendingIntent, showName, groupMember.getShowNickName(), z, str, group.getId(), i2));
        k0.put(Integer.valueOf(group.getId().hashCode()), group.getId().hashCode() + "");
        String str2 = "createrNotificationAndroid0: " + group.getId() + "   " + group.getId().hashCode();
        notificationManager.notify(group.getId().hashCode() + "", group.getId().hashCode(), content.build());
    }

    public final void B(String str, String str2, PendingIntent pendingIntent, String str3, boolean z, boolean z2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationCompat.Builder number = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.notification_color)).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(str3));
        if (z) {
            number.setContentTitle(str2);
            number.setContentText(str);
        } else {
            number.setContentTitle(str);
        }
        if (z2) {
            number.setDefaults(-1);
        }
        k0.put(Integer.valueOf(str3.hashCode()), str3.hashCode() + "");
        String str4 = "createrNotificationAndroid0: " + str3 + "   " + str3.hashCode();
        notificationManager.notify(str3.hashCode() + "", str3.hashCode(), number.build());
    }

    public final void B0(List<GiftCard> list) {
        List<CommunMessage> listFindAll = DaoUtils.getCommunMessageDao().findAll();
        if (listFindAll == null || listFindAll.size() <= 0 || list == null || list.size() <= 0) {
            return;
        }
        for (CommunMessage communMessage : listFindAll) {
            if (communMessage.getType() == MessageType.giftcard) {
                EntityGiftCard entityGiftCard = (EntityGiftCard) communMessage.syncDecryptBean();
                for (GiftCard giftCard : list) {
                    if (TextUtils.equals(entityGiftCard.getCardLink(), giftCard.getCardLink())) {
                        entityGiftCard = giftCard.toEntityGiftCard();
                        communMessage.sendEntity(entityGiftCard);
                        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                    }
                }
            }
        }
    }

    @RequiresApi(api = 26)
    public final void C(String str, String str2, PendingIntent pendingIntent, String str3, boolean z, boolean z2) {
        String str4;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (z2) {
            str4 = "com.lovense.wear.notic.sound";
            NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.sound", "RemoteNotificationSound", 3);
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
            str4 = "com.lovense.wear.notic.silence";
            NotificationChannel notificationChannel2 = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
            notificationChannel2.setLockscreenVisibility(-1);
            notificationChannel2.setDescription("description of this notification");
            notificationChannel2.setName("RemoteNotificationSilence");
            notificationChannel2.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
        NotificationCompat.Builder number = new NotificationCompat.Builder(this, str4).setSmallIcon(R.drawable.icon_notification).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(str3));
        if (z) {
            number.setContentTitle(str2);
            number.setContentText(str);
        } else {
            number.setContentText(str);
        }
        k0.put(Integer.valueOf(str3.hashCode()), str3.hashCode() + "");
        String str5 = "createrNotificationAndroid0: " + str3 + "   " + str3.hashCode();
        notificationManager.notify(str3.hashCode() + "", str3.hashCode(), number.build());
    }

    public void C0() {
        try {
            O = false;
            Z = true;
            EventBus.getDefault().post(ManagerRDBean.getManager());
            if (WearUtils.e1(eg3.h(WearUtils.x, "gen_token_Key", "")) || WearUtils.e1(WearUtils.t)) {
                return;
            }
            if (MusicControl.h0().O()) {
                MusicControl.h0().S();
            }
            y12.c.a().t();
            db2.A().K();
            hu3.R(H() != null ? H() : WearUtils.x);
            vg3.b().a(new c(this));
            eg3.m(WearUtils.x, "xmpp_password");
            eg3.m(WearUtils.x, "avatar_report_status");
            eg3.m(WearUtils.x, "gen_token_Key");
            eg3.m(WearUtils.x, "r_token_Key");
            WearUtils.s = "";
            WearUtils.t = "";
            ob2.o().J();
            db2.A().i = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void D0() {
        MyActionBar myActionBar = o0;
        if (myActionBar != null) {
            String str = (String) myActionBar.getYesImageBtn().getTag(R.id.tag1);
            if (WearUtils.e1(str) || !str.equals("toy")) {
                return;
            }
            o0.setRssiImage(this, H());
        }
    }

    public void E() {
        Iterator<Activity> it = pd3.j().a.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        D();
    }

    public final void E0() {
        l0 = (getApplicationContext().getResources().getConfiguration().uiMode & 32) != 0;
        m0 = pe3.d("SKIN");
        n0 = pe3.c("userDefault", true);
        int i2 = m0;
        if (i2 == 2 || (l0 && i2 == 0)) {
            zg4 zg4VarZ = zg4.z(s0);
            zg4VarZ.i(new fh4());
            zg4VarZ.i(new di4());
            zg4VarZ.w("skinman.apk", new o(this), 0);
            return;
        }
        zg4 zg4VarZ2 = zg4.z(s0);
        zg4VarZ2.i(new fh4());
        zg4VarZ2.i(new di4());
        zg4VarZ2.x();
    }

    public pc1 G() {
        if (this.x == null) {
            this.x = pc1.a;
        }
        return this.x;
    }

    public String I() {
        return this.w;
    }

    public Object J(String str) {
        return this.v.get(str);
    }

    public Alarm K(String str) {
        Alarm alarmFindAlarm = DaoUtils.getAlarmDao().findAlarm(str, str);
        if (alarmFindAlarm != null) {
            return alarmFindAlarm;
        }
        Alarm alarm = new Alarm();
        alarm.setOwnerEmail(str);
        alarm.setFriendEmail(str);
        alarm.setMissSwitchOn("false");
        alarm.setNotifySwitchOn("false");
        DaoUtils.getAlarmDao().addIfNotExist(alarm);
        return alarm;
    }

    public void L(int i2, wn2<List<GiftCard>> wn2Var) {
        tn2.x(N()).e("/remote/gift-card/list?type=" + i2, new h(wn2Var));
    }

    public MainActivity M() {
        return M;
    }

    public void O() {
        this.d = 0L;
        this.e = 0L;
        this.f = System.currentTimeMillis();
        tn2.x(N()).d("/date-web-api/api/server/timestamp", new i());
    }

    public void P() {
        String strH;
        String str = WearUtils.v ? E : F;
        try {
            if (eg3.a(this, str)) {
                strH = eg3.h(this, str, "");
            } else {
                strH = WearUtils.n(getAssets().open(WearUtils.v ? "ConfigToyDev.txt" : "ConfigToyRes.txt"));
                eg3.i(this, str, strH);
            }
            if (!WearUtils.e1(strH)) {
                String strH2 = nd3.h(strH);
                xe3.a("getToyConfig", strH2);
                if (!WearUtils.e1(strH2)) {
                    Toy.setToyConfig(strH2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, ye3.s());
        map.put("dataVersion", Integer.valueOf(WearUtils.v ? Toy.ConfigVersionDev : Toy.ConfigVersionRes));
        tn2.x(WearUtils.x).t("/app/toy/config/lastUpdate", map, new e(str));
    }

    public String R(String str) {
        if (WearUtils.e1(str)) {
            return "";
        }
        User userV = WearUtils.y.v(str);
        String strG0 = userV == null ? WearUtils.g0(str) : userV.getUserName();
        if (userV != null && !WearUtils.e1(userV.getRemark())) {
            strG0 = userV.getRemark();
        }
        return userV.isDateIng() ? userV.getShowNickName() : WearUtils.e1(strG0) ? "" : strG0;
    }

    public synchronized Setting S() {
        String strR = WearUtils.y.r();
        Setting setting = this.u;
        if (setting == null || TextUtils.isEmpty(setting.getId()) || !this.u.getId().equals(strR)) {
            n0();
        }
        return this.u;
    }

    public SwitchBean.ToEntity T(int i2) {
        return f0.get(Integer.valueOf(i2));
    }

    public final void X() {
        pz.a();
        WearUtils.x = this;
        WearUtils.B = WearUtils.X0(this);
        WearUtils.p = getString(R.string.app_platform);
        WearUtils.o = getString(R.string.app_resource);
        WearUtils.q = Q(this) == null ? "" : Q(this).versionName;
        f71.b(s0);
        yd3.a();
        WearUtils.o0(this);
        WearUtils.Q0();
        ye3.z(this);
        yd3.e();
        E0();
        WearUtils.T0();
        Z();
        d0 = db2.A();
        e0 = a12.e();
        pd3.j().k(this);
        b0();
        e0();
        cj3.f().i(s0);
        MusicControl.h0().l0();
    }

    public final void Y() {
        new Thread(new l()).start();
        new fl3().c();
    }

    public final void Z() {
        il2.b bVarB = il2.b();
        bVarB.a(new ml2(this));
        r0 = bVarB.b();
    }

    public final void a0() {
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            firebaseCrashlytics.sendUnsentReports();
            firebaseCrashlytics.setCrashlyticsCollectionEnabled(true);
            FirebaseMessaging.getInstance().subscribeToTopic("notification");
            W = FirebaseInstanceId.getInstance().getToken();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            c0 = firebaseAuth;
            n nVar = new n(this);
            p0 = nVar;
            if (firebaseAuth != null) {
                firebaseAuth.addAuthStateListener(nVar);
            }
        } catch (Exception e2) {
            String str = "FirseBase.onAuth Error:" + e2.getMessage();
            System.out.println("FirseBase.onAuth Error:" + e2.getMessage());
        }
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(lg3.h(context));
        MultiDex.install(this);
    }

    public final void b0() {
        try {
            ah4.h(this);
            lg3.a(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c0() {
        if (this.A == null) {
            r rVar = new r();
            Intent intent = new Intent();
            intent.setAction("com.dx.log.logapplication.service.MyRemoteService");
            intent.setPackage("com.dx.log.logapplication");
            bindService(intent, rVar, 1);
        }
    }

    public final RemoteViews d0(PendingIntent pendingIntent, CharSequence charSequence, CharSequence charSequence2, boolean z, String str, String str2, int i2) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_group_control);
        if (z) {
            remoteViews.setViewVisibility(R.id.tv_group_name, 0);
            remoteViews.setViewVisibility(R.id.tv_accept, 0);
            remoteViews.setViewVisibility(R.id.tv_decline, 0);
        } else {
            remoteViews.setViewVisibility(R.id.tv_group_name, 8);
            remoteViews.setViewVisibility(R.id.tv_accept, 8);
            remoteViews.setViewVisibility(R.id.tv_decline, 8);
        }
        remoteViews.setTextViewText(R.id.tv_group_name, ((Object) charSequence2) + " - " + ((Object) charSequence));
        remoteViews.setTextViewText(R.id.tv_content, str);
        if (j0) {
            remoteViews.setTextColor(R.id.tv_group_name, getResources().getColor(R.color.white));
            remoteViews.setTextColor(R.id.tv_content, getResources().getColor(R.color.white));
        } else {
            remoteViews.setTextColor(R.id.tv_group_name, getResources().getColor(R.color.black));
            remoteViews.setTextColor(R.id.tv_content, getResources().getColor(R.color.black));
        }
        remoteViews.setOnClickPendingIntent(R.id.ll_root, pendingIntent);
        Intent intent = new Intent(this, (Class<?>) NotificationChatService.class);
        intent.setAction(NotificationChatService.a);
        intent.putExtra("userId", str2);
        intent.putExtra("type", i2 == 1 ? 65 : 132);
        remoteViews.setOnClickPendingIntent(R.id.tv_accept, PendingIntent.getService(this, 2, intent, 201326592));
        Intent intent2 = new Intent(this, (Class<?>) NotificationChatService.class);
        intent2.setAction(NotificationChatService.a);
        intent2.putExtra("userId", str2);
        intent2.putExtra("type", i2 == 1 ? 66 : CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA);
        remoteViews.setOnClickPendingIntent(R.id.tv_decline, PendingIntent.getService(this, 3, intent2, 201326592));
        return remoteViews;
    }

    public void e0() {
        tn2.x(this).e(" /remote/init/v2/sensitive?version=1", new f(this));
    }

    public boolean f0() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(getPackageName())) {
                    if (next.importance != 100) {
                        String str = next.processName;
                        return true;
                    }
                    String str2 = next.processName;
                }
            }
        }
        return false;
    }

    public synchronized boolean g0() {
        boolean z;
        synchronized (this) {
            z = this.s;
        }
        return z;
        return z;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public boolean h0() {
        return getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public void i0(int i2, SwitchBean.ToEntity toEntity) {
        f0.put(Integer.valueOf(i2), toEntity);
    }

    public final void j0() {
        registerActivityLifecycleCallbacks(new m());
    }

    public void k0(String str) {
        this.v.remove(str);
    }

    public void m0() {
        q("activeToyControl", null);
        this.r = new AnalyticsBean();
    }

    public void n0() {
        String strR = WearUtils.y.r();
        if (!WearUtils.e1(strR)) {
            Setting settingFindById = DaoUtils.getSettingDao().findById(strR);
            this.u = settingFindById;
            if (settingFindById == null) {
                this.u = new Setting(strR);
                DaoUtils.getSettingDao().add((SettingDao) this.u);
                return;
            }
            return;
        }
        MyApplication myApplication = WearUtils.x;
        if (Z) {
            String str = WearUtils.a;
            Setting settingFindById2 = DaoUtils.getSettingDao().findById(str);
            this.u = settingFindById2;
            if (settingFindById2 == null) {
                this.u = new Setting(str);
                DaoUtils.getSettingDao().add((SettingDao) this.u);
            }
        }
    }

    public void o0(boolean z) {
        vg3.b().a(new a(z));
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int iDiff = configuration.diff(this.B);
        if (TextUtils.isEmpty(lg3.d(this)) || iDiff != 4) {
            super.onConfigurationChanged(configuration);
            this.B = configuration;
        }
        lg3.a(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        if (MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            return;
        }
        super.onCreate();
        s0 = this;
        ti1.c(this);
        X();
        Y();
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(s0).diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCache(new UnlimitedDiscCache(WearUtils.L())).imageDecoder(X).build());
        this.x = pc1.a;
        this.k = (AudioManager) getSystemService("audio");
        this.k.registerMediaButtonEventReceiver(new ComponentName(getPackageName(), MediaButtonReceiver.class.getName()));
        this.B = getApplicationContext().getResources().getConfiguration();
        this.l = new Handler();
        this.m = new Handler(getMainLooper());
        this.l.postDelayed(new k(), C.intValue());
        mk3.a.r();
    }

    public void p(FirebaseAnalytics firebaseAnalytics, String str, HashMap<String, String> map) {
        if (firebaseAnalytics != null) {
            Bundle bundle = new Bundle();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            if (WearUtils.e1(str)) {
                return;
            }
            firebaseAnalytics.logEvent(str, bundle);
        }
    }

    public synchronized void p0(boolean z) {
        synchronized (this) {
            if (this.s != z && z) {
                ye3.m = System.currentTimeMillis();
                ye3.d("A0007", "");
            }
            this.s = z;
        }
    }

    public void q(String str, HashMap<String, String> map) {
        if (str != null) {
            String str2 = "send eventId = " + str;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        if (firebaseAnalytics != null) {
            Bundle bundle = new Bundle();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            if (WearUtils.e1(str)) {
                return;
            }
            firebaseAnalytics.logEvent(str, bundle);
        }
    }

    public void q0(FragmentActivity fragmentActivity) {
        K = fragmentActivity;
        if (fragmentActivity == null) {
            return;
        }
        L = fragmentActivity;
        MyActionBar myActionBar = (MyActionBar) fragmentActivity.findViewById(R.id.actionbar);
        o0 = myActionBar;
        if (myActionBar != null) {
            String str = (String) myActionBar.getYesImageBtn().getTag(R.id.tag1);
            if (WearUtils.e1(str) || !str.equals("toy")) {
                return;
            }
            o0.setRssiImage(this, H());
        }
    }

    public void r0(String str) {
        this.w = str;
    }

    public final void s() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void s0(String str, Object obj) {
        this.v.put(str, obj);
    }

    public void t(String str) {
        Intent intent = new Intent(this, (Class<?>) NotificationChatService.class);
        intent.setAction(NotificationChatService.a);
        intent.putExtra("linkId", str);
        PendingIntent service = PendingIntent.getService(this, 1, intent, 201326592);
        String strE = ah4.e(R.string.control_link_active);
        if (Build.VERSION.SDK_INT >= 26) {
            y(strE, service, str);
        } else {
            x(strE, service, str);
        }
    }

    public void t0() {
        this.l.post(new d());
    }

    public void u(Group group, GroupMember groupMember, String str, int i2) {
        Intent intent = new Intent(this, (Class<?>) NotificationChatService.class);
        intent.setAction(NotificationChatService.a);
        intent.putExtra("userId", group.getId());
        intent.putExtra("type", i2 == 1 ? 64 : 131);
        PendingIntent service = PendingIntent.getService(this, 1, intent, 201326592);
        boolean zB = og3.b(4);
        if (!zB) {
            str = ah4.e(R.string.system_new_message);
        }
        String str2 = str;
        if (Build.VERSION.SDK_INT >= 26) {
            A(str2, group, service, groupMember, zB, i2);
        } else {
            z(str2, group, service, groupMember, zB, i2);
        }
    }

    public void v(String str, String str2, String str3, MessageType messageType, boolean z) {
        Intent intent;
        boolean zB = og3.b(2) & WearUtils.M;
        Intent intent2 = new Intent();
        if (messageType == MessageType.live || messageType == MessageType.sync || messageType == MessageType.video || messageType == MessageType.voice) {
            if (H() != null) {
                if (WearUtils.y.u() == null) {
                    intent2 = new Intent(this, (Class<?>) MainActivity.class);
                    OpenAppBean openAppBean = new OpenAppBean();
                    openAppBean.type = -1;
                    openAppBean.userId = str;
                    v0(openAppBean);
                    intent2.setFlags(268435456);
                } else if (WearUtils.e1(eg3.h(WearUtils.x, "gen_token_Key", ""))) {
                    intent2 = new Intent(WearUtils.x, (Class<?>) LoginActivity.class);
                    intent2.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                } else {
                    intent2 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                    intent2.putExtra("userId", str);
                    intent2.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                }
            }
            if (!z) {
                return;
            }
            intent2.setAction("com.wear.chat.NOTIFICATION_SYNC");
            intent = intent2;
            zB = false;
        } else if (WearUtils.e1(str) || WearUtils.y.u() == null) {
            intent = new Intent(WearUtils.x, (Class<?>) FlashActivity.class);
            intent.addFlags(268468224);
            D();
        } else if (WearUtils.k1(str)) {
            EventBus.getDefault().post(new FinishChatPageEvent(1));
            intent = new Intent(this, (Class<?>) ChatActivity.class);
            intent.putExtra("userId", str);
        } else {
            if (ChatGroupControl.o1().J1()) {
                int intExtra = intent2.getIntExtra("type", 0);
                xe3.a("NotificationChatService", "type:" + intExtra);
                int i2 = intExtra & (-4033);
                if (i2 == 1) {
                    intent2 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                    intent2.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                    ChatGroupControl.o1().r1(str, true);
                } else if (i2 == 2) {
                    ChatGroupControl.o1().r1(str, false);
                }
            } else if (ChatDSControl.r1().H1()) {
                int intExtra2 = intent2.getIntExtra("type", 0);
                xe3.a("NotificationChatService", "type:" + intExtra2);
                int i3 = intExtra2 & (-4033);
                if (i3 == 4) {
                    intent2 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                    intent2.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                    ChatDSControl.r1().s1(str, true);
                } else if (i3 == 5) {
                    ChatDSControl.r1().s1(str, false);
                }
            } else {
                EventBus.getDefault().post(new FinishChatPageEvent(0));
                intent = new Intent(this, (Class<?>) ChatRoomActivity.class);
                intent.putExtra("roomId", str);
            }
            intent = intent2;
        }
        IPeopleInfo iPeopleInfoS = WearUtils.y.s(str);
        String strL0 = WearUtils.L0();
        try {
            if (iPeopleInfoS.isGroup()) {
                strL0 = iPeopleInfoS.getShowNickName();
            } else {
                VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(WearUtils.i0(str2));
                if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                    vCardLoadVCard.getNickName();
                    strL0 = iPeopleInfoS.getShowNickName();
                }
            }
        } catch (Exception unused) {
        }
        if (!og3.b(4)) {
            str3 = ah4.e(R.string.system_new_message);
        }
        String str4 = zB ? "com.lovense.wear.notic.sound" : "com.lovense.wear.notic.silence";
        intent.setFlags(268435456);
        ((NotificationManager) getSystemService("notification")).notify(str.hashCode(), new NotificationCompat.Builder(this, str4).setSmallIcon(R.drawable.icon_notification).setContentTitle(strL0).setContentText(str3).setContentIntent(PendingIntent.getActivity(this, 1, intent, 201326592)).setSound(zB ? WearUtils.S() : null).setAutoCancel(true).build());
    }

    public void w(String str, String str2, String str3, String str4) {
        boolean zB = og3.b(2) & WearUtils.M;
        Intent intent = new Intent(this, (Class<?>) NotificationChatService.class);
        intent.setAction("com.wear.chat.NOTIFICATION_CHAT");
        intent.putExtra("userId", str);
        intent.putExtra("friendId", str2);
        PendingIntent service = PendingIntent.getService(this, 1, intent, 201326592);
        try {
            User userV = WearUtils.y.v(str2);
            if (WearUtils.e1(str4)) {
                str4 = userV.getShowNickName();
            }
        } catch (Exception unused) {
        }
        String str5 = str4;
        boolean zB2 = og3.b(4);
        if (!zB2) {
            str3 = ah4.e(R.string.system_new_message);
        }
        String str6 = str3;
        if (Build.VERSION.SDK_INT >= 26) {
            C(str6, str5, service, str2, zB2, zB);
        } else {
            B(str6, str5, service, str2, zB2, zB);
        }
    }

    public void w0(boolean z) {
        AudioManager audioManager = this.k;
        if (audioManager == null) {
            return;
        }
        if (!z) {
            audioManager.setSpeakerphoneOn(false);
            this.k.setMode(0);
        } else {
            if (audioManager.isWiredHeadsetOn() || this.k.isBluetoothA2dpOn() || this.k.isBluetoothScoOn()) {
                return;
            }
            this.k.setSpeakerphoneOn(true);
        }
    }

    public final void x(String str, PendingIntent pendingIntent, String str2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationCompat.Builder when = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.notification_color)).setTicker(str2).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis());
        when.setContentTitle(str);
        k0.put(Integer.valueOf(str2.hashCode()), str2.hashCode() + "");
        notificationManager.notify(str2.hashCode() + "", str2.hashCode(), when.build());
    }

    @RequiresApi(api = 26)
    public final void y(String str, PendingIntent pendingIntent, String str2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setDescription("description of this notification");
        notificationChannel.setName("RemoteNotificationSilence");
        notificationChannel.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "com.lovense.wear.notic.silence").setSmallIcon(R.drawable.startup_logo).setVisibility(1).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setPriority(2).setTicker(ah4.e(R.string.app_name)).setAutoCancel(true).setChannelId("com.lovense.wear.notic.silence").setContentText(str);
        k0.put(Integer.valueOf(str2.hashCode()), str2.hashCode() + "");
        notificationManager.notify(str2.hashCode() + "", str2.hashCode(), contentText.build());
    }

    public final void z(String str, Group group, PendingIntent pendingIntent, GroupMember groupMember, boolean z, int i2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        String showName = group.getShowNickName();
        NotificationCompat.Builder content = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.notif_launcher).setColor(getResources().getColor(R.color.notification_color)).setTicker(showName).setAutoCancel(true).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setNumber(df3.e().g(group.getId())).setContent(d0(pendingIntent, showName, groupMember.getShowNickName(), z, str, group.getId(), i2));
        k0.put(Integer.valueOf(group.getId().hashCode()), group.getId().hashCode() + "");
        String str2 = "createrNotificationAndroid0: " + group.getId() + "   " + group.getId().hashCode();
        notificationManager.notify(group.getId().hashCode() + "", group.getId().hashCode(), content.build());
    }
}
