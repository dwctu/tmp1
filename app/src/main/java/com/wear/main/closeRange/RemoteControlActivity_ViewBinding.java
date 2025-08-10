package com.wear.main.closeRange;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.control.CurveLineTimeView;
import com.wear.widget.control.MultipleControlLayout;

/* loaded from: classes3.dex */
public class RemoteControlActivity_ViewBinding implements Unbinder {
    public RemoteControlActivity a;

    @UiThread
    public RemoteControlActivity_ViewBinding(RemoteControlActivity remoteControlActivity, View view) {
        this.a = remoteControlActivity;
        remoteControlActivity.curveTopSpace = Utils.findRequiredView(view, R.id.curveTopSpace, "field 'curveTopSpace'");
        remoteControlActivity.curveBottomSpace = Utils.findRequiredView(view, R.id.curveBottomSpace, "field 'curveBottomSpace'");
        remoteControlActivity.curveTimeLine = (CurveLineTimeView) Utils.findRequiredViewAsType(view, R.id.curveTimeLine, "field 'curveTimeLine'", CurveLineTimeView.class);
        remoteControlActivity.curveLayout2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.curveLayout2, "field 'curveLayout2'", LinearLayout.class);
        remoteControlActivity.curveTimeLine2 = (CurveLineTimeView) Utils.findRequiredViewAsType(view, R.id.curveTimeLine2, "field 'curveTimeLine2'", CurveLineTimeView.class);
        remoteControlActivity.multiControl = (MultipleControlLayout) Utils.findRequiredViewAsType(view, R.id.multiControl, "field 'multiControl'", MultipleControlLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RemoteControlActivity remoteControlActivity = this.a;
        if (remoteControlActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        remoteControlActivity.curveTopSpace = null;
        remoteControlActivity.curveBottomSpace = null;
        remoteControlActivity.curveTimeLine = null;
        remoteControlActivity.curveLayout2 = null;
        remoteControlActivity.curveTimeLine2 = null;
        remoteControlActivity.multiControl = null;
    }
}
