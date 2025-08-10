package com.wear.vibematevideo.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes4.dex */
public final class HtmlVideoActivity_ViewBinding implements Unbinder {
    public HtmlVideoActivity a;

    @UiThread
    public HtmlVideoActivity_ViewBinding(HtmlVideoActivity htmlVideoActivity, View view) {
        this.a = htmlVideoActivity;
        htmlVideoActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        htmlVideoActivity.webviewLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_htmlvideo_webView_layout, "field 'webviewLayout'", RelativeLayout.class);
        htmlVideoActivity.videoFullView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.ac_htmlvideo_fullView, "field 'videoFullView'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HtmlVideoActivity htmlVideoActivity = this.a;
        if (htmlVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        htmlVideoActivity.actionbar = null;
        htmlVideoActivity.webviewLayout = null;
        htmlVideoActivity.videoFullView = null;
    }
}
