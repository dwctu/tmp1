package com.wear.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lovense.wear.R;
import com.wear.widget.dialog.GameModeWelcomeDialog;
import dc.ce3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GameModeWelcomeDialog.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0003J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/widget/dialog/GameModeWelcomeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "rect", "Landroid/graphics/Rect;", "(Landroid/content/Context;Landroid/graphics/Rect;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getView", "Landroid/view/View;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GameModeWelcomeDialog extends BottomSheetDialog {

    @NotNull
    public final Context a;

    @NotNull
    public final Rect b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameModeWelcomeDialog(@NotNull Context context, @NotNull Rect rect) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.a = context;
        this.b = rect;
    }

    public static final void c(GameModeWelcomeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @NotNull
    public final View a() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_game_mode_welcome, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…_game_mode_welcome, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        TextView textView = (TextView) findViewById(R.id.tv_dismiss);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: dc.kq3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameModeWelcomeDialog.c(this.a, view);
                }
            });
        }
    }

    public final void d() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, ce3.a(this.a, 60.0f), 0, 0);
        }
        setCancelable(true);
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "this.behavior");
        behavior.setPeekHeight(ce3.a(this.a, 600.0f));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.b.contains((int) ev.getRawX(), (int) ev.getRawY())) {
            return super.dispatchTouchEvent(ev);
        }
        cancel();
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(a());
        d();
        b();
    }
}
