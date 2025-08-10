package com.wear.main.longDistance;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class GroupDsControlSelectDomsPeopleActivity_ViewBinding implements Unbinder {
    public GroupDsControlSelectDomsPeopleActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GroupDsControlSelectDomsPeopleActivity a;

        public a(GroupDsControlSelectDomsPeopleActivity_ViewBinding groupDsControlSelectDomsPeopleActivity_ViewBinding, GroupDsControlSelectDomsPeopleActivity groupDsControlSelectDomsPeopleActivity) {
            this.a = groupDsControlSelectDomsPeopleActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick();
        }
    }

    @UiThread
    public GroupDsControlSelectDomsPeopleActivity_ViewBinding(GroupDsControlSelectDomsPeopleActivity groupDsControlSelectDomsPeopleActivity, View view) {
        this.a = groupDsControlSelectDomsPeopleActivity;
        groupDsControlSelectDomsPeopleActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        groupDsControlSelectDomsPeopleActivity.rvSelectFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_select_friend, "field 'rvSelectFriend'", RecyclerView.class);
        groupDsControlSelectDomsPeopleActivity.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        groupDsControlSelectDomsPeopleActivity.llTop = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_top, "field 'llTop'", LinearLayout.class);
        groupDsControlSelectDomsPeopleActivity.llTip = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tip, "field 'llTip'", LinearLayout.class);
        groupDsControlSelectDomsPeopleActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        groupDsControlSelectDomsPeopleActivity.ivAll = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_all, "field 'ivAll'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_all, "field 'llAll' and method 'onClick'");
        groupDsControlSelectDomsPeopleActivity.llAll = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_all, "field 'llAll'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, groupDsControlSelectDomsPeopleActivity));
        groupDsControlSelectDomsPeopleActivity.etSearch = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'etSearch'", EditText.class);
        groupDsControlSelectDomsPeopleActivity.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_Cancel, "field 'tvCancel'", TextView.class);
        groupDsControlSelectDomsPeopleActivity.llRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'llRoot'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupDsControlSelectDomsPeopleActivity groupDsControlSelectDomsPeopleActivity = this.a;
        if (groupDsControlSelectDomsPeopleActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupDsControlSelectDomsPeopleActivity.abTitle = null;
        groupDsControlSelectDomsPeopleActivity.rvSelectFriend = null;
        groupDsControlSelectDomsPeopleActivity.rvFriend = null;
        groupDsControlSelectDomsPeopleActivity.llTop = null;
        groupDsControlSelectDomsPeopleActivity.llTip = null;
        groupDsControlSelectDomsPeopleActivity.tvTip = null;
        groupDsControlSelectDomsPeopleActivity.ivAll = null;
        groupDsControlSelectDomsPeopleActivity.llAll = null;
        groupDsControlSelectDomsPeopleActivity.etSearch = null;
        groupDsControlSelectDomsPeopleActivity.tvCancel = null;
        groupDsControlSelectDomsPeopleActivity.llRoot = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
