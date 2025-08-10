package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.NewDpgEventConfigBean;
import com.wear.bean.RateFeature;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserControlLink;
import com.wear.bean.event.AddFriendsTimeEvent;
import com.wear.bean.event.ControlLinkDownTimeEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.request.ControlLinkBaseRequest;
import com.wear.bean.socketio.controlLink.response.CloseControlEvent;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.bean.socketio.controlLink.response.EndControlReponse;
import com.wear.bean.socketio.controlLink.response.QueryUserOnlineResponse;
import com.wear.bean.socketio.controlLink.response.RefreshOccupyCountDownResponse;
import com.wear.dao.ControlLinkCommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.ext.ActivityKt;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityControlLinkTimer;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.d83;
import dc.ka2;
import dc.me3;
import dc.rn3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: ControlLinkChatControl.java */
/* loaded from: classes4.dex */
public class c83 extends e83 {
    public ControlLinkBean A;
    public UserControlLink B;
    public boolean C;
    public String D;
    public Handler G;
    public rn3 W;
    public QueryUserOnlineResponse X;
    public Disposable Y;
    public Disposable Z;
    public NewDpgEventConfigBean a0;
    public byte[] b0;
    public boolean i0;
    public ChatLiveControl r;
    public ChatSyncControl s;
    public ChatVideoControl t;
    public cv1 x;
    public String z;
    public final Object q = new Object();
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public List<ControlLinkCommunMessage> y = new ArrayList();
    public boolean E = false;
    public boolean F = false;
    public long K = 0;
    public boolean L = true;
    public int M = 0;
    public int N = 7;
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    public long R = -1;
    public boolean S = false;
    public int T = 0;
    public int U = 0;
    public int V = 0;
    public boolean c0 = false;
    public int d0 = 0;
    public boolean e0 = false;
    public String f0 = "";
    public boolean g0 = false;
    public boolean h0 = true;
    public Runnable j0 = new k();
    public boolean k0 = false;

    /* compiled from: ControlLinkChatControl.java */
    public class a implements ka2.l {
        public a() {
        }

        @Override // dc.ka2.l
        public void cancel() {
            c83.this.u = false;
            EntityLive entityLive = new EntityLive();
            entityLive.setType(EntityLive.LiveOPTType.cancel.toString());
            entityLive.setId(pj3.a());
            c83.this.u2(entityLive, MessageType.live);
            c83.this.n2(1, 4, 0);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class b implements Consumer<Long> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            c83.this.G1(this.a, ah4.e(R.string.control_link_expired), false, this.b, false, false);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class c implements Consumer<Long> {
        public final /* synthetic */ EntityControlLinkTimer a;
        public final /* synthetic */ ControlLinkCommunMessage b;
        public final /* synthetic */ String c;

        public c(EntityControlLinkTimer entityControlLinkTimer, ControlLinkCommunMessage controlLinkCommunMessage, String str) {
            this.a = entityControlLinkTimer;
            this.b = controlLinkCommunMessage;
            this.c = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            int remainTime = this.a.getRemainTime();
            if (remainTime > 0) {
                remainTime--;
                this.a.setRemainTime(remainTime);
                this.b.sendEntity(this.a);
                DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) this.b);
            } else {
                c83.this.S2(this.c);
            }
            EventBus.getDefault().post(new ControlLinkDownTimeEvent(this.b.getId(), remainTime));
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class d implements Function1<Boolean, Unit> {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            d83.w().f(bool.booleanValue(), this.a, c83.this.D);
            if (!bool.booleanValue()) {
                if (d83.w().getA() != null || c83.this.C) {
                    d83.w().S();
                }
                if (this.a.equals(d83.d.live_control.name())) {
                    ChatLiveControl.q0().o0(true, false);
                } else {
                    ChatSyncControl.N0().I0(true, false);
                }
            } else if (!this.a.equals(d83.d.live_control.name())) {
                EntitySync entitySync = new EntitySync();
                entitySync.setType(EntitySync.SyncOPTType.accept.toString());
                entitySync.setId(pj3.a());
                c83 c83Var = c83.this;
                MessageType messageType = MessageType.sync;
                c83Var.u2(entitySync, messageType);
                c83.this.b.setCurrentControlType(messageType);
                c83.this.b.setLiveStatus(2);
                c83 c83Var2 = c83.this;
                c83Var2.s.f0(c83Var2.B, false);
                cv1 cv1Var = c83.this.x;
                if (cv1Var != null) {
                    cv1Var.V2();
                }
            } else if (!d83.w().getE().booleanValue()) {
                c83 c83Var3 = c83.this;
                c83Var3.r.y0(c83Var3.Z1());
                c83 c83Var4 = c83.this;
                c83Var4.r.f1(MessageType.live, c83Var4.C);
            }
            ye3.g("control_link_recevice_permission_popup_click", "click", "control_link_recevice_permission_popup", "button", bool.booleanValue() ? "1" : "2", c83.this.D, JSON.toJSONString(WearUtils.x.G().m()));
            return null;
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class e implements Function1<Boolean, Unit> {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            if (!WearUtils.e1(this.a)) {
                if (this.a.equals(d83.d.sync_control.name())) {
                    if (d83.w().getN() != null) {
                        if (d83.w().getN().equals(EntitySync.SyncOPTType.request)) {
                            c83.this.b.setCurrentControlType(MessageType.sync);
                            c83.this.b.setLiveStatus(2);
                            c83 c83Var = c83.this;
                            c83Var.s.f0(c83Var.B, false);
                            cv1 cv1Var = c83.this.x;
                            if (cv1Var != null) {
                                cv1Var.V2();
                            }
                        } else if (d83.w().getN().equals(EntitySync.SyncOPTType.swap)) {
                            c83.this.b.setCurrentControlType(MessageType.sync);
                            if (d83.w().getQ()) {
                                c83.this.b.setLiveStatus(1);
                            } else {
                                c83.this.b.setLiveStatus(2);
                            }
                            c83 c83Var2 = c83.this;
                            c83Var2.s.f0(c83Var2.B, true);
                            cv1 cv1Var2 = c83.this.x;
                            if (cv1Var2 != null) {
                                cv1Var2.V2();
                            }
                            if (d83.w().getO().booleanValue()) {
                                ChatSyncControl.N0().p.b0(true);
                                ChatSyncControl.N0().A0(3, false);
                            }
                        } else if (d83.w().getN().equals(EntitySync.SyncOPTType.swapLDR)) {
                            c83.this.b.setCurrentControlType(MessageType.sync);
                            c83.this.b.setLiveStatus(2);
                            c83 c83Var3 = c83.this;
                            c83Var3.s.f0(c83Var3.B, false);
                            cv1 cv1Var3 = c83.this.x;
                            if (cv1Var3 != null) {
                                cv1Var3.V2();
                            }
                            ChatSyncControl.N0().p.b0(true);
                            ChatSyncControl.N0().A0(3, false);
                        } else if (d83.w().getN().equals(EntitySync.SyncOPTType.swapLDS)) {
                            c83.this.b.setCurrentControlType(MessageType.sync);
                            c83.this.b.setLiveStatus(2);
                            c83 c83Var4 = c83.this;
                            c83Var4.s.f0(c83Var4.B, false);
                            cv1 cv1Var4 = c83.this.x;
                            if (cv1Var4 != null) {
                                cv1Var4.V2();
                            }
                            ChatSyncControl.N0().p.b0(true);
                            ChatSyncControl.N0().A0(0, false);
                        }
                        d83.w().P(null);
                        d83.w().a0(false);
                    }
                } else if (!d83.w().getM()) {
                    d83.w().h(false);
                    c83.this.A1();
                }
            }
            return null;
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c83 c83Var = c83.this;
            c83Var.c0(c83Var.g, R.drawable.full_control_live, "control_link.json");
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class h implements mf2 {
        public final /* synthetic */ String a;

        /* compiled from: ControlLinkChatControl.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                cv1 cv1Var = c83.this.x;
                if (cv1Var != null) {
                    cv1Var.X();
                }
                cv1 cv1Var2 = c83.this.x;
                if (cv1Var2 != null) {
                    cv1Var2.r2();
                }
            }
        }

        /* compiled from: ControlLinkChatControl.java */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                cv1 cv1Var = c83.this.x;
                if (cv1Var != null) {
                    cv1Var.X();
                }
                ControlLinkBean controlLinkBean = (ControlLinkBean) JSON.parseObject(this.a, ControlLinkBean.class);
                h hVar = h.this;
                c83.this.x2(controlLinkBean, hVar.a, 0);
            }
        }

        public h(String str) {
            this.a = str;
        }

        @Override // dc.mf2
        public void Q(String str) {
            c83.this.U(new b(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            c83.this.U(new a());
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class i implements mf2 {

        /* compiled from: ControlLinkChatControl.java */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsControllerBanned;
                synchronized (c83.this.q) {
                    ControlLinkBean controlLinkBean = (ControlLinkBean) JSON.parseObject(this.a, ControlLinkBean.class);
                    if (controlLinkBean == null) {
                        cv1 cv1Var = c83.this.x;
                        if (cv1Var != null) {
                            cv1Var.r2();
                        }
                    } else {
                        if (c83.this.S) {
                            return;
                        }
                        c83.this.A = controlLinkBean;
                        c83 c83Var = c83.this;
                        c83Var.z = c83Var.A.getSelfId();
                        WearUtils.y.T(c83.this.z);
                        d83.w().p(controlLinkBean.getControlPermission());
                        if (c83.this.A.getLinkStatus() == 1) {
                            c83.this.F1("accident", ah4.e(R.string.notification_control_link_in_use), false, true);
                            return;
                        }
                        if (c83.this.A.getLinkStatus() == 2) {
                            String strE = ah4.e(R.string.control_link_expired);
                            if (c83.this.A.getPunishment() != null) {
                                zIsControllerBanned = c83.this.A.getPunishment().isControllerBanned();
                                if (zIsControllerBanned) {
                                    c83 c83Var2 = c83.this;
                                    strE = c83Var2.J1(c83Var2.A.getPunishment().getBanTime(), c83.this.A.getPunishment().getTimeUnit());
                                }
                            } else {
                                zIsControllerBanned = false;
                            }
                            if (zIsControllerBanned) {
                                c83.this.F1("accident", strE, zIsControllerBanned, true);
                            } else if (c83.this.A.getEndInfo() != null) {
                                if (c83.this.C && c83.this.A.getEndInfo().getEndPersonType() == 1) {
                                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                                } else if (!c83.this.C && c83.this.A.getEndInfo().getEndPersonType() == 2) {
                                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                                }
                                c83 c83Var3 = c83.this;
                                c83Var3.F1("manual", strE, zIsControllerBanned, c83Var3.k0 ? false : true);
                            }
                            return;
                        }
                        if (c83.this.z.equals(c83.this.A.getCreator().getUserId())) {
                            c83.this.C = false;
                            c83 c83Var4 = c83.this;
                            c83Var4.d = c83Var4.A.getJoiner().getUserId();
                        } else {
                            if (c83.this.A.getJoiner() == null) {
                                return;
                            }
                            if (!c83.this.z.equals(c83.this.A.getJoiner().getUserId())) {
                                return;
                            }
                            c83.this.C = true;
                            c83 c83Var5 = c83.this;
                            c83Var5.d = c83Var5.A.getCreator().getUserId();
                        }
                        c83.this.B.setId(c83.this.d);
                        if (c83.this.C) {
                            c83 c83Var6 = c83.this;
                            c83Var6.A2(Boolean.valueOf(c83Var6.A.getCreator().isNewVersion()));
                        } else {
                            c83 c83Var7 = c83.this;
                            c83Var7.A2(Boolean.valueOf(c83Var7.A.getJoiner().isNewVersion()));
                        }
                        dq2.w().F(c83.this.A.getLinkId(), c83.this.A.getX(), c83.this.A.getY());
                        if ((c83.this.P == 2 || c83.this.P % 60 == 0) && c83.this.d0 == 2) {
                            EntitySystem entitySystem = new EntitySystem();
                            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C704.toString(), ah4.e(R.string.control_link_user_disconnected));
                            c83.this.w1(entitySystem);
                        }
                        c83.this.B.updateControlLinkToy(c83.this.C, c83.this.A);
                        c83 c83Var8 = c83.this;
                        c83Var8.t2(c83Var8.A, c83.this.B);
                        c83.this.H2(c83.this.A.getLink());
                        c83 c83Var9 = c83.this;
                        cv1 cv1Var2 = c83Var9.x;
                        if (cv1Var2 != null) {
                            cv1Var2.j2(c83Var9.A, c83.this.B, c83.this.C, c83.this.z, c83.this.d, c83.this.i0, 3, true);
                        }
                    }
                }
            }
        }

        public i() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            c83.this.U(new a(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class j implements mf2 {

        /* compiled from: ControlLinkChatControl.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c83.o0(c83.this);
                c83.x0(c83.this);
                if (c83.this.O >= 2) {
                    c83.this.E1();
                }
            }
        }

        /* compiled from: ControlLinkChatControl.java */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c83.this.Q == 2) {
                    return;
                }
                c83.this.X = (QueryUserOnlineResponse) JSON.parseObject(this.a, QueryUserOnlineResponse.class);
                if (c83.this.X.getAppExStr() != null) {
                    c83 c83Var = c83.this;
                    c83Var.g0 = c83Var.X.getAppExStr().contains(User.FEATURE_IS_SUPPORT_CONTROLLINK_FRIEND_REQUEST);
                } else {
                    c83.this.g0 = false;
                }
                if (c83.this.X.getAppExStr() != null) {
                    c83 c83Var2 = c83.this;
                    c83Var2.h0 = c83Var2.X.getAppExStr().contains(User.FEATURE_IS_SUPPORT_CONTROLLINK_PERMISSION_REQUEST);
                } else {
                    c83.this.h0 = false;
                }
                if (c83.this.X.isOnLine()) {
                    if (c83.this.d0 == 2) {
                        c83.this.d0 = 1;
                    }
                    if ((c83.this.P == 2 || c83.this.P % 12 == 0) && c83.this.d0 == 1 && !c83.this.e0) {
                        EntitySystem entitySystem = new EntitySystem();
                        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C705.toString(), ah4.e(R.string.control_link_user_reconnected));
                        c83.this.w1(entitySystem);
                        c83.this.e0 = true;
                    }
                    c83.this.P = 0;
                } else {
                    c83.this.e0 = false;
                    c83.this.d0 = 2;
                    c83.o0(c83.this);
                }
                if ((c83.this.X.isOnIos() || c83.this.X.isOnAndroid()) && c83.this.X.getAppPage().equals("control_link")) {
                    if (c83.this.X.isOnLine() && (c83.this.T <= 3 || c83.this.T == 6)) {
                        c83.this.T = 5;
                        EntitySystem entitySystem2 = new EntitySystem();
                        entitySystem2.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C701.toString(), "noticeString");
                        c83.this.w1(entitySystem2);
                    }
                    c83.this.O = 0;
                    return;
                }
                if (!d83.w().I() && c83.this.C && c83.this.T == 1 && d83.w().n()) {
                    c83.this.T = 3;
                    EntitySystem entitySystem3 = new EntitySystem();
                    entitySystem3.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C700.toString(), "noticeString");
                    c83.this.w1(entitySystem3);
                }
                c83.x0(c83.this);
                if (!c83.this.X.isOnLine() || c83.this.O < 2) {
                    return;
                }
                if (c83.this.T == 5 || c83.this.T == 2) {
                    c83.this.T = 6;
                    EntitySystem entitySystem4 = new EntitySystem();
                    if (c83.this.C) {
                        entitySystem4.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C702.toString(), "noticeString");
                    } else {
                        entitySystem4.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C706.toString(), "noticeString");
                    }
                    c83.this.w1(entitySystem4);
                }
            }
        }

        public j() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            c83.this.U(new b(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            c83.this.U(new a());
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c83.this.i0) {
                if (c83.this.L) {
                    c83.L0(c83.this);
                } else {
                    c83.N0(c83.this);
                    if (c83.this.K < 0) {
                        c83.this.K = 0L;
                    }
                }
                c83 c83Var = c83.this;
                cv1 cv1Var = c83Var.x;
                if (cv1Var != null) {
                    cv1Var.E3(c83Var.K);
                }
                AddFriendsTimeEvent addFriendsTimeEvent = new AddFriendsTimeEvent();
                addFriendsTimeEvent.setTime(c83.R1().L1().getLink().getExpires() - c83.this.K);
                EventBus.getDefault().post(addFriendsTimeEvent);
            }
            c83.R0(c83.this);
            if (c83.this.M > 6) {
                c83.this.M = 0;
                c83.this.o2();
            }
            c83.U0(c83.this);
            if (c83.this.N > 6) {
                c83.this.N = 0;
                c83.this.p2();
            }
            c83 c83Var2 = c83.this;
            c83Var2.i = (int) c83Var2.Q1();
            c83.this.G.postDelayed(c83.this.j0, 1000L);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class l implements rn3.d {
        public l() {
        }

        @Override // dc.rn3.d
        public void doCancel() {
            EntityLive entityLive = new EntityLive();
            c83 c83Var = c83.this;
            entityLive.setType((c83Var.f2(c83Var.X) ? EntityLive.LiveOPTType.end : EntityLive.LiveOPTType.reject).toString());
            entityLive.setId(pj3.a());
            c83.this.u2(entityLive, MessageType.live);
        }

        @Override // dc.rn3.d
        public void doConfirm() {
            EntityLive entityLive = new EntityLive();
            entityLive.setType(EntityLive.LiveOPTType.accept.toString());
            entityLive.setId(pj3.a());
            c83 c83Var = c83.this;
            MessageType messageType = MessageType.live;
            c83Var.u2(entityLive, messageType);
            if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                rd3.f().B(false);
            }
            if (c83.this.B == null) {
                return;
            }
            c83.a2();
            c83 c83Var2 = c83.this;
            c83Var2.r.y0(c83Var2.Z1());
            c83 c83Var3 = c83.this;
            c83Var3.r.f1(messageType, c83Var3.C);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class m implements DialogInterface.OnDismissListener {
        public m(c83 c83Var) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            eq2.f().i(true);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class n implements rn3.d {
        public n() {
        }

        @Override // dc.rn3.d
        public void doCancel() {
            EntitySync entitySync = new EntitySync();
            c83 c83Var = c83.this;
            entitySync.setType((c83Var.f2(c83Var.X) ? EntitySync.SyncOPTType.end : EntitySync.SyncOPTType.reject).toString());
            entitySync.setId(pj3.a());
            c83.this.u2(entitySync, MessageType.sync);
        }

        @Override // dc.rn3.d
        public void doConfirm() {
            c83.this.B1();
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public class o implements ka2.l {
        public o() {
        }

        @Override // dc.ka2.l
        public void cancel() {
            c83.this.u = false;
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.cancel.toString());
            entitySync.setId(pj3.a());
            c83.this.u2(entitySync, MessageType.sync);
            c83.this.n2(2, 4, 0);
        }
    }

    /* compiled from: ControlLinkChatControl.java */
    public static class p {
        public static final c83 a = new c83();
    }

    public c83() {
        this.b = ch3.n().u();
        this.g = WearUtils.x;
        this.r = ChatLiveControl.q0();
        this.s = ChatSyncControl.N0();
        this.t = ChatVideoControl.a1();
        U(new g());
    }

    public static /* synthetic */ long L0(c83 c83Var) {
        long j2 = c83Var.K;
        c83Var.K = 1 + j2;
        return j2;
    }

    public static /* synthetic */ long N0(c83 c83Var) {
        long j2 = c83Var.K;
        c83Var.K = j2 - 1;
        return j2;
    }

    public static /* synthetic */ int R0(c83 c83Var) {
        int i2 = c83Var.M;
        c83Var.M = i2 + 1;
        return i2;
    }

    public static c83 R1() {
        return p.a;
    }

    public static /* synthetic */ int U0(c83 c83Var) {
        int i2 = c83Var.N;
        c83Var.N = i2 + 1;
        return i2;
    }

    public static void a2() {
        Activity activityE = ActivityKt.e();
        if (activityE instanceof ControlLinkChatActivity) {
            ((ControlLinkChatActivity) activityE).o5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k2(boolean z, String str, String str2, boolean z2, boolean z3, boolean z4) {
        synchronized (this.q) {
            if (this.S) {
                return;
            }
            h12.D.isControlLinkChat = false;
            this.E = false;
            this.S = true;
            this.U = 0;
            this.V = 0;
            if ((l22.n().j == 1 && !this.C) || (l22.n().j == 2 && this.C)) {
                yf3.i.a().s(RateFeature.ControlLink, Integer.valueOf(dc.k.a(Q1())));
            }
            if (this.r.r()) {
                n2(1, 2, WearUtils.C0(this.r.p0()));
                this.r.a();
            }
            if (this.s.r()) {
                n2(2, 2, WearUtils.C0(this.s.K0()));
                this.s.a();
            }
            G();
            this.k0 = false;
            EventBus.getDefault().unregister(this);
            Handler handler = this.G;
            if (handler != null) {
                handler.removeCallbacks(this.j0);
            }
            if (z) {
                dq2.w().q(this.D, str, Q1());
            }
            sz1.d().s(this);
            Disposable disposable = this.Y;
            if (disposable != null && !disposable.isDisposed()) {
                this.Y.dispose();
            }
            Disposable disposable2 = this.Z;
            if (disposable2 != null && !disposable2.isDisposed()) {
                this.Z.dispose();
            }
            this.g.G().u0();
            dq2.w().A(this.D);
            DaoUtils.getControlLinkCommunMessageDao().delMessages(this.D);
            C1(str2, str, z2, z3, z4);
            if (mk2.P().h0()) {
                mk2.P().n0(false);
            }
            me3.e(me3.a.OTHERS);
        }
    }

    public static /* synthetic */ int o0(c83 c83Var) {
        int i2 = c83Var.P;
        c83Var.P = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int x0(c83 c83Var) {
        int i2 = c83Var.O;
        c83Var.O = i2 + 1;
        return i2;
    }

    public void A1() {
        a2();
        this.r.y0(Z1());
        this.r.f1(MessageType.live, this.C);
        ye3.c("control link chatroom", "begin control link live control", this.d);
    }

    public void A2(Boolean bool) {
        if (bool == null) {
            this.Q = 0;
        } else {
            this.Q = bool.booleanValue() ? 1 : 2;
        }
    }

    public void B1() {
        rn3 rn3Var = this.W;
        if (rn3Var != null && rn3Var.d()) {
            this.W.c();
        }
        EntitySync entitySync = new EntitySync();
        entitySync.setType(EntitySync.SyncOPTType.accept.toString());
        entitySync.setId(pj3.a());
        MessageType messageType = MessageType.sync;
        u2(entitySync, messageType);
        this.b.setCurrentControlType(messageType);
        this.b.setLiveStatus(2);
        UserControlLink userControlLink = this.B;
        if (userControlLink == null) {
            return;
        }
        this.s.f0(userControlLink, false);
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.V2();
        }
    }

    public void B2(int i2) {
        this.T = i2;
    }

    public final void C1(String str, String str2, boolean z, boolean z2, boolean z3) {
        FragmentActivity fragmentActivityH;
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.X();
        }
        if (!this.C) {
            db2.A().T();
        }
        WearUtils.y.R(null);
        this.B = null;
        this.A = null;
        if (z || (fragmentActivityH = MyApplication.H()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT, str);
        bundle.putString("endType", str2);
        bundle.putBoolean("isBanned", z2);
        bundle.putBoolean("fromHttpDisable", z3);
        bundle.putString("linkId", this.D);
        NewDpgEventConfigBean newDpgEventConfigBean = this.a0;
        if (newDpgEventConfigBean != null) {
            bundle.putSerializable("dpgEventConfigBean", newDpgEventConfigBean);
        }
        byte[] bArr = this.b0;
        if (bArr != null) {
            bundle.putByteArray("bitmap", bArr);
        }
        this.D = null;
        pj3.g(fragmentActivityH, ControlLinkEndActivity.class, bundle);
        EventBus.getDefault().post(new fq2());
    }

    public void C2(String str) {
        this.f0 = str;
    }

    public void D1() {
        D2(0);
        E2(0);
        C2("");
        l22.n().i = "";
    }

    public void D2(int i2) {
        this.v = i2;
    }

    public void E1() {
        if (this.C) {
            return;
        }
        if (this.r.r()) {
            n2(1, 1, WearUtils.C0(this.r.p0()));
            this.r.a();
        }
        if (this.s.r()) {
            n2(2, 1, WearUtils.C0(this.s.K0()));
            this.s.a();
        }
    }

    public void E2(int i2) {
        this.w = i2;
    }

    public void F1(String str, String str2, boolean z, boolean z2) {
        G1(str, str2, false, z2, z, false);
    }

    public void F2(boolean z) {
        this.k0 = z;
    }

    public void G1(final String str, final String str2, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        U(new Runnable() { // from class: dc.b83
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k2(z2, str, str2, z, z3, z4);
            }
        });
    }

    public void G2(byte[] bArr) {
        this.b0 = bArr;
    }

    public void H1(String str, boolean z) {
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.j3();
        }
        dq2.w().q(this.D, str, Q1());
        this.Y = Observable.timer(3L, TimeUnit.SECONDS).subscribe(new b(str, z));
    }

    public void H2(ControlLinkBean.LinkBean linkBean) {
        WearUtils.y.R(this.D);
        this.i0 = linkBean.isIsStart();
        this.R = linkBean.getExpires();
        this.G.removeCallbacks(this.j0);
        if (linkBean.getExpires() <= 0) {
            this.L = true;
        } else {
            this.L = false;
        }
        long leftControlTime = linkBean.getLeftControlTime();
        this.K = leftControlTime;
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.E3(leftControlTime);
        }
        this.G.postDelayed(this.j0, 1000L);
    }

    public void I1() {
        G1("manual", ah4.e(R.string.control_link_expired), true, true, false, false);
    }

    public void I2(VelvoPreviewView velvoPreviewView) {
        this.r.X0(velvoPreviewView);
        this.s.A1(velvoPreviewView);
    }

    public final String J1(int i2, String str) {
        ah4.e(R.string.control_link_expired);
        if (!this.C) {
            return ah4.e(R.string.link_auto_end_controllee_des);
        }
        str.hashCode();
        switch (str) {
            case "day":
                ah4.e(R.string.tenporarily_ban_day);
                break;
            case "hour":
                ah4.e(R.string.tenporarily_ban_hour);
                break;
            case "week":
                ah4.e(R.string.tenporarily_ban_week);
                break;
            case "month":
                ah4.e(R.string.tenporarily_ban_month);
                break;
        }
        return ah4.e(R.string.banned_opening_link_des);
    }

    @Override // dc.cv1
    public void J2(int i2, boolean z) {
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.J2(i2, z);
        }
    }

    public int K1() {
        return this.O;
    }

    public void K2(View view, String str) {
        if (view == null || WearUtils.e1(str) || !d83.w().I() || d83.w().J()) {
            return;
        }
        d83.w().e0(view, str, new d(str));
    }

    public ControlLinkBean L1() {
        return this.A;
    }

    public void L2(boolean z) {
        if (!z) {
            this.s.D1();
            this.r.Z0();
        } else {
            e0(false);
            this.r.c0();
            this.s.c0();
            W();
        }
    }

    public void M1(String str, ControlLinkBean controlLinkBean) {
        ControlLinkBean controlLinkBean2;
        c2();
        if (!WearUtils.e1(this.D) && str.equals(this.D) && (controlLinkBean2 = this.A) != null && controlLinkBean2.getLinkId().equals(str)) {
            x2(this.A, str, 2);
            return;
        }
        if (controlLinkBean != null) {
            x2(controlLinkBean, str, 1);
            return;
        }
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.j3();
        }
        dq2.w().s(str, new h(str));
    }

    public final void M2(String str) {
        d83.w().a0(false);
        d83.w().d0(eq2.f().e(), ah4.e(R.string.control_link_permission_unavailable_hint), false, new e(str));
    }

    public void N2() {
        this.r.c1();
        this.s.H1();
        this.t.S1();
    }

    public boolean O1() {
        return this.s.r() || this.r.r();
    }

    public void O2(String str, MessageType messageType) {
        if (d83.w().D().e()) {
            return;
        }
        this.u = true;
        if (messageType == MessageType.sync) {
            this.s.L(Z1());
            this.s.J1(str, new o());
        } else {
            this.r.y0(Z1());
            this.r.g1(str, new a());
        }
        try {
            MusicControl.h0().S();
            y12.c.a().t();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean P1() {
        return this.S;
    }

    public void P2(UserControlLink userControlLink, boolean z, View view) {
        this.r.y0(userControlLink);
        this.r.f1(MessageType.live, z);
    }

    public long Q1() {
        if (this.L) {
            return this.K;
        }
        long j2 = this.K;
        return j2 <= 0 ? this.R : this.R - j2;
    }

    public void Q2(UserControlLink userControlLink, boolean z, View view) {
        this.s.L(userControlLink);
        this.s.I1(MessageType.sync);
    }

    public void R2(String str) {
        ControlLinkCommunMessage controlLinkCommunMessageFindById = DaoUtils.getControlLinkCommunMessageDao().findById(str);
        if (controlLinkCommunMessageFindById == null || controlLinkCommunMessageFindById.getMsgType() != MessageType.controllinktimer) {
            return;
        }
        Disposable disposable = this.Z;
        if (disposable == null || disposable.isDisposed()) {
            EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) controlLinkCommunMessageFindById.syncDecryptBean();
            if (entityControlLinkTimer.getRemainTime() <= 0 || entityControlLinkTimer.isCancel()) {
                return;
            }
            this.Z = Observable.interval(1L, 1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(entityControlLinkTimer, controlLinkCommunMessageFindById, str));
        }
    }

    public String S1() {
        return this.D;
    }

    public void S2(String str) {
        Disposable disposable = this.Z;
        if (disposable != null && !disposable.isDisposed()) {
            this.Z.dispose();
        }
        ControlLinkCommunMessage controlLinkCommunMessageFindById = DaoUtils.getControlLinkCommunMessageDao().findById(str);
        if (controlLinkCommunMessageFindById != null) {
            EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) controlLinkCommunMessageFindById.syncDecryptBean();
            entityControlLinkTimer.setCancel(true);
            controlLinkCommunMessageFindById.sendEntity(entityControlLinkTimer);
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) controlLinkCommunMessageFindById);
        }
    }

    public List<ControlLinkCommunMessage> T1() {
        return this.y;
    }

    public void T2(boolean z) {
        try {
            if (this.S) {
                return;
            }
            ControlLinkCommunMessage controlLinkCommunMessageFindLastControlMessage = DaoUtils.getControlLinkCommunMessageDao().findLastControlMessage(this.D);
            if (controlLinkCommunMessageFindLastControlMessage != null) {
                d83.w().U(false);
                controlLinkCommunMessageFindLastControlMessage.syncDecryptBean();
                this.B.setFeature(controlLinkCommunMessageFindLastControlMessage.getFeature());
                MessageType msgType = controlLinkCommunMessageFindLastControlMessage.getMsgType();
                MessageType messageType = MessageType.live;
                if (msgType == messageType) {
                    d83 d83VarW = d83.w();
                    d83.d dVar = d83.d.live_control;
                    d83VarW.V(dVar);
                    if (this.s.r()) {
                        this.s.I0(false, false);
                    }
                    EntityLive entityLive = (EntityLive) controlLinkCommunMessageFindLastControlMessage.syncDecryptBean();
                    if (entityLive.getLiveOPTType() == EntityLive.LiveOPTType.accept) {
                        if (!this.r.r() && !na2.m().l()) {
                            this.r.y0(Z1());
                            this.r.f1(messageType, this.C);
                            me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_MIRROR_BEGIN, me3.a());
                        }
                    } else if (entityLive.getLiveOPTType() == EntityLive.LiveOPTType.request) {
                        if (!this.r.r() && !na2.m().l()) {
                            if (this.C) {
                                xz1.a();
                                String strE = ah4.e(R.string.dialog_receiveRequest_live);
                                String showNickName = this.B.getShowNickName();
                                ye3.c(null, "get control link live control", this.d);
                                d83.w().F();
                                if (d83.w().F().f()) {
                                    return;
                                }
                                rn3 rn3Var = new rn3(MyApplication.H(), strE, showNickName, "", new l(), messageType, this.z);
                                this.W = rn3Var;
                                rn3Var.e(new m(this));
                                eq2.f().i(false);
                            } else {
                                d83.w().h(false);
                                if (!d83.w().I() || d83.w().l()) {
                                    A1();
                                    ye3.c("control link chatroom", "begin control link live control", this.d);
                                } else if (this.B.isSupportControlLinkPermissionRequest() || this.h0) {
                                    if (eq2.f().e() != null) {
                                        Dialog dialog = this.r.v;
                                        if (dialog != null && dialog.isShowing()) {
                                            d83.w().M();
                                            d83.w().f(true, dVar.name(), this.D);
                                            A1();
                                        } else if (d83.w().i()) {
                                            K2(eq2.f().e().findViewById(R.id.actionbar), dVar.name());
                                        }
                                    }
                                } else {
                                    if (eq2.f().e() == null) {
                                        d83.w().Y(true, dVar.name());
                                        return;
                                    }
                                    M2(dVar.name());
                                }
                            }
                        }
                    } else if (entityLive.getLiveOPTType() == EntityLive.LiveOPTType.end) {
                        d83.w().h(true);
                        if (this.r.r()) {
                            this.r.o0(false, false);
                            ye3.c(null, "ended control link live control", this.d);
                        }
                    } else if (entityLive.getLiveOPTType() == EntityLive.LiveOPTType.cancel) {
                        if (this.r.r()) {
                            this.r.o0(false, false);
                        } else {
                            rn3 rn3Var2 = this.W;
                            if (rn3Var2 != null && rn3Var2.d()) {
                                this.W.c();
                            }
                        }
                    } else if (entityLive.getLiveOPTType() == EntityLive.LiveOPTType.reject) {
                        this.r.T0(messageType);
                        n2(1, 5, 0);
                    }
                } else {
                    MessageType msgType2 = controlLinkCommunMessageFindLastControlMessage.getMsgType();
                    MessageType messageType2 = MessageType.sync;
                    if (msgType2 == messageType2) {
                        d83 d83VarW2 = d83.w();
                        d83.d dVar2 = d83.d.sync_control;
                        d83VarW2.V(dVar2);
                        if (this.r.r()) {
                            this.r.o0(false, false);
                        }
                        boolean z2 = LDRControl.p;
                        boolean zIsSupportSolaceTapButtonControl = this.B.isSupportSolaceTapButtonControl();
                        LDRControl.p = zIsSupportSolaceTapButtonControl;
                        if (z2 != zIsSupportSolaceTapButtonControl) {
                            this.s.C0();
                            this.s.p.K();
                        }
                        EntitySync entitySync = (EntitySync) controlLinkCommunMessageFindLastControlMessage.syncDecryptBean();
                        EntitySync.SyncOPTType syncOPTType = entitySync.getSyncOPTType();
                        EntitySync.SyncOPTType syncOPTType2 = EntitySync.SyncOPTType.accept;
                        if (syncOPTType != syncOPTType2) {
                            EntitySync.SyncOPTType syncOPTType3 = entitySync.getSyncOPTType();
                            EntitySync.SyncOPTType syncOPTType4 = EntitySync.SyncOPTType.request;
                            if (syncOPTType3 != syncOPTType4) {
                                EntitySync.SyncOPTType syncOPTType5 = entitySync.getSyncOPTType();
                                EntitySync.SyncOPTType syncOPTType6 = EntitySync.SyncOPTType.end;
                                if (syncOPTType5 == syncOPTType6) {
                                    d83.w().P(syncOPTType6);
                                    ChatSyncControl.N0().m1();
                                    if (ChatSyncControl.N0().r()) {
                                        this.s.I0(false, false);
                                        ye3.c(null, "ended control link sync control", this.d);
                                    }
                                } else {
                                    EntitySync.SyncOPTType syncOPTType7 = entitySync.getSyncOPTType();
                                    EntitySync.SyncOPTType syncOPTType8 = EntitySync.SyncOPTType.reject;
                                    if (syncOPTType7 == syncOPTType8) {
                                        d83.w().P(syncOPTType8);
                                        this.s.k1(messageType2);
                                        n2(2, 5, 0);
                                    } else {
                                        EntitySync.SyncOPTType syncOPTType9 = entitySync.getSyncOPTType();
                                        EntitySync.SyncOPTType syncOPTType10 = EntitySync.SyncOPTType.swapLDR;
                                        if (syncOPTType9 == syncOPTType10 || entitySync.getSyncOPTType() == EntitySync.SyncOPTType.swapLDS) {
                                            if (entitySync.getSyncOPTType() == syncOPTType10) {
                                                d83.w().o(true);
                                                d83.w().P(syncOPTType10);
                                            } else {
                                                d83.w().o(false);
                                                d83.w().P(EntitySync.SyncOPTType.swapLDS);
                                            }
                                            if (ChatSyncControl.N0().r() && !z) {
                                                if (entitySync.getSyncOPTType() == syncOPTType10) {
                                                    ChatSyncControl.N0().p.b0(true);
                                                    ChatSyncControl.N0().A0(3, false);
                                                } else if (entitySync.getSyncOPTType() == EntitySync.SyncOPTType.swapLDS) {
                                                    ChatSyncControl.N0().A0(0, false);
                                                }
                                            }
                                        } else if (entitySync.getSyncOPTType() != EntitySync.SyncOPTType.swapLDRActiveToy) {
                                            EntitySync.SyncOPTType syncOPTType11 = entitySync.getSyncOPTType();
                                            EntitySync.SyncOPTType syncOPTType12 = EntitySync.SyncOPTType.swap;
                                            if (syncOPTType11 == syncOPTType12) {
                                                d83.w().P(syncOPTType12);
                                                if (!z) {
                                                    d83.w().X();
                                                    ChatSyncControl.N0().O1(-1, false);
                                                    if (d83.w().getO().booleanValue() && d83.w().getH() != null && d83.w().getH().isShowing()) {
                                                        ChatSyncControl.N0().u1();
                                                    }
                                                }
                                            } else {
                                                EntitySync.SyncOPTType syncOPTType13 = entitySync.getSyncOPTType();
                                                EntitySync.SyncOPTType syncOPTType14 = EntitySync.SyncOPTType.cancel;
                                                if (syncOPTType13 == syncOPTType14) {
                                                    d83.w().P(syncOPTType14);
                                                    if (ChatSyncControl.N0().r()) {
                                                        this.s.I0(false, false);
                                                    } else {
                                                        rn3 rn3Var3 = this.W;
                                                        if (rn3Var3 != null && rn3Var3.d()) {
                                                            this.W.c();
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (ChatSyncControl.N0().r()) {
                                            ChatSyncControl.N0().p.g0(false, entitySync.getData());
                                        }
                                    }
                                }
                            } else if (!this.s.r() && !na2.m().l()) {
                                d83.w().P(syncOPTType4);
                                ChatSyncControl.N0().m1();
                                if (this.C) {
                                    xz1.a();
                                    ye3.c(null, "get control link sync control", this.d);
                                    this.W = new rn3(MyApplication.H(), ah4.e(R.string.dialog_receiveRequest_sync), this.B.getShowNickName(), "", new n(), messageType2, this.z);
                                } else {
                                    d83.w().h(false);
                                    if (!d83.w().I() || d83.w().m()) {
                                        Dialog dialog2 = this.s.t;
                                        if (dialog2 != null && dialog2.isShowing()) {
                                            this.s.t.dismiss();
                                        }
                                        EntitySync entitySync2 = new EntitySync();
                                        entitySync2.setType(syncOPTType2.toString());
                                        entitySync2.setId(pj3.a());
                                        u2(entitySync2, messageType2);
                                        this.b.setCurrentControlType(messageType2);
                                        this.b.setLiveStatus(2);
                                        this.s.f0(this.B, false);
                                        cv1 cv1Var = this.x;
                                        if (cv1Var != null) {
                                            cv1Var.V2();
                                        }
                                    } else if (this.B.isSupportControlLinkPermissionRequest() || this.h0) {
                                        if (eq2.f().e() != null) {
                                            Dialog dialog3 = this.s.t;
                                            if (dialog3 != null && dialog3.isShowing()) {
                                                d83.w().M();
                                                d83.w().f(true, dVar2.name(), this.D);
                                                Dialog dialog4 = this.s.t;
                                                if (dialog4 != null && dialog4.isShowing()) {
                                                    this.s.t.dismiss();
                                                }
                                                this.s.L(this.B);
                                                this.s.I1(messageType2);
                                            } else if (d83.w().k()) {
                                                K2(eq2.f().e().findViewById(R.id.actionbar), dVar2.name());
                                            }
                                        }
                                    } else {
                                        if (eq2.f().e() == null) {
                                            d83.w().Y(true, dVar2.name());
                                            return;
                                        }
                                        M2(dVar2.name());
                                    }
                                }
                            }
                        } else if (!this.s.r() && !na2.m().l()) {
                            this.s.L(Z1());
                            this.s.I1(messageType2);
                            HashMap map = new HashMap();
                            map.put(TtmlNode.ATTR_ID, this.D);
                            ye3.d("F0025", WearUtils.A.toJson(map));
                            WearUtils.x.q("control_link_control_with_sync_control", null);
                            me3.d(me3.c.CONTROL_LINK_SYNC_CONTROL_SENCE_BEGIN, me3.a());
                        }
                    }
                }
            } else {
                d83.w().U(true);
                if (d83.w().I() && !d83.w().l() && eq2.f().e() != null && d83.w().i()) {
                    K2(eq2.f().e().findViewById(R.id.actionbar), d83.d.live_control.name());
                }
            }
            d83.w().Q();
            if (d83.w().getR()) {
                K2(eq2.f().e().findViewById(R.id.actionbar), WearUtils.e1(d83.w().getS()) ? d83.d.live_control.name() : d83.w().getS());
                d83.w().Z("", false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public int U1() {
        return this.Q;
    }

    public String V1() {
        return this.f0;
    }

    public int W1() {
        return this.v;
    }

    public int X1() {
        return this.w;
    }

    public byte[] Y1() {
        return this.b0;
    }

    public UserControlLink Z1() {
        if (this.B == null) {
            UserControlLink userControlLink = new UserControlLink();
            this.B = userControlLink;
            userControlLink.setId(this.d);
            if (this.C) {
                this.B.setName(ah4.e(R.string.control_link_controllee));
                A2(Boolean.valueOf(this.A.getCreator().isNewVersion()));
            } else {
                this.B.setName(ah4.e(R.string.group_chat_controller));
                A2(Boolean.valueOf(this.A.getJoiner().isNewVersion()));
            }
            this.B.addFriendType(64);
            this.B.updateControlLinkToy(this.C, this.A);
            this.B.setLinkId(this.A.getLinkId());
        }
        return this.B;
    }

    @Override // dc.ra2
    public void a() {
        F1("manual", ah4.e(R.string.control_link_expired), false, true);
    }

    @Override // dc.cv1, dc.jv1
    public void addViewToActivity(View view) {
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.addViewToActivity(view);
        }
    }

    public void b2() {
        this.r.v0();
        this.s.R0();
        this.t.c1();
    }

    public void c2() {
        this.E = true;
        this.S = false;
        h12.D.isControlLinkChat = true;
        e0(true);
        if (this.G == null) {
            this.G = new Handler(Looper.getMainLooper());
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.s.w(this);
        this.r.w(this);
        sz1.d().n(this);
        this.c0 = false;
    }

    public boolean d2() {
        return this.c0;
    }

    public boolean e2() {
        String str = " 是否是加入者：isJoiner=" + this.C;
        return this.C;
    }

    public boolean f2(QueryUserOnlineResponse queryUserOnlineResponse) {
        if (queryUserOnlineResponse == null) {
            return false;
        }
        String appVersion = queryUserOnlineResponse.getAppVersion();
        String str = null;
        if (queryUserOnlineResponse.isOnAndroid()) {
            str = "5.2.1";
        } else if (queryUserOnlineResponse.isOnIos()) {
            str = "5.2.5";
        }
        return WearUtils.k(appVersion, str) == -1;
    }

    public boolean g2() {
        return this.g0;
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // dc.cv1, dc.jv1
    public void l(IPeopleInfo iPeopleInfo) {
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.l(iPeopleInfo);
        }
    }

    public void m2(IPeopleInfo iPeopleInfo) {
        this.r.O0(iPeopleInfo);
        this.s.e1(iPeopleInfo);
    }

    public void n2(int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.ATTR_ID, (Object) this.D);
        JSONArray jSONArray = new JSONArray();
        UserControlLink userControlLink = this.B;
        if (userControlLink != null && userControlLink.getCLLinkedToys2() != null) {
            Iterator<Toy> it = this.B.getCLLinkedToys2().iterator();
            while (it.hasNext()) {
                jSONArray.add(it.next().getDeviceId());
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        if (this.C) {
            ArrayList<Toy> arrayListP = pc1.a.P();
            if (arrayListP != null) {
                Iterator<Toy> it2 = arrayListP.iterator();
                while (it2.hasNext()) {
                    jSONArray2.add(it2.next().getDeviceId());
                }
            }
        } else {
            ArrayList<Toy> controlLinkToys = this.b.getControlLinkToys();
            if (controlLinkToys != null) {
                Iterator<Toy> it3 = controlLinkToys.iterator();
                while (it3.hasNext()) {
                    jSONArray2.add(it3.next().getDeviceId());
                }
            }
        }
        jSONObject.put("oppo_toy_mac", (Object) jSONArray);
        jSONObject.put("toy_mac", (Object) jSONArray2);
        jSONObject.put("control_type", (Object) Integer.valueOf(i2));
        jSONObject.put("control_end_type", (Object) Integer.valueOf(i3));
        jSONObject.put("control_duration", (Object) Integer.valueOf(i4));
        ye3.d("F0027", jSONObject.toString());
    }

    public void o2() {
        dq2.w().s(this.D, new i());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ControlLinkBaseRequest controlLinkBaseRequest) {
        if (controlLinkBaseRequest.getLinkId().equals(this.D)) {
            o2();
        }
    }

    public final void p2() {
        dq2.w().t(this.D, this.d, new j(), 5L);
    }

    public void q2() {
        EntityLive entityLive = new EntityLive();
        entityLive.setType(EntityLive.LiveOPTType.request.toString());
        entityLive.setId(pj3.a());
        u2(entityLive, MessageType.live);
    }

    @Override // dc.ra2
    public boolean r() {
        return this.E;
    }

    public void s2() {
        EntitySync entitySync = new EntitySync();
        entitySync.setType(EntitySync.SyncOPTType.request.toString());
        entitySync.setId(pj3.a());
        u2(entitySync, MessageType.sync);
    }

    @Override // dc.tz1
    public void stop(int i2) {
        a();
    }

    public void t2(ControlLinkBean controlLinkBean, UserControlLink userControlLink) throws Resources.NotFoundException {
        this.A = controlLinkBean;
        if (this.r.r()) {
            this.r.S();
        }
    }

    public final void u2(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        if (!hf3.d(this.g)) {
            sg3.i(this.g, R.string.common_settingTip);
            return;
        }
        if (!MyApplication.P) {
            sg3.i(this.g, R.string.common_timeout_error);
            return;
        }
        if (this.A == null) {
            return;
        }
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setFromId(this.z);
        controlLinkCommunMessage.setToId(this.d);
        controlLinkCommunMessage.sendEntity(dataEntityAbstract, this.A.getX(), this.A.getY());
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setSendStatus(2);
        controlLinkCommunMessage.setCreateTime(be3.r());
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(this.D);
        x1(controlLinkCommunMessage, true);
        dq2.w().D(controlLinkCommunMessage, this.D);
    }

    public void v1(cv1 cv1Var) {
        this.x = cv1Var;
    }

    public void v2(boolean z) {
    }

    public void w1(DataEntityAbstract dataEntityAbstract) {
        ControlLinkBean controlLinkBean = this.A;
        if (controlLinkBean == null || WearUtils.e1(controlLinkBean.getX()) || WearUtils.e1(this.A.getY())) {
            return;
        }
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setFromId(this.z);
        controlLinkCommunMessage.setToId(this.d);
        controlLinkCommunMessage.sendEntity(dataEntityAbstract, this.A.getX(), this.A.getY());
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setSendStatus(2);
        controlLinkCommunMessage.setCreateTime(be3.r());
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(this.D);
        x1(controlLinkCommunMessage, true);
        if (dq2.w().y(controlLinkCommunMessage)) {
            T1().add(controlLinkCommunMessage);
            cv1 cv1Var = this.x;
            if (cv1Var != null) {
                cv1Var.h2();
            }
        }
    }

    public void w2(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
    }

    public final void x1(ControlLinkCommunMessage controlLinkCommunMessage, boolean z) {
        if (dq2.w().x(controlLinkCommunMessage)) {
            if (z) {
                controlLinkCommunMessage.setFromId(this.z);
                controlLinkCommunMessage.setToId(this.d);
            }
            DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
        }
    }

    public final void x2(ControlLinkBean controlLinkBean, String str, int i2) {
        cv1 cv1Var;
        boolean zIsControllerBanned = false;
        if (controlLinkBean == null) {
            F1("accident", ah4.e(R.string.control_link_expired), false, true);
            return;
        }
        this.D = str;
        this.A = controlLinkBean;
        String selfId = controlLinkBean.getSelfId();
        this.z = selfId;
        WearUtils.y.T(selfId);
        ControlLinkBean.LinkBean link = this.A.getLink();
        if (link != null) {
            H2(link);
        }
        d83.w().p(controlLinkBean.getControlPermission());
        if (this.A.getLinkStatus() == 1) {
            F1("accident", ah4.e(R.string.notification_control_link_in_use), false, true);
            return;
        }
        if (this.A.getLinkStatus() == 2) {
            String strE = ah4.e(R.string.control_link_expired);
            if (this.A.getPunishment() != null && (zIsControllerBanned = this.A.getPunishment().isControllerBanned())) {
                strE = J1(this.A.getPunishment().getBanTime(), this.A.getPunishment().getTimeUnit());
            }
            if (!zIsControllerBanned && this.A.getEndInfo() != null) {
                if (this.C && this.A.getEndInfo().getEndPersonType() == 1) {
                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                } else if (!this.C && this.A.getEndInfo().getEndPersonType() == 2) {
                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                }
            }
            F1("accident", strE, zIsControllerBanned, true);
            return;
        }
        if (this.z.equals(this.A.getCreator().getUserId())) {
            this.C = false;
            if (this.A.getJoiner() == null) {
                cv1 cv1Var2 = this.x;
                if (cv1Var2 != null) {
                    cv1Var2.r2();
                    return;
                }
                return;
            }
            this.d = this.A.getJoiner().getUserId();
        } else {
            if (this.A.getJoiner() == null) {
                cv1 cv1Var3 = this.x;
                if (cv1Var3 != null) {
                    cv1Var3.r2();
                    return;
                }
                return;
            }
            if (!this.z.equals(this.A.getJoiner().getUserId())) {
                cv1 cv1Var4 = this.x;
                if (cv1Var4 != null) {
                    cv1Var4.r2();
                    return;
                }
                return;
            }
            this.C = true;
            this.d = this.A.getCreator().getUserId();
        }
        dq2.w().F(this.A.getLinkId(), this.A.getX(), this.A.getY());
        if (this.B == null) {
            this.B = new UserControlLink();
        }
        this.B.setId(this.d);
        if (this.C) {
            this.B.setName(ah4.e(R.string.control_link_controllee));
            A2(Boolean.valueOf(this.A.getCreator().isNewVersion()));
        } else {
            this.B.setName(ah4.e(R.string.group_chat_controller));
            A2(Boolean.valueOf(this.A.getJoiner().isNewVersion()));
        }
        this.B.addFriendType(64);
        this.B.updateControlLinkToy(this.C, this.A);
        this.B.setLinkId(this.A.getLinkId());
        L(this.B);
        this.b.setControlLinkJoiner(this.C);
        if (!this.C) {
            ch3.n().Z(this.A);
        }
        cv1 cv1Var5 = this.x;
        if (cv1Var5 != null) {
            cv1Var5.j2(this.A, this.B, this.C, this.z, this.d, this.i0, i2, false);
        }
        if (!this.C) {
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, str);
            ye3.d("F0022", WearUtils.A.toJson(map));
            WearUtils.x.q("control_link_controllee_enter_remote", null);
        }
        if (i2 == 2 && (cv1Var = this.x) != null) {
            cv1Var.V2();
        }
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
        if (i2 == 0) {
            me3.e(me3.a.CONTROL_LINK_CHAT_LIVE_CONTROL);
            me3.d(me3.c.CONTROL_LINK_LIVE_CONTROL_BEGIN, me3.a());
            ye3.c("control link chatroom", "begin control link live control", this.d);
        }
    }

    @Override // dc.cv1, dc.jv1
    public void y(IPeopleInfo iPeopleInfo) {
        cv1 cv1Var = this.x;
        if (cv1Var != null) {
            cv1Var.y(iPeopleInfo);
        }
    }

    public void y1(int i2) {
        int i3;
        if (this.C || (i3 = this.V) == 6 || (i3 & i2) == i2) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, this.D);
        map.put("type", 1);
        map.put("chat_type", Integer.valueOf(i2 != 2 ? 2 : 1));
        ye3.d("F0026", WearUtils.A.toJson(map));
        this.V = i2 | this.V;
    }

    public void y2(boolean z) {
        this.c0 = z;
    }

    @Override // dc.ka2
    public boolean z() {
        return r();
    }

    public void z1() {
        if (this.F) {
            J2(0, false);
            this.F = false;
        }
    }

    public void z2(NewDpgEventConfigBean newDpgEventConfigBean) {
        this.a0 = newDpgEventConfigBean;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(jq2 jq2Var) {
        boolean z;
        cv1 cv1Var;
        ControlLinkCommunMessage controlLinkCommunMessage;
        if (jq2Var.a() != null) {
            String msgId = (T1().size() <= 0 || (controlLinkCommunMessage = T1().get(T1().size() - 1)) == null) ? "" : controlLinkCommunMessage.getMsgId();
            boolean z2 = false;
            loop0: while (true) {
                z = false;
                for (ControlLinkCommunMessage controlLinkCommunMessage2 : jq2Var.a()) {
                    if (TextUtils.equals(controlLinkCommunMessage2.getDateImTypeData(), this.D)) {
                        if (dq2.w().y(controlLinkCommunMessage2)) {
                            if (WearUtils.e1(msgId) || !msgId.equals(controlLinkCommunMessage2.getMsgId())) {
                                if (controlLinkCommunMessage2.getMsgType() == MessageType.controllink) {
                                    T1().add(0, controlLinkCommunMessage2);
                                } else {
                                    T1().add(controlLinkCommunMessage2);
                                }
                                z2 = true;
                            }
                        }
                        controlLinkCommunMessage2.syncDecryptBean();
                        if (controlLinkCommunMessage2.getMsgType() == MessageType.live || controlLinkCommunMessage2.getMsgType() == MessageType.sync) {
                            z = true;
                        }
                    }
                }
            }
            if (!this.C && this.U != 6) {
                for (int i2 = 0; i2 < T1().size(); i2++) {
                    ControlLinkCommunMessage controlLinkCommunMessage3 = T1().get(i2);
                    if (controlLinkCommunMessage3 != null && !controlLinkCommunMessage3.getFromId().equals(this.z) && controlLinkCommunMessage3.getMsgType() != MessageType.controllink) {
                        int i3 = f.a[controlLinkCommunMessage3.getMsgType().ordinal()];
                        int i4 = i3 != 1 ? i3 != 2 ? 0 : 4 : 2;
                        if ((this.U & i4) != i4) {
                            HashMap map = new HashMap();
                            map.put(TtmlNode.ATTR_ID, this.D);
                            map.put("type", 2);
                            map.put("chat_type", Integer.valueOf(i4 == 2 ? 1 : 2));
                            ye3.d("F0026", WearUtils.A.toJson(map));
                            this.U = i4 | this.U;
                        }
                    }
                }
            }
            if (z) {
                T2(false);
            }
            if (!z2 || (cv1Var = this.x) == null) {
                return;
            }
            cv1Var.h2();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndControlReponse endControlReponse) {
        if (endControlReponse.getLinkId().equals(this.D)) {
            synchronized (this.q) {
                String strE = ah4.e(R.string.control_link_expired);
                if (endControlReponse.isControllerBanned()) {
                    strE = J1(endControlReponse.getBanTime(), endControlReponse.getTimeUnit());
                } else if (this.C && endControlReponse.getEndPersonType() == 1) {
                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                } else if (!this.C && endControlReponse.getEndPersonType() == 2) {
                    strE = ah4.e(R.string.session_ended_notification) + ah4.e(R.string.control_link_expired);
                }
                G1(endControlReponse.getEndType(), strE, false, false, endControlReponse.isControllerBanned(), endControlReponse.isFromHttpDisable());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CloseControlEvent closeControlEvent) {
        if (closeControlEvent.getLinkId().equals(this.D)) {
            synchronized (this.q) {
                if (this.S) {
                    return;
                }
                EventBus.getDefault().unregister(this);
                this.G.removeCallbacks(this.j0);
                this.S = true;
                cv1 cv1Var = this.x;
                if (cv1Var != null) {
                    cv1Var.r2();
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RefreshOccupyCountDownResponse refreshOccupyCountDownResponse) {
        if (refreshOccupyCountDownResponse.getLinkId().equals(this.D)) {
            J2(refreshOccupyCountDownResponse.getRemainTime(), refreshOccupyCountDownResponse.isReachMaxAbnormalCount());
            this.F = refreshOccupyCountDownResponse.getRemainTime() > 0;
        }
    }
}
