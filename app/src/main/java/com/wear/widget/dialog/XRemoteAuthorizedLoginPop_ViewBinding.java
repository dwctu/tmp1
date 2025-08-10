package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public final class XRemoteAuthorizedLoginPop_ViewBinding implements Unbinder {
    public XRemoteAuthorizedLoginPop a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ XRemoteAuthorizedLoginPop a;

        public a(XRemoteAuthorizedLoginPop_ViewBinding xRemoteAuthorizedLoginPop_ViewBinding, XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop) {
            this.a = xRemoteAuthorizedLoginPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ XRemoteAuthorizedLoginPop a;

        public b(XRemoteAuthorizedLoginPop_ViewBinding xRemoteAuthorizedLoginPop_ViewBinding, XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop) {
            this.a = xRemoteAuthorizedLoginPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ XRemoteAuthorizedLoginPop a;

        public c(XRemoteAuthorizedLoginPop_ViewBinding xRemoteAuthorizedLoginPop_ViewBinding, XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop) {
            this.a = xRemoteAuthorizedLoginPop;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    @UiThread
    public XRemoteAuthorizedLoginPop_ViewBinding(XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop, View view) {
        this.a = xRemoteAuthorizedLoginPop;
        xRemoteAuthorizedLoginPop.ivAppIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_icon, "field 'ivAppIcon'", ImageView.class);
        xRemoteAuthorizedLoginPop.tvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'tvAppName'", TextView.class);
        xRemoteAuthorizedLoginPop.tvUserTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_tip, "field 'tvUserTip'", TextView.class);
        xRemoteAuthorizedLoginPop.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_user_custom_name, "field 'btnUserCustomName' and method 'doClick'");
        xRemoteAuthorizedLoginPop.btnUserCustomName = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_user_custom_name, "field 'btnUserCustomName'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, xRemoteAuthorizedLoginPop));
        xRemoteAuthorizedLoginPop.llBottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bottom, "field 'llBottom'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_cancel, "field 'btnCancel' and method 'doClick'");
        xRemoteAuthorizedLoginPop.btnCancel = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_cancel, "field 'btnCancel'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, xRemoteAuthorizedLoginPop));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_allow, "field 'btnAllow' and method 'doClick'");
        xRemoteAuthorizedLoginPop.btnAllow = (TextView) Utils.castView(viewFindRequiredView3, R.id.btn_allow, "field 'btnAllow'", TextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, xRemoteAuthorizedLoginPop));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop = this.a;
        if (xRemoteAuthorizedLoginPop == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        xRemoteAuthorizedLoginPop.ivAppIcon = null;
        xRemoteAuthorizedLoginPop.tvAppName = null;
        xRemoteAuthorizedLoginPop.tvUserTip = null;
        xRemoteAuthorizedLoginPop.recyclerView = null;
        xRemoteAuthorizedLoginPop.btnUserCustomName = null;
        xRemoteAuthorizedLoginPop.llBottom = null;
        xRemoteAuthorizedLoginPop.btnCancel = null;
        xRemoteAuthorizedLoginPop.btnAllow = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
