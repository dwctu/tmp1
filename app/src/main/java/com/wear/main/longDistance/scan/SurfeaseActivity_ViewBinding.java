package com.wear.main.longDistance.scan;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class SurfeaseActivity_ViewBinding implements Unbinder {
    public SurfeaseActivity a;

    @UiThread
    public SurfeaseActivity_ViewBinding(SurfeaseActivity surfeaseActivity, View view) {
        this.a = surfeaseActivity;
        surfeaseActivity.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        surfeaseActivity.logo = (ImageView) Utils.findRequiredViewAsType(view, R.id.logo, "field 'logo'", ImageView.class);
        surfeaseActivity.sufeaseLogin = (ImageView) Utils.findRequiredViewAsType(view, R.id.sufease_login, "field 'sufeaseLogin'", ImageView.class);
        surfeaseActivity.sufeaseLoginCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.sufease_login_cancel, "field 'sufeaseLoginCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SurfeaseActivity surfeaseActivity = this.a;
        if (surfeaseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        surfeaseActivity.ivClose = null;
        surfeaseActivity.logo = null;
        surfeaseActivity.sufeaseLogin = null;
        surfeaseActivity.sufeaseLoginCancel = null;
    }
}
