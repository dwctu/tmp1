package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundButton;
import skin.support.widget.SkinCompatScrollView;

/* loaded from: classes3.dex */
public final class ActivityXremoteDialogTestBinding implements ViewBinding {

    @NonNull
    public final SkinCompatScrollView a;

    @NonNull
    public final SkinRoundButton b;

    @NonNull
    public final SkinRoundButton c;

    @NonNull
    public final SkinRoundButton d;

    @NonNull
    public final SkinRoundButton e;

    @NonNull
    public final SkinRoundButton f;

    public ActivityXremoteDialogTestBinding(@NonNull SkinCompatScrollView skinCompatScrollView, @NonNull SkinRoundButton skinRoundButton, @NonNull SkinRoundButton skinRoundButton2, @NonNull SkinRoundButton skinRoundButton3, @NonNull SkinRoundButton skinRoundButton4, @NonNull SkinRoundButton skinRoundButton5) {
        this.a = skinCompatScrollView;
        this.b = skinRoundButton;
        this.c = skinRoundButton2;
        this.d = skinRoundButton3;
        this.e = skinRoundButton4;
        this.f = skinRoundButton5;
    }

    @NonNull
    public static ActivityXremoteDialogTestBinding a(@NonNull View view) {
        int i = R.id.btn_dialog_1;
        SkinRoundButton skinRoundButton = (SkinRoundButton) view.findViewById(R.id.btn_dialog_1);
        if (skinRoundButton != null) {
            i = R.id.btn_dialog_2;
            SkinRoundButton skinRoundButton2 = (SkinRoundButton) view.findViewById(R.id.btn_dialog_2);
            if (skinRoundButton2 != null) {
                i = R.id.btn_dialog_3;
                SkinRoundButton skinRoundButton3 = (SkinRoundButton) view.findViewById(R.id.btn_dialog_3);
                if (skinRoundButton3 != null) {
                    i = R.id.btn_dialog_4;
                    SkinRoundButton skinRoundButton4 = (SkinRoundButton) view.findViewById(R.id.btn_dialog_4);
                    if (skinRoundButton4 != null) {
                        i = R.id.btn_dialog_5;
                        SkinRoundButton skinRoundButton5 = (SkinRoundButton) view.findViewById(R.id.btn_dialog_5);
                        if (skinRoundButton5 != null) {
                            return new ActivityXremoteDialogTestBinding((SkinCompatScrollView) view, skinRoundButton, skinRoundButton2, skinRoundButton3, skinRoundButton4, skinRoundButton5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityXremoteDialogTestBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityXremoteDialogTestBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_xremote_dialog_test, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinCompatScrollView getRoot() {
        return this.a;
    }
}
