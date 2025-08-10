package com.wear.main.toy;

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
public class ToyDfuActivity_ViewBinding implements Unbinder {
    public ToyDfuActivity a;

    @UiThread
    public ToyDfuActivity_ViewBinding(ToyDfuActivity toyDfuActivity, View view) {
        this.a = toyDfuActivity;
        toyDfuActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyDfuActivity.toy_dfu_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_dfu_icon, "field 'toy_dfu_icon'", ImageView.class);
        toyDfuActivity.toy_upgrade_fail = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_upgrade_fail, "field 'toy_upgrade_fail'", ImageView.class);
        toyDfuActivity.lowBattery = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.low_battery, "field 'lowBattery'", LinearLayout.class);
        toyDfuActivity.lowBatteryUpdateBtn = (Button) Utils.findRequiredViewAsType(view, R.id.low_battery_update_btn, "field 'lowBatteryUpdateBtn'", Button.class);
        toyDfuActivity.lowBatteryOk = (Button) Utils.findRequiredViewAsType(view, R.id.low_battery_ok, "field 'lowBatteryOk'", Button.class);
        toyDfuActivity.updateBtn = (Button) Utils.findRequiredViewAsType(view, R.id.update_btn, "field 'updateBtn'", Button.class);
        toyDfuActivity.uploadingTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.uploading_title, "field 'uploadingTitle'", TextView.class);
        toyDfuActivity.progressbarUploading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressbar_uploading, "field 'progressbarUploading'", ProgressBar.class);
        toyDfuActivity.ll_dfu_toy_battery = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_dfu_toy_battery, "field 'll_dfu_toy_battery'", LinearLayout.class);
        toyDfuActivity.iv_dfu_toy_battery = (TextOverlayImageView) Utils.findRequiredViewAsType(view, R.id.iv_dfu_toy_battery, "field 'iv_dfu_toy_battery'", TextOverlayImageView.class);
        toyDfuActivity.tv_dfu_toy_battery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dfu_toy_battery, "field 'tv_dfu_toy_battery'", TextView.class);
        toyDfuActivity.toyUpdateNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_update_notice, "field 'toyUpdateNotice'", TextView.class);
        toyDfuActivity.tvUpgradeStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_upgrade_status, "field 'tvUpgradeStatus'", TextView.class);
        toyDfuActivity.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_up_case_name, "field 'toyName'", TextView.class);
        toyDfuActivity.tvUpdateTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_update_tip, "field 'tvUpdateTip'", TextView.class);
        toyDfuActivity.tvUpdateTipTake = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_update_tip_take, "field 'tvUpdateTipTake'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyDfuActivity toyDfuActivity = this.a;
        if (toyDfuActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyDfuActivity.actionbar = null;
        toyDfuActivity.toy_dfu_icon = null;
        toyDfuActivity.toy_upgrade_fail = null;
        toyDfuActivity.lowBattery = null;
        toyDfuActivity.lowBatteryUpdateBtn = null;
        toyDfuActivity.lowBatteryOk = null;
        toyDfuActivity.updateBtn = null;
        toyDfuActivity.uploadingTitle = null;
        toyDfuActivity.progressbarUploading = null;
        toyDfuActivity.ll_dfu_toy_battery = null;
        toyDfuActivity.iv_dfu_toy_battery = null;
        toyDfuActivity.tv_dfu_toy_battery = null;
        toyDfuActivity.toyUpdateNotice = null;
        toyDfuActivity.tvUpgradeStatus = null;
        toyDfuActivity.toyName = null;
        toyDfuActivity.tvUpdateTip = null;
        toyDfuActivity.tvUpdateTipTake = null;
    }
}
