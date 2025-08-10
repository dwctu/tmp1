package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes3.dex */
public final class ItemInteractiveVideoDataBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final MediumBoldTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final MediumBoldTextView f;

    @NonNull
    public final MediumBoldTextView g;

    @NonNull
    public final ImageView h;

    public ItemInteractiveVideoDataBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull TextView textView, @NonNull MediumBoldTextView mediumBoldTextView2, @NonNull MediumBoldTextView mediumBoldTextView3, @NonNull ImageView imageView3) {
        this.a = cardView;
        this.b = imageView;
        this.c = imageView2;
        this.d = mediumBoldTextView;
        this.e = textView;
        this.f = mediumBoldTextView2;
        this.g = mediumBoldTextView3;
        this.h = imageView3;
    }

    @NonNull
    public static ItemInteractiveVideoDataBinding a(@NonNull View view) {
        int i = R.id.iv_like;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_like);
        if (imageView != null) {
            i = R.id.iv_site_icon;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_site_icon);
            if (imageView2 != null) {
                i = R.id.tv_content;
                MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) view.findViewById(R.id.tv_content);
                if (mediumBoldTextView != null) {
                    i = R.id.tv_new_flag;
                    TextView textView = (TextView) view.findViewById(R.id.tv_new_flag);
                    if (textView != null) {
                        i = R.id.tv_time;
                        MediumBoldTextView mediumBoldTextView2 = (MediumBoldTextView) view.findViewById(R.id.tv_time);
                        if (mediumBoldTextView2 != null) {
                            i = R.id.tv_title;
                            MediumBoldTextView mediumBoldTextView3 = (MediumBoldTextView) view.findViewById(R.id.tv_title);
                            if (mediumBoldTextView3 != null) {
                                i = R.id.video_pic_iv;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.video_pic_iv);
                                if (imageView3 != null) {
                                    return new ItemInteractiveVideoDataBinding((CardView) view, imageView, imageView2, mediumBoldTextView, textView, mediumBoldTextView2, mediumBoldTextView3, imageView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
