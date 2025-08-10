package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class NewtoyBtdisabledLayoutBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public NewtoyBtdisabledLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = relativeLayout;
        this.b = relativeLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    @NonNull
    public static NewtoyBtdisabledLayoutBinding a(@NonNull View view) {
        int i = R.id.newtoy_btdisablediv;
        ImageView imageView = (ImageView) view.findViewById(R.id.newtoy_btdisablediv);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.newtoy_btdisabledtv1;
            TextView textView = (TextView) view.findViewById(R.id.newtoy_btdisabledtv1);
            if (textView != null) {
                i = R.id.newtoy_btdisabledtv2;
                TextView textView2 = (TextView) view.findViewById(R.id.newtoy_btdisabledtv2);
                if (textView2 != null) {
                    i = R.id.newtoy_btn;
                    TextView textView3 = (TextView) view.findViewById(R.id.newtoy_btn);
                    if (textView3 != null) {
                        return new NewtoyBtdisabledLayoutBinding(relativeLayout, imageView, relativeLayout, textView, textView2, textView3);
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
