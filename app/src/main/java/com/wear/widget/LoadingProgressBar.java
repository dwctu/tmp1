package com.wear.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class LoadingProgressBar extends LinearLayout {
    public LayoutInflater a;
    public RelativeLayout b;

    public LoadingProgressBar(Context context) {
        super(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.loading_progressbar, (ViewGroup) null);
        this.b = relativeLayout;
        addView(relativeLayout);
    }
}
