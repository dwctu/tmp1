package dc;

import com.broadcom.bt.util.io.IOUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.packet.DefaultExtensionElement;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.roster.packet.RosterPacket;

/* compiled from: SmackRosterListener.java */
/* loaded from: classes4.dex */
public class ju3 implements RosterListener {
    public MyApplication a = WearUtils.x;
    public hu3 b;

    /* compiled from: SmackRosterListener.java */
    public class a implements zn2<String> {
        public final /* synthetic */ String a;

        public a(ju3 ju3Var, String str) {
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
            n82Var.z(WearUtils.i0(this.a));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public ju3(hu3 hu3Var) {
        this.b = hu3Var;
    }

    public final void a(User user) {
        if (user.haveFriendType(1)) {
            String strG0 = WearUtils.g0(user.getUserJid());
            UserSetting userSettingZ = WearUtils.y.z(strG0);
            ye3.d("D0004", "");
            HashMap map = new HashMap();
            map.put(PSOProgramService.JobID_Key, user.getUserJid());
            tn2.x(WearUtils.x).t("/api/user/deleteUserSettings", map, new a(this, strG0));
            UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(WearUtils.i0(strG0));
            if (userSettingsBeanG != null) {
                userSettingsBeanG.setMuteFlag(0);
            } else {
                WearUtils.x.i.F(WearUtils.i0(strG0), 0);
                WearUtils.x.i.B(false, WearUtils.i0(strG0));
            }
            String str = "jid=" + WearUtils.i0(strG0) + "&email=" + WearUtils.y.u().getId().trim() + "&isOpen=0&time=" + be3.I().getTime();
            HashMap map2 = new HashMap();
            map2.put("isChecked", String.valueOf(false).trim());
            map2.put("friendEmail", String.valueOf(strG0).trim());
            hp1.b(str, map2, true, String.valueOf(strG0).trim());
            File fileN = WearUtils.N(ch3.n().v(strG0));
            if (fileN.exists()) {
                fileN.delete();
            }
            DaoUtils.getCommunMessageDao().deleteByFriendEmail(strG0);
            DaoUtils.getUserSettingDao().delT(userSettingZ);
        }
        WearUtils.y.J(WearUtils.g0(user.getUserJid()));
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesAdded(Collection<String> collection) {
        String str = "--->entriesAdded:" + collection;
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesDeleted(Collection<String> collection) {
        String str = "--->entriesDeleted:" + collection;
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            User userV = WearUtils.y.v(WearUtils.g0(it.next()));
            if (userV != null) {
                a(userV);
            }
        }
        EventBus.getDefault().post(new UserUpdateEvent(""));
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void entriesUpdated(Collection<String> collection) {
        String str = "--->entriesUpdated:" + collection;
        boolean z = false;
        String str2 = "";
        for (String str3 : collection) {
            RosterEntry entry = hu3.C().getEntry(str3);
            String str4 = "--->address:" + collection + "==subscription==" + entry.getType() + "==ask==" + entry.getStatus();
            str2 = str2 + "address:" + collection + "\nsubscription:" + entry.getType() + "\nask:" + entry.getStatus() + IOUtils.LINE_SEPARATOR_UNIX;
            String strG0 = WearUtils.g0(str3);
            if (strG0.contains("ive")) {
                String str5 = "entriesUpdated===" + strG0;
            }
            User userV = WearUtils.y.v(strG0);
            if (userV != null) {
                if (RosterPacket.ItemType.both.equals(entry.getType())) {
                    userV.resetFriendType(1);
                } else if (RosterPacket.ItemType.to.equals(entry.getType()) && userV.haveFriendType(2)) {
                    userV.resetFriendType(1);
                    hu3.a(strG0);
                }
                z = true;
            }
        }
        if (z) {
            EventBus.getDefault().post(new UserUpdateEvent(""));
        }
    }

    @Override // org.jivesoftware.smack.roster.RosterListener
    public void presenceChanged(Presence presence) {
        UserSetting userSettingZ;
        String strG0 = WearUtils.g0(presence.getFrom());
        Account accountU = WearUtils.y.u();
        User userV = WearUtils.y.v(strG0);
        User userFindById = DaoUtils.getUserDao().findById(strG0);
        if (userV != null) {
            if (userFindById != null && !WearUtils.e1(userFindById.getRemoteAccountId())) {
                userV.setRemoteAccountId(userFindById.getRemoteAccountId());
            }
            if (presence.hasExtension("reloadVCard", "jabber:client")) {
                this.b.J(userV);
                DaoUtils.getUserDao().update(userV);
            }
            if (presence.hasExtension("toy", "jabber:client")) {
                DefaultExtensionElement defaultExtensionElement = (DefaultExtensionElement) presence.getExtension("toy", "jabber:client");
                userV.setToyName(defaultExtensionElement.getValue("name"));
                userV.setToyStatus(defaultExtensionElement.getValue("status"));
                userV.setToyDeviceId(defaultExtensionElement.getValue("deviceId"));
            }
            String strDecrypt = null;
            if (accountU != null && (userSettingZ = WearUtils.y.z(strG0)) != null && WearUtils.x1(userSettingZ.getLogNotify()) && !userV.isUserOnline() && presence.isAvailable() && (presence.getMode() == Presence.Mode.chat || presence.getMode() == Presence.Mode.dnd)) {
                String str = String.format(ah4.e(R.string.tip_friend_login), userV.getShowNickName());
                if (!this.a.f0() && !WearUtils.x.i.n(WearUtils.i0(strG0)) && !userV.isDateIng()) {
                    sg3.k(MyApplication.H(), str);
                }
            }
            if (userV.getOnline() != presence.isAvailable()) {
                userV.setOnline(presence.isAvailable());
            }
            userV.setChatType(presence.getType());
            if (presence.getMode() == Presence.Mode.available) {
                userV.setStatusMode(Presence.Mode.away);
            } else {
                userV.setStatusMode(presence.getMode());
            }
            if (presence.hasExtension("lovense", "jabber:client")) {
                DefaultExtensionElement defaultExtensionElement2 = (DefaultExtensionElement) presence.getExtension("lovense", "jabber:client");
                if (defaultExtensionElement2 != null && !WearUtils.e1(defaultExtensionElement2.getValue("data"))) {
                    strDecrypt = CommunMessage.decrypt(defaultExtensionElement2.getValue("data"));
                }
                wi2.e().a(strG0, userV, strDecrypt);
            } else {
                EventBus.getDefault().post(new UserUpdateEvent(strG0));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("presenceChanged: ");
        sb.append(strG0);
        sb.append("  ");
        sb.append(userV != null ? userV.getRemotePlatform() : "无此好友");
        sb.toString();
    }
}
