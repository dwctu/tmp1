package com.wear.ui.me;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.Setting;
import com.wear.bean.TestValue;
import com.wear.bean.ThemeChangeEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.OpenLockEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.dao.TestValueDao;
import com.wear.main.account.ChatSettingActivity;
import com.wear.main.account.HomepageSettingsActivity;
import com.wear.main.account.MessageNotificationsActivity;
import com.wear.main.account.MusicLinkedAccountActivity;
import com.wear.main.account.MyAccountActivity;
import com.wear.main.account.SettingLanguageActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.game.ui.NewGameModeActivity;
import com.wear.main.longDistance.block.BlockContactsActivity;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.aj4;
import dc.ch3;
import dc.cs3;
import dc.eg3;
import dc.ep1;
import dc.fp2;
import dc.is3;
import dc.kd2;
import dc.kn3;
import dc.ku1;
import dc.lg3;
import dc.lu1;
import dc.me3;
import dc.na2;
import dc.nd3;
import dc.pj3;
import dc.tn2;
import dc.wm2;
import dc.xe2;
import dc.ye3;
import dc.zn2;
import dc.zt3;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class SettingActivity extends BaseActivity implements View.OnClickListener, fp2, aj4 {
    public static boolean f;
    public wm2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.block_beta_flag)
    public TextView blockBetaFlag;

    @BindView(R.id.account_setting_reddot_account)
    public View dotAccount;
    public Setting e;

    @BindView(R.id.ll_login_setting)
    public LinearLayout llLoginSetting;

    @BindView(R.id.ll_offline)
    public LinearLayout llOffline;

    @BindView(R.id.rl_chat)
    public RelativeLayout rlChat;

    @BindView(R.id.rl_game_mode)
    public RelativeLayout rlGameMode;

    @BindView(R.id.rl_homepage)
    public RelativeLayout rlHomepage;

    @BindView(R.id.rl_language)
    public RelativeLayout rlLanguage;

    @BindView(R.id.rl_ninja_mode)
    public RelativeLayout rlNinjaMode;

    @BindView(R.id.rl_skin)
    public View rlSkin;

    @BindView(R.id.rl_sync_pattern)
    public RelativeLayout rlSyncPattern;

    @BindView(R.id.rl_default_theme)
    public RelativeLayout rl_default_theme;

    @BindView(R.id.rl_develop_model)
    public RelativeLayout rl_develop_model;

    @BindView(R.id.sb_ninja_mode)
    public SwitchView sbNinjaMode;

    @BindView(R.id.sb_sync_pattern)
    public SwitchView sbSyncPattern;

    @BindView(R.id.setting_block_contacts)
    public RelativeLayout settingBlockContacts;

    @BindView(R.id.setting_keep_screen_swith)
    public SwitchView settingKeepScreenSwith;

    @BindView(R.id.setting_music_linked_account)
    public RelativeLayout settingMusicLinkedAccount;

    @BindView(R.id.setting_my_account)
    public RelativeLayout settingMyAccount;

    @BindView(R.id.setting_red_dot)
    public View settingRedDot;

    @BindView(R.id.setting_default_theme)
    public SwitchView setting_default_theme;

    @BindView(R.id.setting_develop_model)
    public SwitchView setting_develop_model;

    @BindView(R.id.settings_message_notifications_link)
    public RelativeLayout settingsMessageNotificationsLink;

    @BindView(R.id.tv_account_logout)
    public TextView tvAccountLogout;

    @BindView(R.id.tv_blocked_contacts)
    public TextView tvBlockedContacts;

    @BindView(R.id.tv_dark_mode)
    public TextView tvDarkMode;

    @BindView(R.id.tv_ninja_mode)
    public TextView tvNinjaMode;

    @BindView(R.id.tv_settings_message_notifications)
    public TextView tvSettingsMessageNotifications;

    @BindView(R.id.tv_sync_pattern)
    public TextView tvSyncPattern;

    @BindView(R.id.tv_develop_model)
    public TextView tv_develop_model;

    @BindView(R.id.v_ninja_mode)
    public View vNinjaMode;

    @BindView(R.id.v_sync_pattern)
    public View vSyncPattern;
    public xe2 b = (xe2) xe2.L0();
    public boolean c = false;
    public String d = zt3.k;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                DaoUtils.getTestValueDao().save(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY, "1", TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE);
            } else {
                DaoUtils.getTestValueDao().delete(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY, TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE);
            }
            EventBus.getDefault().post(new KeepScreenSetting(z));
        }
    }

    public class b implements View.OnClickListener {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.c = true;
                settingActivity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + SettingActivity.this.getPackageName())), 10091);
            }
        }

        /* renamed from: com.wear.ui.me.SettingActivity$b$b, reason: collision with other inner class name */
        public class C0156b implements is3.c {
            public C0156b() {
            }

            @Override // dc.is3.c
            public void doCancel() {
                DaoUtils.getTestValueDao().save(SettingActivity.this.d, "0", TestValueDao.NINJA_MODE_SWITCH_TYPE);
                EventBus.getDefault().post(new OpenLockEvent(false));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!SettingActivity.this.sbNinjaMode.isChecked() && !SettingActivity.this.y4()) {
                cs3.d(SettingActivity.this, ah4.e(R.string.ninja_mode_permission), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new a(), new C0156b()).show();
                return;
            }
            if (SettingActivity.this.sbNinjaMode.isChecked()) {
                DaoUtils.getTestValueDao().save(SettingActivity.this.d, "0", TestValueDao.NINJA_MODE_SWITCH_TYPE);
            } else {
                DaoUtils.getTestValueDao().save(SettingActivity.this.d, "1", TestValueDao.NINJA_MODE_SWITCH_TYPE);
            }
            EventBus.getDefault().post(new OpenLockEvent(!SettingActivity.this.sbNinjaMode.isChecked()));
            SettingActivity.this.sbNinjaMode.setChecked(!r7.isChecked());
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingActivity.this.K4(!SettingActivity.this.sbSyncPattern.isChecked());
        }
    }

    public class e implements is3.d {
        public final /* synthetic */ boolean a;

        public e(boolean z) {
            this.a = z;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            SettingActivity.this.H4("syncPatternSwitch", this.a ? 1 : 0);
        }
    }

    public class f implements is3.d {
        public f() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            SettingActivity.this.z4();
        }
    }

    public class g implements zn2<String> {
        public g(SettingActivity settingActivity) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class h implements kn3.d {
        public h() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.s(SettingActivity.this, LoginActivity.class);
        }
    }

    public class i implements is3.d {
        public i() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            na2.m().w();
            ChatVideoControl.a1().X0(true, false, false);
            pj3.f(SettingActivity.this, NewGameModeActivity.class);
            SettingActivity.this.x4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(boolean z, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (z) {
            return;
        }
        this.rl_develop_model.setVisibility(0);
        eg3.j(this, "XRemoteDevelopModel", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E4(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(this, "switchDevelopModel", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G4(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ku1.a("Settings", "settings_default_theme_click", "click", "settings_default_theme", "button", "", Integer.valueOf(z ? 1 : 0), null);
        eg3.j(this, "switchDefaultTheme", z);
        EventBus.getDefault().post(new ThemeChangeEvent());
    }

    public final void A4() {
        this.tv_develop_model.setText(ah4.e(R.string.settings_developer_mode));
        final boolean zD = eg3.d(this, "XRemoteDevelopModel", false);
        this.rl_develop_model.setVisibility(zD ? 0 : 8);
        this.actionbar.getLabelStatus().setOnClickListener(new lu1(3, new lu1.a() { // from class: dc.vb3
            @Override // dc.lu1.a
            public final void a(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.C4(zD, view);
            }
        }));
        this.setting_develop_model.setCheckedImmediatelyNoEvent(eg3.d(this, "switchDevelopModel", false));
        this.setting_develop_model.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.xb3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.E4(compoundButton, z);
            }
        });
        if (WearUtils.y2()) {
            this.rl_default_theme.setVisibility(0);
        } else {
            this.rl_default_theme.setVisibility(8);
        }
        this.setting_default_theme.setCheckedImmediatelyNoEvent(eg3.d(this, "switchDefaultTheme", false));
        this.setting_default_theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.wb3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.G4(compoundButton, z);
            }
        });
    }

    @Override // dc.fp2
    public void D3(boolean z, BaseResponseBean baseResponseBean) {
        boolean z2 = !this.sbSyncPattern.isChecked();
        this.sbSyncPattern.setChecked(z2);
        LoginUserBean loginUserBeanO = ch3.n().o();
        if (loginUserBeanO != null) {
            loginUserBeanO.setSyncPatternSwitch(z2 ? 1 : 0);
        }
        xe2.L0().A(ch3.n().X());
        if (loginUserBeanO.getSyncPatternSwitch() == 0) {
            xe2.L0().v();
        }
        if (this.b.l && f) {
            f = false;
            if (ch3.n().X()) {
                this.b.Z("patternSync_tipSee_open");
            }
        }
        if (ch3.n().X()) {
            this.b.Z("patternSync_open");
            ye3.d("P0001", "");
        } else {
            ye3.d("P0002", "");
            this.b.Z("patternSync_close");
        }
    }

    public final void H4(String str, int i2) {
        if (WearUtils.y.u() != null) {
            HashMap map = new HashMap();
            map.put(str, Integer.valueOf(i2));
            HashMap map2 = new HashMap();
            map2.put("config", WearUtils.A.toJson(map));
            this.a.h(false, map2);
        }
    }

    public final void I4() {
        String strI;
        this.d = !WearUtils.e1(zt3.k) ? zt3.k : zt3.l;
        if (DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) != null) {
            this.settingKeepScreenSwith.setCheckedImmediatelyNoEvent(true);
        } else {
            this.settingKeepScreenSwith.setCheckedImmediatelyNoEvent(false);
        }
        this.settingKeepScreenSwith.setOnCheckedChangeListener(new a(this));
        if (y4()) {
            TestValue existKey = DaoUtils.getTestValueDao().getExistKey(nd3.u(this.d), TestValueDao.NINJA_MODE_SWITCH_TYPE);
            if (existKey == null || (strI = nd3.i(existKey.getValue())) == null || strI.equals("1")) {
                this.sbNinjaMode.setCheckedImmediatelyNoEvent(true);
            } else {
                this.sbNinjaMode.setCheckedImmediatelyNoEvent(false);
            }
        } else {
            this.sbNinjaMode.setCheckedImmediatelyNoEvent(false);
        }
        this.vNinjaMode.setOnClickListener(new b());
        this.sbNinjaMode.setOnCheckedChangeListener(new c(this));
        this.rlSkin.setOnClickListener(this);
        WearUtils.y.u();
        this.sbSyncPattern.setCheckedImmediatelyNoEvent(ch3.n().X());
        this.vSyncPattern.setOnClickListener(new d());
    }

    public final void J4() {
        String str = "showDot isShowChat: " + ManagerRDBean.getManager().isShowChat();
        this.dotAccount.setVisibility(ManagerRDBean.getManager().isShowMyAccount() ? 0 : 8);
    }

    public final void K4(boolean z) {
        is3.b bVar = new is3.b(this);
        if (z) {
            bVar.p(ah4.e(R.string.pattern_sync_enable));
            bVar.o(ah4.e(R.string.common_agree));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new e(z));
            cs3.h(bVar).show();
            return;
        }
        H4("syncPatternSwitch", z ? 1 : 0);
        bVar.p(ah4.e(R.string.pattern_sync_disable));
        bVar.o(ah4.e(R.string.common_delete));
        bVar.n(ah4.e(R.string.pattern_sync_no_del));
        bVar.d(new f());
        cs3.h(bVar).show();
    }

    @Override // dc.aj4
    public void P1() {
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.f(this);
        this.mPresenter = this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_offline /* 2131363545 */:
                pj3.s(this, LoginActivity.class);
                break;
            case R.id.rl_chat /* 2131364246 */:
                addAnalyticsEventId("chat_setting", null);
                pj3.f(this, ChatSettingActivity.class);
                break;
            case R.id.rl_game_mode /* 2131364268 */:
                if (!na2.m().i()) {
                    pj3.f(this, NewGameModeActivity.class);
                    x4();
                    break;
                } else {
                    is3.b bVar = new is3.b(this);
                    bVar.p(ah4.e(R.string.game_mode_noti));
                    bVar.d(new i());
                    cs3.h(bVar).show();
                    break;
                }
            case R.id.rl_homepage /* 2131364275 */:
                ManagerRDBean.getManager().setShowHomePage(false);
                ManagerRDBean.saveManager();
                EventBus.getDefault().post(ManagerRDBean.getManager());
                addAnalyticsEventId("homepage_settings", null);
                pj3.f(this, HomepageSettingsActivity.class);
                break;
            case R.id.rl_language /* 2131364279 */:
                pj3.f(this, SettingLanguageActivity.class);
                break;
            case R.id.rl_skin /* 2131364301 */:
                pj3.f(this, SettingDarkModeActivity.class);
                break;
            case R.id.setting_block_contacts /* 2131364488 */:
                pj3.h(this, BlockContactsActivity.class, "block_list_type", 0);
                break;
            case R.id.setting_music_linked_account /* 2131364504 */:
                pj3.f(this, MusicLinkedAccountActivity.class);
                break;
            case R.id.setting_my_account /* 2131364505 */:
                if (!MyApplication.Z) {
                    pj3.f(this, MyAccountActivity.class);
                    break;
                } else {
                    kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.offline_notification), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new h());
                    kn3Var.show();
                    kn3Var.p();
                    break;
                }
            case R.id.settings_message_notifications_link /* 2131364526 */:
                pj3.f(this, MessageNotificationsActivity.class);
                break;
            case R.id.tv_account_logout /* 2131364905 */:
                ye3.I("logoutNormally", "click logout");
                ep1.b().i(this);
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_setting);
        me3.c(me3.c.ME_SETTINGS_UI_ENTER);
        ye3.c("settings", "into page", null);
        ButterKnife.bind(this);
        this.settingMyAccount.setOnClickListener(this);
        this.settingMusicLinkedAccount.setOnClickListener(this);
        this.settingsMessageNotificationsLink.setOnClickListener(this);
        this.tvAccountLogout.setOnClickListener(this);
        this.settingBlockContacts.setOnClickListener(this);
        this.rlLanguage.setOnClickListener(this);
        this.rlChat.setOnClickListener(this);
        this.rlHomepage.setOnClickListener(this);
        this.llOffline.setOnClickListener(this);
        this.rlGameMode.setOnClickListener(this);
        this.e = this.application.S();
        A4();
        if (this.e == null) {
            finish();
            return;
        }
        if (MyApplication.Z) {
            this.llOffline.setVisibility(0);
            this.tvAccountLogout.setVisibility(8);
            this.settingsMessageNotificationsLink.setVisibility(8);
            this.rlSyncPattern.setVisibility(8);
            this.rlNinjaMode.setVisibility(8);
            this.rlChat.setVisibility(8);
        } else {
            this.llOffline.setVisibility(8);
            this.tvAccountLogout.setVisibility(8);
            this.settingsMessageNotificationsLink.setVisibility(0);
            this.rlSyncPattern.setVisibility(0);
            this.rlNinjaMode.setVisibility(0);
            this.rlChat.setVisibility(0);
        }
        boolean z = WearUtils.D;
        lg3.f(WearUtils.x);
        this.rlGameMode.setVisibility(8);
        I4();
        EventBus.getDefault().register(this);
        kd2.C().s(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f = false;
        me3.c(me3.c.ME_SETTINGS_UI_EXIT);
        EventBus.getDefault().unregister(this);
        kd2.C().J(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginOrOfflineEvent loginOrOfflineEvent) {
        if (loginOrOfflineEvent.isLogin()) {
            this.llOffline.setVisibility(8);
            this.tvAccountLogout.setVisibility(8);
            this.settingsMessageNotificationsLink.setVisibility(0);
            this.rlSyncPattern.setVisibility(0);
            this.rlNinjaMode.setVisibility(0);
            this.rlChat.setVisibility(0);
        } else {
            this.llOffline.setVisibility(0);
            this.tvAccountLogout.setVisibility(8);
            this.settingsMessageNotificationsLink.setVisibility(8);
            this.rlSyncPattern.setVisibility(8);
            this.rlNinjaMode.setVisibility(8);
            this.rlChat.setVisibility(8);
        }
        I4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        DaoUtils.getSettingDao().update((SettingDao) this.e);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.c) {
            this.c = false;
            if (y4()) {
                DaoUtils.getTestValueDao().save(zt3.k, "1", TestValueDao.NINJA_MODE_SWITCH_TYPE);
                EventBus.getDefault().post(new OpenLockEvent(true));
                this.sbNinjaMode.setChecked(true);
            }
        }
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            this.tvDarkMode.setText(ah4.e(R.string.settings_dark_mode_system));
        } else if (i2 == 1) {
            this.tvDarkMode.setText(ah4.e(R.string.depth_control_off));
        } else {
            this.tvDarkMode.setText(ah4.e(R.string.depth_control_on));
        }
        J4();
    }

    public final void x4() {
        ye3.i("Setting", "game_mode_click", "click", "game_mode", "button");
    }

    public final boolean y4() {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this);
    }

    public final void z4() {
        tn2.x(this.application).l("/wear/myPattern/deleteAllMyPattern", new HashMap(), new g(this));
    }
}
