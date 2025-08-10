package com.wear.widget.chatMic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.bh0;
import dc.zg0;

/* loaded from: classes4.dex */
public class NewChatEmojisPanel extends LinearLayout implements zg0 {
    public View a;

    public NewChatEmojisPanel(Context context) {
        this(context, null);
    }

    public int getPanelHeight() {
        return bh0.h.b();
    }

    @Override // dc.zg0
    public void reset() {
    }

    public void setFavoriteLayoutVisible(boolean z) {
        this.a.setVisibility(z ? 0 : 8);
    }

    public NewChatEmojisPanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewChatEmojisPanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.long_chat_emojis_layer, (ViewGroup) this, true);
        this.a = findViewById(R.id.favorite_image_panel);
    }
}
