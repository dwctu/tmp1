package com.wear.main.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class BlockListActivity_ViewBinding implements Unbinder {
    public BlockListActivity a;

    @UiThread
    public BlockListActivity_ViewBinding(BlockListActivity blockListActivity, View view) {
        this.a = blockListActivity;
        blockListActivity.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BlockListActivity blockListActivity = this.a;
        if (blockListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        blockListActivity.rvList = null;
    }
}
