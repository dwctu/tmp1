package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class FragmentVbPatternBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final RecyclerView b;

    @NonNull
    public final SmartRefreshLayout c;

    public FragmentVbPatternBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout) {
        this.a = skinCompatConstraintLayout;
        this.b = recyclerView;
        this.c = smartRefreshLayout;
    }

    @NonNull
    public static FragmentVbPatternBinding a(@NonNull View view) {
        int i = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i = R.id.refresh_layout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
            if (smartRefreshLayout != null) {
                return new FragmentVbPatternBinding((SkinCompatConstraintLayout) view, recyclerView, smartRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static FragmentVbPatternBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentVbPatternBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_vb_pattern, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinCompatConstraintLayout getRoot() {
        return this.a;
    }
}
