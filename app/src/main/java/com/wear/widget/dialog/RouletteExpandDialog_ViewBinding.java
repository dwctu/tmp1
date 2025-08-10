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
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class RouletteExpandDialog_ViewBinding implements Unbinder {
    public RouletteExpandDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RouletteExpandDialog a;

        public a(RouletteExpandDialog_ViewBinding rouletteExpandDialog_ViewBinding, RouletteExpandDialog rouletteExpandDialog) {
            this.a = rouletteExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ RouletteExpandDialog a;

        public b(RouletteExpandDialog_ViewBinding rouletteExpandDialog_ViewBinding, RouletteExpandDialog rouletteExpandDialog) {
            this.a = rouletteExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RouletteExpandDialog a;

        public c(RouletteExpandDialog_ViewBinding rouletteExpandDialog_ViewBinding, RouletteExpandDialog rouletteExpandDialog) {
            this.a = rouletteExpandDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public RouletteExpandDialog_ViewBinding(RouletteExpandDialog rouletteExpandDialog, View view) {
        this.a = rouletteExpandDialog;
        rouletteExpandDialog.flRootView = (FrameLayout) Utils.findOptionalViewAsType(view, R.id.fl_root_view, "field 'flRootView'", FrameLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_expand_bg, "method 'onClick'");
        rouletteExpandDialog.LLExpandBg = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_expand_bg, "field 'LLExpandBg'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, rouletteExpandDialog));
        rouletteExpandDialog.ivIcon = (ImageView) Utils.findOptionalViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        rouletteExpandDialog.tvPatternName = (TextView) Utils.findOptionalViewAsType(view, R.id.tv_pattern_name, "field 'tvPatternName'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_bg, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, rouletteExpandDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_end, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, rouletteExpandDialog));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RouletteExpandDialog rouletteExpandDialog = this.a;
        if (rouletteExpandDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        rouletteExpandDialog.flRootView = null;
        rouletteExpandDialog.LLExpandBg = null;
        rouletteExpandDialog.ivIcon = null;
        rouletteExpandDialog.tvPatternName = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
