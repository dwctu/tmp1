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
public class PatternExpandDialog_ViewBinding implements Unbinder {
    public PatternExpandDialog a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public a(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public b(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public c(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public d(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public e(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ PatternExpandDialog a;

        public f(PatternExpandDialog_ViewBinding patternExpandDialog_ViewBinding, PatternExpandDialog patternExpandDialog) {
            this.a = patternExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PatternExpandDialog_ViewBinding(PatternExpandDialog patternExpandDialog, View view) {
        this.a = patternExpandDialog;
        patternExpandDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_bg, "field 'ivBg' and method 'onClick'");
        patternExpandDialog.ivBg = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, patternExpandDialog));
        patternExpandDialog.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        patternExpandDialog.tvPatternName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvPatternName'", TextView.class);
        patternExpandDialog.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_end, "field 'ivEnd' and method 'onClick'");
        patternExpandDialog.ivEnd = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_end, "field 'ivEnd'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, patternExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_expand_bg, "field 'LLExpandBg' and method 'onClick'");
        patternExpandDialog.LLExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_expand_bg, "field 'LLExpandBg'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, patternExpandDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause' and method 'onClick'");
        patternExpandDialog.ivPlayOrPause = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, patternExpandDialog));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_previous, "field 'ivPrevious' and method 'onClick'");
        patternExpandDialog.ivPrevious = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_previous, "field 'ivPrevious'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, patternExpandDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_next, "field 'ivNext' and method 'onClick'");
        patternExpandDialog.ivNext = (ImageView) Utils.castView(viewFindRequiredView6, R.id.iv_next, "field 'ivNext'", ImageView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, patternExpandDialog));
        patternExpandDialog.iv_under_preview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_under_preview, "field 'iv_under_preview'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternExpandDialog patternExpandDialog = this.a;
        if (patternExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternExpandDialog.flRootView = null;
        patternExpandDialog.ivBg = null;
        patternExpandDialog.ivIcon = null;
        patternExpandDialog.tvPatternName = null;
        patternExpandDialog.tvTime = null;
        patternExpandDialog.ivEnd = null;
        patternExpandDialog.LLExpandBg = null;
        patternExpandDialog.ivPlayOrPause = null;
        patternExpandDialog.ivPrevious = null;
        patternExpandDialog.ivNext = null;
        patternExpandDialog.iv_under_preview = null;
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
