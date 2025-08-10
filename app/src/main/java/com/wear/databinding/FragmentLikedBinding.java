package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class FragmentLikedBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final SmartRefreshLayout e;

    @NonNull
    public final TextView f;

    public FragmentLikedBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.a = skinCompatConstraintLayout;
        this.b = linearLayout;
        this.c = textView;
        this.d = recyclerView;
        this.e = smartRefreshLayout;
        this.f = textView2;
    }

    @NonNull
    public static FragmentLikedBinding a(@NonNull View view) {
        int i = R.id.no_data_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.no_data_layout);
        if (linearLayout != null) {
            i = R.id.pattern_tv;
            TextView textView = (TextView) view.findViewById(R.id.pattern_tv);
            if (textView != null) {
                i = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    i = R.id.refresh_layout;
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                    if (smartRefreshLayout != null) {
                        i = R.id.top_layout;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.top_layout);
                        if (linearLayout2 != null) {
                            i = R.id.video_tv;
                            TextView textView2 = (TextView) view.findViewById(R.id.video_tv);
                            if (textView2 != null) {
                                return new FragmentLikedBinding((SkinCompatConstraintLayout) view, linearLayout, textView, recyclerView, smartRefreshLayout, linearLayout2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static FragmentLikedBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentLikedBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_liked, viewGroup, false);
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
