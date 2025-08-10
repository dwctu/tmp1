package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class LanApiUpdateToyDailog_ViewBinding implements Unbinder {
    public LanApiUpdateToyDailog a;

    @UiThread
    public LanApiUpdateToyDailog_ViewBinding(LanApiUpdateToyDailog lanApiUpdateToyDailog, View view) {
        this.a = lanApiUpdateToyDailog;
        lanApiUpdateToyDailog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        lanApiUpdateToyDailog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LanApiUpdateToyDailog lanApiUpdateToyDailog = this.a;
        if (lanApiUpdateToyDailog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        lanApiUpdateToyDailog.tvConfirm = null;
        lanApiUpdateToyDailog.tvCancel = null;
    }
}
