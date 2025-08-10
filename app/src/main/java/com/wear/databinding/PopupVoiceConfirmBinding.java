package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class PopupVoiceConfirmBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public PopupVoiceConfirmBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
    }

    @NonNull
    public static PopupVoiceConfirmBinding a(@NonNull View view) {
        int i = R.id.iv_bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
        if (imageView != null) {
            i = R.id.tv_cancel;
            TextView textView = (TextView) view.findViewById(R.id.tv_cancel);
            if (textView != null) {
                i = R.id.tv_confirm;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_confirm);
                if (textView2 != null) {
                    i = R.id.tv_confirm_title;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_confirm_title);
                    if (textView3 != null) {
                        return new PopupVoiceConfirmBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static PopupVoiceConfirmBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopupVoiceConfirmBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_voice_confirm, viewGroup, false);
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
