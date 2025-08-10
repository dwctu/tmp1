package dc;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.LastLoginInfoBean;
import com.wear.bean.MatchResult;
import com.wear.bean.PushChatLogRecordBean;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.XYBean;
import com.wear.bean.event.GroupStatusEvent;
import com.wear.bean.event.MessageSendEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.event.VCardChangeEvent;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.SensitiveWordDao;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToySearchActivity;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.ContainBean;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityGiftCard;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityVMShareCard;
import com.wear.protocol.EntityWishList;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.DefaultExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterLoadedListener;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.bean.BaseRequestIQ;
import org.jivesoftware.smackx.disco.bean.BaseResIQ;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomList;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomMembers;
import org.jivesoftware.smackx.disco.bean.request.RequestRoominfoMembers;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomList;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomMembers;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoominfoMembers;
import org.jivesoftware.smackx.disco.bean.response.Room;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jivesoftware.smackx.offline.OfflineMessageManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscription;

/* compiled from: SmackConnection.java */
/* loaded from: classes4.dex */
public class hu3 {
    public static final String n = "hu3";
    public static XMPPTCPConnection o;
    public static gu3 p;
    public static hu3 q;
    public static MyApplication r;
    public static ChatManager s;
    public static Roster t;
    public static Timer u;
    public static String v;
    public static MultiUserChatManager w;
    public static HashMap<String, String> x;
    public String b;
    public String c;
    public String d;
    public String e;
    public VCardManager f;
    public iu3 g;
    public fu3 h;
    public ju3 i;
    public mu3 j;
    public lu3 k;
    public r l;
    public List<bu3> a = new ArrayList();
    public q m = new h();

    /* compiled from: SmackConnection.java */
    public class a implements Runnable {
        public final /* synthetic */ ContainBean a;

        public a(ContainBean containBean) {
            this.a = containBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.f0(this.a);
        }
    }

    /* compiled from: SmackConnection.java */
    public class b implements Callback<bd4> {
        @Override // retrofit2.Callback
        public void onFailure(Call<bd4> call, Throwable th) {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<bd4> call, Response<bd4> response) {
        }
    }

    /* compiled from: SmackConnection.java */
    public class c implements kv1 {
        public final /* synthetic */ boolean a;

        public c(hu3 hu3Var, boolean z) {
            this.a = z;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseRoomList responseRoomList = (ResponseRoomList) JSON.parseObject(str, ResponseRoomList.class);
            Map<String, Group> mapL = ch3.n().l();
            if (responseRoomList.getRooms() == null || responseRoomList.getRooms().size() == 0) {
                mapL.clear();
            }
            List<Room> rooms = responseRoomList.getRooms();
            Iterator it = new ArrayList(mapL.keySet()).iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                Iterator<Room> it2 = rooms.iterator();
                while (it2.hasNext()) {
                    if (it2.next().getRoomId().equals(str2)) {
                        z = true;
                    }
                }
                if (!z) {
                    mapL.remove(str2);
                }
            }
            Iterator<Room> it3 = rooms.iterator();
            while (true) {
                String str3 = "";
                if (!it3.hasNext()) {
                    ye3.E();
                    EventBus.getDefault().post(new UserUpdateEvent(""));
                    return;
                }
                Room next = it3.next();
                String roomId = next.getRoomId();
                Group group = mapL.get(roomId);
                if (group == null) {
                    group = new Group(roomId);
                }
                group.setName(next.getRoomName());
                group.setStatus(next.getStatus());
                group.setByWho(next.getByWho());
                group.setRns(next.getRns());
                group.setEnterTime(next.getEnterTime());
                group.setUrl(tg3.c(next.getUrl()));
                group.setMcs(tg3.c(next.getMcs()));
                group.setBanType(next.getBanType());
                String rps = next.getRps();
                if (rps != null) {
                    String str4 = "";
                    for (String str5 : rps.split(",")) {
                        if (!TextUtils.isEmpty(str5) && !str5.contains("UploadFiles/wear/avatar")) {
                            try {
                                String str6 = new String(Base64.decode(str5), "ISO-8859-1");
                                str5 = (TextUtils.isEmpty(str6) || str6.length() > 512) ? "" : str6;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        str4 = str4 + str5 + ",";
                    }
                    str3 = str4;
                }
                if (!TextUtils.isEmpty(str3)) {
                    group.setRps(str3.substring(0, str3.length() - 1));
                }
                mapL.put(roomId, group);
                if (!group.isExit() && this.a) {
                    zb2.O().P(roomId);
                }
                EventBus.getDefault().post(new GroupStatusEvent(group.getId()));
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            ye3.E();
        }
    }

    /* compiled from: SmackConnection.java */
    public class d implements kv1 {
        public final /* synthetic */ bv1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public d(bv1 bv1Var, String str, boolean z) {
            this.a = bv1Var;
            this.b = str;
            this.c = z;
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseRoominfoMembers responseRoominfoMembers = (ResponseRoominfoMembers) JSON.parseObject(str, ResponseRoominfoMembers.class);
            if (!responseRoominfoMembers.suc()) {
                bv1 bv1Var = this.a;
                if (bv1Var != null) {
                    bv1Var.r1(this.b);
                    return;
                }
                return;
            }
            Room room = responseRoominfoMembers.getData().getRoom();
            String roomId = room.getRoomId();
            Group groupK = ch3.n().k(roomId);
            if (groupK == null) {
                groupK = new Group(roomId);
                ch3.n().l().put(roomId, groupK);
            }
            if (!TextUtils.isEmpty(room.getRoomName())) {
                groupK.setName(room.getRoomName());
            }
            groupK.setUrl(tg3.c(room.getUrl()));
            groupK.setMcs(tg3.c(room.getMcs()));
            String strB = tg3.b(room.getRps());
            if (!TextUtils.isEmpty(strB)) {
                groupK.setRps(strB);
            }
            if (!TextUtils.isEmpty(room.getByWho())) {
                groupK.setByWho(room.getByWho());
            }
            if (!TextUtils.isEmpty(room.getRns())) {
                groupK.setRns(room.getRns());
            }
            groupK.setBanType(room.getBanType());
            groupK.setStatus(room.getStatus());
            groupK.setEnterTime(room.getEnterTime());
            hu3.this.S(groupK, responseRoominfoMembers.getData().getUsers());
            bv1 bv1Var2 = this.a;
            if (bv1Var2 != null) {
                bv1Var2.Q(roomId);
            }
            if (this.c) {
                zb2.O().P(roomId);
            }
            EventBus.getDefault().post(new UserUpdateEvent(""));
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            bv1 bv1Var = this.a;
            if (bv1Var != null) {
                bv1Var.r1(this.b);
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class e implements kv1 {
        public e() {
        }

        @Override // dc.kv1
        public void a(String str) {
            ResponseRoomMembers responseRoomMembers = (ResponseRoomMembers) JSON.parseObject(str, ResponseRoomMembers.class);
            if (responseRoomMembers.suc()) {
                for (ResponseRoomMembers.RoomsBean roomsBean : responseRoomMembers.getRooms()) {
                    Group groupK = ch3.n().k(roomsBean.getRoomId());
                    if (groupK != null && !groupK.isExit()) {
                        zb2.O().P(groupK.getId());
                    }
                    hu3.this.S(groupK, roomsBean.getUsers());
                }
                ye3.G();
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            ye3.G();
        }
    }

    /* compiled from: SmackConnection.java */
    public class f implements Runnable {
        public final /* synthetic */ BaseRequestIQ a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ kv1 c;

        public f(hu3 hu3Var, BaseRequestIQ baseRequestIQ, Object obj, kv1 kv1Var) {
            this.a = baseRequestIQ;
            this.b = obj;
            this.c = kv1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BaseResIQ baseResIQ = (BaseResIQ) hu3.o.createPacketCollectorAndSend(this.a).nextResultOrThrow();
                zb2.O().j0("Message==>", "接口：" + this.a.toString());
                zb2.O().j0("Message==>", "参数：" + JSON.toJSONString(this.b));
                zb2.O().j0("Message==>", "结果：" + baseResIQ.getBody());
                kv1 kv1Var = this.c;
                if (kv1Var != null) {
                    kv1Var.a((String) baseResIQ.getBody());
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    kv1 kv1Var2 = this.c;
                    if (kv1Var2 != null) {
                        kv1Var2.onError(e);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class g implements zn2<String> {
        public final /* synthetic */ yn2 a;

        public g(hu3 hu3Var, yn2 yn2Var) {
            this.a = yn2Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            LastLoginInfoBean lastLoginInfoBean = (LastLoginInfoBean) WearUtils.A.fromJson(str, LastLoginInfoBean.class);
            if (lastLoginInfoBean == null || lastLoginInfoBean.getData() == null || TextUtils.isEmpty(lastLoginInfoBean.getData().getSessionId())) {
                this.a.onError(new NetException(NetException.NULL_PORINT_ERROR, "data is null"));
            } else {
                this.a.onSuccess(lastLoginInfoBean.getData().getSessionId());
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            this.a.onError(netException);
        }
    }

    /* compiled from: SmackConnection.java */
    public class h implements q {
        public h() {
        }

        @Override // dc.hu3.q
        public void a(String str) {
            MyApplication.P = false;
            MyApplication.Q = 2;
            ye3.d("A0006", "");
            ye3.p(0, 9, NetException.XMPP_CONNECT_ERROR_EXCEPTION, str != null ? str.toString() : "");
            hu3.this.t(ah4.e(R.string.userdata_error_text));
            if (hf3.d(hu3.r) || !(MyApplication.H() instanceof LoginActivity)) {
                return;
            }
            hf3.f(MyApplication.H());
        }

        @Override // dc.hu3.q
        public void connectSuc() {
            hu3 hu3Var = hu3.this;
            hu3Var.o0(hu3Var.b, hu3Var.c, hu3Var.d, hu3Var.e);
        }
    }

    /* compiled from: SmackConnection.java */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = MyApplication.Q;
                if (i != 0 && i != 1 && !MyApplication.P) {
                    hu3.this.l0();
                }
                uf2.v().B();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class j extends TimerTask {

        /* compiled from: SmackConnection.java */
        public class a implements yn2<String> {
            public a() {
            }

            @Override // dc.yn2, dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                if (str.equals(ye3.x())) {
                    hu3.this.Y();
                    return;
                }
                MyApplication.Q = 0;
                sg3.i(hu3.r, R.string.system_account_single);
                ep1.b().g();
            }

            @Override // dc.yn2
            public void onCompleted() {
            }

            @Override // dc.yn2, dc.zn2
            public void onError(NetException netException) {
                hu3.this.Y();
            }

            @Override // dc.yn2
            public void onStart() {
            }
        }

        public j() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = MyApplication.Q;
            if (i == 0) {
                ep1.b().e("loginFlag==0");
            } else if (i == 2 || !MyApplication.P) {
                hu3.this.W(new a());
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class k implements Runnable {
        public k(hu3 hu3Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ep1.b().e("说明认证，单纯掉线");
                try {
                    ye3.d("A0002", se3.b(WearUtils.x));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                hu3.o.connect();
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                hu3.this.n0();
                ep1.b().e("5555");
            } catch (Exception e) {
                ep1.b().e("6666");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SmackConnection.java */
    public class m implements HostnameVerifier {
        public m(hu3 hu3Var) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: SmackConnection.java */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            hu3.this.M();
            hu3.this.K();
            EventBus.getDefault().post(hu3.t.getEntries());
            hu3.T();
        }
    }

    /* compiled from: SmackConnection.java */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            Map<String, User> mapY = WearUtils.y.y();
            if (mapY != null) {
                for (Map.Entry<String, User> entry : mapY.entrySet()) {
                    if (entry.getValue() != null && WearUtils.e1(entry.getValue().getUserName())) {
                        XYBean xYBeanQ0 = WearUtils.Q0();
                        String str = "xyBean.x: " + xYBeanQ0.x + "   xyBean.y: " + xYBeanQ0.y + "  邮箱：" + entry.getValue().getId();
                        String strX = nd3.x(entry.getValue().getId(), xYBeanQ0.x, xYBeanQ0.y);
                        String str2 = "encipherString: " + strX;
                        arrayList.add(strX);
                    }
                }
            }
            String unused = hu3.n;
            String str3 = "loadUserNameByApiV2 userEmailList: " + arrayList.size();
            hu3.this.O(arrayList);
        }
    }

    /* compiled from: SmackConnection.java */
    public class p implements zn2<String> {
        public final /* synthetic */ List a;

        public p(hu3 hu3Var, List list) {
            this.a = list;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            User userV;
            String unused = hu3.n;
            String str2 = "loadUserNameByApiV2 response: " + str;
            if (WearUtils.e1(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean zOptBoolean = jSONObject.optBoolean("result");
                String strOptString = jSONObject.optString("data", "");
                if (!zOptBoolean || WearUtils.e1(strOptString)) {
                    return;
                }
                HashMap map = (HashMap) WearUtils.A.fromJson(strOptString, HashMap.class);
                String unused2 = hu3.n;
                String str3 = "onSuccess: " + map.size();
                if (map.size() > 0) {
                    for (String str4 : this.a) {
                        XYBean xYBeanQ0 = WearUtils.Q0();
                        String str5 = "xyBean.x: " + xYBeanQ0.x + "   xyBean.y: " + xYBeanQ0.y + "  解密前的数据：" + ((String) map.get(str4));
                        String strK = nd3.k((String) map.get(str4), xYBeanQ0.x, xYBeanQ0.y);
                        if (!WearUtils.e1(strK) && (userV = WearUtils.y.v(str4)) != null) {
                            userV.setName(strK);
                            String unused3 = hu3.n;
                            String str6 = "ttttt_updateUser: " + userV.getRemoteAccountId();
                            DaoUtils.getUserDao().update(userV);
                        }
                    }
                    EventBus.getDefault().post(new UserUpdateEvent(""));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            String unused = hu3.n;
            String str = "loadUserNameByApiV2 onError: " + netException.getMessage();
        }
    }

    /* compiled from: SmackConnection.java */
    public interface q {
        void a(String str);

        void connectSuc();
    }

    /* compiled from: SmackConnection.java */
    public interface r {
        void a(String str);
    }

    /* compiled from: SmackConnection.java */
    public interface s {
        void a();
    }

    public hu3(Context context) {
        r = (MyApplication) context.getApplicationContext();
        this.g = new iu3(this);
        p = new gu3();
        this.h = new fu3();
        this.i = new ju3(this);
        this.j = new mu3(this);
        this.k = new lu3(this);
        m0();
    }

    public static void B() {
        XMPPTCPConnection xMPPTCPConnection;
        try {
            if (r != null && q != null && (xMPPTCPConnection = o) != null && xMPPTCPConnection.isConnected() && o.isAuthenticated()) {
                zb2.O().j0("Message==>", "开始获取离线消息");
                OfflineMessageManager offlineMessageManager = new OfflineMessageManager(o);
                List<Message> messages = offlineMessageManager.getMessages();
                zb2.O().j0("Message==>", "离线消息数量: " + offlineMessageManager.getMessageCount());
                for (Message message : messages) {
                    String str = message.getFrom().split("/")[0];
                    String str2 = message.getTo().split("/")[0];
                    Date date = new Date();
                    String stanzaId = message.getStanzaId();
                    if (DaoUtils.getCommunMessageDao().findByReceiveId(stanzaId) != null) {
                        return;
                    }
                    try {
                        p.l(false, WearUtils.u(message.getBody()), str, str2, stanzaId, date);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                offlineMessageManager.deleteMessages();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static Roster C() {
        return t;
    }

    public static void D(String str, boolean z) {
        Presence presence = new Presence(z ? Presence.Type.subscribed : Presence.Type.unsubscribed);
        presence.setTo(WearUtils.i0(str));
        try {
            XMPPTCPConnection xMPPTCPConnection = o;
            if (xMPPTCPConnection != null) {
                xMPPTCPConnection.sendStanza(presence);
            }
        } catch (SmackException.NotConnectedException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean E(EntitySystem.EntityArray entityArray) {
        if (entityArray.getType() == null || entityArray.getCode() == null || !EntitySystem.SystemOPTType.T300.toString().equals(entityArray.getType())) {
            return false;
        }
        return EntitySystem.SystemOPTCode.C306.toString().equals(entityArray.getCode()) || EntitySystem.SystemOPTCode.C307.toString().equals(entityArray.getCode());
    }

    public static /* synthetic */ void F(String str, String str2, MatchResult matchResult) {
        if (matchResult == null || !matchResult.isReg()) {
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(str);
        communMessage.setTo(str2);
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

    public static /* synthetic */ void G(s sVar, Roster roster) {
        Set<RosterEntry> entries = roster.getEntries();
        ep1.b().e("花名册数量：" + entries.size());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, User> mapY = ch3.n().y();
        for (RosterEntry rosterEntry : entries) {
            String user = rosterEntry.getUser();
            String strG0 = WearUtils.g0(user);
            if (rosterEntry.getType().equals(RosterPacket.ItemType.to)) {
                Presence presence = new Presence(Presence.Type.subscribed);
                presence.setTo(rosterEntry.getUser());
                try {
                    o.sendStanza(presence);
                } catch (SmackException.NotConnectedException e2) {
                    e2.printStackTrace();
                }
            }
            User userFindById = mapY.get(strG0);
            if (userFindById == null || WearUtils.e1(userFindById.getRemoteAccountId())) {
                userFindById = DaoUtils.getUserDao().findById(strG0);
            }
            if (userFindById == null) {
                userFindById = new User(strG0);
                DaoUtils.getUserDao().add(userFindById);
            }
            if (!WearUtils.e1(rosterEntry.getName())) {
                userFindById.setName(rosterEntry.getName());
            } else if (WearUtils.e1(userFindById.getUserName())) {
                userFindById.setName(WearUtils.L0());
            }
            String str = "ttttt_startRealLogin: " + userFindById.getRemoteAccountId();
            DaoUtils.getUserDao().update(userFindById);
            Presence presence2 = roster.getPresence(user);
            userFindById.setOnline(presence2.isAvailable());
            userFindById.setStatusMode(presence2.getMode());
            if (RosterPacket.ItemStatus.subscribe.equals(rosterEntry.getStatus())) {
                userFindById.addFriendType(2);
                if (RosterPacket.ItemType.remove.equals(rosterEntry.getType())) {
                    userFindById.addFriendType(8);
                }
            } else if (RosterPacket.ItemType.remove.equals(rosterEntry.getType())) {
                userFindById.addFriendType(8);
            }
            if (RosterPacket.ItemType.both.equals(rosterEntry.getType()) || RosterPacket.ItemType.from.equals(rosterEntry.getType()) || RosterPacket.ItemType.to.equals(rosterEntry.getType())) {
                userFindById.resetFriendType(1);
            }
            concurrentHashMap.put(userFindById.getId(), userFindById);
        }
        WearUtils.y.W(concurrentHashMap);
        ep1.b().e("user处理完成");
        if (sVar != null) {
            sVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(String str, String str2, String str3, String str4) {
        String str5;
        p(false);
        df3.e().i();
        ep1.b().e("group处理完成");
        Account accountU = ch3.n().u();
        String str6 = WearUtils.e1(str) ? str2 : str;
        if (accountU == null || !str6.equals(accountU.getId())) {
            accountU = new Account(str6);
        }
        Presence presence = new Presence(Presence.Type.available);
        Presence.Mode mode = Presence.Mode.chat;
        presence.setMode(mode);
        VCardManager instanceFor = VCardManager.getInstanceFor(o);
        this.f = instanceFor;
        try {
            VCard vCardLoadVCard = instanceFor.loadVCard();
            if (!WearUtils.e1(ch3.n().o().getRemoteAccountId())) {
                vCardLoadVCard.setRemoteAccountId(ch3.n().o().getRemoteAccountId());
            }
            if (WearUtils.e1(vCardLoadVCard.getField("REMOTEACCOUNTID"))) {
                vCardLoadVCard.setField("REMOTEACCOUNTID", ch3.n().o().getRemoteAccountId());
            }
            if (!WearUtils.e1(str3) && (WearUtils.e1(vCardLoadVCard.getNickName()) || !str3.equals(vCardLoadVCard.getNickName()))) {
                vCardLoadVCard.setNickName(str3);
            }
            if (!WearUtils.e1(str3)) {
                accountU.setName(str3);
            } else if (!WearUtils.e1(vCardLoadVCard.getNickName())) {
                accountU.setName(vCardLoadVCard.getNickName());
            }
            if (vCardLoadVCard.isErrorAvatar()) {
                str5 = "user_device";
                WearUtils.r2(vCardLoadVCard.getAvatarTemp(), accountU);
                vCardLoadVCard.setAvatar("", MimeTypes.IMAGE_JPEG);
            } else if (WearUtils.i1(vCardLoadVCard.getAvatar())) {
                str5 = "user_device";
                WearUtils.r2("", accountU);
                vCardLoadVCard.setAvatar("", MimeTypes.IMAGE_JPEG);
            } else {
                str5 = "user_device";
                String str7 = new String(vCardLoadVCard.getAvatar(), "ISO-8859-1");
                if (WearUtils.e1(str7) || str7.length() > 512) {
                    WearUtils.r2("", accountU);
                    vCardLoadVCard.setAvatar(accountU.getAvatar().getBytes(), MimeTypes.IMAGE_JPEG);
                } else {
                    WearUtils.r2(str7, accountU);
                }
            }
            String field = vCardLoadVCard.getField("DEVICETOKEN");
            String field2 = vCardLoadVCard.getField("APPVERSION");
            accountU.setGender(vCardLoadVCard.getField("SEX"));
            accountU.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
            accountU.setAge(vCardLoadVCard.getField("AGE"));
            vCardLoadVCard.setField("GMTTIME", be3.o());
            accountU.setUserCode(vCardLoadVCard.getField("USERID"));
            MyApplication.W = FirebaseInstanceId.getInstance().getToken();
            vCardLoadVCard.setField("DEVICETOKEN", "nodevicetoken");
            re3.v(MyApplication.W);
            vCardLoadVCard.setField("DEVICETYPE", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            vCardLoadVCard.setField("APPVERSION", WearUtils.q);
            vCardLoadVCard.setField("ISSUPPORTGROUP", ch3.n().o().getIsSupportGroup() + "");
            if (WearUtils.e1(vCardLoadVCard.getField("ADDFRIENDFROMGROUP"))) {
                vCardLoadVCard.setField("ADDFRIENDFROMGROUP", "1");
            }
            accountU.setAddFriendFromGroup(vCardLoadVCard.getField("ADDFRIENDFROMGROUP"));
            accountU.setDeviceToken(MyApplication.W);
            accountU.setDeviceType(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            accountU.setDeviceAppVersion(WearUtils.q);
            this.f.saveVCard(vCardLoadVCard);
            if (!WearUtils.e1(MyApplication.W) && !MyApplication.W.equals(field)) {
                presence.addExtension(new DefaultExtensionElement("reloadVCard", null));
            } else if (!WearUtils.e1(WearUtils.q) && !WearUtils.q.equals(field2)) {
                presence.addExtension(new DefaultExtensionElement("reloadVCard", null));
            }
            x0(MyApplication.W);
            ye3.A();
            accountU.setPassword(str4);
            accountU.setEmailAndPassMd5(WearUtils.r0(str2 + "||" + WearUtils.r0(str4)));
            WearUtils.y.V(accountU);
            LoginUserBean loginUserBeanO = ch3.n().o();
            if (loginUserBeanO != null) {
                me3.h(loginUserBeanO.getAppAccountCode());
            }
            int iF = eg3.f(r, "init_on_line_status" + accountU.getId(), 0);
            if (iF == 1) {
                Presence.Mode mode2 = Presence.Mode.dnd;
                accountU.setStatusMode(mode2);
                presence.setMode(mode2);
            } else if (iF == 2) {
                Presence.Mode mode3 = Presence.Mode.away;
                accountU.setStatusMode(mode3);
                presence.setMode(mode3);
            } else {
                accountU.setStatusMode(mode);
                presence.setMode(mode);
            }
            ob2.o().H(0);
            o.sendStanza(presence);
            zd3.d(r, "xmpp_email", str2 + WearUtils.H1());
            zd3.d(r, "xmpp_password", str4);
            ye3.Y(str2);
            ye3.p(1, 11, null, null);
            String str8 = str5;
            String strH = eg3.h(r, str8, "");
            String strQ = ye3.q();
            if (!strQ.equals(strH)) {
                eg3.i(r, str8, strQ);
            }
            EventBus.getDefault().post(new UserUpdateEvent(""));
            MyApplication.Q = 3;
            Q(ah4.e(R.string.login_success));
            vg3.b().a(new n());
            EventBus.getDefault().post(new VCardChangeEvent());
        } catch (SmackException.NoResponseException e2) {
            o(e2, "A0003", 12, NetException.XMPP_LOGIN_ERROR_TIME);
        } catch (Exception e3) {
            o(e3, "A0004", 12, NetException.XMPP_LOGIN_ERROR_EXCEPTION);
        }
    }

    public static void R(Context context) {
        if (WearUtils.e1(eg3.h(WearUtils.x, "gen_token_Key", "")) || WearUtils.e1(WearUtils.t) || WearUtils.y.u() == null) {
            return;
        }
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(WearUtils.e).build();
        String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
        ((sn2) retrofitBuild.create(sn2.class)).a("/app/config/messagePush", strI != null ? strI : "", WearUtils.q, new HashMap()).enqueue(new b());
    }

    public static boolean T() {
        Presence.Mode statusMode;
        Toy next;
        String lowerCase;
        if (r == null || q == null || o == null || MyApplication.Q != 3) {
            return false;
        }
        try {
            statusMode = WearUtils.y.u().getStatusMode();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (MyApplication.H() instanceof ToySearchActivity) {
            return false;
        }
        ArrayList<Toy> arrayListO = r.G().o();
        if (arrayListO.size() > 0) {
            Iterator<Toy> it = arrayListO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.isConnected() && next.isSelect()) {
                    break;
                }
            }
            if (next == null) {
                next = arrayListO.get(0);
            }
        } else {
            next = null;
        }
        if (next == null) {
            Presence presence = new Presence(Presence.Type.available);
            presence.setMode(statusMode);
            try {
                XMPPTCPConnection xMPPTCPConnection = o;
                if (xMPPTCPConnection != null && xMPPTCPConnection.isConnected()) {
                    o.sendStanza(presence);
                }
            } catch (SmackException.NotConnectedException e3) {
                e3.printStackTrace();
            }
        }
        Presence presence2 = new Presence(Presence.Type.available);
        presence2.setMode(statusMode);
        DefaultExtensionElement defaultExtensionElement = new DefaultExtensionElement("toy", null);
        String realType = "";
        String deviceType = next == null ? "" : next.getDeviceType();
        if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
            lowerCase = "";
        } else {
            lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
            if (lowerCase.endsWith(";")) {
                lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
            }
        }
        defaultExtensionElement.setValue("deviceId", lowerCase);
        if (next != null) {
            realType = next.getRealType();
        }
        defaultExtensionElement.setValue("name", realType);
        String str = "false";
        if (next != null && next.getStatus() == 1) {
            str = "true";
        }
        defaultExtensionElement.setValue("status", str);
        defaultExtensionElement.setValue("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        defaultExtensionElement.setValue("version", ye3.s());
        presence2.addExtension(defaultExtensionElement);
        SyncLinkToy syncLinkToy = new SyncLinkToy();
        syncLinkToy.setPlatform(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        syncLinkToy.setV(100);
        syncLinkToy.setVersion(ye3.s());
        if (arrayListO.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Toy toy : arrayListO) {
                SyncLinkToy.ToysBean toysBeanFromToy = SyncLinkToy.getToysBeanFromToy(toy);
                if (toy.isSupportLdr()) {
                    toysBeanFromToy.setIsSupportLdr(1);
                }
                if (toy.isSelect()) {
                    syncLinkToy.addToys(toysBeanFromToy);
                }
            }
            presence2.addExtensions(arrayList);
        }
        DefaultExtensionElement defaultExtensionElement2 = new DefaultExtensionElement("lovense", null);
        HashMap<String, Object> mapA = td3.c().a();
        if (mapA != null && mapA.size() > 0) {
            syncLinkToy.setChat(mapA);
        }
        defaultExtensionElement2.setValue("data", y(WearUtils.A.toJson(syncLinkToy)));
        if (syncLinkToy.getToys() != null && syncLinkToy.getToys().size() > 2) {
            presence2.addExtension(new DefaultExtensionElement("multitoy", null));
        }
        presence2.addExtension(defaultExtensionElement2);
        try {
            XMPPTCPConnection xMPPTCPConnection2 = o;
            if (xMPPTCPConnection2 != null && xMPPTCPConnection2.isConnected()) {
                o.sendStanza(presence2);
            }
        } catch (SmackException.NotConnectedException e4) {
            e4.printStackTrace();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void U(com.wear.protocol.ContainBean r11) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.hu3.U(com.wear.protocol.ContainBean):void");
    }

    public static void V(String str) {
        String strR = nd3.r(ch3.n().u().getUserJid());
        if (WearUtils.e1(v)) {
            v = eg3.h(WearUtils.x, strR + "_pushChatLogRecord", "");
        }
        boolean z = false;
        be3.b.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        String str2 = be3.b.format(Long.valueOf(System.currentTimeMillis()));
        Gson gson = new Gson();
        PushChatLogRecordBean pushChatLogRecordBean = (PushChatLogRecordBean) gson.fromJson(v, PushChatLogRecordBean.class);
        boolean z2 = true;
        if (pushChatLogRecordBean != null) {
            if (str2.equals(pushChatLogRecordBean.getPushDate())) {
                if (!pushChatLogRecordBean.getListJid().contains(str)) {
                }
                z2 = z;
            } else {
                pushChatLogRecordBean.getListJid().clear();
                pushChatLogRecordBean.setPushDate(str2);
            }
            z = true;
            z2 = z;
        } else {
            pushChatLogRecordBean = new PushChatLogRecordBean();
            pushChatLogRecordBean.setPushDate(str2);
        }
        if (z2) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("chat_type", (Object) 30);
            jSONObject.put("receiver_jid", (Object) str);
            ye3.d("F0014", jSONObject.toJSONString());
            pushChatLogRecordBean.getListJid().add(str);
            v = gson.toJson(pushChatLogRecordBean);
            eg3.i(WearUtils.x, strR + "_pushChatLogRecord", v);
        }
    }

    public static void X(String str, Message message) {
        try {
            ChatManager chatManager = s;
            if (chatManager == null) {
                return;
            }
            chatManager.createChat(str, p).sendMessage(message);
        } catch (SmackException.NotConnectedException e2) {
            e2.printStackTrace();
            e2.getMessage();
        }
    }

    public static void Z(String str) {
        D(str, false);
    }

    public static void a(String str) {
        D(str, true);
    }

    public static boolean b0(String str) {
        try {
            t.removeEntry(t.getEntry(WearUtils.i0(str)));
            ye3.d("D0003", "");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void e0(CommunMessage communMessage, String str) {
        try {
            MultiUserChat multiUserChat = w.getMultiUserChat(communMessage.getTo());
            Message messageCreateMessage = multiUserChat.createMessage();
            messageCreateMessage.setStanzaId(communMessage.getId());
            messageCreateMessage.setBody(str);
            multiUserChat.sendMessage(messageCreateMessage);
            xe3.a("sss", "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void f0(ContainBean containBean) {
        if (containBean.getEntity().getType() == MessageType.chat) {
            v(containBean.getEntity().getFrom(), containBean.getEntity().getTo(), containBean.getEntity());
        }
        CommunMessage entity = containBean.getEntity();
        m(entity, true);
        entity.setFrom(WearUtils.i0(WearUtils.y.r()));
        String json = containBean.getJson();
        xe3.a("Message==>", "sendMessage:" + json);
        Message message = new Message();
        message.setBody(WearUtils.B(json));
        message.setStanzaId(entity.getId());
        if (entity.getDataBean() != null && entity.getDataBean().needReceiptReceived()) {
            if (dh3.m(ch3.n().v(WearUtils.g0(entity.getTo())))) {
                X(entity.getTo(), message);
                entity.sendSuc();
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) entity);
                MessageSendEvent messageSendEvent = new MessageSendEvent();
                messageSendEvent.msg = entity;
                EventBus.getDefault().post(messageSendEvent);
                return;
            }
            xe3.a("Message==>", "加入任务列表需要接收回执：" + entity.getId());
            DeliveryReceiptRequest.addTo(message);
            zb2.O().x(entity);
        }
        X(entity.getTo(), message);
        U(containBean);
    }

    public static void g0(DataEntityAbstract dataEntityAbstract, String str, MessageType messageType, String str2, String str3, String str4) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setUserId(ch3.n().p());
        f0(new ContainBean(communMessage));
    }

    public static void h0(DataEntityAbstract dataEntityAbstract, String str, MessageType messageType, String str2, String str3, String str4) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(str);
        communMessage.setTo(WearUtils.y.p());
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setUserId(ch3.n().p());
        if (zb2.O().l0(communMessage)) {
            User userV = ch3.n().v(WearUtils.g0(str));
            if (userV != null && userV.isDateIng()) {
                communMessage.setSendType(2);
            }
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            zb2.O().i0(communMessage);
        }
        CommunMessage communMessage2 = new CommunMessage();
        communMessage2.setFrom(WearUtils.y.p());
        communMessage2.setTo(str);
        communMessage2.sendEntity(dataEntityAbstract);
        f0(new ContainBean(communMessage2));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.wear.protocol.CommunMessage i(com.wear.protocol.CommunMessage r5) {
        /*
            r0 = 5
            com.wear.protocol.MessageType[] r0 = new com.wear.protocol.MessageType[r0]
            com.wear.protocol.MessageType r1 = com.wear.protocol.MessageType.live
            r2 = 0
            r0[r2] = r1
            com.wear.protocol.MessageType r1 = com.wear.protocol.MessageType.toy
            r3 = 1
            r0[r3] = r1
            com.wear.protocol.MessageType r1 = com.wear.protocol.MessageType.sync
            r4 = 2
            r0[r4] = r1
            com.wear.protocol.MessageType r1 = com.wear.protocol.MessageType.video
            r4 = 3
            r0[r4] = r1
            com.wear.protocol.MessageType r1 = com.wear.protocol.MessageType.voice
            r4 = 4
            r0[r4] = r1
            java.util.List r0 = java.util.Arrays.asList(r0)
            com.wear.protocol.MessageType r1 = r5.getType()
            boolean r0 = r0.contains(r1)
            r0 = r0 ^ r3
            com.wear.protocol.MessageType r1 = r5.getType()
            com.wear.protocol.MessageType r3 = com.wear.protocol.MessageType.alarm
            if (r1 != r3) goto L40
            com.wear.protocol.DataEntityAbstract r1 = r5.getDataBean()
            com.wear.protocol.EntityAlarm r1 = (com.wear.protocol.EntityAlarm) r1
            com.wear.protocol.EntityAlarm$AlarmOPTType r1 = r1.getAlarmOPTType()
            com.wear.protocol.EntityAlarm$AlarmOPTType r3 = com.wear.protocol.EntityAlarm.AlarmOPTType.delete
            if (r1 != r3) goto L40
            r0 = 0
        L40:
            com.wear.protocol.MessageType r1 = r5.getType()
            com.wear.protocol.MessageType r3 = com.wear.protocol.MessageType.system
            if (r1 != r3) goto L5f
            com.wear.protocol.DataEntityAbstract r1 = r5.getDataBean()
            com.wear.protocol.EntitySystem r1 = (com.wear.protocol.EntitySystem) r1
            com.wear.protocol.EntitySystem$SystemOPTType r3 = r1.getFirstSysOPTType()
            com.wear.protocol.EntitySystem$SystemOPTType r4 = com.wear.protocol.EntitySystem.SystemOPTType.T300
            if (r3 != r4) goto L5f
            com.wear.protocol.EntitySystem$SystemOPTCode r1 = r1.getFirstSysOPTCode()
            com.wear.protocol.EntitySystem$SystemOPTCode r3 = com.wear.protocol.EntitySystem.SystemOPTCode.C309
            if (r1 != r3) goto L5f
            goto L60
        L5f:
            r2 = r0
        L60:
            if (r2 == 0) goto Lc8
            com.wear.protocol.EntitySystem r0 = new com.wear.protocol.EntitySystem
            r0.<init>()
            com.wear.protocol.EntitySystem$SystemOPTType r1 = com.wear.protocol.EntitySystem.SystemOPTType.T200
            java.lang.String r1 = r1.toString()
            com.wear.protocol.EntitySystem$SystemOPTCode r2 = com.wear.protocol.EntitySystem.SystemOPTCode.C203
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.wear.protocol.MessageType r4 = r5.getType()
            java.lang.String r4 = r0.getNotificationMessage(r4)
            r3.append(r4)
            java.lang.String r4 = "#"
            r3.append(r4)
            java.lang.String r4 = r5.getId()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.addDataToArray(r1, r2, r3)
            com.wear.protocol.CommunMessage r1 = new com.wear.protocol.CommunMessage
            r1.<init>()
            dc.ch3 r2 = com.wear.util.WearUtils.y
            java.lang.String r2 = r2.p()
            r1.setFrom(r2)
            java.lang.String r5 = r5.getTo()
            r1.setTo(r5)
            r1.sendEntity(r0)
            java.lang.String r5 = com.wear.util.WearUtils.E()
            r1.setId(r5)
            dc.ch3 r5 = dc.ch3.n()
            java.lang.String r5 = r5.p()
            r1.setUserId(r5)
            com.wear.dao.CommunMessageDao r5 = com.wear.dao.DaoUtils.getCommunMessageDao()
            r5.updateOrAdd(r1)
            goto Lc9
        Lc8:
            r1 = 0
        Lc9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.hu3.i(com.wear.protocol.CommunMessage):com.wear.protocol.CommunMessage");
    }

    public static void i0(String str, DataEntityAbstract dataEntityAbstract, MessageType messageType, String str2, String str3, String str4, String str5, String str6) {
        if (!MyApplication.P || x() == null) {
            sg3.i(WearUtils.x, R.string.message_send_error);
            return;
        }
        if (messageType == null || dataEntityAbstract == null) {
            sg3.i(WearUtils.x, R.string.message_send_error);
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            zb2.O().i0(communMessage);
        }
        if (!WearUtils.x.i.D(str, true)) {
            vg3.b().a(new a(new ContainBean(communMessage)));
            return;
        }
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C203.toString(), entitySystem.getNotificationMessage(communMessage.getType()) + "#" + communMessage.getId());
        CommunMessage communMessage2 = new CommunMessage();
        communMessage2.setFrom(WearUtils.y.p());
        communMessage2.setTo(str);
        communMessage2.sendEntity(entitySystem);
        communMessage2.setId(WearUtils.E());
        communMessage2.setUserId(ch3.n().p());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage2);
        zb2.O().i0(communMessage2);
    }

    public static CommunMessage j(CommunMessage communMessage) {
        if (!((communMessage.getType() == MessageType.alarm && ((EntityAlarm) communMessage.getDataBean()).getAlarmOPTType() == EntityAlarm.AlarmOPTType.delete) ? false : !Arrays.asList(MessageType.live, MessageType.toy, MessageType.sync, MessageType.video, MessageType.voice).contains(communMessage.getType()))) {
            return null;
        }
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C10000.toString(), entitySystem.getNotificationMessage(communMessage.getType()) + "#" + communMessage.getId());
        CommunMessage communMessage2 = new CommunMessage();
        communMessage2.setFrom(WearUtils.y.p());
        communMessage2.setTo(communMessage.getTo());
        communMessage2.sendEntity(entitySystem);
        communMessage2.setId(WearUtils.E());
        communMessage2.setUserId(ch3.n().p());
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage2);
        return communMessage2;
    }

    public static boolean k(String str) {
        try {
            t.createEntry(WearUtils.i0(str), null, null);
            ye3.d("D0001", nd3.r(str));
            return true;
        } catch (Exception e2) {
            ye3.d("D0002", nd3.r(str));
            e2.printStackTrace();
            return false;
        }
    }

    public static void m(CommunMessage communMessage, boolean z) {
        if (zb2.O().l0(communMessage)) {
            communMessage.getReceiveId();
            String id = communMessage.getId();
            if (communMessage.getType() == MessageType.chat) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityChat) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.wishlist) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityWishList) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.giftcard) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityGiftCard) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.audio) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityAudio) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.picture) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityPicture) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.pattern) {
                if (Arrays.asList(EntityPattern.TYPE_DETAIL_MYSENDPATTERN, EntityPattern.TYPE_DETAIL_PATTERN_RESEND, EntityPattern.TYPE_DETAIL_PATTERN_RESEND_V2).contains(((EntityPattern) communMessage.getDataBean()).getType()) || WearUtils.e1(((EntityPattern) communMessage.getDataBean()).getType())) {
                    DaoUtils.getReCallDao().addRecall(id, ((EntityPattern) communMessage.getDataBean()).getMsgId(), z);
                    return;
                }
                return;
            }
            if (communMessage.getType() == MessageType.shortvideo) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityShortVideo) communMessage.getDataBean()).getMsgId(), z);
                return;
            }
            if (communMessage.getType() == MessageType.burnpicture) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityBurnPicture) communMessage.getDataBean()).getMsgId(), z);
            } else if (communMessage.getType() == MessageType.burnvideo) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityBurnShortVideo) communMessage.getDataBean()).getMsgId(), z);
            } else if (communMessage.getType() == MessageType.vmsharecard) {
                DaoUtils.getReCallDao().addRecall(id, ((EntityVMShareCard) communMessage.getDataBean()).getMsgId(), z);
            }
        }
    }

    public static void n(CommunMessage communMessage) {
        if (communMessage.getType() == MessageType.pattern) {
            DaoUtils.getReCallDao().addReceiveReSendPatternRecall(communMessage.getId(), ((EntityPattern) communMessage.getDataBean()).getMsgId());
        }
    }

    public static void q0() {
        XMPPTCPConnection xMPPTCPConnection;
        if (r == null || !MyApplication.P || WearUtils.y.u() == null || (xMPPTCPConnection = o) == null || !xMPPTCPConnection.isConnected()) {
            return;
        }
        v0(true);
    }

    public static void r0() {
        try {
            v0(true);
        } catch (Exception unused) {
        }
    }

    public static boolean s0() {
        Account accountU;
        ch3 ch3Var = WearUtils.y;
        if (ch3Var == null || (accountU = ch3Var.u()) == null) {
            return false;
        }
        return t0(accountU.getStatusMode());
    }

    public static boolean t0(Presence.Mode mode) {
        Account accountU;
        if (r != null && MyApplication.P && (accountU = WearUtils.y.u()) != null) {
            Presence presence = new Presence(Presence.Type.available);
            presence.setMode(mode);
            XMPPTCPConnection xMPPTCPConnection = o;
            if (xMPPTCPConnection != null && xMPPTCPConnection.isConnected()) {
                try {
                    accountU.setStatusMode(mode);
                    o.sendStanza(presence);
                    v0(true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void u(DataEntityAbstract dataEntityAbstract, String str, String str2) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(str);
        communMessage.setTo(str2);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setUserId(ch3.n().p());
        if (zb2.O().l0(communMessage)) {
            if (!str2.equals(ch3.n().u().getUserJid())) {
                str = str2;
            }
            User userV = ch3.n().v(WearUtils.g0(str));
            if (userV != null && userV.isDateIng()) {
                communMessage.setSendType(2);
            }
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            zb2.O().i0(communMessage);
        }
    }

    public static void u0(VCard vCard) {
        Account accountU = WearUtils.y.u();
        if (o == null || accountU == null) {
            return;
        }
        try {
            if (!WearUtils.e1(vCard.getNickName())) {
                accountU.setName(vCard.getNickName());
            }
            if (vCard.isErrorAvatar()) {
                WearUtils.r2(vCard.getAvatarTemp(), accountU);
                String str = "888888888" + vCard.toString();
                vCard.setAvatar("", MimeTypes.IMAGE_JPEG);
            } else if (WearUtils.i1(vCard.getAvatar())) {
                WearUtils.r2("", accountU);
                vCard.setAvatar("", MimeTypes.IMAGE_JPEG);
            } else {
                String str2 = new String(vCard.getAvatar(), "ISO-8859-1");
                if (WearUtils.e1(str2) || str2.length() > 512) {
                    WearUtils.r2("", accountU);
                    vCard.setAvatar("", MimeTypes.IMAGE_JPEG);
                } else {
                    WearUtils.r2(str2, accountU);
                }
            }
            accountU.setGender(vCard.getField("SEX"));
            accountU.setMoodMessage(vCard.getField("MOODMESSAGE"));
            accountU.setAge(vCard.getField("AGE"));
            accountU.setUserCode(vCard.getField("USERID"));
            accountU.setAddFriendFromGroup(vCard.getField("ADDFRIENDFROMGROUP"));
            EventBus.getDefault().post(new VCardChangeEvent());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void v(final String str, final String str2, CommunMessage communMessage) {
        DaoUtils.getSensitiveWordDao().toMatchSensitiveResult(communMessage.getRealFrom() != null ? SensitiveWordDao.CHAT_ROOM : SensitiveWordDao.CHAT, ((EntityChat) communMessage.getDataBean()).getText(), new SensitiveWordDao.OnResultListener() { // from class: dc.wt3
            @Override // com.wear.dao.SensitiveWordDao.OnResultListener
            public final void onResult(MatchResult matchResult) {
                hu3.F(str, str2, matchResult);
            }
        });
    }

    public static void v0(boolean z) {
        Account accountU = WearUtils.y.u();
        XMPPTCPConnection xMPPTCPConnection = o;
        if (xMPPTCPConnection == null || accountU == null || !xMPPTCPConnection.isConnected() || !o.isAuthenticated()) {
            return;
        }
        VCardManager instanceFor = VCardManager.getInstanceFor(o);
        try {
            VCard vCardLoadVCard = instanceFor.loadVCard();
            vCardLoadVCard.setNickName(accountU.getUserName());
            vCardLoadVCard.setField("SEX", accountU.getGender());
            if (WearUtils.i1(vCardLoadVCard.getAvatar()) || WearUtils.e1(accountU.getAvatar())) {
                accountU.setAvatar("");
                vCardLoadVCard.setAvatar("", MimeTypes.IMAGE_JPEG);
            } else {
                if (accountU.getAvatar().length() > 512) {
                    accountU.setAvatar("");
                }
                vCardLoadVCard.setAvatar(accountU.getAvatar().getBytes(), MimeTypes.IMAGE_JPEG);
            }
            vCardLoadVCard.setField("MOODMESSAGE", accountU.getMoodMessage());
            vCardLoadVCard.setField("AGE", accountU.getAge());
            vCardLoadVCard.setField("GMTTIME", be3.o());
            if (uf2.v().q()) {
                vCardLoadVCard.setField("ORDERCHANNEL", "openfire#socketio_1");
            } else {
                vCardLoadVCard.setField("ORDERCHANNEL", "openfire#socketio_0");
            }
            vCardLoadVCard.setField("ADDFRIENDFROMGROUP", accountU.getAddFriendFromGroup());
            instanceFor.saveVCard(vCardLoadVCard);
            if (!z || WearUtils.y.u() == null) {
                return;
            }
            Presence presence = new Presence(Presence.Type.available);
            presence.setMode(WearUtils.y.u().getStatusMode());
            presence.addExtension(new DefaultExtensionElement("reloadVCard", null));
            XMPPTCPConnection xMPPTCPConnection2 = o;
            if (xMPPTCPConnection2 != null && xMPPTCPConnection2.isConnected()) {
                o.sendStanza(presence);
            }
            T();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void w0() {
        Account accountU = WearUtils.y.u();
        XMPPTCPConnection xMPPTCPConnection = o;
        if (xMPPTCPConnection == null || accountU == null || !xMPPTCPConnection.isConnected() || !o.isAuthenticated()) {
            return;
        }
        VCardManager instanceFor = VCardManager.getInstanceFor(o);
        try {
            VCard vCardLoadVCard = instanceFor.loadVCard();
            vCardLoadVCard.setNickName(accountU.getUserName());
            vCardLoadVCard.setField("SEX", accountU.getGender());
            if (WearUtils.i1(vCardLoadVCard.getAvatar())) {
                if (!WearUtils.e1(accountU.getAvatar())) {
                    if (accountU.getAvatar().length() > 512) {
                        accountU.setAvatar("");
                    } else {
                        vCardLoadVCard.setAvatar(accountU.getAvatar().getBytes(), MimeTypes.IMAGE_JPEG);
                    }
                }
            } else if (WearUtils.e1(accountU.getAvatar())) {
                vCardLoadVCard.setAvatar(vCardLoadVCard.getAvatarTemp().getBytes(), MimeTypes.IMAGE_JPEG);
                accountU.setAvatar(vCardLoadVCard.getAvatarTemp());
            } else {
                if (accountU.getAvatar().length() > 512) {
                    accountU.setAvatar("");
                }
                vCardLoadVCard.setAvatar(accountU.getAvatar().getBytes(), MimeTypes.IMAGE_JPEG);
            }
            vCardLoadVCard.setField("MOODMESSAGE", accountU.getMoodMessage());
            vCardLoadVCard.setField("AGE", accountU.getAge());
            vCardLoadVCard.setField("GMTTIME", be3.o());
            if (uf2.v().q()) {
                vCardLoadVCard.setField("ORDERCHANNEL", "openfire#socketio_1");
            } else {
                vCardLoadVCard.setField("ORDERCHANNEL", "openfire#socketio_0");
            }
            vCardLoadVCard.setField("ADDFRIENDFROMGROUP", accountU.getAddFriendFromGroup());
            instanceFor.saveVCard(vCardLoadVCard);
            if (WearUtils.y.u() == null) {
                return;
            }
            Presence presence = new Presence(Presence.Type.available);
            presence.setMode(WearUtils.y.u().getStatusMode());
            presence.addExtension(new DefaultExtensionElement("reloadVCard", null));
            XMPPTCPConnection xMPPTCPConnection2 = o;
            if (xMPPTCPConnection2 != null && xMPPTCPConnection2.isConnected()) {
                o.sendStanza(presence);
            }
            T();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static XMPPConnection x() {
        return o;
    }

    public static String y(@NonNull String str) {
        if (x == null) {
            x = new HashMap<>();
        }
        if (x.containsKey(str)) {
            return x.get(str);
        }
        String strEncryp = CommunMessage.encryp(str);
        if (!WearUtils.e1(strEncryp)) {
            x.put(str, strEncryp);
        }
        return strEncryp;
    }

    public static hu3 z(Context context) {
        if (q == null) {
            synchronized (hu3.class) {
                if (q == null) {
                    q = new hu3(context);
                }
            }
        }
        return q;
    }

    public void A(List<String> list) {
        RequestRoomMembers requestRoomMembers = new RequestRoomMembers();
        requestRoomMembers.setRoomIds(list);
        zb2.O().B0(requestRoomMembers, new e());
    }

    public void J(User user) {
        if (user == null) {
            return;
        }
        try {
            String strI0 = WearUtils.i0(user.getId());
            String str = "jid===" + strI0;
            VCard vCardLoadVCard = this.f.loadVCard(strI0);
            if (!WearUtils.x.i.l(user.getUserJid()) && !user.isDeleteByFriend()) {
                if (vCardLoadVCard == null) {
                    return;
                }
                String str2 = "vcard的数据===" + vCardLoadVCard.toString();
                if (!WearUtils.e1(vCardLoadVCard.getNickName())) {
                    user.setName(vCardLoadVCard.getNickName());
                }
                if (vCardLoadVCard.isErrorAvatar()) {
                    WearUtils.s2(vCardLoadVCard.getAvatarTemp(), user);
                } else if (WearUtils.i1(vCardLoadVCard.getAvatar())) {
                    WearUtils.s2(vCardLoadVCard.getAvatarTemp(), user);
                    vCardLoadVCard.setAvatar("", MimeTypes.IMAGE_JPEG);
                } else {
                    WearUtils.s2(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"), user);
                }
                r rVar = this.l;
                if (rVar != null) {
                    rVar.a(strI0);
                }
                String field = vCardLoadVCard.getField("ISSUPPORTGROUP");
                if (!WearUtils.e1(field)) {
                    user.setIsSupportGroup(field);
                }
                user.setDeviceToken(vCardLoadVCard.getField("DEVICETOKEN"));
                user.setGender(vCardLoadVCard.getField("SEX"));
                user.setUserCode(vCardLoadVCard.getField("USERID"));
                user.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
                user.setAge(vCardLoadVCard.getField("AGE"));
                user.setFriendGTMTime(vCardLoadVCard.getField("GMTTIME"));
                user.setDeviceType(vCardLoadVCard.getField("DEVICETYPE"));
                user.setDeviceAppVersion(vCardLoadVCard.getField("APPVERSION"));
                user.setSupportType(vCardLoadVCard.getField("ORDERCHANNEL"));
                if (WearUtils.e1(vCardLoadVCard.getRemoteAccountId())) {
                    return;
                }
                user.setRemoteAccountId(vCardLoadVCard.getRemoteAccountId());
                return;
            }
            User userFindById = DaoUtils.getUserDao().findById(user.getId());
            if (!WearUtils.e1(userFindById.getUserName())) {
                user.setName(userFindById.getUserName());
            } else if (!WearUtils.e1(vCardLoadVCard.getNickName())) {
                user.setName(vCardLoadVCard.getNickName());
            }
            WearUtils.s2(userFindById.getAvatar(), user);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void K() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ye3.D();
        Map<String, User> mapY = WearUtils.y.y();
        ep1.b().e("开始拉取好友vcard信息");
        eg3.k(WearUtils.x, "user_size", mapY.size());
        boolean z = false;
        int i2 = 0;
        for (String str : mapY.keySet()) {
            if (MyApplication.Q == 0) {
                ep1.b().e("退出登录，停止拉取好友");
                return;
            }
            i2++;
            ep1.b().e("拉取第" + i2 + "个好友信息" + str);
            J(mapY.get(str));
            DaoUtils.getUserDao().update(mapY.get(str));
            if (i2 >= 10 && !z) {
                ep1.b().n(2);
                EventBus.getDefault().post(new UserUpdateEvent(""));
                z = true;
            }
        }
        ep1.b().e("好友vcard信息加载完毕");
        if (!z || mapY.size() < 10) {
            ep1.b().n(2);
        }
        ye3.C();
        EventBus.getDefault().post(new UserUpdateEvent(""));
        Handler handler = r.l;
        if (handler != null) {
            handler.postDelayed(new o(), 1000L);
        }
    }

    public String L(String str) {
        try {
            VCard vCardLoadVCard = this.f.loadVCard(WearUtils.i0(str));
            if (vCardLoadVCard == null) {
                return null;
            }
            return vCardLoadVCard.getField("ADDFRIENDFROMGROUP");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void M() {
        if (MyApplication.Q == 0) {
            ep1.b().e("退出登录，停止拉取群成員信息");
            return;
        }
        ye3.H();
        Map<String, Group> mapL = WearUtils.y.l();
        ep1.b().e("开始拉取群成員信息");
        A(new ArrayList(mapL.keySet()));
    }

    public void N(boolean z) throws SmackException.NotConnectedException, SmackException.NotLoggedInException {
        ep1.b().e("开始拉取好友列表:");
        ep1.b().n(1);
        EventBus.getDefault().post(new UserUpdateEvent(""));
        if (z) {
            t.reloadAndWait();
        }
    }

    public final void O(List<String> list) {
        if (list.size() <= 0) {
            return;
        }
        String json = WearUtils.A.toJson(list);
        String str = "loadUserNameByApiV2 json: " + json;
        tn2.x(WearUtils.x).m("/api/getUserNameByEmailV2", json, new p(this, list));
    }

    public final void P(String str) {
        synchronized (this.a) {
            Iterator<bu3> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().l3(str);
            }
        }
    }

    public void Q(String str) {
        synchronized (this.a) {
            Iterator<bu3> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().I1(str);
            }
        }
    }

    public final void S(Group group, List<GroupMember> list) {
        if (group != null) {
            try {
                Map<String, GroupMember> members = group.getMembers();
                if (list != null && list.size() != 0) {
                    Hashtable hashtable = new Hashtable();
                    for (GroupMember groupMember : list) {
                        String jid = groupMember.getJid();
                        GroupMember groupMember2 = members.get(jid);
                        if (groupMember2 == null) {
                            groupMember2 = new GroupMember();
                            groupMember2.setJid(jid);
                            members.put(jid, groupMember2);
                        }
                        String photo = groupMember.getPhoto();
                        if (!WearUtils.e1(photo) && !photo.contains("UploadFiles/wear/avatar")) {
                            try {
                                String str = new String(Base64.decode(photo), "ISO-8859-1");
                                photo = (TextUtils.isEmpty(str) || str.length() > 512) ? "" : str;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        groupMember2.setPhoto(photo);
                        if (!TextUtils.isEmpty(groupMember.getRealNickName())) {
                            groupMember2.setNickName(groupMember.getRealNickName());
                        }
                        groupMember2.setEnterTime(groupMember.getEnterTime());
                        groupMember2.setAffiliation(groupMember.getAffiliation());
                        hashtable.put(jid, groupMember2);
                        zb2.O().r0(jid, groupMember2.getAvatar());
                    }
                    Iterator<Map.Entry<String, GroupMember>> it = members.entrySet().iterator();
                    while (it.hasNext()) {
                        if (!hashtable.containsKey(it.next().getKey())) {
                            it.remove();
                        }
                    }
                    return;
                }
                members.clear();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public Subscription W(yn2<String> yn2Var) {
        return tn2.x(WearUtils.x).f("/api/last_login_info", new g(this, yn2Var));
    }

    public void Y() {
        i iVar = new i();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            vg3.b().a(iVar);
        } else {
            iVar.run();
        }
    }

    public void a0() throws SmackException.NotConnectedException, SmackException.NotLoggedInException {
        k0(new s() { // from class: dc.kt3
            @Override // dc.hu3.s
            public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.K();
            }
        });
        N(true);
    }

    public void c0(bu3 bu3Var) {
        synchronized (this.a) {
            this.a.remove(bu3Var);
        }
    }

    public void d0(Object obj, String str, kv1 kv1Var) {
        BaseRequestIQ baseRequestIQ = new BaseRequestIQ(obj);
        baseRequestIQ.setType(IQ.Type.get);
        baseRequestIQ.setTo(str);
        f fVar = new f(this, baseRequestIQ, obj, kv1Var);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            vg3.b().a(fVar);
        } else {
            fVar.run();
        }
    }

    public void j0(r rVar) {
        this.l = rVar;
    }

    public final void k0(final s sVar) {
        t.removeAllRosterLoadedListeners();
        t.addRosterLoadedListener(new RosterLoadedListener() { // from class: dc.yt3
            @Override // org.jivesoftware.smack.roster.RosterLoadedListener
            public final void onRosterLoaded(Roster roster) {
                hu3.G(sVar, roster);
            }
        });
    }

    public void l(bu3 bu3Var) {
        synchronized (this.a) {
            if (this.a.contains(bu3Var)) {
                return;
            }
            this.a.add(bu3Var);
        }
    }

    public boolean l0() {
        if (MyApplication.Q == 1) {
            ep1.b().e("正在连接");
            return true;
        }
        try {
            if (o == null) {
                ep1.b().e("mConnection== null");
            } else {
                ep1.b().e("mConnection!= null");
            }
        } catch (Exception e2) {
            ep1.b().e("mConnection!=null " + e2.getMessage());
        }
        if (o != null && MyApplication.Q != 2) {
            if (MyApplication.P) {
                ep1.b().e("不需要登录了");
                Q("");
                return false;
            }
            if (o.isConnected()) {
                ep1.b().e("说明还没认证，此时等待认证");
                return false;
            }
            k kVar = new k(this);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                vg3.b().a(kVar);
            } else {
                kVar.run();
            }
            return true;
        }
        ep1.b().e("startToConnect()");
        MyApplication.Q = 1;
        p0();
        return true;
    }

    public void m0() {
        Timer timer = u;
        if (timer != null) {
            timer.cancel();
            u = null;
        }
        Timer timer2 = new Timer();
        u = timer2;
        timer2.schedule(new j(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 10000L);
    }

    public void n0() {
        ye3.a0();
        m0();
        ep1.b().e("开始连接");
        XMPPTCPConnection xMPPTCPConnection = o;
        if (xMPPTCPConnection != null && xMPPTCPConnection.isConnected() && !o.isAuthenticated()) {
            ep1.b().e("已有连接");
            this.m.connectSuc();
            return;
        }
        SmackConfiguration.DEBUG = true;
        SmackConfiguration.setDefaultPacketReplyTimeout(AsyncHttpRequest.DEFAULT_TIMEOUT);
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
        builder.setServiceName(WearUtils.d);
        builder.setHost(WearUtils.c);
        builder.setPort(WearUtils.m);
        builder.setConnectTimeout(AsyncHttpRequest.DEFAULT_TIMEOUT);
        builder.setCompressionEnabled(false);
        builder.setDebuggerEnabled(false);
        builder.setSendPresence(false);
        if (WearUtils.n) {
            builder.setSecurityMode(ConnectionConfiguration.SecurityMode.ifpossible);
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(AsyncHttpRequest.DEFAULT_TIMEOUT);
            try {
                if (WearUtils.v) {
                    builder.setHostnameVerifier(new m(this));
                }
                builder.setSocketFactory(sSLCertificateSocketFactory);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        }
        try {
            if (o != null) {
                ep1.b().e("断开旧的连接");
                w(true);
                MyApplication.Q = 1;
            }
        } catch (Exception unused) {
        }
        ep1.b().e("初始化连接");
        ye3.f("A0013");
        ye3.V();
        ep1.b().e("开始创建新连接对象：");
        o = new XMPPTCPConnection(builder.build());
        ep1.b().e("创建新连接对象：" + o.toString());
        o.setPacketReplyTimeout(30000L);
        o.addConnectionListener(this.g);
        try {
            o.connect();
            ReconnectionManager.getInstanceFor(o).enableAutomaticReconnection();
            DeliveryReceiptManager.getInstanceFor(o).setAutoReceiptMode(DeliveryReceiptManager.AutoReceiptMode.always);
            s = ChatManager.getInstanceFor(o);
            w = MultiUserChatManager.getInstanceFor(o);
            this.m.connectSuc();
        } catch (Exception e3) {
            ye3.d("A0005", "");
            this.m.a(e3.getMessage() != null ? e3.getMessage() : "");
            FirebaseCrashlytics.getInstance().recordException(e3);
        }
    }

    public final void o(Exception exc, String str, int i2, String str2) {
        MyApplication.P = false;
        WearUtils.s(n, exc);
        w(false);
        ye3.d(str, "");
        ye3.p(0, i2, str2, exc.getMessage());
        P(ah4.e(R.string.userdata_error_text) + "[" + str2 + "]");
        ep1.b().e(exc.getMessage());
    }

    public void o0(final String str, final String str2, final String str3, final String str4) {
        try {
            ye3.K(8);
            if (o.isConnected() && o.isAuthenticated()) {
                Q(ah4.e(R.string.login_success));
                return;
            }
            ye3.n();
            ye3.B();
            Roster instanceFor = Roster.getInstanceFor(o);
            t = instanceFor;
            instanceFor.setSubscriptionMode(Roster.SubscriptionMode.manual);
            o.addSyncStanzaListener(this.j, StanzaTypeFilter.PRESENCE);
            o.addSyncStanzaListener(this.k, new ku3(VCard.class));
            String strReplace = WearUtils.W(str, false).replace("@", "!!!");
            ep1.b().e("开始账户密码登录:" + str + "  " + str2);
            s.addChatListener(this.h);
            DeliveryReceiptManager.getInstanceFor(o).addReceiptReceivedListener(zb2.O());
            t.addRosterListener(this.i);
            k0(new s() { // from class: dc.xt3
                @Override // dc.hu3.s
                public final void a() {
                    this.a.I(str4, str, str3, str2);
                }
            });
            o.login(strReplace, str2, WearUtils.o);
            ep1.b().e("登录成功" + Thread.currentThread().getId());
            N(false);
        } catch (SmackException.NoResponseException e2) {
            o(e2, "A0003", 12, NetException.XMPP_LOGIN_ERROR_TIME);
        } catch (Exception e3) {
            o(e3, "A0004", 12, NetException.XMPP_LOGIN_ERROR_EXCEPTION);
        }
    }

    public void p(boolean z) {
        try {
            ep1.b().e("开始拉取群聊列表:");
            ye3.F();
            zb2.O().B0(new RequestRoomList(), new c(this, z));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void p0() {
        ep1.b().e("开始登录");
        l lVar = new l();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            vg3.b().a(lVar);
        } else {
            lVar.run();
        }
    }

    public void q(String str, bv1 bv1Var) {
        r(str, bv1Var, false);
    }

    public void r(String str, bv1 bv1Var, boolean z) {
        try {
            RequestRoominfoMembers requestRoominfoMembers = new RequestRoominfoMembers();
            requestRoominfoMembers.setRoomId(str);
            zb2.O().C0(requestRoominfoMembers, WearUtils.k0(str), new d(bv1Var, str, z));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void s(String str, String str2, String str3, String str4) {
        MyApplication.Q = 1;
        zt3.k = WearUtils.e1(str4) ? str : str4;
        xe2.L0().g(xe2.r, "AlarmTranslationListener.loginUserName:" + zt3.k);
        ye3.f("A0012");
        this.b = str;
        this.c = str2;
        this.e = str4;
        this.d = str3;
        p0();
    }

    public final void t(String str) {
        synchronized (this.a) {
            Iterator<bu3> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().u1(str);
            }
        }
    }

    public void w(boolean z) {
        ep1 ep1VarB = ep1.b();
        StringBuilder sb = new StringBuilder();
        sb.append("isSelf = ");
        sb.append(z);
        sb.append("  mConnection!=null = ");
        sb.append(o != null);
        ep1VarB.e(sb.toString());
        if (MyApplication.Q == 0) {
            return;
        }
        XMPPTCPConnection xMPPTCPConnection = o;
        ep1.b().e("旧连接对象：" + xMPPTCPConnection.toString());
        if (xMPPTCPConnection != null) {
            try {
                MyApplication.Q = 0;
                if (xMPPTCPConnection != null) {
                    xMPPTCPConnection.removeConnectionListener(this.g);
                }
            } catch (Exception unused) {
            }
            try {
                try {
                    try {
                        VCardManager.getInstanceFor(xMPPTCPConnection);
                        if (xMPPTCPConnection.isConnected() && xMPPTCPConnection.isAuthenticated()) {
                            MyApplication.P = false;
                            Presence presence = new Presence(Presence.Type.unavailable);
                            presence.addExtension(new DefaultExtensionElement("reloadVCard", null));
                            xMPPTCPConnection.sendStanza(presence);
                        }
                        try {
                            ReconnectionManager.getInstanceFor(o).disableAutomaticReconnection();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        MyApplication.Q = 0;
                        if (xMPPTCPConnection.isConnected() && xMPPTCPConnection.isAuthenticated()) {
                            ep1.b().e(xMPPTCPConnection.isConnected() + "  " + MyApplication.P);
                            xMPPTCPConnection.disconnect();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } finally {
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    ReconnectionManager.getInstanceFor(o).disableAutomaticReconnection();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                MyApplication.Q = 0;
                if (xMPPTCPConnection.isConnected() && xMPPTCPConnection.isAuthenticated()) {
                    ep1.b().e(xMPPTCPConnection.isConnected() + "  " + MyApplication.P);
                    xMPPTCPConnection.disconnect();
                }
            }
            MyApplication.Q = 0;
            MyApplication.P = false;
            ep1.b().n(0);
        }
    }

    public void x0(String str) {
        if (o != null) {
            try {
                VCard vCardLoadVCard = this.f.loadVCard();
                if (WearUtils.e1(MyApplication.W) || MyApplication.W.equals(str)) {
                    return;
                }
                vCardLoadVCard.setField("DEVICETOKEN", "nodevicetoken");
                this.f.saveVCard(vCardLoadVCard);
                MyApplication.W = str;
                re3.v(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
