package com.wear.main.closeRange;

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
public class RemoteMultiControlActivity_ViewBinding implements Unbinder {
    public RemoteMultiControlActivity a;

    @UiThread
    public RemoteMultiControlActivity_ViewBinding(RemoteMultiControlActivity remoteMultiControlActivity, View view) {
        this.a = remoteMultiControlActivity;
        remoteMultiControlActivity.bar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'bar'", MyActionBar.class);
        remoteMultiControlActivity.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_panel, "field 'multiControlPanel'", MultiControlPanel.class);
        remoteMultiControlActivity.velvoPreviewView = (VelvoPreviewView) Utils.findRequiredViewAsType(view, R.id.velvo_preview, "field 'velvoPreviewView'", VelvoPreviewView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RemoteMultiControlActivity remoteMultiControlActivity = this.a;
        if (remoteMultiControlActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        remoteMultiControlActivity.bar = null;
        remoteMultiControlActivity.multiControlPanel = null;
        remoteMultiControlActivity.velvoPreviewView = null;
    }
}
