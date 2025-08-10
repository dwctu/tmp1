package com.wear.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public final class ControlGeneralExpandDialog_ViewBinding implements Unbinder {
    public ControlGeneralExpandDialog a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public a(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public b(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public c(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public d(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public e(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ControlGeneralExpandDialog a;

        public f(ControlGeneralExpandDialog_ViewBinding controlGeneralExpandDialog_ViewBinding, ControlGeneralExpandDialog controlGeneralExpandDialog) {
            this.a = controlGeneralExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ControlGeneralExpandDialog_ViewBinding(ControlGeneralExpandDialog controlGeneralExpandDialog, View view) {
        this.a = controlGeneralExpandDialog;
        controlGeneralExpandDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_bg, "field 'ivBg' and method 'onClick'");
        controlGeneralExpandDialog.ivBg = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, controlGeneralExpandDialog));
        controlGeneralExpandDialog.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        controlGeneralExpandDialog.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        controlGeneralExpandDialog.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_end, "field 'ivEnd' and method 'onClick'");
        controlGeneralExpandDialog.ivEnd = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_end, "field 'ivEnd'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, controlGeneralExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_expand_bg, "field 'llExpandBg' and method 'onClick'");
        controlGeneralExpandDialog.llExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_expand_bg, "field 'llExpandBg'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, controlGeneralExpandDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause' and method 'onClick'");
        controlGeneralExpandDialog.ivPlayOrPause = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, controlGeneralExpandDialog));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_previous, "field 'ivPrevious' and method 'onClick'");
        controlGeneralExpandDialog.ivPrevious = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_previous, "field 'ivPrevious'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, controlGeneralExpandDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_next, "field 'ivNext' and method 'onClick'");
        controlGeneralExpandDialog.ivNext = (ImageView) Utils.castView(viewFindRequiredView6, R.id.iv_next, "field 'ivNext'", ImageView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, controlGeneralExpandDialog));
        controlGeneralExpandDialog.ivUnderPreview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_under_preview, "field 'ivUnderPreview'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ControlGeneralExpandDialog controlGeneralExpandDialog = this.a;
        if (controlGeneralExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlGeneralExpandDialog.flRootView = null;
        controlGeneralExpandDialog.ivBg = null;
        controlGeneralExpandDialog.ivIcon = null;
        controlGeneralExpandDialog.tvName = null;
        controlGeneralExpandDialog.tvTime = null;
        controlGeneralExpandDialog.ivEnd = null;
        controlGeneralExpandDialog.llExpandBg = null;
        controlGeneralExpandDialog.ivPlayOrPause = null;
        controlGeneralExpandDialog.ivPrevious = null;
        controlGeneralExpandDialog.ivNext = null;
        controlGeneralExpandDialog.ivUnderPreview = null;
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
    }
}
