package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.seekbar.RangeSeekBar;

/* loaded from: classes3.dex */
public final class ItemMytoyitemStrokeRangeBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final RangeSeekBar c;

    public ItemMytoyitemStrokeRangeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RangeSeekBar rangeSeekBar) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = rangeSeekBar;
    }

    @NonNull
    public static ItemMytoyitemStrokeRangeBinding a(@NonNull View view) {
        int i = R.id.mytoy_item1_funcationbg;
        ImageView imageView = (ImageView) view.findViewById(R.id.mytoy_item1_funcationbg);
        if (imageView != null) {
            i = R.id.mytoy_item1_funcationname;
            TextView textView = (TextView) view.findViewById(R.id.mytoy_item1_funcationname);
            if (textView != null) {
                i = R.id.mytoy_stroke_seekbar;
                RangeSeekBar rangeSeekBar = (RangeSeekBar) view.findViewById(R.id.mytoy_stroke_seekbar);
                if (rangeSeekBar != null) {
                    return new ItemMytoyitemStrokeRangeBinding((ConstraintLayout) view, imageView, textView, rangeSeekBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
