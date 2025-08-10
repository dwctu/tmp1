package dc;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.bean.ReCall;
import com.wear.bean.UserSetting;
import com.wear.bean.event.AutoPlayPatternSettingEvent;
import com.wear.bean.event.PatternRecEvent;
import com.wear.bean.event.PatternRecEvent1;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.dao.ReCallDao;
import com.wear.dao.UserSettingDao;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import dc.qf3;
import dc.y12;
import java.util.Arrays;
import org.greenrobot.eventbus.EventBus;

/* compiled from: PatternTranslationListener.java */
/* loaded from: classes4.dex */
public class cu3 {
    public static Dialog a = null;
    public static String b = "";

    /* compiled from: PatternTranslationListener.java */
    public class a implements qf3.d {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.qf3.d
        public void a() {
            qf3.x(null);
            zb2.O().m0(this.a);
        }
    }

    public static /* synthetic */ void a(CommunMessage communMessage, String str) throws IllegalStateException {
        if (MusicControl.h0().O()) {
            MusicControl.h0().X();
        }
        k22 k22Var = (k22) y12.c.a().i(y12.c.TYPE_VOICE_BOOK);
        if (k22Var != null) {
            k22Var.B();
        }
        db2.A().w(false);
        if (!DaoUtils.getReCallDao().canPlayPattern(communMessage.getId(), communMessage.getCreated())) {
            sg3.h(R.string.message_recalled);
            return;
        }
        if (!sz1.d().a(4) || na2.m().f()) {
            na2.m().t();
            return;
        }
        if (WearUtils.x.G().P().size() > 0) {
            sz1.d().r(4);
            zb2.O().p0(str, communMessage.getId());
            qf3.x(new a(str));
            qf3.z(((EntityPattern) communMessage.getDataBean()).getUrl(), false, communMessage.getId(), null);
        }
        h(communMessage.getFrom(), ((EntityPattern) communMessage.getDataBean()).getMsgId());
    }

    public static /* synthetic */ void b(Dialog dialog, String str, is3.d dVar, View view) {
        dialog.dismiss();
        i(str);
        dVar.doConfirm();
    }

    public static /* synthetic */ void c(boolean z, final CommunMessage communMessage, CommunMessage communMessage2, String str, Activity activity, final String str2, IPeopleInfo iPeopleInfo) {
        Dialog dialog = a;
        if (dialog != null) {
            dialog.dismiss();
            a = null;
        }
        boolean z2 = WearUtils.x.G().P().size() == 0;
        d(z, true, communMessage, false, communMessage2, str, true);
        xz1.a();
        is3.b bVar = new is3.b(activity);
        bVar.k(R.layout.dialog_auto_play_pattern);
        bVar.u(R.id.play_pattern);
        bVar.t(R.id.dont_play_pattern);
        bVar.o(ah4.e(R.string.common_play));
        bVar.n(ah4.e(R.string.chat_pattern_resend_dont_play));
        final is3.d dVar = new is3.d() { // from class: dc.pt3
            @Override // dc.is3.d
            public final void doConfirm() throws IllegalStateException {
                cu3.a(communMessage, str2);
            }
        };
        bVar.d(dVar);
        final is3 is3VarH = cs3.h(bVar);
        b = communMessage.getId();
        is3VarH.show();
        TextView textView = (TextView) is3VarH.findViewById(R.id.tv_friend_name);
        TextView textView2 = (TextView) is3VarH.findViewById(R.id.tv_title_notice);
        TextView textView3 = (TextView) is3VarH.findViewById(R.id.tv_auto_play_pattern);
        TextView textView4 = (TextView) is3VarH.findViewById(R.id.tv_pattern_receive);
        TextView textView5 = (TextView) is3VarH.findViewById(R.id.tv_pattern_name);
        textView.setText(iPeopleInfo.getShowNickName());
        textView3.setOnClickListener(new View.OnClickListener() { // from class: dc.nt3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cu3.b(is3VarH, str2, dVar, view);
            }
        });
        if (z2) {
            textView2.setVisibility(8);
            textView5.setVisibility(8);
            textView4.setVisibility(0);
        }
        if (iPeopleInfo.isDateIng()) {
            textView3.setVisibility(8);
        }
        a = is3VarH;
    }

    public static void d(boolean z, boolean z2, CommunMessage communMessage, boolean z3, CommunMessage communMessage2, String str, boolean z4) {
        String strG0 = WearUtils.g0(str);
        String str2 = "onePatternAction: fromJid=" + strG0 + "  friendId=" + strG0;
        if (zb2.O().W(strG0)) {
            if (!z2 && WearUtils.x.G().P().size() > 0) {
                z3 = true;
            }
            if (z3 && db2.A().D()) {
                z3 = false;
            }
            if (z3 && !DaoUtils.getReCallDao().canPlayPattern(communMessage.getId(), communMessage.getCreated())) {
                sg3.h(R.string.message_recalled);
                z3 = false;
            }
            if (z4) {
                z3 = false;
            }
            if (!z3) {
                z = z3;
            }
            e(communMessage, z);
            EventBus.getDefault().post(new PatternRecEvent(null, false, communMessage2));
        } else if ((!z2 || z3) && WearUtils.x.G().P().size() > 0) {
            if (!DaoUtils.getReCallDao().canPlayPattern(communMessage.getId(), communMessage.getCreated())) {
                sg3.h(R.string.message_recalled);
            } else if (z3) {
                sz1.d().r(4);
                qf3.z(((EntityPattern) communMessage.getDataBean()).getUrl(), false, communMessage.getId(), null);
            }
            h(communMessage.getFrom(), ((EntityPattern) communMessage.getDataBean()).getMsgId());
        }
        hu3.n(communMessage);
    }

    public static void e(CommunMessage communMessage, boolean z) {
        EntityPattern entityPattern = (EntityPattern) communMessage.syncDecryptBean();
        entityPattern.setIsAutoPlay(z);
        communMessage.setDataBean(entityPattern);
        String[] strArr = {EntityPattern.TYPE_DETAIL_MYSENDPATTERN, EntityPattern.TYPE_DETAIL_PATTERN_RESEND, EntityPattern.TYPE_DETAIL_PATTERN_RESEND_V2};
        if (WearUtils.e1(entityPattern.getType()) || !Arrays.asList(strArr).contains(entityPattern.getType())) {
            EventBus.getDefault().post(new PatternRecEvent(communMessage, z, null));
        } else {
            if (DaoUtils.getCommunMessageDao().hasPatternByFromIdAndUrl(communMessage.getFrom(), entityPattern.getUrl(), entityPattern.getTime())) {
                EventBus.getDefault().post(new PatternRecEvent1(entityPattern, communMessage, z));
                return;
            }
            DaoUtils.getCommunMessageDao().add(communMessage);
            EventBus.getDefault().post(new PatternRecEvent(communMessage, z, null));
        }
    }

    public static void f(String str) {
        Dialog dialog = a;
        if (dialog != null && dialog.isShowing() && b.equals(str)) {
            a.dismiss();
            a = null;
        }
    }

    public static void g(final CommunMessage communMessage, final String str, final CommunMessage communMessage2) {
        final String strG0 = WearUtils.g0(str);
        final IPeopleInfo iPeopleInfoS = ch3.n().s(strG0);
        UserSetting userSettingZ = WearUtils.y.z(strG0);
        String str2 = "receiveDeCode: friendId=" + strG0 + "fromUser.isGroup=" + iPeopleInfoS.isGroup() + "AutoPlayPattern=" + userSettingZ.getAutoPlayPattern();
        if (!iPeopleInfoS.isDateIng() && WearUtils.x1(userSettingZ.getAutoPlayPattern()) && !WearUtils.x.i.o(str)) {
            if (MusicControl.h0().O()) {
                MusicControl.h0().X();
            }
            k22 k22Var = (k22) y12.c.a().i(y12.c.TYPE_VOICE_BOOK);
            if (k22Var != null) {
                k22Var.B();
            }
            if (sz1.d().a(4) && !na2.m().f()) {
                qf3.C();
                WearUtils.x.G().W(0);
            }
        }
        if (!sz1.d().a(4) || na2.m().f() || my2.i.a().getB()) {
            return;
        }
        boolean zD = db2.A().D();
        if (!zb2.O().W(strG0) && !WearUtils.x.i.o(str) && WearUtils.x1(userSettingZ.getAutoPlayPattern()) && !strG0.equals(WearUtils.x.I()) && !zD && !iPeopleInfoS.isDateIng() && !db2.A().D()) {
            if (WearUtils.y.v(WearUtils.g0(str)) != null) {
                sg3.l(String.format(ah4.e(R.string.playing_pattern_automatically), WearUtils.y.v(WearUtils.g0(str)).getShowNickName()));
            }
            sz1.d().r(4);
            qf3.z(((EntityPattern) communMessage.getDataBean()).getUrl(), false, communMessage.getId(), null);
            h(communMessage.getFrom(), ((EntityPattern) communMessage.getDataBean()).getMsgId());
            return;
        }
        MyApplication myApplication = WearUtils.x;
        final FragmentActivity fragmentActivityH = MyApplication.H();
        final boolean zX1 = WearUtils.x1(userSettingZ.getAutoPlayPattern());
        if ((!zX1 && !WearUtils.x.i.o(str)) || iPeopleInfoS.isDateIng() || zD) {
            if (WearUtils.x.f0()) {
                return;
            }
            fragmentActivityH.runOnUiThread(new Runnable() { // from class: dc.ot3
                @Override // java.lang.Runnable
                public final void run() {
                    cu3.c(zX1, communMessage, communMessage2, str, fragmentActivityH, strG0, iPeopleInfoS);
                }
            });
            return;
        }
        if (communMessage.getType() == MessageType.pattern) {
            String[] strArr = {EntityPattern.TYPE_DETAIL_MYSENDPATTERN, EntityPattern.TYPE_DETAIL_PATTERN_RESEND, EntityPattern.TYPE_DETAIL_PATTERN_RESEND_V2};
            EntityPattern entityPattern = (EntityPattern) communMessage.getDataBean();
            if (entityPattern != null && !WearUtils.e1(entityPattern.getType()) && Arrays.asList(strArr).contains(entityPattern.getType())) {
                hu3.n(communMessage);
            }
        }
        d(zX1, false, communMessage, false, communMessage2, str, false);
    }

    public static void h(String str, String str2) {
        ReCall reCallFindById;
        if (WearUtils.e1(str2)) {
            return;
        }
        String strReceiveCanRecall = DaoUtils.getReCallDao().receiveCanRecall(str2);
        if (WearUtils.e1(strReceiveCanRecall) || (reCallFindById = DaoUtils.getReCallDao().findById(strReceiveCanRecall)) == null) {
            return;
        }
        reCallFindById.setCanBe(1);
        DaoUtils.getReCallDao().update((ReCallDao) reCallFindById);
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C321.toString(), str2);
        zb2.O().F0(WearUtils.x, str, entitySystem);
    }

    public static void i(String str) {
        UserSetting userSettingZ = WearUtils.y.z(str);
        userSettingZ.setAutoPlayPattern(Boolean.TRUE);
        DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
        WearUtils.y.L(userSettingZ);
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C200.toString(), null);
        hu3.i0(WearUtils.i0(str), entitySystem, MessageType.system, ah4.e(R.string.chat_pattern_sync_own_notice), null, null, "graytext", null);
        EventBus.getDefault().post(new AutoPlayPatternSettingEvent(str));
    }
}
