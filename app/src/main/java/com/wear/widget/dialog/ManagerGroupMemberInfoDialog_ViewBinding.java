package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
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
public class ManagerGroupMemberInfoDialog_ViewBinding implements Unbinder {
    public ManagerGroupMemberInfoDialog a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public a(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public b(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public c(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public d(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public e(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public f(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public g(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public h(ManagerGroupMemberInfoDialog_ViewBinding managerGroupMemberInfoDialog_ViewBinding, ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ManagerGroupMemberInfoDialog_ViewBinding(ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog, View view) {
        this.a = managerGroupMemberInfoDialog;
        managerGroupMemberInfoDialog.rivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.riv_user_img, "field 'rivUserImg'", RoundedImageView.class);
        managerGroupMemberInfoDialog.ivRole = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_role, "field 'ivRole'", ImageView.class);
        managerGroupMemberInfoDialog.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        managerGroupMemberInfoDialog.toyRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.toy_recyclerview, "field 'toyRecyclerView'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_send_message, "field 'tvSendMessage' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvSendMessage = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_send_message, "field 'tvSendMessage'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_add_friend, "field 'tvAddFriend' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvAddFriend = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_add_friend, "field 'tvAddFriend'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_dismiss_admin, "field 'tvDismissAdmin' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvDismissAdmin = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_dismiss_admin, "field 'tvDismissAdmin'", TextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_make_admin, "field 'tvMakeAdmin' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvMakeAdmin = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_make_admin, "field 'tvMakeAdmin'", TextView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_block, "field 'tvBlock' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvBlock = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_block, "field 'tvBlock'", TextView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_remove, "field 'tvRemove' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvRemove = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_remove, "field 'tvRemove'", TextView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvCancel = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, managerGroupMemberInfoDialog));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_report, "field 'tvReport' and method 'onViewClicked'");
        managerGroupMemberInfoDialog.tvReport = (TextView) Utils.castView(viewFindRequiredView8, R.id.tv_report, "field 'tvReport'", TextView.class);
        this.i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(this, managerGroupMemberInfoDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog = this.a;
        if (managerGroupMemberInfoDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        managerGroupMemberInfoDialog.rivUserImg = null;
        managerGroupMemberInfoDialog.ivRole = null;
        managerGroupMemberInfoDialog.tvName = null;
        managerGroupMemberInfoDialog.toyRecyclerView = null;
        managerGroupMemberInfoDialog.tvSendMessage = null;
        managerGroupMemberInfoDialog.tvAddFriend = null;
        managerGroupMemberInfoDialog.tvDismissAdmin = null;
        managerGroupMemberInfoDialog.tvMakeAdmin = null;
        managerGroupMemberInfoDialog.tvBlock = null;
        managerGroupMemberInfoDialog.tvRemove = null;
        managerGroupMemberInfoDialog.tvCancel = null;
        managerGroupMemberInfoDialog.tvReport = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
    }
}
