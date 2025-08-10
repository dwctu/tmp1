package com.wear.ui.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class BlockListFragment_ViewBinding implements Unbinder {
    public BlockListFragment a;

    @UiThread
    public BlockListFragment_ViewBinding(BlockListFragment blockListFragment, View view) {
        this.a = blockListFragment;
        blockListFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BlockListFragment blockListFragment = this.a;
        if (blockListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        blockListFragment.rvList = null;
    }
}
