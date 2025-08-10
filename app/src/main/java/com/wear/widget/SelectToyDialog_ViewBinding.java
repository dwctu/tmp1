package com.wear.widget;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class SelectToyDialog_ViewBinding implements Unbinder {
    public SelectToyDialog a;

    @UiThread
    public SelectToyDialog_ViewBinding(SelectToyDialog selectToyDialog, View view) {
        this.a = selectToyDialog;
        selectToyDialog.connectedRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.connectedRecyclerView, "field 'connectedRecyclerView'", RecyclerView.class);
        selectToyDialog.disconnectedRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.disconnectedRecyclerView, "field 'disconnectedRecyclerView'", RecyclerView.class);
        selectToyDialog.cancelBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel_btn, "field 'cancelBtn'", TextView.class);
        selectToyDialog.okBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.ok_btn, "field 'okBtn'", TextView.class);
        selectToyDialog.leftTitle1 = (TextView) Utils.findRequiredViewAsType(view, R.id.left_title_1, "field 'leftTitle1'", TextView.class);
        selectToyDialog.leftTitle2 = (TextView) Utils.findRequiredViewAsType(view, R.id.left_title_2, "field 'leftTitle2'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SelectToyDialog selectToyDialog = this.a;
        if (selectToyDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        selectToyDialog.connectedRecyclerView = null;
        selectToyDialog.disconnectedRecyclerView = null;
        selectToyDialog.cancelBtn = null;
        selectToyDialog.okBtn = null;
        selectToyDialog.leftTitle1 = null;
        selectToyDialog.leftTitle2 = null;
    }
}
