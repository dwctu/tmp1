package com.wear.ui.discover.pattern;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes3.dex */
public class PatternsItemFragment_ViewBinding implements Unbinder {
    public PatternsItemFragment a;

    @UiThread
    public PatternsItemFragment_ViewBinding(PatternsItemFragment patternsItemFragment, View view) {
        this.a = patternsItemFragment;
        patternsItemFragment.patternRecylerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.pattern_recylerview, "field 'patternRecylerview'", RecyclerView.class);
        patternsItemFragment.swipeRefreshPattern = (SwipyRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_pattern, "field 'swipeRefreshPattern'", SwipyRefreshLayout.class);
        patternsItemFragment.pattern_list_empty_text = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty_text, "field 'pattern_list_empty_text'", TextView.class);
        patternsItemFragment.mTv_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTv_tip'", TextView.class);
        patternsItemFragment.emptyView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'emptyView'", LinearLayout.class);
        patternsItemFragment.loginPattern = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.login_patterns, "field 'loginPattern'", FrameLayout.class);
        patternsItemFragment.offlinePattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.offline_patterns, "field 'offlinePattern'", LinearLayout.class);
        patternsItemFragment.offlineLogin = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.offline_login, "field 'offlineLogin'", MediumBoldTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternsItemFragment patternsItemFragment = this.a;
        if (patternsItemFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternsItemFragment.patternRecylerview = null;
        patternsItemFragment.swipeRefreshPattern = null;
        patternsItemFragment.pattern_list_empty_text = null;
        patternsItemFragment.mTv_tip = null;
        patternsItemFragment.emptyView = null;
        patternsItemFragment.loginPattern = null;
        patternsItemFragment.offlinePattern = null;
        patternsItemFragment.offlineLogin = null;
    }
}
