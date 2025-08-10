package com.wear.main.longDistance.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class LDRControl_ViewBinding implements Unbinder {
    public LDRControl a;

    @UiThread
    public LDRControl_ViewBinding(LDRControl lDRControl, View view) {
        this.a = lDRControl;
        lDRControl.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        lDRControl.rvSelf = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_self, "field 'rvSelf'", RecyclerView.class);
        lDRControl.ivLdrControlStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control_states, "field 'ivLdrControlStates'", ImageView.class);
        lDRControl.ldrSensitivity = (SeekBar) Utils.findRequiredViewAsType(view, R.id.ldr_sensitivity, "field 'ldrSensitivity'", SeekBar.class);
        lDRControl.ldrSensitivityLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ldr_sensitivity_layout, "field 'ldrSensitivityLayout'", LinearLayout.class);
        lDRControl.ivLdrControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control, "field 'ivLdrControl'", ImageView.class);
        lDRControl.tvLdrControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ldr_control, "field 'tvLdrControl'", TextView.class);
        lDRControl.tvFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_name, "field 'tvFriendName'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LDRControl lDRControl = this.a;
        if (lDRControl == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        lDRControl.rvFriend = null;
        lDRControl.rvSelf = null;
        lDRControl.ivLdrControlStates = null;
        lDRControl.ldrSensitivity = null;
        lDRControl.ldrSensitivityLayout = null;
        lDRControl.ivLdrControl = null;
        lDRControl.tvLdrControl = null;
        lDRControl.tvFriendName = null;
    }
}
