package com.wear.ui.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class RequestFriendsListFragment_ViewBinding implements Unbinder {
    public RequestFriendsListFragment a;

    @UiThread
    public RequestFriendsListFragment_ViewBinding(RequestFriendsListFragment requestFriendsListFragment, View view) {
        this.a = requestFriendsListFragment;
        requestFriendsListFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RequestFriendsListFragment requestFriendsListFragment = this.a;
        if (requestFriendsListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        requestFriendsListFragment.rvList = null;
    }
}
