package com.wear.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class FlashActivity_ViewBinding implements Unbinder {
    public FlashActivity a;

    @UiThread
    public FlashActivity_ViewBinding(FlashActivity flashActivity, View view) {
        this.a = flashActivity;
        flashActivity.tvProgress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_progress, "field 'tvProgress'", TextView.class);
        flashActivity.proBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.proBar, "field 'proBar'", ProgressBar.class);
        flashActivity.llProgress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_progress, "field 'llProgress'", LinearLayout.class);
        flashActivity.screanRootLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.screan_root_layout, "field 'screanRootLayout'", RelativeLayout.class);
        flashActivity.constraintLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.constraint_layout, "field 'constraintLayout'", ConstraintLayout.class);
        flashActivity.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        flashActivity.dotLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dot_layout, "field 'dotLayout'", LinearLayout.class);
        flashActivity.rlActivity = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_activity, "field 'rlActivity'", RelativeLayout.class);
        flashActivity.ivActivity = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_activity, "field 'ivActivity'", ImageView.class);
        flashActivity.tvSkip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_skip, "field 'tvSkip'", TextView.class);
        flashActivity.textview3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.textView3, "field 'textview3'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FlashActivity flashActivity = this.a;
        if (flashActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        flashActivity.tvProgress = null;
        flashActivity.proBar = null;
        flashActivity.llProgress = null;
        flashActivity.screanRootLayout = null;
        flashActivity.constraintLayout = null;
        flashActivity.viewpager = null;
        flashActivity.dotLayout = null;
        flashActivity.rlActivity = null;
        flashActivity.ivActivity = null;
        flashActivity.tvSkip = null;
        flashActivity.textview3 = null;
    }
}
