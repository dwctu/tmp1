package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ControlLinkBanDialog_ViewBinding implements Unbinder {
    public ControlLinkBanDialog a;

    @UiThread
    public ControlLinkBanDialog_ViewBinding(ControlLinkBanDialog controlLinkBanDialog, View view) {
        this.a = controlLinkBanDialog;
        controlLinkBanDialog.tvDes1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_des1, "field 'tvDes1'", TextView.class);
        controlLinkBanDialog.tvDes2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_des2, "field 'tvDes2'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkBanDialog controlLinkBanDialog = this.a;
        if (controlLinkBanDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkBanDialog.tvDes1 = null;
        controlLinkBanDialog.tvDes2 = null;
    }
}
