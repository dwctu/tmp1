package com.wear.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class TimePickerDialog_ViewBinding implements Unbinder {
    public TimePickerDialog a;

    @UiThread
    public TimePickerDialog_ViewBinding(TimePickerDialog timePickerDialog, View view) {
        this.a = timePickerDialog;
        timePickerDialog.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        timePickerDialog.cycleWheelView0 = (CycleWheelView) Utils.findRequiredViewAsType(view, R.id.cycleWheelView0, "field 'cycleWheelView0'", CycleWheelView.class);
        timePickerDialog.cycleWheelView1 = (CycleWheelView) Utils.findRequiredViewAsType(view, R.id.cycleWheelView1, "field 'cycleWheelView1'", CycleWheelView.class);
        timePickerDialog.cycleWheelView2 = (CycleWheelView) Utils.findRequiredViewAsType(view, R.id.cycleWheelView2, "field 'cycleWheelView2'", CycleWheelView.class);
        timePickerDialog.linear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linear, "field 'linear'", LinearLayout.class);
        timePickerDialog.cancelBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel_btn, "field 'cancelBtn'", TextView.class);
        timePickerDialog.okBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.ok_btn, "field 'okBtn'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TimePickerDialog timePickerDialog = this.a;
        if (timePickerDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        timePickerDialog.title = null;
        timePickerDialog.cycleWheelView0 = null;
        timePickerDialog.cycleWheelView1 = null;
        timePickerDialog.cycleWheelView2 = null;
        timePickerDialog.linear = null;
        timePickerDialog.cancelBtn = null;
        timePickerDialog.okBtn = null;
    }
}
