package dc;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.bean.FindMatchUserBean;
import com.wear.bean.FriendEmailBean;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.RouletteEndBean;
import com.wear.bean.RoulettePublicBean;
import com.wear.bean.User;
import com.wear.bean.UserAcceptBean;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.UserRejectBean;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.chat.RouletteUser;
import com.wear.bean.event.ChatGPTEvent;
import com.wear.bean.event.ChatGPTType;
import com.wear.bean.socketio.timestamp.TimestampResponse;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.protocol.CommunMessage;
import com.wear.ui.chat.NewChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: GeneralManagerImpl.java */
/* loaded from: classes3.dex */
public class e42 implements tf2 {
    public static e42 a;

    public static e42 i() {
        if (a == null) {
            synchronized (e42.class) {
                if (a == null) {
                    a = new e42();
                }
            }
        }
        return a;
    }

    public static /* synthetic */ void j(FragmentActivity fragmentActivity) {
        Intent intent = new Intent(fragmentActivity, (Class<?>) LoginActivity.class);
        intent.addFlags(268468224);
        fragmentActivity.startActivity(intent);
    }

    public static /* synthetic */ void k() {
        if (WearUtils.y.u() != null) {
            ep1.b().h(1);
            String strE = ah4.e(R.string.notification_change_email1);
            final FragmentActivity fragmentActivity = MyApplication.K;
            cs3.k(fragmentActivity, strE, new is3.d() { // from class: dc.d42
                @Override // dc.is3.d
                public final void doConfirm() {
                    e42.j(fragmentActivity);
                }
            }).show();
        }
    }

    public void a(String str) {
        MyApplication.N().m.post(new Runnable() { // from class: dc.c42
            @Override // java.lang.Runnable
            public final void run() {
                e42.k();
            }
        });
    }

    public void b(String str) {
        MyApplication.H();
        EventBus.getDefault().post(new ChatGPTEvent(ChatGPTType.PATTERN, JSON.parseObject(str).getString("sessionTaskId")));
    }

    public void c(String str) {
        EventBus.getDefault().post(new ChatGPTEvent(ChatGPTType.STORY, JSON.parseObject(str).getString("sessionTaskId")));
    }

    @Override // dc.tf2
    public void connectSuc() {
    }

    public void d() {
        EventBus.getDefault().post(new UserAcceptBean());
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void e() {
        EventBus.getDefault().post(new UserRejectBean());
    }

    public void f(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    public void g(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (MyApplication.H() instanceof NewChatActivity) {
            EventBus.getDefault().post(new RouletteEndBean());
        } else {
            my2.i.a().y(false);
            sg3.l(MyApplication.H().getString(R.string.control_roulette_end_session2));
        }
    }

    public void h(String str) {
        String str2 = "msg===" + str;
        EventBus.getDefault().post((FindMatchUserBean) JSON.parseObject(str, FindMatchUserBean.class));
    }

    public void l(String str) {
        EventBus.getDefault().post(new bx3());
        ye3.d("Z0013", "刷新Ntoken，重连SocketIO");
    }

    public void m(TimestampResponse timestampResponse) {
    }

    public void n(String str) {
        String str2 = "收到事件:" + str;
        UserJoinChatBean userJoinChatBean = (UserJoinChatBean) WearUtils.A.fromJson(str, UserJoinChatBean.class);
        RouletteUser rouletteUser = new RouletteUser();
        rouletteUser.setFriendId(userJoinChatBean.getUserAccountCode());
        RoulettePublicBean publicKey = userJoinChatBean.getPublicKey();
        if (publicKey != null && publicKey.getData() != null) {
            rouletteUser.setPublicKey(publicKey.getData());
        }
        DaoUtils.getRouletteUserDao().add(rouletteUser);
        EventBus.getDefault().post(userJoinChatBean);
    }

    public void o(String str) {
        FriendEmailBean friendEmailBean = (FriendEmailBean) JSON.parseObject(str, FriendEmailBean.class);
        User userFindRemoteAccountIdByIds = DaoUtils.getUserDao().findRemoteAccountIdByIds(friendEmailBean.getRemoteAccountId());
        String id = userFindRemoteAccountIdByIds.getId();
        String strG = nd3.g(friendEmailBean.getEmail());
        Map<String, User> mapY = ch3.n().y();
        User userFindById = mapY.get(id);
        if (userFindById == null) {
            userFindById = DaoUtils.getUserDao().findById(id);
        }
        mapY.remove(userFindById.getId());
        userFindById.setId(strG);
        userFindById.setAvatar(userFindRemoteAccountIdByIds.getAvatar());
        userFindById.setName(userFindRemoteAccountIdByIds.getUserName());
        userFindById.setRemoteAccountId(friendEmailBean.getRemoteAccountId());
        mapY.put(strG, userFindById);
        User user = new User();
        user.setId(strG);
        user.setRemoteAccountId(friendEmailBean.getRemoteAccountId());
        user.setName(userFindRemoteAccountIdByIds.getUserName());
        if (!TextUtils.isEmpty(userFindRemoteAccountIdByIds.getAvatar())) {
            user.setAvatar(userFindRemoteAccountIdByIds.getAvatar());
        } else if (WearUtils.e1(userFindById.getAvatar())) {
            String str2 = "头像链接" + userFindRemoteAccountIdByIds.getAvatarBitmapUrl();
            user.setAvatar(zb2.O().M(WearUtils.i0(id)));
        } else {
            user.setAvatar(userFindById.getAvatar());
        }
        DaoUtils.getUserDao().delT(userFindRemoteAccountIdByIds);
        DaoUtils.getUserDao().add(user);
        ch3.n().Q();
        DaoUtils.updateFriendEmail(id, strG);
        df3.e().i();
        f42 f42Var = new f42();
        f42Var.d(id);
        f42Var.c(strG);
        zb2.O().r0(WearUtils.i0(strG), userFindRemoteAccountIdByIds.getAvatar());
        List<String> listF = WearUtils.x.i.f(0);
        if (listF != null && listF.size() > 0) {
            for (int i = 0; i < listF.size(); i++) {
                if (WearUtils.i0(id).equals(listF.get(i))) {
                    listF.set(i, WearUtils.i0(strG));
                }
            }
        }
        List<String> byMessageMuteList = WearUtils.x.i.a.getByMessageMuteList();
        if (byMessageMuteList != null && byMessageMuteList.size() > 0) {
            for (int i2 = 0; i2 < byMessageMuteList.size(); i2++) {
                if (byMessageMuteList.get(i2).equals(WearUtils.i0(id))) {
                    byMessageMuteList.set(i2, WearUtils.i0(strG));
                }
            }
        }
        List<UserSettingsBean> userSettings = WearUtils.x.i.a.getUserSettings();
        if (userSettings != null && userSettings.size() > 0) {
            for (int i3 = 0; i3 < userSettings.size(); i3++) {
                if (userSettings.get(i3).getJid().equals(WearUtils.i0(id)) && userSettings.get(i3).getMuteFlag() == 1) {
                    userSettings.get(i3).setJid(WearUtils.i0(strG));
                }
            }
        }
        Map<String, Group> mapL = ch3.n().l();
        if (mapL != null && mapL.size() > 0) {
            for (Group group : mapL.values()) {
                Iterator<GroupMember> it = group.getMembers().values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        GroupMember next = it.next();
                        if (next.getJid().equals(WearUtils.i0(id))) {
                            next.setJid(WearUtils.i0(strG));
                            group.getMembers().put(WearUtils.i0(strG), next);
                            group.getMembers().remove(WearUtils.i0(id));
                            CommunMessage lastMessage = group.getLastMessage();
                            if (lastMessage.getRealFrom().equals(WearUtils.i0(id))) {
                                lastMessage.setRealFrom(WearUtils.i0(strG));
                            }
                        }
                    }
                }
            }
        }
        EventBus.getDefault().post(f42Var);
    }
}
