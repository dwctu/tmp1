package com.wear.main.longDistance.block;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class BlockTypeChooseActivity_ViewBinding implements Unbinder {
    public BlockTypeChooseActivity a;

    @UiThread
    public BlockTypeChooseActivity_ViewBinding(BlockTypeChooseActivity blockTypeChooseActivity, View view) {
        this.a = blockTypeChooseActivity;
        blockTypeChooseActivity.actionbarAccount = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar_account, "field 'actionbarAccount'", MyActionBar.class);
        blockTypeChooseActivity.contactsFriends = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.contacts_friends, "field 'contactsFriends'", LinearLayout.class);
        blockTypeChooseActivity.rejectedRequests = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rejected_requests, "field 'rejectedRequests'", LinearLayout.class);
        blockTypeChooseActivity.tvContactsFriends = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_contacts_friends, "field 'tvContactsFriends'", TextView.class);
        blockTypeChooseActivity.tvRejectedRequests = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rejected_requests, "field 'tvRejectedRequests'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BlockTypeChooseActivity blockTypeChooseActivity = this.a;
        if (blockTypeChooseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        blockTypeChooseActivity.actionbarAccount = null;
        blockTypeChooseActivity.contactsFriends = null;
        blockTypeChooseActivity.rejectedRequests = null;
        blockTypeChooseActivity.tvContactsFriends = null;
        blockTypeChooseActivity.tvRejectedRequests = null;
    }
}
