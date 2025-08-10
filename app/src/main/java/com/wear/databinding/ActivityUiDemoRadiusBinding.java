package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityUiDemoRadiusBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public ActivityUiDemoRadiusBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar) {
        this.a = linearLayout;
    }

    @NonNull
    public static ActivityUiDemoRadiusBinding a(@NonNull View view) {
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.bar);
        if (myActionBar != null) {
            return new ActivityUiDemoRadiusBinding((LinearLayout) view, myActionBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bar)));
    }

    @NonNull
    public static ActivityUiDemoRadiusBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUiDemoRadiusBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ui_demo_radius, viewGroup, false);
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
