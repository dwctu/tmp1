package com.wear.widget.dialog;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;

/* loaded from: classes4.dex */
public class LoveEmojisDialog_ViewBinding implements Unbinder {
    public LoveEmojisDialog a;

    @UiThread
    public LoveEmojisDialog_ViewBinding(LoveEmojisDialog loveEmojisDialog, View view) {
        this.a = loveEmojisDialog;
        loveEmojisDialog.confirmButton = (Button) Utils.findRequiredViewAsType(view, R.id.confirm_button, "field 'confirmButton'", Button.class);
        loveEmojisDialog.videoPlayer = (MyVideoView) Utils.findRequiredViewAsType(view, R.id.videoPlayer, "field 'videoPlayer'", MyVideoView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoveEmojisDialog loveEmojisDialog = this.a;
        if (loveEmojisDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        loveEmojisDialog.confirmButton = null;
        loveEmojisDialog.videoPlayer = null;
    }
}
