package com.wear.main.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class MessageNotificationsActivity_ViewBinding implements Unbinder {
    public MessageNotificationsActivity a;

    @UiThread
    public MessageNotificationsActivity_ViewBinding(MessageNotificationsActivity messageNotificationsActivity, View view) {
        this.a = messageNotificationsActivity;
        messageNotificationsActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        messageNotificationsActivity.settingNotificationSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_notification_swith, "field 'settingNotificationSwith'", SwitchView.class);
        messageNotificationsActivity.settingSoundSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_sound_swith, "field 'settingSoundSwith'", SwitchView.class);
        messageNotificationsActivity.settingVideoSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_video_swith, "field 'settingVideoSwith'", SwitchView.class);
        messageNotificationsActivity.settingPreviewSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_preview_swith, "field 'settingPreviewSwith'", SwitchView.class);
        messageNotificationsActivity.systemNotificationDisabledTips = (TextView) Utils.findRequiredViewAsType(view, R.id.system_notification_disabled_tips, "field 'systemNotificationDisabledTips'", TextView.class);
        messageNotificationsActivity.appOtherNotificationControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.app_other_notification_control, "field 'appOtherNotificationControl'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MessageNotificationsActivity messageNotificationsActivity = this.a;
        if (messageNotificationsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        messageNotificationsActivity.actionbar = null;
        messageNotificationsActivity.settingNotificationSwith = null;
        messageNotificationsActivity.settingSoundSwith = null;
        messageNotificationsActivity.settingVideoSwith = null;
        messageNotificationsActivity.settingPreviewSwith = null;
        messageNotificationsActivity.systemNotificationDisabledTips = null;
        messageNotificationsActivity.appOtherNotificationControl = null;
    }
}
