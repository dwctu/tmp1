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
public class VibeWithMeControlActivity_ViewBinding implements Unbinder {
    public VibeWithMeControlActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ VibeWithMeControlActivity a;

        public a(VibeWithMeControlActivity_ViewBinding vibeWithMeControlActivity_ViewBinding, VibeWithMeControlActivity vibeWithMeControlActivity) {
            this.a = vibeWithMeControlActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick();
        }
    }

    @UiThread
    public VibeWithMeControlActivity_ViewBinding(VibeWithMeControlActivity vibeWithMeControlActivity, View view) {
        this.a = vibeWithMeControlActivity;
        vibeWithMeControlActivity.rvToys = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toys, "field 'rvToys'", RecyclerView.class);
        vibeWithMeControlActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        vibeWithMeControlActivity.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        vibeWithMeControlActivity.tvPf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pf, "field 'tvPf'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, vibeWithMeControlActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VibeWithMeControlActivity vibeWithMeControlActivity = this.a;
        if (vibeWithMeControlActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        vibeWithMeControlActivity.rvToys = null;
        vibeWithMeControlActivity.tvTip = null;
        vibeWithMeControlActivity.tvTime = null;
        vibeWithMeControlActivity.tvPf = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
