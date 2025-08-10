package com.wear.widget.chatMic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChatMorePanel extends ChatMorePanelPto {

    @BindView(R.id.chat_more_alarm)
    public View chat_more_alarm;

    @BindView(R.id.chat_more_dialog)
    public View chat_more_dialog;

    @BindView(R.id.chat_more_liveControl)
    public View chat_more_liveControl;

    @BindView(R.id.chat_more_sendPattern)
    public View chat_more_sendPattern;

    @BindView(R.id.chat_more_sendPicture)
    public View chat_more_sendPicture;

    @BindView(R.id.chat_more_sync)
    public View chat_more_sync;

    @BindView(R.id.chat_more_video)
    public View chat_more_video;

    @BindView(R.id.chat_more_voice)
    public View chat_more_voice;

    @BindView(R.id.long_chat_more_layout)
    public LinearLayout long_chat_more_layout;

    public ChatMorePanel(Context context) {
        this(context, null);
    }

    public View getChat_more_alarm() {
        return this.chat_more_alarm;
    }

    public View getChat_more_dialog() {
        return this.chat_more_dialog;
    }

    public View getChat_more_liveControl() {
        return this.chat_more_liveControl;
    }

    public View getChat_more_sendPattern() {
        return this.chat_more_sendPattern;
    }

    public View getChat_more_sendPicture() {
        return this.chat_more_sendPicture;
    }

    public View getChat_more_sync() {
        return this.chat_more_sync;
    }

    public View getChat_more_video() {
        return this.chat_more_video;
    }

    public View getChat_more_voice() {
        return this.chat_more_voice;
    }

    public ChatMorePanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatMorePanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(R.layout.long_chat_more_layer, (ViewGroup) this, true));
    }
}
