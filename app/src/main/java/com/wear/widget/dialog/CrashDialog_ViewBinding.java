package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class CrashDialog_ViewBinding implements Unbinder {
    public CrashDialog a;

    @UiThread
    public CrashDialog_ViewBinding(CrashDialog crashDialog, View view) {
        this.a = crashDialog;
        crashDialog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CrashDialog crashDialog = this.a;
        if (crashDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        crashDialog.tvText = null;
    }
}
