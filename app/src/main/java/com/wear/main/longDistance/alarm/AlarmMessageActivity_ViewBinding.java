package com.wear.main.longDistance.alarm;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AlarmMessageActivity_ViewBinding implements Unbinder {
    public AlarmMessageActivity a;

    @UiThread
    public AlarmMessageActivity_ViewBinding(AlarmMessageActivity alarmMessageActivity, View view) {
        this.a = alarmMessageActivity;
        alarmMessageActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        alarmMessageActivity.messageText = (EditText) Utils.findRequiredViewAsType(view, R.id.message_text, "field 'messageText'", EditText.class);
        alarmMessageActivity.messageTextNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.message_text_number, "field 'messageTextNumber'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmMessageActivity alarmMessageActivity = this.a;
        if (alarmMessageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmMessageActivity.actionbar = null;
        alarmMessageActivity.messageText = null;
        alarmMessageActivity.messageTextNumber = null;
    }
}
