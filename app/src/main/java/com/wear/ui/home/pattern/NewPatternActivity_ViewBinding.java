package com.wear.ui.home.pattern;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class NewPatternActivity_ViewBinding implements Unbinder {
    public NewPatternActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ NewPatternActivity a;

        public a(NewPatternActivity_ViewBinding newPatternActivity_ViewBinding, NewPatternActivity newPatternActivity) {
            this.a = newPatternActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onViewClicked();
        }
    }

    @UiThread
    public NewPatternActivity_ViewBinding(NewPatternActivity newPatternActivity, View view) {
        this.a = newPatternActivity;
        newPatternActivity.choosePatternsNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.choose_patterns_notice, "field 'choosePatternsNotice'", TextView.class);
        newPatternActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        newPatternActivity.flContent = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_content, "field 'flContent'", FrameLayout.class);
        newPatternActivity.ivSyncTopTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_sync_top_tip, "field 'ivSyncTopTip'", ImageView.class);
        newPatternActivity.tvSyncTopTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sync_top_tip, "field 'tvSyncTopTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_sync_top_tip, "field 'rlSyncTopTip' and method 'onViewClicked'");
        newPatternActivity.rlSyncTopTip = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.rl_sync_top_tip, "field 'rlSyncTopTip'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, newPatternActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewPatternActivity newPatternActivity = this.a;
        if (newPatternActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newPatternActivity.choosePatternsNotice = null;
        newPatternActivity.actionBar = null;
        newPatternActivity.flContent = null;
        newPatternActivity.ivSyncTopTip = null;
        newPatternActivity.tvSyncTopTip = null;
        newPatternActivity.rlSyncTopTip = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
