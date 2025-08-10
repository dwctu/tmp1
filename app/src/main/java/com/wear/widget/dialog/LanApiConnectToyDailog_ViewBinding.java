package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class LanApiConnectToyDailog_ViewBinding implements Unbinder {
    public LanApiConnectToyDailog a;

    @UiThread
    public LanApiConnectToyDailog_ViewBinding(LanApiConnectToyDailog lanApiConnectToyDailog, View view) {
        this.a = lanApiConnectToyDailog;
        lanApiConnectToyDailog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        lanApiConnectToyDailog.buyToys = (TextView) Utils.findRequiredViewAsType(view, R.id.buy_toys, "field 'buyToys'", TextView.class);
        lanApiConnectToyDailog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        lanApiConnectToyDailog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LanApiConnectToyDailog lanApiConnectToyDailog = this.a;
        if (lanApiConnectToyDailog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        lanApiConnectToyDailog.tvText = null;
        lanApiConnectToyDailog.buyToys = null;
        lanApiConnectToyDailog.tvConfirm = null;
        lanApiConnectToyDailog.tvCancel = null;
    }
}
