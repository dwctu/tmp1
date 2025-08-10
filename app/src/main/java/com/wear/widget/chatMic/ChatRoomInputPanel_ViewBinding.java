package com.wear.widget.chatMic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.widget.BaseImageButton;
import com.wear.widget.RadiuImageView;

/* loaded from: classes4.dex */
public class ChatRoomInputPanel_ViewBinding implements Unbinder {
    public ChatRoomInputPanel a;

    @UiThread
    public ChatRoomInputPanel_ViewBinding(ChatRoomInputPanel chatRoomInputPanel, View view) {
        this.a = chatRoomInputPanel;
        chatRoomInputPanel.chat_voice = (BaseImageButton) Utils.findRequiredViewAsType(view, R.id.btn_chat_voice, "field 'chat_voice'", BaseImageButton.class);
        chatRoomInputPanel.ll_reply = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_reply, "field 'll_reply'", LinearLayout.class);
        chatRoomInputPanel.tv_reply_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reply_name, "field 'tv_reply_name'", TextView.class);
        chatRoomInputPanel.tv_reply_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reply_content, "field 'tv_reply_content'", TextView.class);
        chatRoomInputPanel.iv_close_reply = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close_reply, "field 'iv_close_reply'", ImageView.class);
        chatRoomInputPanel.miv_reply_user_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_picture, "field 'miv_reply_user_picture'", RadiuImageView.class);
        chatRoomInputPanel.rl_reply_video = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_reply_video, "field 'rl_reply_video'", RelativeLayout.class);
        chatRoomInputPanel.miv_reply_user_video_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_video_picture, "field 'miv_reply_user_video_picture'", RadiuImageView.class);
        chatRoomInputPanel.ll_reply_voice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_reply_voice, "field 'll_reply_voice'", LinearLayout.class);
        chatRoomInputPanel.reply_voice_icon = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.reply_voice_icon, "field 'reply_voice_icon'", LottieAnimationView.class);
        chatRoomInputPanel.reply_voice_time = (TextView) Utils.findRequiredViewAsType(view, R.id.reply_voice_time, "field 'reply_voice_time'", TextView.class);
        chatRoomInputPanel.voiceMessagePanelView = (VoiceMessagePanelView) Utils.findRequiredViewAsType(view, R.id.voice_message_panel_view, "field 'voiceMessagePanelView'", VoiceMessagePanelView.class);
        chatRoomInputPanel.ll_chat_input_panel = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.ll_chat_input_panel, "field 'll_chat_input_panel'", ViewGroup.class);
        chatRoomInputPanel.chatMessageContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.chat_message_container, "field 'chatMessageContainer'", ViewGroup.class);
        chatRoomInputPanel.rlChatInputPanel = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.rl_send_message, "field 'rlChatInputPanel'", ViewGroup.class);
        chatRoomInputPanel.chatPicture = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_pictures, "field 'chatPicture'", ImageView.class);
        chatRoomInputPanel.chatSend = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_chat_send, "field 'chatSend'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatRoomInputPanel chatRoomInputPanel = this.a;
        if (chatRoomInputPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatRoomInputPanel.chat_voice = null;
        chatRoomInputPanel.ll_reply = null;
        chatRoomInputPanel.tv_reply_name = null;
        chatRoomInputPanel.tv_reply_content = null;
        chatRoomInputPanel.iv_close_reply = null;
        chatRoomInputPanel.miv_reply_user_picture = null;
        chatRoomInputPanel.rl_reply_video = null;
        chatRoomInputPanel.miv_reply_user_video_picture = null;
        chatRoomInputPanel.ll_reply_voice = null;
        chatRoomInputPanel.reply_voice_icon = null;
        chatRoomInputPanel.reply_voice_time = null;
        chatRoomInputPanel.voiceMessagePanelView = null;
        chatRoomInputPanel.ll_chat_input_panel = null;
        chatRoomInputPanel.chatMessageContainer = null;
        chatRoomInputPanel.rlChatInputPanel = null;
        chatRoomInputPanel.chatPicture = null;
        chatRoomInputPanel.chatSend = null;
    }
}
