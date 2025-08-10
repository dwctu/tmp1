package com.wear.main.longDistance.controllink;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ControlLinkDescriptionActivity_ViewBinding implements Unbinder {
    public ControlLinkDescriptionActivity a;

    @UiThread
    public ControlLinkDescriptionActivity_ViewBinding(ControlLinkDescriptionActivity controlLinkDescriptionActivity, View view) {
        this.a = controlLinkDescriptionActivity;
        controlLinkDescriptionActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.action_bar, "field 'actionBar'", MyActionBar.class);
        controlLinkDescriptionActivity.messageText = (EditText) Utils.findRequiredViewAsType(view, R.id.message_text, "field 'messageText'", EditText.class);
        controlLinkDescriptionActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkDescriptionActivity controlLinkDescriptionActivity = this.a;
        if (controlLinkDescriptionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkDescriptionActivity.actionBar = null;
        controlLinkDescriptionActivity.messageText = null;
        controlLinkDescriptionActivity.recyclerView = null;
    }
}
