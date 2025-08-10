package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class AlarmCreateActivity_ViewBinding implements Unbinder {
    public AlarmCreateActivity a;

    @UiThread
    public AlarmCreateActivity_ViewBinding(AlarmCreateActivity alarmCreateActivity, View view) {
        this.a = alarmCreateActivity;
        alarmCreateActivity.createAlarmActionOneLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_my_timepicker_view, "field 'createAlarmActionOneLayout'", LinearLayout.class);
        alarmCreateActivity.tvAlarmNotification = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_notification, "field 'tvAlarmNotification'", TextView.class);
        alarmCreateActivity.alarmMessageNotification = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message_notification, "field 'alarmMessageNotification'", LinearLayout.class);
        alarmCreateActivity.tvAlarmRepeat = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_repeat, "field 'tvAlarmRepeat'", TextView.class);
        alarmCreateActivity.alarmMessageRepeat = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message_repeat, "field 'alarmMessageRepeat'", LinearLayout.class);
        alarmCreateActivity.alarmNotifySwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.alarm_notify_swith, "field 'alarmNotifySwith'", SwitchView.class);
        alarmCreateActivity.createAlarmPartnerTimepickerLayout = Utils.findRequiredView(view, R.id.create_alarm_partner_timepicker_layout, "field 'createAlarmPartnerTimepickerLayout'");
        alarmCreateActivity.createAlarmPartnerTimepickerView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_partner_timepicker_view, "field 'createAlarmPartnerTimepickerView'", LinearLayout.class);
        alarmCreateActivity.rootView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rootView, "field 'rootView'", LinearLayout.class);
        alarmCreateActivity.alarmNotifySwithLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_notify_swith_layout, "field 'alarmNotifySwithLayout'", LinearLayout.class);
        alarmCreateActivity.tvMyGtmTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_my_gtm_time, "field 'tvMyGtmTime'", TextView.class);
        alarmCreateActivity.tvPatternGtmTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_gtm_time, "field 'tvPatternGtmTime'", TextView.class);
        alarmCreateActivity.tvAlarmTitleContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_title_content, "field 'tvAlarmTitleContent'", TextView.class);
        alarmCreateActivity.alarmTitleSettings = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_title_settings, "field 'alarmTitleSettings'", LinearLayout.class);
        alarmCreateActivity.tvAlarmDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_duration, "field 'tvAlarmDuration'", TextView.class);
        alarmCreateActivity.llAlarmDuration = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_duration, "field 'llAlarmDuration'", LinearLayout.class);
        alarmCreateActivity.tvAlarmSnooze = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_snooze, "field 'tvAlarmSnooze'", TextView.class);
        alarmCreateActivity.llAlarmSnooze = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_snooze, "field 'llAlarmSnooze'", LinearLayout.class);
        alarmCreateActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        alarmCreateActivity.tvSend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_send, "field 'tvSend'", TextView.class);
        alarmCreateActivity.tabLine = Utils.findRequiredView(view, R.id.tab_line, "field 'tabLine'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmCreateActivity alarmCreateActivity = this.a;
        if (alarmCreateActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmCreateActivity.createAlarmActionOneLayout = null;
        alarmCreateActivity.tvAlarmNotification = null;
        alarmCreateActivity.alarmMessageNotification = null;
        alarmCreateActivity.tvAlarmRepeat = null;
        alarmCreateActivity.alarmMessageRepeat = null;
        alarmCreateActivity.alarmNotifySwith = null;
        alarmCreateActivity.createAlarmPartnerTimepickerLayout = null;
        alarmCreateActivity.createAlarmPartnerTimepickerView = null;
        alarmCreateActivity.rootView = null;
        alarmCreateActivity.alarmNotifySwithLayout = null;
        alarmCreateActivity.tvMyGtmTime = null;
        alarmCreateActivity.tvPatternGtmTime = null;
        alarmCreateActivity.tvAlarmTitleContent = null;
        alarmCreateActivity.alarmTitleSettings = null;
        alarmCreateActivity.tvAlarmDuration = null;
        alarmCreateActivity.llAlarmDuration = null;
        alarmCreateActivity.tvAlarmSnooze = null;
        alarmCreateActivity.llAlarmSnooze = null;
        alarmCreateActivity.ivBack = null;
        alarmCreateActivity.tvSend = null;
        alarmCreateActivity.tabLine = null;
    }
}
