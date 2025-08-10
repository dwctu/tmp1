package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class VideoPatternConnectToyDialog_ViewBinding implements Unbinder {
    public VideoPatternConnectToyDialog a;

    @UiThread
    public VideoPatternConnectToyDialog_ViewBinding(VideoPatternConnectToyDialog videoPatternConnectToyDialog, View view) {
        this.a = videoPatternConnectToyDialog;
        videoPatternConnectToyDialog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        videoPatternConnectToyDialog.buyToys = (TextView) Utils.findRequiredViewAsType(view, R.id.buy_toys, "field 'buyToys'", TextView.class);
        videoPatternConnectToyDialog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        videoPatternConnectToyDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoPatternConnectToyDialog videoPatternConnectToyDialog = this.a;
        if (videoPatternConnectToyDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoPatternConnectToyDialog.tvText = null;
        videoPatternConnectToyDialog.buyToys = null;
        videoPatternConnectToyDialog.tvConfirm = null;
        videoPatternConnectToyDialog.tvCancel = null;
    }
}
