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
public class ToyPinRemoveFailTipActivity_ViewBinding implements Unbinder {
    public ToyPinRemoveFailTipActivity a;

    @UiThread
    public ToyPinRemoveFailTipActivity_ViewBinding(ToyPinRemoveFailTipActivity toyPinRemoveFailTipActivity, View view) {
        this.a = toyPinRemoveFailTipActivity;
        toyPinRemoveFailTipActivity.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        toyPinRemoveFailTipActivity.toyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_icon, "field 'toyIcon'", ImageView.class);
        toyPinRemoveFailTipActivity.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
        toyPinRemoveFailTipActivity.toyPinTipText1 = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_text_1, "field 'toyPinTipText1'", TextView.class);
        toyPinRemoveFailTipActivity.toyPinTipView = Utils.findRequiredView(view, R.id.toy_pin_tip_view, "field 'toyPinTipView'");
        toyPinRemoveFailTipActivity.tip1Ok = (TextView) Utils.findRequiredViewAsType(view, R.id.tip_1_ok, "field 'tip1Ok'", TextView.class);
        toyPinRemoveFailTipActivity.toyPinTip1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.toy_pin_tip_1, "field 'toyPinTip1'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyPinRemoveFailTipActivity toyPinRemoveFailTipActivity = this.a;
        if (toyPinRemoveFailTipActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyPinRemoveFailTipActivity.ivClose = null;
        toyPinRemoveFailTipActivity.toyIcon = null;
        toyPinRemoveFailTipActivity.toyName = null;
        toyPinRemoveFailTipActivity.toyPinTipText1 = null;
        toyPinRemoveFailTipActivity.toyPinTipView = null;
        toyPinRemoveFailTipActivity.tip1Ok = null;
        toyPinRemoveFailTipActivity.toyPinTip1 = null;
    }
}
