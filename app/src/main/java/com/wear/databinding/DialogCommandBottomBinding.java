package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class DialogCommandBottomBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    public DialogCommandBottomBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Flow flow, @NonNull Flow flow2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull View view, @NonNull View view2) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = textView9;
        this.l = textView10;
        this.m = textView11;
        this.n = textView12;
        this.o = textView13;
        this.p = textView14;
        this.q = textView15;
        this.r = textView16;
    }

    @NonNull
    public static DialogCommandBottomBinding a(@NonNull View view) {
        int i = R.id.flow;
        Flow flow = (Flow) view.findViewById(R.id.flow);
        if (flow != null) {
            i = R.id.flow_intermediate;
            Flow flow2 = (Flow) view.findViewById(R.id.flow_intermediate);
            if (flow2 != null) {
                i = R.id.iv_close;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                if (imageView != null) {
                    i = R.id.iv_pattern_default;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pattern_default);
                    if (imageView2 != null) {
                        i = R.id.iv_pattern_straight;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_pattern_straight);
                        if (imageView3 != null) {
                            i = R.id.iv_pattern_wave;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_pattern_wave);
                            if (imageView4 != null) {
                                i = R.id.tv_command_faster;
                                TextView textView = (TextView) view.findViewById(R.id.tv_command_faster);
                                if (textView != null) {
                                    i = R.id.tv_command_prompt;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_command_prompt);
                                    if (textView2 != null) {
                                        i = R.id.tv_command_slower;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_command_slower);
                                        if (textView3 != null) {
                                            i = R.id.tv_command_speed;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_command_speed);
                                            if (textView4 != null) {
                                                i = R.id.tv_command_start;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_command_start);
                                                if (textView5 != null) {
                                                    i = R.id.tv_command_stop;
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_command_stop);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_command_strength;
                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_command_strength);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_command_stronger;
                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_command_stronger);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_command_weaker;
                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_command_weaker);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_default;
                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_default);
                                                                    if (textView10 != null) {
                                                                        i = R.id.tv_ex;
                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_ex);
                                                                        if (textView11 != null) {
                                                                            i = R.id.tv_instruction;
                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_instruction);
                                                                            if (textView12 != null) {
                                                                                i = R.id.tv_intermediate;
                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_intermediate);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.tv_pattern_command;
                                                                                    TextView textView14 = (TextView) view.findViewById(R.id.tv_pattern_command);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.tv_straight;
                                                                                        TextView textView15 = (TextView) view.findViewById(R.id.tv_straight);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.tv_wave;
                                                                                            TextView textView16 = (TextView) view.findViewById(R.id.tv_wave);
                                                                                            if (textView16 != null) {
                                                                                                i = R.id.view_line_1;
                                                                                                View viewFindViewById = view.findViewById(R.id.view_line_1);
                                                                                                if (viewFindViewById != null) {
                                                                                                    i = R.id.view_line_2;
                                                                                                    View viewFindViewById2 = view.findViewById(R.id.view_line_2);
                                                                                                    if (viewFindViewById2 != null) {
                                                                                                        return new DialogCommandBottomBinding((ConstraintLayout) view, flow, flow2, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, viewFindViewById, viewFindViewById2);
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
    public static DialogCommandBottomBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCommandBottomBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_command_bottom, viewGroup, false);
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
