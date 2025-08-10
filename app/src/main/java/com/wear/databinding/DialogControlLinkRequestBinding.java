package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundButton;
import skin.support.widget.SkinCompatRelativeLayout;

/* loaded from: classes3.dex */
public final class DialogControlLinkRequestBinding implements ViewBinding {

    @NonNull
    public final SkinCompatRelativeLayout a;

    @NonNull
    public final SkinRoundButton b;

    @NonNull
    public final SkinRoundButton c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    public DialogControlLinkRequestBinding(@NonNull SkinCompatRelativeLayout skinCompatRelativeLayout, @NonNull SkinRoundButton skinRoundButton, @NonNull SkinRoundButton skinRoundButton2, @NonNull ImageView imageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull TextView textView) {
        this.a = skinCompatRelativeLayout;
        this.b = skinRoundButton;
        this.c = skinRoundButton2;
        this.d = imageView;
        this.e = textView;
    }

    @NonNull
    public static DialogControlLinkRequestBinding a(@NonNull View view) {
        int i = R.id.btn_accept;
        SkinRoundButton skinRoundButton = (SkinRoundButton) view.findViewById(R.id.btn_accept);
        if (skinRoundButton != null) {
            i = R.id.btn_decline;
            SkinRoundButton skinRoundButton2 = (SkinRoundButton) view.findViewById(R.id.btn_decline);
            if (skinRoundButton2 != null) {
                i = R.id.img_panel;
                ImageView imageView = (ImageView) view.findViewById(R.id.img_panel);
                if (imageView != null) {
                    i = R.id.ll_icon;
                    SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.ll_icon);
                    if (skinRoundAutoLinearLayout != null) {
                        i = R.id.tv_explain;
                        TextView textView = (TextView) view.findViewById(R.id.tv_explain);
                        if (textView != null) {
                            return new DialogControlLinkRequestBinding((SkinCompatRelativeLayout) view, skinRoundButton, skinRoundButton2, imageView, skinRoundAutoLinearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogControlLinkRequestBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogControlLinkRequestBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_control_link_request, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinCompatRelativeLayout getRoot() {
        return this.a;
    }
}
