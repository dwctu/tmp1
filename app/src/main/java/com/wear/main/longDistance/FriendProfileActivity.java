package com.wear.main.longDistance;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwnerKt;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.wear.BaseActivity;
import com.wear.bean.BlockClose;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.AutoPlayPatternSettingEvent;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.FriendsRequestEvent;
import com.wear.bean.me.OnlineStatusFriendCheckParam;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.main.account.EditNickNameByFriendActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.report.ReasonOptionActivity;
import com.wear.main.longDistance.report.ResultActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.EntitySystem;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.iwatcher.ImageWatcher;
import dc.ah4;
import dc.be3;
import dc.bo3;
import dc.bp2;
import dc.ch3;
import dc.cs3;
import dc.de3;
import dc.dm;
import dc.eg3;
import dc.ep1;
import dc.gg3;
import dc.gp1;
import dc.hp;
import dc.hp1;
import dc.ip1;
import dc.is3;
import dc.kf;
import dc.kg3;
import dc.km2;
import dc.kn3;
import dc.ku1;
import dc.lc3;
import dc.n82;
import dc.ns3;
import dc.pf3;
import dc.pj3;
import dc.q61;
import dc.qe3;
import dc.qo;
import dc.sg3;
import dc.t51;
import dc.tg3;
import dc.th4;
import dc.u51;
import dc.vg3;
import dc.wo;
import dc.ye3;
import dc.zb2;
import dc.zt3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class FriendProfileActivity extends BaseActivity<km2> implements bp2 {
    public ViewGroup A;
    public SwitchView B;
    public File C;
    public Uri D;
    public User E;
    public UserSetting F;
    public int G;
    public MyActionBar K;
    public ImageWatcher a;
    public km2 b;
    public String c;
    public UserSettingsBean d = null;
    public GifImageView e;
    public ImageView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public SwitchView j;
    public SwitchView k;
    public SwitchView l;
    public SwitchView m;
    public SwitchView n;
    public SwitchView o;
    public SwitchView p;
    public SwitchView q;
    public SwitchView s;
    public LinearLayout t;
    public RelativeLayout u;
    public LinearLayout v;
    public View w;
    public RelativeLayout x;
    public RelativeLayout y;
    public TextView z;

    public class a implements ImageWatcher.h {
        public a() {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void a(int i) {
            FriendProfileActivity.this.e.setVisibility(4);
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void b(int i, GifImageView gifImageView, Object obj) {
            FriendProfileActivity.this.e.setVisibility(4);
        }
    }

    public class b implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(FriendProfileActivity.this);
            }
        }

        public b() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(FriendProfileActivity.this.activity);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                FriendProfileActivity.this.S5();
            }
        }
    }

    public class c implements bo3.d {
        public c() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (FriendProfileActivity.this.C.exists()) {
                FriendProfileActivity.this.C.delete();
            }
            tg3.k(FriendProfileActivity.this.activity, 17);
        }
    }

    public class d implements bo3.d {
        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            FriendProfileActivity friendProfileActivity = FriendProfileActivity.this;
            friendProfileActivity.D = tg3.l(friendProfileActivity, friendProfileActivity.C, 16);
        }
    }

    public class e implements bo3.d {
        public final /* synthetic */ File a;

        public e(File file) {
            this.a = file;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (this.a.delete()) {
                sg3.i(FriendProfileActivity.this, R.string.partner_profile_black_setting_success);
            }
            FriendProfileActivity.this.addAnalyticsEventId("resetChatBackground", null);
        }
    }

    public class f implements bo3.d {
        public f(FriendProfileActivity friendProfileActivity) {
        }

        @Override // dc.bo3.d
        public void a(int i) {
        }
    }

    public class g implements kn3.d {
        public g() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(FriendProfileActivity.this);
        }
    }

    public class h implements tg3.a {
        public h() {
        }

        @Override // dc.tg3.a
        public void a(Bitmap bitmap, String str) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            File fileO = WearUtils.O();
            WearUtils.r(byteArrayInputStream, fileO);
            FriendProfileActivity.this.Q5(fileO);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ EntitySystem b;

        public i(FriendProfileActivity friendProfileActivity, String str, EntitySystem entitySystem) {
            this.a = str;
            this.b = entitySystem;
        }

        @Override // java.lang.Runnable
        public void run() {
            zb2.O().F0(WearUtils.x, this.a, this.b);
        }
    }

    public class j implements u51 {
        public j() {
        }

        @Override // dc.u51
        public /* synthetic */ void a(List list, boolean z) {
            t51.a(this, list, z);
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
            if (z) {
                FriendProfileActivity.this.k.setCheckedImmediatelyNoEvent(true);
                FriendProfileActivity.this.P5(true);
            }
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ EntitySystem b;

        public k(FriendProfileActivity friendProfileActivity, String str, EntitySystem entitySystem) {
            this.a = str;
            this.b = entitySystem;
        }

        @Override // java.lang.Runnable
        public void run() {
            zb2.O().F0(WearUtils.x, this.a, this.b);
        }
    }

    public class l implements ip1 {
        public final /* synthetic */ boolean a;

        public l(boolean z) {
            this.a = z;
        }

        @Override // dc.ip1
        public void G() {
            FriendProfileActivity.this.dissDialog();
            FriendProfileActivity.this.G = 0;
            FriendProfileActivity.this.s.setCheckedImmediatelyNoEvent(!this.a);
        }

        @Override // dc.ip1
        public void d() {
            FriendProfileActivity.this.cancleDelay();
        }
    }

    public class m extends HashMap<String, String> {
        public m() {
            String str;
            if (WearUtils.y.y() == null) {
                str = "0";
            } else {
                str = "" + WearUtils.y.y().size();
            }
            put("count", str);
        }
    }

    public class n extends HashMap<String, String> {
        public n() {
            String str;
            if (WearUtils.y.y() == null) {
                str = "0";
            } else {
                str = "" + WearUtils.y.y().size();
            }
            put("count", str);
        }
    }

    public class o implements kn3.d {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WearUtils.A(FriendProfileActivity.this.E.getUserJid());
                DaoUtils.getCommunMessageDao().deleteByFriendEmail(FriendProfileActivity.this.c);
                DaoUtils.getEmojiFavoriteDao().deleteAllOwner(FriendProfileActivity.this.c);
                DaoUtils.getMessageHideDao().deleteAllHides(WearUtils.i0(zt3.k), FriendProfileActivity.this.E.getUserJid());
                DaoUtils.getMessageUnReadDao().deleteAllUnRead(WearUtils.i0(zt3.k), FriendProfileActivity.this.E.getUserJid());
                EventBus.getDefault().post(new ClearChatViewFriendIdEvent(FriendProfileActivity.this.c));
            }
        }

        public o() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            vg3.b().a(new a());
            FriendProfileActivity.this.u.setEnabled(false);
            ((TextView) FriendProfileActivity.this.u.findViewById(R.id.clear_chat_message_text)).setTextColor(Color.parseColor("#9a9a9a"));
        }
    }

    public class p implements ip1 {
        public final /* synthetic */ boolean a;

        public p(boolean z) {
            this.a = z;
        }

        @Override // dc.ip1
        public void G() {
            FriendProfileActivity.this.dissDialog();
            FriendProfileActivity.this.G = 0;
            FriendProfileActivity.this.p.setCheckedImmediatelyNoEvent(!this.a);
        }

        @Override // dc.ip1
        public void d() {
            FriendProfileActivity.this.cancleDelay();
        }
    }

    public class q extends wo<Bitmap> {
        public final /* synthetic */ ImageWatcher.g d;

        public q(FriendProfileActivity friendProfileActivity, ImageWatcher.g gVar) {
            this.d = gVar;
        }

        @Override // dc.cp
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Bitmap bitmap, @Nullable hp<? super Bitmap> hpVar) {
            this.d.b(bitmap);
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    public FriendProfileActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.C = fileE0;
        this.D = Uri.fromFile(fileE0);
        this.G = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B5(boolean z) {
        int i2;
        if (z) {
            UserSettingsBean userSettingsBean = this.d;
            if (userSettingsBean != null) {
                userSettingsBean.setMuteFlag(1);
            } else {
                WearUtils.x.i.F(WearUtils.i0(this.c), 1);
                WearUtils.x.i.B(true, WearUtils.i0(this.c));
            }
            i2 = 1;
        } else {
            UserSettingsBean userSettingsBean2 = this.d;
            if (userSettingsBean2 != null) {
                userSettingsBean2.setMuteFlag(0);
            } else {
                WearUtils.x.i.F(WearUtils.i0(this.c), 0);
                WearUtils.x.i.B(false, WearUtils.i0(this.c));
            }
            i2 = 0;
        }
        String str = "jid=" + WearUtils.i0(this.c) + "&isOpen=" + i2 + "&time=" + be3.I().getTime();
        HashMap map = new HashMap();
        map.put("isChecked", String.valueOf(z).trim());
        map.put("friendEmail", String.valueOf(this.c).trim());
        hp1.b(str, map, true, String.valueOf(this.c).trim());
        dissDialog();
        this.G = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D5(CompoundButton compoundButton, final boolean z) {
        gp1 gp1Var = new gp1(new Runnable() { // from class: dc.t62
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B5(z);
            }
        }, new p(z));
        this.G = 2;
        if (ep1.b().r(this, gp1Var)) {
            showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F5(View view) {
        this.b.h(this.E.getUserJid());
        showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H5(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        bundle.putString("userId", this.c);
        pj3.g(this, SearchChatHistoryActivity.class, bundle);
        eg3.j(this, "SearchChatTip_" + ch3.n().r(), true);
        this.w.setVisibility(8);
        HashMap map = new HashMap();
        map.put("chat_type", "1");
        ye3.e("M0040", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J5(CompoundButton compoundButton, boolean z) {
        int i2;
        if (z) {
            UserSettingsBean userSettingsBean = this.d;
            if (userSettingsBean != null) {
                userSettingsBean.setSetTop(be3.I().getTime());
            } else {
                WearUtils.x.i.E(WearUtils.i0(this.c), be3.I().getTime());
            }
            i2 = 1;
        } else {
            i2 = 0;
            UserSettingsBean userSettingsBean2 = this.d;
            if (userSettingsBean2 != null) {
                userSettingsBean2.setSetTop(0L);
            } else {
                WearUtils.x.i.E(WearUtils.i0(this.c), 0L);
            }
        }
        String str = "jid=" + WearUtils.i0(this.c) + "&isOpen=" + i2 + "&time=" + be3.I().getTime();
        HashMap map = new HashMap();
        map.put("isChecked", String.valueOf(z).trim());
        map.put("friendEmail", String.valueOf(this.c).trim());
        hp1.c(str, map, true, String.valueOf(this.c).trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L5(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setAudioVibration(Boolean.valueOf(this.m.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N5(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setMessageVibration(Boolean.valueOf(this.l.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit X4(Boolean bool) {
        this.B.setCheckedImmediatelyNoEvent(bool.booleanValue());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Unit Z4(Boolean bool) {
        dissDialog();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b5(CompoundButton compoundButton, boolean z) {
        showDialog();
        Presence.Mode statusMode = ch3.n().u().getStatusMode();
        Presence.Mode mode = Presence.Mode.away;
        ku1.f("chat info", statusMode == mode ? "appear_available_click" : "appear_invisible_click", statusMode == mode ? "appear_available" : "appear_invisible", z ? "open" : Close.ELEMENT, null, null);
        new lc3().i(LifecycleOwnerKt.getLifecycleScope(this), new OnlineStatusFriendCheckParam(this.c, statusMode == mode ? 2 : 1, Boolean.valueOf(z)), new Function1() { // from class: dc.v62
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.a.Z4((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d5(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setAutoAccept(Boolean.valueOf(this.o.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
        EntitySystem entitySystem = new EntitySystem();
        if (z) {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C304.toString(), null);
        } else {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C305.toString(), null);
        }
        ep1.b().q(new gp1((Runnable) new k(this, this.E.getUserJid(), entitySystem), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f5(CompoundButton compoundButton, boolean z) {
        if (!z || zt3.f()) {
            P5(this.k.isChecked());
        } else {
            this.k.setCheckedImmediatelyNoEvent(false);
            zt3.v(this, new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h5(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setAutoPlayPattern(Boolean.valueOf(this.j.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
        if (z) {
            EntitySystem entitySystem = new EntitySystem();
            String userJid = this.E.getUserJid();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C200.toString(), null);
            ep1.b().q(new gp1((Runnable) new i(this, userJid, entitySystem), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j5(boolean z, n82.d dVar) {
        if (!z) {
            WearUtils.x.q("longDistance_unblock_friend", new n());
            WearUtils.x.i.y(this.E.getUserJid(), dVar);
            return;
        }
        WearUtils.x.i.b(this.E.getUserJid(), 0, dVar);
        EventBus.getDefault().post(new BlockClose(this.E.getId()));
        WearUtils.x.q("longDistance_block_friend", new m());
        HashMap map = new HashMap();
        map.put("who_oppo", this.E.getUserJid());
        map.put("invite_result", 2);
        ye3.d("F0012", WearUtils.A.toJson(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l5(final n82.d dVar, CompoundButton compoundButton, final boolean z) {
        if (ChatSyncControl.N0().D(this.c)) {
            sg3.k(this, String.format(ah4.e(R.string.block_fail_tip_sync_control), new Object[0]));
            this.s.setCheckedImmediatelyNoEvent(false);
            return;
        }
        if (ChatLiveControl.q0().D(this.c)) {
            sg3.k(this, String.format(ah4.e(R.string.block_fail_tip_live_control), new Object[0]));
            this.s.setCheckedImmediatelyNoEvent(false);
        } else if (ChatVideoControl.a1().D(this.c)) {
            sg3.k(this, ChatVideoControl.a1().k1() ? String.format(ah4.e(R.string.block_fail_tip_video_call), new Object[0]) : String.format(ah4.e(R.string.block_fail_tip_voice_call), new Object[0]));
            this.s.setCheckedImmediatelyNoEvent(false);
        } else {
            gp1 gp1Var = new gp1(new Runnable() { // from class: dc.p62
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j5(z, dVar);
                }
            }, new l(z));
            showDialog();
            this.G = 1;
            ep1.b().r(this, gp1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n5(boolean z) {
        dissDialog();
        EventBus.getDefault().post(new FriendsRequestEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p5(View view) {
        E4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r5(View view) {
        kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.clear_chat_message) + "?", ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new o());
        kn3Var.show();
        kn3Var.p();
        kn3Var.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t5(View view) {
        pj3.q(this, EditNickNameByFriendActivity.class, 153, "userId", this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v5(View view) throws Resources.NotFoundException {
        R5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x5(Context context, String str, ImageWatcher.g gVar) {
        kf.z(this).j().J0(str).a(qo.p0(new dm(de3.a(this, 8.0f)))).x0(new q(this, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z5(CompoundButton compoundButton, boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setLogNotify(Boolean.valueOf(this.n.isChecked()));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
    }

    public final void E4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new b());
    }

    public final String F4(Uri uri, Bitmap bitmap) {
        return qe3.g(this, uri, bitmap);
    }

    public final void G4() {
        this.A = (ViewGroup) findViewById(R.id.appear_visible_container);
        this.z = (TextView) findViewById(R.id.appear_visible_tv);
        this.B = (SwitchView) findViewById(R.id.appear_visible);
        Presence.Mode statusMode = ch3.n().u().getStatusMode();
        Presence.Mode mode = Presence.Mode.away;
        String strE = ah4.e(statusMode == mode ? R.string.chat_info_show_online_status : R.string.chat_info_hide_online_status);
        boolean z = statusMode == Presence.Mode.dnd;
        this.z.setText(strE);
        this.A.setVisibility(z ? 8 : 0);
        if (!z) {
            lc3.g().c(LifecycleOwnerKt.getLifecycleScope(this), new OnlineStatusFriendCheckParam(this.c, statusMode == mode ? 2 : 1, null), new Function1() { // from class: dc.h62
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.a.X4((Boolean) obj);
                }
            });
        }
        this.B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.l62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.b5(compoundButton, z2);
            }
        });
    }

    public final void H4() {
        this.o = (SwitchView) findViewById(R.id.auto_accept);
        if (WearUtils.x1(this.F.getAutoAccept())) {
            this.o.setCheckedImmediatelyNoEvent(true);
        }
        this.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.k62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.d5(compoundButton, z);
            }
        });
    }

    public final void I4() {
        this.k = (SwitchView) findViewById(R.id.auto_play_alarm);
        if (WearUtils.x1(this.F.getAutoPlayAlarm())) {
            this.k.setCheckedImmediatelyNoEvent(true);
        }
        this.k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.z62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.f5(compoundButton, z);
            }
        });
    }

    public final void J4() {
        this.j = (SwitchView) findViewById(R.id.auto_play_pattern);
        if (WearUtils.x1(this.F.getAutoPlayPattern())) {
            this.j.setCheckedImmediatelyNoEvent(true);
        }
        this.j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.o62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.h5(compoundButton, z);
            }
        });
    }

    public final void K4() {
        final n82.d dVar = new n82.d() { // from class: dc.i62
            @Override // dc.n82.d
            public final void a(boolean z) {
                this.a.n5(z);
            }
        };
        this.s = (SwitchView) findViewById(R.id.black_setting);
        if (WearUtils.x.i.k(this.E.getUserJid())) {
            this.s.setCheckedImmediatelyNoEvent(true);
        }
        this.s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.m62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.l5(dVar, compoundButton, z);
            }
        });
    }

    public final void L4() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.setting_chat_background);
        this.x = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.r62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.p5(view);
            }
        });
    }

    public final void M4() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.clear_chat_message);
        this.u = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.s62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r5(view);
            }
        });
    }

    public final void N4() {
        findViewById(R.id.all_item).setOnClickListener(new View.OnClickListener() { // from class: dc.u62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t5(view);
            }
        });
        findViewById(R.id.rl_img).setOnClickListener(new View.OnClickListener() { // from class: dc.a72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.a.v5(view);
            }
        });
        this.e = (GifImageView) findViewById(R.id.iv_show_big_img);
        this.t = (LinearLayout) findViewById(R.id.user_id_layout);
        ImageView imageView = (ImageView) findViewById(R.id.user_img);
        this.f = imageView;
        WearUtils.t2(imageView, this.E);
        TextView textView = (TextView) findViewById(R.id.user_name);
        this.h = textView;
        textView.setText(this.E.getUserName());
        TextView textView2 = (TextView) findViewById(R.id.user_id);
        this.i = textView2;
        textView2.setText(WearUtils.g0(this.E.getUserJid()));
        ImageView imageView2 = (ImageView) findViewById(R.id.user_gender);
        this.g = imageView2;
        imageView2.setVisibility(0);
        if ("Female".equalsIgnoreCase(this.E.getGender())) {
            this.g.setImageResource(R.drawable.content_icon_gender_female);
        } else if ("Male".equalsIgnoreCase(this.E.getGender())) {
            this.g.setImageResource(R.drawable.content_icon_gender_male);
        } else {
            this.g.setVisibility(8);
        }
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.K = myActionBar;
        myActionBar.setParentBackgroundColor(th4.b(this.application, R.color.lvs_ui_standard_systemBackground6));
    }

    public final void O4() {
        new DisplayImageOptions.Builder().showImageOnFail(R.drawable.content_icon_picture_loading).cacheInMemory(false).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        ImageWatcher imageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);
        this.a = imageWatcher;
        imageWatcher.setSkipImageLoaderCache(true);
        this.a.setTranslucentStatus(gg3.g(this));
        this.a.setErrorImageRes(R.drawable.avatar_default_fullview_fail);
        this.a.setLoader(new ImageWatcher.i() { // from class: dc.w62
            @Override // com.wear.widget.iwatcher.ImageWatcher.i
            public final void a(Context context, String str, ImageWatcher.g gVar) {
                this.a.x5(context, str, gVar);
            }
        });
    }

    public final void O5() {
        String avatar = this.E.getAvatar();
        if (TextUtils.isEmpty(avatar)) {
            this.e.setImageResource(R.drawable.chat_avatar_default);
            return;
        }
        this.e.setImageResource(R.drawable.avatar_default_fullview_fail);
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        kf.z(this).v(avatar).a(qo.p0(new dm(de3.a(this, 8.0f)))).A0(this.e);
    }

    public final void P4() {
        this.n = (SwitchView) findViewById(R.id.log_notify);
        if (WearUtils.x1(this.F.getLogNotify())) {
            this.n.setCheckedImmediatelyNoEvent(true);
        }
        this.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.j62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.z5(compoundButton, z);
            }
        });
    }

    public final void P5(boolean z) {
        UserSetting userSetting = this.F;
        if (userSetting != null) {
            userSetting.setAutoPlayAlarm(Boolean.valueOf(z));
            DaoUtils.getUserSettingDao().update((UserSettingDao) this.F);
        }
    }

    public final void Q4() {
        this.p = (SwitchView) findViewById(R.id.mute_notifications);
        UserSettingsBean userSettingsBean = this.d;
        if (userSettingsBean != null && userSettingsBean.getMuteFlag() > 0) {
            this.p.setCheckedImmediatelyNoEvent(true);
        }
        this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.n62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.D5(compoundButton, z);
            }
        });
    }

    public final void Q5(File file) throws IOException {
        addAnalyticsEventId("setChatBackground", null);
        WearUtils.q(file, WearUtils.N(this.E));
        if (!WearUtils.N(this.E).exists()) {
            sg3.i(this, R.string.setting_black_image_not_exist);
        } else {
            sg3.i(this, R.string.partner_profile_black_setting_success);
            finish();
        }
    }

    public final void R4() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.report_layout);
        this.y = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.q62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F5(view);
            }
        });
    }

    public final void R5() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.e);
        this.e.getLocationOnScreen(new int[2]);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ns3(this.e.getWidth(), this.e.getHeight(), r0[0], r0[1]));
        ArrayList arrayList3 = new ArrayList();
        String avatar = this.E.getAvatar();
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        arrayList3.add(avatar);
        this.a.E(this.e, arrayList, arrayList3, arrayList2, false, new a());
    }

    public final void S4() {
        this.w = findViewById(R.id.view_search_chat_history);
        if (!pf3.d(this)) {
            View view = this.w;
            StringBuilder sb = new StringBuilder();
            sb.append("SearchChatTip_");
            sb.append(ch3.n().r());
            view.setVisibility(eg3.d(this, sb.toString(), false) ? 8 : 0);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_search_chat_history);
        this.v = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.y62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.H5(view2);
            }
        });
    }

    public final void S5() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_chat_photo);
        bo3Var.show();
        bo3Var.d(R.id.from_album, new c());
        bo3Var.d(R.id.from_camera, new d());
        bo3Var.d(R.id.cancel_from, null);
        bo3Var.a(R.id.clean_layout).setVisibility(0);
        File fileN = WearUtils.N(this.E);
        if (!fileN.exists()) {
            bo3Var.d(R.id.action_clean, new f(this));
        } else {
            bo3Var.a(R.id.clean_layout).setVisibility(0);
            bo3Var.d(R.id.action_clean, new e(fileN));
        }
    }

    public final void T4() {
        this.q = (SwitchView) findViewById(R.id.topTop_setting);
        UserSettingsBean userSettingsBean = this.d;
        if (userSettingsBean != null && userSettingsBean.getSetTop() > 0) {
            this.q.setChecked(true);
        }
        this.q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.x62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.J5(compoundButton, z);
            }
        });
    }

    public final void U4() {
        this.m = (SwitchView) findViewById(R.id.audio_vibration);
        if (WearUtils.x1(this.F.getAudioVibration())) {
            this.m.setCheckedImmediatelyNoEvent(true);
        }
        this.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.g62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.L5(compoundButton, z);
            }
        });
    }

    public final void V4() {
        this.l = (SwitchView) findViewById(R.id.message_vibration);
        if (WearUtils.x1(this.F.getMessageVibration())) {
            this.l.setCheckedImmediatelyNoEvent(true);
        }
        this.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.f62
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.N5(compoundButton, z);
            }
        });
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.x(this);
        this.mPresenter = this.b;
    }

    @Override // dc.bp2
    public void n3(boolean z, String str) {
        dissDialog();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", this.E.getId());
        bundle.putString("user_img", this.E.getAvatar());
        if (!str.equals("pending")) {
            pj3.g(this, ReasonOptionActivity.class, bundle);
        } else {
            bundle.putInt("status", 1);
            pj3.g(this, ResultActivity.class, bundle);
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        try {
            if (i2 == 16) {
                if (i3 == -1) {
                    Uri data = this.D;
                    if (intent != null && intent.getData() != null) {
                        data = intent.getData();
                    }
                    tg3.e(this.C, this, data, new h());
                    return;
                }
                return;
            }
            if (i2 != 17) {
                if (i2 == 999 && i3 == -1) {
                    boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                    intent.getIntArrayExtra("grant_results");
                    if (booleanExtra) {
                        S5();
                        return;
                    } else {
                        new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new g()).show();
                        return;
                    }
                }
                return;
            }
            if (intent == null || intent.getData() == null) {
                return;
            }
            Uri data2 = intent.getData();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inSampleSize = 2;
                options.inJustDecodeBounds = false;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data2), null, options);
                Bitmap bitmapL = WearUtils.l(this.application, bitmapDecodeStream, F4(data2, bitmapDecodeStream));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapL.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                File fileO = WearUtils.O();
                WearUtils.r(byteArrayInputStream, fileO);
                if (fileO != null && (fileO == null || fileO.exists())) {
                    Q5(fileO);
                    return;
                }
                sg3.i(this, R.string.setting_black_image_not_exist);
            } catch (Exception e2) {
                e2.printStackTrace();
                sg3.i(this, R.string.setting_black_image_not_exist);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        int i2 = this.G;
        if (i2 == 1) {
            SwitchView switchView = this.s;
            switchView.setCheckedImmediatelyNoEvent(true ^ switchView.isChecked());
            ep1.b().m(this);
        } else if (i2 == 2) {
            SwitchView switchView2 = this.p;
            switchView2.setCheckedImmediatelyNoEvent(true ^ switchView2.isChecked());
            ep1.b().m(this);
        }
        this.G = 0;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_friend_profile);
        setCurrentScreen(this, "setting_change_profile_screen_view", FriendProfileActivity.class.getSimpleName());
        String stringExtra = getIntent().getStringExtra("userId");
        this.c = stringExtra;
        User userV = WearUtils.y.v(stringExtra);
        this.E = userV;
        if (userV == null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.F = WearUtils.y.z(this.c);
        this.d = WearUtils.x.i.g(WearUtils.i0(this.c));
        N4();
        S4();
        J4();
        I4();
        U4();
        V4();
        P4();
        H4();
        K4();
        M4();
        G4();
        Q4();
        T4();
        L4();
        R4();
        O4();
        O5();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        File file = this.C;
        if (file != null && file.exists()) {
            this.C.delete();
        }
        ep1.b().m(this);
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.a.isShown() || i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.a.B();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AutoPlayPatternSettingEvent autoPlayPatternSettingEvent) {
        String str;
        if (autoPlayPatternSettingEvent == null || (str = autoPlayPatternSettingEvent.friendId) == null || !str.equals(this.c)) {
            return;
        }
        this.j.setChecked(true);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(WearUtils.i0(this.c));
        this.d = userSettingsBeanG;
        if (userSettingsBeanG == null) {
            this.t.setVisibility(8);
            User user = this.E;
            if (user != null) {
                this.h.setText(user.getUserName());
                return;
            }
            return;
        }
        if (WearUtils.e1(userSettingsBeanG.getRemark()) || WearUtils.e1(this.d.getRemark().trim())) {
            this.t.setVisibility(8);
            User user2 = this.E;
            if (user2 != null) {
                this.h.setText(user2.getUserName());
                return;
            }
            return;
        }
        this.t.setVisibility(0);
        this.i.setText(this.d.getRemark());
        if (this.E != null) {
            this.h.setText(this.d.getRemark());
            this.i.setText(this.E.getUserName());
        }
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        super.settingBarColor();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Window window = getWindow();
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                window.setNavigationBarColor(Color.parseColor("#1E1F29"));
                return;
            } else {
                window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
                return;
            }
        }
        if (i2 == 2) {
            window.setNavigationBarColor(Color.parseColor("#1E1F29"));
        } else {
            window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FinishChatPageEvent finishChatPageEvent) {
        finish();
    }
}
