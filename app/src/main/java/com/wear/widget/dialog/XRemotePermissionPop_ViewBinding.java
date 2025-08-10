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
public final class XRemotePermissionPop_ViewBinding implements Unbinder {
    public XRemotePermissionPop a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ XRemotePermissionPop a;

        public a(XRemotePermissionPop_ViewBinding xRemotePermissionPop_ViewBinding, XRemotePermissionPop xRemotePermissionPop) {
            this.a = xRemotePermissionPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ XRemotePermissionPop a;

        public b(XRemotePermissionPop_ViewBinding xRemotePermissionPop_ViewBinding, XRemotePermissionPop xRemotePermissionPop) {
            this.a = xRemotePermissionPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    @UiThread
    public XRemotePermissionPop_ViewBinding(XRemotePermissionPop xRemotePermissionPop, View view) {
        this.a = xRemotePermissionPop;
        xRemotePermissionPop.ivAppIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_icon, "field 'ivAppIcon'", ImageView.class);
        xRemotePermissionPop.tvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'tvAppName'", TextView.class);
        xRemotePermissionPop.tvPrivacyContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_privacy_content, "field 'tvPrivacyContent'", TextView.class);
        xRemotePermissionPop.tvPrivacyTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_privacy_title, "field 'tvPrivacyTitle'", TextView.class);
        xRemotePermissionPop.vPlaceholder = Utils.findRequiredView(view, R.id.v_placeholder, "field 'vPlaceholder'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_cancel, "field 'btnCancel' and method 'doClick'");
        xRemotePermissionPop.btnCancel = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_cancel, "field 'btnCancel'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, xRemotePermissionPop));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_allow, "field 'btnAllow' and method 'doClick'");
        xRemotePermissionPop.btnAllow = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_allow, "field 'btnAllow'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, xRemotePermissionPop));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        XRemotePermissionPop xRemotePermissionPop = this.a;
        if (xRemotePermissionPop == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        xRemotePermissionPop.ivAppIcon = null;
        xRemotePermissionPop.tvAppName = null;
        xRemotePermissionPop.tvPrivacyContent = null;
        xRemotePermissionPop.tvPrivacyTitle = null;
        xRemotePermissionPop.vPlaceholder = null;
        xRemotePermissionPop.btnCancel = null;
        xRemotePermissionPop.btnAllow = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
