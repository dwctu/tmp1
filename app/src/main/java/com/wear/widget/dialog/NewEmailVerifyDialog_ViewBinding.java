package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class NewEmailVerifyDialog_ViewBinding implements Unbinder {
    public NewEmailVerifyDialog a;

    @UiThread
    public NewEmailVerifyDialog_ViewBinding(NewEmailVerifyDialog newEmailVerifyDialog, View view) {
        this.a = newEmailVerifyDialog;
        newEmailVerifyDialog.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        newEmailVerifyDialog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        newEmailVerifyDialog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        newEmailVerifyDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        newEmailVerifyDialog.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewEmailVerifyDialog newEmailVerifyDialog = this.a;
        if (newEmailVerifyDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newEmailVerifyDialog.tvTitle = null;
        newEmailVerifyDialog.tvText = null;
        newEmailVerifyDialog.tvConfirm = null;
        newEmailVerifyDialog.tvCancel = null;
        newEmailVerifyDialog.tvTip = null;
    }
}
