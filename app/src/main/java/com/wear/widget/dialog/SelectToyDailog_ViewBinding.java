package com.wear.widget.dialog;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class SelectToyDailog_ViewBinding implements Unbinder {
    public SelectToyDailog a;

    @UiThread
    public SelectToyDailog_ViewBinding(SelectToyDailog selectToyDailog, View view) {
        this.a = selectToyDailog;
        selectToyDailog.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        selectToyDailog.lvToys = (ListView) Utils.findRequiredViewAsType(view, R.id.lv_toys, "field 'lvToys'", ListView.class);
        selectToyDailog.tvConfirm = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SelectToyDailog selectToyDailog = this.a;
        if (selectToyDailog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        selectToyDailog.tvText = null;
        selectToyDailog.lvToys = null;
        selectToyDailog.tvConfirm = null;
    }
}
