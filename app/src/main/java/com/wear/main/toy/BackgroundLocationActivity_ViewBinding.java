package com.wear.main.toy;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class BackgroundLocationActivity_ViewBinding implements Unbinder {
    public BackgroundLocationActivity a;

    @UiThread
    public BackgroundLocationActivity_ViewBinding(BackgroundLocationActivity backgroundLocationActivity, View view) {
        this.a = backgroundLocationActivity;
        backgroundLocationActivity.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        backgroundLocationActivity.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        backgroundLocationActivity.dotLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dot_layout, "field 'dotLayout'", LinearLayout.class);
        backgroundLocationActivity.toSetting = (TextView) Utils.findRequiredViewAsType(view, R.id.to_setting, "field 'toSetting'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BackgroundLocationActivity backgroundLocationActivity = this.a;
        if (backgroundLocationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        backgroundLocationActivity.ivClose = null;
        backgroundLocationActivity.viewpager = null;
        backgroundLocationActivity.dotLayout = null;
        backgroundLocationActivity.toSetting = null;
    }
}
