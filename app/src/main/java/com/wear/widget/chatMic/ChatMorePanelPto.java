package com.wear.widget.chatMic;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.bh0;
import dc.zg0;

/* loaded from: classes4.dex */
public class ChatMorePanelPto extends LinearLayout implements zg0 {

    @BindView(R.id.long_chat_more_layout)
    public LinearLayout long_chat_more_layout;

    public ChatMorePanelPto(Context context) {
        super(context);
    }

    public int getPanelHeight() {
        return bh0.h.b();
    }

    @Override // dc.zg0
    public void reset() {
    }

    public void setHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.long_chat_more_layout.getLayoutParams();
        layoutParams.height = i;
        this.long_chat_more_layout.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ChatMorePanelPto(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatMorePanelPto(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
