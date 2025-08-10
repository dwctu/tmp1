package com.wear.ui.discover.pattern;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class PatternUserActivity_ViewBinding implements Unbinder {
    public PatternUserActivity a;

    @UiThread
    public PatternUserActivity_ViewBinding(PatternUserActivity patternUserActivity, View view) {
        this.a = patternUserActivity;
        patternUserActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        patternUserActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternUserActivity patternUserActivity = this.a;
        if (patternUserActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternUserActivity.actionbar = null;
        patternUserActivity.recyclerView = null;
    }
}
