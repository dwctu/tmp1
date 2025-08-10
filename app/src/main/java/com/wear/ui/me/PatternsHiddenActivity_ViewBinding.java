package com.wear.ui.me;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.wear.widget.MyActionBar;

/* loaded from: classes4.dex */
public class PatternsHiddenActivity_ViewBinding implements Unbinder {
    public PatternsHiddenActivity a;

    @UiThread
    public PatternsHiddenActivity_ViewBinding(PatternsHiddenActivity patternsHiddenActivity, View view) {
        this.a = patternsHiddenActivity;
        patternsHiddenActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        patternsHiddenActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.pattern_recylerview, "field 'mRecyclerView'", RecyclerView.class);
        patternsHiddenActivity.mSwipeRefreshPattern = (SwipyRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_pattern, "field 'mSwipeRefreshPattern'", SwipyRefreshLayout.class);
        patternsHiddenActivity.mllEmpty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'mllEmpty'", RelativeLayout.class);
        patternsHiddenActivity.pattern_list_empty_text = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty_text, "field 'pattern_list_empty_text'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternsHiddenActivity patternsHiddenActivity = this.a;
        if (patternsHiddenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternsHiddenActivity.actionbar = null;
        patternsHiddenActivity.mRecyclerView = null;
        patternsHiddenActivity.mSwipeRefreshPattern = null;
        patternsHiddenActivity.mllEmpty = null;
        patternsHiddenActivity.pattern_list_empty_text = null;
    }
}
