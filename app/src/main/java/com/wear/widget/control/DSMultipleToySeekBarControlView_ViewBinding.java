package com.wear.widget.control;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class DSMultipleToySeekBarControlView_ViewBinding implements Unbinder {
    public DSMultipleToySeekBarControlView a;

    @UiThread
    public DSMultipleToySeekBarControlView_ViewBinding(DSMultipleToySeekBarControlView dSMultipleToySeekBarControlView, View view) {
        this.a = dSMultipleToySeekBarControlView;
        dSMultipleToySeekBarControlView.vseekBarLeft = (VSeekBarView) Utils.findRequiredViewAsType(view, R.id.vseekBar_left, "field 'vseekBarLeft'", VSeekBarView.class);
        dSMultipleToySeekBarControlView.vseekBarLeftLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.vseekBar_left_layout, "field 'vseekBarLeftLayout'", RelativeLayout.class);
        dSMultipleToySeekBarControlView.vseekBarRight = (VSeekBarView) Utils.findRequiredViewAsType(view, R.id.vseekBar_right, "field 'vseekBarRight'", VSeekBarView.class);
        dSMultipleToySeekBarControlView.vseekBarRightLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.vseekBar_right_layout, "field 'vseekBarRightLayout'", RelativeLayout.class);
        dSMultipleToySeekBarControlView.vseekBarExpansion = (VSeekBarView) Utils.findRequiredViewAsType(view, R.id.vseekBar_expansion, "field 'vseekBarExpansion'", VSeekBarView.class);
        dSMultipleToySeekBarControlView.vseekBarExpansionLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.vseekBar_expansion_layout, "field 'vseekBarExpansionLayout'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DSMultipleToySeekBarControlView dSMultipleToySeekBarControlView = this.a;
        if (dSMultipleToySeekBarControlView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        dSMultipleToySeekBarControlView.vseekBarLeft = null;
        dSMultipleToySeekBarControlView.vseekBarLeftLayout = null;
        dSMultipleToySeekBarControlView.vseekBarRight = null;
        dSMultipleToySeekBarControlView.vseekBarRightLayout = null;
        dSMultipleToySeekBarControlView.vseekBarExpansion = null;
        dSMultipleToySeekBarControlView.vseekBarExpansionLayout = null;
    }
}
