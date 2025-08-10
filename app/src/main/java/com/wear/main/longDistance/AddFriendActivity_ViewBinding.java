package com.wear.main.longDistance;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AddFriendActivity_ViewBinding implements Unbinder {
    public AddFriendActivity a;

    @UiThread
    public AddFriendActivity_ViewBinding(AddFriendActivity addFriendActivity, View view) {
        this.a = addFriendActivity;
        addFriendActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        addFriendActivity.longAddEmail = (EditText) Utils.findRequiredViewAsType(view, R.id.long_add_email, "field 'longAddEmail'", EditText.class);
        addFriendActivity.nameContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.name_content_delete, "field 'nameContentDelete'", ImageView.class);
        addFriendActivity.tvJoinDiscord = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_join_discord, "field 'tvJoinDiscord'", TextView.class);
        addFriendActivity.mTvInviteLink = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_invite_link, "field 'mTvInviteLink'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddFriendActivity addFriendActivity = this.a;
        if (addFriendActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        addFriendActivity.actionbar = null;
        addFriendActivity.longAddEmail = null;
        addFriendActivity.nameContentDelete = null;
        addFriendActivity.tvJoinDiscord = null;
        addFriendActivity.mTvInviteLink = null;
    }
}
