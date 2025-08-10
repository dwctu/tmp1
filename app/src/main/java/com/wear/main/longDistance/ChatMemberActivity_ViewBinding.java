package com.wear.main.longDistance;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatMemberActivity_ViewBinding implements Unbinder {
    public ChatMemberActivity a;

    @UiThread
    public ChatMemberActivity_ViewBinding(ChatMemberActivity chatMemberActivity, View view) {
        this.a = chatMemberActivity;
        chatMemberActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        chatMemberActivity.contactList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.contact_list, "field 'contactList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMemberActivity chatMemberActivity = this.a;
        if (chatMemberActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMemberActivity.abTitle = null;
        chatMemberActivity.contactList = null;
    }
}
