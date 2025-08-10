package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import skin.support.widget.SkinTableLayout;

/* loaded from: classes3.dex */
public final class PopupChatItemMenuBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final SkinTableLayout b;

    public PopupChatItemMenuBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SkinTableLayout skinTableLayout) {
        this.a = constraintLayout;
        this.b = skinTableLayout;
    }

    @NonNull
    public static PopupChatItemMenuBinding a(@NonNull View view) {
        SkinTableLayout skinTableLayout = (SkinTableLayout) view.findViewById(R.id.table_layout);
        if (skinTableLayout != null) {
            return new PopupChatItemMenuBinding((ConstraintLayout) view, skinTableLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.table_layout)));
    }

    @NonNull
    public static PopupChatItemMenuBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopupChatItemMenuBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_chat_item_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
