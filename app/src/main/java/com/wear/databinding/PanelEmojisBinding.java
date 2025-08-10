package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.chatMic.NewChatEmojisPanel;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class PanelEmojisBinding implements ViewBinding {

    @NonNull
    public final NewChatEmojisPanel a;

    public PanelEmojisBinding(@NonNull NewChatEmojisPanel newChatEmojisPanel) {
        this.a = newChatEmojisPanel;
    }

    @NonNull
    public static PanelEmojisBinding a(@NonNull View view) {
        Objects.requireNonNull(view, "rootView");
        return new PanelEmojisBinding((NewChatEmojisPanel) view);
    }

    @NonNull
    public static PanelEmojisBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.panel_emojis, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NewChatEmojisPanel getRoot() {
        return this.a;
    }
}
