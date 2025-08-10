package com.wear.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundButton;

/* loaded from: classes3.dex */
public final class DialogControlLinkPermissionBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final SkinRoundButton b;

    @NonNull
    public final SkinRoundButton c;

    @NonNull
    public final TextView d;

    public DialogControlLinkPermissionBinding(@NonNull RelativeLayout relativeLayout, @NonNull SkinRoundButton skinRoundButton, @NonNull SkinRoundButton skinRoundButton2, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.b = skinRoundButton;
        this.c = skinRoundButton2;
        this.d = textView;
    }

    @NonNull
    public static DialogControlLinkPermissionBinding a(@NonNull View view) {
        int i = R.id.btn_cancel;
        SkinRoundButton skinRoundButton = (SkinRoundButton) view.findViewById(R.id.btn_cancel);
        if (skinRoundButton != null) {
            i = R.id.btn_ok;
            SkinRoundButton skinRoundButton2 = (SkinRoundButton) view.findViewById(R.id.btn_ok);
            if (skinRoundButton2 != null) {
                i = R.id.tv_describe;
                TextView textView = (TextView) view.findViewById(R.id.tv_describe);
                if (textView != null) {
                    return new DialogControlLinkPermissionBinding((RelativeLayout) view, skinRoundButton, skinRoundButton2, textView);
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
