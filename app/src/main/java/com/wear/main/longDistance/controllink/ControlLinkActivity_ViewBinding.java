package com.wear.main.longDistance.controllink;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ControlLinkActivity_ViewBinding implements Unbinder {
    public ControlLinkActivity a;

    @UiThread
    public ControlLinkActivity_ViewBinding(ControlLinkActivity controlLinkActivity, View view) {
        this.a = controlLinkActivity;
        controlLinkActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        controlLinkActivity.etControlTimes = (EditText) Utils.findRequiredViewAsType(view, R.id.et_control_times, "field 'etControlTimes'", EditText.class);
        controlLinkActivity.btCreateControlLink = (Button) Utils.findRequiredViewAsType(view, R.id.bt_create_control_link, "field 'btCreateControlLink'", Button.class);
        controlLinkActivity.layoutControMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_contro_message, "field 'layoutControMessage'", LinearLayout.class);
        controlLinkActivity.tvTimesUntis = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_times_untis, "field 'tvTimesUntis'", TextView.class);
        controlLinkActivity.tvToysUntis = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toys_untis, "field 'tvToysUntis'", TextView.class);
        controlLinkActivity.rlTimesUntis = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_times_untis, "field 'rlTimesUntis'", RelativeLayout.class);
        controlLinkActivity.rlToysUntis = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_toys_untis, "field 'rlToysUntis'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkActivity controlLinkActivity = this.a;
        if (controlLinkActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkActivity.actionbar = null;
        controlLinkActivity.etControlTimes = null;
        controlLinkActivity.btCreateControlLink = null;
        controlLinkActivity.layoutControMessage = null;
        controlLinkActivity.tvTimesUntis = null;
        controlLinkActivity.tvToysUntis = null;
        controlLinkActivity.rlTimesUntis = null;
        controlLinkActivity.rlToysUntis = null;
    }
}
