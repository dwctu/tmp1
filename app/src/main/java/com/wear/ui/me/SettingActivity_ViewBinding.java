package com.wear.ui.me;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes4.dex */
public class SettingActivity_ViewBinding implements Unbinder {
    public SettingActivity a;

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.a = settingActivity;
        settingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        settingActivity.settingMyAccount = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_my_account, "field 'settingMyAccount'", RelativeLayout.class);
        settingActivity.settingMusicLinkedAccount = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_music_linked_account, "field 'settingMusicLinkedAccount'", RelativeLayout.class);
        settingActivity.settingsMessageNotificationsLink = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.settings_message_notifications_link, "field 'settingsMessageNotificationsLink'", RelativeLayout.class);
        settingActivity.settingBlockContacts = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.setting_block_contacts, "field 'settingBlockContacts'", RelativeLayout.class);
        settingActivity.settingKeepScreenSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_keep_screen_swith, "field 'settingKeepScreenSwith'", SwitchView.class);
        settingActivity.rlGameMode = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_game_mode, "field 'rlGameMode'", RelativeLayout.class);
        settingActivity.rlLanguage = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_language, "field 'rlLanguage'", RelativeLayout.class);
        settingActivity.tvSettingsMessageNotifications = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_settings_message_notifications, "field 'tvSettingsMessageNotifications'", TextView.class);
        settingActivity.tvBlockedContacts = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_blocked_contacts, "field 'tvBlockedContacts'", TextView.class);
        settingActivity.blockBetaFlag = (TextView) Utils.findRequiredViewAsType(view, R.id.block_beta_flag, "field 'blockBetaFlag'", TextView.class);
        settingActivity.sbSyncPattern = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sb_sync_pattern, "field 'sbSyncPattern'", SwitchView.class);
        settingActivity.vSyncPattern = Utils.findRequiredView(view, R.id.v_sync_pattern, "field 'vSyncPattern'");
        settingActivity.rlSyncPattern = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_sync_pattern, "field 'rlSyncPattern'", RelativeLayout.class);
        settingActivity.rlNinjaMode = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_ninja_mode, "field 'rlNinjaMode'", RelativeLayout.class);
        settingActivity.sbNinjaMode = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sb_ninja_mode, "field 'sbNinjaMode'", SwitchView.class);
        settingActivity.vNinjaMode = Utils.findRequiredView(view, R.id.v_ninja_mode, "field 'vNinjaMode'");
        settingActivity.rlChat = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_chat, "field 'rlChat'", RelativeLayout.class);
        settingActivity.rlHomepage = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_homepage, "field 'rlHomepage'", RelativeLayout.class);
        settingActivity.settingRedDot = Utils.findRequiredView(view, R.id.setting_red_dot, "field 'settingRedDot'");
        settingActivity.tvSyncPattern = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sync_pattern, "field 'tvSyncPattern'", TextView.class);
        settingActivity.tvNinjaMode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ninja_mode, "field 'tvNinjaMode'", TextView.class);
        settingActivity.rlSkin = Utils.findRequiredView(view, R.id.rl_skin, "field 'rlSkin'");
        settingActivity.tvAccountLogout = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_account_logout, "field 'tvAccountLogout'", TextView.class);
        settingActivity.tvDarkMode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dark_mode, "field 'tvDarkMode'", TextView.class);
        settingActivity.llLoginSetting = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_login_setting, "field 'llLoginSetting'", LinearLayout.class);
        settingActivity.llOffline = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_offline, "field 'llOffline'", LinearLayout.class);
        settingActivity.dotAccount = Utils.findRequiredView(view, R.id.account_setting_reddot_account, "field 'dotAccount'");
        settingActivity.rl_develop_model = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_develop_model, "field 'rl_develop_model'", RelativeLayout.class);
        settingActivity.tv_develop_model = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_develop_model, "field 'tv_develop_model'", TextView.class);
        settingActivity.setting_develop_model = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_develop_model, "field 'setting_develop_model'", SwitchView.class);
        settingActivity.setting_default_theme = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_default_theme, "field 'setting_default_theme'", SwitchView.class);
        settingActivity.rl_default_theme = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_default_theme, "field 'rl_default_theme'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingActivity settingActivity = this.a;
        if (settingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        settingActivity.actionbar = null;
        settingActivity.settingMyAccount = null;
        settingActivity.settingMusicLinkedAccount = null;
        settingActivity.settingsMessageNotificationsLink = null;
        settingActivity.settingBlockContacts = null;
        settingActivity.settingKeepScreenSwith = null;
        settingActivity.rlGameMode = null;
        settingActivity.rlLanguage = null;
        settingActivity.tvSettingsMessageNotifications = null;
        settingActivity.tvBlockedContacts = null;
        settingActivity.blockBetaFlag = null;
        settingActivity.sbSyncPattern = null;
        settingActivity.vSyncPattern = null;
        settingActivity.rlSyncPattern = null;
        settingActivity.rlNinjaMode = null;
        settingActivity.sbNinjaMode = null;
        settingActivity.vNinjaMode = null;
        settingActivity.rlChat = null;
        settingActivity.rlHomepage = null;
        settingActivity.settingRedDot = null;
        settingActivity.tvSyncPattern = null;
        settingActivity.tvNinjaMode = null;
        settingActivity.rlSkin = null;
        settingActivity.tvAccountLogout = null;
        settingActivity.tvDarkMode = null;
        settingActivity.llLoginSetting = null;
        settingActivity.llOffline = null;
        settingActivity.dotAccount = null;
        settingActivity.rl_develop_model = null;
        settingActivity.tv_develop_model = null;
        settingActivity.setting_develop_model = null;
        settingActivity.setting_default_theme = null;
        settingActivity.rl_default_theme = null;
    }
}
