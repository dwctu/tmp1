package com.wear.main.toy;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class SexMachineUpliftActivity_ViewBinding implements Unbinder {
    public SexMachineUpliftActivity a;

    @UiThread
    public SexMachineUpliftActivity_ViewBinding(SexMachineUpliftActivity sexMachineUpliftActivity, View view) {
        this.a = sexMachineUpliftActivity;
        sexMachineUpliftActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        sexMachineUpliftActivity.switchButton = (SwitchView) Utils.findRequiredViewAsType(view, R.id.switchButton, "field 'switchButton'", SwitchView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SexMachineUpliftActivity sexMachineUpliftActivity = this.a;
        if (sexMachineUpliftActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        sexMachineUpliftActivity.actionbar = null;
        sexMachineUpliftActivity.switchButton = null;
    }
}
