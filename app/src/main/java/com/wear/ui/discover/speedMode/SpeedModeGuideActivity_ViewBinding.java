package com.wear.ui.discover.speedMode;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.iwatcher.ImageWatcher;
import com.wear.widget.llong.DSGuideViewpager;

/* loaded from: classes3.dex */
public class SpeedModeGuideActivity_ViewBinding implements Unbinder {
    public SpeedModeGuideActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeGuideActivity a;

        public a(SpeedModeGuideActivity_ViewBinding speedModeGuideActivity_ViewBinding, SpeedModeGuideActivity speedModeGuideActivity) {
            this.a = speedModeGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeGuideActivity a;

        public b(SpeedModeGuideActivity_ViewBinding speedModeGuideActivity_ViewBinding, SpeedModeGuideActivity speedModeGuideActivity) {
            this.a = speedModeGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SpeedModeGuideActivity_ViewBinding(SpeedModeGuideActivity speedModeGuideActivity, View view) {
        this.a = speedModeGuideActivity;
        speedModeGuideActivity.rlDSGuide = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_main_dsguide_rl, "field 'rlDSGuide'", RelativeLayout.class);
        speedModeGuideActivity.dsGuideViewpager = (DSGuideViewpager) Utils.findRequiredViewAsType(view, R.id.ac_main_dsguide_dsvp, "field 'dsGuideViewpager'", DSGuideViewpager.class);
        speedModeGuideActivity.vImageWatcher = (ImageWatcher) Utils.findRequiredViewAsType(view, R.id.v_image_watcher, "field 'vImageWatcher'", ImageWatcher.class);
        speedModeGuideActivity.tvGuideTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_main_guide_title, "field 'tvGuideTitle'", TextView.class);
        speedModeGuideActivity.tvGuideMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_main_guide_msg, "field 'tvGuideMsg'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_main_dsguide_check, "field 'tvGuideCheck' and method 'onClick'");
        speedModeGuideActivity.tvGuideCheck = (TextView) Utils.castView(viewFindRequiredView, R.id.ac_main_dsguide_check, "field 'tvGuideCheck'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, speedModeGuideActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_main_dsguide_close, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, speedModeGuideActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SpeedModeGuideActivity speedModeGuideActivity = this.a;
        if (speedModeGuideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        speedModeGuideActivity.rlDSGuide = null;
        speedModeGuideActivity.dsGuideViewpager = null;
        speedModeGuideActivity.vImageWatcher = null;
        speedModeGuideActivity.tvGuideTitle = null;
        speedModeGuideActivity.tvGuideMsg = null;
        speedModeGuideActivity.tvGuideCheck = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
