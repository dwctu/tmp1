package com.wear.widget.chatMic;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChatEmojisPanel_ViewBinding implements Unbinder {
    public ChatEmojisPanel a;

    @UiThread
    public ChatEmojisPanel_ViewBinding(ChatEmojisPanel chatEmojisPanel, View view) {
        this.a = chatEmojisPanel;
        chatEmojisPanel.long_chat_emojis_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.chat_emojis_panel_layout, "field 'long_chat_emojis_layout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatEmojisPanel chatEmojisPanel = this.a;
        if (chatEmojisPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatEmojisPanel.long_chat_emojis_layout = null;
    }
}
