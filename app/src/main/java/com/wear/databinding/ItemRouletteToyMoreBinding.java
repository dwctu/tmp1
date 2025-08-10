package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class ItemRouletteToyMoreBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final TextView b;

    public ItemRouletteToyMoreBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.a = linearLayout;
        this.b = textView;
    }

    @NonNull
    public static ItemRouletteToyMoreBinding a(@NonNull View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_count);
        if (textView != null) {
            return new ItemRouletteToyMoreBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_count)));
    }

    @NonNull
    public static ItemRouletteToyMoreBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_roulette_toy_more, viewGroup, false);
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
