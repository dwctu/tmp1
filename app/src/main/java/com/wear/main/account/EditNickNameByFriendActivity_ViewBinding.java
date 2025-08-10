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
public class EditNickNameByFriendActivity_ViewBinding implements Unbinder {
    public EditNickNameByFriendActivity a;

    @UiThread
    public EditNickNameByFriendActivity_ViewBinding(EditNickNameByFriendActivity editNickNameByFriendActivity, View view) {
        this.a = editNickNameByFriendActivity;
        editNickNameByFriendActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        editNickNameByFriendActivity.currentNickname = (EditText) Utils.findRequiredViewAsType(view, R.id.current_nickname, "field 'currentNickname'", EditText.class);
        editNickNameByFriendActivity.contentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.content_delete, "field 'contentDelete'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditNickNameByFriendActivity editNickNameByFriendActivity = this.a;
        if (editNickNameByFriendActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editNickNameByFriendActivity.actionbar = null;
        editNickNameByFriendActivity.currentNickname = null;
        editNickNameByFriendActivity.contentDelete = null;
    }
}
