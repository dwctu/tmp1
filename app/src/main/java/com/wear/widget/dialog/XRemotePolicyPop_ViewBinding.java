package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public final class XRemotePolicyPop_ViewBinding implements Unbinder {
    public XRemotePolicyPop a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ XRemotePolicyPop a;

        public a(XRemotePolicyPop_ViewBinding xRemotePolicyPop_ViewBinding, XRemotePolicyPop xRemotePolicyPop) {
            this.a = xRemotePolicyPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ XRemotePolicyPop a;

        public b(XRemotePolicyPop_ViewBinding xRemotePolicyPop_ViewBinding, XRemotePolicyPop xRemotePolicyPop) {
            this.a = xRemotePolicyPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    @UiThread
    public XRemotePolicyPop_ViewBinding(XRemotePolicyPop xRemotePolicyPop, View view) {
        this.a = xRemotePolicyPop;
        xRemotePolicyPop.ivAppIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_icon, "field 'ivAppIcon'", ImageView.class);
        xRemotePolicyPop.tvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'tvAppName'", TextView.class);
        xRemotePolicyPop.tvPrivacyContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_privacy_content, "field 'tvPrivacyContent'", TextView.class);
        xRemotePolicyPop.vPlaceholder = Utils.findRequiredView(view, R.id.v_placeholder, "field 'vPlaceholder'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_cancel, "field 'btnCancel' and method 'doClick'");
        xRemotePolicyPop.btnCancel = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_cancel, "field 'btnCancel'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, xRemotePolicyPop));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_allow, "field 'btnAllow' and method 'doClick'");
        xRemotePolicyPop.btnAllow = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_allow, "field 'btnAllow'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, xRemotePolicyPop));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        XRemotePolicyPop xRemotePolicyPop = this.a;
        if (xRemotePolicyPop == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        xRemotePolicyPop.ivAppIcon = null;
        xRemotePolicyPop.tvAppName = null;
        xRemotePolicyPop.tvPrivacyContent = null;
        xRemotePolicyPop.vPlaceholder = null;
        xRemotePolicyPop.btnCancel = null;
        xRemotePolicyPop.btnAllow = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
