package com.wear.widget.chatMic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ChatRoomMorePanel extends ChatMorePanelPto {
    public ChatRoomMorePanel(Context context) {
        this(context, null);
    }

    public ChatRoomMorePanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatRoomMorePanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(R.layout.v_chat_room_menu, (ViewGroup) this, true));
    }
}
