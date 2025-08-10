package com.wear.main.longDistance.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.control.multiToys.MultiControlPanel;

/* loaded from: classes3.dex */
public class ChatLiveControl_ViewBinding implements Unbinder {
    public ChatLiveControl a;

    @UiThread
    public ChatLiveControl_ViewBinding(ChatLiveControl chatLiveControl, View view) {
        this.a = chatLiveControl;
        chatLiveControl.tvControlTimeCenter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_time_center, "field 'tvControlTimeCenter'", TextView.class);
        chatLiveControl.vBeControledLive = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.v_be_controled_live, "field 'vBeControledLive'", LinearLayout.class);
        chatLiveControl.tvLiveControlTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_live_control_tip, "field 'tvLiveControlTip'", TextView.class);
        chatLiveControl.vLiveControlLine = Utils.findRequiredView(view, R.id.v_live_control_line, "field 'vLiveControlLine'");
        chatLiveControl.tvControlTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_time, "field 'tvControlTime'", TextView.class);
        chatLiveControl.ivControlClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_close, "field 'ivControlClose'", ImageView.class);
        chatLiveControl.llLiveControlTime = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_live_control_time, "field 'llLiveControlTime'", LinearLayout.class);
        chatLiveControl.vControlLiveNoToys = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.v_control_live_no_toys, "field 'vControlLiveNoToys'", ConstraintLayout.class);
        chatLiveControl.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multipanel_livecontrol, "field 'multiControlPanel'", MultiControlPanel.class);
        chatLiveControl.flLiveLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.fl_live_layout, "field 'flLiveLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatLiveControl chatLiveControl = this.a;
        if (chatLiveControl == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatLiveControl.tvControlTimeCenter = null;
        chatLiveControl.vBeControledLive = null;
        chatLiveControl.tvLiveControlTip = null;
        chatLiveControl.vLiveControlLine = null;
        chatLiveControl.tvControlTime = null;
        chatLiveControl.ivControlClose = null;
        chatLiveControl.llLiveControlTime = null;
        chatLiveControl.vControlLiveNoToys = null;
        chatLiveControl.multiControlPanel = null;
        chatLiveControl.flLiveLayout = null;
    }
}
