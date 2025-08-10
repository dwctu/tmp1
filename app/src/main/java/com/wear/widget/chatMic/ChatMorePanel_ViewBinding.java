package com.wear.widget.chatMic;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.UiThread;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChatMorePanel_ViewBinding extends ChatMorePanelPto_ViewBinding {
    public ChatMorePanel b;

    @UiThread
    public ChatMorePanel_ViewBinding(ChatMorePanel chatMorePanel, View view) {
        super(chatMorePanel, view);
        this.b = chatMorePanel;
        chatMorePanel.long_chat_more_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.long_chat_more_layout, "field 'long_chat_more_layout'", LinearLayout.class);
        chatMorePanel.chat_more_liveControl = Utils.findRequiredView(view, R.id.chat_more_liveControl, "field 'chat_more_liveControl'");
        chatMorePanel.chat_more_sync = Utils.findRequiredView(view, R.id.chat_more_sync, "field 'chat_more_sync'");
        chatMorePanel.chat_more_video = Utils.findRequiredView(view, R.id.chat_more_video, "field 'chat_more_video'");
        chatMorePanel.chat_more_voice = Utils.findRequiredView(view, R.id.chat_more_voice, "field 'chat_more_voice'");
        chatMorePanel.chat_more_sendPattern = Utils.findRequiredView(view, R.id.chat_more_sendPattern, "field 'chat_more_sendPattern'");
        chatMorePanel.chat_more_sendPicture = Utils.findRequiredView(view, R.id.chat_more_sendPicture, "field 'chat_more_sendPicture'");
        chatMorePanel.chat_more_alarm = Utils.findRequiredView(view, R.id.chat_more_alarm, "field 'chat_more_alarm'");
        chatMorePanel.chat_more_dialog = Utils.findRequiredView(view, R.id.chat_more_dialog, "field 'chat_more_dialog'");
    }

    @Override // com.wear.widget.chatMic.ChatMorePanelPto_ViewBinding, butterknife.Unbinder
    public void unbind() {
        ChatMorePanel chatMorePanel = this.b;
        if (chatMorePanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        chatMorePanel.long_chat_more_layout = null;
        chatMorePanel.chat_more_liveControl = null;
        chatMorePanel.chat_more_sync = null;
        chatMorePanel.chat_more_video = null;
        chatMorePanel.chat_more_voice = null;
        chatMorePanel.chat_more_sendPattern = null;
        chatMorePanel.chat_more_sendPicture = null;
        chatMorePanel.chat_more_alarm = null;
        chatMorePanel.chat_more_dialog = null;
        super.unbind();
    }
}
