package com.wear.thirdlogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lovense.wear.R;
import com.wear.thirdlogin.ThirdCheckBindBottomDialog;
import dc.ce3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThirdCheckBindBottomDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0003J\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/thirdlogin/ThirdCheckBindBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "bottomClickListener", "Lcom/wear/thirdlogin/ThirdCheckBindBottomDialog$ClickListener;", "(Landroid/app/Activity;Lcom/wear/thirdlogin/ThirdCheckBindBottomDialog$ClickListener;)V", "getView", "Landroid/view/View;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ThirdCheckBindBottomDialog extends BottomSheetDialog {

    @Nullable
    public final a a;

    /* compiled from: ThirdCheckBindBottomDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/wear/thirdlogin/ThirdCheckBindBottomDialog$ClickListener;", "", "bindAccount", "", "createNewAccount", "doCancel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void b();

        void doCancel();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdCheckBindBottomDialog(@NotNull Activity activity, @Nullable a aVar) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = aVar;
    }

    public static final void c(ThirdCheckBindBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.a;
        if (aVar != null) {
            aVar.doCancel();
        }
        this$0.dismiss();
    }

    public static final void d(ThirdCheckBindBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.a;
        if (aVar != null) {
            aVar.b();
        }
        this$0.dismiss();
    }

    public static final void e(ThirdCheckBindBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.a;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismiss();
    }

    @NotNull
    public final View a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.bind_account_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…ind_account_dialog, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.lq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdCheckBindBottomDialog.c(this.a, view);
                }
            });
        }
        Button button = (Button) findViewById(R.id.btn_bind_account);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: dc.kq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdCheckBindBottomDialog.d(this.a, view);
                }
            });
        }
        Button button2 = (Button) findViewById(R.id.btn_create_account);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: dc.mq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdCheckBindBottomDialog.e(this.a, view);
                }
            });
        }
    }

    public final void f() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, ce3.a(getContext(), 60.0f), 0, 0);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(a());
        f();
        b();
    }
}
