package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class ViewVelvoPreviewBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    public ViewVelvoPreviewBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView) {
        this.a = cardView;
        this.b = linearLayout;
        this.c = imageView;
        this.d = imageView3;
        this.e = imageView4;
        this.f = textView;
    }

    @NonNull
    public static ViewVelvoPreviewBinding a(@NonNull View view) {
        int i = R.id.container_velvo_preview;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container_velvo_preview);
        if (linearLayout != null) {
            i = R.id.toy_velvo_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.toy_velvo_container);
            if (relativeLayout != null) {
                i = R.id.toy_velvo_left;
                ImageView imageView = (ImageView) view.findViewById(R.id.toy_velvo_left);
                if (imageView != null) {
                    i = R.id.toy_velvo_right;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.toy_velvo_right);
                    if (imageView2 != null) {
                        i = R.id.velvo_expand;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.velvo_expand);
                        if (imageView3 != null) {
                            i = R.id.velvo_hidden;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.velvo_hidden);
                            if (imageView4 != null) {
                                i = R.id.velvo_show_name;
                                TextView textView = (TextView) view.findViewById(R.id.velvo_show_name);
                                if (textView != null) {
                                    return new ViewVelvoPreviewBinding((CardView) view, linearLayout, relativeLayout, imageView, imageView2, imageView3, imageView4, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewVelvoPreviewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_velvo_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
