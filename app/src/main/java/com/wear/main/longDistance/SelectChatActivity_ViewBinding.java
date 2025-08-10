package com.wear.main.longDistance;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;

/* loaded from: classes3.dex */
public class SelectChatActivity_ViewBinding implements Unbinder {
    public SelectChatActivity a;

    @UiThread
    public SelectChatActivity_ViewBinding(SelectChatActivity selectChatActivity, View view) {
        this.a = selectChatActivity;
        selectChatActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        selectChatActivity.sb_search = (SearchButton) Utils.findRequiredViewAsType(view, R.id.sb_search, "field 'sb_search'", SearchButton.class);
        selectChatActivity.chat_list = (ListView) Utils.findRequiredViewAsType(view, R.id.chat_list, "field 'chat_list'", ListView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SelectChatActivity selectChatActivity = this.a;
        if (selectChatActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        selectChatActivity.actionBar = null;
        selectChatActivity.sb_search = null;
        selectChatActivity.chat_list = null;
    }
}
