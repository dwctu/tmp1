package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class NewtoySearchfailedLayoutBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final ImageView d;

    public NewtoySearchfailedLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = relativeLayout;
        this.b = textView;
        this.c = relativeLayout2;
        this.d = imageView3;
    }

    @NonNull
    public static NewtoySearchfailedLayoutBinding a(@NonNull View view) {
        int i = R.id.failed_tv;
        TextView textView = (TextView) view.findViewById(R.id.failed_tv);
        if (textView != null) {
            i = R.id.iv1;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv1);
            if (imageView != null) {
                i = R.id.iv2;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv2);
                if (imageView2 != null) {
                    i = R.id.lly;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lly);
                    if (linearLayout != null) {
                        i = R.id.lly2;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.lly2);
                        if (linearLayout2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i = R.id.searchnotoyIv;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.searchnotoyIv);
                            if (imageView3 != null) {
                                i = R.id.tv;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv);
                                if (textView2 != null) {
                                    i = R.id.tv1;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv1);
                                    if (textView3 != null) {
                                        i = R.id.tv2;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv2);
                                        if (textView4 != null) {
                                            return new NewtoySearchfailedLayoutBinding(relativeLayout, textView, imageView, imageView2, linearLayout, linearLayout2, relativeLayout, imageView3, textView2, textView3, textView4);
                                        }
                                    }
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
    public RelativeLayout getRoot() {
        return this.a;
    }
}
