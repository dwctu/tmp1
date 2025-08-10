package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ToyPinOnDialog_ViewBinding implements Unbinder {
    public ToyPinOnDialog a;

    @UiThread
    public ToyPinOnDialog_ViewBinding(ToyPinOnDialog toyPinOnDialog, View view) {
        this.a = toyPinOnDialog;
        toyPinOnDialog.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        toyPinOnDialog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        toyPinOnDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        toyPinOnDialog.tvConfirmTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm_time, "field 'tvConfirmTime'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyPinOnDialog toyPinOnDialog = this.a;
        if (toyPinOnDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyPinOnDialog.tvTitle = null;
        toyPinOnDialog.tvText = null;
        toyPinOnDialog.tvCancel = null;
        toyPinOnDialog.tvConfirmTime = null;
    }
}
