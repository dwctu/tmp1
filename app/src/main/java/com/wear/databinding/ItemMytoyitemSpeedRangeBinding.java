package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.seekbar.RangeSeekBar;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ItemMytoyitemSpeedRangeBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final RangeSeekBar c;

    public ItemMytoyitemSpeedRangeBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RangeSeekBar rangeSeekBar) {
        this.a = skinCompatConstraintLayout;
        this.b = textView;
        this.c = rangeSeekBar;
    }

    @NonNull
    public static ItemMytoyitemSpeedRangeBinding a(@NonNull View view) {
        int i = R.id.mytoy_item1_funcationbg;
        ImageView imageView = (ImageView) view.findViewById(R.id.mytoy_item1_funcationbg);
        if (imageView != null) {
            i = R.id.mytoy_item1_funcationname;
            TextView textView = (TextView) view.findViewById(R.id.mytoy_item1_funcationname);
            if (textView != null) {
                i = R.id.mytoy_stroke_seekbar;
                RangeSeekBar rangeSeekBar = (RangeSeekBar) view.findViewById(R.id.mytoy_stroke_seekbar);
                if (rangeSeekBar != null) {
                    return new ItemMytoyitemSpeedRangeBinding((SkinCompatConstraintLayout) view, imageView, textView, rangeSeekBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinCompatConstraintLayout getRoot() {
        return this.a;
    }
}
