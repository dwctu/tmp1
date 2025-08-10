package com.wear.main.patterns;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.velvo.VelvoPreviewView;

/* loaded from: classes3.dex */
public class CreatePatternActivity_ViewBinding implements Unbinder {
    public CreatePatternActivity a;

    @UiThread
    public CreatePatternActivity_ViewBinding(CreatePatternActivity createPatternActivity, View view) {
        this.a = createPatternActivity;
        createPatternActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        createPatternActivity.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_panel, "field 'multiControlPanel'", MultiControlPanel.class);
        createPatternActivity.velvoPreviewView = (VelvoPreviewView) Utils.findRequiredViewAsType(view, R.id.velvo_preview, "field 'velvoPreviewView'", VelvoPreviewView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreatePatternActivity createPatternActivity = this.a;
        if (createPatternActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        createPatternActivity.actionbar = null;
        createPatternActivity.multiControlPanel = null;
        createPatternActivity.velvoPreviewView = null;
    }
}
