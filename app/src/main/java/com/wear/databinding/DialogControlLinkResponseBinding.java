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
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundButton;

/* loaded from: classes3.dex */
public final class DialogControlLinkResponseBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final SkinRoundButton b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public DialogControlLinkResponseBinding(@NonNull RelativeLayout relativeLayout, @NonNull SkinRoundButton skinRoundButton, @NonNull SkinRoundButton skinRoundButton2, @NonNull ImageView imageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = relativeLayout;
        this.b = skinRoundButton2;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    @NonNull
    public static DialogControlLinkResponseBinding a(@NonNull View view) {
        int i = R.id.btn_accept;
        SkinRoundButton skinRoundButton = (SkinRoundButton) view.findViewById(R.id.btn_accept);
        if (skinRoundButton != null) {
            i = R.id.btn_cancel;
            SkinRoundButton skinRoundButton2 = (SkinRoundButton) view.findViewById(R.id.btn_cancel);
            if (skinRoundButton2 != null) {
                i = R.id.img_panel;
                ImageView imageView = (ImageView) view.findViewById(R.id.img_panel);
                if (imageView != null) {
                    i = R.id.ll_icon;
                    SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ll_icon);
                    if (skinRoundAutoLinearLayout != null) {
                        i = R.id.ll_title;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_title);
                        if (linearLayout != null) {
                            i = R.id.tv_explain;
                            TextView textView = (TextView) view.findViewById(R.id.tv_explain);
                            if (textView != null) {
                                i = R.id.tv_title;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                                if (textView2 != null) {
                                    return new DialogControlLinkResponseBinding((RelativeLayout) view, skinRoundButton, skinRoundButton2, imageView, skinRoundAutoLinearLayout, linearLayout, textView, textView2);
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
    public static DialogControlLinkResponseBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogControlLinkResponseBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_control_link_response, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
