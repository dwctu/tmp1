package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import skin.support.widget.SkinCompatImageView;

/* loaded from: classes3.dex */
public final class PopupRouletteNoToyBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final ConstraintLayout b;

    public PopupRouletteNoToyBinding(@NonNull LinearLayout linearLayout, @NonNull SkinCompatImageView skinCompatImageView, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = constraintLayout;
    }

    @NonNull
    public static PopupRouletteNoToyBinding a(@NonNull View view) {
        int i = R.id.actionbar_yew_image_btn;
        SkinCompatImageView skinCompatImageView = (SkinCompatImageView) view.findViewById(R.id.actionbar_yew_image_btn);
        if (skinCompatImageView != null) {
            i = R.id.container;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container);
            if (constraintLayout != null) {
                i = R.id.container_child;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.container_child);
                if (frameLayout != null) {
                    return new PopupRouletteNoToyBinding((LinearLayout) view, skinCompatImageView, constraintLayout, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static PopupRouletteNoToyBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopupRouletteNoToyBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_roulette_no_toy, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
