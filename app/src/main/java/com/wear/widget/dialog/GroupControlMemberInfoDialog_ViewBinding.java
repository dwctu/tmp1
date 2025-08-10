package com.wear.widget.dialog;

import android.view.View;
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
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes4.dex */
public class GroupControlMemberInfoDialog_ViewBinding implements Unbinder {
    public GroupControlMemberInfoDialog a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GroupControlMemberInfoDialog a;

        public a(GroupControlMemberInfoDialog_ViewBinding groupControlMemberInfoDialog_ViewBinding, GroupControlMemberInfoDialog groupControlMemberInfoDialog) {
            this.a = groupControlMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GroupControlMemberInfoDialog a;

        public b(GroupControlMemberInfoDialog_ViewBinding groupControlMemberInfoDialog_ViewBinding, GroupControlMemberInfoDialog groupControlMemberInfoDialog) {
            this.a = groupControlMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public GroupControlMemberInfoDialog_ViewBinding(GroupControlMemberInfoDialog groupControlMemberInfoDialog, View view) {
        this.a = groupControlMemberInfoDialog;
        groupControlMemberInfoDialog.rivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.riv_user_img, "field 'rivUserImg'", RoundedImageView.class);
        groupControlMemberInfoDialog.ivRole = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_role, "field 'ivRole'", ImageView.class);
        groupControlMemberInfoDialog.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        groupControlMemberInfoDialog.ivBattery1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_battery_1, "field 'ivBattery1'", ImageView.class);
        groupControlMemberInfoDialog.tvToyName1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_name_1, "field 'tvToyName1'", TextView.class);
        groupControlMemberInfoDialog.ivBattery2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_battery_2, "field 'ivBattery2'", ImageView.class);
        groupControlMemberInfoDialog.tvToyName2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_name_2, "field 'tvToyName2'", TextView.class);
        groupControlMemberInfoDialog.llToyInfo = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_toy_info, "field 'llToyInfo'", LinearLayout.class);
        groupControlMemberInfoDialog.toyRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.toy_recyclerview, "field 'toyRecyclerView'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_to_control, "field 'tvToControl' and method 'onViewClicked'");
        groupControlMemberInfoDialog.tvToControl = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_to_control, "field 'tvToControl'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, groupControlMemberInfoDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_block_contact, "field 'tvBlockContact' and method 'onViewClicked'");
        groupControlMemberInfoDialog.tvBlockContact = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_block_contact, "field 'tvBlockContact'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, groupControlMemberInfoDialog));
        groupControlMemberInfoDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupControlMemberInfoDialog groupControlMemberInfoDialog = this.a;
        if (groupControlMemberInfoDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupControlMemberInfoDialog.rivUserImg = null;
        groupControlMemberInfoDialog.ivRole = null;
        groupControlMemberInfoDialog.tvName = null;
        groupControlMemberInfoDialog.ivBattery1 = null;
        groupControlMemberInfoDialog.tvToyName1 = null;
        groupControlMemberInfoDialog.ivBattery2 = null;
        groupControlMemberInfoDialog.tvToyName2 = null;
        groupControlMemberInfoDialog.llToyInfo = null;
        groupControlMemberInfoDialog.toyRecyclerView = null;
        groupControlMemberInfoDialog.tvToControl = null;
        groupControlMemberInfoDialog.tvBlockContact = null;
        groupControlMemberInfoDialog.tvCancel = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
