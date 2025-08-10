package com.wear.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes3.dex */
public final class ItemInteractivePatternDataAdBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MediumBoldTextView b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final CardView d;

    @NonNull
    public final TextView e;

    public ItemInteractivePatternDataAdBinding(@NonNull LinearLayout linearLayout, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.b = mediumBoldTextView;
        this.c = constraintLayout;
        this.d = cardView;
        this.e = textView;
    }

    @NonNull
    public static ItemInteractivePatternDataAdBinding a(@NonNull View view) {
        int i = R.id.ad_content_tv;
        MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) view.findViewById(R.id.ad_content_tv);
        if (mediumBoldTextView != null) {
            i = R.id.no_more_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.no_more_layout);
            if (constraintLayout != null) {
                i = R.id.top_ad_layout;
                CardView cardView = (CardView) view.findViewById(R.id.top_ad_layout);
                if (cardView != null) {
                    i = R.id.tv_no_more;
                    TextView textView = (TextView) view.findViewById(R.id.tv_no_more);
                    if (textView != null) {
                        return new ItemInteractivePatternDataAdBinding((LinearLayout) view, mediumBoldTextView, constraintLayout, cardView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
