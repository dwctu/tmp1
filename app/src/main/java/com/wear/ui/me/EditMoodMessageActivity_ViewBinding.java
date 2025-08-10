package com.wear.ui.me;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes4.dex */
public class EditMoodMessageActivity_ViewBinding implements Unbinder {
    public EditMoodMessageActivity a;

    @UiThread
    public EditMoodMessageActivity_ViewBinding(EditMoodMessageActivity editMoodMessageActivity, View view) {
        this.a = editMoodMessageActivity;
        editMoodMessageActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        editMoodMessageActivity.currentMoodMessage = (EditText) Utils.findRequiredViewAsType(view, R.id.current_mood_message, "field 'currentMoodMessage'", EditText.class);
        editMoodMessageActivity.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditMoodMessageActivity editMoodMessageActivity = this.a;
        if (editMoodMessageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editMoodMessageActivity.actionbar = null;
        editMoodMessageActivity.currentMoodMessage = null;
        editMoodMessageActivity.tvCount = null;
    }
}
