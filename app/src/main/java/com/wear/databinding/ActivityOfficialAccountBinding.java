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
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityOfficialAccountBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final SmartRefreshLayout d;

    public ActivityOfficialAccountBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = recyclerView;
        this.d = smartRefreshLayout;
    }

    @NonNull
    public static ActivityOfficialAccountBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.recyclerview;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
            if (recyclerView != null) {
                i = R.id.smartRefresh;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smartRefresh);
                if (smartRefreshLayout != null) {
                    return new ActivityOfficialAccountBinding((LinearLayout) view, myActionBar, recyclerView, smartRefreshLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityOfficialAccountBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityOfficialAccountBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_official_account, viewGroup, false);
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
