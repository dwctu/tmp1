package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;

/* loaded from: classes3.dex */
public final class ActivityControlRouletteNoticeBinding implements ViewBinding {

    @NonNull
    public final SkinRoundAutoRelativeLayout a;

    @NonNull
    public final MyActionBar b;

    public ActivityControlRouletteNoticeBinding(@NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout, @NonNull MyActionBar myActionBar) {
        this.a = skinRoundAutoRelativeLayout;
        this.b = myActionBar;
    }

    @NonNull
    public static ActivityControlRouletteNoticeBinding a(@NonNull View view) {
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            return new ActivityControlRouletteNoticeBinding((SkinRoundAutoRelativeLayout) view, myActionBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.actionbar)));
    }

    @NonNull
    public static ActivityControlRouletteNoticeBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityControlRouletteNoticeBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_control_roulette_notice, viewGroup, false);
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
