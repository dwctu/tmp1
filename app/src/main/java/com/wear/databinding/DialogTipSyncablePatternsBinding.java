package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class DialogTipSyncablePatternsBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final TextView b;

    public DialogTipSyncablePatternsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3) {
        this.a = relativeLayout;
        this.b = textView2;
    }

    @NonNull
    public static DialogTipSyncablePatternsBinding a(@NonNull View view) {
        int i = R.id.btn_got_it;
        TextView textView = (TextView) view.findViewById(R.id.btn_got_it);
        if (textView != null) {
            i = R.id.discover_tip_layer;
            TextView textView2 = (TextView) view.findViewById(R.id.discover_tip_layer);
            if (textView2 != null) {
                i = R.id.iv_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
                if (imageView != null) {
                    i = R.id.tv_tip;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_tip);
                    if (textView3 != null) {
                        return new DialogTipSyncablePatternsBinding((RelativeLayout) view, textView, textView2, imageView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogTipSyncablePatternsBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTipSyncablePatternsBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_tip_syncable_patterns, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
