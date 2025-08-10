package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import skin.support.widget.SkinAutoLinearLayout;

/* loaded from: classes3.dex */
public final class ActivityUiDemoButtonBinding implements ViewBinding {

    @NonNull
    public final SkinAutoLinearLayout a;

    @NonNull
    public final MyActionBar b;

    public ActivityUiDemoButtonBinding(@NonNull SkinAutoLinearLayout skinAutoLinearLayout, @NonNull MyActionBar myActionBar) {
        this.a = skinAutoLinearLayout;
        this.b = myActionBar;
    }

    @NonNull
    public static ActivityUiDemoButtonBinding a(@NonNull View view) {
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.bar);
        if (myActionBar != null) {
            return new ActivityUiDemoButtonBinding((SkinAutoLinearLayout) view, myActionBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bar)));
    }

    @NonNull
    public static ActivityUiDemoButtonBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUiDemoButtonBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ui_demo_button, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinAutoLinearLayout getRoot() {
        return this.a;
    }
}
