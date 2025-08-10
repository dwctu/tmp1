package com.wear.widget.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes4.dex */
public class FFBasicMsgSelectDialog_ViewBinding implements Unbinder {
    public FFBasicMsgSelectDialog a;

    @UiThread
    public FFBasicMsgSelectDialog_ViewBinding(FFBasicMsgSelectDialog fFBasicMsgSelectDialog, View view) {
        this.a = fFBasicMsgSelectDialog;
        fFBasicMsgSelectDialog.tvTitle = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", MediumBoldTextView.class);
        fFBasicMsgSelectDialog.rvSelect = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_select, "field 'rvSelect'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FFBasicMsgSelectDialog fFBasicMsgSelectDialog = this.a;
        if (fFBasicMsgSelectDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fFBasicMsgSelectDialog.tvTitle = null;
        fFBasicMsgSelectDialog.rvSelect = null;
    }
}
