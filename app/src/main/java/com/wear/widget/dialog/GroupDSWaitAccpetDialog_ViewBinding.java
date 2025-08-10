package com.wear.widget.dialog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes4.dex */
public class GroupDSWaitAccpetDialog_ViewBinding implements Unbinder {
    public GroupDSWaitAccpetDialog a;

    @UiThread
    public GroupDSWaitAccpetDialog_ViewBinding(GroupDSWaitAccpetDialog groupDSWaitAccpetDialog, View view) {
        this.a = groupDSWaitAccpetDialog;
        groupDSWaitAccpetDialog.tvRoomName = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.tv_room_name, "field 'tvRoomName'", MediumBoldTextView.class);
        groupDSWaitAccpetDialog.dsWaitConnect = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.ds_wait_connect, "field 'dsWaitConnect'", MediumBoldTextView.class);
        groupDSWaitAccpetDialog.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        groupDSWaitAccpetDialog.tvSUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_s_user_name, "field 'tvSUserName'", TextView.class);
        groupDSWaitAccpetDialog.rvMember = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_member, "field 'rvMember'", RecyclerView.class);
        groupDSWaitAccpetDialog.tvDecline = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_decline, "field 'tvDecline'", TextView.class);
        groupDSWaitAccpetDialog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
        groupDSWaitAccpetDialog.llGroupControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_group_control, "field 'llGroupControl'", LinearLayout.class);
        groupDSWaitAccpetDialog.tvCreateCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_create_cancel, "field 'tvCreateCancel'", TextView.class);
        groupDSWaitAccpetDialog.llCreateControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_create_control, "field 'llCreateControl'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = this.a;
        if (groupDSWaitAccpetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupDSWaitAccpetDialog.tvRoomName = null;
        groupDSWaitAccpetDialog.dsWaitConnect = null;
        groupDSWaitAccpetDialog.ivUserImg = null;
        groupDSWaitAccpetDialog.tvSUserName = null;
        groupDSWaitAccpetDialog.rvMember = null;
        groupDSWaitAccpetDialog.tvDecline = null;
        groupDSWaitAccpetDialog.tvConfirm = null;
        groupDSWaitAccpetDialog.llGroupControl = null;
        groupDSWaitAccpetDialog.tvCreateCancel = null;
        groupDSWaitAccpetDialog.llCreateControl = null;
    }
}
