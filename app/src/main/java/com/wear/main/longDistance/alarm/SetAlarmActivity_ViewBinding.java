package com.wear.main.longDistance.alarm;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class SetAlarmActivity_ViewBinding implements Unbinder {
    public SetAlarmActivity a;

    @UiThread
    public SetAlarmActivity_ViewBinding(SetAlarmActivity setAlarmActivity, View view) {
        this.a = setAlarmActivity;
        setAlarmActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        setAlarmActivity.createAlarmActionMoreLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_action_more_layout, "field 'createAlarmActionMoreLayout'", LinearLayout.class);
        setAlarmActivity.tvTimeContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_content, "field 'tvTimeContent'", TextView.class);
        setAlarmActivity.timeSettings = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.time_settings, "field 'timeSettings'", LinearLayout.class);
        setAlarmActivity.tvFrequencyContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_frequency_content, "field 'tvFrequencyContent'", TextView.class);
        setAlarmActivity.frequencySettings = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.frequency_settings, "field 'frequencySettings'", LinearLayout.class);
        setAlarmActivity.tvDateContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date_content, "field 'tvDateContent'", TextView.class);
        setAlarmActivity.dateSettings = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.date_settings, "field 'dateSettings'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SetAlarmActivity setAlarmActivity = this.a;
        if (setAlarmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        setAlarmActivity.actionbar = null;
        setAlarmActivity.createAlarmActionMoreLayout = null;
        setAlarmActivity.tvTimeContent = null;
        setAlarmActivity.timeSettings = null;
        setAlarmActivity.tvFrequencyContent = null;
        setAlarmActivity.frequencySettings = null;
        setAlarmActivity.tvDateContent = null;
        setAlarmActivity.dateSettings = null;
    }
}
