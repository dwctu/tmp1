package com.wear.component.dxtoy.toy.update;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.util.TextOverlayImageView;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ToyUpgradeActivity_ViewBinding implements Unbinder {
    public ToyUpgradeActivity a;

    @UiThread
    public ToyUpgradeActivity_ViewBinding(ToyUpgradeActivity toyUpgradeActivity, View view) {
        this.a = toyUpgradeActivity;
        toyUpgradeActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyUpgradeActivity.toy_dfu_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_dfu_icon, "field 'toy_dfu_icon'", ImageView.class);
        toyUpgradeActivity.toy_upgrade_fail = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_upgrade_fail, "field 'toy_upgrade_fail'", ImageView.class);
        toyUpgradeActivity.lowBattery = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.low_battery, "field 'lowBattery'", LinearLayout.class);
        toyUpgradeActivity.lowBatteryUpdateBtn = (Button) Utils.findRequiredViewAsType(view, R.id.low_battery_update_btn, "field 'lowBatteryUpdateBtn'", Button.class);
        toyUpgradeActivity.lowBatteryOk = (Button) Utils.findRequiredViewAsType(view, R.id.low_battery_ok, "field 'lowBatteryOk'", Button.class);
        toyUpgradeActivity.updateBtn = (Button) Utils.findRequiredViewAsType(view, R.id.update_btn, "field 'updateBtn'", Button.class);
        toyUpgradeActivity.uploadingTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.uploading_title, "field 'uploadingTitle'", TextView.class);
        toyUpgradeActivity.progressbarUploading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressbar_uploading, "field 'progressbarUploading'", ProgressBar.class);
        toyUpgradeActivity.ll_dfu_toy_battery = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_dfu_toy_battery, "field 'll_dfu_toy_battery'", LinearLayout.class);
        toyUpgradeActivity.iv_dfu_toy_battery = (TextOverlayImageView) Utils.findRequiredViewAsType(view, R.id.iv_dfu_toy_battery, "field 'iv_dfu_toy_battery'", TextOverlayImageView.class);
        toyUpgradeActivity.tv_dfu_toy_battery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dfu_toy_battery, "field 'tv_dfu_toy_battery'", TextView.class);
        toyUpgradeActivity.toyUpdateNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_update_notice, "field 'toyUpdateNotice'", TextView.class);
        toyUpgradeActivity.tvUpgradeStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_upgrade_status, "field 'tvUpgradeStatus'", TextView.class);
        toyUpgradeActivity.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
        toyUpgradeActivity.tvUpdateTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_update_tip, "field 'tvUpdateTip'", TextView.class);
        toyUpgradeActivity.tvUpdateTipTake = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_update_tip_take, "field 'tvUpdateTipTake'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyUpgradeActivity toyUpgradeActivity = this.a;
        if (toyUpgradeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyUpgradeActivity.actionbar = null;
        toyUpgradeActivity.toy_dfu_icon = null;
        toyUpgradeActivity.toy_upgrade_fail = null;
        toyUpgradeActivity.lowBattery = null;
        toyUpgradeActivity.lowBatteryUpdateBtn = null;
        toyUpgradeActivity.lowBatteryOk = null;
        toyUpgradeActivity.updateBtn = null;
        toyUpgradeActivity.uploadingTitle = null;
        toyUpgradeActivity.progressbarUploading = null;
        toyUpgradeActivity.ll_dfu_toy_battery = null;
        toyUpgradeActivity.iv_dfu_toy_battery = null;
        toyUpgradeActivity.tv_dfu_toy_battery = null;
        toyUpgradeActivity.toyUpdateNotice = null;
        toyUpgradeActivity.tvUpgradeStatus = null;
        toyUpgradeActivity.toyName = null;
        toyUpgradeActivity.tvUpdateTip = null;
        toyUpgradeActivity.tvUpdateTipTake = null;
    }
}
