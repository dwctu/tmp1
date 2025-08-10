package com.wear.widget.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;

/* loaded from: classes4.dex */
public class NewToyGuideDialog_ViewBinding implements Unbinder {
    public NewToyGuideDialog a;

    @UiThread
    public NewToyGuideDialog_ViewBinding(NewToyGuideDialog newToyGuideDialog, View view) {
        this.a = newToyGuideDialog;
        newToyGuideDialog.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        newToyGuideDialog.videoPlayer = (MyVideoView) Utils.findRequiredViewAsType(view, R.id.videoPlayer, "field 'videoPlayer'", MyVideoView.class);
        newToyGuideDialog.button = (Button) Utils.findRequiredViewAsType(view, R.id.button, "field 'button'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewToyGuideDialog newToyGuideDialog = this.a;
        if (newToyGuideDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newToyGuideDialog.title = null;
        newToyGuideDialog.videoPlayer = null;
        newToyGuideDialog.button = null;
    }
}
