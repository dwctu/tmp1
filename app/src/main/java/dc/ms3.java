package dc;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.databinding.DialogUiStandardBaseBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIStandardCommonDialog.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/wear/widget/dialog/UIStandardCommonDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBinding", "Lcom/wear/databinding/DialogUiStandardBaseBinding;", "setContent", "spannableString", "Landroid/text/SpannableString;", FirebaseAnalytics.Param.CONTENT, "", "setNegativeBtnVisibility", "visibility", "", "setNegativeText", "negativeText", "setOnBtnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/widget/dialog/UIStandardCommonDialog$OnBtnClickListener;", "setPositiveText", "positiveText", "setTitle", MessageBundle.TITLE_ENTRY, "OnBtnClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ms3 extends Dialog {

    @NotNull
    public DialogUiStandardBaseBinding a;

    /* compiled from: UIStandardCommonDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/wear/widget/dialog/UIStandardCommonDialog$OnBtnClickListener;", "", "onNegativeClick", "", "onPositiveClick", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms3(@NotNull Context context) {
        super(context, R.style.dialog);
        Intrinsics.checkNotNullParameter(context, "context");
        DialogUiStandardBaseBinding dialogUiStandardBaseBindingC = DialogUiStandardBaseBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(dialogUiStandardBaseBindingC, "inflate(LayoutInflater.from(context))");
        this.a = dialogUiStandardBaseBindingC;
        setContentView(dialogUiStandardBaseBindingC.getRoot());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ce3.a(getContext(), 311.0f);
        window.setAttributes(attributes);
        this.a.d.setOnClickListener(new View.OnClickListener() { // from class: dc.mr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ms3.a(this.a, view);
            }
        });
        this.a.c.setOnClickListener(new View.OnClickListener() { // from class: dc.nr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ms3.b(this.a, view);
            }
        });
    }

    public static final void a(ms3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void b(ms3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void i(a aVar, ms3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar != null) {
            aVar.b();
        }
        this$0.dismiss();
    }

    public static final void j(a aVar, ms3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismiss();
    }

    @NotNull
    public final ms3 g(@Nullable SpannableString spannableString) {
        this.a.b.setText(spannableString);
        this.a.b.setMovementMethod(LinkMovementMethod.getInstance());
        return this;
    }

    @NotNull
    public final ms3 h(@Nullable final a aVar) {
        this.a.d.setOnClickListener(new View.OnClickListener() { // from class: dc.pr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ms3.i(aVar, this, view);
            }
        });
        this.a.c.setOnClickListener(new View.OnClickListener() { // from class: dc.or3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ms3.j(aVar, this, view);
            }
        });
        return this;
    }

    @NotNull
    public final ms3 k(@Nullable String str) {
        this.a.d.setText(str);
        return this;
    }
}
