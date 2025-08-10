package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.tencent.qgame.animplayer.AnimView;

/* loaded from: classes3.dex */
public final class ItemInteractiveVideoDataAdBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final ConstraintLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final AnimView h;

    public ItemInteractiveVideoDataAdBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2, @NonNull Guideline guideline3, @NonNull Guideline guideline4, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull AnimView animView, @NonNull ImageView imageView3) {
        this.a = linearLayout;
        this.b = constraintLayout;
        this.c = imageView;
        this.d = constraintLayout2;
        this.e = imageView2;
        this.f = constraintLayout3;
        this.g = constraintLayout4;
        this.h = animView;
    }

    @NonNull
    public static ItemInteractiveVideoDataAdBinding a(@NonNull View view) {
        int i = R.id.tv_no_more;
        TextView textView = (TextView) view.findViewById(R.id.tv_no_more);
        if (textView != null) {
            i = R.id.video_bottom_ad_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.video_bottom_ad_layout);
            if (constraintLayout != null) {
                i = R.id.video_bottom_iv_ad;
                ImageView imageView = (ImageView) view.findViewById(R.id.video_bottom_iv_ad);
                if (imageView != null) {
                    i = R.id.video_bottom_trial_guideline;
                    Guideline guideline = (Guideline) view.findViewById(R.id.video_bottom_trial_guideline);
                    if (guideline != null) {
                        i = R.id.video_bottom_trial_guideline_h;
                        Guideline guideline2 = (Guideline) view.findViewById(R.id.video_bottom_trial_guideline_h);
                        if (guideline2 != null) {
                            i = R.id.video_bottom_trial_layout;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_bottom_trial_layout);
                            if (linearLayout != null) {
                                i = R.id.video_download_ad_layout;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.video_download_ad_layout);
                                if (constraintLayout2 != null) {
                                    i = R.id.video_download_middle_iv_ad;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.video_download_middle_iv_ad);
                                    if (imageView2 != null) {
                                        i = R.id.video_download_trial_guideline;
                                        Guideline guideline3 = (Guideline) view.findViewById(R.id.video_download_trial_guideline);
                                        if (guideline3 != null) {
                                            i = R.id.video_download_trial_guideline_h;
                                            Guideline guideline4 = (Guideline) view.findViewById(R.id.video_download_trial_guideline_h);
                                            if (guideline4 != null) {
                                                i = R.id.video_no_more_layout;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.video_no_more_layout);
                                                if (constraintLayout3 != null) {
                                                    i = R.id.video_top_ad_layout;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.video_top_ad_layout);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.video_top_ad_vap;
                                                        AnimView animView = (AnimView) view.findViewById(R.id.video_top_ad_vap);
                                                        if (animView != null) {
                                                            i = R.id.video_top_iv_ad;
                                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.video_top_iv_ad);
                                                            if (imageView3 != null) {
                                                                return new ItemInteractiveVideoDataAdBinding((LinearLayout) view, textView, constraintLayout, imageView, guideline, guideline2, linearLayout, constraintLayout2, imageView2, guideline3, guideline4, constraintLayout3, constraintLayout4, animView, imageView3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
