package com.wear.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ControlExpandDialog_ViewBinding implements Unbinder {
    public ControlExpandDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ControlExpandDialog a;

        public a(ControlExpandDialog_ViewBinding controlExpandDialog_ViewBinding, ControlExpandDialog controlExpandDialog) {
            this.a = controlExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ControlExpandDialog a;

        public b(ControlExpandDialog_ViewBinding controlExpandDialog_ViewBinding, ControlExpandDialog controlExpandDialog) {
            this.a = controlExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ControlExpandDialog a;

        public c(ControlExpandDialog_ViewBinding controlExpandDialog_ViewBinding, ControlExpandDialog controlExpandDialog) {
            this.a = controlExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ControlExpandDialog_ViewBinding(ControlExpandDialog controlExpandDialog, View view) {
        this.a = controlExpandDialog;
        controlExpandDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_bg, "field 'ivBg' and method 'onClick'");
        controlExpandDialog.ivBg = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, controlExpandDialog));
        controlExpandDialog.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        controlExpandDialog.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tvUserName'", TextView.class);
        controlExpandDialog.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_end, "field 'ivEnd' and method 'onClick'");
        controlExpandDialog.ivEnd = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_end, "field 'ivEnd'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, controlExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_expand_bg, "field 'LLExpandBg' and method 'onClick'");
        controlExpandDialog.LLExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_expand_bg, "field 'LLExpandBg'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, controlExpandDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlExpandDialog controlExpandDialog = this.a;
        if (controlExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlExpandDialog.flRootView = null;
        controlExpandDialog.ivBg = null;
        controlExpandDialog.ivIcon = null;
        controlExpandDialog.tvUserName = null;
        controlExpandDialog.tvTime = null;
        controlExpandDialog.ivEnd = null;
        controlExpandDialog.LLExpandBg = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
