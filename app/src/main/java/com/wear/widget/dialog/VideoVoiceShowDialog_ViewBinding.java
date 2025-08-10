package com.wear.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class VideoVoiceShowDialog_ViewBinding implements Unbinder {
    public VideoVoiceShowDialog a;

    @UiThread
    public VideoVoiceShowDialog_ViewBinding(VideoVoiceShowDialog videoVoiceShowDialog, View view) {
        this.a = videoVoiceShowDialog;
        videoVoiceShowDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoVoiceShowDialog videoVoiceShowDialog = this.a;
        if (videoVoiceShowDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoVoiceShowDialog.flRootView = null;
    }
}
