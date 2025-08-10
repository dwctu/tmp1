package com.wear.main.closeRange.alexa;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AlexaPinActivity_ViewBinding implements Unbinder {
    public AlexaPinActivity a;

    @UiThread
    public AlexaPinActivity_ViewBinding(AlexaPinActivity alexaPinActivity, View view) {
        this.a = alexaPinActivity;
        alexaPinActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        alexaPinActivity.alexaTall = (TextView) Utils.findRequiredViewAsType(view, R.id.alexa_tall, "field 'alexaTall'", TextView.class);
        alexaPinActivity.pinNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pin_number, "field 'pinNumber'", TextView.class);
        alexaPinActivity.alexaBtn = (Button) Utils.findRequiredViewAsType(view, R.id.alexa_btn, "field 'alexaBtn'", Button.class);
        alexaPinActivity.moreCommand = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.more_command, "field 'moreCommand'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlexaPinActivity alexaPinActivity = this.a;
        if (alexaPinActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alexaPinActivity.actionbar = null;
        alexaPinActivity.alexaTall = null;
        alexaPinActivity.pinNumber = null;
        alexaPinActivity.alexaBtn = null;
        alexaPinActivity.moreCommand = null;
    }
}
