package com.wear.widget.dialog;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import dc.gg3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/widget/dialog/CustomBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onOrientationChangeListener", "Lcom/wear/widget/dialog/CustomBottomSheetDialog$OnOrientationChangeListener;", "changeDialogLandscape", "", "changeDialogPortrait", "changeOrientation", "orientation", "", "setOnOrientationChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "show", "OnOrientationChangeListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class CustomBottomSheetDialog extends BottomSheetDialog {

    @Nullable
    public a a;

    /* compiled from: CustomBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/widget/dialog/CustomBottomSheetDialog$OnOrientationChangeListener;", "", "onOrientationChange", "", "orientation", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomBottomSheetDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = gg3.c(getContext());
            attributes.height = (int) (gg3.c(getContext()) * 0.9f);
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(2);
        }
    }

    public final void b() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
            }
            if (attributes != null) {
                attributes.height = -2;
            }
            if (attributes != null) {
                attributes.gravity = 80;
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(1);
        }
    }

    public final void c(int i) {
        if (isShowing()) {
            if (i == 1) {
                b();
            } else {
                if (i != 2) {
                    return;
                }
                a();
            }
        }
    }

    public final void d(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a = listener;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c(gg3.d(getContext()));
        getBehavior().setState(3);
    }
}
