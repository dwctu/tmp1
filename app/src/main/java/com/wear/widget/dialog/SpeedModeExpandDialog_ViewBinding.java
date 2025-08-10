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
public class SpeedModeExpandDialog_ViewBinding implements Unbinder {
    public SpeedModeExpandDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeExpandDialog a;

        public a(SpeedModeExpandDialog_ViewBinding speedModeExpandDialog_ViewBinding, SpeedModeExpandDialog speedModeExpandDialog) {
            this.a = speedModeExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeExpandDialog a;

        public b(SpeedModeExpandDialog_ViewBinding speedModeExpandDialog_ViewBinding, SpeedModeExpandDialog speedModeExpandDialog) {
            this.a = speedModeExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ SpeedModeExpandDialog a;

        public c(SpeedModeExpandDialog_ViewBinding speedModeExpandDialog_ViewBinding, SpeedModeExpandDialog speedModeExpandDialog) {
            this.a = speedModeExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SpeedModeExpandDialog_ViewBinding(SpeedModeExpandDialog speedModeExpandDialog, View view) {
        this.a = speedModeExpandDialog;
        speedModeExpandDialog.flRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_expand_bg, "field 'LLExpandBg' and method 'onClick'");
        speedModeExpandDialog.LLExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_expand_bg, "field 'LLExpandBg'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, speedModeExpandDialog));
        speedModeExpandDialog.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        speedModeExpandDialog.tvPatternName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_name, "field 'tvPatternName'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_bg, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, speedModeExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_end, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, speedModeExpandDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SpeedModeExpandDialog speedModeExpandDialog = this.a;
        if (speedModeExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        speedModeExpandDialog.flRootView = null;
        speedModeExpandDialog.LLExpandBg = null;
        speedModeExpandDialog.ivIcon = null;
        speedModeExpandDialog.tvPatternName = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
