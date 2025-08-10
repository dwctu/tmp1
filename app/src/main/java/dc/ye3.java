package dc;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.Account;
import com.wear.bean.LogType;
import com.wear.bean.LoginFriendsTimeLogBean;
import com.wear.bean.LoginLogBean;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.dao.LogDao;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.network.presenter.bean.BackupXmppUrlsBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.RecommendXmppUrlsBean;
import com.wear.network.presenter.bean.XmppUrlBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.ui.home.remote.RemoteControl;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: LogUtils.java */
/* loaded from: classes4.dex */
public class ye3 {
    public static final String a = "ye3";
    public static String c;
    public static String d;
    public static long i;
    public static String o;
    public static Map<String, String> p;
    public static Map<String, String> q;
    public static DateFormat r;
    public static String s;
    public static String t;
    public static int u;
    public static HashMap<String, Integer> v;
    public static String w;
    public static Timer x;
    public static List<LogType> y;
    public static final String b = bf3.c("XMPP_BLOCK_URL_KEY");
    public static String e = "";
    public static Map<String, XmppUrlBean> f = new HashMap();
    public static int g = 0;
    public static LoginLogBean h = new LoginLogBean();
    public static LinkedHashMap<String, XmppUrlBean> j = new LinkedHashMap<>();
    public static LinkedHashMap<String, XmppUrlBean> k = new LinkedHashMap<>();
    public static long l = 0;
    public static long m = 0;
    public static LoginFriendsTimeLogBean n = new LoginFriendsTimeLogBean();

    /* compiled from: LogUtils.java */
    public class a extends TimerTask {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str = "run: " + this.a;
            ye3.X();
        }
    }

    /* compiled from: LogUtils.java */
    public class b implements g {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // dc.ye3.g
        public void a() {
            DaoUtils.getLogDao().delTs(this.a);
        }

        @Override // dc.ye3.g
        public void error() {
        }
    }

    /* compiled from: LogUtils.java */
    public class c implements lz {
        @Override // dc.lz
        public void a(@NonNull String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(Build.MODEL);
            sb.append("#");
            sb.append(Build.VERSION.RELEASE);
            sb.append("#");
            sb.append("remote");
            sb.append("#");
            sb.append(ye3.e);
            sb.append("#");
            sb.append(hf3.a());
            sb.append("#");
            sb.append(af3.d() == 1 ? "longrange_1" : "longrange_0");
            ye3.T(!WearUtils.e1(zt3.k) ? zt3.k : WearUtils.a, "S0006", sb.toString(), str, null);
        }
    }

    /* compiled from: LogUtils.java */
    public class d implements zn2<String> {
        public final /* synthetic */ g a;

        public d(g gVar) {
            this.a = gVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.error();
                    return;
                }
                return;
            }
            g gVar2 = this.a;
            if (gVar2 != null) {
                gVar2.a();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            g gVar = this.a;
            if (gVar != null) {
                gVar.error();
            }
        }
    }

    /* compiled from: LogUtils.java */
    public class e implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: LogUtils.java */
    public class f implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public f(int i, String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                String str = ye3.r.format(new Date());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(WearUtils.p0(), "xmpp-" + (this.a == 0 ? StreamManagement.AckRequest.ELEMENT : "s") + Constants.FILENAME_SEQUENCE_SEPARATOR + str + ".log"));
                fileOutputStream.write(this.b.toString().getBytes());
                fileOutputStream.close();
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: LogUtils.java */
    public interface g {
        void a();

        void error();
    }

    static {
        new ArrayList();
        p = new HashMap();
        q = new HashMap();
        r = new SimpleDateFormat("yyyyMMddHHmmss");
        u = 0;
        v = new HashMap<>();
        w = "";
        y = new ArrayList();
    }

    public static void A() {
        n.setFetchRosterTimeEnd(System.currentTimeMillis());
    }

    public static void B() {
        n.setFetchRosterTimeStar(System.currentTimeMillis());
    }

    public static void C() {
        n.setFriendVcardTimeEnd(System.currentTimeMillis());
    }

    public static void D() {
        n.setFriendVcardTimeStar(System.currentTimeMillis());
    }

    public static void E() {
        n.setGroupListTimeEnd(System.currentTimeMillis());
    }

    public static void F() {
        n.setGroupListTimeStar(System.currentTimeMillis());
    }

    public static void G() {
        n.setGroupMemberTimeEnd(System.currentTimeMillis());
    }

    public static void H() {
        n.setGroupMemberTimeStar(System.currentTimeMillis());
    }

    public static void I(String str, String str2) {
        try {
            if (og3.a(12)) {
                FragmentActivity fragmentActivityH = MyApplication.H();
                String simpleName = fragmentActivityH != null ? fragmentActivityH.getClass().getSimpleName() : "";
                HashMap map = new HashMap();
                map.put("netType", w());
                map.put("errorMessage", str2);
                map.put("exitType", str);
                map.put("lastActiverTimes", Long.valueOf(l));
                map.put("lastLostTimes", Long.valueOf(m));
                map.put("modulePage", simpleName);
                map.put("session_id", x());
                map.put("device_id", tz.i());
                Q("L0004", nd3.s(WearUtils.A.toJson(map)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().setCustomKey("loginErrorMessage", "error");
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public static void J(int i2, String str, String str2, int i3, Map<String, Object> map) {
        if (i3 == 9) {
            if (str2.contains("SocketException: Socket closed")) {
                y().put(str, new XmppUrlBean(h.getCurrentUrl(), h.getCurrentPort(), true));
                zd3.e(b, y());
                if (j.get(str) != null) {
                    j.get(str).setFailCount(j.get(str).getFailCount() + 1);
                }
                xe3.a(a, "setXmppUrl: 失败，9 key = " + str + "   加入黑名单");
            } else {
                XmppUrlBean xmppUrlBean = y().get(str);
                if (xmppUrlBean == null) {
                    xmppUrlBean = new XmppUrlBean(h.getCurrentUrl(), h.getCurrentPort(), false, 1);
                } else if (xmppUrlBean.getFailCount() >= 4) {
                    xmppUrlBean.setBlock(true);
                } else {
                    xmppUrlBean.setFailCount(xmppUrlBean.getFailCount() + 1);
                }
                y().put(str, xmppUrlBean);
                if (j.get(str) != null) {
                    j.get(str).setFailCount(j.get(str).getFailCount() + 1);
                }
                zd3.e(b, y());
                xe3.a(a, "setXmppUrl: 失败，9 非特定错误 key = " + str + "   不加入黑名单");
            }
        } else if (i3 == 12) {
            XmppUrlBean xmppUrlBean2 = y().get(str);
            if (xmppUrlBean2 == null) {
                xmppUrlBean2 = new XmppUrlBean(h.getCurrentUrl(), h.getCurrentPort(), false, 1);
            } else if (xmppUrlBean2.getFailCount() >= 4) {
                xmppUrlBean2.setBlock(true);
            } else {
                xmppUrlBean2.setFailCount(xmppUrlBean2.getFailCount() + 1);
            }
            y().put(str, xmppUrlBean2);
            if (j.get(str) != null) {
                j.get(str).setFailCount(j.get(str).getFailCount() + 1);
            }
            zd3.e(b, y());
            xe3.a(a, "setXmppUrl: 12  失败，" + str + "   加入黑名单");
        }
        if (og3.a(10)) {
            String json = new Gson().toJson(map);
            xe3.a(a, "setXmppUrl: 最后：" + str + "   " + json);
            Q("L0003", nd3.s(json));
        }
    }

    public static void K(int i2) {
        h.put(i2, System.currentTimeMillis());
    }

    public static void L(LoginUserBean loginUserBean) {
        h.setRecommendXmppUrls(loginUserBean.getRecommendXmppUrls());
        h.setBackupXmppUrls(loginUserBean.getBackupXmppUrls());
        b0(loginUserBean);
    }

    public static void M(int i2) {
        if (h.getStartTime() <= 0) {
            h.setAutoLogin(true);
            h.setNetType(w());
            h.setStartTime(System.currentTimeMillis());
        }
        h.setCurrentUrl(WearUtils.c);
        h.setCurrentPort(WearUtils.m);
        h.put(i2, System.currentTimeMillis());
    }

    public static void N(String str) {
        if (WearUtils.e1(o)) {
            o = !WearUtils.e1(zt3.k) ? zt3.k : WearUtils.a;
        }
        T(o, "9958", str, tz.i(), null);
    }

    public static void O(String str, String str2, g gVar) {
        S(str, str2, tz.i(), gVar);
    }

    public static void P(String str, File file, zn2<String> zn2Var) {
        if (file.exists()) {
            HashMap map = new HashMap();
            map.put("email", nd3.r(str));
            tn2.x(WearUtils.x).A("/wear/android/crashFile", file, map, zn2Var);
        }
    }

    public static void Q(String str, String str2) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, nd3.s("e4e3" + o + "mki8"));
        map.put("type", str);
        map.put("text", str2);
        map.put("pf", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("appType", "remote");
        map.put("model", Build.MODEL);
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        map.put("session_id", x());
        map.put("device_id", tz.i());
        tn2.x(WearUtils.x).l("/app/exception/log", map, new e());
    }

    public static void R(String str, String str2) {
        if (WearUtils.e1(o)) {
            o = !WearUtils.e1(zt3.k) ? zt3.k : WearUtils.a;
        }
        T(o, str, str2, tz.i(), null);
    }

    public static void S(String str, String str2, String str3, g gVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = "";
        }
        String str4 = "text=" + str2 + "&platform=android&appType=remote&sessionId=" + s + "&version=" + WearUtils.q + "&language=" + lg3.b(WearUtils.x) + "&nettype=" + se3.b(WearUtils.x) + "&deviceId=" + str3 + "&timezone=" + w + "&openId=" + t + "&model=" + Build.MODEL + ";" + Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str)) {
            str4 = "email=" + nd3.r(str) + ContainerUtils.FIELD_DELIMITER + str4;
        }
        tn2.x(WearUtils.x).s("/wear/logsNewV3", str4, new d(gVar));
    }

    public static void T(String str, String str2, String str3, String str4, g gVar) {
        LogType logType = new LogType(str2, str3);
        logType.setId(null);
        logType.setUserId(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(logType);
        String str5 = "sendLog:" + str2 + ", param:" + str3;
        S(str, WearUtils.A.toJson(arrayList), str4, gVar);
    }

    public static void U(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MODEL);
        sb.append("#");
        sb.append(Build.VERSION.RELEASE);
        sb.append("#");
        sb.append("remote");
        sb.append("#");
        sb.append(e);
        sb.append("#");
        sb.append(hf3.a());
        sb.append("#");
        sb.append(af3.d() == 1 ? "longrange_1" : "longrange_0");
        String string = sb.toString();
        LogType logType = new LogType("S0001", string);
        logType.setId(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(logType);
        String str = "sendOpenLog: S0001  " + string;
        O(z ? "" : o, WearUtils.A.toJson(arrayList), null);
    }

    public static void V() {
        List<LogType> list = y;
        if (list != null && list.size() > 0 && WearUtils.x.j == 1) {
            O(o, WearUtils.A.toJson(y), null);
        }
        m();
    }

    public static void W() {
        tz.j(new c());
    }

    public static synchronized void X() {
        List arrayList;
        try {
            List<LogType> listFindAll = DaoUtils.getLogDao().findAll();
            xe3.a("LogUtils", "总条数：" + listFindAll.size());
            if (WearUtils.x.j != 1) {
                ArrayList arrayList2 = new ArrayList();
                for (LogType logType : listFindAll) {
                    if (logType.isEnforced()) {
                        arrayList2.add(logType);
                    }
                }
                listFindAll = arrayList2;
            }
            int size = listFindAll.size() > 50 ? listFindAll.size() - 50 : 0;
            if (size > 0) {
                DaoUtils.getLogDao().delTs(listFindAll.subList(0, size));
            }
            HashMap map = new HashMap();
            while (size < listFindAll.size()) {
                LogType logType2 = listFindAll.get(size);
                String strI = nd3.i(logType2.getUserId());
                if (TextUtils.isEmpty(strI)) {
                    strI = t();
                }
                if (map.containsKey(strI)) {
                    arrayList = (List) map.get(strI);
                } else {
                    arrayList = new ArrayList();
                    map.put(strI, arrayList);
                }
                logType2.setUserId(null);
                arrayList.add(logType2);
                size++;
            }
            for (String str : map.keySet()) {
                List list = (List) map.get(str);
                O(str, WearUtils.A.toJson(list), new b(list));
            }
            xe3.a(a, "email:" + map.keySet());
        } catch (Exception unused) {
            DaoUtils.getLogDao().cleanLogs();
        }
    }

    public static void Y(String str) {
        o = str;
    }

    public static void Z(HashMap<String, Integer> map) {
        if (map == null) {
            return;
        }
        try {
            if (v == null) {
                v = u();
            }
            for (String str : map.keySet()) {
                v.put(str, map.get(str));
            }
            pe3.j("logFilterKey", v);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a0() {
        boolean z;
        int failCount = 0;
        if (j.size() > 0) {
            for (XmppUrlBean xmppUrlBean : j.values()) {
                if (xmppUrlBean.getType() == 0 && !xmppUrlBean.isBlock() && xmppUrlBean.getFailCount() <= 0) {
                    WearUtils.c = xmppUrlBean.getUrl();
                    WearUtils.m = xmppUrlBean.getPort();
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z && k.size() > 0) {
            for (XmppUrlBean xmppUrlBean2 : k.values()) {
                if (xmppUrlBean2.getFailCount() <= failCount) {
                    failCount = xmppUrlBean2.getFailCount();
                    WearUtils.c = xmppUrlBean2.getUrl();
                    WearUtils.m = xmppUrlBean2.getPort();
                }
            }
        }
        String str = "setXmppUrl: 登陆前设置本地地址，" + WearUtils.c + "   " + WearUtils.m;
        M(7);
    }

    public static void b0(LoginUserBean loginUserBean) {
        if (loginUserBean.getRecommendXmppUrls() == null) {
            return;
        }
        for (RecommendXmppUrlsBean recommendXmppUrlsBean : loginUserBean.getRecommendXmppUrls()) {
            if (!WearUtils.e1(recommendXmppUrlsBean.getUrl()) && !WearUtils.c1(Integer.valueOf(recommendXmppUrlsBean.getPort()))) {
                String str = recommendXmppUrlsBean.getUrl() + SignatureImpl.INNER_SEP + recommendXmppUrlsBean.getPort();
                if (!j.containsKey(str)) {
                    XmppUrlBean xmppUrlBean = new XmppUrlBean(recommendXmppUrlsBean.getUrl(), recommendXmppUrlsBean.getPort(), 0);
                    if (y().get(str) == null || !y().get(str).isBlock()) {
                        xmppUrlBean.setBlock(false);
                    } else {
                        xmppUrlBean.setBlock(true);
                    }
                    j.put(str, xmppUrlBean);
                    String str2 = "setXmppUrl: 获取服务器  " + str;
                }
            }
        }
        if (loginUserBean.getBackupXmppUrls() == null) {
            return;
        }
        for (BackupXmppUrlsBean backupXmppUrlsBean : loginUserBean.getBackupXmppUrls()) {
            if (!WearUtils.e1(backupXmppUrlsBean.getUrl()) && !WearUtils.c1(Integer.valueOf(backupXmppUrlsBean.getPort()))) {
                String str3 = backupXmppUrlsBean.getUrl() + SignatureImpl.INNER_SEP + backupXmppUrlsBean.getPort();
                if (!k.containsKey(str3)) {
                    k.put(str3, new XmppUrlBean(backupXmppUrlsBean.getUrl(), backupXmppUrlsBean.getPort(), 1));
                }
            }
        }
        String str4 = "setXmppUrl: 获取服务器，设置本地 " + j.size() + "   " + k.size();
    }

    public static void c(String str, String str2, String str3) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put(DataLayout.ELEMENT, str);
        }
        map.put("event", str2);
        if (!TextUtils.isEmpty(str3)) {
            map.put("oppo_id", str3);
        }
        String str4 = c83.R1().r() ? c83.R1().r.r() ? "control link live control" : c83.R1().s.r() ? "control link sync control" : "control link control" : ChatLiveControl.q0().r() ? "1v1 live control" : ChatSyncControl.N0().r() ? "1v1 sync control" : ChatVideoControl.a1().r() ? ChatVideoControl.a1().k1() ? "1v1 video control" : "1v1 voice control" : ChatGroupControl.o1().r() ? "group sync control" : ChatDSControl.r1().r() ? "group D&S control" : RemoteControl.j().a ? "remote control" : PatternPlayManagerImpl.H ? "pattern play" : SoundPlayControl.M().a ? "sound control" : MusicControl.h0().u ? "music play" : SpeedModeControl.C().L() ? "speed mode" : OrgySetting.getInstance().isJoinIn() ? "lovense orgy" : DiscordControl.getInstance().isJoin() ? "discord orgy" : "";
        if (!TextUtils.isEmpty(str4)) {
            map.put("control_sence", str4);
        }
        e("A0030", map);
    }

    public static void c0(int i2, boolean z) {
        try {
            h.clear();
            h.setNetType(w());
            h.setAutoLogin(z);
            long jCurrentTimeMillis = System.currentTimeMillis();
            h.put(i2, jCurrentTimeMillis);
            h.setStartTime(jCurrentTimeMillis);
            i = System.currentTimeMillis();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str, String str2) {
        if (WearUtils.e1(str)) {
            return;
        }
        try {
            Integer num = u().get(str);
            if (num != null) {
                if (num.intValue() == 0) {
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String strReplace = str2.replace(ContainerUtils.FIELD_DELIMITER, "#");
        String str3 = "save log to db：" + str + "  " + strReplace;
        LogType logType = new LogType(str, strReplace);
        logType.setId(null);
        logType.setUserId(nd3.u(t()));
        WearUtils.x.s0("lastLog", logType);
        DaoUtils.getLogDao().add((LogDao) logType);
        int i2 = u + 1;
        u = i2;
        if (i2 % 50 == 0) {
            X();
        }
        if (u >= 50000) {
            u = 0;
        }
    }

    public static void d0(String str, int i2) {
        vg3.b().a(new f(i2, str));
    }

    public static void e(String str, HashMap<String, Object> map) {
        if (WearUtils.e1(str)) {
            return;
        }
        d(str, map != null ? WearUtils.A.toJson(map) : null);
    }

    public static void f(String str) {
        LogType logType = new LogType(str, Build.MODEL + "#" + Build.VERSION.RELEASE + "#remote#" + e + "#" + be3.I().getTime());
        logType.setId(null);
        y.add(logType);
    }

    public static void g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap();
        map.put("page_name", "Control Link");
        map.put("event_id", str);
        map.put("event_type", str2);
        map.put("element_id", str3);
        map.put("element_type", str4);
        map.put("element_content", str5);
        map.put("element_name", str6);
        map.put("toys", str7);
        e("S0009", map);
    }

    public static void h(int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAddress());
        }
        String json = new Gson().toJson(arrayList);
        HashMap map = new HashMap();
        if (i2 == 1) {
            map.put("page_name", "Control Link Tips");
            map.put("event_id", "tips_exposure");
            map.put("event_type", "exposure");
            map.put("element_id", "control_link_tips");
            map.put("element_type", "");
            map.put("element_content", "tips");
            map.put("element_name", "");
            map.put(TypedValues.TransitionType.S_DURATION, "");
            map.put("toys", json);
        } else if (i2 == 2) {
            map.put("page_name", "Control Link Tips");
            map.put("event_id", "tips_get_tophy_click");
            map.put("event_type", "click");
            map.put("element_id", "tips_get_tophy");
            map.put("element_type", "button");
            map.put("element_content", "get_tophy");
            map.put("element_name", "");
            map.put(TypedValues.TransitionType.S_DURATION, "");
            map.put("toys", json);
        } else {
            map.put("page_name", "Control Link Tips");
            map.put("event_id", "tips_go_to_community_click");
            map.put("event_type", "click");
            map.put("element_id", "tips_go_to_community");
            map.put("element_type", "button");
            map.put("element_content", "go_to_community");
            map.put("element_name", "");
            map.put(TypedValues.TransitionType.S_DURATION, "");
            map.put("toys", json);
        }
        e("S0009", map);
    }

    public static void i(String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        map.put("page_name", str);
        map.put("event_id", str2);
        map.put("event_type", str3);
        map.put("element_id", str4);
        map.put("element_type", str5);
        map.put("toys", WearUtils.x.G().m());
        e("S0009", map);
    }

    public static void j(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        HashMap map = new HashMap();
        map.put("page_name", str);
        map.put("event_id", str2);
        map.put("event_type", str3);
        map.put("element_id", str4);
        if (!WearUtils.e1(str5)) {
            map.put("element_type", str5);
        }
        if (!WearUtils.e1(str6)) {
            map.put("element_content", str6);
        }
        if (!WearUtils.e1(str7)) {
            map.put("element_name", str7);
        }
        if (j2 != -1) {
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        }
        map.put("toys", WearUtils.x.G().m());
        e("S0009", map);
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8) {
        HashMap map = new HashMap();
        map.put("page_name", str);
        map.put("event_id", str2);
        map.put("event_type", str3);
        map.put("element_id", str4);
        map.put("element_type", str5);
        map.put("element_content", str6);
        map.put("element_name", str7);
        if (j2 != -1) {
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        }
        map.put("toys", str8);
        e("S0009", map);
    }

    public static synchronized void l(int i2) {
        Timer timer = x;
        if (timer != null) {
            timer.cancel();
            x = null;
        }
        String str = "run 网络变化: netWorkType=" + i2;
        int i3 = i2 == 1 ? AsyncHttpRequest.DEFAULT_TIMEOUT : 120000;
        Timer timer2 = new Timer();
        x = timer2;
        timer2.schedule(new a(i3), 5000L, i3);
    }

    public static void m() {
        y.clear();
    }

    public static void n() {
        n.clear();
        n.setRequest_id(Long.valueOf(i));
        n.setAutoLogin(Boolean.valueOf(h.isAutoLogin()));
    }

    public static void o(Map<String, String> map, boolean z) {
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, d);
        map.put("SDK_INT", Build.VERSION.SDK_INT + "");
        map.put("MODE", Build.MODEL + "");
    }

    public static void p(int i2, int i3, String str, String str2) {
        if (i2 == 0) {
            try {
                g++;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        HashMap map = new HashMap();
        map.put("isSuccess", Boolean.valueOf(i2 != 0));
        map.put("errorCount", Integer.valueOf(g));
        map.put("request_id", Long.valueOf(i));
        String str3 = h.getCurrentUrl() + SignatureImpl.INNER_SEP + h.getCurrentPort();
        if (i2 == 0) {
            map.put("errorCode", str);
            map.put("errorMessage", str2);
            if (g > 5) {
                y().clear();
                zd3.e(b, y());
            }
        } else {
            g = 0;
            if (y().get(str3) != null) {
                y().remove(str3);
                zd3.e(b, y());
            }
        }
        if (WearUtils.B) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            h.put(i3, jCurrentTimeMillis);
            h.setEndTime(jCurrentTimeMillis);
            h.settTime();
            h.setLoginResult(i2);
            map.putAll(h.getLog());
            J(i2, str3, str2, i3, map);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("#");
            sb.append(str2 != null ? str2.toString() : "");
            h.setErrorMessage(sb.toString());
            String json = WearUtils.A.toJson(h);
            String str4 = "setXmppUrl endLoginLog: " + json;
            d0(json, i2);
        } else {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            h.put(i3, jCurrentTimeMillis2);
            h.setEndTime(jCurrentTimeMillis2);
            h.settTime();
            h.setLoginResult(i2);
            map.putAll(h.getLog());
            J(i2, str3, str2, i3, map);
        }
        h.clear();
    }

    public static String q() {
        return d;
    }

    public static String r(Context context) throws PackageManager.NameNotFoundException {
        String str;
        String str2 = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str3 = packageInfo.versionName;
                if (str3 == null) {
                    str3 = "null";
                }
                String str4 = packageInfo.versionCode + "";
                str2 = "->v" + str3 + "->c" + str4;
                e = str3;
                WearUtils.r = str4;
            }
            if (context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                str = str2 + " ->BLE:true";
            } else if (((BluetoothManager) WearUtils.x.getSystemService("bluetooth")).getAdapter() == null) {
                str = str2 + " ->BLE:noBT";
            } else {
                str = str2 + " ->BLE:false";
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        return Build.MODEL + "->" + Build.VERSION.RELEASE + str;
    }

    public static String s() {
        return e;
    }

    public static String t() {
        Account accountU;
        String id = WearUtils.a;
        if (!MyApplication.Z && (accountU = ch3.n().u()) != null) {
            id = accountU.getId();
        }
        String str = zt3.k;
        return (MyApplication.Q != 1 || TextUtils.isEmpty(str)) ? id : str;
    }

    public static HashMap<String, Integer> u() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (v.size() != 0) {
            return v;
        }
        v = (HashMap) pe3.e("logFilterKey");
        if (v == null) {
            v = new HashMap<>();
        }
        return v;
    }

    public static String v(String str) {
        String logToyType;
        Toy toyQ = WearUtils.x.G().Q(str);
        if (toyQ != null) {
            logToyType = toyQ.getLogToyType();
        } else {
            Toy toyN = WearUtils.x.G().n(str);
            logToyType = toyN != null ? toyN.getLogToyType() : "";
        }
        return WearUtils.e1(logToyType) ? str.toUpperCase().replace(SignatureImpl.INNER_SEP, "") : logToyType;
    }

    public static String w() {
        int iA = se3.a(WearUtils.x);
        return iA != 0 ? iA != 1 ? iA != 2 ? iA != 3 ? iA != 4 ? EnvironmentCompat.MEDIA_UNKNOWN : "wwan_4" : "wwan_3" : "wwan_2" : "wifi" : "none";
    }

    public static String x() {
        return s;
    }

    public static Map<String, XmppUrlBean> y() {
        if (f == null) {
            f = new HashMap();
        }
        return f;
    }

    public static void z(Context context) {
        String strB = zd3.b(context, "xmpp_email");
        o = strB;
        o = WearUtils.i(strB);
        String strH = eg3.h(context, "log_session", "");
        s = strH;
        if (WearUtils.e1(strH)) {
            String string = UUID.randomUUID().toString();
            s = string;
            eg3.i(context, "log_session", string);
        }
        tz.k(s);
        xd3.a.a().b();
        w = be3.v();
        t = WearUtils.E();
        c = WearUtils.E();
        d = r(context);
        String str = "------" + d;
        o(p, false);
        o(q, true);
        l(se3.a(WearUtils.x));
        u = 0;
        if (!q().equals(eg3.h(context, "current_version", null))) {
            DaoUtils.getLogDao().cleanLogs();
            eg3.i(context, "current_version", q());
        }
        ze3.e();
        f = (Map) zd3.a(b);
    }
}
