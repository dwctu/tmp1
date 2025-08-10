package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.lovense.wear.R;
import com.wear.widget.ScaleView;
import com.wear.widget.chatMic.DrawView;
import com.wear.widget.control.AutoHideTextView;
import com.wear.widget.control.ScaleTextView;

/* loaded from: classes3.dex */
public final class ActivityVoiceControlBinding implements ViewBinding {

    @NonNull
    public final ScaleTextView A;

    @NonNull
    public final TextView B;

    @NonNull
    public final TextView C;

    @NonNull
    public final TextView D;

    @NonNull
    public final TextView E;

    @NonNull
    public final TextView F;

    @NonNull
    public final TextView G;

    @NonNull
    public final DrawView K;

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final AutoHideTextView b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final LottieAnimationView i;

    @NonNull
    public final LottieAnimationView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final PlayerView n;

    @NonNull
    public final ProgressBar o;

    @NonNull
    public final ConstraintLayout p;

    @NonNull
    public final ConstraintLayout q;

    @NonNull
    public final RecyclerView r;

    @NonNull
    public final ScaleView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final TextView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final TextView w;

    @NonNull
    public final TextView x;

    @NonNull
    public final TextView y;

    @NonNull
    public final TextView z;

    public ActivityVoiceControlBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AutoHideTextView autoHideTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull PlayerView playerView, @NonNull ProgressBar progressBar, @NonNull ConstraintLayout constraintLayout5, @NonNull ConstraintLayout constraintLayout6, @NonNull RecyclerView recyclerView, @NonNull ScaleView scaleView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull ScaleTextView scaleTextView, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull DrawView drawView) {
        this.a = constraintLayout;
        this.b = autoHideTextView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = constraintLayout4;
        this.f = imageView;
        this.g = imageView3;
        this.h = imageView4;
        this.i = lottieAnimationView;
        this.j = lottieAnimationView2;
        this.k = imageView6;
        this.l = imageView7;
        this.m = imageView8;
        this.n = playerView;
        this.o = progressBar;
        this.p = constraintLayout5;
        this.q = constraintLayout6;
        this.r = recyclerView;
        this.s = scaleView;
        this.t = textView;
        this.u = textView2;
        this.v = textView3;
        this.w = textView4;
        this.x = textView5;
        this.y = textView6;
        this.z = textView8;
        this.A = scaleTextView;
        this.B = textView11;
        this.C = textView12;
        this.D = textView13;
        this.E = textView14;
        this.F = textView15;
        this.G = textView16;
        this.K = drawView;
    }

    @NonNull
    public static ActivityVoiceControlBinding a(@NonNull View view) {
        int i = R.id.auto_hide_text_view;
        AutoHideTextView autoHideTextView = (AutoHideTextView) view.findViewById(R.id.auto_hide_text_view);
        if (autoHideTextView != null) {
            i = R.id.cl_actionbar;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_actionbar);
            if (constraintLayout != null) {
                i = R.id.cl_debug_panel;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_debug_panel);
                if (constraintLayout2 != null) {
                    i = R.id.content_view;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.content_view);
                    if (constraintLayout3 != null) {
                        i = R.id.iv_back;
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                        if (imageView != null) {
                            i = R.id.iv_connect_error;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_connect_error);
                            if (imageView2 != null) {
                                i = R.id.iv_continue_download;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_continue_download);
                                if (imageView3 != null) {
                                    i = R.id.iv_debug_close;
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_debug_close);
                                    if (imageView4 != null) {
                                        i = R.id.iv_frequency;
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.iv_frequency);
                                        if (lottieAnimationView != null) {
                                            i = R.id.iv_microphone;
                                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.iv_microphone);
                                            if (lottieAnimationView2 != null) {
                                                i = R.id.iv_reload;
                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_reload);
                                                if (imageView5 != null) {
                                                    i = R.id.iv_reload_bg;
                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_reload_bg);
                                                    if (imageView6 != null) {
                                                        i = R.id.iv_scale_bottom;
                                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_scale_bottom);
                                                        if (imageView7 != null) {
                                                            i = R.id.iv_toy_empty;
                                                            ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_toy_empty);
                                                            if (imageView8 != null) {
                                                                i = R.id.playerView;
                                                                PlayerView playerView = (PlayerView) view.findViewById(R.id.playerView);
                                                                if (playerView != null) {
                                                                    i = R.id.progressBar;
                                                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
                                                                    if (progressBar != null) {
                                                                        i = R.id.root_download;
                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.root_download);
                                                                        if (constraintLayout4 != null) {
                                                                            i = R.id.root_error;
                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.root_error);
                                                                            if (constraintLayout5 != null) {
                                                                                i = R.id.rv_debug;
                                                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_debug);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.scaleView;
                                                                                    ScaleView scaleView = (ScaleView) view.findViewById(R.id.scaleView);
                                                                                    if (scaleView != null) {
                                                                                        i = R.id.tv_button_download;
                                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_button_download);
                                                                                        if (textView != null) {
                                                                                            i = R.id.tv_button_no;
                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_button_no);
                                                                                            if (textView2 != null) {
                                                                                                i = R.id.tv_debug_frequency;
                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_debug_frequency);
                                                                                                if (textView3 != null) {
                                                                                                    i = R.id.tv_debug_recognition_result;
                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_debug_recognition_result);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.tv_debug_type;
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_debug_type);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.tv_debug_value;
                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_debug_value);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.tv_dialog_title;
                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_title);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.tv_download_progress;
                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_download_progress);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.tv_network_unstable;
                                                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_network_unstable);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.tv_reload;
                                                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_reload);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.tv_scale_text;
                                                                                                                                ScaleTextView scaleTextView = (ScaleTextView) view.findViewById(R.id.tv_scale_text);
                                                                                                                                if (scaleTextView != null) {
                                                                                                                                    i = R.id.tv_start;
                                                                                                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_start);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.tv_sub_title;
                                                                                                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_sub_title);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i = R.id.tv_tips;
                                                                                                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_tips);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.tv_title;
                                                                                                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = R.id.tv_top_guide;
                                                                                                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_top_guide);
                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                        i = R.id.tv_toy_size;
                                                                                                                                                        TextView textView16 = (TextView) view.findViewById(R.id.tv_toy_size);
                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                            i = R.id.wave_view;
                                                                                                                                                            DrawView drawView = (DrawView) view.findViewById(R.id.wave_view);
                                                                                                                                                            if (drawView != null) {
                                                                                                                                                                return new ActivityVoiceControlBinding((ConstraintLayout) view, autoHideTextView, constraintLayout, constraintLayout2, constraintLayout3, imageView, imageView2, imageView3, imageView4, lottieAnimationView, lottieAnimationView2, imageView5, imageView6, imageView7, imageView8, playerView, progressBar, constraintLayout4, constraintLayout5, recyclerView, scaleView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, scaleTextView, textView11, textView12, textView13, textView14, textView15, textView16, drawView);
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
    public static ActivityVoiceControlBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityVoiceControlBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_voice_control, viewGroup, false);
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
