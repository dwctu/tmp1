package dc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ControlIdBean;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.MatchResult;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.event.EndChatEvent;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.SensitiveWordDao;
import com.wear.dao.UserSettingDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.localMusic.PlaylistDetailsActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.ContainBean;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityControl;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.HandleListener;
import com.wear.protocol.MessageType;
import com.wear.ui.discover.speedMode.SpeedModeActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.HtmlVideoActivity;
import dc.kn3;
import dc.rn3;
import java.util.Date;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SmackChatMessageListener.java */
/* loaded from: classes4.dex */
public class gu3 implements ChatMessageListener {
    public static ControlIdBean j = new ControlIdBean();
    public static eu3 k;
    public String b;
    public rn3 a = null;
    public PowerManager.WakeLock d = null;
    public Handler e = new Handler(Looper.getMainLooper());
    public Handler f = new Handler(Looper.getMainLooper());
    public Handler g = new Handler(Looper.getMainLooper());
    public ie3 h = new ie3();
    public kn3 i = null;
    public MyApplication c = WearUtils.x;

    /* compiled from: SmackChatMessageListener.java */
    public class a implements kn3.d {
        public final /* synthetic */ MessageType a;
        public final /* synthetic */ String b;
        public final /* synthetic */ HandleListener c;

        public a(MessageType messageType, String str, HandleListener handleListener) {
            this.a = messageType;
            this.b = str;
            this.c = handleListener;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            this.c.rejectAction(this.b, null);
            gu3.this.g();
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            db2.A().w(false);
            MessageType messageType = this.a;
            if (messageType == MessageType.video || messageType == MessageType.voice) {
                WearUtils.z2();
            }
            if (ChatSyncControl.N0().r()) {
                ChatSyncControl.N0().a();
            }
            gu3.this.s(this.b, this.a);
            gu3.this.g();
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.live.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.sync.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.voice.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.toy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.partnertoy.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MessageType.alexa.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[MessageType.system.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[MessageType.alarm.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class c implements Runnable {
        public final /* synthetic */ MessageType a;
        public final /* synthetic */ User b;

        public c(gu3 gu3Var, MessageType messageType, User user) {
            this.a = messageType;
            this.b = user;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.a1().d0(this.a, this.b);
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class d implements Runnable {
        public final /* synthetic */ MessageType a;

        public d(gu3 gu3Var, MessageType messageType) {
            this.a = messageType;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == MessageType.live) {
                ChatLiveControl.q0().l0();
            } else {
                MessageType messageType = MessageType.sync;
            }
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class e implements Runnable {
        public e(gu3 gu3Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(new KeepScreenSetting(true));
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class f implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ MessageType b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Activity e;

        /* compiled from: SmackChatMessageListener.java */
        public class a implements rn3.d {
            public a() {
            }

            @Override // dc.rn3.d
            public void doCancel() {
                sz1.d().s(gu3.this.a);
                MessageType messageType = f.this.b;
                if (messageType == MessageType.live) {
                    EntityLive entityLive = new EntityLive();
                    EntityLive.LiveOPTType liveOPTType = EntityLive.LiveOPTType.reject;
                    entityLive.setType(liveOPTType.toString());
                    entityLive.setId(gu3.j.getControlId());
                    f fVar = f.this;
                    hu3.h0(entityLive, fVar.c, fVar.b, liveOPTType.toString(), null, null);
                    ChatLiveControl.q0().R0(false, true, f.this.c);
                } else if (messageType == MessageType.sync) {
                    EntitySync entitySync = new EntitySync();
                    EntitySync.SyncOPTType syncOPTType = EntitySync.SyncOPTType.reject;
                    entitySync.setType(syncOPTType.toString());
                    entitySync.setId(gu3.j.getControlId());
                    f fVar2 = f.this;
                    hu3.h0(entitySync, fVar2.c, fVar2.b, syncOPTType.toString(), null, null);
                    ChatSyncControl.N0().h1(false, true, f.this.c);
                } else if (messageType == MessageType.video) {
                    WearUtils.z2();
                    EntityVideo entityVideo = new EntityVideo();
                    EntityVideo.VideoOPTType videoOPTType = EntityVideo.VideoOPTType.reject;
                    entityVideo.setType(videoOPTType.toString());
                    entityVideo.setId(gu3.j.getControlId());
                    f fVar3 = f.this;
                    hu3.h0(entityVideo, fVar3.c, fVar3.b, videoOPTType.toString(), null, null);
                    ChatVideoControl.a1().D1(false, true, true, f.this.c);
                } else if (messageType == MessageType.voice) {
                    WearUtils.z2();
                    EntityVoice entityVoice = new EntityVoice();
                    EntityVoice.VoiceOPTType voiceOPTType = EntityVoice.VoiceOPTType.reject;
                    entityVoice.setType(voiceOPTType.toString());
                    entityVoice.setId(gu3.j.getControlId());
                    f fVar4 = f.this;
                    hu3.h0(entityVoice, fVar4.c, fVar4.b, voiceOPTType.toString(), null, null);
                    ChatVideoControl.a1().D1(false, true, false, f.this.c);
                }
                gu3.this.c.k0(f.this.d);
                gu3.j.setAvailable(ControlIdBean.Status.cancel);
            }

            @Override // dc.rn3.d
            public void doConfirm() {
                sz1.d().s(gu3.this.a);
                MessageType messageType = f.this.b;
                if (messageType == MessageType.video || messageType == MessageType.voice) {
                    WearUtils.z2();
                }
                if (ChatSyncControl.N0().r()) {
                    ChatSyncControl.N0().a();
                }
                rd3.f().B(false);
                f fVar = f.this;
                gu3.this.s(fVar.c, fVar.b);
                gu3.this.c.k0(f.this.d);
            }
        }

        public f(String str, MessageType messageType, String str2, String str3, Activity activity) {
            this.a = str;
            this.b = messageType;
            this.c = str2;
            this.d = str3;
            this.e = activity;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r12 = this;
                dc.gu3 r0 = dc.gu3.this
                com.wear.util.MyApplication r0 = dc.gu3.b(r0)
                java.lang.String r1 = r12.a
                java.lang.String r0 = r0.R(r1)
                r1 = 2131887000(0x7f120398, float:1.9408595E38)
                java.lang.String r1 = dc.ah4.e(r1)
                com.wear.protocol.MessageType r2 = com.wear.protocol.MessageType.sync
                com.wear.protocol.MessageType r3 = r12.b
                boolean r2 = r2.equals(r3)
                java.lang.String r3 = ""
                if (r2 == 0) goto L2c
                r1 = 2131887003(0x7f12039b, float:1.94086E38)
                java.lang.String r1 = dc.ah4.e(r1)
                java.lang.String r2 = "get sync control"
            L28:
                r7 = r0
                r6 = r1
                r8 = r3
                goto L5d
            L2c:
                com.wear.protocol.MessageType r2 = com.wear.protocol.MessageType.video
                com.wear.protocol.MessageType r4 = r12.b
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L43
                r0 = 2131887004(0x7f12039c, float:1.9408603E38)
                java.lang.String r1 = dc.ah4.e(r0)
                java.lang.String r2 = "get video control"
                r6 = r1
                r7 = r3
                r8 = r7
                goto L5d
            L43:
                com.wear.protocol.MessageType r2 = com.wear.protocol.MessageType.voice
                com.wear.protocol.MessageType r4 = r12.b
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L5a
                r1 = 2131887005(0x7f12039d, float:1.9408605E38)
                java.lang.String r1 = dc.ah4.e(r1)
                java.lang.String r2 = "get voice control"
                r8 = r0
                r6 = r1
                r7 = r3
                goto L5d
            L5a:
                java.lang.String r2 = "get live control"
                goto L28
            L5d:
                java.lang.String r0 = r12.c
                r1 = 0
                dc.ye3.c(r1, r2, r0)
                dc.gu3 r0 = dc.gu3.this
                dc.rn3 r0 = r0.a
                if (r0 == 0) goto L8a
                dc.sz1 r0 = dc.sz1.d()
                dc.gu3 r2 = dc.gu3.this
                dc.rn3 r2 = r2.a
                r0.s(r2)
                dc.gu3 r0 = dc.gu3.this
                dc.rn3 r0 = r0.a
                r0.c()
                dc.gu3 r0 = dc.gu3.this
                com.wear.util.MyApplication r0 = dc.gu3.b(r0)
                java.lang.String r2 = r12.d
                r0.k0(r2)
                dc.gu3 r0 = dc.gu3.this
                r0.a = r1
            L8a:
                android.app.Activity r0 = r12.e     // Catch: java.lang.Exception -> Lde
                boolean r0 = r0.isFinishing()     // Catch: java.lang.Exception -> Lde
                if (r0 != 0) goto Le2
                android.app.Activity r0 = r12.e     // Catch: java.lang.Exception -> Lde
                boolean r0 = r0.isDestroyed()     // Catch: java.lang.Exception -> Lde
                if (r0 != 0) goto Le2
                dc.xz1.a()     // Catch: java.lang.Exception -> Lde
                android.app.Activity r0 = r12.e     // Catch: java.lang.Exception -> Lde
                java.lang.String r1 = "input_method"
                java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> Lde
                android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch: java.lang.Exception -> Lde
                android.app.Activity r1 = r12.e     // Catch: java.lang.Exception -> Lde
                android.view.Window r1 = r1.getWindow()     // Catch: java.lang.Exception -> Lde
                android.view.View r1 = r1.getDecorView()     // Catch: java.lang.Exception -> Lde
                android.os.IBinder r1 = r1.getWindowToken()     // Catch: java.lang.Exception -> Lde
                r2 = 0
                r0.hideSoftInputFromWindow(r1, r2)     // Catch: java.lang.Exception -> Lde
                dc.gu3 r0 = dc.gu3.this     // Catch: java.lang.Exception -> Lde
                dc.rn3 r1 = new dc.rn3     // Catch: java.lang.Exception -> Lde
                android.app.Activity r5 = r12.e     // Catch: java.lang.Exception -> Lde
                dc.gu3$f$a r9 = new dc.gu3$f$a     // Catch: java.lang.Exception -> Lde
                r9.<init>()     // Catch: java.lang.Exception -> Lde
                com.wear.protocol.MessageType r10 = r12.b     // Catch: java.lang.Exception -> Lde
                java.lang.String r11 = r12.a     // Catch: java.lang.Exception -> Lde
                r4 = r1
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Lde
                r0.a = r1     // Catch: java.lang.Exception -> Lde
                dc.gu3 r0 = dc.gu3.this     // Catch: java.lang.Exception -> Lde
                com.wear.util.MyApplication r0 = dc.gu3.b(r0)     // Catch: java.lang.Exception -> Lde
                java.lang.String r1 = r12.d     // Catch: java.lang.Exception -> Lde
                dc.gu3 r2 = dc.gu3.this     // Catch: java.lang.Exception -> Lde
                dc.rn3 r2 = r2.a     // Catch: java.lang.Exception -> Lde
                r0.s0(r1, r2)     // Catch: java.lang.Exception -> Lde
                goto Le2
            Lde:
                r0 = move-exception
                r0.printStackTrace()
            Le2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.gu3.f.run():void");
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class g implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ DataEntityAbstract b;
        public final /* synthetic */ MessageType c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;

        public g(String str, DataEntityAbstract dataEntityAbstract, MessageType messageType, Activity activity, String str2) {
            this.a = str;
            this.b = dataEntityAbstract;
            this.c = messageType;
            this.d = activity;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            rn3 rn3Var = (rn3) gu3.this.c.J(this.a);
            if (rn3Var != null && rn3Var.d()) {
                rn3Var.c();
            }
            if (gu3.this.i != null && gu3.this.i.isShowing()) {
                gu3.this.g();
            }
            gu3.this.c.k0(this.a);
            String id = ((EntityControl) this.b).getId();
            if (!TextUtils.isEmpty(id)) {
                if (!id.equals(gu3.j.getControlId())) {
                    return;
                }
                if (gu3.j.getAvailable() == ControlIdBean.Status.request) {
                    gu3.j.setAvailable(ControlIdBean.Status.cancel);
                } else if (gu3.j.getAvailable() == ControlIdBean.Status.accept) {
                    EndChatEvent endChatEvent = new EndChatEvent();
                    endChatEvent.endChat = true;
                    EventBus.getDefault().post(endChatEvent);
                    return;
                }
            }
            MessageType messageType = this.c;
            if (messageType == MessageType.video || messageType == MessageType.voice) {
                WearUtils.z2();
            }
            if (!WearUtils.x.f0()) {
                sg3.k(this.d, String.format(ah4.e(R.string.chat_video_cancel), WearUtils.x.R(this.e)));
            } else if (og3.b(1)) {
                sg3.k(this.d, String.format(ah4.e(R.string.chat_video_cancel), WearUtils.x.R(this.e)));
            }
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class h implements Runnable {
        public final /* synthetic */ DataEntityAbstract a;

        public h(gu3 gu3Var, DataEntityAbstract dataEntityAbstract) {
            this.a = dataEntityAbstract;
        }

        @Override // java.lang.Runnable
        public void run() {
            ye3.d("H0006", JSON.toJSONString(this.a));
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class i extends TimerTask {
        public i() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            gu3.this.c.G().W(0);
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class j extends ff3 {
        public j(gu3 gu3Var) {
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
        }
    }

    /* compiled from: SmackChatMessageListener.java */
    public class k extends ff3 {
        public final /* synthetic */ EntityAudio a;
        public final /* synthetic */ CommunMessage b;

        public k(gu3 gu3Var, EntityAudio entityAudio, CommunMessage communMessage) {
            this.a = entityAudio;
            this.b = communMessage;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
        }

        @Override // dc.ff3
        public void c(boolean z, Object obj, String str) {
            if (!z && (obj instanceof Integer) && ((Integer) obj).intValue() == 404) {
                this.a.setExpired(true);
                this.b.sendEntity(this.a);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.b);
                FirebaseCrashlytics.getInstance().recordException(new Throwable("语音消息过期"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(MessageType messageType, User user, Account account) {
        boolean z;
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH instanceof RemoteControlActivity) {
            ((RemoteControlActivity) fragmentActivityH).u4();
            z = true;
        } else {
            z = false;
        }
        if (fragmentActivityH instanceof RemoteMultiControlActivity) {
            ((RemoteMultiControlActivity) fragmentActivityH).C4();
            z = true;
        }
        if (fragmentActivityH instanceof PlaylistDetailsActivity) {
            ((PlaylistDetailsActivity) fragmentActivityH).R4();
            z = true;
        }
        if (fragmentActivityH instanceof PatternPlayActivity) {
            ((PatternPlayActivity) fragmentActivityH).y6();
            z = true;
        }
        if (fragmentActivityH instanceof MainActivity) {
            ((MainActivity) fragmentActivityH).t8();
            z = true;
        }
        if (fragmentActivityH instanceof SoundPlayActivity) {
            z = true;
        }
        if (fragmentActivityH instanceof SpeedModeActivity) {
            fragmentActivityH.finish();
            z = true;
        }
        if (fragmentActivityH instanceof ChatRoomActivity) {
            z = true;
        }
        if (fragmentActivityH instanceof ChatActivity) {
            z = true;
        }
        boolean z2 = fragmentActivityH instanceof HtmlVideoActivity ? true : z;
        MessageType messageType2 = MessageType.video;
        if (messageType == messageType2 || messageType == MessageType.voice) {
            if (z2) {
                this.g.postDelayed(new c(this, messageType, user), 100L);
            } else {
                ChatVideoControl.a1().d0(messageType, user);
            }
        }
        if (messageType == messageType2 || messageType == MessageType.voice || fragmentActivityH == null) {
            return;
        }
        pj3.j(fragmentActivityH, ChatActivity.class, "userId", account.getLiveFriendId());
    }

    public static /* synthetic */ void p(String str, String str2, CommunMessage communMessage, MatchResult matchResult) {
        if (matchResult == null || !matchResult.isReg()) {
            return;
        }
        CommunMessage communMessage2 = new CommunMessage();
        communMessage2.setFrom(str);
        communMessage2.setTo(str2);
        String strG = TextUtils.isEmpty(matchResult.getKey()) ? ah4.g(matchResult.getKey()) : matchResult.getDefaultText();
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C308.toString(), strG);
        communMessage2.sendEntity(entitySystem);
        communMessage2.setType(MessageType.fromString("system"));
        communMessage2.setCreated(be3.b(communMessage.getCreated()));
        communMessage2.setId(WearUtils.E());
        DaoUtils.getCommunMessageDao().add(communMessage2);
        zb2.O().i0(communMessage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(DataEntityAbstract dataEntityAbstract, MessageType messageType, HandleListener handleListener, String str, Activity activity) {
        j.setControlId(((EntityControl) dataEntityAbstract).getId());
        if (!TextUtils.isEmpty(j.getControlId())) {
            j.setAvailable(ControlIdBean.Status.request);
        }
        z(messageType, handleListener, str, activity);
    }

    public static void x(eu3 eu3Var) {
        k = eu3Var;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void t(String str, final MessageType messageType) {
        final User userV;
        final Account accountU = WearUtils.y.u();
        if (accountU == null || (userV = ch3.n().v(WearUtils.X(str))) == null) {
            return;
        }
        MusicControl.h0().S();
        y12.c.a().t();
        eu3 eu3Var = k;
        if (eu3Var != null) {
            eu3Var.w0(1);
        }
        pc1.a.F();
        td3.c().g(messageType, 2);
        accountU.setCurrentControlType(messageType);
        accountU.setAcceptVideoRequestJid(null);
        MessageType messageType2 = MessageType.video;
        if (messageType == messageType2 || messageType == MessageType.voice) {
            accountU.setLiveStatus(2);
            accountU.setAcceptVideoRequestJid(str);
        } else {
            accountU.setLiveStatus(2);
        }
        accountU.setLiveFriendId(WearUtils.g0(str));
        zb2.O().U0(true, WearUtils.g0(str));
        zb2.O().r(str);
        if (messageType == MessageType.live) {
            j.setAvailable(ControlIdBean.Status.accept);
            EntityLive entityLive = new EntityLive();
            EntityLive.LiveOPTType liveOPTType = EntityLive.LiveOPTType.accept;
            entityLive.setType(liveOPTType.toString());
            entityLive.setId(j.getControlId());
            hu3.g0(entityLive, str, messageType, liveOPTType.toString(), null, null);
            ChatLiveControl.q0().f0(userV);
        } else if (messageType == MessageType.sync) {
            j.setAvailable(ControlIdBean.Status.accept);
            EntitySync entitySync = new EntitySync();
            EntitySync.SyncOPTType syncOPTType = EntitySync.SyncOPTType.accept;
            entitySync.setType(syncOPTType.toString());
            entitySync.setId(j.getControlId());
            hu3.g0(entitySync, str, messageType, syncOPTType.toString(), null, null);
            ChatSyncControl.N0().f0(userV, false);
        } else if ((messageType == messageType2 || messageType == MessageType.voice) && messageType == messageType2) {
            zb2.O().L0(TtmlNode.START, WearUtils.X(str));
        }
        EventBus.getDefault().post(new FinishChatPageEvent(1));
        this.g.post(new Runnable() { // from class: dc.tt3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(messageType, userV, accountU);
            }
        });
        WearUtils.x.l.postDelayed(new d(this, messageType), 200L);
        WearUtils.x.l.postDelayed(new e(this), 8000L);
    }

    public final void f(final String str, final String str2, final CommunMessage communMessage) {
        DaoUtils.getSensitiveWordDao().toMatchSensitiveResult(SensitiveWordDao.NOT_UPLOAD, ((EntityChat) communMessage.getDataBean()).getText(), new SensitiveWordDao.OnResultListener() { // from class: dc.ut3
            @Override // com.wear.dao.SensitiveWordDao.OnResultListener
            public final void onResult(MatchResult matchResult) {
                gu3.p(str, str2, communMessage, matchResult);
            }
        });
    }

    public final void g() {
        try {
            kn3 kn3Var = this.i;
            if (kn3Var != null) {
                if (kn3Var.isShowing()) {
                    Context baseContext = ((ContextWrapper) this.i.getContext()).getBaseContext();
                    if (!(baseContext instanceof Activity)) {
                        this.i.dismiss();
                    } else if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                        this.i.dismiss();
                    }
                }
                this.i = null;
            }
        } catch (Exception unused) {
        }
    }

    public final String h(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!EntityUnSupport.isSupport(jSONObject.getString("type"))) {
                jSONObject.put("type", "unsupport");
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String i(String str) {
        try {
            return new JSONObject(str).getString("type");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void j(boolean z, String str, CommunMessage communMessage) {
        k(z, str, communMessage, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0b6c  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0b9b  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0c13  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0c64  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0c7a  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0c81  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0ca8  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0cb9  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0ccc  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0cd3  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0cdc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0d59  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k(boolean r29, java.lang.String r30, com.wear.protocol.CommunMessage r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 3494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gu3.k(boolean, java.lang.String, com.wear.protocol.CommunMessage, boolean):void");
    }

    public void l(boolean z, String str, String str2, String str3, String str4, Date date) {
        String strI = i(str);
        CommunMessage entity = new ContainBean(h(str)).getEntity();
        if (TextUtils.isEmpty(entity.getFrom())) {
            entity.setFrom(str2);
        }
        entity.setDataBean(entity.syncDecryptBean());
        entity.setReceiveId(str4);
        entity.setId(WearUtils.E());
        entity.setUserId(str3);
        entity.setSendStatus(0);
        entity.setCreated(date);
        entity.setFrom(str2);
        entity.setTo(str3);
        if (entity.getType() == MessageType.unsupport) {
            EntityUnSupport entityUnSupport = new EntityUnSupport();
            entityUnSupport.setOldType(strI);
            entityUnSupport.setMessageBody(entity.getData());
            entity.setData(CommunMessage.encryp(new Gson().toJson(entityUnSupport)));
        }
        j(z, str, entity);
    }

    public final void m(User user, MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        if (!this.c.i.t(messageType, dataEntityAbstract)) {
            user.setFagree(-1);
            ch3.n().g(user.getId());
            user.setTempName(null);
            return;
        }
        user.setFagree(1);
        if (user.getIagree() == 1) {
            if (user.isFriend()) {
                ch3.n().a(user.getId());
                user.resetFriendType(1);
                user.setTempName(null);
                user.resetAddFriendInfo();
                return;
            }
            if (user.isOnlyFriendType(4) || user.isOnlyFriendType(2)) {
                if (user.isOnlyFriendType(4)) {
                    hu3.a(user.getId());
                    synchronized (ch3.h) {
                        ch3 ch3Var = WearUtils.y;
                        ch3.j.remove(user);
                    }
                    UserSetting userSettingZ = WearUtils.y.z(user.getId());
                    if (userSettingZ != null && !userSettingZ.isFriendsRequestClick()) {
                        userSettingZ.setFriendsRequestClick(true);
                        DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                        df3.e().c(user.getId());
                        mu3.c--;
                    }
                }
                ch3.n().a(user.getId());
                user.resetFriendType(1);
                user.setTempName(null);
                user.resetAddFriendInfo();
            }
        }
    }

    @Override // org.jivesoftware.smack.chat.ChatMessageListener
    public void processMessage(Chat chat, Message message) {
        ep1.b().e("processMessage：");
        String str = message.getFrom().split("/")[0];
        String str2 = message.getTo().split("/")[0];
        String body = message.getBody();
        Date date = new Date();
        DelayInformation delayInformation = (DelayInformation) message.getExtension(DelayInformation.NAMESPACE);
        if (delayInformation != null) {
            date = delayInformation.getStamp();
        }
        Date date2 = date;
        if (TextUtils.isEmpty(body)) {
            return;
        }
        String stanzaId = message.getStanzaId();
        if (DaoUtils.getCommunMessageDao().findByReceiveId(stanzaId) != null) {
            return;
        }
        String strU = WearUtils.u(body);
        xe3.a("Message==>", "来自XMpp Message：receiveId：" + stanzaId + " " + strU);
        l(true, strU, str, str2, stanzaId, date2);
    }

    public final void v(String str, String str2, CommunMessage communMessage, MessageType messageType) {
        communMessage.setFrom(str);
        communMessage.setTo(str2);
        if (zb2.O().l0(communMessage)) {
            if (str2.equals(ch3.n().u().getUserJid())) {
                str2 = str;
            }
            User userV = ch3.n().v(WearUtils.g0(str2));
            if (userV != null && userV.isDateIng()) {
                communMessage.setSendType(2);
            }
            DaoUtils.getCommunMessageDao().add(communMessage);
            hu3.m(communMessage, false);
            if (messageType != MessageType.system) {
                EventBus.getDefault().post(communMessage);
            }
            if (!zb2.O().W(str)) {
                df3.e().l(str, communMessage.getId());
            }
            zb2.O().i0(communMessage);
        }
    }

    public final void w(String str, String str2, String str3, CommunMessage communMessage, MessageType messageType, boolean z) {
        communMessage.setFrom(str);
        communMessage.setTo(str2);
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().addIfNotExist(communMessage);
            hu3.m(communMessage, false);
            if (messageType != MessageType.system && z) {
                EventBus.getDefault().post(communMessage);
            }
            if (!zb2.O().W(str)) {
                df3.e().m(str, communMessage.getId(), z);
            }
            zb2.O().i0(communMessage);
        }
    }

    public final void y(MessageType messageType, String str) {
        User userV = WearUtils.y.v(str);
        if (userV != null && !WearUtils.e1(userV.getUserName())) {
            str = userV.getUserName();
        }
        String str2 = messageType == MessageType.live ? String.format(ah4.e(R.string.conflict_notice_live_control), str) : messageType == MessageType.sync ? String.format(ah4.e(R.string.conflict_notice_sync_control), str) : messageType == MessageType.video ? String.format(ah4.e(R.string.conflict_notice_video_control), str) : messageType == MessageType.voice ? String.format(ah4.e(R.string.conflict_notice_voice_control), str) : "";
        if (WearUtils.e1(str2)) {
            return;
        }
        sg3.l(str2);
    }

    public final void z(MessageType messageType, HandleListener handleListener, String str, Activity activity) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.dialog_wait_dialog_layout, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_from);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_notice);
        String strE = ah4.e(R.string.message_notification_type_live);
        if (messageType == MessageType.sync) {
            strE = ah4.e(R.string.message_notification_type_sync);
        } else if (messageType == MessageType.video) {
            strE = ah4.e(R.string.chat_video);
        } else if (messageType == MessageType.voice) {
            strE = ah4.e(R.string.chat_voice);
        }
        User userV = WearUtils.y.v(WearUtils.g0(str));
        String strG0 = (userV == null || userV.getUserName() == null) ? WearUtils.g0(str) : userV.getUserName();
        if (userV != null && !WearUtils.e1(userV.getRemark())) {
            strG0 = userV.getRemark();
        }
        textView.setText(Html.fromHtml(String.format(ah4.e(R.string.request_from_type_title), strE, "<font color='#ff4081'>" + strG0 + "</font>")));
        if (messageType == MessageType.video || messageType == MessageType.voice) {
            strE = strE.toLowerCase();
        }
        textView2.setText(String.format(ah4.e(R.string.request_from_type_notice), strE));
        g();
        kn3 kn3Var = new kn3((Context) activity, "", ah4.e(R.string.common_accept), ah4.e(R.string.common_decline), false, (kn3.d) new a(messageType, str, handleListener));
        this.i = kn3Var;
        kn3Var.show();
        this.i.h(viewInflate);
    }
}
