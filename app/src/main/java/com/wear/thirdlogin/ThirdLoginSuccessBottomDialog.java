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
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.thirdlogin.ThirdLoginSuccessBottomDialog;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.kf;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThirdLoginSuccessBottomDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0003J\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/thirdlogin/ThirdLoginSuccessBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", FirebaseAnalytics.Param.CONTENT, "", "ivUrl", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "getView", "Landroid/view/View;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ThirdLoginSuccessBottomDialog extends BottomSheetDialog {

    @NotNull
    public final Activity a;

    @NotNull
    public final String b;

    @NotNull
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdLoginSuccessBottomDialog(@NotNull Activity activity, @NotNull String content, @NotNull String ivUrl) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(ivUrl, "ivUrl");
        this.a = activity;
        this.b = content;
        this.c = ivUrl;
    }

    public static final void c(ThirdLoginSuccessBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @NotNull
    public final View a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.third_login_success_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…gin_success_dialog, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_user_head);
        if (imageView != null) {
            if (this.c.length() == 0) {
                imageView.setImageResource(R.drawable.chat_avatar_default);
                Unit unit = Unit.INSTANCE;
            } else {
                if (!StringsKt__StringsJVMKt.startsWith$default(this.c, "http", false, 2, null)) {
                    this.c = WearUtils.e + this.c;
                }
                Intrinsics.checkNotNullExpressionValue(kf.v(this.a).v(this.c).A0(imageView), "{\n                if (!i…nto(ivUser)\n            }");
            }
        }
        Button button = (Button) findViewById(R.id.btn_got_it);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: dc.nq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThirdLoginSuccessBottomDialog.c(this.a, view);
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.tv_content);
        if (textView == null) {
            return;
        }
        textView.setText(this.b);
    }

    public final void d() {
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
        d();
        b();
    }
}
