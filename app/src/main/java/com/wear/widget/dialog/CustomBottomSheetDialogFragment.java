package com.wear.widget.dialog;

import android.app.Dialog;
import android.content.res.Configuration;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import dc.gg3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CustomBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/wear/widget/dialog/CustomBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "changeDialogLandscape", "", "changeDialogPortrait", "changeOrientation", "orientation", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResume", "onStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {
    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        v(gg3.d(getContext()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        v(gg3.d(getContext()));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) parent);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(parent)");
            bottomSheetBehaviorFrom.setState(3);
        }
    }

    public final void t() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = gg3.c(getContext());
        attributes.height = (int) (gg3.c(getContext()) * 0.9f);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public final void u() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = (int) (gg3.c(getContext()) * 0.9f);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public final void v(int i) {
        if (isAdded()) {
            if (i == 1) {
                u();
            } else {
                if (i != 2) {
                    return;
                }
                t();
            }
        }
    }
}
