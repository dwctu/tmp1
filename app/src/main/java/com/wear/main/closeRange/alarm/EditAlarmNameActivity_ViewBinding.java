package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class EditAlarmNameActivity_ViewBinding implements Unbinder {
    public EditAlarmNameActivity a;

    @UiThread
    public EditAlarmNameActivity_ViewBinding(EditAlarmNameActivity editAlarmNameActivity, View view) {
        this.a = editAlarmNameActivity;
        editAlarmNameActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        editAlarmNameActivity.currentNickname = (EditText) Utils.findRequiredViewAsType(view, R.id.current_nickname, "field 'currentNickname'", EditText.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditAlarmNameActivity editAlarmNameActivity = this.a;
        if (editAlarmNameActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editAlarmNameActivity.actionbar = null;
        editAlarmNameActivity.currentNickname = null;
    }
}
