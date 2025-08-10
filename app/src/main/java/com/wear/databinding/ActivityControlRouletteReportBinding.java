package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;
import com.wear.widget.roundwidget.SkinRoundImageView;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.design.widget.SkinMaterialTextInputEditText;

/* loaded from: classes3.dex */
public final class ActivityControlRouletteReportBinding implements ViewBinding {

    @NonNull
    public final SkinRoundAutoRelativeLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final SkinMaterialTextInputEditText c;

    @NonNull
    public final SkinRoundAutoRelativeLayout d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final ScrollView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final SkinRoundTextView i;

    @NonNull
    public final TextView j;

    public ActivityControlRouletteReportBinding(@NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout, @NonNull MyActionBar myActionBar, @NonNull SkinMaterialTextInputEditText skinMaterialTextInputEditText, @NonNull SkinRoundImageView skinRoundImageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout2, @NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout3, @NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout4, @NonNull RecyclerView recyclerView, @NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SkinRoundTextView skinRoundTextView, @NonNull TextView textView4) {
        this.a = skinRoundAutoRelativeLayout;
        this.b = myActionBar;
        this.c = skinMaterialTextInputEditText;
        this.d = skinRoundAutoRelativeLayout2;
        this.e = recyclerView;
        this.f = scrollView;
        this.g = textView;
        this.h = textView3;
        this.i = skinRoundTextView;
        this.j = textView4;
    }

    @NonNull
    public static ActivityControlRouletteReportBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.et_description;
            SkinMaterialTextInputEditText skinMaterialTextInputEditText = (SkinMaterialTextInputEditText) view.findViewById(R.id.et_description);
            if (skinMaterialTextInputEditText != null) {
                i = R.id.img_more;
                SkinRoundImageView skinRoundImageView = (SkinRoundImageView) view.findViewById(R.id.img_more);
                if (skinRoundImageView != null) {
                    i = R.id.ll_title;
                    SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ll_title);
                    if (skinRoundAutoLinearLayout != null) {
                        i = R.id.rl_choose_history;
                        SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout = (SkinRoundAutoRelativeLayout) view.findViewById(R.id.rl_choose_history);
                        if (skinRoundAutoRelativeLayout != null) {
                            i = R.id.rl_choose_picture;
                            SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout2 = (SkinRoundAutoRelativeLayout) view.findViewById(R.id.rl_choose_picture);
                            if (skinRoundAutoRelativeLayout2 != null) {
                                i = R.id.rl_description;
                                SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout3 = (SkinRoundAutoRelativeLayout) view.findViewById(R.id.rl_description);
                                if (skinRoundAutoRelativeLayout3 != null) {
                                    i = R.id.rl_imgs;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_imgs);
                                    if (recyclerView != null) {
                                        i = R.id.scrollView;
                                        ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollView);
                                        if (scrollView != null) {
                                            i = R.id.tv_input_num;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_input_num);
                                            if (textView != null) {
                                                i = R.id.tv_num_title;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_num_title);
                                                if (textView2 != null) {
                                                    i = R.id.tv_nums;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_nums);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_select_num;
                                                        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.tv_select_num);
                                                        if (skinRoundTextView != null) {
                                                            i = R.id.tv_submit;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_submit);
                                                            if (textView4 != null) {
                                                                return new ActivityControlRouletteReportBinding((SkinRoundAutoRelativeLayout) view, myActionBar, skinMaterialTextInputEditText, skinRoundImageView, skinRoundAutoLinearLayout, skinRoundAutoRelativeLayout, skinRoundAutoRelativeLayout2, skinRoundAutoRelativeLayout3, recyclerView, scrollView, textView, textView2, textView3, skinRoundTextView, textView4);
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
    public static ActivityControlRouletteReportBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityControlRouletteReportBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_control_roulette_report, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinRoundAutoRelativeLayout getRoot() {
        return this.a;
    }
}
