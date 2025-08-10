package dc;

import android.content.Intent;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.event.AddFriendsRequestEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.ui.longDistance.FriendsSearchListActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;

/* compiled from: SmackStanzaListener.java */
/* loaded from: classes4.dex */
public class mu3 implements StanzaListener {
    public static int c;
    public MyApplication a = WearUtils.x;
    public hu3 b;

    /* compiled from: SmackStanzaListener.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Presence.Type.values().length];
            a = iArr;
            try {
                iArr[Presence.Type.subscribe.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Presence.Type.subscribed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Presence.Type.unsubscribe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Presence.Type.unsubscribed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public mu3(hu3 hu3Var) {
        this.b = hu3Var;
    }

    @Override // org.jivesoftware.smack.StanzaListener
    public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
        Presence presence = (Presence) stanza;
        String from = presence.getFrom();
        String strG0 = WearUtils.g0(from);
        User userV = WearUtils.y.v(strG0);
        int i = a.a[presence.getType().ordinal()];
        User user = null;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    String str = "unsubscribe:getFrom==" + strG0;
                    return;
                }
                if (i != 4) {
                    return;
                }
                String str2 = "unsubscribed:getFrom==" + strG0;
                if (userV != null) {
                    boolean zIsOnlyFriendType = userV.isOnlyFriendType(1);
                    boolean zIsOnlyFriendType2 = userV.isOnlyFriendType(2);
                    boolean zIsOnlyFriendType3 = userV.isOnlyFriendType(10);
                    if (zIsOnlyFriendType || zIsOnlyFriendType2 || zIsOnlyFriendType3) {
                        if (zIsOnlyFriendType || zIsOnlyFriendType3) {
                            userV.resetFriendType(8);
                        } else {
                            userV.resetFriendType(16);
                        }
                    }
                }
                ye3.d("D0004", "");
                LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
                return;
            }
            String str3 = "subscribed:getFrom==" + strG0;
            if (userV == null) {
                userV = new User(strG0);
                ch3.n().m(userV);
                WearUtils.y.b(userV);
            } else if (userV.getIagree() == 1 && userV.getFagree() == 1) {
                synchronized (ch3.h) {
                    ch3 ch3Var = WearUtils.y;
                    ch3.j.remove(userV);
                }
                UserSetting userSettingZ = WearUtils.y.z(userV.getId());
                if (userSettingZ != null && !userSettingZ.isFriendsRequestClick()) {
                    userSettingZ.setFriendsRequestClick(true);
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                    df3.e().c(userV.getId());
                    c--;
                }
                ch3.n().a(userV.getId());
                userV.setTempName(null);
                userV.resetAddFriendInfo();
            }
            userV.resetFriendType(1);
            hu3.a(strG0);
            EventBus.getDefault().post(new UserUpdateEvent(""));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("subscribe:getFrom==");
        sb.append(strG0);
        sb.append("==");
        sb.append(Looper.myLooper() == Looper.getMainLooper());
        sb.toString();
        if (this.a.i.k(from)) {
            return;
        }
        if (userV != null && userV.canAutomaticAddFriend()) {
            if (userV.getIagree() == 1 && userV.getFagree() == 1) {
                ch3.n().a(userV.getId());
                userV.setTempName(null);
                userV.resetAddFriendInfo();
            }
            userV.resetFriendType(1);
            hu3.a(strG0);
            EventBus.getDefault().post(new UserUpdateEvent(""));
            return;
        }
        if (userV == null) {
            userV = new User(strG0);
            ch3.n().m(userV);
        } else if (userV.isFriend()) {
            return;
        }
        userV.resetFriendType(4);
        if (WearUtils.w1(strG0)) {
            hu3.a(strG0);
            return;
        }
        WearUtils.y.b(userV);
        synchronized (ch3.h) {
            for (int i2 = 0; i2 < ch3.j.size(); i2++) {
                if (ch3.j.get(i2).getId().equals(userV.getId())) {
                    user = ch3.j.get(i2);
                }
            }
            if (user != null) {
                return;
            }
            ch3.j.add(0, userV);
            if (this.a.i.q(from)) {
                return;
            }
            UserSetting userSettingZ2 = WearUtils.y.z(userV.getId());
            AddFriendsRequestEvent addFriendsRequestEvent = new AddFriendsRequestEvent();
            addFriendsRequestEvent.user = userV;
            if (MyApplication.K instanceof FriendsSearchListActivity) {
                if (userSettingZ2 != null) {
                    if (userSettingZ2.isFriendsRequestClick()) {
                        addFriendsRequestEvent.flag = 1;
                    } else {
                        addFriendsRequestEvent.flag = 0;
                    }
                    userSettingZ2.setFriendsRequestClick(true);
                    userSettingZ2.setAddTime(System.currentTimeMillis());
                    DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ2);
                }
                EventBus.getDefault().post(addFriendsRequestEvent);
            }
            if (!userSettingZ2.isFriendsRequestClick()) {
                c++;
                userSettingZ2.setAddTime(System.currentTimeMillis());
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ2);
                df3.e().a(strG0);
                LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
                addFriendsRequestEvent.flag = 2;
                EventBus.getDefault().post(addFriendsRequestEvent);
            }
        }
    }
}
