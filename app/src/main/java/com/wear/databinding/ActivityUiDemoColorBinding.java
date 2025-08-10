package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityUiDemoColorBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final RecyclerView c;

    public ActivityUiDemoColorBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = recyclerView;
    }

    @NonNull
    public static ActivityUiDemoColorBinding a(@NonNull View view) {
        int i = R.id.bar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.bar);
        if (myActionBar != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                return new ActivityUiDemoColorBinding((LinearLayout) view, myActionBar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityUiDemoColorBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUiDemoColorBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ui_demo_color, viewGroup, false);
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
