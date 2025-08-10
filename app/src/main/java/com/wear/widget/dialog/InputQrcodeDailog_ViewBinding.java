package com.wear.widget.dialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class InputQrcodeDailog_ViewBinding implements Unbinder {
    public InputQrcodeDailog a;

    @UiThread
    public InputQrcodeDailog_ViewBinding(InputQrcodeDailog inputQrcodeDailog, View view) {
        this.a = inputQrcodeDailog;
        inputQrcodeDailog.etText = (EditText) Utils.findRequiredViewAsType(view, R.id.et_text, "field 'etText'", EditText.class);
        inputQrcodeDailog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        InputQrcodeDailog inputQrcodeDailog = this.a;
        if (inputQrcodeDailog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        inputQrcodeDailog.etText = null;
        inputQrcodeDailog.tvConfirm = null;
    }
}
