package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes4.dex */
public class GroupControledWaitAccpetDialog_ViewBinding implements Unbinder {
    public GroupControledWaitAccpetDialog a;

    @UiThread
    public GroupControledWaitAccpetDialog_ViewBinding(GroupControledWaitAccpetDialog groupControledWaitAccpetDialog, View view) {
        this.a = groupControledWaitAccpetDialog;
        groupControledWaitAccpetDialog.rvMember = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_member, "field 'rvMember'", RecyclerView.class);
        groupControledWaitAccpetDialog.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        groupControledWaitAccpetDialog.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
        groupControledWaitAccpetDialog.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tvUserName'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupControledWaitAccpetDialog groupControledWaitAccpetDialog = this.a;
        if (groupControledWaitAccpetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupControledWaitAccpetDialog.rvMember = null;
        groupControledWaitAccpetDialog.ivUserImg = null;
        groupControledWaitAccpetDialog.tvCount = null;
        groupControledWaitAccpetDialog.tvUserName = null;
    }
}
