package com.wear.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.wear.ui.chat.pancel.helper.view.pannel.PanelContainer;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class PanelChatContainerBinding implements ViewBinding {

    @NonNull
    public final PanelContainer a;

    public PanelChatContainerBinding(@NonNull PanelContainer panelContainer, @NonNull PanelContainer panelContainer2) {
        this.a = panelContainer;
    }

    @NonNull
    public static PanelChatContainerBinding a(@NonNull View view) {
        Objects.requireNonNull(view, "rootView");
        PanelContainer panelContainer = (PanelContainer) view;
        return new PanelChatContainerBinding(panelContainer, panelContainer);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PanelContainer getRoot() {
        return this.a;
    }
}
