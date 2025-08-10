package com.wear.widget.chatMic;

import android.animation.LayoutTransition;
import android.content.Context;
import android.media.MediaRecorder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.widget.ChatEditText;
import com.wear.widget.RadiuImageView;
import com.wear.widget.chatMic.VoiceMessagePanelView;

/* loaded from: classes4.dex */
public class ChatInputPanel extends ChatInputPanelPto {

    @BindView(R.id.chat_message_container)
    public ViewGroup chatMessageContainer;

    @BindView(R.id.chat_pictures)
    public ImageView chatPicture;

    @BindView(R.id.chat_send)
    public ImageView chatSend;

    @BindView(R.id.chat_emojis)
    public ImageView chat_emojis;

    @BindView(R.id.chat_message)
    public ChatEditText chat_message;

    @BindView(R.id.chat_more)
    public ImageView chat_more;

    @BindView(R.id.chat_voice)
    public ImageView chat_voice;

    @BindView(R.id.iv_close_reply)
    public ImageView iv_close_reply;

    @BindView(R.id.ll_chat_input_panel)
    public ViewGroup ll_chat_input_panel;

    @BindView(R.id.ll_reply)
    public LinearLayout ll_reply;

    @BindView(R.id.ll_reply_voice)
    public LinearLayout ll_reply_voice;

    @BindView(R.id.miv_reply_user_picture)
    public RadiuImageView miv_reply_user_picture;

    @BindView(R.id.miv_reply_user_video_picture)
    public RadiuImageView miv_reply_user_video_picture;

    @BindView(R.id.reply_voice_icon)
    public LottieAnimationView reply_voice_icon;

    @BindView(R.id.reply_voice_time)
    public TextView reply_voice_time;

    @BindView(R.id.rl_chat_input_panel)
    public ViewGroup rlChatInputPanel;

    @BindView(R.id.rl_reply_video)
    public RelativeLayout rl_reply_video;

    @BindView(R.id.tv_reply_content)
    public TextView tv_reply_content;

    @BindView(R.id.tv_reply_name)
    public TextView tv_reply_name;

    @BindView(R.id.v_block_tip)
    public View v_block_tip;

    @BindView(R.id.voice_message_panel_view)
    public VoiceMessagePanelView voiceMessagePanelView;

    public ChatInputPanel(Context context) {
        this(context, null);
    }

    public ViewGroup getChatMessageContainer() {
        return this.chatMessageContainer;
    }

    public ImageView getChatPicture() {
        return this.chatPicture;
    }

    public ImageView getChatSend() {
        return this.chatSend;
    }

    public ImageView getChat_emojis() {
        return this.chat_emojis;
    }

    public ChatEditText getChat_message() {
        return this.chat_message;
    }

    public ImageView getChat_more() {
        return this.chat_more;
    }

    public ImageView getChat_voice() {
        return this.chat_voice;
    }

    public ImageView getIv_close_reply() {
        return this.iv_close_reply;
    }

    public LinearLayout getLl_reply() {
        return this.ll_reply;
    }

    public LinearLayout getLl_reply_voice() {
        return this.ll_reply_voice;
    }

    public RadiuImageView getMiv_reply_user_picture() {
        return this.miv_reply_user_picture;
    }

    public RadiuImageView getMiv_reply_user_video_picture() {
        return this.miv_reply_user_video_picture;
    }

    public LottieAnimationView getReply_voice_icon() {
        return this.reply_voice_icon;
    }

    public TextView getReply_voice_time() {
        return this.reply_voice_time;
    }

    public RelativeLayout getRl_reply_video() {
        return this.rl_reply_video;
    }

    public TextView getTv_reply_content() {
        return this.tv_reply_content;
    }

    public TextView getTv_reply_name() {
        return this.tv_reply_name;
    }

    public View getV_block_tip() {
        return this.v_block_tip;
    }

    public void p(MediaRecorder mediaRecorder) {
        this.voiceMessagePanelView.k(mediaRecorder);
    }

    public void q(VoiceMessagePanelView.b bVar) {
        this.voiceMessagePanelView.setRecordActionListener(bVar);
    }

    public void r() {
        this.voiceMessagePanelView.l();
    }

    public void s(ViewGroup viewGroup) {
        this.voiceMessagePanelView.p(this.ll_chat_input_panel, viewGroup, false);
    }

    public void setChatPictureHidden() {
        this.chatPicture.setVisibility(8);
    }

    public ChatInputPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatInputPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(R.layout.layout_chat_input_panel, (ViewGroup) this, true));
        LayoutTransition layoutTransition = this.rlChatInputPanel.getLayoutTransition();
        layoutTransition.disableTransitionType(2);
        layoutTransition.disableTransitionType(3);
        this.voiceMessagePanelView.h(this.chat_voice);
    }
}
