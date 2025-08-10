package com.wear.ui.discover.pattern;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ReportReasonActivity_ViewBinding implements Unbinder {
    public ReportReasonActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public a(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public b(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public c(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public d(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public e(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public f(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonActivity a;

        public g(ReportReasonActivity_ViewBinding reportReasonActivity_ViewBinding, ReportReasonActivity reportReasonActivity) {
            this.a = reportReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportReasonActivity_ViewBinding(ReportReasonActivity reportReasonActivity, View view) {
        this.a = reportReasonActivity;
        reportReasonActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.reason_layout_1, "field 'reasonLayout1' and method 'onClick'");
        reportReasonActivity.reasonLayout1 = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.reason_layout_1, "field 'reasonLayout1'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, reportReasonActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.reason_layout_2, "field 'reasonLayout2' and method 'onClick'");
        reportReasonActivity.reasonLayout2 = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.reason_layout_2, "field 'reasonLayout2'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, reportReasonActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.reason_layout_3, "field 'reasonLayout3' and method 'onClick'");
        reportReasonActivity.reasonLayout3 = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.reason_layout_3, "field 'reasonLayout3'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, reportReasonActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.reason_layout_4, "field 'reasonLayout4' and method 'onClick'");
        reportReasonActivity.reasonLayout4 = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.reason_layout_4, "field 'reasonLayout4'", LinearLayout.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, reportReasonActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.reason_layout_5, "field 'reasonLayout5' and method 'onClick'");
        reportReasonActivity.reasonLayout5 = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.reason_layout_5, "field 'reasonLayout5'", LinearLayout.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, reportReasonActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.reason_layout_6, "field 'reasonLayout6' and method 'onClick'");
        reportReasonActivity.reasonLayout6 = (LinearLayout) Utils.castView(viewFindRequiredView6, R.id.reason_layout_6, "field 'reasonLayout6'", LinearLayout.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, reportReasonActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.submit_btn, "field 'submitBtn' and method 'onClick'");
        reportReasonActivity.submitBtn = (Button) Utils.castView(viewFindRequiredView7, R.id.submit_btn, "field 'submitBtn'", Button.class);
        this.h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, reportReasonActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReportReasonActivity reportReasonActivity = this.a;
        if (reportReasonActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportReasonActivity.actionbar = null;
        reportReasonActivity.reasonLayout1 = null;
        reportReasonActivity.reasonLayout2 = null;
        reportReasonActivity.reasonLayout3 = null;
        reportReasonActivity.reasonLayout4 = null;
        reportReasonActivity.reasonLayout5 = null;
        reportReasonActivity.reasonLayout6 = null;
        reportReasonActivity.submitBtn = null;
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
    }
}
