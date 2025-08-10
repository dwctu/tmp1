package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class AlarmDurationDialog_ViewBinding implements Unbinder {
    public AlarmDurationDialog a;

    @UiThread
    public AlarmDurationDialog_ViewBinding(AlarmDurationDialog alarmDurationDialog, View view) {
        this.a = alarmDurationDialog;
        alarmDurationDialog.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        alarmDurationDialog.vLine1 = Utils.findRequiredView(view, R.id.v_line_1, "field 'vLine1'");
        alarmDurationDialog.llAlarmDuration = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_duration, "field 'llAlarmDuration'", LinearLayout.class);
        alarmDurationDialog.vLine2 = Utils.findRequiredView(view, R.id.v_line_2, "field 'vLine2'");
        alarmDurationDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        alarmDurationDialog.tvDone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_done, "field 'tvDone'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmDurationDialog alarmDurationDialog = this.a;
        if (alarmDurationDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmDurationDialog.tvTitle = null;
        alarmDurationDialog.vLine1 = null;
        alarmDurationDialog.llAlarmDuration = null;
        alarmDurationDialog.vLine2 = null;
        alarmDurationDialog.tvCancel = null;
        alarmDurationDialog.tvDone = null;
    }
}
