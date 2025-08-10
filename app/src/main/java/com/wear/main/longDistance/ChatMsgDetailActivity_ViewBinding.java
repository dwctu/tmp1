package com.wear.main.longDistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ChatMsgDetailActivity_ViewBinding implements Unbinder {
    public ChatMsgDetailActivity a;

    @UiThread
    public ChatMsgDetailActivity_ViewBinding(ChatMsgDetailActivity chatMsgDetailActivity, View view) {
        this.a = chatMsgDetailActivity;
        chatMsgDetailActivity.tv_msg_detail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg_detail, "field 'tv_msg_detail'", TextView.class);
        chatMsgDetailActivity.iv_rootbg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_rootbg, "field 'iv_rootbg'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMsgDetailActivity chatMsgDetailActivity = this.a;
        if (chatMsgDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMsgDetailActivity.tv_msg_detail = null;
        chatMsgDetailActivity.iv_rootbg = null;
    }
}
