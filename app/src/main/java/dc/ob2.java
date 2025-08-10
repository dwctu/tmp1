package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.OpenAppBean;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.event.InDateActivityEvent;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.bean.socketio.date.request.AppUserStatusBean;
import com.wear.bean.socketio.date.request.AppUserToysBean;
import com.wear.bean.socketio.date.request.DateBean;
import com.wear.bean.socketio.date.request.ForumEngagementCheckBean;
import com.wear.bean.socketio.date.request.ForumEngagementFriendNoticeBean;
import com.wear.bean.socketio.date.request.ForumEngagementGetToysBean;
import com.wear.bean.socketio.date.request.ForumEngagementOnRoomBean;
import com.wear.bean.socketio.date.request.ForumEngagementOverBean;
import com.wear.bean.socketio.date.request.ForumEngagementPersonBean;
import com.wear.bean.socketio.date.response.ForumEngagementCancelDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementCheckNoticeDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementInfoDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementNoticeBean;
import com.wear.bean.socketio.date.response.ForumEngagementOverNoticeDTOBean;
import com.wear.bean.socketio.date.response.UserInfoDao;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* compiled from: DateManagerImpl.java */
/* loaded from: classes3.dex */
public class ob2 implements tf2 {
    public static String i;
    public static ob2 j;
    public boolean b;
    public Dialog c;
    public String d;
    public Dialog e;
    public HashMap<String, String> h;
    public Handler a = new Handler(Looper.getMainLooper());
    public Runnable f = new a();
    public String g = "";

    /* compiled from: DateManagerImpl.java */
    public class a implements Runnable {

        /* compiled from: DateManagerImpl.java */
        /* renamed from: dc.ob2$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnDismissListenerC0206a implements DialogInterface.OnDismissListener {
            public DialogInterfaceOnDismissListenerC0206a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ob2.this.e = null;
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ob2.this.a.postDelayed(ob2.this.f, 60000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            InDateActivityEvent inDateActivityEvent = new InDateActivityEvent();
            inDateActivityEvent.flag = 1;
            EventBus.getDefault().post(inDateActivityEvent);
            ob2.this.a.removeCallbacks(ob2.this.f);
            if (ob2.this.e != null) {
                ob2.this.e = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivity = MyApplication.K;
            User userV = ch3.n().v(ob2.this.d);
            if (userV == null || !userV.isDateIng() || fragmentActivity == null || fragmentActivity.isDestroyed() || !(fragmentActivity instanceof ChatActivity)) {
                return;
            }
            String str = String.format(ah4.e(R.string.str_wait_date_tip), userV.getTempName());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) str);
            int iIndexOf = str.indexOf(userV.getTempName());
            if (iIndexOf != -1 && userV.getTempName().length() + iIndexOf <= spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(fragmentActivity, R.color.color_accent)), iIndexOf, userV.getTempName().length() + iIndexOf, 34);
            }
            ob2.this.j();
            ob2.this.e = cs3.d(fragmentActivity, spannableStringBuilder, ah4.e(R.string.str_wait_date_tip_ok), ah4.e(R.string.str_wait_date_tip_no), new is3.d() { // from class: dc.gb2
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.b();
                }
            }, new is3.c() { // from class: dc.fb2
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.d();
                }
            });
            ob2.this.e.show();
            ob2.this.e.setOnDismissListener(new DialogInterfaceOnDismissListenerC0206a());
        }
    }

    /* compiled from: DateManagerImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ User c;

        public b(ob2 ob2Var, boolean z, Activity activity, User user) {
            this.a = z;
            this.b = activity;
            this.c = user;
        }

        @Override // java.lang.Runnable
        public void run() {
            EntitySystem entitySystem = new EntitySystem();
            if (this.a) {
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C322.toString(), null);
            } else {
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C323.toString(), null);
            }
            zb2.O().F0(this.b, this.c.getUserJid(), entitySystem);
        }
    }

    public static ob2 o() {
        if (j == null) {
            synchronized (ob2.class) {
                if (j == null) {
                    j = new ob2();
                }
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        H(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(ForumEngagementPersonBean forumEngagementPersonBean, UserInfoDao userInfoDao) {
        forumEngagementPersonBean.receiverIsAgree = Boolean.TRUE;
        h(forumEngagementPersonBean);
        OpenAppBean openAppBean = new OpenAppBean();
        openAppBean.type = 0;
        openAppBean.userId = userInfoDao.getFriendId();
        openAppBean.receiverName = userInfoDao.getFriendName();
        openAppBean.datingId = userInfoDao.getDatingId();
        MyApplication.v0(openAppBean);
        this.c = null;
        i = userInfoDao.getDatingId();
        EventBus.getDefault().post(new InDateActivityEvent());
        WearUtils.x.q("date_accept", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(ForumEngagementPersonBean forumEngagementPersonBean) {
        forumEngagementPersonBean.receiverIsAgree = Boolean.FALSE;
        this.c = null;
        i = null;
        h(forumEngagementPersonBean);
        WearUtils.x.q("date_decline", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(DialogInterface dialogInterface) {
        this.c = null;
    }

    public boolean F(String str, String str2) {
        return false;
    }

    public void G(String str) {
        int i2;
        Toy toy;
        if (ch3.n().u() == null) {
            return;
        }
        pc1 pc1VarG = WearUtils.x.G();
        ArrayList<Toy> arrayListO = pc1VarG.o();
        ArrayList arrayList = new ArrayList();
        synchronized (arrayListO) {
            toy = arrayListO.size() > 0 ? arrayListO.get(0) : null;
            Iterator<Toy> it = arrayListO.iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect() && pc1VarG.a(next.getAddress()) && next.isSelect()) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 0) {
            toy = (Toy) arrayList.get(0);
        }
        String deviceType = toy == null ? "" : toy.getDeviceType();
        if (!WearUtils.e1(deviceType) && deviceType.split(SignatureImpl.INNER_SEP).length == 3) {
            String lowerCase = toy.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
            if (lowerCase.endsWith(";")) {
                lowerCase.substring(0, lowerCase.length() - 1);
            }
        }
        SyncLinkToy syncLinkToy = new SyncLinkToy();
        syncLinkToy.setPlatform(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        syncLinkToy.setV(100);
        syncLinkToy.setVersion(ye3.s());
        if (arrayListO.size() > 0) {
            Iterator<Toy> it2 = arrayListO.iterator();
            while (it2.hasNext()) {
                Toy next2 = it2.next();
                SyncLinkToy.ToysBean toysBeanFromToy = SyncLinkToy.getToysBeanFromToy(next2);
                if (next2.isSupportLdr()) {
                    toysBeanFromToy.setIsSupportLdr(1);
                }
                if (next2.isSelect()) {
                    syncLinkToy.addToys(toysBeanFromToy);
                }
            }
        }
        AppUserToysBean appUserToysBean = new AppUserToysBean();
        appUserToysBean.toys = "";
        String jSONString = JSON.toJSONString(syncLinkToy);
        xe3.a("Toy", jSONString);
        appUserToysBean.toyJson = m(jSONString);
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            appUserToysBean.toys += ((Toy) arrayList.get(i2)).getName();
            if (i2 < size - 1) {
                appUserToysBean.toys += ",";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.E());
        sb.append(WearUtils.B ? Constants.FILENAME_SEQUENCE_SEPARATOR + str : "");
        appUserToysBean.requestId = sb.toString();
        if (!WearUtils.e1(appUserToysBean.toyJson)) {
            if (!this.g.equals(appUserToysBean.toyJson)) {
                h(appUserToysBean);
            }
            this.g = appUserToysBean.toyJson;
        }
        r32.l().x();
    }

    public void H(int i2) {
        Account accountU = ch3.n().u();
        if (accountU == null) {
            return;
        }
        AppUserStatusBean appUserStatusBean = new AppUserStatusBean();
        if (accountU.getLiveStatus() == 0) {
            appUserStatusBean.controlStatus = "no";
            if (i2 != 0 && i2 == 1) {
                appUserStatusBean.controlStatus = "controlLink";
            }
        } else if (ChatLiveControl.q0().z()) {
            appUserStatusBean.controlStatus = MessageType.live.toString();
        } else if (ChatSyncControl.N0().z()) {
            appUserStatusBean.controlStatus = MessageType.sync.toString();
        } else if (ChatVideoControl.a1().z()) {
            if (ChatVideoControl.a1().k1()) {
                appUserStatusBean.controlStatus = MessageType.video.toString();
            } else {
                appUserStatusBean.controlStatus = MessageType.voice.toString();
            }
        } else if (ChatGroupControl.o1().z()) {
            appUserStatusBean.controlStatus = "roomSync";
        }
        if (sz1.d().f(32)) {
            appUserStatusBean.controlStatus = "mediaPlayer";
        }
        if (sz1.d().f(64)) {
            appUserStatusBean.controlStatus = "mediaPlayer";
        }
        if (r32.l().n()) {
            appUserStatusBean.controlStatus = "vrGame";
        }
        if (sz1.d().f(1024)) {
            appUserStatusBean.controlStatus = "displayPanel";
        }
        Presence.Mode statusMode = accountU.getStatusMode();
        if (statusMode == Presence.Mode.chat) {
            AppUserStatusBean.onlineStatus = "status_available";
        } else if (statusMode == Presence.Mode.dnd) {
            AppUserStatusBean.onlineStatus = "status_busy";
        } else if (statusMode == Presence.Mode.away) {
            AppUserStatusBean.onlineStatus = "status_invisible";
        } else {
            AppUserStatusBean.onlineStatus = OfflineMessageRequest.ELEMENT;
        }
        MyApplication myApplication = WearUtils.x;
        appUserStatusBean.dToken = MyApplication.W;
        appUserStatusBean.uid = WearUtils.f(zd3.b(WearUtils.x, "xmpp_email_simple_name"));
        h(appUserStatusBean);
    }

    public void I() {
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(new Runnable() { // from class: dc.eb2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s();
            }
        }, 1000L);
    }

    public void J() {
        if (ch3.n().u() == null) {
            return;
        }
        AppUserStatusBean appUserStatusBean = new AppUserStatusBean();
        AppUserStatusBean.onlineStatus = "signOut";
        appUserStatusBean.controlStatus = "no";
        MyApplication myApplication = WearUtils.x;
        appUserStatusBean.dToken = MyApplication.W;
        appUserStatusBean.uid = WearUtils.f(zd3.b(WearUtils.x, "xmpp_email_simple_name"));
        h(appUserStatusBean);
        this.b = false;
    }

    public void K() {
        this.a.removeCallbacksAndMessages(null);
    }

    public void L() {
        h(new ForumEngagementCheckBean());
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void A(final UserInfoDao userInfoDao) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        FragmentActivity fragmentActivity = MyApplication.K;
        WearUtils.x.q("date_receive", null);
        if (fragmentActivity == null || fragmentActivity.isDestroyed() || this.b) {
            return;
        }
        is3.b bVar = new is3.b(fragmentActivity);
        final ForumEngagementPersonBean forumEngagementPersonBean = new ForumEngagementPersonBean();
        forumEngagementPersonBean.datingId = userInfoDao.getDatingId();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String friendName = !TextUtils.isEmpty(userInfoDao.getFriendName()) ? userInfoDao.getFriendName() : userInfoDao.getFriendId();
        String str = String.format(ah4.e(R.string.str_invite_date_tip), friendName);
        spannableStringBuilder.append((CharSequence) str);
        int iIndexOf = str.indexOf(friendName);
        if (iIndexOf != -1 && friendName.length() + iIndexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(fragmentActivity, R.color.color_accent)), iIndexOf, friendName.length() + iIndexOf, 34);
        }
        bVar.p(spannableStringBuilder);
        bVar.d(new is3.d() { // from class: dc.mb2
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.u(forumEngagementPersonBean, userInfoDao);
            }
        });
        bVar.c(new is3.c() { // from class: dc.lb2
            @Override // dc.is3.c
            public final void doCancel() {
                this.a.w(forumEngagementPersonBean);
            }
        });
        bVar.n(ah4.e(R.string.common_no));
        bVar.o(ah4.e(R.string.common_yes));
        i();
        is3 is3VarH = cs3.h(bVar);
        this.c = is3VarH;
        is3VarH.show();
        this.c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.jb2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.y(dialogInterface);
            }
        });
        MyApplication myApplication = WearUtils.x;
        if (myApplication.f0() && og3.b(1)) {
            PowerManager powerManager = (PowerManager) myApplication.getSystemService("power");
            if (powerManager != null && (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, ":target")) != null) {
                wakeLockNewWakeLock.acquire();
                wakeLockNewWakeLock.release();
            }
            myApplication.w(ch3.n().u().getId(), userInfoDao.getFriendId(), ah4.e(R.string.str_rece_dating_tip), friendName);
        }
    }

    public void N(AppUserToysBean appUserToysBean) {
        User userV;
        appUserToysBean.setSponsor(nd3.g(appUserToysBean.getSponsor()));
        String strDecrypt = CommunMessage.decrypt(appUserToysBean.toyJson);
        if (TextUtils.isEmpty(strDecrypt) || ((SyncLinkToy) JSON.parseObject(strDecrypt, SyncLinkToy.class)) == null || (userV = WearUtils.y.v(appUserToysBean.sponsor)) == null || !userV.isDateIng()) {
            return;
        }
        wi2.e().a(appUserToysBean.sponsor, userV, strDecrypt);
    }

    public void O(ForumEngagementNoticeBean forumEngagementNoticeBean) {
        i();
        OpenAppBean openAppBean = new OpenAppBean();
        openAppBean.type = 0;
        openAppBean.userId = nd3.g(forumEngagementNoticeBean.getSponsor());
        openAppBean.receiverName = forumEngagementNoticeBean.getSponsorName();
        openAppBean.datingId = forumEngagementNoticeBean.getDatingId();
        MyApplication.v0(openAppBean);
        i = forumEngagementNoticeBean.getDatingId();
        EventBus.getDefault().post(new InDateActivityEvent());
    }

    public void P(ForumEngagementCancelDTOBean forumEngagementCancelDTOBean) {
        int i2 = forumEngagementCancelDTOBean.mark;
        if (i2 == 0 && !this.b) {
            sg3.l(String.format(ah4.e(R.string.str_invite_date_cancle), forumEngagementCancelDTOBean.sponsorName));
        } else if (i2 == 1 && !this.b) {
            sg3.l(String.format(ah4.e(R.string.str_invite_date_decline), forumEngagementCancelDTOBean.sponsorName));
        }
        i();
    }

    public void Q(final ForumEngagementCheckNoticeDTOBean forumEngagementCheckNoticeDTOBean) {
        forumEngagementCheckNoticeDTOBean.receiver = nd3.g(forumEngagementCheckNoticeDTOBean.receiver);
        if (forumEngagementCheckNoticeDTOBean.status) {
            this.a.post(new Runnable() { // from class: dc.ib2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.A(forumEngagementCheckNoticeDTOBean);
                }
            });
        } else {
            i();
        }
    }

    public void R(NtokenResponseBean.Dating dating) {
        if (dating != null) {
            String str = i;
            if (str != null && str.equals(dating.datingId) && zb2.O().W(WearUtils.i0(dating.receiver))) {
                return;
            }
            i = dating.datingId;
            OpenAppBean openAppBean = new OpenAppBean();
            openAppBean.type = 0;
            openAppBean.userId = nd3.g(dating.receiver);
            openAppBean.selfId = nd3.g(dating.sponsor);
            openAppBean.receiverName = dating.receiverName;
            openAppBean.datingId = dating.datingId;
            MyApplication.v0(openAppBean);
            EventBus.getDefault().post(new InDateActivityEvent());
        }
    }

    public void S(ForumEngagementInfoDTOBean forumEngagementInfoDTOBean) {
        forumEngagementInfoDTOBean.receiver = nd3.g(forumEngagementInfoDTOBean.receiver);
        if (!forumEngagementInfoDTOBean.mark) {
            this.a.removeCallbacks(this.f);
            sg3.l(String.format(ah4.e(R.string.str_dating_end), forumEngagementInfoDTOBean.receiverName));
            InDateActivityEvent inDateActivityEvent = new InDateActivityEvent();
            inDateActivityEvent.flag = 4;
            EventBus.getDefault().post(inDateActivityEvent);
            return;
        }
        InDateActivityEvent inDateActivityEvent2 = new InDateActivityEvent();
        if (forumEngagementInfoDTOBean.receiverOnRoom) {
            this.a.removeCallbacks(this.f);
            j();
            inDateActivityEvent2.flag = 2;
        } else {
            this.a.removeCallbacks(this.f);
            this.a.postDelayed(this.f, 60000L);
            inDateActivityEvent2.flag = 3;
        }
        User userV = ch3.n().v(forumEngagementInfoDTOBean.receiver);
        if (userV != null) {
            userV.setTempAvatar(forumEngagementInfoDTOBean.receiverAvatar);
        }
        EventBus.getDefault().post(inDateActivityEvent2);
    }

    public void T(final ForumEngagementNoticeBean forumEngagementNoticeBean) {
        rn3 rn3Var;
        User user;
        if (!na2.m().f() && sz1.d().e() < 8) {
            ChatActivity chatActivity = null;
            Iterator<Activity> it = pd3.j().a.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next instanceof ChatActivity) {
                    chatActivity = (ChatActivity) next;
                }
            }
            if (chatActivity == null || (user = chatActivity.z) == null || !(user.isDateIng() || ChatSyncControl.N0().z() || ChatVideoControl.a1().z())) {
                gu3 gu3Var = hu3.p;
                if (gu3Var == null || (rn3Var = gu3Var.a) == null || !rn3Var.d()) {
                    forumEngagementNoticeBean.setSponsor(nd3.g(forumEngagementNoticeBean.getSponsor()));
                    this.a.post(new Runnable() { // from class: dc.kb2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.C(forumEngagementNoticeBean);
                        }
                    });
                }
            }
        }
    }

    public void U() {
        this.a.removeCallbacks(this.f);
        InDateActivityEvent inDateActivityEvent = new InDateActivityEvent();
        inDateActivityEvent.flag = 2;
        EventBus.getDefault().post(inDateActivityEvent);
        j();
    }

    public void V(ForumEngagementOverNoticeDTOBean forumEngagementOverNoticeDTOBean) {
        if (forumEngagementOverNoticeDTOBean.datingId.equals(i)) {
            this.a.removeCallbacksAndMessages(null);
            InDateActivityEvent inDateActivityEvent = new InDateActivityEvent();
            inDateActivityEvent.flag = 4;
            EventBus.getDefault().post(inDateActivityEvent);
        }
    }

    public void W(String str) {
        MyApplication.N().l.post(new Runnable() { // from class: dc.nb2
            @Override // java.lang.Runnable
            public final void run() {
                vc2.b(MyApplication.K, new View.OnClickListener() { // from class: dc.hb2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ep1.b().g();
                    }
                });
            }
        });
    }

    public void X() {
        H(0);
        G("EVENT_MESSAGE_REPORT_USER_STATUS");
    }

    @Override // dc.tf2
    public void connectSuc() {
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null || openAppBean.type != 1) {
            return;
        }
        L();
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void g(Activity activity, User user, boolean z, String str) {
        this.b = false;
        ForumEngagementFriendNoticeBean forumEngagementFriendNoticeBean = new ForumEngagementFriendNoticeBean();
        forumEngagementFriendNoticeBean.datingId = str;
        forumEngagementFriendNoticeBean.receiverIsAgree = Boolean.valueOf(z);
        h(forumEngagementFriendNoticeBean);
        ep1.b().q(new gp1((Runnable) new b(this, z, activity, user), true));
    }

    public void h(DateBean dateBean) {
        Account accountU = ch3.n().u();
        if (dateBean == null || accountU == null) {
            return;
        }
        if (TextUtils.isEmpty(dateBean.userName)) {
            dateBean.userName = accountU.getId();
        }
        dateBean.userName = n(dateBean.userName);
        uf2.v().E(dateBean);
    }

    public final void i() {
        try {
            Dialog dialog = this.c;
            if (dialog != null) {
                dialog.dismiss();
                this.c = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void j() {
        try {
            Dialog dialog = this.e;
            if (dialog != null) {
                dialog.dismiss();
                this.e = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k() {
        ForumEngagementOverBean forumEngagementOverBean = new ForumEngagementOverBean();
        forumEngagementOverBean.datingId = i;
        h(forumEngagementOverBean);
        this.a.removeCallbacksAndMessages(null);
    }

    public void l(String str) {
        p(str);
        ForumEngagementOnRoomBean forumEngagementOnRoomBean = new ForumEngagementOnRoomBean();
        forumEngagementOnRoomBean.datingId = i;
        h(forumEngagementOnRoomBean);
        this.d = str;
    }

    public final String m(@NonNull String str) {
        if (this.h == null) {
            this.h = new HashMap<>();
        }
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        String strEncryp = CommunMessage.encryp(str);
        if (!WearUtils.e1(strEncryp)) {
            this.h.put(str, strEncryp);
        }
        return strEncryp;
    }

    public final String n(@NonNull String str) {
        if (this.h == null) {
            this.h = new HashMap<>();
        }
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        String strQ = nd3.q(str);
        if (!WearUtils.e1(strQ)) {
            this.h.put(str, strQ);
        }
        return strQ;
    }

    public final void p(String str) {
        ForumEngagementGetToysBean forumEngagementGetToysBean = new ForumEngagementGetToysBean();
        forumEngagementGetToysBean.datingId = i;
        forumEngagementGetToysBean.userName = str;
        h(forumEngagementGetToysBean);
    }

    public boolean q() {
        Dialog dialog = this.c;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }
}
