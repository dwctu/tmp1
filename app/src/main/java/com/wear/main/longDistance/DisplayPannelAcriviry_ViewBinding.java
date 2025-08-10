package com.wear.main.longDistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class DisplayPannelAcriviry_ViewBinding implements Unbinder {
    public DisplayPannelAcriviry a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ DisplayPannelAcriviry a;

        public a(DisplayPannelAcriviry_ViewBinding displayPannelAcriviry_ViewBinding, DisplayPannelAcriviry displayPannelAcriviry) {
            this.a = displayPannelAcriviry;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked();
        }
    }

    @UiThread
    public DisplayPannelAcriviry_ViewBinding(DisplayPannelAcriviry displayPannelAcriviry, View view) {
        this.a = displayPannelAcriviry;
        displayPannelAcriviry.ivTopBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_top_bg, "field 'ivTopBg'", ImageView.class);
        displayPannelAcriviry.tvPf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pf, "field 'tvPf'", TextView.class);
        displayPannelAcriviry.ivTopIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_top_icon, "field 'ivTopIcon'", ImageView.class);
        displayPannelAcriviry.tvToyStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_status, "field 'tvToyStatus'", TextView.class);
        displayPannelAcriviry.tvGoRoomTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_go_room_tip, "field 'tvGoRoomTip'", TextView.class);
        displayPannelAcriviry.vCenter = Utils.findRequiredView(view, R.id.v_center, "field 'vCenter'");
        displayPannelAcriviry.tvWaitReconnectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wait_reconnect_tip, "field 'tvWaitReconnectTip'", TextView.class);
        displayPannelAcriviry.tvProgress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_progress, "field 'tvProgress'", TextView.class);
        displayPannelAcriviry.proBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.proBar, "field 'proBar'", ProgressBar.class);
        displayPannelAcriviry.llProgress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_progress, "field 'llProgress'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "field 'tvStop' and method 'onViewClicked'");
        displayPannelAcriviry.tvStop = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_stop, "field 'tvStop'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, displayPannelAcriviry));
        displayPannelAcriviry.waitClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.wait_close, "field 'waitClose'", ImageView.class);
        displayPannelAcriviry.browserWaitLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.browser_wait_ll, "field 'browserWaitLl'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DisplayPannelAcriviry displayPannelAcriviry = this.a;
        if (displayPannelAcriviry == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        displayPannelAcriviry.ivTopBg = null;
        displayPannelAcriviry.tvPf = null;
        displayPannelAcriviry.ivTopIcon = null;
        displayPannelAcriviry.tvToyStatus = null;
        displayPannelAcriviry.tvGoRoomTip = null;
        displayPannelAcriviry.vCenter = null;
        displayPannelAcriviry.tvWaitReconnectTip = null;
        displayPannelAcriviry.tvProgress = null;
        displayPannelAcriviry.proBar = null;
        displayPannelAcriviry.llProgress = null;
        displayPannelAcriviry.tvStop = null;
        displayPannelAcriviry.waitClose = null;
        displayPannelAcriviry.browserWaitLl = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
