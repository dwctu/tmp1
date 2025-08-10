package com.wear.widget.control.multiToys;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.FadingRecyclerView;
import com.wear.widget.llong.MyStrengthControlViewL;

/* loaded from: classes4.dex */
public class MultiFysControlPanel_ViewBinding implements Unbinder {
    public MultiFysControlPanel a;

    @UiThread
    public MultiFysControlPanel_ViewBinding(MultiFysControlPanel multiFysControlPanel, View view) {
        this.a = multiFysControlPanel;
        multiFysControlPanel.sensitivityProgress = (MyStrengthControlViewL) Utils.findRequiredViewAsType(view, R.id.sensitivity_progress, "field 'sensitivityProgress'", MyStrengthControlViewL.class);
        multiFysControlPanel.bottomLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.bottom_layout, "field 'bottomLayout'", ConstraintLayout.class);
        multiFysControlPanel.toyRecyclerview = (FadingRecyclerView) Utils.findRequiredViewAsType(view, R.id.toy_recyclerview, "field 'toyRecyclerview'", FadingRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MultiFysControlPanel multiFysControlPanel = this.a;
        if (multiFysControlPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        multiFysControlPanel.sensitivityProgress = null;
        multiFysControlPanel.bottomLayout = null;
        multiFysControlPanel.toyRecyclerview = null;
    }
}
