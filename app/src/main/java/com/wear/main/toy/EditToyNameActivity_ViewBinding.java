package com.wear.main.toy;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class EditToyNameActivity_ViewBinding implements Unbinder {
    public EditToyNameActivity a;

    @UiThread
    public EditToyNameActivity_ViewBinding(EditToyNameActivity editToyNameActivity, View view) {
        this.a = editToyNameActivity;
        editToyNameActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        editToyNameActivity.currentNickname = (EditText) Utils.findRequiredViewAsType(view, R.id.current_nickname, "field 'currentNickname'", EditText.class);
        editToyNameActivity.tvToyNote = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toy_note, "field 'tvToyNote'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditToyNameActivity editToyNameActivity = this.a;
        if (editToyNameActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editToyNameActivity.actionbar = null;
        editToyNameActivity.currentNickname = null;
        editToyNameActivity.tvToyNote = null;
    }
}
