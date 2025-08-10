package com.wear.main;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes3.dex */
public class VersionHistoryActivity_ViewBinding implements Unbinder {
    public VersionHistoryActivity a;

    @UiThread
    public VersionHistoryActivity_ViewBinding(VersionHistoryActivity versionHistoryActivity, View view) {
        this.a = versionHistoryActivity;
        versionHistoryActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        versionHistoryActivity.smartRefresh = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.smartRefresh, "field 'smartRefresh'", SmartRefreshLayout.class);
        versionHistoryActivity.description = (TextView) Utils.findRequiredViewAsType(view, R.id.description, "field 'description'", TextView.class);
        versionHistoryActivity.title = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", MediumBoldTextView.class);
        versionHistoryActivity.actionbarBack = (ImageButton) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbarBack'", ImageButton.class);
        versionHistoryActivity.backRelative = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.back_relative, "field 'backRelative'", RelativeLayout.class);
        versionHistoryActivity.bar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bar, "field 'bar'", RelativeLayout.class);
        versionHistoryActivity.scrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scrollView, "field 'scrollView'", ScrollView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VersionHistoryActivity versionHistoryActivity = this.a;
        if (versionHistoryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        versionHistoryActivity.recyclerView = null;
        versionHistoryActivity.smartRefresh = null;
        versionHistoryActivity.description = null;
        versionHistoryActivity.title = null;
        versionHistoryActivity.actionbarBack = null;
        versionHistoryActivity.backRelative = null;
        versionHistoryActivity.bar = null;
        versionHistoryActivity.scrollView = null;
    }
}
