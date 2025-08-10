package com.wear.main.toy.pin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ToyPinTipActivity_ViewBinding implements Unbinder {
    public ToyPinTipActivity a;

    @UiThread
    public ToyPinTipActivity_ViewBinding(ToyPinTipActivity toyPinTipActivity, View view) {
        this.a = toyPinTipActivity;
        toyPinTipActivity.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        toyPinTipActivity.toyPinTipText1 = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_text_1, "field 'toyPinTipText1'", TextView.class);
        toyPinTipActivity.toyPinTipView = Utils.findRequiredView(view, R.id.toy_pin_tip_view, "field 'toyPinTipView'");
        toyPinTipActivity.tip1Ok = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_1_ok, "field 'tip1Ok'", TextView.class);
        toyPinTipActivity.toyPinTipText2 = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_text_2, "field 'toyPinTipText2'", TextView.class);
        toyPinTipActivity.tip2Connect = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_2_connect, "field 'tip2Connect'", TextView.class);
        toyPinTipActivity.toyPinTip2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_2, "field 'toyPinTip2'", LinearLayout.class);
        toyPinTipActivity.toyPinTipText3 = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_text_3, "field 'toyPinTipText3'", TextView.class);
        toyPinTipActivity.tip3Connecting = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_3_connecting, "field 'tip3Connecting'", TextView.class);
        toyPinTipActivity.toyPinTip3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_3, "field 'toyPinTip3'", LinearLayout.class);
        toyPinTipActivity.tip4Reseted = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_4_reseted, "field 'tip4Reseted'", TextView.class);
        toyPinTipActivity.tip4ConnectAgain = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_4_connect_again, "field 'tip4ConnectAgain'", TextView.class);
        toyPinTipActivity.toyPinTip4 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_4, "field 'toyPinTip4'", LinearLayout.class);
        toyPinTipActivity.toyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_icon, "field 'toyIcon'", ImageView.class);
        toyPinTipActivity.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
        toyPinTipActivity.toyTip3ConnectStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_tip_3_connect_status, "field 'toyTip3ConnectStatus'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyPinTipActivity toyPinTipActivity = this.a;
        if (toyPinTipActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyPinTipActivity.ivClose = null;
        toyPinTipActivity.toyPinTipText1 = null;
        toyPinTipActivity.toyPinTipView = null;
        toyPinTipActivity.tip1Ok = null;
        toyPinTipActivity.toyPinTipText2 = null;
        toyPinTipActivity.tip2Connect = null;
        toyPinTipActivity.toyPinTip2 = null;
        toyPinTipActivity.toyPinTipText3 = null;
        toyPinTipActivity.tip3Connecting = null;
        toyPinTipActivity.toyPinTip3 = null;
        toyPinTipActivity.tip4Reseted = null;
        toyPinTipActivity.tip4ConnectAgain = null;
        toyPinTipActivity.toyPinTip4 = null;
        toyPinTipActivity.toyIcon = null;
        toyPinTipActivity.toyName = null;
        toyPinTipActivity.toyTip3ConnectStatus = null;
    }
}
