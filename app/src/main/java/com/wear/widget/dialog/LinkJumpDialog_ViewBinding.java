package com.wear.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class LinkJumpDialog_ViewBinding implements Unbinder {
    public LinkJumpDialog a;

    @UiThread
    public LinkJumpDialog_ViewBinding(LinkJumpDialog linkJumpDialog, View view) {
        this.a = linkJumpDialog;
        linkJumpDialog.link = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.link, "field 'link'", AppCompatTextView.class);
        linkJumpDialog.confirmButton = (AppCompatButton) Utils.findRequiredViewAsType(view, R.id.confirm_button, "field 'confirmButton'", AppCompatButton.class);
        linkJumpDialog.cancelButton = (AppCompatButton) Utils.findRequiredViewAsType(view, R.id.cancel_button, "field 'cancelButton'", AppCompatButton.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LinkJumpDialog linkJumpDialog = this.a;
        if (linkJumpDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        linkJumpDialog.link = null;
        linkJumpDialog.confirmButton = null;
        linkJumpDialog.cancelButton = null;
    }
}
