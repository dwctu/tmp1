package com.wear.widget.chatMic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import dc.bh0;
import dc.zg0;

/* loaded from: classes4.dex */
public class ChatEmojisPanel extends LinearLayout implements zg0 {

    @BindView(R.id.chat_emojis_panel_layout)
    public LinearLayout long_chat_emojis_layout;

    public ChatEmojisPanel(Context context) {
        this(context, null);
    }

    public int getPanelHeight() {
        return bh0.h.b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = bh0.h.b();
            setLayoutParams(layoutParams);
        }
    }

    @Override // dc.zg0
    public void reset() {
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.long_chat_emojis_layout.getLayoutParams();
        layoutParams.height = i;
        this.long_chat_emojis_layout.setLayoutParams(layoutParams);
    }

    public ChatEmojisPanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatEmojisPanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(R.layout.long_chat_emojis_layer, (ViewGroup) this, true));
    }
}
