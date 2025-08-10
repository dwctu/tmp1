package com.wear.main.longDistance.controllink;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ControlLinkNewActivity_ViewBinding implements Unbinder {
    public ControlLinkNewActivity a;

    @UiThread
    public ControlLinkNewActivity_ViewBinding(ControlLinkNewActivity controlLinkNewActivity, View view) {
        this.a = controlLinkNewActivity;
        controlLinkNewActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        controlLinkNewActivity.btnCreateControlLink = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.btn_create_control_link, "field 'btnCreateControlLink'", LinearLayout.class);
        controlLinkNewActivity.allType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_type, "field 'allType'", LinearLayout.class);
        controlLinkNewActivity.activeType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.active_type, "field 'activeType'", LinearLayout.class);
        controlLinkNewActivity.waitingType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.waiting_type, "field 'waitingType'", LinearLayout.class);
        controlLinkNewActivity.expiredType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expired_type, "field 'expiredType'", LinearLayout.class);
        controlLinkNewActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        controlLinkNewActivity.smartRefresh = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.smartRefresh, "field 'smartRefresh'", SmartRefreshLayout.class);
        controlLinkNewActivity.verticalLine = (ImageView) Utils.findRequiredViewAsType(view, R.id.vertical_line, "field 'verticalLine'", ImageView.class);
        controlLinkNewActivity.deleteAll = (TextView) Utils.findRequiredViewAsType(view, R.id.deleteAll, "field 'deleteAll'", TextView.class);
        controlLinkNewActivity.tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tips, "field 'tips'", TextView.class);
        controlLinkNewActivity.allTypeText = (TextView) Utils.findRequiredViewAsType(view, R.id.all_type_text, "field 'allTypeText'", TextView.class);
        controlLinkNewActivity.activeTypeText = (TextView) Utils.findRequiredViewAsType(view, R.id.active_type_text, "field 'activeTypeText'", TextView.class);
        controlLinkNewActivity.waitingTypeText = (TextView) Utils.findRequiredViewAsType(view, R.id.waiting_type_text, "field 'waitingTypeText'", TextView.class);
        controlLinkNewActivity.expiredTypeText = (TextView) Utils.findRequiredViewAsType(view, R.id.expired_type_text, "field 'expiredTypeText'", TextView.class);
        controlLinkNewActivity.createButton = (TextView) Utils.findRequiredViewAsType(view, R.id.createButton, "field 'createButton'", TextView.class);
        controlLinkNewActivity.noControlLinkLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.noControlLinkLayout, "field 'noControlLinkLayout'", ConstraintLayout.class);
        controlLinkNewActivity.typeConstrain = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.type_constrain, "field 'typeConstrain'", ConstraintLayout.class);
        controlLinkNewActivity.mViewRedDot = Utils.findRequiredView(view, R.id.view_red_dot, "field 'mViewRedDot'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkNewActivity controlLinkNewActivity = this.a;
        if (controlLinkNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkNewActivity.actionbar = null;
        controlLinkNewActivity.btnCreateControlLink = null;
        controlLinkNewActivity.allType = null;
        controlLinkNewActivity.activeType = null;
        controlLinkNewActivity.waitingType = null;
        controlLinkNewActivity.expiredType = null;
        controlLinkNewActivity.recyclerView = null;
        controlLinkNewActivity.smartRefresh = null;
        controlLinkNewActivity.verticalLine = null;
        controlLinkNewActivity.deleteAll = null;
        controlLinkNewActivity.tips = null;
        controlLinkNewActivity.allTypeText = null;
        controlLinkNewActivity.activeTypeText = null;
        controlLinkNewActivity.waitingTypeText = null;
        controlLinkNewActivity.expiredTypeText = null;
        controlLinkNewActivity.createButton = null;
        controlLinkNewActivity.noControlLinkLayout = null;
        controlLinkNewActivity.typeConstrain = null;
        controlLinkNewActivity.mViewRedDot = null;
    }
}
