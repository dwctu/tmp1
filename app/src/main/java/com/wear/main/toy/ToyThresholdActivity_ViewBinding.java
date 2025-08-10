package com.wear.main.toy;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.llong.StrengthControlViewL;

/* loaded from: classes3.dex */
public class ToyThresholdActivity_ViewBinding implements Unbinder {
    public ToyThresholdActivity a;

    @UiThread
    public ToyThresholdActivity_ViewBinding(ToyThresholdActivity toyThresholdActivity, View view) {
        this.a = toyThresholdActivity;
        toyThresholdActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyThresholdActivity.thresholdControl = (StrengthControlViewL) Utils.findRequiredViewAsType(view, R.id.threshold_control, "field 'thresholdControl'", StrengthControlViewL.class);
        toyThresholdActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyThresholdActivity toyThresholdActivity = this.a;
        if (toyThresholdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyThresholdActivity.actionbar = null;
        toyThresholdActivity.thresholdControl = null;
        toyThresholdActivity.tvTip = null;
    }
}
