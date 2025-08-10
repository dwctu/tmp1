package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public final class DialogUiStandardBaseBinding implements ViewBinding {

    @NonNull
    public final SkinRoundConstraintLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final SkinRoundTextView c;

    @NonNull
    public final SkinRoundTextView d;

    public DialogUiStandardBaseBinding(@NonNull SkinRoundConstraintLayout skinRoundConstraintLayout, @NonNull TextView textView, @NonNull SkinRoundTextView skinRoundTextView, @NonNull SkinRoundTextView skinRoundTextView2, @NonNull TextView textView2) {
        this.a = skinRoundConstraintLayout;
        this.b = textView;
        this.c = skinRoundTextView;
        this.d = skinRoundTextView2;
    }

    @NonNull
    public static DialogUiStandardBaseBinding a(@NonNull View view) {
        int i = R.id.tv_content;
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        if (textView != null) {
            i = R.id.tv_negative;
            SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.tv_negative);
            if (skinRoundTextView != null) {
                i = R.id.tv_positive;
                SkinRoundTextView skinRoundTextView2 = (SkinRoundTextView) view.findViewById(R.id.tv_positive);
                if (skinRoundTextView2 != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        return new DialogUiStandardBaseBinding((SkinRoundConstraintLayout) view, textView, skinRoundTextView, skinRoundTextView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogUiStandardBaseBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiStandardBaseBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_ui_standard_base, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinRoundConstraintLayout getRoot() {
        return this.a;
    }
}
