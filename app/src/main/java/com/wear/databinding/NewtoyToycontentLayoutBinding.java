package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class NewtoyToycontentLayoutBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LottieAnimationView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final RecyclerView i;

    @NonNull
    public final RecyclerView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final RelativeLayout l;

    @NonNull
    public final TextView m;

    @NonNull
    public final SkinCompatConstraintLayout n;

    public NewtoyToycontentLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout3, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout, @NonNull SkinCompatConstraintLayout skinCompatConstraintLayout) {
        this.a = relativeLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = lottieAnimationView;
        this.e = textView;
        this.f = imageView2;
        this.g = textView2;
        this.h = textView3;
        this.i = recyclerView;
        this.j = recyclerView2;
        this.k = textView4;
        this.l = relativeLayout3;
        this.m = textView5;
        this.n = skinCompatConstraintLayout;
    }

    @NonNull
    public static NewtoyToycontentLayoutBinding a(@NonNull View view) {
        int i = R.id.bt_disabled_iv;
        ImageView imageView = (ImageView) view.findViewById(R.id.bt_disabled_iv);
        if (imageView != null) {
            i = R.id.bt_disabled_layout;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bt_disabled_layout);
            if (relativeLayout != null) {
                i = R.id.bt_layout;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bt_layout);
                if (linearLayout != null) {
                    i = R.id.bt_searing_iv;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.bt_searing_iv);
                    if (lottieAnimationView != null) {
                        i = R.id.bt_type;
                        TextView textView = (TextView) view.findViewById(R.id.bt_type);
                        if (textView != null) {
                            i = R.id.icon_warn_multiple_close;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.icon_warn_multiple_close);
                            if (imageView2 != null) {
                                i = R.id.my_toy_title_tv;
                                TextView textView2 = (TextView) view.findViewById(R.id.my_toy_title_tv);
                                if (textView2 != null) {
                                    i = R.id.newtoy_bldisabledtv;
                                    TextView textView3 = (TextView) view.findViewById(R.id.newtoy_bldisabledtv);
                                    if (textView3 != null) {
                                        i = R.id.newtoy_recyclermytoy;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.newtoy_recyclermytoy);
                                        if (recyclerView != null) {
                                            i = R.id.newtoy_recyclersearchtoy;
                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.newtoy_recyclersearchtoy);
                                            if (recyclerView2 != null) {
                                                i = R.id.newtoy_rescan;
                                                TextView textView4 = (TextView) view.findViewById(R.id.newtoy_rescan);
                                                if (textView4 != null) {
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                                    i = R.id.newtoy_searchtoytitle;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.newtoy_searchtoytitle);
                                                    if (textView5 != null) {
                                                        i = R.id.search_toy_title_layout;
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.search_toy_title_layout);
                                                        if (constraintLayout != null) {
                                                            i = R.id.warn_multiple_toys_tips;
                                                            SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) view.findViewById(R.id.warn_multiple_toys_tips);
                                                            if (skinCompatConstraintLayout != null) {
                                                                return new NewtoyToycontentLayoutBinding(relativeLayout2, imageView, relativeLayout, linearLayout, lottieAnimationView, textView, imageView2, textView2, textView3, recyclerView, recyclerView2, textView4, relativeLayout2, textView5, constraintLayout, skinCompatConstraintLayout);
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
    public RelativeLayout getRoot() {
        return this.a;
    }
}
