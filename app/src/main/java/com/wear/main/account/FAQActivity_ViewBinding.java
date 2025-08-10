package com.wear.main.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class FAQActivity_ViewBinding implements Unbinder {
    public FAQActivity a;

    @UiThread
    public FAQActivity_ViewBinding(FAQActivity fAQActivity, View view) {
        this.a = fAQActivity;
        fAQActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        fAQActivity.pattern_list = (ListView) Utils.findRequiredViewAsType(view, R.id.pattern_list, "field 'pattern_list'", ListView.class);
        fAQActivity.swipeRefreshLayout = (SwipyRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_pattern, "field 'swipeRefreshLayout'", SwipyRefreshLayout.class);
        fAQActivity.patternListEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty_text, "field 'patternListEmptyText'", TextView.class);
        fAQActivity.patternListEmptyTip = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty_tip, "field 'patternListEmptyTip'", TextView.class);
        fAQActivity.emptyView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'emptyView'", LinearLayout.class);
        fAQActivity.loading_layer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading_layer, "field 'loading_layer'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FAQActivity fAQActivity = this.a;
        if (fAQActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fAQActivity.actionbar = null;
        fAQActivity.pattern_list = null;
        fAQActivity.swipeRefreshLayout = null;
        fAQActivity.patternListEmptyText = null;
        fAQActivity.patternListEmptyTip = null;
        fAQActivity.emptyView = null;
        fAQActivity.loading_layer = null;
    }
}
