package com.wear.widget;

import android.annotation.SuppressLint;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lovense.wear.R;
import com.wear.widget.NewGalleryBottomDialog;
import dc.ah4;
import dc.ce3;
import dc.on3;
import dc.wi1;
import dc.ye3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewGalleryBottomDialog.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0003J\u0006\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/wear/widget/NewGalleryBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "layoutResouce", "", "type", "rect", "Landroid/graphics/Rect;", "bottomClickListener", "Lcom/wear/widget/NewGalleryBottomDialog$ClickListener;", "(Landroidx/appcompat/app/AppCompatActivity;IILandroid/graphics/Rect;Lcom/wear/widget/NewGalleryBottomDialog$ClickListener;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getView", "Landroid/view/View;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class NewGalleryBottomDialog extends BottomSheetDialog {
    public final int a;
    public final int b;

    @NotNull
    public final Rect c;

    @Nullable
    public final a d;

    /* compiled from: NewGalleryBottomDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/NewGalleryBottomDialog$ClickListener;", "", "doCancel", "", "doConfirm", "name", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@Nullable String str);
    }

    /* compiled from: NewGalleryBottomDialog.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/wear/widget/NewGalleryBottomDialog$initData$1$1", "Lcom/wear/widget/EditDialog$ClickListener;", "doCancel", "", "doConfirm", "name", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements on3.c {
        public final /* synthetic */ TextView b;

        public b(TextView textView) {
            this.b = textView;
        }

        @Override // dc.on3.c
        public void a(@Nullable String str) {
            ye3.j("game", "apply_to_be_a_developer_popup_click", "click", "apply_to_be_a_developer_popup", "button", "ok", "", -1L);
            a aVar = NewGalleryBottomDialog.this.d;
            if (aVar != null) {
                aVar.a(str);
            }
            this.b.setText(ah4.e(R.string.application_successful));
            this.b.setBackgroundResource(R.drawable.bg_cccccc_gary_22);
            wi1.a(this.b, false);
        }

        @Override // dc.on3.c
        public void doCancel() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewGalleryBottomDialog(@NotNull AppCompatActivity activity, int i, int i2, @NotNull Rect rect, @Nullable a aVar) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.a = i;
        this.b = i2;
        this.c = rect;
        this.d = aVar;
    }

    public static final void d(NewGalleryBottomDialog this$0, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b == 1) {
            ye3.j("game", "apply_to_be_a_developer_click", "click", "apply_to_be_a_developer", "button", "1", "", -1L);
            new on3(this$0.getContext(), ah4.e(R.string.common_email), ah4.e(R.string.button_apply_developer), this$0.new b(textView));
        } else {
            ye3.i("game", "game_welcome_popup_click", "click", "game_welcome_popup", "popup");
            this$0.dismiss();
        }
    }

    @NotNull
    public final View b() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.a, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(layoutResouce, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void c() {
        final TextView textView = (TextView) findViewById(R.id.tv_dismiss);
        if (this.b == 1) {
            if (textView != null) {
                textView.setText(ah4.e(R.string.button_apply_developer));
            }
        } else if (textView != null) {
            textView.setText(ah4.e(R.string.button_continue));
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: dc.gn3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewGalleryBottomDialog.d(this.a, textView, view);
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.c.contains((int) ev.getRawX(), (int) ev.getRawY())) {
            return super.dispatchTouchEvent(ev);
        }
        cancel();
        return true;
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
        setContentView(b());
        e();
        c();
    }
}
