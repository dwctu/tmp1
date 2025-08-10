package com.wear.main;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class NetTestActivity_ViewBinding implements Unbinder {
    public NetTestActivity a;

    @UiThread
    public NetTestActivity_ViewBinding(NetTestActivity netTestActivity, View view) {
        this.a = netTestActivity;
        netTestActivity.bar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.action_bar, "field 'bar'", MyActionBar.class);
        netTestActivity.tvPing = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ping, "field 'tvPing'", TextView.class);
        netTestActivity.tvDnsAddress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dns_address, "field 'tvDnsAddress'", TextView.class);
        netTestActivity.tvHostAddress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_host_address, "field 'tvHostAddress'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NetTestActivity netTestActivity = this.a;
        if (netTestActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        netTestActivity.bar = null;
        netTestActivity.tvPing = null;
        netTestActivity.tvDnsAddress = null;
        netTestActivity.tvHostAddress = null;
    }
}
