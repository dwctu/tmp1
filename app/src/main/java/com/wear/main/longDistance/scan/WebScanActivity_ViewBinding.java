package com.wear.main.longDistance.scan;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class WebScanActivity_ViewBinding implements Unbinder {
    public WebScanActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ WebScanActivity a;

        public a(WebScanActivity_ViewBinding webScanActivity_ViewBinding, WebScanActivity webScanActivity) {
            this.a = webScanActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ WebScanActivity a;

        public b(WebScanActivity_ViewBinding webScanActivity_ViewBinding, WebScanActivity webScanActivity) {
            this.a = webScanActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public WebScanActivity_ViewBinding(WebScanActivity webScanActivity, View view) {
        this.a = webScanActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_input_code, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, webScanActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.scan_album_iv, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, webScanActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
