package com.wear.main.longDistance.alarm;

import android.view.View;
import android.widget.ImageView;
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
public class ChatAlarmActivity_ViewBinding implements Unbinder {
    public ChatAlarmActivity a;

    @UiThread
    public ChatAlarmActivity_ViewBinding(ChatAlarmActivity chatAlarmActivity, View view) {
        this.a = chatAlarmActivity;
        chatAlarmActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatAlarmActivity.createAlarmActionOne = (ImageView) Utils.findRequiredViewAsType(view, R.id.create_alarm_action_one, "field 'createAlarmActionOne'", ImageView.class);
        chatAlarmActivity.createAlarmActionOneLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_my_timepicker_view, "field 'createAlarmActionOneLayout'", LinearLayout.class);
        chatAlarmActivity.createAlarmActionMore = (ImageView) Utils.findRequiredViewAsType(view, R.id.create_alarm_action_more, "field 'createAlarmActionMore'", ImageView.class);
        chatAlarmActivity.createAlarmActionMoreLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_action_more_layout, "field 'createAlarmActionMoreLayout'", LinearLayout.class);
        chatAlarmActivity.tvCreateAlarmActionMore = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_create_alarm_action_more, "field 'tvCreateAlarmActionMore'", TextView.class);
        chatAlarmActivity.alarmListLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_list_layout, "field 'alarmListLayout'", LinearLayout.class);
        chatAlarmActivity.alarmNotifySwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.alarm_notify_swith, "field 'alarmNotifySwith'", SwitchView.class);
        chatAlarmActivity.alarmMissSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.alarm_miss_swith, "field 'alarmMissSwith'", SwitchView.class);
        chatAlarmActivity.tvAlarmMessageContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_message_content, "field 'tvAlarmMessageContent'", TextView.class);
        chatAlarmActivity.alarmMessageSettings = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message_settings, "field 'alarmMessageSettings'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatAlarmActivity chatAlarmActivity = this.a;
        if (chatAlarmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatAlarmActivity.actionbar = null;
        chatAlarmActivity.createAlarmActionOne = null;
        chatAlarmActivity.createAlarmActionOneLayout = null;
        chatAlarmActivity.createAlarmActionMore = null;
        chatAlarmActivity.createAlarmActionMoreLayout = null;
        chatAlarmActivity.tvCreateAlarmActionMore = null;
        chatAlarmActivity.alarmListLayout = null;
        chatAlarmActivity.alarmNotifySwith = null;
        chatAlarmActivity.alarmMissSwith = null;
        chatAlarmActivity.tvAlarmMessageContent = null;
        chatAlarmActivity.alarmMessageSettings = null;
    }
}
