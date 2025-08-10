package com.wear.main.longDistance.player.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class PlayerActivity_ViewBinding implements Unbinder {
    public PlayerActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PlayerActivity a;

        public a(PlayerActivity_ViewBinding playerActivity_ViewBinding, PlayerActivity playerActivity) {
            this.a = playerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked();
        }
    }

    @UiThread
    public PlayerActivity_ViewBinding(PlayerActivity playerActivity, View view) {
        this.a = playerActivity;
        playerActivity.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        playerActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "field 'tvStop' and method 'onViewClicked'");
        playerActivity.tvStop = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_stop, "field 'tvStop'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, playerActivity));
        playerActivity.logTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.log_text_view, "field 'logTextView'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlayerActivity playerActivity = this.a;
        if (playerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        playerActivity.tvTime = null;
        playerActivity.tvTip = null;
        playerActivity.tvStop = null;
        playerActivity.logTextView = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
