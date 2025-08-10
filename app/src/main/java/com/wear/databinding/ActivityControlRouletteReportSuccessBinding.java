package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;

/* loaded from: classes3.dex */
public final class ActivityControlRouletteReportSuccessBinding implements ViewBinding {

    @NonNull
    public final SkinRoundAutoRelativeLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final TextView c;

    public ActivityControlRouletteReportSuccessBinding(@NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout, @NonNull MyActionBar myActionBar, @NonNull TextView textView) {
        this.a = skinRoundAutoRelativeLayout;
        this.b = myActionBar;
        this.c = textView;
    }

    @NonNull
    public static ActivityControlRouletteReportSuccessBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.tv_ok;
            TextView textView = (TextView) view.findViewById(R.id.tv_ok);
            if (textView != null) {
                return new ActivityControlRouletteReportSuccessBinding((SkinRoundAutoRelativeLayout) view, myActionBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityControlRouletteReportSuccessBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityControlRouletteReportSuccessBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_control_roulette_report_success, viewGroup, false);
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
