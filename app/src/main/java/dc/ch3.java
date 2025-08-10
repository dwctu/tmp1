package dc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.ControlLinkCreatorToyBean;
import com.wear.bean.Group;
import com.wear.bean.Toy;
import com.wear.bean.TypingBean;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.TypingEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.network.presenter.bean.AppCodeBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomExit;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* compiled from: UsersInstance.java */
/* loaded from: classes4.dex */
public class ch3 {
    public static final Object h = new Object();
    public static List<IPeopleInfo> i = Collections.synchronizedList(new ArrayList());
    public static List<User> j = Collections.synchronizedList(new ArrayList());
    public static List<TypingBean> k = Collections.synchronizedList(new ArrayList());
    public static volatile ch3 l = null;
    public Account b;
    public Timer f;
    public TimerTask g;
    public LoginUserBean a = new LoginUserBean();
    public Map<String, User> c = new HashMap();
    public Map<String, UserSetting> d = new ConcurrentHashMap();
    public Map<String, Group> e = new HashMap();

    /* compiled from: UsersInstance.java */
    public class a extends TimerTask {
        public a(ch3 ch3Var) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            List<TypingBean> list = ch3.k;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (TypingBean typingBean : ch3.k) {
                long jD = be3.d(typingBean.getCreated());
                if (typingBean.isTyping() && be3.r() > jD + 3000) {
                    typingBean.setTyping(false);
                }
            }
            EventBus.getDefault().post(new TypingEvent());
        }
    }

    /* compiled from: UsersInstance.java */
    public class b extends TypeToken<List<AppCodeBean>> {
        public b(ch3 ch3Var) {
        }
    }

    /* compiled from: UsersInstance.java */
    public class c implements zn2<String> {
        public final /* synthetic */ String a;

        public c(ch3 ch3Var, String str) {
            this.a = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            n82 n82Var;
            MyApplication myApplication = WearUtils.x;
            if (myApplication == null || (n82Var = myApplication.i) == null) {
                return;
            }
            n82Var.z(WearUtils.j0(this.a));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    /* compiled from: UsersInstance.java */
    public class d extends HashMap<String, String> {
        public d() {
            put("count", "" + ch3.i.size());
        }
    }

    /* compiled from: UsersInstance.java */
    public class e implements Runnable {
        public final /* synthetic */ String a;

        public e(ch3 ch3Var, String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            hu3.b0(this.a);
        }
    }

    public ch3() {
        try {
            if (pe3.d("NEW_DATA") <= 0) {
                Map<String, ?> mapC = eg3.c(WearUtils.x);
                if (mapC != null) {
                    for (String str : mapC.keySet()) {
                        if (str != null && (str.contains("chat-open-more-") || str.contains("show_orgy_banner_key") || str.contains("orgy_activitys_"))) {
                            eg3.m(WearUtils.x, str);
                        }
                    }
                }
                pe3.i("NEW_DATA", 1);
                try {
                    SharedPreferences.Editor editorEdit = WearUtils.x.getSharedPreferences("Cookies_Prefs", 0).edit();
                    editorEdit.clear();
                    editorEdit.commit();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        E();
    }

    public static synchronized ch3 n() {
        if (l == null) {
            synchronized (ch3.class) {
                if (l == null) {
                    l = new ch3();
                }
            }
        }
        return l;
    }

    public void A() {
        F();
        D();
        B();
        G();
        C();
    }

    public final void B() {
        String strC = zd3.c("block");
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        try {
            WearUtils.x.i.j(strC, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void C() {
        if (this.e.size() == 0) {
            this.e = (Map) zd3.a("group");
        }
        if (this.e == null) {
            this.e = new HashMap();
        }
    }

    public final void D() {
        LoginUserBean loginUserBean = (LoginUserBean) zd3.a("loginUserBean");
        if (loginUserBean != null) {
            this.a = loginUserBean;
        }
    }

    public final void E() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
        TimerTask timerTask = this.g;
        if (timerTask != null) {
            timerTask.cancel();
            this.g = null;
        }
        this.f = new Timer();
        a aVar = new a(this);
        this.g = aVar;
        this.f.schedule(aVar, 3000L, 3000L);
    }

    public final void F() {
        Account account = (Account) zd3.a("user");
        if (account != null) {
            this.b = account;
        }
    }

    public final void G() {
        if (this.c.size() == 0) {
            this.c = (Map) zd3.a("userMap");
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
    }

    public final void H(AppCodeBean appCodeBean) {
        String str = "putAppCodeBean: 接口获取的=" + appCodeBean.toString();
        String strH = eg3.h(MyApplication.N(), "email_app_code", "");
        if (TextUtils.isEmpty(strH)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(appCodeBean);
            eg3.i(MyApplication.N(), "email_app_code", ro2.c(arrayList));
            return;
        }
        try {
            List<AppCodeBean> list = (List) WearUtils.A.fromJson(strH, new b(this).getType());
            if (list == null || list.size() <= 0) {
                return;
            }
            boolean z = false;
            for (AppCodeBean appCodeBean2 : list) {
                if (TextUtils.equals(appCodeBean.getEmail(), appCodeBean2.getEmail())) {
                    if (!TextUtils.equals(appCodeBean.getAppAccountCode(), appCodeBean2.getAppAccountCode())) {
                        break;
                    } else {
                        z = true;
                    }
                }
            }
            if (z) {
                return;
            }
            list.add(appCodeBean);
            eg3.i(MyApplication.N(), "email_app_code", WearUtils.A.toJson(list));
        } catch (JsonSyntaxException e2) {
            String str2 = "putAppCodeBean: 解析json错误=" + e2.getMessage();
        }
    }

    public void I(String str, dv1 dv1Var) {
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, WearUtils.j0(str));
        IPeopleInfo iPeopleInfoS = n().s(str);
        tn2.x(WearUtils.x).t("/api/user/deleteUserSettings", map, new c(this, str));
        WearUtils.x.q("longDistance_remove_friend", new d());
        UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(WearUtils.j0(str));
        if (userSettingsBeanG != null) {
            userSettingsBeanG.setMuteFlag(0);
        } else {
            WearUtils.x.i.F(WearUtils.j0(str), 0);
            if (iPeopleInfoS != null && !iPeopleInfoS.isGroup()) {
                WearUtils.x.i.B(false, WearUtils.j0(str));
            }
        }
        String str2 = "jid=" + WearUtils.j0(str) + "&isOpen=0&time=" + be3.I().getTime();
        HashMap map2 = new HashMap();
        map2.put("isChecked", String.valueOf(false).trim());
        map2.put("friendEmail", String.valueOf(str).trim());
        hp1.b(str2, map2, true, String.valueOf(str).trim());
        UserSetting userSettingZ = n().z(str);
        File fileN = WearUtils.N(iPeopleInfoS);
        if (fileN.exists()) {
            fileN.delete();
        }
        DaoUtils.getCommunMessageDao().deleteByFriendEmail(str);
        DaoUtils.getUserSettingDao().delT(userSettingZ);
        DaoUtils.getMessageUnReadDao().deleteAllUnRead(WearUtils.y.p(), WearUtils.j0(str));
        n().L(userSettingZ);
        if (iPeopleInfoS != null) {
            if (iPeopleInfoS.isGroup()) {
                n().K(str);
            } else {
                n().J(str);
            }
        }
        if (dv1Var != null) {
            dv1Var.d();
        }
        try {
            if (!iPeopleInfoS.isGroup()) {
                vg3.b().a(new e(this, str));
                WearUtils.x.i.a.getFriendBlack().remove(WearUtils.j0(str));
            } else {
                RequestRoomExit requestRoomExit = new RequestRoomExit();
                requestRoomExit.setRoomId(str);
                requestRoomExit.setStatus(3);
                zb2.O().C0(requestRoomExit, WearUtils.j0(str), null);
            }
        } catch (Exception unused) {
        }
    }

    public void J(String str) {
        this.c.remove(str);
        Q();
        this.d.remove(str);
        df3.e().c(str);
    }

    public void K(String str) {
        this.e.remove(str);
        N();
        this.d.remove(str);
        df3.e().c(str);
    }

    public void L(UserSetting userSetting) {
        if (userSetting != null) {
            this.d.remove(userSetting);
        }
    }

    public void M(String str) {
        zd3.f("block", str);
    }

    public void N() {
        Map<String, Group> map = this.e;
        if (map != null) {
            zd3.e("group", map);
        }
    }

    public final void O() {
        zd3.e("loginUserBean", this.a);
    }

    public void P() {
        zd3.e("user", this.b);
    }

    public void Q() {
        Map<String, User> map = this.c;
        if (map != null) {
            zd3.e("userMap", map);
        }
    }

    public void R(String str) {
        Account account = this.b;
        if (account != null) {
            account.setControlLinkId(str);
        }
    }

    public void S(Toy toy) {
        Account account = this.b;
        if (account != null) {
            account.setControlLinkToys(toy);
        }
    }

    public void T(String str) {
        Account account = this.b;
        if (account != null) {
            account.setControlLinkUserId(str);
        }
    }

    public void U(LoginUserBean loginUserBean) {
        if (loginUserBean == null) {
            return;
        }
        this.a = loginUserBean;
        WearUtils.x.j = loginUserBean.getLogAccept();
        db2.A().R(loginUserBean.getWs_server_url());
        H(new AppCodeBean(loginUserBean.getAppAccountCode(), loginUserBean.getEmail()));
        O();
    }

    public void V(Account account) {
        this.b = account;
        if (account != null) {
            P();
        }
    }

    public void W(Map<String, User> map) {
        this.c = map;
        Q();
    }

    public boolean X() {
        return o() != null && o().getSyncPatternSwitch() == 1;
    }

    public boolean Y() {
        return o() != null && o().getSyncPatternTips() == 1;
    }

    public void Z(ControlLinkBean controlLinkBean) {
        d();
        List<ControlLinkCreatorToyBean> toys = controlLinkBean.getCreator().getToys();
        if (toys == null || toys.size() <= 0) {
            ArrayList<Toy> arrayListP = WearUtils.x.G().P();
            if (arrayListP.size() > 0) {
                Iterator<Toy> it = arrayListP.iterator();
                while (it.hasNext()) {
                    S(it.next());
                }
                return;
            }
            return;
        }
        for (ControlLinkCreatorToyBean controlLinkCreatorToyBean : toys) {
            if (!WearUtils.e1(controlLinkCreatorToyBean.getId())) {
                Toy toy = new Toy();
                toy.setDeviceId(controlLinkCreatorToyBean.getId());
                tu1.a(toy);
                try {
                    toy.setVersion(Integer.valueOf(Integer.parseInt(controlLinkCreatorToyBean.getType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                } catch (Exception unused) {
                }
                Toy toyR = WearUtils.x.G().R(controlLinkCreatorToyBean.getId());
                if (toyR != null) {
                    toy.setAddress(toyR.getAddress());
                    toy.setName(toyR.getName());
                    toy.synNameToType();
                    toy.setBattery(toyR.getBattery());
                    toy.setVersion(toyR.getVersion());
                    toy.setStatus(toyR.isConnected() ? 1 : 0);
                    toy.setIsSelect(Integer.valueOf(toyR.isSelect() ? 1 : 0));
                } else {
                    toy.setName(jf3.b(controlLinkCreatorToyBean.getType()));
                    toy.synNameToType();
                    try {
                        if (controlLinkCreatorToyBean.getFVersion() != null) {
                            toy.setVersion(Integer.valueOf(Integer.parseInt(controlLinkCreatorToyBean.getFVersion())));
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                    toy.setStatus(WearUtils.y1(controlLinkCreatorToyBean.getStatus()) ? 1 : 0);
                    toy.setBattery(!WearUtils.e1(controlLinkCreatorToyBean.getBattery()) ? Integer.parseInt(controlLinkCreatorToyBean.getBattery()) : 60);
                    toy.setIsSelect(1);
                }
                S(toy);
            }
        }
    }

    public void a(String str) {
        User user = this.c.get(str);
        if (user == null || user.isAddMessage()) {
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(user.getUserJid());
        communMessage.setUserId(n().p());
        communMessage.setTo(WearUtils.y.p());
        EntityChat entityChat = new EntityChat();
        entityChat.setText(String.format(ah4.e(R.string.str_is_from_forum), user.getTempName()));
        communMessage.sendEntity(entityChat);
        communMessage.setId(WearUtils.E());
        DaoUtils.getCommunMessageDao().add(communMessage);
        DaoUtils.getCommunMessageDao().upDateByFriendEmail(user.getId(), 2);
        df3.e().l(user.getUserJid(), communMessage.getId());
        user.setAddMessage(true);
        EventBus.getDefault().post(new UserUpdateEvent(""));
    }

    public void b(User user) {
        if (this.c.containsKey(user.getId())) {
            return;
        }
        this.c.put(user.getId(), user);
        Q();
    }

    public void c(UserSetting userSetting) {
        if (userSetting != null) {
            String friendUserId = userSetting.getFriendUserId();
            if (this.d.containsKey(friendUserId)) {
                return;
            }
            this.d.put(friendUserId, userSetting);
        }
    }

    public void d() {
        Account account = this.b;
        if (account != null) {
            account.clearControlLinkToys();
        }
    }

    public void e() {
        pe3.a("userMap");
        pe3.a("loginUserBean");
        pe3.a("user");
        pe3.a("block");
        pe3.a("group");
    }

    public void f() {
        this.c.clear();
        Q();
        this.d.clear();
        this.e.clear();
        N();
    }

    public void g(String str) {
        User user = this.c.get(str);
        if (user == null) {
            J(str);
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(str);
            return;
        }
        user.deleteFriendType(32);
        if (user.isOnlyFriendType(16)) {
            J(str);
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(str);
        } else {
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(str, 2);
        }
        user.setTempName(null);
    }

    public Map<String, IPeopleInfo> h() {
        HashMap map = new HashMap();
        map.putAll(this.c);
        map.putAll(this.e);
        return map;
    }

    public String i() {
        Account account = this.b;
        return account != null ? account.getControlLinkId() : "";
    }

    public String j() {
        Account account = this.b;
        return account != null ? account.getControlLinkUserId() : "";
    }

    public Group k(String str) {
        return this.e.get(str);
    }

    public Map<String, Group> l() {
        return this.e;
    }

    public User m(User user) {
        try {
            VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(WearUtils.i0(user.getId()));
            if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                user.setName(vCardLoadVCard.getNickName());
            }
            if (!WearUtils.i1(vCardLoadVCard.getAvatar())) {
                WearUtils.s2(new String(vCardLoadVCard.getAvatar(), "ISO-8859-1"), user);
            }
            user.setMoodMessage(vCardLoadVCard.getField("MOODMESSAGE"));
            user.setAge(vCardLoadVCard.getField("AGE"));
            user.setFriendGTMTime(vCardLoadVCard.getField("GMTTIME"));
            user.setDeviceType(vCardLoadVCard.getField("DEVICETYPE"));
            user.setDeviceAppVersion(vCardLoadVCard.getField("APPVERSION"));
        } catch (Exception unused) {
        }
        return user;
    }

    public LoginUserBean o() {
        return this.a;
    }

    public String p() {
        Account account = this.b;
        return account != null ? WearUtils.i0(account.getId()) : "";
    }

    public String q() {
        if (this.b == null) {
            return "";
        }
        return WearUtils.i0(this.b.getId()) + "/wearable";
    }

    public String r() {
        if (this.b == null) {
            return "";
        }
        String str = "account = " + this.b;
        return this.b.getId();
    }

    public IPeopleInfo s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        User user = this.c.get(str);
        return user == null ? this.e.get(str) : user;
    }

    public User t(String str) {
        if (WearUtils.e1(str)) {
            return null;
        }
        for (User user : j) {
            if (str.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    @Nullable
    public Account u() {
        return this.b;
    }

    public User v(String str) {
        if (WearUtils.e1(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public User w(String str) {
        if (!WearUtils.e1(str)) {
            if (WearUtils.G2(str)) {
                return v(str);
            }
            for (Map.Entry<String, User> entry : this.c.entrySet()) {
                String userName = entry.getValue().getUserName();
                if (!WearUtils.e1(userName) && str.equals(userName)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public Account x() {
        if (this.b == null) {
            F();
        }
        return this.b;
    }

    public Map<String, User> y() {
        return this.c;
    }

    public UserSetting z(String str) {
        UserSetting userSettingFindUserSettingsByUserIdAndFriendUserId = this.d.get(str);
        if (userSettingFindUserSettingsByUserIdAndFriendUserId == null) {
            userSettingFindUserSettingsByUserIdAndFriendUserId = DaoUtils.getUserSettingDao().findUserSettingsByUserIdAndFriendUserId(WearUtils.y.r(), str);
            if (userSettingFindUserSettingsByUserIdAndFriendUserId == null) {
                userSettingFindUserSettingsByUserIdAndFriendUserId = new UserSetting();
                userSettingFindUserSettingsByUserIdAndFriendUserId.setUserId(WearUtils.y.r());
                userSettingFindUserSettingsByUserIdAndFriendUserId.setFriendUserId(str);
                userSettingFindUserSettingsByUserIdAndFriendUserId.setAudioVibration(Boolean.FALSE);
                DaoUtils.getUserSettingDao().add((UserSettingDao) userSettingFindUserSettingsByUserIdAndFriendUserId);
            }
            c(userSettingFindUserSettingsByUserIdAndFriendUserId);
        }
        return userSettingFindUserSettingsByUserIdAndFriendUserId;
    }
}
