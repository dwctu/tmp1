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
import com.wear.widget.ChatEditText;
import com.wear.widget.RadiuImageView;

/* loaded from: classes4.dex */
public class ChatInputPanel_ViewBinding implements Unbinder {
    public ChatInputPanel a;

    @UiThread
    public ChatInputPanel_ViewBinding(ChatInputPanel chatInputPanel, View view) {
        this.a = chatInputPanel;
        chatInputPanel.chat_voice = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_voice, "field 'chat_voice'", ImageView.class);
        chatInputPanel.chat_more = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_more, "field 'chat_more'", ImageView.class);
        chatInputPanel.chatPicture = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_pictures, "field 'chatPicture'", ImageView.class);
        chatInputPanel.chat_emojis = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_emojis, "field 'chat_emojis'", ImageView.class);
        chatInputPanel.chat_message = (ChatEditText) Utils.findRequiredViewAsType(view, R.id.chat_message, "field 'chat_message'", ChatEditText.class);
        chatInputPanel.v_block_tip = Utils.findRequiredView(view, R.id.v_block_tip, "field 'v_block_tip'");
        chatInputPanel.ll_reply = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_reply, "field 'll_reply'", LinearLayout.class);
        chatInputPanel.tv_reply_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reply_name, "field 'tv_reply_name'", TextView.class);
        chatInputPanel.tv_reply_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reply_content, "field 'tv_reply_content'", TextView.class);
        chatInputPanel.iv_close_reply = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close_reply, "field 'iv_close_reply'", ImageView.class);
        chatInputPanel.miv_reply_user_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_picture, "field 'miv_reply_user_picture'", RadiuImageView.class);
        chatInputPanel.rl_reply_video = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_reply_video, "field 'rl_reply_video'", RelativeLayout.class);
        chatInputPanel.miv_reply_user_video_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_video_picture, "field 'miv_reply_user_video_picture'", RadiuImageView.class);
        chatInputPanel.ll_reply_voice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_reply_voice, "field 'll_reply_voice'", LinearLayout.class);
        chatInputPanel.reply_voice_icon = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.reply_voice_icon, "field 'reply_voice_icon'", LottieAnimationView.class);
        chatInputPanel.reply_voice_time = (TextView) Utils.findRequiredViewAsType(view, R.id.reply_voice_time, "field 'reply_voice_time'", TextView.class);
        chatInputPanel.voiceMessagePanelView = (VoiceMessagePanelView) Utils.findRequiredViewAsType(view, R.id.voice_message_panel_view, "field 'voiceMessagePanelView'", VoiceMessagePanelView.class);
        chatInputPanel.ll_chat_input_panel = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.ll_chat_input_panel, "field 'll_chat_input_panel'", ViewGroup.class);
        chatInputPanel.rlChatInputPanel = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.rl_chat_input_panel, "field 'rlChatInputPanel'", ViewGroup.class);
        chatInputPanel.chatMessageContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.chat_message_container, "field 'chatMessageContainer'", ViewGroup.class);
        chatInputPanel.chatSend = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_send, "field 'chatSend'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatInputPanel chatInputPanel = this.a;
        if (chatInputPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatInputPanel.chat_voice = null;
        chatInputPanel.chat_more = null;
        chatInputPanel.chatPicture = null;
        chatInputPanel.chat_emojis = null;
        chatInputPanel.chat_message = null;
        chatInputPanel.v_block_tip = null;
        chatInputPanel.ll_reply = null;
        chatInputPanel.tv_reply_name = null;
        chatInputPanel.tv_reply_content = null;
        chatInputPanel.iv_close_reply = null;
        chatInputPanel.miv_reply_user_picture = null;
        chatInputPanel.rl_reply_video = null;
        chatInputPanel.miv_reply_user_video_picture = null;
        chatInputPanel.ll_reply_voice = null;
        chatInputPanel.reply_voice_icon = null;
        chatInputPanel.reply_voice_time = null;
        chatInputPanel.voiceMessagePanelView = null;
        chatInputPanel.ll_chat_input_panel = null;
        chatInputPanel.rlChatInputPanel = null;
        chatInputPanel.chatMessageContainer = null;
        chatInputPanel.chatSend = null;
    }
}
