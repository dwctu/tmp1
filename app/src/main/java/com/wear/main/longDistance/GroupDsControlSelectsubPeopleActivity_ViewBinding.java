package com.wear.main.longDistance;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class GroupDsControlSelectsubPeopleActivity_ViewBinding implements Unbinder {
    public GroupDsControlSelectsubPeopleActivity a;

    @UiThread
    public GroupDsControlSelectsubPeopleActivity_ViewBinding(GroupDsControlSelectsubPeopleActivity groupDsControlSelectsubPeopleActivity, View view) {
        this.a = groupDsControlSelectsubPeopleActivity;
        groupDsControlSelectsubPeopleActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        groupDsControlSelectsubPeopleActivity.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        groupDsControlSelectsubPeopleActivity.etSearch = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'etSearch'", EditText.class);
        groupDsControlSelectsubPeopleActivity.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_Cancel, "field 'tvCancel'", TextView.class);
        groupDsControlSelectsubPeopleActivity.llRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'llRoot'", LinearLayout.class);
        groupDsControlSelectsubPeopleActivity.emptyView = (TextView) Utils.findRequiredViewAsType(view, R.id.empty_view, "field 'emptyView'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupDsControlSelectsubPeopleActivity groupDsControlSelectsubPeopleActivity = this.a;
        if (groupDsControlSelectsubPeopleActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupDsControlSelectsubPeopleActivity.abTitle = null;
        groupDsControlSelectsubPeopleActivity.rvFriend = null;
        groupDsControlSelectsubPeopleActivity.etSearch = null;
        groupDsControlSelectsubPeopleActivity.tvCancel = null;
        groupDsControlSelectsubPeopleActivity.llRoot = null;
        groupDsControlSelectsubPeopleActivity.emptyView = null;
    }
}
