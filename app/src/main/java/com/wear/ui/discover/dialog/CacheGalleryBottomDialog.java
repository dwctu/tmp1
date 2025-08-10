package com.wear.ui.discover.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lovense.wear.R;
import com.wear.ui.discover.dialog.CacheGalleryBottomDialog;
import com.wear.widget.SwitchView;
import dc.ce3;
import dc.eg3;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CacheGalleryBottomDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0003J\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/wear/ui/discover/dialog/CacheGalleryBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "layoutResouce", "", "(Landroidx/appcompat/app/AppCompatActivity;I)V", "getView", "Landroid/view/View;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheGalleryBottomDialog extends BottomSheetDialog {
    public final int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheGalleryBottomDialog(@NotNull AppCompatActivity activity, int i) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = i;
    }

    public static final void c(CacheGalleryBottomDialog this$0, CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eg3.j(this$0.getContext(), "switchClearCache", z);
    }

    public static final void d(CacheGalleryBottomDialog this$0, CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eg3.j(this$0.getContext(), "switchWihteList", z);
    }

    @NotNull
    public final View a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.a, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(layoutResouce, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        boolean zD = eg3.d(getContext(), "switchClearCache", true);
        SwitchView switchView = (SwitchView) findViewById(R.id.setting_clear_cache_switch);
        if (switchView != null) {
            switchView.setCheckedImmediatelyNoEvent(zD);
        }
        if (switchView != null) {
            switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.mw2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    CacheGalleryBottomDialog.c(this.a, compoundButton, z);
                }
            });
        }
        boolean zD2 = eg3.d(getContext(), "switchWihteList", false);
        SwitchView switchView2 = (SwitchView) findViewById(R.id.setting_clear_white_list_switch1);
        if (switchView2 != null) {
            switchView2.setCheckedImmediatelyNoEvent(zD2);
        }
        if (switchView2 != null) {
            switchView2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.lw2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    CacheGalleryBottomDialog.d(this.a, compoundButton, z);
                }
            });
        }
    }

    public final void e() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, ce3.a(getContext(), 60.0f), 0, 0);
        }
        setCancelable(true);
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "this.behavior");
        behavior.setPeekHeight(ce3.a(getContext(), 600.0f));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(a());
        e();
        b();
    }
}
