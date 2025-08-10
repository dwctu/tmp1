package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.widget.MyActionBar;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ActivityVoiceBookBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final SkinCompatConstraintLayout c;

    @NonNull
    public final View d;

    @NonNull
    public final RoundedImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final ProgressBar i;

    @NonNull
    public final RecyclerView j;

    @NonNull
    public final RecyclerView k;

    @NonNull
    public final RoundedImageView l;

    @NonNull
    public final SeekBar m;

    @NonNull
    public final SmartRefreshLayout n;

    @NonNull
    public final TextView o;

    public ActivityVoiceBookBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull View view, @NonNull RoundedImageView roundedImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull RoundedImageView roundedImageView2, @NonNull SeekBar seekBar, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull TextView textView) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = skinCompatConstraintLayout;
        this.d = view;
        this.e = roundedImageView;
        this.f = imageView;
        this.g = imageView3;
        this.h = linearLayout2;
        this.i = progressBar;
        this.j = recyclerView;
        this.k = recyclerView2;
        this.l = roundedImageView2;
        this.m = seekBar;
        this.n = smartRefreshLayout;
        this.o = textView;
    }

    @NonNull
    public static ActivityVoiceBookBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.bottom_bar_root;
            SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) view.findViewById(R.id.bottom_bar_root);
            if (skinCompatConstraintLayout != null) {
                i = R.id.group_bottom;
                View viewFindViewById = view.findViewById(R.id.group_bottom);
                if (viewFindViewById != null) {
                    i = R.id.iv_ad_banner;
                    RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.iv_ad_banner);
                    if (roundedImageView != null) {
                        i = R.id.iv_bottom_play;
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bottom_play);
                        if (imageView != null) {
                            i = R.id.iv_bottom_pull_up;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bottom_pull_up);
                            if (imageView2 != null) {
                                i = R.id.iv_chat_gpt;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_chat_gpt);
                                if (imageView3 != null) {
                                    i = R.id.ll_net_work_error;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_net_work_error);
                                    if (linearLayout != null) {
                                        i = R.id.progressBar;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
                                        if (progressBar != null) {
                                            i = R.id.recyclerTag;
                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerTag);
                                            if (recyclerView != null) {
                                                i = R.id.recyclerView;
                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
                                                if (recyclerView2 != null) {
                                                    i = R.id.riv_cover;
                                                    RoundedImageView roundedImageView2 = (RoundedImageView) view.findViewById(R.id.riv_cover);
                                                    if (roundedImageView2 != null) {
                                                        i = R.id.seekBar;
                                                        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
                                                        if (seekBar != null) {
                                                            i = R.id.smartRefresh;
                                                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smartRefresh);
                                                            if (smartRefreshLayout != null) {
                                                                i = R.id.tv_bottom_bar_title;
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_bottom_bar_title);
                                                                if (textView != null) {
                                                                    return new ActivityVoiceBookBinding((LinearLayout) view, myActionBar, skinCompatConstraintLayout, viewFindViewById, roundedImageView, imageView, imageView2, imageView3, linearLayout, progressBar, recyclerView, recyclerView2, roundedImageView2, seekBar, smartRefreshLayout, textView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityVoiceBookBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityVoiceBookBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_voice_book, viewGroup, false);
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
