package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AlarmListActivity_ViewBinding implements Unbinder {
    public AlarmListActivity a;

    @UiThread
    public AlarmListActivity_ViewBinding(AlarmListActivity alarmListActivity, View view) {
        this.a = alarmListActivity;
        alarmListActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        alarmListActivity.ivAlarmListAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_alarm_list_add, "field 'ivAlarmListAdd'", ImageView.class);
        alarmListActivity.createTvText = (TextView) Utils.findRequiredViewAsType(view, R.id.create_tv_text, "field 'createTvText'", TextView.class);
        alarmListActivity.createAlarmTop = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_alarm_top, "field 'createAlarmTop'", LinearLayout.class);
        alarmListActivity.rvAlarmList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_alarm_list, "field 'rvAlarmList'", RecyclerView.class);
        alarmListActivity.createAlarmImage = (TextView) Utils.findRequiredViewAsType(view, R.id.create_alarm_image, "field 'createAlarmImage'", TextView.class);
        alarmListActivity.createEmptyLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_empty_layout, "field 'createEmptyLayout'", LinearLayout.class);
        alarmListActivity.rootLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.root_layout, "field 'rootLayout'", LinearLayout.class);
        alarmListActivity.llAlarmPermissionTip = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_permission_tip, "field 'llAlarmPermissionTip'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmListActivity alarmListActivity = this.a;
        if (alarmListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmListActivity.actionbar = null;
        alarmListActivity.ivAlarmListAdd = null;
        alarmListActivity.createTvText = null;
        alarmListActivity.createAlarmTop = null;
        alarmListActivity.rvAlarmList = null;
        alarmListActivity.createAlarmImage = null;
        alarmListActivity.createEmptyLayout = null;
        alarmListActivity.rootLayout = null;
        alarmListActivity.llAlarmPermissionTip = null;
    }
}
