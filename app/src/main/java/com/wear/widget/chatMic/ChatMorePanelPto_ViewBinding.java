package com.wear.widget.chatMic;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChatMorePanelPto_ViewBinding implements Unbinder {
    public ChatMorePanelPto a;

    @UiThread
    public ChatMorePanelPto_ViewBinding(ChatMorePanelPto chatMorePanelPto, View view) {
        this.a = chatMorePanelPto;
        chatMorePanelPto.long_chat_more_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.long_chat_more_layout, "field 'long_chat_more_layout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMorePanelPto chatMorePanelPto = this.a;
        if (chatMorePanelPto == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMorePanelPto.long_chat_more_layout = null;
    }
}
