package com.wear.main.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.CurveLineTimeView;
import com.wear.widget.control.TouchControlVerticalBarView;
import com.wear.widget.control.TouchControlView;

/* loaded from: classes3.dex */
public class RecordSendPatternActivity_ViewBinding implements Unbinder {
    public RecordSendPatternActivity a;

    @UiThread
    public RecordSendPatternActivity_ViewBinding(RecordSendPatternActivity recordSendPatternActivity, View view) {
        this.a = recordSendPatternActivity;
        recordSendPatternActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        recordSendPatternActivity.curveTimeLine = (CurveLineTimeView) Utils.findRequiredViewAsType(view, R.id.curveTimeLine, "field 'curveTimeLine'", CurveLineTimeView.class);
        recordSendPatternActivity.touchView = (TouchControlView) Utils.findRequiredViewAsType(view, R.id.touchView, "field 'touchView'", TouchControlView.class);
        recordSendPatternActivity.touchViewControl = (TouchControlVerticalBarView) Utils.findRequiredViewAsType(view, R.id.touchViewControl, "field 'touchViewControl'", TouchControlVerticalBarView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordSendPatternActivity recordSendPatternActivity = this.a;
        if (recordSendPatternActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        recordSendPatternActivity.actionbar = null;
        recordSendPatternActivity.curveTimeLine = null;
        recordSendPatternActivity.touchView = null;
        recordSendPatternActivity.touchViewControl = null;
    }
}
