package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import skin.support.widget.SkinCompatImageView;

/* loaded from: classes3.dex */
public final class LayoutSyncControlLdrBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    public LayoutSyncControlLdrBinding(@NonNull RelativeLayout relativeLayout, @NonNull SkinCompatImageView skinCompatImageView, @NonNull ImageView imageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view, @NonNull View view2) {
        this.a = relativeLayout;
    }

    @NonNull
    public static LayoutSyncControlLdrBinding a(@NonNull View view) {
        int i = R.id.iv_ldr_control;
        SkinCompatImageView skinCompatImageView = (SkinCompatImageView) view.findViewById(R.id.iv_ldr_control);
        if (skinCompatImageView != null) {
            i = R.id.iv_ldr_control_states;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_ldr_control_states);
            if (imageView != null) {
                i = R.id.ldr_master_control_layout;
                SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ldr_master_control_layout);
                if (skinRoundAutoLinearLayout != null) {
                    i = R.id.ldr_sensitivity;
                    SeekBar seekBar = (SeekBar) view.findViewById(R.id.ldr_sensitivity);
                    if (seekBar != null) {
                        i = R.id.ldr_sensitivity_layout;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ldr_sensitivity_layout);
                        if (linearLayout != null) {
                            i = R.id.ll_progress;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_progress);
                            if (linearLayout2 != null) {
                                i = R.id.ll_toy_list;
                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_toy_list);
                                if (linearLayout3 != null) {
                                    i = R.id.rv_friend;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_friend);
                                    if (recyclerView != null) {
                                        i = R.id.rv_self;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_self);
                                        if (recyclerView2 != null) {
                                            i = R.id.tv_friend_name;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_friend_name);
                                            if (textView != null) {
                                                i = R.id.tv_ldr_control;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_ldr_control);
                                                if (textView2 != null) {
                                                    i = R.id.v_line;
                                                    View viewFindViewById = view.findViewById(R.id.v_line);
                                                    if (viewFindViewById != null) {
                                                        i = R.id.v_line_1;
                                                        View viewFindViewById2 = view.findViewById(R.id.v_line_1);
                                                        if (viewFindViewById2 != null) {
                                                            return new LayoutSyncControlLdrBinding((RelativeLayout) view, skinCompatImageView, imageView, skinRoundAutoLinearLayout, seekBar, linearLayout, linearLayout2, linearLayout3, recyclerView, recyclerView2, textView, textView2, viewFindViewById, viewFindViewById2);
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
