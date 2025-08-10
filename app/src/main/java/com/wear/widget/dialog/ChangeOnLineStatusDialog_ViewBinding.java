package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChangeOnLineStatusDialog_ViewBinding implements Unbinder {
    public ChangeOnLineStatusDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeOnLineStatusDialog a;

        public a(ChangeOnLineStatusDialog_ViewBinding changeOnLineStatusDialog_ViewBinding, ChangeOnLineStatusDialog changeOnLineStatusDialog) {
            this.a = changeOnLineStatusDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeOnLineStatusDialog a;

        public b(ChangeOnLineStatusDialog_ViewBinding changeOnLineStatusDialog_ViewBinding, ChangeOnLineStatusDialog changeOnLineStatusDialog) {
            this.a = changeOnLineStatusDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChangeOnLineStatusDialog a;

        public c(ChangeOnLineStatusDialog_ViewBinding changeOnLineStatusDialog_ViewBinding, ChangeOnLineStatusDialog changeOnLineStatusDialog) {
            this.a = changeOnLineStatusDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChangeOnLineStatusDialog_ViewBinding(ChangeOnLineStatusDialog changeOnLineStatusDialog, View view) {
        this.a = changeOnLineStatusDialog;
        changeOnLineStatusDialog.ivAvailable = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_available, "field 'ivAvailable'", ImageView.class);
        changeOnLineStatusDialog.ivBusy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_busy, "field 'ivBusy'", ImageView.class);
        changeOnLineStatusDialog.ivInvisible = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_invisible, "field 'ivInvisible'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_available, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, changeOnLineStatusDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_busy, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, changeOnLineStatusDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_invisible, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, changeOnLineStatusDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeOnLineStatusDialog changeOnLineStatusDialog = this.a;
        if (changeOnLineStatusDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        changeOnLineStatusDialog.ivAvailable = null;
        changeOnLineStatusDialog.ivBusy = null;
        changeOnLineStatusDialog.ivInvisible = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
