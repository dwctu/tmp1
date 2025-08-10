package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class NewtoyNotoyrlLayoutBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TextView d;

    public NewtoyNotoyrlLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = relativeLayout;
        this.b = imageView;
        this.c = relativeLayout2;
        this.d = textView2;
    }

    @NonNull
    public static NewtoyNotoyrlLayoutBinding a(@NonNull View view) {
        int i = R.id.emptyIv;
        ImageView imageView = (ImageView) view.findViewById(R.id.emptyIv);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.newtoy_notoy2;
            TextView textView = (TextView) view.findViewById(R.id.newtoy_notoy2);
            if (textView != null) {
                i = R.id.newtoy_notoy3;
                TextView textView2 = (TextView) view.findViewById(R.id.newtoy_notoy3);
                if (textView2 != null) {
                    i = R.id.newtoy_searching_index;
                    TextView textView3 = (TextView) view.findViewById(R.id.newtoy_searching_index);
                    if (textView3 != null) {
                        return new NewtoyNotoyrlLayoutBinding(relativeLayout, imageView, relativeLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
