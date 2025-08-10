package com.wear.widget.control.multiToys;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Guideline;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.llong.sliding.SlidingUpPanelLayout;

/* loaded from: classes4.dex */
public class MultiControlPanel_ViewBinding implements Unbinder {
    public MultiControlPanel a;

    @UiThread
    public MultiControlPanel_ViewBinding(MultiControlPanel multiControlPanel, View view) {
        this.a = multiControlPanel;
        multiControlPanel.multiToysCurvePanel = (MultiToysCurvePanel) Utils.findRequiredViewAsType(view, R.id.multi_toys_curve_panel, "field 'multiToysCurvePanel'", MultiToysCurvePanel.class);
        multiControlPanel.slidingPaneLayout = (SlidingUpPanelLayout) Utils.findRequiredViewAsType(view, R.id.multi_ball_slidingpanelayout, "field 'slidingPaneLayout'", SlidingUpPanelLayout.class);
        multiControlPanel.multiBallSelectPanel = (MultiBallSelectPanel) Utils.findRequiredViewAsType(view, R.id.multi_ball_select_panel, "field 'multiBallSelectPanel'", MultiBallSelectPanel.class);
        multiControlPanel.multiBallControlPanel = (MultiBallControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_ball_control_panel, "field 'multiBallControlPanel'", MultiBallControlPanel.class);
        multiControlPanel.guideline = (Guideline) Utils.findRequiredViewAsType(view, R.id.multi_ball_control_guideline3, "field 'guideline'", Guideline.class);
        multiControlPanel.divider = Utils.findRequiredView(view, R.id.divider, "field 'divider'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MultiControlPanel multiControlPanel = this.a;
        if (multiControlPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        multiControlPanel.multiToysCurvePanel = null;
        multiControlPanel.slidingPaneLayout = null;
        multiControlPanel.multiBallSelectPanel = null;
        multiControlPanel.multiBallControlPanel = null;
        multiControlPanel.guideline = null;
        multiControlPanel.divider = null;
    }
}
