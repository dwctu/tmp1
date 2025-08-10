package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class NewUserVerifyDialog_ViewBinding implements Unbinder {
    public NewUserVerifyDialog a;

    @UiThread
    public NewUserVerifyDialog_ViewBinding(NewUserVerifyDialog newUserVerifyDialog, View view) {
        this.a = newUserVerifyDialog;
        newUserVerifyDialog.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        newUserVerifyDialog.tvStep = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_step, "field 'tvStep'", TextView.class);
        newUserVerifyDialog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        newUserVerifyDialog.tvSkip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_skip, "field 'tvSkip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewUserVerifyDialog newUserVerifyDialog = this.a;
        if (newUserVerifyDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newUserVerifyDialog.tvTip = null;
        newUserVerifyDialog.tvStep = null;
        newUserVerifyDialog.tvConfirm = null;
        newUserVerifyDialog.tvSkip = null;
    }
}
