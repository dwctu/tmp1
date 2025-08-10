package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.control.multiToys.MultiControlPanel;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ViewLiveControlBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public ViewLiveControlBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull MultiControlPanel multiControlPanel, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout4, @NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull View view) {
        this.a = linearLayout;
    }

    @NonNull
    public static ViewLiveControlBinding a(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.iv_control_close;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_control_close);
        if (imageView != null) {
            i = R.id.ll_live_control_time;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_live_control_time);
            if (linearLayout2 != null) {
                i = R.id.multipanel_livecontrol;
                MultiControlPanel multiControlPanel = (MultiControlPanel) view.findViewById(R.id.multipanel_livecontrol);
                if (multiControlPanel != null) {
                    i = R.id.tv_control_time;
                    TextView textView = (TextView) view.findViewById(R.id.tv_control_time);
                    if (textView != null) {
                        i = R.id.tv_control_time_center;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_control_time_center);
                        if (textView2 != null) {
                            i = R.id.tv_live_control_tip;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_live_control_tip);
                            if (textView3 != null) {
                                i = R.id.v_be_controled_live;
                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.v_be_controled_live);
                                if (linearLayout3 != null) {
                                    i = R.id.v_control_live_no_toys;
                                    SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) view.findViewById(R.id.v_control_live_no_toys);
                                    if (skinCompatConstraintLayout != null) {
                                        i = R.id.v_live_control_line;
                                        View viewFindViewById = view.findViewById(R.id.v_live_control_line);
                                        if (viewFindViewById != null) {
                                            return new ViewLiveControlBinding(linearLayout, linearLayout, imageView, linearLayout2, multiControlPanel, textView, textView2, textView3, linearLayout3, skinCompatConstraintLayout, viewFindViewById);
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
    public static ViewLiveControlBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_live_control, viewGroup, false);
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
