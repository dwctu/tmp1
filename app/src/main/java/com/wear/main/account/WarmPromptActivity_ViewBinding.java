package com.wear.main.account;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class WarmPromptActivity_ViewBinding implements Unbinder {
    public WarmPromptActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ WarmPromptActivity a;

        public a(WarmPromptActivity_ViewBinding warmPromptActivity_ViewBinding, WarmPromptActivity warmPromptActivity) {
            this.a = warmPromptActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ WarmPromptActivity a;

        public b(WarmPromptActivity_ViewBinding warmPromptActivity_ViewBinding, WarmPromptActivity warmPromptActivity) {
            this.a = warmPromptActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public WarmPromptActivity_ViewBinding(WarmPromptActivity warmPromptActivity, View view) {
        this.a = warmPromptActivity;
        warmPromptActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_agree, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, warmPromptActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_disagree, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, warmPromptActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarmPromptActivity warmPromptActivity = this.a;
        if (warmPromptActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        warmPromptActivity.tvTip = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
