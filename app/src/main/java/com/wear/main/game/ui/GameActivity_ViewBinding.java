package com.wear.main.game.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class GameActivity_ViewBinding implements Unbinder {
    public GameActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GameActivity a;

        public a(GameActivity_ViewBinding gameActivity_ViewBinding, GameActivity gameActivity) {
            this.a = gameActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked();
        }
    }

    @UiThread
    public GameActivity_ViewBinding(GameActivity gameActivity, View view) {
        this.a = gameActivity;
        gameActivity.ivTopBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_top_bg, "field 'ivTopBg'", ImageView.class);
        gameActivity.ivMirrorlifePlayWave = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_mirrorlife_play_wave, "field 'ivMirrorlifePlayWave'", ImageView.class);
        gameActivity.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        gameActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_stop, "field 'tvStop' and method 'onViewClicked'");
        gameActivity.tvStop = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_stop, "field 'tvStop'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, gameActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GameActivity gameActivity = this.a;
        if (gameActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        gameActivity.ivTopBg = null;
        gameActivity.ivMirrorlifePlayWave = null;
        gameActivity.tvTime = null;
        gameActivity.tvTip = null;
        gameActivity.tvStop = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
