package com.wear.main;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.lovense.wear.R;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.discord.DiscordEvent;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.MainFragmentPagerAdapter;
import com.wear.adapter.longdistance.GuideViewPagerAdapter;
import com.wear.bean.Account;
import com.wear.bean.AlarmListItems;
import com.wear.bean.CheckIsNewWolkinBean;
import com.wear.bean.ExpressionBean;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.InviteRequestInfo;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.OpenAppBean;
import com.wear.bean.ParseData;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.ScanVideoPatternQRBean;
import com.wear.bean.StrengthLogBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.VMShareDataBean;
import com.wear.bean.XYBean;
import com.wear.bean.event.AddFriendsAckClEvent;
import com.wear.bean.event.ChangeDiscoverEvent;
import com.wear.bean.event.GiftCardEvent;
import com.wear.bean.event.InDateActivityEvent;
import com.wear.bean.event.LanguageEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.PatternSyncEndEvent;
import com.wear.bean.event.VideoPatternControlEvent;
import com.wear.bean.migrate.MigCheckFieldsEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.LogFeaturesConfigBean;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.bean.response.QrCodeBean;
import com.wear.bean.socketio.scan.ScanBean;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.dao.UserSettingDao;
import com.wear.main.MainActivity;
import com.wear.main.account.AccountDeleteActivity;
import com.wear.main.account.ChangePasswordActivity;
import com.wear.main.account.LockActivity;
import com.wear.main.account.NewWarmPromptActivity;
import com.wear.main.account.PasscodeActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.DisplayPannelAcriviry;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.main.longDistance.scan.WebScanActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.toy.ToyActivity;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.PrivacyPolicyStatusBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.presenter.bean.RemoteVibemateEventConfigBean;
import com.wear.network.presenter.bean.UserInfoBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.ui.discover.DiscoverFragment;
import com.wear.ui.discover.giftCard.GiftCardActivity;
import com.wear.ui.discover.pattern.PatternFragment;
import com.wear.ui.home.HomeFragment;
import com.wear.ui.longDistance.LongFragment;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.ui.me.MeFragment;
import com.wear.ui.me.fragment.InviteUserRequestFragment;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.FloatingNewControlView;
import com.wear.widget.MainTabLayout;
import com.wear.widget.dialog.DatingAddFriendDialog;
import com.wear.widget.dialog.NewEmailVerifyDialog;
import com.wear.widget.dialog.SelectToyDailog;
import com.wear.widget.dialog.VideoPatternConnectToyDialog;
import dc.a12;
import dc.ah4;
import dc.aj4;
import dc.bf3;
import dc.bg3;
import dc.bu3;
import dc.bx3;
import dc.ch3;
import dc.cs3;
import dc.d71;
import dc.db2;
import dc.df3;
import dc.dq2;
import dc.ee3;
import dc.ef2;
import dc.eg3;
import dc.eh3;
import dc.ep1;
import dc.ep2;
import dc.f12;
import dc.f71;
import dc.ff2;
import dc.ff3;
import dc.ge3;
import dc.gg2;
import dc.hf3;
import dc.hh3;
import dc.hu3;
import dc.ig2;
import dc.is3;
import dc.jc1;
import dc.k12;
import dc.kf2;
import dc.kg3;
import dc.kn3;
import dc.ku1;
import dc.l12;
import dc.lg3;
import dc.lp1;
import dc.mk2;
import dc.mu3;
import dc.n82;
import dc.nd3;
import dc.ne3;
import dc.nu1;
import dc.nz1;
import dc.o71;
import dc.ob2;
import dc.pb2;
import dc.pc1;
import dc.pf3;
import dc.pg3;
import dc.pj3;
import dc.pq2;
import dc.q61;
import dc.qb2;
import dc.rd3;
import dc.re3;
import dc.rf3;
import dc.rp1;
import dc.sg3;
import dc.sm2;
import dc.sq2;
import dc.t51;
import dc.ti3;
import dc.tn2;
import dc.tq2;
import dc.u51;
import dc.uf2;
import dc.um2;
import dc.v51;
import dc.vc2;
import dc.ve3;
import dc.vf3;
import dc.vg3;
import dc.vu1;
import dc.vz1;
import dc.wz1;
import dc.xc1;
import dc.xe2;
import dc.xe3;
import dc.y12;
import dc.yc2;
import dc.yd3;
import dc.ye3;
import dc.yf3;
import dc.yn2;
import dc.zd3;
import dc.zn2;
import dc.zt3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class MainActivity extends QRCodeActivity implements ep2, bu3, aj4, ge3.b {
    public static boolean c0;
    public Account A;
    public View B;
    public ViewPager C;
    public hu3 D;
    public r0 F;
    public Dialog G;
    public int L;
    public boolean M;
    public boolean N;
    public boolean P;
    public Dialog R;
    public Dialog S;
    public Dialog T;
    public Handler W;
    public Runnable X;
    public View Y;
    public InviteUserRequestFragment a0;
    public um2 n;
    public Bundle o;
    public HomeFragment t;
    public LongFragment u;
    public DiscoverFragment v;

    @BindView(R.id.view_stub_guide)
    public ViewStub viewStubGuide;
    public MeFragment w;
    public MainTabLayout x;
    public MyApplication z;
    public static final String b0 = MainActivity.class.getSimpleName();
    public static boolean d0 = false;
    public static int e0 = 1033;
    public static boolean f0 = false;
    public int m = 0;
    public int p = 0;
    public boolean q = true;
    public FragmentManager s = getSupportFragmentManager();
    public boolean y = true;
    public List<BaseFragment> E = new ArrayList();
    public boolean K = false;
    public boolean O = false;
    public CompositeDisposable Q = new CompositeDisposable();
    public int U = 0;
    public int V = 0;
    public VMShareDataBean Z = new VMShareDataBean();

    public class a implements Runnable {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                XYBean xYBeanQ0 = WearUtils.Q0();
                if (WearUtils.e1(((User) this.a.get(i)).getRemoteAccountId()) && !WearUtils.e1(nd3.x(((User) this.a.get(i)).getId(), xYBeanQ0.x, xYBeanQ0.y))) {
                    arrayList.add(nd3.x(((User) this.a.get(i)).getId(), xYBeanQ0.x, xYBeanQ0.y));
                }
            }
            if (arrayList.size() > 0) {
                MainActivity.this.n.A((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    public class a0 implements Consumer<Long> {
        public final /* synthetic */ OpenAppBean a;

        public class a implements yc2 {
            public a() {
            }

            @Override // dc.yc2
            public void S3() {
                MainActivity.this.dissDialog();
            }

            @Override // dc.yc2
            public void a2() {
            }

            @Override // dc.yc2
            public void e0() {
                MainActivity.this.showDialog();
            }

            @Override // dc.yc2
            public void f1() {
            }

            @Override // dc.yc2
            public boolean x2(String str) {
                if (MainActivity.this.z.G().N() != null) {
                    return true;
                }
                if (MainActivity.this.G != null && MainActivity.this.G.isShowing()) {
                    MainActivity.this.G.dismiss();
                }
                is3.b bVar = new is3.b(MainActivity.this);
                bVar.p(str);
                bVar.k(R.layout.dialog_default_ok_new);
                MainActivity.this.G = cs3.h(bVar);
                MainActivity.this.G.show();
                return false;
            }
        }

        public a0(OpenAppBean openAppBean) {
            this.a = openAppBean;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            ig2.n().q(this.a.data, new a());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ QueryRemoteAccountInfoBean a;

        public b(MainActivity mainActivity, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean) {
            this.a = queryRemoteAccountInfoBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getData() == null || this.a.getData().getList() == null || this.a.getData().getList().size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.a.getData().getList().size(); i++) {
                XYBean xYBeanQ0 = WearUtils.Q0();
                arrayList.add(nd3.k(this.a.getData().getList().get(i).getEmail(), xYBeanQ0.x, xYBeanQ0.y));
                arrayList2.add(this.a.getData().getList().get(i).getRemoteAccountId());
            }
            List<User> listFindAll = DaoUtils.getUserDao().findAll();
            for (int i2 = 0; i2 < listFindAll.size(); i2++) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (WearUtils.e1(listFindAll.get(i2).getRemoteAccountId())) {
                        if (Objects.equals(listFindAll.get(i2).getId(), arrayList.get(i3))) {
                            listFindAll.get(i2).setRemoteAccountId((String) arrayList2.get(i3));
                            DaoUtils.getUserDao().updateOrAdd(listFindAll.get(i2));
                        }
                    } else if (listFindAll.get(i2).getRemoteAccountId().equals(arrayList2.get(i3))) {
                        String str = "RealId====111" + listFindAll.get(i2).getId() + "   getRemoteAccountId= " + listFindAll.get(i2).getRemoteAccountId();
                        String str2 = "friendEmail====111" + ((String) arrayList.get(i3)) + "   friendAccountIdList= " + ((String) arrayList2.get(i3));
                        if (!Objects.equals(listFindAll.get(i2).getId(), arrayList.get(i3))) {
                            DaoUtils.updateFriendEmail(listFindAll.get(i2).getId(), (String) arrayList.get(i3));
                            DaoUtils.getUserDao().delT(listFindAll.get(i2));
                            listFindAll.get(i2).setId((String) arrayList.get(i3));
                            listFindAll.get(i2).setRemoteAccountId((String) arrayList2.get(i3));
                            DaoUtils.getUserDao().add(listFindAll.get(i2));
                        }
                    }
                }
            }
        }
    }

    public class b0 implements ServiceConnection {
        public b0(MainActivity mainActivity) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.r6(mainActivity.getIntent());
            MainActivity.this.V7();
        }
    }

    public class c0 implements VideoPatternConnectToyDialog.d {
        public c0() {
        }

        @Override // com.wear.widget.dialog.VideoPatternConnectToyDialog.d
        public void a() {
            mk2.P().J();
        }

        @Override // com.wear.widget.dialog.VideoPatternConnectToyDialog.d
        public void b() {
            pj3.f(MainActivity.this, ToyActivity.class);
        }
    }

    public class d implements zn2<String> {
        public d(MainActivity mainActivity) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class d0 implements mk2.r {

        public class a implements is3.c {
            public final /* synthetic */ ScanVideoPatternQRBean a;

            public a(d0 d0Var, ScanVideoPatternQRBean scanVideoPatternQRBean) {
                this.a = scanVideoPatternQRBean;
            }

            @Override // dc.is3.c
            public void doCancel() {
                mk2.P().J();
                mk2.P().E(this.a.getPatternId(), this.a.getPf(), 3);
            }
        }

        public class b implements is3.d {
            public final /* synthetic */ ScanVideoPatternQRBean a;

            public b(ScanVideoPatternQRBean scanVideoPatternQRBean) {
                this.a = scanVideoPatternQRBean;
            }

            @Override // dc.is3.d
            public void doConfirm() {
                MusicControl.h0().S();
                y12.c.a().t();
                ff2.d = false;
                ff2.f = false;
                ff2.e = false;
                ff2.n().C();
                ScanQRDataBean scanQRDataBean = MyApplication.G;
                if (scanQRDataBean != null) {
                    scanQRDataBean.onCancelReportToService();
                }
                MyApplication.G = null;
                EventBus.getDefault().post(new LanApiControlEvent(false));
                if (OrgySetting.getInstance().isJoinIn()) {
                    OrgySetting.getInstance().joinOrgyAction();
                }
                EventBus.getDefault().post(new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_OVER));
                MainActivity.this.showDialog();
                mk2.P().Y(this.a);
            }
        }

        public d0() {
        }

        @Override // dc.mk2.r
        public void a(String str, String str2) {
            MainActivity.this.dissDialog();
            sg3.h(R.string.common_internet_error);
            mk2.P().E("", "", 4);
        }

        @Override // dc.mk2.r
        public void b(ScanVideoPatternQRBean scanVideoPatternQRBean) {
            MainActivity.this.dissDialog();
            is3.b bVar = new is3.b(MainActivity.this);
            bVar.m(false);
            bVar.l(false);
            bVar.p(String.format(ah4.e(R.string.vp_sync), scanVideoPatternQRBean.getPf()));
            bVar.o(ah4.e(R.string.common_yes));
            bVar.d(new b(scanVideoPatternQRBean));
            bVar.c(new a(this, scanVideoPatternQRBean));
            cs3.h(bVar).show();
        }
    }

    public class e extends TypeReference<HashMap<String, String>> {
        public e(MainActivity mainActivity) {
        }
    }

    public class e0 implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(MainActivity.this);
            }
        }

        public e0() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(MainActivity.this.activity);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                MainActivity.this.d8();
            }
        }
    }

    public class f implements ef2 {
        public f(MainActivity mainActivity) {
        }

        @Override // dc.ef2
        public ef2.a a(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.b = false;
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
            xe3.a("newCommand", "createFail ip=" + exc.getMessage());
        }

        @Override // dc.ef2
        public void c(String str, int i) {
            xe3.a("newCommand", "createSuccess ip=" + str + "   port=" + i);
        }
    }

    public class f0 implements f12.d {
        public f0(MainActivity mainActivity) {
        }

        @Override // dc.f12.d
        public void a() {
        }
    }

    public class g implements zn2<String> {
        public g(MainActivity mainActivity) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            T t;
            LogFeaturesConfigBean logFeaturesConfigBean = (LogFeaturesConfigBean) JSON.parseObject(str, LogFeaturesConfigBean.class);
            if (logFeaturesConfigBean.code != 0 || (t = logFeaturesConfigBean.data) == 0) {
                return;
            }
            ye3.Z((HashMap) t);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class g0 implements l12.k {
        public g0(MainActivity mainActivity) {
        }

        @Override // dc.l12.k
        public void i(boolean z) {
            MainActivity.d0 = true;
            EventBus.getDefault().post(new HomeMusicBean(5));
        }

        @Override // dc.l12.k
        public void l(boolean z) {
            MainActivity.d0 = false;
        }
    }

    public class h implements yn2<ExpressionBean> {

        public class a extends ff3 {
            public final /* synthetic */ ExpressionBean a;

            public a(ExpressionBean expressionBean) {
                this.a = expressionBean;
            }

            @Override // dc.ff3
            public void b(boolean z, Object obj) {
                try {
                    eg3.k(MainActivity.this, "Expression_Version", this.a.getData().getV());
                    hh3.b((File) obj, WearUtils.T("emojis_anim"), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public h() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ExpressionBean expressionBean) {
            if (expressionBean != null) {
                if (expressionBean.isResult()) {
                    if (expressionBean.getData() != null) {
                        WearUtils.D0(false, expressionBean.getData().getUrl(), new a(expressionBean));
                    }
                } else {
                    String unused = MainActivity.b0;
                    String str = "initExpression:" + expressionBean.getMessage();
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String unused = MainActivity.b0;
            String str = "initExpression:" + netException.getMessage();
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class h0 implements is3.d {
        public final /* synthetic */ DiscordEvent a;

        public h0(MainActivity mainActivity, DiscordEvent discordEvent) {
            this.a = discordEvent;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            DiscordControl.getInstance().join(true, true, this.a.getOrderKey());
        }
    }

    public class i extends TimerTask {
        public i() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            MainActivity.this.x8();
        }
    }

    public class i0 implements l12.k {
        public i0(MainActivity mainActivity) {
        }

        @Override // dc.l12.k
        public void i(boolean z) {
        }

        @Override // dc.l12.k
        public void l(boolean z) {
        }
    }

    public class j implements zn2<String> {

        public class a extends TypeReference<CheckIsNewWolkinBean> {
            public a(j jVar) {
            }
        }

        public j() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            CheckIsNewWolkinBean checkIsNewWolkinBean = (CheckIsNewWolkinBean) JSON.parseObject(str, new a(this), new Feature[0]);
            if (checkIsNewWolkinBean == null || checkIsNewWolkinBean.getCode().intValue() != 0) {
                LoginUserBean loginUserBeanO = ch3.n().o();
                if (loginUserBeanO != null) {
                    MainActivity.this.n.h(loginUserBeanO.getPwdType(), loginUserBeanO.isVerify(), loginUserBeanO.getEmail());
                    MainActivity.this.k6();
                    return;
                }
                return;
            }
            if (checkIsNewWolkinBean.getData() != null && checkIsNewWolkinBean.getData().size() > 0) {
                Intent intent = new Intent(MainActivity.this, (Class<?>) NewWarmPromptActivity.class);
                intent.putExtra("listBeans", (Serializable) checkIsNewWolkinBean.getData());
                MainActivity.this.startActivityForResult(intent, 159147123);
            } else {
                LoginUserBean loginUserBeanO2 = ch3.n().o();
                if (loginUserBeanO2 != null) {
                    MainActivity.this.n.h(loginUserBeanO2.getPwdType(), loginUserBeanO2.isVerify(), loginUserBeanO2.getEmail());
                    MainActivity.this.k6();
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            LoginUserBean loginUserBeanO = ch3.n().o();
            if (loginUserBeanO != null) {
                MainActivity.this.n.h(loginUserBeanO.getPwdType(), loginUserBeanO.isVerify(), loginUserBeanO.getEmail());
            }
        }
    }

    public class j0 implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public class a implements kn3.d {

            /* renamed from: com.wear.main.MainActivity$j0$a$a, reason: collision with other inner class name */
            public class C0083a extends HashMap<String, String> {
                public C0083a() {
                    String str;
                    if (WearUtils.y.y() == null) {
                        str = "0";
                    } else {
                        str = "" + WearUtils.y.y().size();
                    }
                    put("count", str);
                }
            }

            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void b(boolean z, String str, String str2) {
                if (z) {
                    MainActivity.this.e8(str, str2);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void d(final String str, final String str2, final boolean z) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: dc.zv1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(z, str, str2);
                    }
                });
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                WearUtils.x.q("longDistance_unblock_friend", new C0083a());
                n82 n82Var = WearUtils.x.i;
                j0 j0Var = j0.this;
                String str = j0Var.b;
                final String str2 = j0Var.c;
                final String str3 = j0Var.a;
                n82Var.y(str, new n82.d() { // from class: dc.yv1
                    @Override // dc.n82.d
                    public final void a(boolean z) {
                        this.a.d(str2, str3, z);
                    }
                });
            }
        }

        public j0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            kn3 kn3Var = new kn3((Context) MainActivity.this, String.format(ah4.e(R.string.add_blocke_friends_fail), this.a), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new a());
            kn3Var.show();
            kn3Var.p();
        }
    }

    public class k implements is3.d {
        public k() {
        }

        public static /* synthetic */ void a(List list, boolean z) {
            if (!z) {
            }
        }

        @Override // dc.is3.d
        public void doConfirm() {
            vz1.b(wz1.b.POWER);
            q61 q61VarM = q61.m(MainActivity.this);
            q61VarM.h("android.permission.ACCESS_FINE_LOCATION");
            q61VarM.h("android.permission.ACCESS_COARSE_LOCATION");
            q61VarM.j(new u51() { // from class: dc.vv1
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) {
                    MainActivity.k.a(list, z);
                }
            });
        }
    }

    public class k0 implements GuideViewPagerAdapter.a {
        public final /* synthetic */ ViewPager2 a;

        public k0(ViewPager2 viewPager2) {
            this.a = viewPager2;
        }

        @Override // com.wear.adapter.longdistance.GuideViewPagerAdapter.a
        public void a(int i) {
            this.a.setCurrentItem(i);
        }

        @Override // com.wear.adapter.longdistance.GuideViewPagerAdapter.a
        public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.viewStubGuide.setVisibility(8);
            eg3.j(MainActivity.this.z, "key_show_guide_by_long_distance", true);
        }
    }

    public class l implements is3.c {
        public l(MainActivity mainActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            vz1.b(wz1.b.POWER);
        }
    }

    public class l0 implements is3.d {
        public l0() {
        }

        public static /* synthetic */ void a(List list, boolean z) {
            if (z) {
                return;
            }
            sg3.l(ah4.e(R.string.system_bluetooth_off));
        }

        @Override // dc.is3.d
        public void doConfirm() {
            q61 q61VarM = q61.m(MainActivity.this);
            q61VarM.h(v51.a.a);
            q61VarM.j(new u51() { // from class: dc.wv1
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) {
                    MainActivity.l0.a(list, z);
                }
            });
        }
    }

    public class m implements is3.d {
        public m(MainActivity mainActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class m0 implements is3.c {
        public m0(MainActivity mainActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            MyApplication.v0(null);
        }
    }

    public class n implements DialogInterface.OnDismissListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.R = null;
        }
    }

    public class n0 implements is3.d {
        public n0() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            MainActivity.this.u8();
        }
    }

    public class o implements NewEmailVerifyDialog.c {
        public final /* synthetic */ String a;

        public o(String str) {
            this.a = str;
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void a() {
            if (MainActivity.this.n.s()) {
                MainActivity.this.r8(this.a);
            }
            MainActivity.this.R.dismiss();
            vf3.a("A0024", 1, 2);
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void b(int i) {
            vf3.a("A0024", 1, 3);
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void c() {
            vf3.a("A0024", 1, 4);
        }
    }

    public class o0 implements pq2 {
        public o0() {
        }

        @Override // dc.pq2
        public void a(String str) {
            MainActivity mainActivity = MainActivity.this;
            sg3.k(mainActivity, mainActivity.getString(R.string.toast_login_failed));
        }

        @Override // dc.pq2
        public void b(sq2 sq2Var) {
        }

        @Override // dc.pq2
        public void onCancel() {
            MainActivity mainActivity = MainActivity.this;
            sg3.k(mainActivity, mainActivity.getString(R.string.toast_login_failed));
        }
    }

    public class p implements ViewPager.OnPageChangeListener {
        public p() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (MainActivity.this.E != null && MainActivity.this.E.size() > i && (MainActivity.this.E.get(i) instanceof LongFragment)) {
                MyApplication.N().L(2, null);
            }
            if (MainActivity.this.m == 2 && i != 2) {
                HashMap map = new HashMap();
                map.put("page_name", "discover");
                map.put("page_type", "");
                map.put("control_type", "");
                ye3.e("S0008", map);
            }
            MainActivity.this.m = i;
            if (i == 2) {
                EventBus.getDefault().post(new ChangeDiscoverEvent());
                HashMap map2 = new HashMap();
                map2.put("page_name", "discover");
                map2.put("referrer", "");
                map2.put("page_type", "");
                map2.put("control_type", "");
                ye3.e("S0007", map2);
            }
            if (MainActivity.this.E != null) {
                for (int i2 = 0; i2 < MainActivity.this.E.size(); i2++) {
                    if (i2 != i) {
                        ((BaseFragment) MainActivity.this.E.get(i2)).I();
                    }
                }
                ((BaseFragment) MainActivity.this.E.get(i)).J();
            }
            MainActivity mainActivity = MainActivity.this;
            if (mainActivity.m == 2 && !mainActivity.M && MainActivity.this.N && MainActivity.this.O && MainActivity.this.U == 0) {
                eg3.i(MainActivity.this, "according_red_dot", Boolean.TRUE);
                MainActivity.this.x.b(MainActivity.this.m, false);
            }
            MainActivity mainActivity2 = MainActivity.this;
            if (mainActivity2.m == 1) {
                mainActivity2.G6();
            }
        }
    }

    public class p0 implements Runnable {
        public p0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.L = mainActivity.getIntent().getIntExtra("isChange", 0);
            MainActivity.this.z.S();
            nz1.e().i(MainActivity.this.A.getId());
            rf3.l(true);
        }
    }

    public class q implements OnCompleteListener<AuthResult> {
        public q(MainActivity mainActivity) {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<AuthResult> task) {
            String unused = MainActivity.b0;
            String str = "signInAnonymously:onComplete:" + task.isSuccessful();
            if (task.isSuccessful()) {
                return;
            }
            String unused2 = MainActivity.b0;
            task.getException();
        }
    }

    public class q0 implements yn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public q0(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (str.equals(ye3.x())) {
                MainActivity.this.D.s(this.a, this.b, null, null);
                return;
            }
            MyApplication.Q = 0;
            sg3.i(MainActivity.this.z, R.string.system_account_single);
            ep1.b().g();
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            MainActivity.this.D.s(this.a, this.b, null, null);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.B.getWidth() == 0 || MainActivity.this.B.getHeight() == 0) {
                return;
            }
            FloatingNewControlView.r = MainActivity.this.B.getWidth();
            FloatingNewControlView.q = MainActivity.this.B.getTop();
            FloatingNewControlView.s = MainActivity.this.B.getHeight() + MainActivity.this.B.getTop();
        }
    }

    public class r0 extends BroadcastReceiver {
        public r0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "com.wear.messageTip":
                    MainActivity.this.i8();
                    ((BaseFragment) MainActivity.this.E.get(1)).K(intent);
                    break;
                case "ACTION_TOY_UPDATE":
                    ((BaseFragment) MainActivity.this.E.get(0)).K(intent);
                    break;
                case "com.wear.messageTipB":
                    MainActivity.this.i8();
                    break;
            }
        }
    }

    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("密码====");
            sb.append(!WearUtils.e1(zd3.b(MainActivity.this, "xmpp_password")));
            sb.toString();
            String str = "好友数====" + ch3.i.size();
            String str2 = "保存数===" + eg3.f(WearUtils.x, "user_size", -1);
            if ((WearUtils.e1(zd3.b(MainActivity.this, "xmpp_password")) || WearUtils.y.h().size() <= 0) && eg3.f(WearUtils.x, "user_size", -1) != 0) {
                MainActivity.this.W.postDelayed(this, 1000L);
            } else {
                MainActivity.this.i6();
            }
        }
    }

    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            MainActivity.this.Z = MyApplication.V;
            bundle.putSerializable("vshare_data", MainActivity.this.Z);
            pj3.g(MainActivity.this, ForwardMessageActivity.class, bundle);
            MyApplication.x0(null);
            MyApplication.V = null;
        }
    }

    public class u implements Runnable {
        public u(MainActivity mainActivity) {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyApplication.D();
        }
    }

    public class v implements kn3.d {
        public v() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(MainActivity.this);
        }
    }

    public class w implements is3.c {
        public w(MainActivity mainActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            MyApplication.v0(null);
        }
    }

    public class x implements is3.d {
        public x() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            MainActivity.this.u8();
        }
    }

    public class y implements qb2 {
        public y() {
        }

        @Override // dc.qb2
        public void Q0() {
        }

        @Override // dc.qb2
        public void q1(boolean z) {
            pj3.f(MainActivity.this, DisplayPannelAcriviry.class);
        }

        @Override // dc.qb2
        public void x0() {
        }
    }

    public class z implements zn2<BaseResponseBeanNew<QrCodeBean>> {
        public z() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<QrCodeBean> baseResponseBeanNew) {
            QrCodeBean qrCodeBean;
            MainActivity.this.dissDialog();
            if (baseResponseBeanNew == null || baseResponseBeanNew.code != 0 || (qrCodeBean = baseResponseBeanNew.data) == null) {
                return;
            }
            String qrDate = qrCodeBean.getQrDate();
            if (TextUtils.isEmpty(qrDate)) {
                return;
            }
            String strH = nd3.h(qrDate);
            xe3.a(MainActivity.b0, "解密：result:" + strH);
            ScanBean scanBean = null;
            try {
                scanBean = (ScanBean) JSON.parseObject(strH, ScanBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (scanBean == null || TextUtils.isEmpty(scanBean.getD())) {
                return;
            }
            MainActivity.this.s6(scanBean.getT() == 10 ? 1 : 2, scanBean.getD());
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe3.a(MainActivity.b0, netException.getMessage());
            MainActivity.this.dissDialog();
            sg3.h(R.string.common_internet_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B7(OpenAppBean openAppBean) {
        ob2.o().J();
        pj3.j(this, LoginActivity.class, "email", openAppBean.selfId);
        ep1.b().a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E7(String str) {
        MyApplication.v0(null);
        U7(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G7(final String str, InviteRequestInfo inviteRequestInfo) {
        InviteUserRequestFragment inviteUserRequestFragment = new InviteUserRequestFragment();
        this.a0 = inviteUserRequestFragment;
        inviteUserRequestFragment.E(new InviteUserRequestFragment.b() { // from class: dc.dw1
            @Override // com.wear.ui.me.fragment.InviteUserRequestFragment.b
            public final void a() {
                this.a.E7(str);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelable("inviteRequestInfo", inviteRequestInfo);
        this.a0.setArguments(bundle);
        this.a0.F(getSupportFragmentManager());
        ku1.i("Invite Link", "add_people_invite_link_popup_exposure", "exposure", "add_people_invite_link_popup", "button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I7(Toy toy) {
        if (toy.isConnected()) {
            lp1.a.e(this, toy.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K7() {
        vf3.a("A0026", 1, 2);
        pj3.f(this, ChangePasswordActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N6(OpenAppBean openAppBean) {
        User user = new User(openAppBean.userId);
        user.addFriendType(16);
        user.addFriendType(32);
        user.setOnline(true);
        user.setTempName(openAppBean.receiverName);
        try {
            if (MyApplication.P) {
                VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(WearUtils.i0(openAppBean.userId));
                if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                    user.setName(vCardLoadVCard.getNickName());
                }
                if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                    WearUtils.s2(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"), user);
                }
                if (!TextUtils.isEmpty(openAppBean.receiverName)) {
                    user.setTempName(openAppBean.receiverName);
                }
                user.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
                user.setAge(vCardLoadVCard.getField("AGE"));
                user.setFriendGTMTime(vCardLoadVCard.getField("GMTTIME"));
                user.setDeviceType(vCardLoadVCard.getField("DEVICETYPE"));
                user.setDeviceAppVersion(vCardLoadVCard.getField("APPVERSION"));
                user.setSupportType(vCardLoadVCard.getField("ORDERCHANNEL"));
                user.setRemotePlatform(vCardLoadVCard.getField("DEVICETYPE"));
                user.setRemoteVersion(vCardLoadVCard.getField("APPVERSION"));
            }
        } catch (Exception unused) {
        }
        WearUtils.y.b(user);
        dismissLoadingProgress();
        pj3.j(this, ChatActivity.class, "userId", user.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N7() {
        vf3.a("A0026", 2, 2);
        pj3.f(this, ChangePasswordActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R6() {
        try {
            if (isFinishing() || isDestroyed()) {
                vz1.b(wz1.b.POWER);
            }
        } catch (Exception e2) {
            vz1.b(wz1.b.POWER);
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public static /* synthetic */ void S6(OpenAppBean openAppBean, ObservableEmitter observableEmitter, String str) {
        String strI0 = WearUtils.i0(openAppBean.userId);
        if (openAppBean.userId == null || !strI0.equals(str)) {
            return;
        }
        observableEmitter.onNext(str);
        observableEmitter.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U6(final OpenAppBean openAppBean, final ObservableEmitter observableEmitter) throws Exception {
        hu3.z(this).j0(new hu3.r() { // from class: dc.xv1
            @Override // dc.hu3.r
            public final void a(String str) {
                MainActivity.S6(openAppBean, observableEmitter, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W6() throws Exception {
        hu3.z(this).j0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y6(OpenAppBean openAppBean, String str) throws Exception {
        p6(openAppBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a7(OpenAppBean openAppBean, Throwable th) throws Exception {
        p6(openAppBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c7(String str, Toy toy) {
        if (hf3.d(this)) {
            s8(toy, str);
        } else {
            sg3.i(this, R.string.qrcode_no_network);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e7() throws ParseException {
        String strR = WearUtils.y.r();
        if (WearUtils.e1(strR)) {
            strR = "";
        }
        if (!zt3.f()) {
            List<UserSetting> listFindUserSettingsByUserId = DaoUtils.getUserSettingDao().findUserSettingsByUserId(strR);
            if (listFindUserSettingsByUserId == null || listFindUserSettingsByUserId.isEmpty()) {
                return;
            }
            for (UserSetting userSetting : listFindUserSettingsByUserId) {
                if (userSetting.getAutoPlayAlarm().booleanValue()) {
                    userSetting.setAutoPlayAlarm(Boolean.FALSE);
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSetting);
                }
            }
            return;
        }
        List<AlarmListItems> listFindAlarmList = DaoUtils.getAlarmListDao().findAlarmList(strR);
        for (int i2 = 0; i2 < listFindAlarmList.size(); i2++) {
            AlarmListItems alarmListItems = listFindAlarmList.get(i2);
            if (alarmListItems.getIsSelected() > 0) {
                alarmListItems.setHaveSnoozeCount(0);
                if (!alarmListItems.getFrequency().equals("customer")) {
                    DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
                    zt3.t(this.z, alarmListItems.getId(), false, true, true);
                } else if (alarmListItems.getFrequency().equals("customer")) {
                    if (zt3.g(alarmListItems)) {
                        alarmListItems.setIsSelected(0);
                        AlarmMessagingService.d(alarmListItems.getId(), true);
                    } else {
                        zt3.t(this.z, alarmListItems.getId(), false, true, true);
                    }
                    DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
                }
            } else {
                AlarmMessagingService.d(alarmListItems.getId(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g7() {
        try {
            if (!isFinishing() && !isDestroyed()) {
                if (WearUtils.l1(this)) {
                    j6();
                    return;
                } else {
                    eg3.j(this, "is_first_show_battery", true);
                    cs3.d(this, ah4.e(R.string.app_close_battery_optimization), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.kw1
                        @Override // dc.is3.d
                        public final void doConfirm() {
                            this.a.l6();
                        }
                    }, new is3.c() { // from class: dc.ax1
                        @Override // dc.is3.c
                        public final void doCancel() {
                            this.a.j6();
                        }
                    }).show();
                    return;
                }
            }
            vz1.b(wz1.b.POWER);
        } catch (Exception e2) {
            vz1.b(wz1.b.POWER);
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k7(TabLayout.Tab tab) {
        if (tab == null || tab.getPosition() != 1) {
            return;
        }
        ((LongFragment) this.E.get(1)).n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m7(String str, String str2, View view) {
        e6(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o7() {
        getWindow().setFlags(128, 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r7() {
        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + WearUtils.x.getPackageName())), 10086);
    }

    public static /* synthetic */ void s7(boolean z2) {
        if (z2) {
            MyApplication.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u7(List list, List list2, XYBean xYBean, List list3) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (TextUtils.equals(((User) list2.get(i3)).getId(), (CharSequence) list.get(i2)) && WearUtils.e1(((User) list2.get(i3)).getRemoteAccountId()) && !WearUtils.e1(nd3.x((String) list.get(i2), xYBean.x, xYBean.y))) {
                    list3.add(nd3.x((String) list.get(i2), xYBean.x, xYBean.y));
                }
            }
        }
        String str = "emails======" + list3.size();
        String[] strArr = (String[]) list3.toArray(new String[0]);
        if (strArr.length > 0) {
            this.n.A(strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w7(User user, String str) {
        UserSetting userSettingZ;
        user.setIagree(1);
        ob2.o().g(this, user, true, str);
        if (user.getFagree() == -1) {
            ch3.n().g(user.getId());
            if (user.isOnlyFriendType(4) && (userSettingZ = WearUtils.y.z(user.getId())) != null && !userSettingZ.isFriendsRequestClick()) {
                df3.e().a(user.getId());
            }
            user.setTempName(null);
            user.resetAddFriendInfo();
            return;
        }
        if (user.getFagree() == 1) {
            if (user.isOnlyFriendType(16) || user.isDeleteByFriend()) {
                if (user.haveFriendType(4)) {
                    hu3.a(user.getId());
                    synchronized (ch3.h) {
                        ch3.j.remove(user);
                    }
                    UserSetting userSettingZ2 = WearUtils.y.z(user.getId());
                    if (userSettingZ2 != null && !userSettingZ2.isFriendsRequestClick()) {
                        userSettingZ2.setFriendsRequestClick(true);
                        DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ2);
                        df3.e().c(user.getId());
                        mu3.c--;
                    }
                } else {
                    hu3.k(user.getId());
                }
            } else if (user.isOnlyFriendType(4)) {
                hu3.a(user.getId());
                synchronized (ch3.h) {
                    ch3.j.remove(user);
                }
                UserSetting userSettingZ3 = WearUtils.y.z(user.getId());
                if (userSettingZ3 != null && !userSettingZ3.isFriendsRequestClick()) {
                    userSettingZ3.setFriendsRequestClick(true);
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ3);
                    df3.e().c(user.getId());
                    mu3.c--;
                }
            }
            user.resetFriendType(1);
            ch3.n().a(user.getId());
            user.resetAddFriendInfo();
            user.setTempName(null);
            this.z.q("date_addFriend_yes", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y7(User user, String str) {
        user.setIagree(-1);
        ob2.o().g(this, user, false, str);
        ch3.n().g(user.getId());
        user.setTempName(null);
        this.z.q("date_addFriend_no", null);
    }

    public final void A6() {
        tn2.x(this).e("/remote/init/expression?v=" + eg3.f(this, "Expression_Version", 0), new h());
    }

    public final void B6() {
        try {
            FirebaseAuth firebaseAuth = MyApplication.c0;
            if (firebaseAuth == null || firebaseAuth.signInAnonymously() == null) {
                return;
            }
            MyApplication.c0.signInAnonymously().addOnCompleteListener(this, new q(this));
            this.z.bindService(new Intent(this.z, (Class<?>) AlarmMessagingService.class), new b0(this), 1);
        } catch (Exception unused) {
            System.out.println("e");
        }
    }

    public final List<BaseFragment> C6() {
        Bundle bundle = this.o;
        if (bundle != null) {
            this.t = (HomeFragment) this.s.getFragment(bundle, HomeFragment.class.getSimpleName());
            this.u = (LongFragment) this.s.getFragment(this.o, LongFragment.class.getSimpleName());
            this.v = (DiscoverFragment) this.s.getFragment(this.o, PatternFragment.class.getSimpleName());
            this.w = (MeFragment) this.s.getFragment(this.o, MeFragment.class.getSimpleName());
        }
        h8();
        g8();
        this.E.add(this.t);
        this.E.add(this.u);
        this.E.add(this.v);
        this.E.add(this.w);
        return this.E;
    }

    public final void D6() {
        if (WearUtils.e1(DaoUtils.getTestValueDao().getValue(zt3.k, TestValueDao.LAN_API_DATA_TYPE))) {
            return;
        }
        ScanQRDataBean scanQRDataBean = (ScanQRDataBean) WearUtils.A.fromJson(nd3.h(DaoUtils.getTestValueDao().getValue(zt3.k, TestValueDao.LAN_API_DATA_TYPE)), ScanQRDataBean.class);
        if (scanQRDataBean != null) {
            MyApplication.G = scanQRDataBean;
            int iIntValue = 0;
            kf2.m().b(new f(this), "/", false);
            ff2.d = true;
            ff2.f = true;
            db2.A().b.j(false);
            ScanQRDataBean scanQRDataBean2 = MyApplication.G;
            if (scanQRDataBean2 != null) {
                scanQRDataBean2.onCancelReportToService();
            }
            String heart = scanQRDataBean.getHeart();
            if (!WearUtils.e1(heart) && WearUtils.q1(heart)) {
                iIntValue = Integer.valueOf(heart).intValue();
            }
            if (iIntValue > 0) {
                scanQRDataBean.createAutoReportToService(iIntValue);
            } else if (iIntValue == 0) {
                scanQRDataBean.reportToService();
            }
        }
    }

    public final void E6() throws Throwable {
        try {
            W5(lg3.b(this));
            if (ah4.d) {
                new sm2().e(LifecycleOwnerKt.getLifecycleScope(this));
                ah4.d = false;
            }
            if (WearUtils.e1(lg3.d(this))) {
                String language = Locale.getDefault().getLanguage();
                String str = "local_language=" + language;
                lg3.g(this, language);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void F6() {
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("model", Build.MODEL);
        map.put("version", WearUtils.q);
        map.put("systemVersion", Build.VERSION.RELEASE);
        map.put("remark", "");
        map.put("apv", SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
        tn2.x(this.z).l("/wear/log/featuresConfig", map, new g(this));
    }

    public final void G6() {
        ViewStub viewStub;
        if (pf3.d(this) || !MyApplication.O || eg3.d(this.z, "key_show_guide_by_long_distance", false) || (viewStub = this.viewStubGuide) == null) {
            return;
        }
        if (this.Y == null) {
            this.Y = viewStub.inflate();
        }
        String[] strArr = {"es", "en", "fr", "fa", "ru"};
        ViewPager2 viewPager2 = (ViewPager2) this.Y.findViewById(R.id.viewpage_long_distance_guide);
        viewPager2.setUserInputEnabled(false);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < 4; i2++) {
            arrayList.add(g6(i2, strArr));
        }
        viewPager2.setAdapter(new GuideViewPagerAdapter(arrayList, new k0(viewPager2)));
    }

    public void H6() {
        T7(false);
        MusicControl.h0().D(new f0(this));
    }

    @Override // dc.bu3
    public void I1(String str) {
    }

    public final void I6() {
        if (MyApplication.O) {
            OfficialaCountModel.g.a().v();
        }
    }

    public final void J6() {
        vu1.e();
    }

    public final void K6() throws Resources.NotFoundException {
        this.B = findViewById(R.id.screan_root_layout);
        this.E = C6();
        MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this.E);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.C = viewPager;
        viewPager.setAdapter(mainFragmentPagerAdapter);
        this.C.setOffscreenPageLimit(3);
        this.C.addOnPageChangeListener(new p());
        this.B.post(new r());
        X7();
        if (this.P) {
            this.C.setCurrentItem(1);
        }
        MainTabLayout mainTabLayout = (MainTabLayout) findViewById(R.id.tab_layout);
        this.x = mainTabLayout;
        mainTabLayout.setupWithViewPager(this.C);
        this.x.setOnTabReselectedListener(new MainTabLayout.b() { // from class: dc.sv1
            @Override // com.wear.widget.MainTabLayout.b
            public final void onTabReselected(TabLayout.Tab tab) {
                this.a.k7(tab);
            }
        });
    }

    @Override // dc.ep2
    public void L0(boolean z2, BaseResponseBean baseResponseBean) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ManagerRDBean(ManagerRDBean managerRDBean) {
        m8();
    }

    @Override // dc.ep2
    public void N(AccountConfigBean accountConfigBean) {
        ch3.n().o().setEnableAgoraIO(accountConfigBean.getData().isEnableAgoraIO());
        eg3.i(this.z, "is_enable_cold_restart", Boolean.valueOf(accountConfigBean.getData().isEnableColdRestart()));
    }

    @Override // dc.ep2
    public void O0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(WearUtils.x, "need_upload_cold_restart", false);
        this.n.l();
    }

    @Override // dc.aj4
    public void P1() {
        HomeFragment homeFragment = this.t;
        if (homeFragment != null) {
            homeFragment.g0();
        }
    }

    @Override // dc.ep2
    public void Q3(boolean z2, LoginUserBean loginUserBean, String str, String str2) throws IOException {
        Y5(loginUserBean, str, str2);
    }

    public final void Q7(BaseResponseBean baseResponseBean) {
        if (!baseResponseBean.isResult() || baseResponseBean.getData() == null) {
            return;
        }
        String string = baseResponseBean.getData().toString();
        String str = null;
        Map map = (Map) WearUtils.A.fromJson(nd3.j(string), HashMap.class);
        if (map != null) {
            string = (String) map.get("email");
            str = (String) map.get("username");
        }
        String strI0 = WearUtils.i0(string);
        if (WearUtils.x.i.k(strI0)) {
            ku1.f("Invite Link", "add_people_invite_link_send_request_fail", "add_people_invite_link_send_request", 1, null, null);
            k8(string, strI0, str);
            return;
        }
        User userW = WearUtils.y.w(str);
        if (userW != null && userW.addSendToMe()) {
            sg3.k(this, String.format(ah4.e(R.string.add_friend_user_requested), str));
            return;
        }
        User userW2 = WearUtils.y.w(string);
        if (userW2 == null || !userW2.isFriend()) {
            e8(string, str);
        } else {
            sg3.i(this, R.string.add_friend_user_exist);
        }
    }

    @Override // dc.ge3.b
    public void R1(int i2, String str) {
        if (i2 == 50000) {
            sg3.l(ah4.e(R.string.error_verify_reach_limit));
        } else {
            sg3.l(str);
        }
    }

    public final void R7(LoginUserBean loginUserBean, String str, String str2) throws IOException {
        String strI = WearUtils.i(str);
        ye3.K(5);
        ye3.L(loginUserBean);
        S7();
        xe2.L0().A(ch3.n().X());
        DaoUtils.upDateEmail(loginUserBean);
        I6();
        synchronized (this) {
            Y7();
            this.D.W(new q0(strI, str2));
        }
        if (eg3.d(WearUtils.x, "need_upload_cold_restart", false)) {
            this.n.D();
        } else {
            this.n.l();
        }
    }

    public final void S7() throws IOException {
        ParseData parseData;
        String stringExtra = getIntent().getStringExtra("com.parse.Data");
        MyApplication.Z = false;
        MyApplication.O = true;
        if (c0) {
            c0 = false;
            return;
        }
        WearUtils.x.n0();
        bg3.b();
        re3.p(null);
        WearUtils.E.clear();
        EventBus.getDefault().post(ManagerRDBean.getManager());
        re3.m();
        re3.t();
        OrgySetting.getInstance().syncOrgyActivity(null);
        if (ch3.n().X()) {
            xe2.L0().s();
        }
        if (WearUtils.e1(db2.A().c)) {
            db2.A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
        }
        if (stringExtra != null && (parseData = (ParseData) WearUtils.A.fromJson(stringExtra, ParseData.class)) != null && !WearUtils.e1(parseData.getFrom())) {
            pj3.j(this, ChatActivity.class, "userId", parseData.getFrom());
            dismissLoadingProgress();
            return;
        }
        boolean z2 = this.z.n;
        if (DaoUtils.getTestValueDao().getExistKey(nd3.i(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) != null) {
            this.parentHandler.post(new Runnable() { // from class: dc.ow1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.o7();
                }
            });
        }
        re3.l();
        eh3.a().b(this);
        EventBus.getDefault().post(new LoginStatusActionEvent());
        if (WearUtils.x.j == 1) {
            ye3.U(false);
        }
        db2.A().v();
        a12.e().g(zt3.k, true, null);
        this.parentHandler.postDelayed(new Runnable() { // from class: dc.lw1
            @Override // java.lang.Runnable
            public final void run() {
                fp1.c();
            }
        }, 3500L);
        x6();
        if (TextUtils.isEmpty(getIntent().getStringExtra("email"))) {
            runOnMainThread(new c());
        }
        this.n.j(false);
        yd3.f();
        J6();
        a6();
        D6();
        a8();
        if (this.L == 1) {
            pj3.f(this, PasscodeActivity.class);
        }
        b6();
        String strF = ti3.f(this, "uploadLog.json");
        String str = "savedJson11111===" + strF;
        if (!WearUtils.e1(strF) && !strF.equals("{\"data\":[]}") && ch3.n().o() != null && !WearUtils.g1(WearUtils.x.G().o())) {
            rp1.v(strF);
            ti3.a(new File(getFilesDir(), "uploadLog.json"));
            String str2 = "savedJson22222===" + ti3.f(this, "uploadLog.json");
        }
        this.n.q();
        yf3.i.a().j();
    }

    public final void T7(boolean z2) {
    }

    @Override // dc.ep2
    public void U(boolean z2, NtokenResponseBean ntokenResponseBean) {
        try {
            uf2.v().p(ntokenResponseBean);
            if (ntokenResponseBean.dating == null) {
                DaoUtils.getCommunMessageDao().clearDateChat();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void U7(String str) {
        this.n.r(str);
    }

    public final void V5() {
        showLoadingProgress();
        final OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null) {
            return;
        }
        vg3.b().a(new Runnable() { // from class: dc.pw1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N6(openAppBean);
            }
        });
    }

    public void V7() {
        if (TextUtils.equals(pg3.h().b(), "vibemate") && pg3.h().d()) {
            String strH = eg3.h(this, "remote_vibemate_event_config_bean", "");
            if (!strH.isEmpty()) {
                this.O = ((RemoteVibemateEventConfigBean) WearUtils.A.fromJson(strH, RemoteVibemateEventConfigBean.class)).isResult();
            }
            this.p = eg3.f(this, "isInstall_vibemate", 1);
            this.M = eg3.d(this, "according_red_dot", false);
            this.N = eh3.a().e(this);
            c6();
        }
    }

    public void W5(String str) throws Throwable {
        File fileE0 = WearUtils.e0("language/" + str);
        if (fileE0.exists()) {
            String strN1 = WearUtils.N1(fileE0.getPath());
            if (TextUtils.isEmpty(strN1)) {
                return;
            }
            try {
                ah4.i((HashMap) JSON.parseObject(strN1, new e(this), new Feature[0]));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void W7() {
        try {
            if (getIntent().getIntExtra("isOrgyJump", 0) == 1) {
                String stringExtra = getIntent().getStringExtra(ImagesContract.URL);
                if (WearUtils.e1(stringExtra)) {
                    return;
                }
                pj3.w(this, stringExtra);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean X5(int[] iArr) {
        for (int i2 : iArr) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public final void X7() throws Resources.NotFoundException {
        if (getIntent().getIntExtra("isPatternJump", 0) == 1) {
            this.C.setCurrentItem(2);
        }
    }

    public final void Y5(LoginUserBean loginUserBean, String str, String str2) throws IOException {
        if (loginUserBean.isVerify()) {
            R7(loginUserBean, str, str2);
            return;
        }
        if (loginUserBean.isNewUser()) {
            R7(loginUserBean, str, str2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            String str3 = localDateTimeNow.format(dateTimeFormatterOfPattern);
            if (!localDateTimeNow.plusSeconds(1L).isBefore(LocalDateTime.ofInstant(Instant.ofEpochSecond(loginUserBean.getVerifyExpiredTime() / 1000), ZoneId.systemDefault()))) {
                Bundle bundle = new Bundle();
                bundle.putString("gotoVerify", loginUserBean.getVerifyEmailUrl());
                pj3.g(this, LoginActivity.class, bundle);
                MyApplication.Q = 0;
                WearUtils.x.C0();
                finish();
                return;
            }
            String strH = eg3.h(this, "open_verify_email", "");
            if (WearUtils.e1(strH)) {
                eg3.i(this, "open_verify_email", str3);
                m6(loginUserBean.getVerifyEmailUrl());
                R7(loginUserBean, str, str2);
                return;
            }
            if (ChronoUnit.SECONDS.between(LocalDateTime.parse(strH, dateTimeFormatterOfPattern), localDateTimeNow) < loginUserBean.getVerifyEmailTipIntervalDays() * 24 * 60 * 60) {
                R7(loginUserBean, str, str2);
                return;
            }
            m6(loginUserBean.getVerifyEmailUrl());
            R7(loginUserBean, str, str2);
            eg3.i(this, "open_verify_email", str3);
        }
    }

    public final void Y7() {
        List<User> listFindAll = DaoUtils.getUserDao().findAll();
        if (listFindAll == null || listFindAll.isEmpty()) {
            return;
        }
        new Thread(new a(listFindAll)).start();
    }

    @Override // dc.ep2
    public void Z0(boolean z2, PrivacyPolicyStatusBean privacyPolicyStatusBean) {
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: Z5, reason: merged with bridge method [inline-methods] */
    public final void i7() {
        if (q61.f(this, "android.permission.READ_MEDIA_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ye3.d = ye3.r(this.z);
            H6();
            rf3.l(false);
        }
    }

    public final void Z7(Collection<RosterEntry> collection) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final List<User> listFindAll = DaoUtils.getUserDao().findAll();
        if (listFindAll == null || listFindAll.isEmpty()) {
            return;
        }
        String str = "entries长度===" + collection.size();
        if (collection.size() > 0) {
            Iterator<RosterEntry> it = collection.iterator();
            while (it.hasNext()) {
                String strG0 = WearUtils.g0(it.next().getUser());
                String str2 = "email======" + strG0;
                arrayList2.add(strG0);
            }
        }
        final XYBean xYBeanQ0 = WearUtils.Q0();
        new Thread(new Runnable() { // from class: dc.tv1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.u7(arrayList2, listFindAll, xYBeanQ0, arrayList);
            }
        }).start();
    }

    public final void a6() {
        tn2.x(WearUtils.x).t("/api/remote/policy/checkNew", new HashMap(), new j());
    }

    public final void a8() {
        Account accountU = ch3.n().u();
        if (accountU == null) {
            return;
        }
        String str = "beta_new_record" + bf3.c(accountU.getId());
        if (TextUtils.isEmpty(zd3.c(str))) {
            zd3.f(str, "true");
            tn2.x(WearUtils.x).t("/beta/new/record", new HashMap(), new d(this));
        }
    }

    public final void b() {
        if (!f0) {
            f0 = true;
            this.parentHandler.postDelayed(new Runnable() { // from class: dc.zw1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.f0 = false;
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return;
        }
        try {
            if (this.z == null || MyApplication.H() == null) {
                return;
            }
            moveTaskToBack(false);
        } catch (Exception unused) {
        }
    }

    public final void b6() {
        if (Build.VERSION.SDK_INT < 31 || pc1.a.o().size() <= 0) {
            return;
        }
        if ((getPackageManager().checkPermission("android.permission.BLUETOOTH_SCAN", getPackageName()) == 0) || !this.q) {
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.notification_android12_bluetooth_required));
        bVar.b(false);
        bVar.d(new l0());
        bVar.o(ah4.e(R.string.common_ok));
        cs3.h(bVar).show();
        this.q = false;
    }

    public final void b8() {
        OfficialaCountModel.g.a().E(lg3.b(this));
    }

    public void c6() {
        this.x.b(2, false);
        if (this.U > 0) {
            this.x.b(2, true);
            return;
        }
        boolean z2 = WearUtils.D;
        if (this.O && this.N && !z2 && this.p == 1 && !this.M) {
            this.x.b(2, true);
        }
    }

    public void c8() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA");
        q61VarM.j(new e0());
    }

    public final void d6() {
        Dialog dialog = this.T;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.T.dismiss();
    }

    public final void d8() {
        Intent intent = new Intent(this, (Class<?>) WebScanActivity.class);
        pj3.d(intent);
        startActivityForResult(intent, 1219);
    }

    public final void e6(String str, String str2) {
        WearUtils.f(zd3.b(this, "xmpp_email"));
        zd3.b(this, "xmpp_password");
        ye3.p(0, 6, str2, str);
        sg3.k(this, str);
        u8();
    }

    public final void e8(String str, String str2) {
        User userW = WearUtils.y.w(str);
        if (userW == null || !userW.isFriend()) {
            if (!hu3.k(str)) {
                sg3.i(this, R.string.common_serverError);
                return;
            }
            sg3.i(this, R.string.user_add_success);
            User userV = WearUtils.y.v(str);
            if (userV == null) {
                userV = new User(str);
                try {
                    VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(WearUtils.i0(str));
                    if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                        userV.setName(vCardLoadVCard.getNickName());
                    }
                    if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                        WearUtils.s2(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"), userV);
                    }
                    userV.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
                    userV.setAge(vCardLoadVCard.getField("AGE"));
                    userV.setFriendGTMTime(vCardLoadVCard.getField("GMTTIME"));
                    userV.setDeviceType(vCardLoadVCard.getField("DEVICETYPE"));
                    userV.setDeviceAppVersion(vCardLoadVCard.getField("APPVERSION"));
                } catch (Exception unused) {
                }
                userV.resetFriendType(2);
            } else if (userV.haveFriendType(1)) {
                userV.resetFriendType(1);
            } else {
                userV.resetFriendType(2);
            }
            WearUtils.y.b(userV);
            HashMap map = new HashMap();
            map.put("add_channel", 4);
            map.put("who_be_invited", userV.getUserJid());
            ye3.d("F0019", WearUtils.A.toJson(map));
            o8();
        }
    }

    @Override // dc.ep2
    public void f(boolean z2, final String str, final String str2) {
        dismissLoadingProgress();
        if (str2.equals("10022")) {
            vc2.b(this, new View.OnClickListener() { // from class: dc.xw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.m7(str, str2, view);
                }
            });
        } else {
            e6(str, str2);
        }
    }

    public final void f6(Intent intent, Account account, OpenAppBean openAppBean) {
        if (TextUtils.isEmpty(openAppBean.datingId)) {
            dismissLoadingProgress();
            return;
        }
        if (openAppBean.selfId == null) {
            openAppBean.selfId = account.getId();
        }
        if (!openAppBean.selfId.equals(account.getId())) {
            if (TextUtils.isEmpty(intent.getStringExtra("email"))) {
                l8(openAppBean.receiverName, openAppBean.selfId);
                return;
            }
            return;
        }
        User user = WearUtils.y.y().get(openAppBean.userId);
        ob2.i = openAppBean.datingId;
        if (user == null) {
            V5();
            return;
        }
        dismissLoadingProgress();
        user.addFriendType(32);
        user.setFagree(0);
        user.setIagree(0);
        if (!TextUtils.isEmpty(openAppBean.receiverName)) {
            user.setTempName(openAppBean.receiverName);
        }
        pj3.j(this, ChatActivity.class, "userId", openAppBean.userId);
    }

    public void f8(int i2) {
        this.x.c(2, i2);
    }

    public final String g6(int i2, String[] strArr) {
        String strF = lg3.f(this.z);
        int length = strArr.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (strArr[i3].equals(strF)) {
                z2 = true;
                break;
            }
            i3++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("longDistanceGuide/");
        if (!z2) {
            strF = "en";
        }
        sb.append(strF);
        sb.append("/view_long_distance_");
        sb.append(i2);
        sb.append(".png");
        return sb.toString();
    }

    public final void g8() {
        this.w.O(R.drawable.activite_me_selector);
        this.v.O(R.drawable.activite_discover_selector);
        this.u.O(R.drawable.activite_long_selector);
        this.t.O(R.drawable.activite_home_selector);
    }

    @Override // dc.ep2
    public void h(boolean z2, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean) {
        new Thread(new b(this, queryRemoteAccountInfoBean)).start();
    }

    public void h6() {
        long jG = eg3.g(this, "limit_the_duration", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        RemoteVibemateEventConfigBean remoteVibemateEventConfigBean = (RemoteVibemateEventConfigBean) WearUtils.A.fromJson(eg3.h(this, "remote_vibemate_event_config_bean", ""), RemoteVibemateEventConfigBean.class);
        if (remoteVibemateEventConfigBean == null) {
            this.n.m(false);
        } else if (!remoteVibemateEventConfigBean.isResult()) {
            this.n.m(remoteVibemateEventConfigBean.isResult());
        } else if (jCurrentTimeMillis - jG >= 3600000) {
            this.n.m(remoteVibemateEventConfigBean.isResult());
        }
    }

    public final void h8() {
        if (this.t == null) {
            this.t = new HomeFragment();
        }
        this.t.P(ah4.e(R.string.main_menu_home));
        if (this.u == null) {
            this.u = new LongFragment();
        }
        this.u.P(ah4.e(R.string.main_partnerPlay));
        if (this.v == null) {
            this.v = new DiscoverFragment();
        }
        this.v.P(ah4.e(R.string.main_menu_discover));
        if (this.w == null) {
            this.w = new MeFragment();
        }
        this.w.P(ah4.e(R.string.str_me));
    }

    @Override // dc.ge3.b
    public void i0(String str) {
        Dialog dialog = this.S;
        if (dialog != null && dialog.isShowing()) {
            this.S.dismiss();
        }
        n8(str);
    }

    public final void i6() {
        String str = "shareDataBean的size" + ch3.i.size();
        runOnMainThread(new t());
    }

    public final void i8() {
        int iF = df3.e().f() + this.V;
        if (iF == 0 || MyApplication.Z) {
            this.x.c(1, 0);
        } else {
            this.x.c(1, iF);
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.e(this);
        this.mPresenter = this.n;
    }

    @Override // dc.ep2
    public void j1(final String str, final InviteRequestInfo inviteRequestInfo) {
        InviteUserRequestFragment inviteUserRequestFragment = this.a0;
        if (inviteUserRequestFragment != null && inviteUserRequestFragment.isResumed()) {
            this.a0.dismissAllowingStateLoss();
        }
        vz1.a(new wz1(wz1.b.INVITE, new wz1.a() { // from class: dc.hw1
            @Override // dc.wz1.a
            public final void a() {
                this.a.G7(str, inviteRequestInfo);
            }
        }));
    }

    public final void j6() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            vz1.b(wz1.b.POWER);
            return;
        }
        if (i2 > 22) {
            if (WearUtils.p1()) {
                this.parentHandler.post(new Runnable() { // from class: dc.bx1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.R6();
                    }
                });
                return;
            }
            is3.b bVar = new is3.b(this);
            bVar.o(ah4.e(R.string.button_continue));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.c(new l(this));
            bVar.d(new k());
            bVar.p(ah4.e(R.string.permission_buletooth_forground));
            cs3.h(bVar).show();
        }
    }

    public final void j8(final User user, final String str) {
        user.resetAddFriendInfo();
        user.setAddMessage(false);
        is3.b bVar = new is3.b(this);
        bVar.p(user.getTempName());
        bVar.d(new is3.d() { // from class: dc.jw1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.w7(user, str);
            }
        });
        bVar.c(new is3.c() { // from class: dc.tw1
            @Override // dc.is3.c
            public final void doCancel() {
                this.a.y7(user, str);
            }
        });
        bVar.n(ah4.e(R.string.common_no));
        bVar.o(ah4.e(R.string.common_yes));
        DatingAddFriendDialog datingAddFriendDialog = (DatingAddFriendDialog) cs3.i(bVar, DatingAddFriendDialog.class);
        datingAddFriendDialog.show();
        datingAddFriendDialog.p();
        ob2.o().b = true;
        datingAddFriendDialog.setListener(new DatingAddFriendDialog.b() { // from class: dc.gw1
            @Override // com.wear.widget.dialog.DatingAddFriendDialog.b
            public final void onDismiss() {
                ob2.o().b = false;
            }
        });
    }

    @Override // dc.ep2
    public void k1(boolean z2, String str) {
        DaoUtils.getTestValueDao().save(str, System.currentTimeMillis() + "", TestValueDao.SHOW_WEAK_PSW_DIALOG_TYPE);
        DaoUtils.getTestValueDao().save(str, System.currentTimeMillis() + "", TestValueDao.SHOW_COMMON_PSW_DIALOG_TYPE);
        cs3.e(this, ah4.e(R.string.security_tip_title), ah4.e(R.string.security_tip_note), ah4.e(R.string.common_chage), ah4.e(R.string.button_not_now_1), new is3.d() { // from class: dc.yw1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.K7();
            }
        }, new is3.c() { // from class: dc.bw1
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0026", 1, 1);
            }
        }).show();
        vf3.a("A0025", 1, -1);
    }

    public final void k6() {
        if (MyApplication.V != null) {
            Handler handler = new Handler();
            this.W = handler;
            s sVar = new s();
            this.X = sVar;
            handler.postDelayed(sVar, 1000L);
        }
    }

    public final void k8(String str, String str2, String str3) {
        runOnUiThread(new j0(str3, str2, str));
    }

    @Override // dc.bu3
    public void l3(String str) {
        sg3.k(this, str);
        dismissLoadingProgress();
        u8();
    }

    public final void l6() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Intent intent = new Intent();
                String packageName = getPackageName();
                intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent.setData(Uri.parse("package:" + packageName));
                startActivityForResult(intent, 1001);
            } catch (Exception unused) {
            }
        }
    }

    public final void l8(String str, String str2) {
        final OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null) {
            return;
        }
        String str3 = String.format(ah4.e(R.string.str_login_diffenct_account), str, str2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int iLastIndexOf = str3.lastIndexOf(str);
        if (iLastIndexOf != -1 && str.length() + iLastIndexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_accent)), iLastIndexOf, str.length() + iLastIndexOf, 34);
        }
        int iLastIndexOf2 = str3.lastIndexOf(str2);
        if (iLastIndexOf2 != -1 && str2.length() + iLastIndexOf2 <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_accent)), iLastIndexOf2, str2.length() + iLastIndexOf2, 34);
        }
        cs3.k(this, spannableStringBuilder, new is3.d() { // from class: dc.ww1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.B7(openAppBean);
            }
        }).show();
    }

    public final void m6(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void m8() {
    }

    public final void n6(Intent intent) {
        Account accountU = ch3.n().u();
        if (accountU == null) {
            return;
        }
        final OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null) {
            dismissLoadingProgress();
            return;
        }
        xe3.a("displayPannel", "handleNewTask: " + openAppBean.type);
        int i2 = openAppBean.type;
        if (i2 == -1) {
            if (!WearUtils.k1(openAppBean.userId)) {
                p6(openAppBean);
                return;
            } else {
                this.Q.add(Observable.create(new ObservableOnSubscribe() { // from class: dc.cw1
                    @Override // io.reactivex.ObservableOnSubscribe
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        this.a.U6(openAppBean, observableEmitter);
                    }
                }).timeout(3L, TimeUnit.SECONDS).doFinally(new Action() { // from class: dc.fw1
                    @Override // io.reactivex.functions.Action
                    public final void run() throws Exception {
                        this.a.W6();
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.sw1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) throws Exception {
                        this.a.Y6(openAppBean, (String) obj);
                    }
                }, new Consumer() { // from class: dc.nw1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) throws Exception {
                        this.a.a7(openAppBean, (Throwable) obj);
                    }
                }));
                return;
            }
        }
        if (i2 == 0) {
            f6(intent, accountU, openAppBean);
            return;
        }
        if (i2 == 2) {
            q6(openAppBean);
            return;
        }
        if (i2 == 3) {
            u6(openAppBean);
            return;
        }
        if (i2 == 4 || MyApplication.U.type == 5) {
            o6(openAppBean);
            return;
        }
        if (i2 == 6 || i2 == 8) {
            v6();
            return;
        }
        if (i2 == 7) {
            t6(openAppBean);
            return;
        }
        if (i2 == 9) {
            Z4(openAppBean.data);
        } else if (i2 == 10) {
            this.n.B(openAppBean.data);
        } else if (i2 == 11) {
            w6();
        }
    }

    public void n8(String str) {
        is3.b bVar = new is3.b(this);
        bVar.d(new m(this));
        bVar.c(new is3.c() { // from class: dc.cx1
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0024", 1, 1);
            }
        });
        bVar.h(true);
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_cancel);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.button_verified));
        bVar.e(str);
        is3 is3VarI = cs3.i(bVar, NewEmailVerifyDialog.class);
        this.R = is3VarI;
        is3VarI.setOnDismissListener(new n());
        ((NewEmailVerifyDialog) this.R).setiVerifyEmailListener(new o(str));
        ((NewEmailVerifyDialog) this.R).setAutoSend(false);
        this.R.show();
        vf3.a("A0023", 1, -1);
    }

    public final void o6(OpenAppBean openAppBean) {
        String str = openAppBean.data;
        int i2 = openAppBean.type;
        String str2 = "handleNewTask: isConnect = " + uf2.v().q();
        dq2.w().G(str, i2, this);
    }

    public final void o8() {
        d71 d71Var = new d71();
        d71Var.a = "Request Sent";
        d71Var.e = new o71(R.layout.toast_success);
        f71.k(d71Var);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        String str = "onActivityResult: " + i2 + "  " + i3;
        if (i2 == GiftCardActivity.i) {
            EventBus.getDefault().post(new GiftCardEvent(0));
        }
        if (i2 == 10086) {
            if (i3 == -1) {
                ee3.p(this, ee3.o());
            } else if (Build.VERSION.SDK_INT >= 26) {
                if (getPackageManager().canRequestPackageInstalls()) {
                    ee3.p(this, ee3.o());
                } else {
                    final boolean zW = MyApplication.W();
                    String strE = ah4.e(R.string.common_cancel);
                    if (zW) {
                        strE = ah4.e(R.string.common_exit);
                    }
                    cs3.d(this, ah4.e(R.string.apk_update_fail_android_o_permission), ah4.e(R.string.common_update), strE, new is3.d() { // from class: dc.aw1
                        @Override // dc.is3.d
                        public final void doConfirm() {
                            this.a.r7();
                        }
                    }, new is3.c() { // from class: dc.vw1
                        @Override // dc.is3.c
                        public final void doCancel() {
                            MainActivity.s7(zW);
                        }
                    }).show();
                }
            }
        }
        if (i2 == 10087 && i3 != -1 && MyApplication.W()) {
            this.parentHandler.postDelayed(new u(this), 1000L);
        }
        if (i2 == 1001) {
            j6();
        }
        if (i2 == e0 && WearUtils.p1()) {
            j6();
        }
        if (i2 == 12345 && i3 == 3456789) {
            if (intent == null) {
                return;
            }
            if (!WearUtils.e1(intent.getStringExtra("applicationName"))) {
                ye3.j("game", "game_exit_click", "click", intent.getStringExtra(RemoteConfigConstants.RequestFieldKey.APP_ID), "button", "", intent.getStringExtra("applicationName"), intent.getLongExtra(TypedValues.TransitionType.S_DURATION, 0L) / 1000);
            }
        }
        if (i2 == 159147123 && i3 == 11111) {
            if (intent == null) {
                return;
            }
            LoginUserBean loginUserBeanO = ch3.n().o();
            if (loginUserBeanO != null) {
                this.n.h(loginUserBeanO.getPwdType(), loginUserBeanO.isVerify(), loginUserBeanO.getEmail());
                k6();
            }
        }
        if (i3 != -1) {
            return;
        }
        if (i2 == 48) {
            this.E.get(2).K(intent);
            return;
        }
        if (i2 != 1087) {
            if (i2 != 1219) {
                return;
            }
            ve3.d().f();
        } else if (i3 == -1) {
            if (intent.getBooleanExtra("grant_all", false)) {
                c8();
            } else {
                new kn3((Context) this, ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new v()).show();
            }
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        b();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        this.o = bundle;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findViewById(R.id.main_layout);
        setVolumeControlStream(3);
        this.z = (MyApplication) getApplication();
        MyApplication.u0(this);
        MyApplication.N = true;
        MusicControl.h0().g();
        k12.m.o(this);
        EventBus.getDefault().register(this);
        this.P = getIntent().getBooleanExtra("isFinishToLongDistance", false);
        MyApplication.Z = getIntent().getBooleanExtra("isOffline", false);
        W7();
        this.A = WearUtils.y.u();
        K6();
        DaoUtils.getTestValueDao().resetRecordList();
        if (!MyApplication.R) {
            String strH = eg3.h(this, "check_app_version", null);
            if (WearUtils.e1(strH) || !strH.equals(ye3.s())) {
                this.n.C();
            }
        }
        if (eg3.a(this, "passcode_code_key")) {
            MyApplication myApplication = this.z;
            if (myApplication.n) {
                myApplication.p0(false);
                pj3.h(this, LockActivity.class, "open_passcode_lock", 0);
            }
        }
        z6();
        h6();
        this.n.n();
        this.n.k();
        this.n.o();
        pf3.e(this);
        B6();
        WearUtils.y();
        hu3.z(this).l(this);
        E6();
        this.K = getIntent().getBooleanExtra(AccountDeleteActivity.c, false);
        v8();
        new Timer().schedule(new i(), 0L, 5000L);
        nu1.c(this);
        ne3.a.a();
        b8();
        F6();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity fragmentActivityH = MyApplication.H();
        MyApplication.a0 = false;
        if (fragmentActivityH != null && fragmentActivityH.equals(this)) {
            this.z.q0(null);
        }
        MyApplication.u0(null);
        dismissLoadingProgress();
        hu3.z(this).c0(this);
        EventBus.getDefault().unregister(this);
        rd3.f().b(this);
        this.Q.clear();
        Handler handler = this.W;
        if (handler != null) {
            handler.removeCallbacks(this.X);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsAckClEvent addFriendsAckClEvent) {
        this.y = false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternSyncEndEvent patternSyncEndEvent) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMigCheckFieldsEvent(MigCheckFieldsEvent migCheckFieldsEvent) {
        if (migCheckFieldsEvent.isPass()) {
            return;
        }
        sg3.l("新增加的聊天字段未添加到消息迁移转换类里,在MigrateAdapterBean增加对应字段");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws Resources.NotFoundException {
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("isFinishToLongDistance", false);
        this.P = booleanExtra;
        if (booleanExtra) {
            this.C.setCurrentItem(1);
        }
        Map<String, User> mapY = WearUtils.y.y();
        if (MyApplication.U != null || mapY == null || mapY.size() == 0) {
            r6(intent);
            X7();
            return;
        }
        for (User user : mapY.values()) {
            if (user.isDateIng()) {
                pj3.j(this, ChatActivity.class, "userId", user.getId());
                return;
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.F != null) {
            LocalBroadcastManager.getInstance(WearUtils.x).unregisterReceiver(this.F);
            this.F = null;
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (WearUtils.x.G().N() != null && pf3.d(this) && !eg3.d(this, "is_first_show_battery", false)) {
            vz1.a(new wz1(wz1.b.POWER, new wz1.a() { // from class: dc.uw1
                @Override // dc.wz1.a
                public final void a() {
                    this.a.y6();
                }
            }));
        }
        this.F = new r0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_TOY_UPDATE");
        intentFilter.addAction("com.wear.messageTip");
        intentFilter.addAction("com.wear.messageTipB");
        LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.F, intentFilter);
        this.z.q0(this);
        i8();
        if (this.A != null) {
            this.n.i();
        }
        new Bundle().putString("MainActivity", WearUtils.y.r());
        boolean zBooleanValue = ((Boolean) eg3.b(this, "crash_handler", Boolean.FALSE)).booleanValue();
        System.out.println("cresh.main.error" + zBooleanValue);
        if (zBooleanValue) {
            eg3.m(this, "crash_handler");
        }
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (PlayService.R) {
                Map<Integer, String> map = MyApplication.k0;
                if (map != null && map.size() > 0) {
                    for (Integer num : MyApplication.k0.keySet()) {
                        if (num != null) {
                            notificationManager.cancel(num + "", num.intValue());
                        }
                    }
                }
            } else {
                notificationManager.cancelAll();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c6();
        m8();
        T7(true);
        if (this.K) {
            this.K = false;
            this.C.setCurrentItem(this.E.size() - 1);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        p8();
        if (this.m == 1) {
            G6();
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            if (this.E.get(i2).isAdded()) {
                this.s.putFragment(bundle, this.E.get(i2).getClass().getSimpleName(), this.E.get(i2));
            }
        }
    }

    public final void p6(OpenAppBean openAppBean) {
        dismissLoadingProgress();
        if (WearUtils.k1(openAppBean.userId)) {
            pj3.j(this, ChatActivity.class, "userId", openAppBean.userId);
        } else {
            pj3.j(this, ChatRoomActivity.class, "roomId", openAppBean.userId);
        }
    }

    public final void p8() {
        this.x.b(3, WearUtils.I1(this, "key_show_red_by_connections"));
    }

    public final void q6(OpenAppBean openAppBean) {
        if (WearUtils.e1(openAppBean.data)) {
            return;
        }
        String strH = nd3.h(openAppBean.data);
        if (TextUtils.isEmpty(strH)) {
            sg3.i(this, R.string.qrcode_not_lovense_qrcode);
            return;
        }
        xe3.a("displayPannel", "result=" + strH);
        ScanBean scanBean = null;
        try {
            scanBean = (ScanBean) JSON.parseObject(strH, ScanBean.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (scanBean == null) {
            sg3.i(this, R.string.qrcode_not_lovense_qrcode);
            return;
        }
        if ("c".equals(scanBean.getA())) {
            sg3.i(this, R.string.qrcode_scan_with_connect);
            return;
        }
        ArrayList<Toy> arrayList = new ArrayList(this.z.G().o());
        ArrayList arrayList2 = new ArrayList();
        for (Toy toy : arrayList) {
            if (toy.isSelect() && toy.isSupportControlPanel() && toy.isConnected()) {
                arrayList2.add(toy);
            }
        }
        if (arrayList2.size() == 0) {
            sg3.i(this, R.string.qrcode_browser_dont_connect_max);
            return;
        }
        final String d2 = scanBean.getD();
        if (arrayList2.size() == 1) {
            if (hf3.d(this)) {
                s8((Toy) arrayList2.get(0), d2);
                return;
            } else {
                sg3.i(this, R.string.qrcode_no_network);
                return;
            }
        }
        is3.b bVar = new is3.b(this);
        bVar.o(ah4.e(R.string.common_ok));
        bVar.u(R.id.tv_confirm);
        bVar.p(ah4.e(R.string.qrcode_scan_two_toy));
        bVar.e(arrayList2);
        SelectToyDailog selectToyDailog = (SelectToyDailog) cs3.i(bVar, SelectToyDailog.class);
        selectToyDailog.show();
        selectToyDailog.setListener(new SelectToyDailog.a() { // from class: dc.ew1
            @Override // com.wear.widget.dialog.SelectToyDailog.a
            public final void a(Toy toy2) {
                this.a.c7(d2, toy2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q8(java.lang.String r11) {
        /*
            r10 = this;
            android.app.Dialog r0 = r10.T
            if (r0 == 0) goto L5
            return
        L5:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto Lc
            return
        Lc:
            com.wear.util.MyApplication r0 = r10.z
            dc.pc1 r0 = r0.G()
            com.wear.bean.Toy r11 = r0.Q(r11)
            if (r11 != 0) goto L19
            return
        L19:
            r0 = 0
            boolean r1 = r11.isEI01Toy()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L38
            java.lang.Integer r1 = r11.getVersion()
            int r1 = r1.intValue()
            r4 = 3
            if (r1 >= r4) goto L38
            r0 = 2131887851(0x7f1206eb, float:1.941032E38)
            java.lang.String r0 = dc.ah4.e(r0)
        L34:
            r6 = r0
            r2 = 1
            goto Lad
        L38:
            boolean r1 = r11.isEAToy()
            r4 = 4
            if (r1 == 0) goto L51
            java.lang.Integer r1 = r11.getVersion()
            int r1 = r1.intValue()
            if (r1 >= r4) goto L51
            r0 = 2131887846(0x7f1206e6, float:1.941031E38)
            java.lang.String r0 = dc.ah4.e(r0)
            goto L34
        L51:
            boolean r1 = r11.isXMachine()
            r5 = 2131887848(0x7f1206e8, float:1.9410315E38)
            if (r1 == 0) goto L8b
            int r1 = r11.getToyVersion()
            r6 = 50
            if (r1 < r6) goto L6a
            int r1 = r11.getToyVersion()
            r6 = 51
            if (r1 <= r6) goto L7a
        L6a:
            int r1 = r11.getToyVersion()
            r6 = 80
            if (r1 < r6) goto L8b
            int r1 = r11.getToyVersion()
            r6 = 83
            if (r1 > r6) goto L8b
        L7a:
            java.lang.String r0 = dc.ah4.e(r5)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r4 = r11.getShowName()
            r1[r2] = r4
            java.lang.String r0 = java.lang.String.format(r0, r1)
            goto L34
        L8b:
            boolean r1 = r11.isMiniXMachine()
            if (r1 == 0) goto Lac
            java.lang.Integer r1 = r11.getVersion()
            int r1 = r1.intValue()
            if (r1 >= r4) goto Lac
            java.lang.String r0 = dc.ah4.e(r5)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r4 = r11.getShowName()
            r1[r2] = r4
            java.lang.String r0 = java.lang.String.format(r0, r1)
            goto L34
        Lac:
            r6 = r0
        Lad:
            if (r2 != 0) goto Lb0
            return
        Lb0:
            r0 = 2131886368(0x7f120120, float:1.9407313E38)
            java.lang.String r5 = dc.ah4.e(r0)
            r0 = 2131886394(0x7f12013a, float:1.9407366E38)
            java.lang.String r7 = dc.ah4.e(r0)
            r8 = 0
            dc.iw1 r9 = new dc.iw1
            r9.<init>()
            r4 = r10
            dc.is3 r11 = dc.cs3.g(r4, r5, r6, r7, r8, r9)
            r10.T = r11
            r11.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.MainActivity.q8(java.lang.String):void");
    }

    public final void r6(Intent intent) {
        int i2;
        xe3.a("displayPannel", "handleNewTask: handleNewTask");
        if (!MyApplication.Z) {
            if (this.z.n) {
                return;
            }
            n6(intent);
            return;
        }
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null || !((i2 = openAppBean.type) == 4 || i2 == 5)) {
            if (openAppBean == null || openAppBean.type != 10) {
                pj3.f(this, LoginActivity.class);
                return;
            } else {
                this.n.B(openAppBean.data);
                return;
            }
        }
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.offline_notification));
        bVar.d(new x());
        bVar.c(new w(this));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.common_ok));
        cs3.h(bVar).show();
    }

    public void r8(String str) {
        DaoUtils.getTestValueDao().save(str, System.currentTimeMillis() + "", TestValueDao.SHOW_WEAK_PSW_DIALOG_TYPE);
        DaoUtils.getTestValueDao().save(str, System.currentTimeMillis() + "", TestValueDao.SHOW_COMMON_PSW_DIALOG_TYPE);
        cs3.e(this, "", ah4.e(R.string.notification_weak_password2), ah4.e(R.string.common_chage), ah4.e(R.string.button_not_now_1), new is3.d() { // from class: dc.rw1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.N7();
            }
        }, new is3.c() { // from class: dc.uv1
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0026", 2, 1);
            }
        }).show();
        vf3.a("A0025", 2, -1);
    }

    public final void s6(int i2, String str) {
        mk2.P().e0();
        mk2.P().r0(2);
        if (this.z.G().P().size() > 0) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            showDialog();
            mk2.P().q0(i2, str, new d0());
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.m(false);
        bVar.l(false);
        bVar.p(ah4.e(R.string.vp_toy_fst));
        bVar.o(ah4.e(R.string.lan_api_connect_toy));
        VideoPatternConnectToyDialog videoPatternConnectToyDialog = (VideoPatternConnectToyDialog) cs3.i(bVar, VideoPatternConnectToyDialog.class);
        videoPatternConnectToyDialog.p(new c0());
        videoPatternConnectToyDialog.show();
        mk2.P().E("", "", 2);
    }

    public final void s8(Toy toy, String str) {
        pb2.m().G(toy, str, 1, new y());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void spotifyCheckIn(HomeMusicBean homeMusicBean) {
        String str = "homeMusicBean type:" + homeMusicBean.getType();
        if (homeMusicBean.getType() != 3 && homeMusicBean.getType() != 4) {
            if (homeMusicBean.getType() == 10) {
                h7();
            }
        } else if (MusicControl.h0().e.t()) {
            d0 = true;
            EventBus.getDefault().post(new HomeMusicBean(5));
        } else if (!WearUtils.e1(l12.m(2, "")) || homeMusicBean.getType() == 3) {
            spotifyCheckIn(true, new g0(this));
        } else {
            d0 = false;
        }
    }

    @Override // dc.ep2
    public void t3(BaseResponseBean baseResponseBean) {
        Q7(baseResponseBean);
    }

    public final void t6(OpenAppBean openAppBean) {
        this.Q.add(Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a0(openAppBean)));
    }

    public void t8() {
        List<BaseFragment> list;
        if (this.m != 2 || (list = this.E) == null) {
            return;
        }
        list.get(2).I();
    }

    @Override // dc.bu3
    public void u1(String str) {
        dismissLoadingProgress();
        if (this.y) {
            sg3.k(this, str);
        }
    }

    public final void u6(OpenAppBean openAppBean) {
        gg2.d().e(this, openAppBean.data);
    }

    public final void u8() {
        MyApplication.Q = 0;
        WearUtils.x.C0();
        pj3.f(this, LoginActivity.class);
        finish();
    }

    public final void v6() {
        ScanBean scanBean;
        if (TextUtils.isEmpty(MyApplication.U.data)) {
            return;
        }
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean.type == 8) {
            String strH = nd3.h(openAppBean.data);
            xe3.a(b0, "解密：result:" + strH);
            try {
                scanBean = (ScanBean) JSON.parseObject(strH, ScanBean.class);
            } catch (Exception e2) {
                e2.printStackTrace();
                scanBean = null;
            }
            if (scanBean != null && !TextUtils.isEmpty(scanBean.getD())) {
                s6(2, scanBean.getD());
            }
        } else {
            showDialog();
            HashMap map = new HashMap();
            map.put(XHTMLText.CODE, MyApplication.U.data);
            tn2.x(WearUtils.x).k("/api/remote/shortCode", map, new z());
        }
        MyApplication.v0(null);
    }

    public final void v8() {
        if (WearUtils.e1(l12.m(2, ""))) {
            return;
        }
        spotifyCheckIn(false, new i0(this));
    }

    public void w6() {
        I6();
        pj3.f(this, OfficialAccountActivity.class);
        ku1.a("Lovense Remote", "lovense_remote_notification_assistant_click", "click", "lovense_remote_notification_assistant", "", "", null, null);
    }

    public void w8(int i2) {
        this.V = i2;
        i8();
    }

    public void x6() {
        vg3.b().a(new Runnable() { // from class: dc.mw1
            @Override // java.lang.Runnable
            public final void run() throws ParseException {
                this.a.e7();
            }
        });
    }

    public final void x8() throws IOException {
        StrengthLogBean strengthLogBean = new StrengthLogBean();
        ArrayList arrayList = new ArrayList();
        Map<String, LinkedHashMap<List<String>, int[]>> map = jc1.c;
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, LinkedHashMap<List<String>, int[]>> entry : map.entrySet()) {
            StrengthLogBean.DataBean dataBean = new StrengthLogBean.DataBean();
            dataBean.setToyDeviceType(entry.getKey());
            LinkedHashMap<List<String>, int[]> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<List<String>, int[]> entry2 : value.entrySet()) {
                if (!X5(entry2.getValue())) {
                    arrayList2.add(entry2.getValue());
                }
            }
            if (!WearUtils.g1(arrayList2)) {
                dataBean.setToy_strength_range(arrayList2);
                arrayList.add(dataBean);
            }
        }
        strengthLogBean.setData(arrayList);
        if (WearUtils.e1(JSON.toJSONString(strengthLogBean)) || WearUtils.g1(arrayList)) {
            return;
        }
        ti3.g(this, JSON.toJSONString(strengthLogBean), "uploadLog.json");
        String str = "strengthLogBean====" + JSON.toJSONString(strengthLogBean);
    }

    @Override // dc.ep2
    public void y2(boolean z2, UserInfoBean userInfoBean) {
        try {
            if (userInfoBean.isResult()) {
                Map map = (Map) new Gson().fromJson(userInfoBean.getMessage(), Map.class);
                this.z.s0("isTest", Boolean.valueOf("1".equals(map.get("test"))));
                this.z.s0("isModel", Boolean.valueOf("1".equals(map.get("model"))));
            }
        } catch (Exception unused) {
        }
    }

    public final void y6() {
        runOnMainThread(new Runnable() { // from class: dc.rv1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g7();
            }
        });
    }

    public final void z6() throws IOException {
        this.parentHandler.postDelayed(new Runnable() { // from class: dc.qw1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i7();
            }
        }, 1000L);
        String str = "MyApplication.isOfflineMode:" + MyApplication.Z;
        if (!MyApplication.R) {
            MyApplication.r();
        }
        if (MyApplication.Z) {
            rf3.l(false);
            re3.l();
            eh3.a().b(this);
            re3.p(null);
            return;
        }
        dismissLoadingProgress();
        if (this.A == null) {
            String strB = zd3.b(this, "xmpp_email");
            String strI = WearUtils.i(strB);
            ye3.Y(strI);
            String strB2 = zd3.b(this, "xmpp_password");
            if (WearUtils.e1(strB2)) {
                MyApplication.Z = true;
                OpenAppBean openAppBean = MyApplication.U;
                if (openAppBean == null) {
                    vu1.e();
                    rf3.l(false);
                    re3.l();
                    b6();
                    eh3.a().b(this);
                    re3.p(null);
                    return;
                }
                int i2 = openAppBean.type;
                if (i2 != 4 && i2 != 5) {
                    if (i2 == 10) {
                        this.n.B(openAppBean.data);
                        return;
                    } else {
                        u8();
                        return;
                    }
                }
                is3.b bVar = new is3.b(this);
                bVar.p(ah4.e(R.string.offline_notification));
                bVar.d(new n0());
                bVar.c(new m0(this));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.o(ah4.e(R.string.common_ok));
                cs3.h(bVar).show();
                return;
            }
            ch3.n().A();
            Account accountU = WearUtils.y.u();
            this.A = accountU;
            if (accountU == null) {
                eg3.m(this, "xmpp_password");
                u8();
                return;
            }
            zt3.k = strI;
            this.D = hu3.z(this);
            MyApplication.Q = 1;
            this.z.S();
            nz1.e().i(this.A.getId());
            rf3.l(true);
            if (eg3.d(this, "is_third_login", false)) {
                tq2.a().c(this, tq2.a.Google, new o0());
            }
            this.n.z(false, strB, strB2);
        } else {
            vg3.b().a(new p0());
            S7();
            I6();
        }
        A6();
    }

    @Override // com.wear.BaseActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(KeepScreenSetting keepScreenSetting) {
        if (keepScreenSetting != null) {
            if (keepScreenSetting.isKeepOn()) {
                getWindow().setFlags(128, 128);
            } else {
                if (getClass().getSimpleName().equals("ChatActivity")) {
                    return;
                }
                getWindow().clearFlags(128);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Collection<RosterEntry> collection) {
        if (collection != null) {
            Z7(collection);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (xc1Var != null) {
            if (xc1Var.b() == 1) {
                q8(xc1Var.a());
            } else if (xc1Var.b() == -1) {
                d6();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Boolean bool) {
        if (bool.booleanValue()) {
            n6(getIntent());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(InDateActivityEvent inDateActivityEvent) throws Resources.NotFoundException {
        int i2 = inDateActivityEvent.flag;
        if (i2 != 0) {
            if (i2 == 5) {
                this.C.setCurrentItem(1);
                User user = inDateActivityEvent.data;
                if (user != null) {
                    j8(user, inDateActivityEvent.datingId);
                }
                if (mk2.P().h0()) {
                    mk2.P().n0(false);
                    return;
                }
                return;
            }
            return;
        }
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null) {
            return;
        }
        ob2.i = openAppBean.datingId;
        User user2 = WearUtils.y.y().get(openAppBean.userId);
        if (user2 == null) {
            V5();
            return;
        }
        if (!TextUtils.isEmpty(openAppBean.receiverName)) {
            user2.setTempName(openAppBean.receiverName);
        }
        user2.addFriendType(32);
        user2.resetAddFriendInfo();
        user2.setAddMessage(false);
        pj3.j(this, ChatActivity.class, "userId", openAppBean.userId);
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VideoPatternControlEvent videoPatternControlEvent) {
        dissDialog();
        if (videoPatternControlEvent.isSuccess() || MyApplication.H() != this) {
            return;
        }
        sg3.h(R.string.common_netError);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginOrOfflineEvent loginOrOfflineEvent) throws IOException {
        if (loginOrOfflineEvent.isLogin()) {
            this.A = WearUtils.y.u();
            z6();
            a6();
        } else {
            this.n.B(null);
            this.A = null;
            this.x.c(1, 0);
            ch3.n().V(null);
            z6();
        }
        HomeFragment homeFragment = this.t;
        if (homeFragment != null) {
            homeFragment.w2(loginOrOfflineEvent);
        }
        LongFragment longFragment = this.u;
        if (longFragment != null) {
            longFragment.M1(loginOrOfflineEvent);
        }
        DiscoverFragment discoverFragment = this.v;
        if (discoverFragment != null) {
            discoverFragment.U0(loginOrOfflineEvent);
        }
        MeFragment meFragment = this.w;
        if (meFragment != null) {
            meFragment.f0(loginOrOfflineEvent);
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DiscordEvent discordEvent) throws Resources.NotFoundException {
        if (discordEvent.getEventType() == DiscordEvent.TYPE_SCAN_QRCODE) {
            if (!DiscordControl.getInstance().isJoin()) {
                is3.b bVar = new is3.b(this);
                bVar.q(ah4.e(R.string.notification_join_discord_orgy_title));
                bVar.p(ah4.e(R.string.notification_join_discord_orgy_des));
                bVar.o(ah4.e(R.string.common_join));
                bVar.d(new h0(this, discordEvent));
                cs3.h(bVar).show();
            }
            this.C.setCurrentItem(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LanguageEvent languageEvent) throws Throwable {
        W5(languageEvent.getLanguage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(bx3 bx3Var) {
        this.n.j(false);
    }
}
