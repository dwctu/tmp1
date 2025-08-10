package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class ViewRoulettePlayBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public ViewRoulettePlayBinding(@NonNull TextView textView) {
        this.a = textView;
    }

    @NonNull
    public static ViewRoulettePlayBinding a(@NonNull View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewRoulettePlayBinding((TextView) view);
    }

    @NonNull
    public static ViewRoulettePlayBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_roulette_play, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.a;
    }
}
