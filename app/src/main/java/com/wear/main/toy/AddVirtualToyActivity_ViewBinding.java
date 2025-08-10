package com.wear.main.toy;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class AddVirtualToyActivity_ViewBinding implements Unbinder {
    public AddVirtualToyActivity a;

    @UiThread
    public AddVirtualToyActivity_ViewBinding(AddVirtualToyActivity addVirtualToyActivity, View view) {
        this.a = addVirtualToyActivity;
        addVirtualToyActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddVirtualToyActivity addVirtualToyActivity = this.a;
        if (addVirtualToyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        addVirtualToyActivity.recyclerView = null;
    }
}
