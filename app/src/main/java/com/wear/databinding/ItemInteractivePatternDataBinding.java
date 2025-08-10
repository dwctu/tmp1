package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.control.NewCurveLineView;

/* loaded from: classes3.dex */
public final class ItemInteractivePatternDataBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final MediumBoldTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final NewCurveLineView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public ItemInteractivePatternDataBinding(@NonNull CardView cardView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull NewCurveLineView newCurveLineView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = cardView;
        this.b = relativeLayout;
        this.c = imageView;
        this.d = mediumBoldTextView;
        this.e = textView;
        this.f = imageView2;
        this.g = newCurveLineView;
        this.h = textView2;
        this.i = textView3;
    }

    @NonNull
    public static ItemInteractivePatternDataBinding a(@NonNull View view) {
        int i = R.id.data_loading_view;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.data_loading_view);
        if (relativeLayout != null) {
            i = R.id.iv_pattern_like;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_pattern_like);
            if (imageView != null) {
                i = R.id.pattern_ad_tv;
                MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) view.findViewById(R.id.pattern_ad_tv);
                if (mediumBoldTextView != null) {
                    i = R.id.pattern_id_tv;
                    TextView textView = (TextView) view.findViewById(R.id.pattern_id_tv);
                    if (textView != null) {
                        i = R.id.pattern_info_layout;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pattern_info_layout);
                        if (linearLayout != null) {
                            i = R.id.pattern_play;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.pattern_play);
                            if (imageView2 != null) {
                                i = R.id.pattern_play_curve;
                                NewCurveLineView newCurveLineView = (NewCurveLineView) view.findViewById(R.id.pattern_play_curve);
                                if (newCurveLineView != null) {
                                    i = R.id.pattern_play_layout;
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pattern_play_layout);
                                    if (linearLayout2 != null) {
                                        i = R.id.pattern_times;
                                        TextView textView2 = (TextView) view.findViewById(R.id.pattern_times);
                                        if (textView2 != null) {
                                            i = R.id.tv_pattern_like_number;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_pattern_like_number);
                                            if (textView3 != null) {
                                                return new ItemInteractivePatternDataBinding((CardView) view, relativeLayout, imageView, mediumBoldTextView, textView, linearLayout, imageView2, newCurveLineView, linearLayout2, textView2, textView3);
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
    public CardView getRoot() {
        return this.a;
    }
}
