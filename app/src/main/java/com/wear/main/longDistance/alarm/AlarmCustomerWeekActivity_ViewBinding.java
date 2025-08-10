package com.wear.main.longDistance.alarm;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AlarmCustomerWeekActivity_ViewBinding implements Unbinder {
    public AlarmCustomerWeekActivity a;

    @UiThread
    public AlarmCustomerWeekActivity_ViewBinding(AlarmCustomerWeekActivity alarmCustomerWeekActivity, View view) {
        this.a = alarmCustomerWeekActivity;
        alarmCustomerWeekActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        alarmCustomerWeekActivity.customWeekLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.custom_week_layout, "field 'customWeekLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmCustomerWeekActivity alarmCustomerWeekActivity = this.a;
        if (alarmCustomerWeekActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmCustomerWeekActivity.actionbar = null;
        alarmCustomerWeekActivity.customWeekLayout = null;
    }
}
