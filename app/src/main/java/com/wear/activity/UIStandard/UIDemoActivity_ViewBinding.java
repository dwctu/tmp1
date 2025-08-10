package com.wear.activity.UIStandard;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class UIDemoActivity_ViewBinding implements Unbinder {
    public UIDemoActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ UIDemoActivity a;

        public a(UIDemoActivity_ViewBinding uIDemoActivity_ViewBinding, UIDemoActivity uIDemoActivity) {
            this.a = uIDemoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ UIDemoActivity a;

        public b(UIDemoActivity_ViewBinding uIDemoActivity_ViewBinding, UIDemoActivity uIDemoActivity) {
            this.a = uIDemoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ UIDemoActivity a;

        public c(UIDemoActivity_ViewBinding uIDemoActivity_ViewBinding, UIDemoActivity uIDemoActivity) {
            this.a = uIDemoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ UIDemoActivity a;

        public d(UIDemoActivity_ViewBinding uIDemoActivity_ViewBinding, UIDemoActivity uIDemoActivity) {
            this.a = uIDemoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ UIDemoActivity a;

        public e(UIDemoActivity_ViewBinding uIDemoActivity_ViewBinding, UIDemoActivity uIDemoActivity) {
            this.a = uIDemoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public UIDemoActivity_ViewBinding(UIDemoActivity uIDemoActivity, View view) {
        this.a = uIDemoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_color, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, uIDemoActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_font, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, uIDemoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_shadow, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, uIDemoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_radius, "method 'onClick'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, uIDemoActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_button, "method 'onClick'");
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, uIDemoActivity));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
    }
}
