package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ShowAlarmPopwindow_ViewBinding implements Unbinder {
    public ShowAlarmPopwindow a;

    @UiThread
    public ShowAlarmPopwindow_ViewBinding(ShowAlarmPopwindow showAlarmPopwindow, View view) {
        this.a = showAlarmPopwindow;
        showAlarmPopwindow.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        showAlarmPopwindow.tvAmOrPm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_am_or_pm, "field 'tvAmOrPm'", TextView.class);
        showAlarmPopwindow.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        showAlarmPopwindow.tvAlarmFrom = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_from, "field 'tvAlarmFrom'", TextView.class);
        showAlarmPopwindow.ivSnoozeBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_snooze_bg, "field 'ivSnoozeBg'", ImageView.class);
        showAlarmPopwindow.tvSnooze = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_snooze, "field 'tvSnooze'", TextView.class);
        showAlarmPopwindow.tvSnoozeCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_snooze_count, "field 'tvSnoozeCount'", TextView.class);
        showAlarmPopwindow.tvTurnOff = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_turn_off, "field 'tvTurnOff'", TextView.class);
        showAlarmPopwindow.ivUp = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_up, "field 'ivUp'", ImageView.class);
        showAlarmPopwindow.stlRoot = (SlideTopViewDragHelper) Utils.findRequiredViewAsType(view, R.id.stl_root, "field 'stlRoot'", SlideTopViewDragHelper.class);
        showAlarmPopwindow.clRoot = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_root, "field 'clRoot'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ShowAlarmPopwindow showAlarmPopwindow = this.a;
        if (showAlarmPopwindow == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        showAlarmPopwindow.ivClose = null;
        showAlarmPopwindow.tvAmOrPm = null;
        showAlarmPopwindow.tvTime = null;
        showAlarmPopwindow.tvAlarmFrom = null;
        showAlarmPopwindow.ivSnoozeBg = null;
        showAlarmPopwindow.tvSnooze = null;
        showAlarmPopwindow.tvSnoozeCount = null;
        showAlarmPopwindow.tvTurnOff = null;
        showAlarmPopwindow.ivUp = null;
        showAlarmPopwindow.stlRoot = null;
        showAlarmPopwindow.clRoot = null;
    }
}
