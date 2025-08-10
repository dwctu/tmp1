package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.ui.discover.roulette.widget.CenterFlowLayout;

/* loaded from: classes3.dex */
public final class ViewRouletteToyPlaysBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    @NonNull
    public final CenterFlowLayout b;

    @NonNull
    public final CenterFlowLayout c;

    @NonNull
    public final ViewRoulettePlayBinding d;

    @NonNull
    public final ItemRouletteToyBinding e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final LinearLayout g;

    public ViewRouletteToyPlaysBinding(@NonNull FrameLayout frameLayout, @NonNull CenterFlowLayout centerFlowLayout, @NonNull CenterFlowLayout centerFlowLayout2, @NonNull ViewRoulettePlayBinding viewRoulettePlayBinding, @NonNull ItemRouletteToyBinding itemRouletteToyBinding, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.a = frameLayout;
        this.b = centerFlowLayout;
        this.c = centerFlowLayout2;
        this.d = viewRoulettePlayBinding;
        this.e = itemRouletteToyBinding;
        this.f = linearLayout;
        this.g = linearLayout2;
    }

    @NonNull
    public static ViewRouletteToyPlaysBinding a(@NonNull View view) {
        int i = R.id.center_flow_layout;
        CenterFlowLayout centerFlowLayout = (CenterFlowLayout) view.findViewById(R.id.center_flow_layout);
        if (centerFlowLayout != null) {
            i = R.id.flex_box_layout;
            CenterFlowLayout centerFlowLayout2 = (CenterFlowLayout) view.findViewById(R.id.flex_box_layout);
            if (centerFlowLayout2 != null) {
                i = R.id.single_item_roulette_play;
                View viewFindViewById = view.findViewById(R.id.single_item_roulette_play);
                if (viewFindViewById != null) {
                    ViewRoulettePlayBinding viewRoulettePlayBindingA = ViewRoulettePlayBinding.a(viewFindViewById);
                    i = R.id.single_item_roulette_toy;
                    View viewFindViewById2 = view.findViewById(R.id.single_item_roulette_toy);
                    if (viewFindViewById2 != null) {
                        ItemRouletteToyBinding itemRouletteToyBindingB = ItemRouletteToyBinding.b(viewFindViewById2);
                        i = R.id.view_container_roulette_more;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.view_container_roulette_more);
                        if (linearLayout != null) {
                            i = R.id.view_container_roulette_single;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.view_container_roulette_single);
                            if (linearLayout2 != null) {
                                return new ViewRouletteToyPlaysBinding((FrameLayout) view, centerFlowLayout, centerFlowLayout2, viewRoulettePlayBindingA, itemRouletteToyBindingB, linearLayout, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewRouletteToyPlaysBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_roulette_toy_plays, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
