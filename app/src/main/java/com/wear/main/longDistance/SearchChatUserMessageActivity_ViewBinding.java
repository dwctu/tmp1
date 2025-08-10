package com.wear.main.longDistance;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.iwatcher.ImageWatcher;

/* loaded from: classes3.dex */
public class SearchChatUserMessageActivity_ViewBinding implements Unbinder {
    public SearchChatUserMessageActivity a;

    @UiThread
    public SearchChatUserMessageActivity_ViewBinding(SearchChatUserMessageActivity searchChatUserMessageActivity, View view) {
        this.a = searchChatUserMessageActivity;
        searchChatUserMessageActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        searchChatUserMessageActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
        searchChatUserMessageActivity.vImageWatcher = (ImageWatcher) Utils.findRequiredViewAsType(view, R.id.v_image_watcher, "field 'vImageWatcher'", ImageWatcher.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatUserMessageActivity searchChatUserMessageActivity = this.a;
        if (searchChatUserMessageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatUserMessageActivity.recyclerView = null;
        searchChatUserMessageActivity.tv_no_result = null;
        searchChatUserMessageActivity.vImageWatcher = null;
    }
}
