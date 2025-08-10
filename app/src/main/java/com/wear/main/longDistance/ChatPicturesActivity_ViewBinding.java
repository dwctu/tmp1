package com.wear.main.longDistance;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.iwatcher.ImageWatcher;

/* loaded from: classes3.dex */
public class ChatPicturesActivity_ViewBinding implements Unbinder {
    public ChatPicturesActivity a;

    @UiThread
    public ChatPicturesActivity_ViewBinding(ChatPicturesActivity chatPicturesActivity, View view) {
        this.a = chatPicturesActivity;
        chatPicturesActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatPicturesActivity.mGridView = (GridView) Utils.findRequiredViewAsType(view, R.id.expression_gridview, "field 'mGridView'", GridView.class);
        chatPicturesActivity.deleteAction = Utils.findRequiredView(view, R.id.iv_delete_action, "field 'deleteAction'");
        chatPicturesActivity.selectNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_number, "field 'selectNumber'", TextView.class);
        chatPicturesActivity.vImageWatcher = (ImageWatcher) Utils.findRequiredViewAsType(view, R.id.v_image_watcher, "field 'vImageWatcher'", ImageWatcher.class);
        chatPicturesActivity.vImageDownload = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_image_download, "field 'vImageDownload'", ImageView.class);
        chatPicturesActivity.vImageScan = (ImageView) Utils.findRequiredViewAsType(view, R.id.v_image_scan, "field 'vImageScan'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatPicturesActivity chatPicturesActivity = this.a;
        if (chatPicturesActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatPicturesActivity.actionbar = null;
        chatPicturesActivity.mGridView = null;
        chatPicturesActivity.deleteAction = null;
        chatPicturesActivity.selectNumber = null;
        chatPicturesActivity.vImageWatcher = null;
        chatPicturesActivity.vImageDownload = null;
        chatPicturesActivity.vImageScan = null;
    }
}
