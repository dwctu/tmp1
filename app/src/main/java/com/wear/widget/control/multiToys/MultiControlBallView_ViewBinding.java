package com.wear.widget.control.multiToys;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class MultiControlBallView_ViewBinding implements Unbinder {
    public MultiControlBallView a;

    @UiThread
    public MultiControlBallView_ViewBinding(MultiControlBallView multiControlBallView, View view) {
        this.a = multiControlBallView;
        multiControlBallView.llBall = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_ball, "field 'llBall'", LinearLayout.class);
        multiControlBallView.clMergeBall = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_merge_ball, "field 'clMergeBall'", ConstraintLayout.class);
        multiControlBallView.tvName = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", AppCompatTextView.class);
        multiControlBallView.ivFunction = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_function, "field 'ivFunction'", ImageView.class);
        multiControlBallView.ivActivate = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_activate, "field 'ivActivate'", ImageView.class);
        multiControlBallView.ivControlMode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode, "field 'ivControlMode'", ImageView.class);
        multiControlBallView.ivCrossBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_cross_bg, "field 'ivCrossBg'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MultiControlBallView multiControlBallView = this.a;
        if (multiControlBallView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        multiControlBallView.llBall = null;
        multiControlBallView.clMergeBall = null;
        multiControlBallView.tvName = null;
        multiControlBallView.ivFunction = null;
        multiControlBallView.ivActivate = null;
        multiControlBallView.ivControlMode = null;
        multiControlBallView.ivCrossBg = null;
    }
}
