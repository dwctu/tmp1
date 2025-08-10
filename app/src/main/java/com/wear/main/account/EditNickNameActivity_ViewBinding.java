package com.wear.main.account;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class EditNickNameActivity_ViewBinding implements Unbinder {
    public EditNickNameActivity a;

    @UiThread
    public EditNickNameActivity_ViewBinding(EditNickNameActivity editNickNameActivity, View view) {
        this.a = editNickNameActivity;
        editNickNameActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        editNickNameActivity.currentNickname = (EditText) Utils.findRequiredViewAsType(view, R.id.current_nickname, "field 'currentNickname'", EditText.class);
        editNickNameActivity.contentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.content_delete, "field 'contentDelete'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditNickNameActivity editNickNameActivity = this.a;
        if (editNickNameActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editNickNameActivity.actionbar = null;
        editNickNameActivity.currentNickname = null;
        editNickNameActivity.contentDelete = null;
    }
}
