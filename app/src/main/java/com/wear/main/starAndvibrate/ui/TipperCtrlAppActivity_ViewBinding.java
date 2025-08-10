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
public class TipperCtrlAppActivity_ViewBinding implements Unbinder {
    public TipperCtrlAppActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TipperCtrlAppActivity a;

        public a(TipperCtrlAppActivity_ViewBinding tipperCtrlAppActivity_ViewBinding, TipperCtrlAppActivity tipperCtrlAppActivity) {
            this.a = tipperCtrlAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick();
        }
    }

    @UiThread
    public TipperCtrlAppActivity_ViewBinding(TipperCtrlAppActivity tipperCtrlAppActivity, View view) {
        this.a = tipperCtrlAppActivity;
        tipperCtrlAppActivity.rvToys = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toys, "field 'rvToys'", RecyclerView.class);
        tipperCtrlAppActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        tipperCtrlAppActivity.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        tipperCtrlAppActivity.tvTimesUp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_times_up, "field 'tvTimesUp'", TextView.class);
        tipperCtrlAppActivity.tvPf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pf, "field 'tvPf'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, tipperCtrlAppActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TipperCtrlAppActivity tipperCtrlAppActivity = this.a;
        if (tipperCtrlAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        tipperCtrlAppActivity.rvToys = null;
        tipperCtrlAppActivity.tvTip = null;
        tipperCtrlAppActivity.tvTime = null;
        tipperCtrlAppActivity.tvTimesUp = null;
        tipperCtrlAppActivity.tvPf = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
