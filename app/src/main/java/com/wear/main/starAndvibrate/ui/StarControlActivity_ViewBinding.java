package com.wear.main.starAndvibrate.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class StarControlActivity_ViewBinding implements Unbinder {
    public StarControlActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ StarControlActivity a;

        public a(StarControlActivity_ViewBinding starControlActivity_ViewBinding, StarControlActivity starControlActivity) {
            this.a = starControlActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick();
        }
    }

    @UiThread
    public StarControlActivity_ViewBinding(StarControlActivity starControlActivity, View view) {
        this.a = starControlActivity;
        starControlActivity.rvToys = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toys, "field 'rvToys'", RecyclerView.class);
        starControlActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        starControlActivity.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, starControlActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        StarControlActivity starControlActivity = this.a;
        if (starControlActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        starControlActivity.rvToys = null;
        starControlActivity.tvTip = null;
        starControlActivity.tvTime = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
