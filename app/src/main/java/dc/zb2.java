package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.MatchResult;
import com.wear.bean.SwitchBeanFeaturesConfig;
import com.wear.bean.User;
import com.wear.bean.VMShareDataBean;
import com.wear.bean.event.GroupBanEvent;
import com.wear.bean.event.GroupInvitationEvent;
import com.wear.bean.event.GroupInvitationSettingEvent;
import com.wear.bean.event.GroupNameChangeEvent;
import com.wear.bean.event.GroupProhibitedEvent;
import com.wear.bean.event.GroupStatusEvent;
import com.wear.bean.event.MessageSendEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.date.request.AppUserVideoTypeBean;
import com.wear.bean.socketio.msg.BeatSearchForPapersReturnRequest;
import com.wear.bean.socketio.msg.XmppMsg;
import com.wear.bean.socketio.msg.XmppStatusRequest;
import com.wear.bean.socketio.msg.XmppStatusResponse;
import com.wear.bean.socketio.msg.response.BeatSearchForPapersReturnResponse;
import com.wear.bean.socketio.msg.response.FrozenAccountResponse;
import com.wear.bean.socketio.msg.response.MessageErrorResponse;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.SensitiveWordDao;
import com.wear.main.MainActivity;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.ContainBean;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import io.agora.rtm2.RtmConstants;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PresenceListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.bean.request.RequestMessageRead;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomInvitationList;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomOfflinemsg;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomSettingInfo;
import org.jivesoftware.smackx.disco.bean.response.BroadDataBean;
import org.jivesoftware.smackx.disco.bean.response.ResponseBroad;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomInvitationList;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomOfflinemsg;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomSettingInfo;
import org.jivesoftware.smackx.disco.bean.response.SubMessageBean;
import org.jivesoftware.smackx.receipts.ReceiptReceivedListener;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MessageManagerImpl.java */
/* loaded from: classes3.dex */
public class zb2 implements ReceiptReceivedListener, tf2, MessageListener, PresenceListener {
    public static zb2 y;
    public static String z;
    public MyApplication b;
    public boolean c;
    public String d;
    public Dialog e;
    public final Timer l;
    public Handler m;
    public HandlerThread n;
    public HashMap<String, String> o;
    public LinkedList<Long> p;
    public ie3 q;
    public String r;
    public Boolean s;
    public Handler t;
    public int u;
    public FrozenAccountResponse v;
    public Hashtable<String, RequestMessageRead> w;
    public Handler x;
    public final Set<xb2> a = new CopyOnWriteArraySet();
    public Handler f = new Handler(Looper.getMainLooper());
    public Handler g = new Handler(Looper.getMainLooper());
    public Handler h = new Handler(Looper.getMainLooper());
    public Handler i = new Handler(Looper.getMainLooper());
    public long j = 1000;
    public final LinkedHashMap<String, u> k = new LinkedHashMap<>();

    /* compiled from: MessageManagerImpl.java */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ DataEntityAbstract b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public a(String str, DataEntityAbstract dataEntityAbstract, boolean z, String str2, boolean z2) {
            this.a = str;
            this.b = dataEntityAbstract;
            this.c = z;
            this.d = str2;
            this.e = z2;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            GroupMember memberByJid;
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(this.a);
            communMessage.sendEntity(this.b);
            communMessage.setId(WearUtils.E());
            communMessage.setUserId(communMessage.getFrom());
            communMessage.setRealFrom(communMessage.getFrom());
            Account accountU = ch3.n().u();
            if (accountU != null) {
                String str = "对方的头像===" + accountU.getAvatar();
                communMessage.setRealFromPhoto(accountU.getAvatar());
                communMessage.setRealFromNickName(accountU.getUserName());
                Group groupK = ch3.n().k(WearUtils.A0(this.a));
                if (groupK != null && (memberByJid = groupK.getMemberByJid(accountU.getUserJid())) != null) {
                    communMessage.setRealFromNickName(memberByJid.getNickName());
                }
            }
            communMessage.setSendStatus(0);
            if (this.c) {
                DataEntityAbstract dataEntityAbstract = this.b;
                if (dataEntityAbstract instanceof EntityChat) {
                    zb2.this.q.M(((EntityChat) dataEntityAbstract).getText());
                    communMessage.setShowEmojiAnim(!TextUtils.isEmpty(zb2.this.q.s(r2, false)));
                    communMessage.setEmojiLogType(this.d);
                }
            }
            if (zb2.this.r != null && communMessage.getType() == MessageType.chat) {
                communMessage.setReplyData(zb2.this.r);
                zb2.this.r = null;
            }
            if (zb2.this.l0(communMessage) && this.e) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                zb2.this.i0(communMessage);
            }
            zb2.this.s0(new ContainBean(communMessage));
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        /* compiled from: MessageManagerImpl.java */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sg3.l(ah4.e(R.string.group_chat_not_member_note1));
            }
        }

        public b(CommunMessage communMessage, String str, String str2, boolean z) {
            this.a = communMessage;
            this.b = str;
            this.c = str2;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            GroupMember memberByJid;
            this.a.setFrom(WearUtils.y.p());
            this.a.setTo(this.b);
            CommunMessage communMessage = this.a;
            communMessage.setUserId(communMessage.getFrom());
            CommunMessage communMessage2 = this.a;
            communMessage2.setRealFrom(communMessage2.getFrom());
            boolean z = false;
            this.a.setSendStatus(0);
            Account accountU = ch3.n().u();
            if (accountU != null) {
                this.a.setRealFromPhoto(accountU.getAvatar());
                this.a.setRealFromNickName(accountU.getUserName());
                Group groupK = ch3.n().k(WearUtils.A0(this.b));
                if (groupK != null && (memberByJid = groupK.getMemberByJid(accountU.getUserJid())) != null) {
                    z = true;
                    this.a.setRealFromNickName(memberByJid.getNickName());
                }
            }
            if (!TextUtils.isEmpty(this.c)) {
                this.a.setEmojiLogType(this.c);
            }
            if (zb2.this.l0(this.a) && this.d) {
                DaoUtils.getCommunMessageDao().updateOrAdd(this.a);
                zb2.this.i0(this.a);
            }
            if (z) {
                zb2.this.s0(new ContainBean(this.a));
                return;
            }
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH != null) {
                fragmentActivityH.runOnUiThread(new a(this));
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class c implements SensitiveWordDao.OnResultListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.wear.dao.SensitiveWordDao.OnResultListener
        public void onResult(MatchResult matchResult) {
            if (matchResult == null || !matchResult.isReg()) {
                return;
            }
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(this.a);
            communMessage.setTo(this.b);
            String strG = TextUtils.isEmpty(matchResult.getKey()) ? ah4.g(matchResult.getKey()) : matchResult.getDefaultText();
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C308.toString(), strG);
            communMessage.sendEntity(entitySystem);
            communMessage.setType(MessageType.fromString("system"));
            communMessage.setCreated(new Date(System.currentTimeMillis()));
            communMessage.setId(WearUtils.E());
            DaoUtils.getCommunMessageDao().add(communMessage);
            zb2.O().i0(communMessage);
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class d implements Runnable {

        /* compiled from: MessageManagerImpl.java */
        public class a implements Runnable {

            /* compiled from: MessageManagerImpl.java */
            /* renamed from: dc.zb2$d$a$a, reason: collision with other inner class name */
            public class C0234a implements kv1 {
                public C0234a(a aVar) {
                }

                @Override // dc.kv1
                public void a(String str) {
                    Log.println(3, "offMsgUpLoadResponse", str);
                }

                @Override // dc.kv1
                public void onError(Exception exc) {
                    Log.println(3, "offMsgUpLoadResponse", "error");
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (zb2.this.w) {
                    Iterator it = zb2.this.w.keySet().iterator();
                    while (it.hasNext()) {
                        RequestMessageRead requestMessageRead = (RequestMessageRead) zb2.this.w.get((String) it.next());
                        if (requestMessageRead != null) {
                            xe3.a("OffMsg", "上报：" + requestMessageRead.getRoomId() + " " + requestMessageRead.getMsgId());
                            zb2.this.C0(requestMessageRead, WearUtils.k0(requestMessageRead.getRoomId()), new C0234a(this));
                        }
                    }
                    zb2.this.w.clear();
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vg3.b().a(new a());
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class e implements bv1 {
        public final /* synthetic */ BroadDataBean a;

        public e(BroadDataBean broadDataBean) {
            this.a = broadDataBean;
        }

        @Override // dc.bv1
        public void Q(String str) {
            EventBus.getDefault().post(new UserUpdateEvent(""));
            if (zb2.this.b.f0()) {
                String byWho = this.a.getByWho();
                if (og3.b(1)) {
                    User userV = ch3.n().v(WearUtils.X(byWho));
                    String remark = userV.isShowInFriendsList() ? userV.getRemark() : "";
                    if (TextUtils.isEmpty(remark)) {
                        remark = this.a.getByWhoNickName();
                    }
                    String str2 = String.format(ah4.e(R.string.group_chat_created1), remark);
                    String roomId = this.a.getRoomId();
                    zb2.this.b.v(roomId, roomId, str2, MessageType.chat, false);
                }
            }
        }

        @Override // dc.bv1
        public void r1(String str) {
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class f implements bv1 {
        public final /* synthetic */ BroadDataBean a;

        public f(BroadDataBean broadDataBean) {
            this.a = broadDataBean;
        }

        @Override // dc.bv1
        public void Q(String str) {
            EventBus.getDefault().post(new UserUpdateEvent(""));
            if (zb2.this.b.f0() && og3.b(1)) {
                String str2 = String.format(ah4.e(R.string.group_chat_toast_guidelines), ah4.e(R.string.group_chat_toast_guidelines_link));
                String roomId = this.a.getRoomId();
                zb2.this.b.v(roomId, roomId, str2, MessageType.chat, false);
            }
        }

        @Override // dc.bv1
        public void r1(String str) {
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class g implements bv1 {
        public final /* synthetic */ BroadDataBean a;

        public g(BroadDataBean broadDataBean) {
            this.a = broadDataBean;
        }

        @Override // dc.bv1
        public void Q(String str) {
            EventBus.getDefault().post(new GroupStatusEvent(this.a.getRoomId()));
            if (zb2.this.b.f0() && ch3.n().p().equals(this.a.getWho()) && og3.b(1)) {
                User userV = ch3.n().v(WearUtils.X(this.a.getByWho()));
                String remark = userV.isShowInFriendsList() ? userV.getRemark() : "";
                if (TextUtils.isEmpty(remark)) {
                    remark = this.a.getByWhoNickName();
                }
                String str2 = String.format(ah4.e(R.string.group_chat_added_member1), remark);
                String roomId = this.a.getRoomId();
                zb2.this.b.v(roomId, roomId, str2, MessageType.chat, false);
            }
        }

        @Override // dc.bv1
        public void r1(String str) {
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class h implements bv1 {
        public h(zb2 zb2Var) {
        }

        @Override // dc.bv1
        public void Q(String str) {
            EventBus.getDefault().post(new UserUpdateEvent(""));
        }

        @Override // dc.bv1
        public void r1(String str) {
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class i implements kv1 {
        public final /* synthetic */ String a;

        public i(zb2 zb2Var, String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseRoomInvitationList responseRoomInvitationList = (ResponseRoomInvitationList) JSON.parseObject(str, ResponseRoomInvitationList.class);
            Group groupK = ch3.n().k(this.a);
            if (!responseRoomInvitationList.suc() || groupK == null) {
                return;
            }
            List<ResponseRoomInvitationList.InvitationListBean> invitationList = responseRoomInvitationList.getInvitationList();
            for (ResponseRoomInvitationList.InvitationListBean invitationListBean : invitationList) {
                String photo = invitationListBean.getPhoto();
                if (!TextUtils.isEmpty(photo) && !photo.contains("UploadFiles/wear/avatar")) {
                    try {
                        String str2 = new String(Base64.decode(photo), "ISO-8859-1");
                        photo = (WearUtils.e1(str2) || str2.length() > 512) ? "" : str2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                invitationListBean.setPhoto(photo);
            }
            Collections.reverse(invitationList);
            groupK.setInvitationList(invitationList);
            EventBus.getDefault().post(new GroupInvitationEvent(this.a));
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class j implements kv1 {
        public final /* synthetic */ String a;

        public j(zb2 zb2Var, String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseRoomSettingInfo responseRoomSettingInfo = (ResponseRoomSettingInfo) JSON.parseObject(str, ResponseRoomSettingInfo.class);
            GroupInvitationSettingEvent groupInvitationSettingEvent = new GroupInvitationSettingEvent(this.a, true);
            groupInvitationSettingEvent.responseRoomSettingInfo = responseRoomSettingInfo;
            EventBus.getDefault().post(groupInvitationSettingEvent);
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            EventBus.getDefault().post(new GroupInvitationSettingEvent(this.a, false));
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class k extends TimerTask {
        public k() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (zb2.this.k) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zb2.this.k.keySet().iterator();
                while (it.hasNext()) {
                    u uVar = (u) zb2.this.k.get((String) it.next());
                    int i = uVar.b + 1;
                    uVar.b = i;
                    if (i == 2) {
                        zb2.this.j0("Message==>", "开始loading");
                        uVar.a.sendSucImg();
                        DaoUtils.getCommunMessageDao().update((CommunMessageDao) uVar.a);
                        MessageSendEvent messageSendEvent = new MessageSendEvent();
                        messageSendEvent.msg = uVar.a;
                        EventBus.getDefault().post(messageSendEvent);
                    } else if (i == 5) {
                        zb2.this.j0("Message==>", "第一次开始重发前friend");
                        User userV = ch3.n().v(WearUtils.g0(uVar.a.getTo()));
                        if (dh3.a(userV) && uVar.a.getDataBean().autoResendMessage()) {
                            zb2.this.j0("Message==>", "第一次开始重发");
                            hu3.f0(new ContainBean(uVar.a));
                        } else if (dh3.a(userV)) {
                            zb2.this.j0("Message==>", "第一次不重发，原因:消息类型不支持" + uVar.a.getDataBean().getEntityType() + "  friend==" + userV);
                        } else {
                            zb2.this.j0("Message==>", "第一次不重发，原因:好友使用旧版本");
                        }
                    } else if (i == 10) {
                        zb2.this.j0("Message==>", "第二次重发失败");
                        User userV2 = ch3.n().v(WearUtils.g0(uVar.a.getTo()));
                        if (dh3.a(userV2) && uVar.a.getDataBean().autoResendMessage()) {
                            zb2.this.j0("Message==>", "第二次开始重发");
                            hu3.f0(new ContainBean(uVar.a));
                        } else if (dh3.a(userV2)) {
                            zb2.this.j0("Message==>", "第二次不重发，原因:消息类型不支持" + uVar.a.getDataBean().getEntityType() + "  friend==" + userV2);
                        } else {
                            zb2.this.j0("Message==>", "第二次不重发，原因:好友使用旧版本");
                        }
                    } else if (i == 15) {
                        uVar.a.sendFail();
                        DaoUtils.getCommunMessageDao().update((CommunMessageDao) uVar.a);
                        arrayList.add(uVar.a.getId());
                        zb2.this.t(uVar.a);
                        MessageSendEvent messageSendEvent2 = new MessageSendEvent();
                        messageSendEvent2.msg = uVar.a;
                        EventBus.getDefault().post(messageSendEvent2);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    zb2.this.k.remove((String) it2.next());
                }
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public static /* synthetic */ class l {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.pattern.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.picture.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.burnpicture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.burnvideo.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MessageType.alarm.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[MessageType.video.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[MessageType.live.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[MessageType.sync.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[MessageType.system.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[MessageType.alexa.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[MessageType.voice.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[MessageType.wishlist.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[MessageType.giftcard.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[MessageType.vmsharecard.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[MessageType.unsupport.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class m implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ yb2 b;

        public m(List list, yb2 yb2Var) {
            this.a = list;
            this.b = yb2Var;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                zb2.this.m.removeCallbacksAndMessages(null);
                String strP = WearUtils.y.p();
                for (IPeopleInfo iPeopleInfo : this.a) {
                    String userJid = iPeopleInfo.getUserJid();
                    if (!WearUtils.e1(userJid) && !WearUtils.e1(strP)) {
                        iPeopleInfo.setDraftMessage(DaoUtils.getCommunMessageDao().findDrafMessage(strP, userJid));
                        if (iPeopleInfo.isGroup()) {
                            iPeopleInfo.setLastMessage(DaoUtils.getCommunMessageDao().findLastGroupMessage(strP, userJid));
                        } else {
                            iPeopleInfo.setLastMessage(DaoUtils.getCommunMessageDao().findLastMessage(strP, userJid));
                        }
                    }
                }
                try {
                    yb2 yb2Var = this.b;
                    if (yb2Var != null) {
                        yb2Var.d();
                    }
                } catch (Exception unused) {
                }
                Thread.sleep(1000L);
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class n implements Runnable {
        public final /* synthetic */ Account a;
        public final /* synthetic */ User b;
        public final /* synthetic */ String c;

        /* compiled from: MessageManagerImpl.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!zb2.this.s.booleanValue()) {
                    zb2.this.j0("Message==>", "10秒到了,但是检测已经结束（这个可能是用户点击了结束控制或者5到10秒内收到了用户的socketIo消息）");
                    return;
                }
                zb2.this.s = Boolean.FALSE;
                n nVar = n.this;
                zb2.this.s(nVar.b, nVar.a);
                zb2.this.u = 0;
            }
        }

        public n(Account account, User user, String str) {
            this.a = account;
            this.b = user;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zb2.this.Y()) {
                zb2.this.j0("Message==>", "5秒到了，但是此时不走socketIo");
                zb2.this.s = Boolean.FALSE;
                zb2.this.u = 0;
                zb2.this.t.removeCallbacksAndMessages(null);
                return;
            }
            if (!zb2.this.s.booleanValue()) {
                zb2.this.j0("Message==>", "5秒到了,但是检测已经结束");
                return;
            }
            if (this.a.getLiveStatus() == 0 || pc1.a.N() == null) {
                zb2.this.s = Boolean.FALSE;
                zb2.this.j0("Message==>", "检测结束,自己没有控制状态或者自己连接玩具为0");
            } else if (this.a.getCurrentControlType() == MessageType.sync && this.a.getLiveStatus() == 1) {
                zb2.this.j0("Message==>", "检测结束,自己时同步控制主控方");
                zb2.this.s = Boolean.FALSE;
            } else {
                zb2.this.u = 1;
                zb2.this.t.postDelayed(new a(), 5000L);
                zb2.this.j0("Message==>", "5秒到了,开始查询好友socketIo状态");
                XmppStatusRequest xmppStatusRequest = new XmppStatusRequest();
                xmppStatusRequest.toJid = this.c;
                zb2.this.K0(xmppStatusRequest);
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class o implements Runnable {
        public final /* synthetic */ User a;

        public o(User user) {
            this.a = user;
        }

        @Override // java.lang.Runnable
        public void run() {
            ye3.d("S0003", "发送C324" + nd3.r(this.a.getUserJid()));
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C324.toString(), null);
            zb2 zb2Var = zb2.this;
            MyApplication myApplication = WearUtils.x;
            zb2Var.F0(MyApplication.H(), this.a.getUserJid(), entitySystem);
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class p implements Runnable {
        public final /* synthetic */ MessageErrorResponse a;

        public p(zb2 zb2Var, MessageErrorResponse messageErrorResponse) {
            this.a = messageErrorResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (!(fragmentActivityH instanceof Activity) || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            is3.b bVar = new is3.b(fragmentActivityH);
            bVar.q(this.a.getTitle());
            bVar.p(this.a.getContent());
            bVar.o("OK");
            bVar.k(R.layout.dialog_default_ok_with_title);
            cs3.h(bVar).show();
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class q implements Runnable {
        public final /* synthetic */ BeatSearchForPapersReturnResponse a;

        /* compiled from: MessageManagerImpl.java */
        public class a implements is3.d {
            public final /* synthetic */ Activity a;

            public a(Activity activity) {
                this.a = activity;
            }

            @Override // dc.is3.d
            public void doConfirm() {
                pj3.w(this.a, q.this.a.getUrl());
            }
        }

        /* compiled from: MessageManagerImpl.java */
        public class b implements DialogInterface.OnDismissListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                zb2.this.e = null;
            }
        }

        public q(BeatSearchForPapersReturnResponse beatSearchForPapersReturnResponse) {
            this.a = beatSearchForPapersReturnResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (!(fragmentActivityH instanceof MainActivity) || fragmentActivityH.isFinishing() || fragmentActivityH.isDestroyed()) {
                return;
            }
            zb2.this.K0(new BeatSearchForPapersReturnRequest());
            Dialog dialog = zb2.this.e;
            if (dialog == null || !dialog.isShowing()) {
                is3.b bVar = new is3.b(fragmentActivityH);
                bVar.q(ah4.e(R.string.new_ui_survey_notification_title));
                bVar.n(ah4.e(R.string.button_no_thanks));
                bVar.o(ah4.e(R.string.button_give_feedback_now));
                bVar.p(ah4.e(R.string.new_ui_survey_notification_des));
                bVar.k(R.layout.dialog_testers);
                bVar.x(ce3.a(fragmentActivityH, 300.0f));
                bVar.d(new a(fragmentActivityH));
                bVar.f(new b());
                zb2.this.e = cs3.h(bVar);
                zb2.this.e.show();
            }
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class r implements Runnable {
        public final /* synthetic */ ContainBean a;

        public r(zb2 zb2Var, ContainBean containBean) {
            this.a = containBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.f0(this.a);
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class s implements Runnable {
        public final /* synthetic */ ContainBean a;

        public s(zb2 zb2Var, ContainBean containBean) {
            this.a = containBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.f0(this.a);
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public class t implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public t(zb2 zb2Var, CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.f0(new ContainBean(this.a));
        }
    }

    /* compiled from: MessageManagerImpl.java */
    public static class u {
        public CommunMessage a;
        public int b;

        public u() {
        }

        public /* synthetic */ u(k kVar) {
            this();
        }
    }

    public zb2() {
        Timer timer = new Timer();
        this.l = timer;
        this.o = new HashMap<>();
        this.p = new LinkedList<>();
        this.q = new ie3();
        this.s = Boolean.FALSE;
        this.t = new Handler(Looper.getMainLooper());
        this.u = 0;
        this.v = null;
        this.w = new Hashtable<>();
        this.x = new Handler(Looper.getMainLooper());
        timer.schedule(new k(), 1L, 1000L);
        HandlerThread handlerThread = new HandlerThread("消息线程");
        this.n = handlerThread;
        handlerThread.start();
        this.m = new Handler(this.n.getLooper());
        this.b = WearUtils.x;
    }

    public static void K(String str, String str2, CommunMessage communMessage) {
        DaoUtils.getSensitiveWordDao().toMatchSensitiveResult(SensitiveWordDao.CHAT_ROOM, ((EntityChat) communMessage.getDataBean()).getText(), new c(str, str2));
    }

    public static zb2 O() {
        if (y == null) {
            synchronized (zb2.class) {
                if (y == null) {
                    y = new zb2();
                }
            }
        }
        return y;
    }

    public static void V0(BroadDataBean broadDataBean, Group group) {
        if (group != null) {
            group.setUrl(tg3.c(broadDataBean.getWhoNickName()));
            group.setMcs(tg3.c(broadDataBean.getWhoNickName()));
        }
        EventBus.getDefault().post(new UserUpdateEvent(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(BroadDataBean broadDataBean) {
        Q(broadDataBean.getRoomId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(BroadDataBean broadDataBean) {
        hu3.z(this.b).q(broadDataBean.getRoomId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(BroadDataBean broadDataBean) {
        R(broadDataBean.getRoomId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(BroadDataBean broadDataBean) {
        hu3.z(this.b).q(broadDataBean.getRoomId(), new g(broadDataBean));
    }

    public final void A(BroadDataBean broadDataBean, long j2, Group group, GroupMember groupMember) {
        w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        if (group != null) {
            if (groupMember != null) {
                groupMember.setAffiliation(10);
            }
            group.removeMemberByJid(broadDataBean.getByWho());
        }
    }

    public final void A0(Group group, String str, BroadDataBean broadDataBean) {
        if (group != null) {
            group.setBanType(str);
        }
        EventBus.getDefault().post(new GroupProhibitedEvent(broadDataBean.getRoomId(), str));
    }

    public synchronized boolean B(MessageType messageType) {
        try {
            if (messageType == MessageType.pattern || messageType == MessageType.alarm || messageType == MessageType.chat || messageType == MessageType.audio || messageType == MessageType.picture) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.p.size() <= 100) {
                    this.p.add(Long.valueOf(jCurrentTimeMillis));
                    return true;
                }
                if (jCurrentTimeMillis - this.p.get(0).longValue() <= 60000) {
                    return false;
                }
                this.p.add(Long.valueOf(jCurrentTimeMillis));
                this.p.removeFirst();
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    public void B0(Object obj, kv1 kv1Var) {
        XMPPConnection xMPPConnectionX = hu3.x();
        if (xMPPConnectionX != null) {
            C0(obj, "conference." + xMPPConnectionX.getServiceName(), kv1Var);
            return;
        }
        if (kv1Var != null) {
            try {
                kv1Var.onError(new ConnectException());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void C(String str) {
        j0("Message==>", "对方需要你切换xmpp通道啦");
        ye3.d("S0003", "收到C324 " + nd3.r(str) + " " + nd3.r(this.d));
        if (str.equals(this.d)) {
            this.s = Boolean.FALSE;
            this.c = false;
        }
    }

    public void C0(Object obj, String str, kv1 kv1Var) {
        hu3.z(this.b).d0(obj, str, kv1Var);
    }

    public final void D(BroadDataBean broadDataBean, long j2) {
        if (ch3.n().u().getUserJid().equals(broadDataBean.getByWho())) {
            return;
        }
        hu3.z(this.b).q(broadDataBean.getRoomId(), new e(broadDataBean));
        w(broadDataBean, broadDataBean.getMsgId(), j2, true);
    }

    public void D0(String str, DataEntityAbstract dataEntityAbstract, MessageType messageType, String str2, String str3, String str4, String str5, String str6) {
        if (!MyApplication.P || hu3.x() == null) {
            sg3.h(R.string.message_send_error);
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        if (l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            i0(communMessage);
        }
        if (!WearUtils.x.i.D(str, true)) {
            vg3.b().a(new s(this, new ContainBean(communMessage)));
            return;
        }
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C203.toString(), entitySystem.getNotificationMessage(communMessage.getType()) + "#" + communMessage.getId());
        CommunMessage communMessage2 = new CommunMessage();
        communMessage2.setFrom(WearUtils.y.p());
        communMessage2.setTo(str);
        communMessage2.sendEntity(entitySystem);
        communMessage2.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage2);
        i0(communMessage2);
    }

    public final void E(BroadDataBean broadDataBean, long j2) {
        String strD = nd3.d(broadDataBean.getShowList());
        if (WearUtils.e1(strD)) {
            return;
        }
        List array = JSON.parseArray(strD, String.class);
        for (int i2 = 0; i2 < array.size(); i2++) {
            if (((String) array.get(i2)).equals(ch3.n().p())) {
                hu3.z(this.b).q(broadDataBean.getRoomId(), new f(broadDataBean));
                w(broadDataBean, broadDataBean.getMsgId(), j2, true);
                return;
            }
        }
    }

    public void E0(String str, DataEntityAbstract dataEntityAbstract, String str2) {
        if (!MyApplication.P || hu3.x() == null) {
            MyApplication myApplication = WearUtils.x;
            sg3.i(MyApplication.H(), R.string.message_send_error);
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(WearUtils.y.p());
        User userV = ch3.n().v(WearUtils.g0(str));
        if (userV != null && userV.isDateIng()) {
            communMessage.setSendType(2);
        }
        if (l0(communMessage)) {
            if (userV.isDeleteByFriend() && !userV.isDateIng()) {
                communMessage.sendFail();
            }
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            if (communMessage.getType() == MessageType.alarm) {
                i0(communMessage);
                CommunMessage communMessageI = null;
                if (userV.isDeleteByFriend() && !userV.isDateIng()) {
                    communMessageI = hu3.j(communMessage);
                } else if (WearUtils.x.i.D(communMessage.getTo(), true)) {
                    communMessageI = hu3.i(communMessage);
                }
                if (communMessageI != null) {
                    i0(communMessageI);
                }
                if (!WearUtils.e1(str2)) {
                    EntityAlarm entityAlarmCopy = ((EntityAlarm) dataEntityAbstract).copy();
                    entityAlarmCopy.getPattern().setTime(str2);
                    CommunMessage communMessage2 = new CommunMessage();
                    communMessage2.setFrom(communMessage.getFrom());
                    communMessage2.setTo(communMessage.getTo());
                    communMessage2.sendEntity(entityAlarmCopy);
                    communMessage2.setId(communMessage.getId());
                    communMessage2.setUserId(communMessage.getFrom());
                    communMessage = communMessage2;
                }
            }
        }
        if (userV == null || !userV.isDeleteByFriend() || userV.isDateIng()) {
            vg3.b().a(new r(this, new ContainBean(communMessage)));
        }
    }

    public String F(CommunMessage communMessage) {
        String str = "type1==" + communMessage.getType();
        switch (l.a[communMessage.getType().ordinal()]) {
            case 1:
                return "[" + ah4.e(R.string.message_notification_type_pattern) + "]";
            case 2:
                return "[" + ah4.e(R.string.message_notification_type_audio) + "]";
            case 3:
            case 4:
                return "[" + ah4.e(R.string.message_notification_type_picture) + "]";
            case 5:
            case 6:
                return "[" + ah4.e(R.string.chat_shortvideo) + "]";
            case 7:
                return "[" + ah4.e(R.string.message_notification_type_alarm) + "]";
            case 8:
                return "[" + ah4.e(R.string.message_notification_type_video) + "]";
            case 9:
                return "[" + ah4.e(R.string.message_notification_type_live) + "]";
            case 10:
                return "[" + ah4.e(R.string.message_notification_type_sync) + "]";
            case 11:
                return "[system]";
            case 12:
                return "[" + ah4.e(R.string.message_notification_type_alarm) + "]";
            case 13:
                return "[" + ah4.e(R.string.message_notification_type_voice) + "]";
            case 14:
                return "[" + ah4.e(R.string.discover_wish_list) + "]";
            case 15:
                return "[" + ah4.e(R.string.discover_gift) + "]";
            case 16:
                return "[" + ah4.e(R.string.type_link) + "]" + ((VMShareDataBean) WearUtils.A.fromJson(CommunMessage.decrypt(communMessage.getData()), VMShareDataBean.class)).getDesc();
            default:
                return "";
        }
    }

    public void F0(Context context, String str, DataEntityAbstract dataEntityAbstract) {
        if (!MyApplication.P) {
            if (context != null) {
                sg3.i(context, R.string.message_send_error);
            }
        } else {
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(str);
            communMessage.sendEntity(dataEntityAbstract);
            communMessage.setId(WearUtils.E());
            y0(communMessage);
        }
    }

    public String G(CommunMessage communMessage, IPeopleInfo iPeopleInfo) {
        String str;
        if (communMessage == null) {
            return "";
        }
        if (communMessage.getType() == null) {
            communMessage.setType(MessageType.unsupport);
            ye3.d("Z0032", communMessage.toString());
        }
        String str2 = "type==" + communMessage.getType();
        switch (l.a[communMessage.getType().ordinal()]) {
            case 1:
                return "[" + ah4.e(R.string.message_notification_type_pattern) + "]";
            case 2:
                return "[" + ah4.e(R.string.message_notification_type_audio) + "]";
            case 3:
            case 4:
                return "[" + ah4.e(R.string.message_notification_type_picture) + "]";
            case 5:
            case 6:
                return "[" + ah4.e(R.string.chat_shortvideo) + "]";
            case 7:
                return "[" + ah4.e(R.string.message_notification_type_alarm) + "]";
            case 8:
                return "[" + ah4.e(R.string.message_notification_type_video) + "]";
            case 9:
                return "[" + ah4.e(R.string.message_notification_type_live) + "]";
            case 10:
                return "[" + ah4.e(R.string.message_notification_type_sync) + "]";
            case 11:
                DataEntityAbstract dataEntityAbstractSyncDecryptBean = communMessage.syncDecryptBean();
                if (!(dataEntityAbstractSyncDecryptBean instanceof EntitySystem)) {
                    return "[system]";
                }
                String strS = S((EntitySystem) dataEntityAbstractSyncDecryptBean, communMessage, iPeopleInfo);
                if (TextUtils.isEmpty(strS)) {
                    str = "[system]";
                } else {
                    str = "" + strS;
                }
                return str;
            case 12:
                return "[" + ah4.e(R.string.message_notification_type_alarm) + "]";
            case 13:
                return "[" + ah4.e(R.string.message_notification_type_voice) + "]";
            case 14:
                return "[" + ah4.e(R.string.discover_wish_list) + "]";
            case 15:
                return "[" + ah4.e(R.string.discover_gift) + "]";
            case 16:
                return "[" + ah4.e(R.string.type_link) + "]" + ((VMShareDataBean) WearUtils.A.fromJson(CommunMessage.decrypt(communMessage.getData()), VMShareDataBean.class)).getDesc();
            case 17:
                return "" + ah4.e(R.string.chat_message_old_version_tip);
            default:
                return "";
        }
    }

    public void G0(String str, CommunMessage communMessage, boolean z2, String str2) {
        vg3.b().a(new b(communMessage, str, str2, z2));
    }

    public void H(Message message) {
        String body = message.getBody();
        O().j0("Message==>", "广播来了:" + message.getType() + " " + message.getBody());
        ResponseBroad responseBroad = (ResponseBroad) JSON.parseObject(body, ResponseBroad.class);
        if (responseBroad.suc() && responseBroad.getType() == 1) {
            BroadDataBean data = responseBroad.getData();
            data.setMsgId(message.getRecId());
            I(data, true, System.currentTimeMillis());
        }
    }

    public void H0(String str, DataEntityAbstract dataEntityAbstract, boolean z2, boolean z3, String str2) {
        vg3.b().a(new a(str, dataEntityAbstract, z3, str2, z2));
    }

    public final void I(BroadDataBean broadDataBean, boolean z2, long j2) {
        if (z2) {
            J0(broadDataBean.getRoomId(), broadDataBean.getMsgId());
        }
        Group group = ch3.n().l().get(broadDataBean.getRoomId());
        GroupMember memberByJid = group != null ? group.getMemberByJid(broadDataBean.getWho()) : null;
        int operationType = broadDataBean.getOperationType();
        if (operationType == 110) {
            D(broadDataBean, j2);
        }
        if (operationType == 301) {
            k0(broadDataBean, j2, group);
            return;
        }
        if (operationType == 601) {
            E(broadDataBean, j2);
            return;
        }
        if (operationType == 401 || operationType == 402) {
            u(broadDataBean, group);
            return;
        }
        if (operationType == 555) {
            A0(group, "prohibited", broadDataBean);
            S0(broadDataBean);
            b(broadDataBean);
            return;
        }
        if (operationType == 556) {
            A0(group, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, broadDataBean);
            return;
        }
        switch (operationType) {
            case 201:
                M0(broadDataBean, j2, memberByJid, 20);
                break;
            case 202:
                M0(broadDataBean, j2, memberByJid, 30);
                break;
            case 203:
                v0(broadDataBean, j2, group);
                break;
            case 204:
                Z0(broadDataBean, j2);
                break;
            case 205:
                Z(broadDataBean, j2);
                break;
            default:
                switch (operationType) {
                    case 304:
                        A(broadDataBean, j2, group, memberByJid);
                        break;
                    case 305:
                        V(broadDataBean, group);
                        break;
                    case 306:
                        u0(broadDataBean, j2, group, memberByJid);
                        break;
                    default:
                        switch (operationType) {
                            case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                                X0(broadDataBean, memberByJid);
                                break;
                            case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                                W0(broadDataBean, group);
                                break;
                            case 503:
                                Y0(broadDataBean);
                                break;
                            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                                V0(broadDataBean, group);
                                break;
                        }
                }
        }
    }

    public boolean I0(EntityToy entityToy, String str) {
        this.d = str;
        User userV = ch3.n().v(str);
        Account accountU = ch3.n().u();
        if (userV != null && accountU != null) {
            xe3.a("Live", "发送的玩具震动信息：" + JSON.toJSONString(entityToy));
            if (Y()) {
                if (!uf2.v().q()) {
                    this.c = false;
                    v(false, false);
                    return false;
                }
                XmppMsg xmppMsg = new XmppMsg();
                xmppMsg.setType(MessageType.toy.toString());
                xmppMsg.setFrJid(accountU.getUserJid() + "/wearable");
                xmppMsg.setToJid(userV.getUserJid() + "/wearable");
                xmppMsg.setData(CommunMessage.encryp(WearUtils.A.toJson(entityToy)));
                xmppMsg.setId(WearUtils.E());
                K0(xmppMsg);
                return true;
            }
        }
        return false;
    }

    public void J(Message message) {
        String str;
        int i2;
        String str2;
        String str3;
        String body = message.getBody();
        zb2 zb2VarO = O();
        StringBuilder sb = new StringBuilder();
        sb.append("离线消息来了:");
        sb.append(message.getType());
        String str4 = " ";
        sb.append(" ");
        sb.append(message.getBody());
        zb2VarO.j0("Message==>", sb.toString());
        List<ResponseRoomOfflinemsg.DataBean> data = ((ResponseRoomOfflinemsg) JSON.parseObject(body, ResponseRoomOfflinemsg.class)).getData();
        String str5 = "/";
        String str6 = message.getFrom().split("/")[0];
        String str7 = message.getTo().split("/")[0];
        String id = zt3.k;
        Account accountU = ch3.n().u();
        if (accountU != null) {
            id = accountU.getId();
        }
        String strJ0 = WearUtils.j0(id);
        xe3.a("OffMsg", "收到个数：" + data.size());
        CommunMessage communMessage = null;
        int i3 = 1;
        int size = data.size() - 1;
        int i4 = 0;
        while (size >= 0) {
            ResponseRoomOfflinemsg.DataBean dataBean = data.get(size);
            if (dataBean.getType() == i3) {
                ResponseBroad responseBroad = (ResponseBroad) JSON.parseObject(dataBean.getBody(), ResponseBroad.class);
                if (responseBroad.suc()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("收到1：");
                    sb2.append(responseBroad.getData().getRoomId());
                    sb2.append(str4);
                    sb2.append(dataBean.getMsgId());
                    sb2.append(str4);
                    sb2.append(responseBroad.getData().getOperationType());
                    sb2.append(str4);
                    sb2.append(dataBean.getCreateTime());
                    sb2.append(str4);
                    i2 = i4;
                    str = str7;
                    sb2.append(be3.i(be3.a, new Date(dataBean.getCreateTime())));
                    xe3.a("OffMsg", sb2.toString());
                    if (responseBroad.getType() == 1) {
                        BroadDataBean data2 = responseBroad.getData();
                        data2.setMsgId(dataBean.getMsgId());
                        if (data2.getOperationType() != 555 && data2.getOperationType() != 556 && data2.getOperationType() != 305) {
                            I(data2, false, dataBean.getCreateTime());
                        }
                    }
                    str2 = str5;
                    str7 = str;
                    str3 = str4;
                    i4 = i2;
                } else {
                    str2 = str5;
                    str3 = str4;
                    i2 = i4;
                    i4 = i2;
                }
            } else {
                str = str7;
                i2 = i4;
                if (dataBean.getType() <= 1 || dataBean.getType() >= 1000) {
                    str2 = str5;
                    str7 = str;
                    str3 = str4;
                    i4 = i2;
                } else {
                    String strU = WearUtils.u(dataBean.getBody());
                    ContainBean containBean = new ContainBean(strU);
                    String string = containBean.getDataMap().get(TtmlNode.ATTR_ID).toString();
                    CommunMessage entity = containBean.getEntity();
                    entity.setRealFrom(!TextUtils.isEmpty(entity.getRealFrom()) ? entity.getRealFrom().split(str5)[0] : !TextUtils.isEmpty(entity.getFrom()) ? entity.getFrom().split(str5)[0] : "");
                    xe3.a("OffMsg", "收到2：" + WearUtils.g0(str6) + str4 + dataBean.getMsgId());
                    CommunMessage communMessageFindByReceiveId = DaoUtils.getCommunMessageDao().findByReceiveId(string);
                    if (communMessageFindByReceiveId != null) {
                        xe3.a("OffMsg", "已有消息1：" + communMessageFindByReceiveId.syncDecryptBean().toString());
                    } else if (entity.getRealFrom().equals(strJ0)) {
                        CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(string);
                        if (communMessageFindById != null) {
                            communMessageFindById.setMsgId(dataBean.getMsgId());
                            DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessageFindById);
                        }
                    } else {
                        DataEntityAbstract dataEntityAbstractSyncDecryptBean = entity.syncDecryptBean();
                        xe3.a("OffMsg", "已有消息2：" + dataEntityAbstractSyncDecryptBean.toString());
                        entity.setDataBean(dataEntityAbstractSyncDecryptBean);
                        String id2 = entity.getId();
                        if (TextUtils.isEmpty(id2)) {
                            id2 = WearUtils.E();
                        }
                        entity.setId(id2);
                        str7 = str;
                        entity.setUserId(str7);
                        entity.setSendStatus(0);
                        entity.setFrom(str6);
                        entity.setTo(str7);
                        entity.setMsgId(dataBean.getMsgId());
                        str2 = str5;
                        str3 = str4;
                        entity.setCreated(new Date(dataBean.getCreateTime()));
                        entity.setReceiveId(string);
                        hu3.p.k(false, strU, entity, false);
                        if (O().l0(entity)) {
                            i4 = i2 + 1;
                            if (entity.getType() != MessageType.system) {
                                communMessage = entity;
                            }
                        } else {
                            i4 = i2;
                        }
                    }
                    str2 = str5;
                    str7 = str;
                    str3 = str4;
                    i4 = i2;
                }
            }
            size--;
            str4 = str3;
            str5 = str2;
            i3 = 1;
        }
        int i5 = i4;
        if (!O().W(str6)) {
            df3.e().b(WearUtils.g0(str6), i5);
            LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
        }
        if (communMessage != null) {
            EventBus.getDefault().post(communMessage);
        }
        if (data.size() != 0) {
            J0(WearUtils.A0(str6), data.get(0).getMsgId());
        }
    }

    public final void J0(String str, String str2) {
        RequestMessageRead requestMessageRead = new RequestMessageRead(str, str2);
        synchronized (this.w) {
            this.w.put(str, requestMessageRead);
        }
        this.x.removeCallbacksAndMessages(null);
        this.x.postDelayed(new d(), 5000L);
    }

    public final void K0(pf2 pf2Var) {
        uf2.v().E(pf2Var);
        j0("Message==>", "发送SocketIO: " + JSON.toJSONString(pf2Var));
    }

    public final String L(String str) throws JSONException {
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

    public void L0(String str, String str2) {
        try {
            AppUserVideoTypeBean appUserVideoTypeBean = new AppUserVideoTypeBean(str, nd3.q(str2));
            String str3 = "sendSokcetIoVideoTypeMsg: " + appUserVideoTypeBean.toString();
            K0(appUserVideoTypeBean);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String M(String str) {
        return this.o.get(str);
    }

    public final void M0(BroadDataBean broadDataBean, long j2, GroupMember groupMember, int i2) {
        w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        if (groupMember != null) {
            groupMember.setAffiliation(i2);
        }
    }

    public FrozenAccountResponse N() {
        return this.v;
    }

    public void N0(BeatSearchForPapersReturnResponse beatSearchForPapersReturnResponse) {
        this.t.post(new q(beatSearchForPapersReturnResponse));
    }

    public void O0(FrozenAccountResponse frozenAccountResponse) {
        this.v = frozenAccountResponse;
    }

    public void P(String str) {
        RequestRoomOfflinemsg requestRoomOfflinemsg = new RequestRoomOfflinemsg();
        requestRoomOfflinemsg.setRoomId(str);
        String id = zt3.k;
        Account accountU = ch3.n().u();
        if (accountU != null) {
            id = accountU.getId();
        }
        CommunMessage communMessageFindLastRecMessage = DaoUtils.getCommunMessageDao().findLastRecMessage(WearUtils.k0(str), WearUtils.j0(id));
        if (communMessageFindLastRecMessage == null) {
            xe3.a("OffMsg", "请求：" + str + " null");
        } else {
            xe3.a("OffMsg", "请求：" + str + " " + communMessageFindLastRecMessage.getMsgId());
            requestRoomOfflinemsg.setMsgId(communMessageFindLastRecMessage.getMsgId());
        }
        O().C0(requestRoomOfflinemsg, WearUtils.k0(str), null);
    }

    public void P0(String str) {
        this.r = str;
    }

    public void Q(String str) {
        RequestRoomInvitationList requestRoomInvitationList = new RequestRoomInvitationList();
        requestRoomInvitationList.setRoomId(str);
        O().C0(requestRoomInvitationList, WearUtils.j0(str), new i(this, str));
    }

    public void Q0(List<IPeopleInfo> list, yb2 yb2Var) {
        this.m.post(new m(list, yb2Var));
    }

    public void R(String str) {
        RequestRoomSettingInfo requestRoomSettingInfo = new RequestRoomSettingInfo();
        requestRoomSettingInfo.setRoomId(str);
        O().C0(requestRoomSettingInfo, WearUtils.k0(str), new j(this, str));
    }

    public void R0() {
        j0("Message==>", "stopD0007");
        this.s = Boolean.FALSE;
        this.u = 0;
        this.t.removeCallbacksAndMessages(null);
    }

    public final String S(EntitySystem entitySystem, CommunMessage communMessage, IPeopleInfo iPeopleInfo) {
        String showNickName;
        if (entitySystem != null && communMessage != null) {
            showNickName = "";
            if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T300 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C320) {
                if (communMessage.getFrom().equals(ch3.n().p())) {
                    return ah4.e(R.string.chat_sync_recall_owner);
                }
                if (iPeopleInfo instanceof Group) {
                    GroupMember memberByJid = ((Group) iPeopleInfo).getMemberByJid(communMessage.getRealFrom());
                    showNickName = memberByJid != null ? memberByJid.getNickName() : "";
                    if (TextUtils.isEmpty(showNickName)) {
                        showNickName = communMessage.getRealFromNickName();
                    }
                } else {
                    showNickName = iPeopleInfo.getShowNickName();
                }
                return String.format(ah4.e(R.string.chat_sync_recall_pattern), showNickName);
            }
            EntitySystem.SystemOPTType firstSysOPTType = entitySystem.getFirstSysOPTType();
            EntitySystem.SystemOPTType systemOPTType = EntitySystem.SystemOPTType.T200;
            if (firstSysOPTType == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C325) {
                return String.format(ah4.e(R.string.group_start_sync_sontrol), communMessage.getRealFromNickName());
            }
            if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C326) {
                return ah4.e(R.string.group_end_sync_control);
            }
            if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10001) {
                EntitySystem.C10001Json objectFromJson = entitySystem.getObjectFromJson();
                int operationType = objectFromJson.getOperationType();
                if (operationType == 110) {
                    return objectFromJson.getByWho().equals(ch3.n().p()) ? ah4.e(R.string.group_chat_created2) : String.format(ah4.e(R.string.group_chat_created1), objectFromJson.getByWhoNickName());
                }
                if (operationType == 301) {
                    return objectFromJson.getWhos().get(0).getWho().equals(ch3.n().p()) ? ah4.e(R.string.group_chat_left_note1) : String.format(ah4.e(R.string.group_chat_left_note2), objectFromJson.getByWhoNickName());
                }
                if (operationType == 304) {
                    return String.format(ah4.e(R.string.group_chat_left_note3), objectFromJson.getByWhoNickName(), objectFromJson.getWhos().get(0).getWhoNickName(), objectFromJson.getByWhoNickName());
                }
                if (operationType == 306) {
                    return String.format(ah4.e(R.string.group_chat_left_note2), objectFromJson.getByWhoNickName());
                }
                if (operationType == 601) {
                    return String.format(ah4.e(R.string.group_chat_toast_guidelines), ah4.e(R.string.group_chat_toast_guidelines_link));
                }
                switch (operationType) {
                    case 201:
                        EntitySystem.C10001Json.WhoBean whoBean = objectFromJson.getWhos().get(0);
                        return whoBean.getWho().equals(ch3.n().p()) ? String.format(ah4.e(R.string.group_chat_make_admin1), objectFromJson.getByWhoNickName()) : String.format(ah4.e(R.string.group_chat_make_admin2), objectFromJson.getByWhoNickName(), whoBean.getWhoNickName());
                    case 202:
                        EntitySystem.C10001Json.WhoBean whoBean2 = objectFromJson.getWhos().get(0);
                        return whoBean2.getWho().equals(ch3.n().p()) ? String.format(ah4.e(R.string.group_chat_dismiss_admin1), objectFromJson.getByWhoNickName()) : String.format(ah4.e(R.string.group_chat_dismiss_admin2), objectFromJson.getByWhoNickName(), whoBean2.getWhoNickName());
                    case 203:
                        EntitySystem.C10001Json.WhoBean whoBean3 = objectFromJson.getWhos().get(0);
                        return whoBean3.getWho().equals(ch3.n().p()) ? String.format(ah4.e(R.string.group_chat_removed1), objectFromJson.getByWhoNickName()) : String.format(ah4.e(R.string.group_chat_removed2), objectFromJson.getByWhoNickName(), whoBean3.getWhoNickName());
                    case 204:
                        EntitySystem.C10001Json.WhoBean whoBean4 = objectFromJson.getWhos().get(0);
                        return whoBean4.getWho().equals(ch3.n().p()) ? String.format(ah4.e(R.string.group_chat_added_member1), objectFromJson.getByWhoNickName()) : String.format(ah4.e(R.string.group_chat_added_member2), objectFromJson.getByWhoNickName(), whoBean4.getWhoNickName());
                    case 205:
                        return String.format(ah4.e(R.string.group_chat_joined), objectFromJson.getWhos().get(0).getWhoNickName());
                    default:
                        switch (operationType) {
                            case 10000:
                                Iterator<EntitySystem.C10001Json.WhoBean> it = objectFromJson.getWhos().iterator();
                                while (it.hasNext()) {
                                    showNickName = showNickName + it.next().getWhoNickName() + "，";
                                }
                                return String.format(ah4.e(R.string.group_chat_decline_invitation1), showNickName.substring(0, showNickName.length() - 1));
                            case 10001:
                                Iterator<EntitySystem.C10001Json.WhoBean> it2 = objectFromJson.getWhos().iterator();
                                while (it2.hasNext()) {
                                    showNickName = showNickName + it2.next().getWhoNickName() + "，";
                                }
                                return String.format(ah4.e(R.string.group_chat_decline_invitation2), showNickName.substring(0, showNickName.length() - 1));
                            case RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION /* 10002 */:
                                Iterator<EntitySystem.C10001Json.WhoBean> it3 = objectFromJson.getWhos().iterator();
                                while (it3.hasNext()) {
                                    showNickName = showNickName + it3.next().getWhoNickName() + "，";
                                }
                                return String.format(ah4.e(R.string.group_chat_wrong_version), showNickName.substring(0, showNickName.length() - 1));
                            case RtmConstants.RTM_ERR_INVALID_TOPIC_NAME /* 10003 */:
                                Iterator<EntitySystem.C10001Json.WhoBean> it4 = objectFromJson.getWhos().iterator();
                                while (it4.hasNext()) {
                                    showNickName = showNickName + it4.next().getWhoNickName() + "，";
                                }
                                return String.format(ah4.e(R.string.group_chat_user_unavailable), showNickName.substring(0, showNickName.length() - 1));
                            case RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED /* 10004 */:
                                String whoNickName = objectFromJson.getWhos().get(0).getWhoNickName();
                                return String.format(ah4.e(R.string.group_chat_added_member2), objectFromJson.getByWhoNickName(), whoNickName) + " . " + String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName);
                            case RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION /* 10005 */:
                                String whoNickName2 = objectFromJson.getWhos().get(0).getWhoNickName();
                                return String.format(ah4.e(R.string.group_chat_joined), whoNickName2) + String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName2);
                        }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S0(BroadDataBean broadDataBean) {
        ChatDSControl chatDSControlR1 = ChatDSControl.r1();
        if (((Group) chatDSControlR1.J()).getId().equals(broadDataBean.getRoomId())) {
            chatDSControlR1.stop(4);
        }
    }

    public final String T(String str) {
        try {
            return new JSONObject(str).getString("type");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void T0(Message message) {
        String body = message.getBody();
        O().j0(uf2.i, "订阅消息来了:" + message.getType() + " " + message.getBody());
        EventBus.getDefault().post((SubMessageBean) JSON.parseObject(body, SubMessageBean.class));
    }

    public HashMap<String, String> U() {
        return this.o;
    }

    public void U0(boolean z2, String str) {
        this.d = str;
        User userV = ch3.n().v(str);
        if (userV == null) {
            return;
        }
        String supportType = userV.getSupportType();
        SwitchBeanFeaturesConfig.VersionEntity versionEntityD = og3.d();
        if (versionEntityD == null || versionEntityD.getStatus() == 0 || !uf2.v().q()) {
            this.c = false;
            v(z2, false);
        } else {
            this.c = true;
        }
        if (this.c) {
            if (!dh3.o(userV)) {
                this.c = false;
                v(z2, true);
            } else if ("openfire#socketio_1".equals(supportType)) {
                this.c = true;
                v(z2, true);
            } else {
                this.c = false;
                v(z2, true);
            }
        }
    }

    public final void V(BroadDataBean broadDataBean, Group group) {
        if (group != null) {
            group.setStatus(5);
            EventBus.getDefault().post(new GroupStatusEvent(broadDataBean.getRoomId()));
            if (broadDataBean.getTypeShow() == 1) {
                EventBus.getDefault().post(new GroupBanEvent(broadDataBean.getRoomId()));
            }
            S0(broadDataBean);
            b(broadDataBean);
            hu3.z(this.b).q(broadDataBean.getRoomId(), new h(this));
        }
    }

    public boolean W(String str) {
        synchronized (this.a) {
            Iterator<xb2> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().O3(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void W0(BroadDataBean broadDataBean, Group group) {
        if (group != null) {
            group.setName(broadDataBean.getWhoNickName());
        }
        EventBus.getDefault().post(new UserUpdateEvent(""));
        EventBus.getDefault().post(new GroupNameChangeEvent(broadDataBean.getWhoNickName(), broadDataBean.getRoomId()));
    }

    public final boolean X(String str) {
        String strX = WearUtils.X(str);
        if (ch3.n().r().equals(strX)) {
            return true;
        }
        User userV = ch3.n().v(strX);
        return userV != null && userV.isShowInFriendsList();
    }

    public final void X0(BroadDataBean broadDataBean, GroupMember groupMember) {
        if (groupMember != null) {
            groupMember.setNickName(broadDataBean.getWhoNickName());
        }
    }

    public boolean Y() {
        return this.c;
    }

    public final void Y0(final BroadDataBean broadDataBean) {
        this.f.removeCallbacksAndMessages(null);
        this.f.postDelayed(new Runnable() { // from class: dc.ub2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f0(broadDataBean);
            }
        }, this.j);
    }

    public final void Z(final BroadDataBean broadDataBean, long j2) {
        if (z(broadDataBean, j2)) {
            w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        }
        this.i.removeCallbacksAndMessages(null);
        this.i.postDelayed(new Runnable() { // from class: dc.rb2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d0(broadDataBean);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public final void Z0(final BroadDataBean broadDataBean, long j2) {
        if (y(broadDataBean, j2)) {
            w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        }
        this.h.removeCallbacksAndMessages(null);
        this.h.postDelayed(new Runnable() { // from class: dc.sb2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h0(broadDataBean);
            }
        }, this.j);
    }

    public void a(MessageErrorResponse messageErrorResponse) {
        this.t.post(new p(this, messageErrorResponse));
    }

    public void a1(String str) {
        j0("Message==>", "收到SocketIO:   " + str);
        XmppMsg xmppMsg = (XmppMsg) JSON.parseObject(str, XmppMsg.class);
        String str2 = xmppMsg.getFrJid().split("/")[0];
        String str3 = xmppMsg.getToJid().split("/")[0];
        Date date = new Date();
        String id = xmppMsg.getId();
        if (DaoUtils.getCommunMessageDao().findByReceiveId(id) != null) {
            return;
        }
        try {
            if (this.s.booleanValue() && WearUtils.g0(str2).equals(this.d)) {
                j0("Message==>", "收到消息，不再检测");
                this.s = Boolean.FALSE;
            }
            hu3.p.l(false, str, str2, str3, id, date);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(BroadDataBean broadDataBean) {
        ChatGroupControl chatGroupControlO1 = ChatGroupControl.o1();
        if (((Group) chatGroupControlO1.J()).getId().equals(broadDataBean.getRoomId())) {
            chatGroupControlO1.stop(4);
        }
    }

    public void b1(String str) {
        j0("Message==>", "收到回执" + str);
    }

    public void c1(String str) {
        Account accountU = ch3.n().u();
        if (accountU == null) {
            return;
        }
        XmppStatusResponse xmppStatusResponse = (XmppStatusResponse) JSON.parseObject(str, XmppStatusResponse.class);
        if (xmppStatusResponse.target == null) {
            return;
        }
        j0("Message==>", "好友SocketIo返回：" + this.c + "控制状态：" + accountU.getLiveStatus());
        StringBuilder sb = new StringBuilder();
        sb.append("好友SocketIo返回：");
        sb.append(str);
        j0("Message==>", sb.toString());
        if (this.s.booleanValue() && this.u == 1) {
            this.u = xmppStatusResponse.online ? 2 : 3;
        }
        if (na2.m().i() && WearUtils.g0(xmppStatusResponse.target).equals(this.d) && Y() && !xmppStatusResponse.online) {
            this.c = false;
            v(false, true);
        }
    }

    @Override // dc.tf2
    public void connectSuc() {
        j0("Message==>", "SocketIo连接成功");
    }

    @Override // dc.tf2
    public void disConnect() {
        Account accountU = ch3.n().u();
        if (accountU == null) {
            return;
        }
        j0("Message==>", "SocketIo断开了" + this.c + accountU.getLiveStatus());
        if (!na2.m().i()) {
            this.c = false;
            return;
        }
        if (Y()) {
            this.c = false;
            v(false, false);
        }
        this.c = false;
    }

    public void i0(CommunMessage communMessage) {
        synchronized (this.a) {
            Iterator<xb2> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().E0(communMessage);
            }
        }
    }

    public void j0(String str, String str2) {
        xe3.a(str, str2);
    }

    public final void k0(BroadDataBean broadDataBean, long j2, Group group) {
        if (!ch3.n().u().getUserJid().equals(broadDataBean.getByWho())) {
            if (group != null && group.getStatus() == 3) {
                group.removeMemberByJid(broadDataBean.getByWho());
                return;
            } else {
                w(broadDataBean, broadDataBean.getMsgId(), j2, true);
                EventBus.getDefault().post(new UserUpdateEvent(""));
            }
        }
        if (group != null) {
            group.removeMemberByJid(broadDataBean.getByWho());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean l0(CommunMessage communMessage) {
        if (MessageType.toy == communMessage.getType()) {
            return false;
        }
        if (!Arrays.asList(MessageType.live, MessageType.sync, MessageType.video, MessageType.voice).contains(communMessage.getType())) {
            String[] strArr = {EntityPattern.TYPE_DETAIL_MYSENDPATTERN, EntityPattern.TYPE_DETAIL_PATTERN_RESEND, EntityPattern.TYPE_DETAIL_PATTERN_RESEND_V2};
            if (MessageType.pattern.equals(communMessage.getType()) && Arrays.asList(strArr).contains(((EntityPattern) communMessage.getDataBean()).getType())) {
                EntityPattern entityPattern = (EntityPattern) communMessage.syncDecryptBean();
                return (entityPattern == null || DaoUtils.getCommunMessageDao().hasPatternByFromIdAndUrl(communMessage.getFrom(), entityPattern.getUrl(), entityPattern.getTime()) || this.a.size() != 0) ? false : true;
            }
            MessageType messageType = MessageType.system;
            if (messageType.equals(communMessage.getType()) && ((EntitySystem) communMessage.getDataBean()).getFirstSysOPTType() != EntitySystem.SystemOPTType.T200) {
                return false;
            }
            if (messageType.equals(communMessage.getType()) && ((EntitySystem) communMessage.getDataBean()).getFirstSysOPTType() == EntitySystem.SystemOPTType.T200) {
                if (((EntitySystem) communMessage.getDataBean()).getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C204) {
                    return false;
                }
                String firstSysText = ((EntitySystem) communMessage.getDataBean()).getFirstSysText();
                if (!WearUtils.e1(firstSysText) && firstSysText.startsWith(zt3.j)) {
                    return false;
                }
            }
            return (MessageType.alarm.equals(communMessage.getType()) && ((EntityAlarm) communMessage.getDataBean()).getAlarmOPTType() == EntityAlarm.AlarmOPTType.delete) ? false : true;
        }
        int i2 = l.a[communMessage.getType().ordinal()];
        if (i2 != 13) {
            switch (i2) {
                case 8:
                    EntityVideo entityVideo = (EntityVideo) communMessage.getDataBean();
                    if (entityVideo.getType().equals(EntityVideo.VideoOPTType.cancel.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.reject.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.end.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.networkError.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.noAnswer.toString())) {
                        return true;
                    }
                    break;
                case 9:
                    EntityLive entityLive = (EntityLive) communMessage.getDataBean();
                    if (entityLive.getType().equals(EntityLive.LiveOPTType.cancel.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.end.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.reject.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.networkError.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.noAnswer.toString())) {
                        return true;
                    }
                    break;
                case 10:
                    EntitySync entitySync = (EntitySync) communMessage.getDataBean();
                    if (entitySync.getType().equals(EntitySync.SyncOPTType.cancel.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.reject.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.end.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.networkError.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.noAnswer.toString())) {
                        return true;
                    }
                    break;
            }
        } else {
            EntityVoice entityVoice = (EntityVoice) communMessage.getDataBean();
            if (entityVoice.getType().equals(EntityVoice.VoiceOPTType.cancel.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.reject.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.end.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.networkError.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.noAnswer.toString())) {
                return true;
            }
        }
        return false;
    }

    public void m0(String str) {
        synchronized (this.a) {
            for (xb2 xb2Var : this.a) {
                if (xb2Var.O3(str)) {
                    xb2Var.notifyDataSetChanged();
                }
            }
        }
    }

    public void n0(FrozenAccountResponse frozenAccountResponse) {
        String str = "notify_account_frozen: " + frozenAccountResponse.toString();
        this.v = frozenAccountResponse;
        ep1.b().g();
    }

    public boolean o0(String str, String str2) {
        j0("Message==>", "收到SocketIO: " + str + "  " + str2);
        return false;
    }

    @Override // org.jivesoftware.smackx.receipts.ReceiptReceivedListener
    public void onReceiptReceived(String str, String str2, String str3, Stanza stanza) {
        xe3.a("Message==>", "receiptId:" + str3 + " fromJid:" + str + " toJid:" + str2);
        w0(str3);
    }

    public void p0(String str, String str2) {
        synchronized (this.a) {
            for (xb2 xb2Var : this.a) {
                if (xb2Var.O3(str)) {
                    xb2Var.c0(str, str2);
                }
            }
        }
    }

    @Override // org.jivesoftware.smack.MessageListener
    public void processMessage(Message message) throws JSONException {
        String stanzaId = message.getStanzaId();
        String strU = WearUtils.u(message.getBody());
        String strT = T(strU);
        String strL = L(strU);
        String str = message.getFrom().split("/")[0];
        String str2 = message.getTo().split("/")[0];
        xe3.a("Message==>", "来自群消息：" + message.getRecId() + " " + stanzaId + " " + strL);
        StringBuilder sb = new StringBuilder();
        sb.append("收到3：");
        sb.append(WearUtils.g0(str));
        sb.append(" ");
        sb.append(message.getRecId());
        xe3.a("OffMsg", sb.toString());
        CommunMessage communMessageFindByReceiveId = DaoUtils.getCommunMessageDao().findByReceiveId(stanzaId);
        J0(WearUtils.A0(str), message.getRecId());
        if (communMessageFindByReceiveId != null) {
            return;
        }
        Date date = new Date();
        CommunMessage entity = new ContainBean(strL).getEntity();
        entity.setRealFrom(!TextUtils.isEmpty(entity.getRealFrom()) ? entity.getRealFrom().split("/")[0] : !TextUtils.isEmpty(entity.getFrom()) ? entity.getFrom().split("/")[0] : "");
        if (entity.getRealFrom().equals(ch3.n().u().getUserJid())) {
            CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(stanzaId);
            if (communMessageFindById != null) {
                communMessageFindById.setMsgId(message.getRecId());
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessageFindById);
                return;
            }
            return;
        }
        if (entity.getType() == MessageType.unsupport) {
            EntityUnSupport entityUnSupport = new EntityUnSupport();
            entityUnSupport.setOldType(strT);
            entityUnSupport.setMessageBody(entity.getData());
            entity.setData(CommunMessage.encryp(new Gson().toJson(entityUnSupport)));
            entity.setDataBean(entity.syncDecryptBean());
        } else {
            entity.setDataBean(entity.syncDecryptBean());
        }
        entity.setReceiveId(stanzaId);
        String id = entity.getId();
        if (TextUtils.isEmpty(id)) {
            id = WearUtils.E();
        }
        entity.setId(id);
        entity.setUserId(str2);
        entity.setSendStatus(0);
        entity.setCreated(date);
        entity.setFrom(str);
        entity.setTo(str2);
        entity.setMsgId(message.getRecId());
        hu3.p.j(false, strL, entity);
    }

    @Override // org.jivesoftware.smack.PresenceListener
    public void processPresence(Presence presence) {
        j0("Message==>", "出席状态来啦：" + presence.getFrom());
    }

    public boolean q(xb2 xb2Var) {
        boolean zAdd;
        synchronized (this.a) {
            zAdd = this.a.add(xb2Var);
        }
        return zAdd;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q0(com.wear.protocol.ContainBean r12) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.zb2.q0(com.wear.protocol.ContainBean):void");
    }

    public void r(String str) {
        String strG0 = WearUtils.g0(str);
        User userV = ch3.n().v(strG0);
        Account accountU = ch3.n().u();
        if (userV == null || accountU == null) {
            return;
        }
        this.t.removeCallbacksAndMessages(null);
        this.s = Boolean.TRUE;
        this.d = strG0;
        j0("Message==>", "开始检测");
        this.t.postDelayed(new n(accountU, userV, str), 5000L);
    }

    public void r0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.o.put(str, str2);
    }

    public final void s(User user, Account account) {
        String str;
        String str2 = "notReceiceOrder#" + nd3.r(user.getUserJid()) + "#" + user.getRemotePlatform() + "#" + user.getRemoteVersion() + "#socketio#" + account.getCurrentControlType();
        int i2 = this.u;
        if (i2 == 1 || i2 == 0) {
            str = str2 + "#disconnect#unknown#" + uf2.v().q() + "#" + user.getSupportType();
        } else if (i2 == 2) {
            str = str2 + "#connected#connected#" + uf2.v().q() + "#" + user.getSupportType();
        } else {
            str = str2 + "#connected#disconnect#" + uf2.v().q() + "#" + user.getSupportType();
        }
        j0("Message==>", "D0007:" + str);
        ye3.d("D0007", str);
        this.c = false;
        ep1.b().q(new gp1((Runnable) new o(user), true));
    }

    public final void s0(ContainBean containBean) throws NumberFormatException {
        if (containBean.getEntity().getType() == MessageType.chat) {
            K(containBean.getEntity().getFrom(), containBean.getEntity().getTo(), containBean.getEntity());
        }
        CommunMessage entity = containBean.getEntity();
        hu3.m(entity, true);
        entity.setFrom(WearUtils.i0(WearUtils.y.r()));
        String json = containBean.getJson();
        xe3.a("Message==>", "sendMessage:" + json);
        hu3.e0(entity, WearUtils.B(json));
        q0(containBean);
    }

    public final void t(CommunMessage communMessage) {
        String str;
        String str2;
        String str3;
        if (communMessage == null) {
            return;
        }
        NetworkInfo networkInfoB = hf3.b();
        String str4 = "notreachable#";
        if (networkInfoB != null && NetworkInfo.State.CONNECTED == networkInfoB.getState() && networkInfoB.isAvailable()) {
            str4 = (networkInfoB.getType() == 1 || networkInfoB.getType() == 0) ? networkInfoB.getType() == 1 ? "wifi#" : "wwan#" : "unknown#";
        }
        if (MyApplication.P) {
            str = str4 + "status_online#";
        } else {
            str = str4 + "offline#";
        }
        User userV = ch3.n().v(WearUtils.g0(communMessage.getTo()));
        if (userV == null || !userV.isRealOnLine()) {
            str2 = str + "offline#";
        } else {
            str2 = str + "status_online#";
        }
        String str5 = str2 + communMessage.getLogType() + "#";
        if (userV == null) {
            str3 = str5 + "null#null";
        } else {
            str3 = str5 + userV.getRemotePlatform() + "#" + userV.getRemoteVersion();
        }
        ye3.d("S0004", str3);
        WearUtils.x.q("messageFailed_15_" + communMessage.getLogType(), null);
        j0("Message==>", "S0004:" + str3 + "  messageFailed_15_" + communMessage.getLogType());
    }

    public boolean t0(xb2 xb2Var) {
        boolean zRemove;
        synchronized (this.a) {
            zRemove = this.a.remove(xb2Var);
        }
        return zRemove;
    }

    public final void u(final BroadDataBean broadDataBean, Group group) {
        if (group == null || !group.iIsAdamin()) {
            return;
        }
        this.g.removeCallbacksAndMessages(null);
        this.g.postDelayed(new Runnable() { // from class: dc.tb2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0(broadDataBean);
            }
        }, this.j);
    }

    public final void u0(BroadDataBean broadDataBean, long j2, Group group, GroupMember groupMember) {
        if (groupMember != null) {
            groupMember.setAffiliation(10);
        }
        w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        if (group != null) {
            group.removeMemberByJid(broadDataBean.getByWho());
        }
    }

    public final void v(boolean z2, boolean z3) {
        String str;
        String str2;
        String str3;
        String str4;
        SwitchBeanFeaturesConfig.VersionEntity versionEntityD = og3.d();
        int status = versionEntityD == null ? 0 : versionEntityD.getStatus();
        if (Y()) {
            if (status == 0) {
                str4 = "init#rm_openfire";
            } else {
                str4 = "init#rm_socketio";
            }
            ye3.d("D0005", str4);
            return;
        }
        if (z2) {
            if (status == 0) {
                str3 = "init#rm_openfire";
            } else {
                str3 = "init#rm_socketio";
            }
            ye3.d("D0006", str3);
            return;
        }
        if (z3) {
            if (status == 0) {
                str2 = "changed by friend disconnect#rm_openfire";
            } else {
                str2 = "changed by friend disconnect#rm_socketio";
            }
            ye3.d("D0006", str2);
            return;
        }
        if (status == 0) {
            str = "changed by me disconnect#rm_openfire";
        } else {
            str = "changed by me disconnect#rm_socketio";
        }
        ye3.d("D0006", str);
    }

    public final void v0(BroadDataBean broadDataBean, long j2, Group group) {
        w(broadDataBean, broadDataBean.getMsgId(), j2, true);
        if (group != null) {
            if (!broadDataBean.getWho().equals(ch3.n().p())) {
                group.removeMemberByJid(broadDataBean.getWho());
                return;
            }
            group.setStatus(4);
            group.setByWho(broadDataBean.getByWhoNickName());
            m0(WearUtils.k0(broadDataBean.getRoomId()));
            EventBus.getDefault().post(new GroupStatusEvent(broadDataBean.getRoomId()));
        }
    }

    public final void w(BroadDataBean broadDataBean, String str, long j2, boolean z2) {
        if (DaoUtils.getCommunMessageDao().findByMsgId(str) != null) {
            return;
        }
        EntitySystem entitySystem = new EntitySystem();
        CommunMessage communMessage = new CommunMessage();
        if (z2) {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C10001.toString(), entitySystem.getJSONText(broadDataBean));
            i0(communMessage);
        } else {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C10001.toString(), entitySystem.getJSONText(broadDataBean));
        }
        communMessage.setFrom(WearUtils.k0(broadDataBean.getRoomId()));
        communMessage.setTo(WearUtils.y.p());
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        communMessage.setMsgId(str);
        communMessage.setCreated(new Date(j2));
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
    }

    public final CommunMessage w0(String str) {
        synchronized (this.k) {
            u uVarRemove = this.k.remove(str);
            if (uVarRemove != null) {
                uVarRemove.a.sendSuc();
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) uVarRemove.a);
                MessageSendEvent messageSendEvent = new MessageSendEvent();
                messageSendEvent.msg = uVarRemove.a;
                EventBus.getDefault().post(messageSendEvent);
                return uVarRemove.a;
            }
            CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(str);
            if (communMessageFindById == null || communMessageFindById.isSendSuc()) {
                return null;
            }
            communMessageFindById.sendSuc();
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessageFindById);
            MessageSendEvent messageSendEvent2 = new MessageSendEvent();
            messageSendEvent2.msg = communMessageFindById;
            EventBus.getDefault().post(messageSendEvent2);
            return communMessageFindById;
        }
    }

    public void x(CommunMessage communMessage) {
        u uVar;
        synchronized (this.k) {
            if (this.k.containsKey(communMessage.getId())) {
                uVar = this.k.get(communMessage.getId());
            } else {
                uVar = new u(null);
                uVar.b = 0;
            }
            uVar.a = communMessage;
            this.k.put(communMessage.getId(), uVar);
        }
    }

    public void x0(DataEntityAbstract dataEntityAbstract, User user, String str, String str2) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setFrom(str);
        communMessage.setTo(str2);
        if (user.isDateIng()) {
            communMessage.setSendType(2);
        }
        if (O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            O().i0(communMessage);
        }
    }

    public final boolean y(BroadDataBean broadDataBean, long j2) {
        String who = broadDataBean.getWho();
        if (X(who)) {
            return true;
        }
        EntitySystem entitySystem = new EntitySystem();
        EntitySystem.C10001Json c10001Json = new EntitySystem.C10001Json();
        c10001Json.setRoomId(broadDataBean.getRoomId());
        c10001Json.setAfiiliatation(broadDataBean.getAffiliation());
        c10001Json.setOperationType(RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED);
        c10001Json.setByWho(broadDataBean.getByWho());
        c10001Json.setByWhoNickName(broadDataBean.getByWhoNickName());
        ArrayList arrayList = new ArrayList();
        EntitySystem.C10001Json.WhoBean whoBean = new EntitySystem.C10001Json.WhoBean();
        whoBean.setWho(who);
        whoBean.setWhoNickName(broadDataBean.getWhoNickName());
        arrayList.add(whoBean);
        c10001Json.setWhos(arrayList);
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C10001.toString(), JSON.toJSONString(c10001Json));
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.k0(broadDataBean.getRoomId()));
        communMessage.setTo(WearUtils.y.p());
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        communMessage.setCreated(new Date(j2));
        communMessage.setMsgId(broadDataBean.getMsgId());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        i0(communMessage);
        return false;
    }

    public void y0(CommunMessage communMessage) {
        vg3.b().a(new t(this, communMessage));
    }

    public final boolean z(BroadDataBean broadDataBean, long j2) {
        String who = broadDataBean.getWho();
        if (X(who)) {
            return true;
        }
        EntitySystem entitySystem = new EntitySystem();
        EntitySystem.C10001Json c10001Json = new EntitySystem.C10001Json();
        c10001Json.setRoomId(broadDataBean.getRoomId());
        c10001Json.setAfiiliatation(broadDataBean.getAffiliation());
        c10001Json.setOperationType(RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION);
        ArrayList arrayList = new ArrayList();
        EntitySystem.C10001Json.WhoBean whoBean = new EntitySystem.C10001Json.WhoBean();
        whoBean.setWho(who);
        whoBean.setWhoNickName(broadDataBean.getWhoNickName());
        arrayList.add(whoBean);
        c10001Json.setWhos(arrayList);
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C10001.toString(), JSON.toJSONString(c10001Json));
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.k0(broadDataBean.getRoomId()));
        communMessage.setTo(WearUtils.y.p());
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(ch3.n().p());
        communMessage.setCreated(new Date(j2));
        communMessage.setMsgId(broadDataBean.getMsgId());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        i0(communMessage);
        return false;
    }

    public void z0(String str, DataEntityAbstract dataEntityAbstract) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        y0(communMessage);
    }
}
