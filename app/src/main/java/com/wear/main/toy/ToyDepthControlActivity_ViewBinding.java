package com.wear.main.toy;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.DepthControlView;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class ToyDepthControlActivity_ViewBinding implements Unbinder {
    public ToyDepthControlActivity a;

    @UiThread
    public ToyDepthControlActivity_ViewBinding(ToyDepthControlActivity toyDepthControlActivity, View view) {
        this.a = toyDepthControlActivity;
        toyDepthControlActivity.dcvControl = (DepthControlView) Utils.findRequiredViewAsType(view, R.id.dcv_control, "field 'dcvControl'", DepthControlView.class);
        toyDepthControlActivity.sbDepthControl = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sb_depth_control, "field 'sbDepthControl'", SwitchView.class);
        toyDepthControlActivity.tvDepthControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_depth_control, "field 'tvDepthControl'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyDepthControlActivity toyDepthControlActivity = this.a;
        if (toyDepthControlActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyDepthControlActivity.dcvControl = null;
        toyDepthControlActivity.sbDepthControl = null;
        toyDepthControlActivity.tvDepthControl = null;
    }
}
