package com.wear.main.longDistance.controllink;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class CreateControlLinkActivity_ViewBinding implements Unbinder {
    public CreateControlLinkActivity a;

    @UiThread
    public CreateControlLinkActivity_ViewBinding(CreateControlLinkActivity createControlLinkActivity, View view) {
        this.a = createControlLinkActivity;
        createControlLinkActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        createControlLinkActivity.repeat = (TextView) Utils.findRequiredViewAsType(view, R.id.repeat, "field 'repeat'", TextView.class);
        createControlLinkActivity.switchButton = (SwitchView) Utils.findRequiredViewAsType(view, R.id.switchButton, "field 'switchButton'", SwitchView.class);
        createControlLinkActivity.mSwiSharePublic = (SwitchView) Utils.findRequiredViewAsType(view, R.id.swi_share_public, "field 'mSwiSharePublic'", SwitchView.class);
        createControlLinkActivity.enterToys = (ImageView) Utils.findRequiredViewAsType(view, R.id.enter_toys, "field 'enterToys'", ImageView.class);
        createControlLinkActivity.toyNames = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_names, "field 'toyNames'", TextView.class);
        createControlLinkActivity.enterDuration = (ImageView) Utils.findRequiredViewAsType(view, R.id.enter_duration, "field 'enterDuration'", ImageView.class);
        createControlLinkActivity.durationTime = (TextView) Utils.findRequiredViewAsType(view, R.id.durationTime, "field 'durationTime'", TextView.class);
        createControlLinkActivity.enterDes = (ImageView) Utils.findRequiredViewAsType(view, R.id.enter_des, "field 'enterDes'", ImageView.class);
        createControlLinkActivity.description = (TextView) Utils.findRequiredViewAsType(view, R.id.description, "field 'description'", TextView.class);
        createControlLinkActivity.save = (TextView) Utils.findRequiredViewAsType(view, R.id.save, "field 'save'", TextView.class);
        createControlLinkActivity.toysLinear = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.toysLinear, "field 'toysLinear'", RelativeLayout.class);
        createControlLinkActivity.durationLinear = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.durationLinear, "field 'durationLinear'", RelativeLayout.class);
        createControlLinkActivity.descriptionLinear = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.descriptionLinear, "field 'descriptionLinear'", RelativeLayout.class);
        createControlLinkActivity.tags = (TextView) Utils.findRequiredViewAsType(view, R.id.tags, "field 'tags'", TextView.class);
        createControlLinkActivity.mTvShareDescription = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_description, "field 'mTvShareDescription'", TextView.class);
        createControlLinkActivity.tvPermissionRed = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_permission_red, "field 'tvPermissionRed'", TextView.class);
        createControlLinkActivity.controlLinkPermission = (SwitchView) Utils.findRequiredViewAsType(view, R.id.control_link_permission, "field 'controlLinkPermission'", SwitchView.class);
        createControlLinkActivity.schSendToTheOther = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sch_send_to_the_other, "field 'schSendToTheOther'", SwitchView.class);
        createControlLinkActivity.schReceiveFromTheOther = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sch_receive_from_the_other, "field 'schReceiveFromTheOther'", SwitchView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreateControlLinkActivity createControlLinkActivity = this.a;
        if (createControlLinkActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        createControlLinkActivity.actionBar = null;
        createControlLinkActivity.repeat = null;
        createControlLinkActivity.switchButton = null;
        createControlLinkActivity.mSwiSharePublic = null;
        createControlLinkActivity.enterToys = null;
        createControlLinkActivity.toyNames = null;
        createControlLinkActivity.enterDuration = null;
        createControlLinkActivity.durationTime = null;
        createControlLinkActivity.enterDes = null;
        createControlLinkActivity.description = null;
        createControlLinkActivity.save = null;
        createControlLinkActivity.toysLinear = null;
        createControlLinkActivity.durationLinear = null;
        createControlLinkActivity.descriptionLinear = null;
        createControlLinkActivity.tags = null;
        createControlLinkActivity.mTvShareDescription = null;
        createControlLinkActivity.tvPermissionRed = null;
        createControlLinkActivity.controlLinkPermission = null;
        createControlLinkActivity.schSendToTheOther = null;
        createControlLinkActivity.schReceiveFromTheOther = null;
    }
}
