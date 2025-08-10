package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class SpeedModeTipDialog_ViewBinding implements Unbinder {
    public SpeedModeTipDialog a;

    @UiThread
    public SpeedModeTipDialog_ViewBinding(SpeedModeTipDialog speedModeTipDialog, View view) {
        this.a = speedModeTipDialog;
        speedModeTipDialog.ivSpeedModeTipSelect = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_speed_mode_tip_select, "field 'ivSpeedModeTipSelect'", ImageView.class);
        speedModeTipDialog.tvSpeedModeTipSelect = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_speed_mode_tip_select, "field 'tvSpeedModeTipSelect'", TextView.class);
        speedModeTipDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        speedModeTipDialog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SpeedModeTipDialog speedModeTipDialog = this.a;
        if (speedModeTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        speedModeTipDialog.ivSpeedModeTipSelect = null;
        speedModeTipDialog.tvSpeedModeTipSelect = null;
        speedModeTipDialog.tvCancel = null;
        speedModeTipDialog.tvConfirm = null;
    }
}
