package com.wear.main.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;

/* loaded from: classes3.dex */
public class AllGroupMembersActivity_ViewBinding implements Unbinder {
    public AllGroupMembersActivity a;

    @UiThread
    public AllGroupMembersActivity_ViewBinding(AllGroupMembersActivity allGroupMembersActivity, View view) {
        this.a = allGroupMembersActivity;
        allGroupMembersActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        allGroupMembersActivity.sbSearch = (SearchButton) Utils.findRequiredViewAsType(view, R.id.sb_search, "field 'sbSearch'", SearchButton.class);
        allGroupMembersActivity.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AllGroupMembersActivity allGroupMembersActivity = this.a;
        if (allGroupMembersActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        allGroupMembersActivity.abTitle = null;
        allGroupMembersActivity.sbSearch = null;
        allGroupMembersActivity.rvFriend = null;
    }
}
