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
public final class PopVocieStartBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    public PopVocieStartBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = textView;
    }

    @NonNull
    public static PopVocieStartBinding a(@NonNull View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            i = R.id.tv_tips;
            TextView textView = (TextView) view.findViewById(R.id.tv_tips);
            if (textView != null) {
                return new PopVocieStartBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static PopVocieStartBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopVocieStartBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pop_vocie_start, viewGroup, false);
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
