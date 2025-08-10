package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public final class PopupRateBinding implements ViewBinding {

    @NonNull
    public final SkinRoundConstraintLayout a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SkinRoundAutoLinearLayout d;

    @NonNull
    public final SkinRoundAutoLinearLayout e;

    @NonNull
    public final LottieAnimationView f;

    @NonNull
    public final LottieAnimationView g;

    public PopupRateBinding(@NonNull SkinRoundConstraintLayout skinRoundConstraintLayout, @NonNull SkinRoundTextView skinRoundTextView, @NonNull ImageView imageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout2, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull TextView textView, @NonNull View view) {
        this.a = skinRoundConstraintLayout;
        this.b = skinRoundTextView;
        this.c = imageView;
        this.d = skinRoundAutoLinearLayout;
        this.e = skinRoundAutoLinearLayout2;
        this.f = lottieAnimationView;
        this.g = lottieAnimationView2;
    }

    @NonNull
    public static PopupRateBinding a(@NonNull View view) {
        int i = R.id.btn_rate_now;
        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.btn_rate_now);
        if (skinRoundTextView != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                i = R.id.ll_bad;
                SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ll_bad);
                if (skinRoundAutoLinearLayout != null) {
                    i = R.id.ll_excellent;
                    SkinRoundAutoLinearLayout skinRoundAutoLinearLayout2 = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ll_excellent);
                    if (skinRoundAutoLinearLayout2 != null) {
                        i = R.id.lottie_bad;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.lottie_bad);
                        if (lottieAnimationView != null) {
                            i = R.id.lottie_excellent;
                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.lottie_excellent);
                            if (lottieAnimationView2 != null) {
                                i = R.id.tv_title;
                                TextView textView = (TextView) view.findViewById(R.id.tv_title);
                                if (textView != null) {
                                    i = R.id.v_divider;
                                    View viewFindViewById = view.findViewById(R.id.v_divider);
                                    if (viewFindViewById != null) {
                                        return new PopupRateBinding((SkinRoundConstraintLayout) view, skinRoundTextView, imageView, skinRoundAutoLinearLayout, skinRoundAutoLinearLayout2, lottieAnimationView, lottieAnimationView2, textView, viewFindViewById);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static PopupRateBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopupRateBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_rate, viewGroup, false);
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
