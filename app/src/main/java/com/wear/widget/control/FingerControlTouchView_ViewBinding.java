package com.wear.widget.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class FingerControlTouchView_ViewBinding implements Unbinder {
    public FingerControlTouchView a;

    @UiThread
    public FingerControlTouchView_ViewBinding(FingerControlTouchView fingerControlTouchView, View view) {
        this.a = fingerControlTouchView;
        fingerControlTouchView.ivOne = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_one, "field 'ivOne'", ImageView.class);
        fingerControlTouchView.ivTwo = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_two, "field 'ivTwo'", ImageView.class);
        fingerControlTouchView.ivThree = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_three, "field 'ivThree'", ImageView.class);
        fingerControlTouchView.vOneLine = Utils.findRequiredView(view, R.id.v_one_line, "field 'vOneLine'");
        fingerControlTouchView.vTwoLine = Utils.findRequiredView(view, R.id.v_two_line, "field 'vTwoLine'");
        fingerControlTouchView.vThreeLine = Utils.findRequiredView(view, R.id.v_three_line, "field 'vThreeLine'");
        fingerControlTouchView.vbOneVseek = (TraditionalSeekBarView) Utils.findRequiredViewAsType(view, R.id.vb_one_vseek, "field 'vbOneVseek'", TraditionalSeekBarView.class);
        fingerControlTouchView.vbTwoVseek = (TraditionalSeekBarView) Utils.findRequiredViewAsType(view, R.id.vb_two_vseek, "field 'vbTwoVseek'", TraditionalSeekBarView.class);
        fingerControlTouchView.vbThreeVseek = (TraditionalSeekBarView) Utils.findRequiredViewAsType(view, R.id.vb_three_vseek, "field 'vbThreeVseek'", TraditionalSeekBarView.class);
        fingerControlTouchView.llTraditional = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_traditional, "field 'llTraditional'", LinearLayout.class);
        fingerControlTouchView.rlOne = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_one, "field 'rlOne'", RelativeLayout.class);
        fingerControlTouchView.rlTwo = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_two, "field 'rlTwo'", RelativeLayout.class);
        fingerControlTouchView.rlThree = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_three, "field 'rlThree'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FingerControlTouchView fingerControlTouchView = this.a;
        if (fingerControlTouchView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fingerControlTouchView.ivOne = null;
        fingerControlTouchView.ivTwo = null;
        fingerControlTouchView.ivThree = null;
        fingerControlTouchView.vOneLine = null;
        fingerControlTouchView.vTwoLine = null;
        fingerControlTouchView.vThreeLine = null;
        fingerControlTouchView.vbOneVseek = null;
        fingerControlTouchView.vbTwoVseek = null;
        fingerControlTouchView.vbThreeVseek = null;
        fingerControlTouchView.llTraditional = null;
        fingerControlTouchView.rlOne = null;
        fingerControlTouchView.rlTwo = null;
        fingerControlTouchView.rlThree = null;
    }
}
