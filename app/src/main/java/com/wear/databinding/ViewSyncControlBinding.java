package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.control.multiToys.MultiControlPanel;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public final class ViewSyncControlBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final NewLDRPanel b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LayoutSyncControlLdrBinding d;

    public ViewSyncControlBinding(@NonNull LinearLayout linearLayout, @NonNull SkinCompatLinearLayout skinCompatLinearLayout, @NonNull ListView listView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull NewLDRPanel newLDRPanel, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7, @NonNull LinearLayout linearLayout8, @NonNull MultiControlPanel multiControlPanel, @NonNull LinearLayout linearLayout9, @NonNull LayoutSyncControlLdrBinding layoutSyncControlLdrBinding, @NonNull LinearLayout linearLayout10, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = linearLayout;
        this.b = newLDRPanel;
        this.c = linearLayout3;
        this.d = layoutSyncControlLdrBinding;
    }

    @NonNull
    public static ViewSyncControlBinding a(@NonNull View view) {
        int i = R.id.chat_live_bottom_pattern_layer;
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) view.findViewById(R.id.chat_live_bottom_pattern_layer);
        if (skinCompatLinearLayout != null) {
            i = R.id.chat_live_bottom_pattern_list;
            ListView listView = (ListView) view.findViewById(R.id.chat_live_bottom_pattern_list);
            if (listView != null) {
                i = R.id.fl_master_sync_control;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_master_sync_control);
                if (frameLayout != null) {
                    i = R.id.iv_control_close;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_control_close);
                    if (imageView != null) {
                        i = R.id.iv_pattern_sync;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pattern_sync);
                        if (imageView2 != null) {
                            i = R.id.iv_show_or_close_more;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_show_or_close_more);
                            if (imageView3 != null) {
                                i = R.id.ldr_panel;
                                NewLDRPanel newLDRPanel = (NewLDRPanel) view.findViewById(R.id.ldr_panel);
                                if (newLDRPanel != null) {
                                    i = R.id.ll_be_controlled_1;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_be_controlled_1);
                                    if (linearLayout != null) {
                                        i = R.id.ll_control_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_control_layout);
                                        if (linearLayout2 != null) {
                                            i = R.id.ll_control_time;
                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_control_time);
                                            if (linearLayout3 != null) {
                                                i = R.id.ll_control_time_1;
                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_control_time_1);
                                                if (linearLayout4 != null) {
                                                    i = R.id.ll_controlled;
                                                    LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_controlled);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.ll_pattern;
                                                        LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.ll_pattern);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.ll_pattern_sync;
                                                            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.ll_pattern_sync);
                                                            if (linearLayout7 != null) {
                                                                i = R.id.multi_control_panel;
                                                                MultiControlPanel multiControlPanel = (MultiControlPanel) view.findViewById(R.id.multi_control_panel);
                                                                if (multiControlPanel != null) {
                                                                    i = R.id.pattern_list_empty;
                                                                    LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.pattern_list_empty);
                                                                    if (linearLayout8 != null) {
                                                                        i = R.id.sync_ldr_layer;
                                                                        View viewFindViewById = view.findViewById(R.id.sync_ldr_layer);
                                                                        if (viewFindViewById != null) {
                                                                            LayoutSyncControlLdrBinding layoutSyncControlLdrBindingA = LayoutSyncControlLdrBinding.a(viewFindViewById);
                                                                            i = R.id.touch_control_horizontal_bottom;
                                                                            LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.touch_control_horizontal_bottom);
                                                                            if (linearLayout9 != null) {
                                                                                i = R.id.tv_control_time;
                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_control_time);
                                                                                if (textView != null) {
                                                                                    i = R.id.tv_control_time_1;
                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_control_time_1);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tv_sync_pattern;
                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_sync_pattern);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tv_tochange_control_dlr;
                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_tochange_control_dlr);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tv_tochange_control_remote;
                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_tochange_control_remote);
                                                                                                if (textView5 != null) {
                                                                                                    return new ViewSyncControlBinding((LinearLayout) view, skinCompatLinearLayout, listView, frameLayout, imageView, imageView2, imageView3, newLDRPanel, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, multiControlPanel, linearLayout8, layoutSyncControlLdrBindingA, linearLayout9, textView, textView2, textView3, textView4, textView5);
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
    public static ViewSyncControlBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_sync_control, viewGroup, false);
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
