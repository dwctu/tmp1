package com.wear.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class GroupControlWaitAccpetDialog_ViewBinding implements Unbinder {
    public GroupControlWaitAccpetDialog a;

    @UiThread
    public GroupControlWaitAccpetDialog_ViewBinding(GroupControlWaitAccpetDialog groupControlWaitAccpetDialog, View view) {
        this.a = groupControlWaitAccpetDialog;
        groupControlWaitAccpetDialog.rvMember = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_member, "field 'rvMember'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupControlWaitAccpetDialog groupControlWaitAccpetDialog = this.a;
        if (groupControlWaitAccpetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupControlWaitAccpetDialog.rvMember = null;
    }
}
