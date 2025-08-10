package dc;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.databinding.DialogControlLinkRequestBinding;
import com.wear.util.MyApplication;
import dc.d83;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlLinkRequestControlDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkRequestControlDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/widget/dialog/ControlLinkRequestControlDialog$Listener;", "getListener", "()Lcom/wear/widget/dialog/ControlLinkRequestControlDialog$Listener;", "setListener", "(Lcom/wear/widget/dialog/ControlLinkRequestControlDialog$Listener;)V", "mBinding", "Lcom/wear/databinding/DialogControlLinkRequestBinding;", "mType", "", "popupWindow", "Landroid/widget/PopupWindow;", "dismiss", "", "initView", "isShowing", "", "setType", "type", "showAsDropDown", "anchor", "Landroid/view/View;", "Listener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class zr3 {

    @NotNull
    public final Context a;
    public DialogControlLinkRequestBinding b;

    @Nullable
    public a c;

    @Nullable
    public PopupWindow d;

    @Nullable
    public String e;

    /* compiled from: ControlLinkRequestControlDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkRequestControlDialog$Listener;", "", "accept", "", "decline", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void accept();
    }

    public zr3(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.e = "";
        b();
    }

    public static final void c(zr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void d(zr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.accept();
        }
    }

    public final void a() {
        PopupWindow popupWindow = this.d;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void b() {
        DialogControlLinkRequestBinding dialogControlLinkRequestBindingC = DialogControlLinkRequestBinding.c(LayoutInflater.from(MyApplication.N()));
        Intrinsics.checkNotNullExpressionValue(dialogControlLinkRequestBindingC, "inflate(LayoutInflater.f…cation.getMyAppcation()))");
        this.b = dialogControlLinkRequestBindingC;
        PopupWindow popupWindow = new PopupWindow(this.a);
        this.d = popupWindow;
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding = null;
        if (popupWindow != null) {
            DialogControlLinkRequestBinding dialogControlLinkRequestBinding2 = this.b;
            if (dialogControlLinkRequestBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                dialogControlLinkRequestBinding2 = null;
            }
            popupWindow.setContentView(dialogControlLinkRequestBinding2.getRoot());
        }
        PopupWindow popupWindow2 = this.d;
        if (popupWindow2 != null) {
            popupWindow2.setFocusable(false);
        }
        PopupWindow popupWindow3 = this.d;
        if (popupWindow3 != null) {
            popupWindow3.setWidth(-1);
        }
        PopupWindow popupWindow4 = this.d;
        if (popupWindow4 != null) {
            popupWindow4.setHeight(-2);
        }
        PopupWindow popupWindow5 = this.d;
        if (popupWindow5 != null) {
            popupWindow5.setBackgroundDrawable(new ColorDrawable(0));
        }
        PopupWindow popupWindow6 = this.d;
        if (popupWindow6 != null) {
            popupWindow6.setAnimationStyle(R.style.ActionSheetDialogAnimation);
        }
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding3 = this.b;
        if (dialogControlLinkRequestBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkRequestBinding3 = null;
        }
        dialogControlLinkRequestBinding3.c.setOnClickListener(new View.OnClickListener() { // from class: dc.eq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                zr3.c(this.a, view);
            }
        });
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding4 = this.b;
        if (dialogControlLinkRequestBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dialogControlLinkRequestBinding = dialogControlLinkRequestBinding4;
        }
        dialogControlLinkRequestBinding.b.setOnClickListener(new View.OnClickListener() { // from class: dc.fq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                zr3.d(this.a, view);
            }
        });
    }

    public final boolean e() {
        PopupWindow popupWindow = this.d;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void h(@Nullable a aVar) {
        this.c = aVar;
    }

    public final void i(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.e = type;
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding = null;
        if (StringsKt__StringsJVMKt.equals$default(type, d83.d.live_control.name(), false, 2, null)) {
            DialogControlLinkRequestBinding dialogControlLinkRequestBinding2 = this.b;
            if (dialogControlLinkRequestBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                dialogControlLinkRequestBinding2 = null;
            }
            dialogControlLinkRequestBinding2.d.setImageResource(R.drawable.icon_control_request_dialog);
            DialogControlLinkRequestBinding dialogControlLinkRequestBinding3 = this.b;
            if (dialogControlLinkRequestBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                dialogControlLinkRequestBinding = dialogControlLinkRequestBinding3;
            }
            dialogControlLinkRequestBinding.e.setText(ah4.e(R.string.control_link_live_control_requested));
            return;
        }
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding4 = this.b;
        if (dialogControlLinkRequestBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkRequestBinding4 = null;
        }
        dialogControlLinkRequestBinding4.d.setImageResource(R.drawable.icon_control_request_sync_dialog);
        DialogControlLinkRequestBinding dialogControlLinkRequestBinding5 = this.b;
        if (dialogControlLinkRequestBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dialogControlLinkRequestBinding = dialogControlLinkRequestBinding5;
        }
        dialogControlLinkRequestBinding.e.setText(ah4.e(R.string.control_link_sync_control_requested));
    }

    public final void j(@Nullable View view) {
        try {
            PopupWindow popupWindow = this.d;
            if (popupWindow != null) {
                popupWindow.showAsDropDown(view, 0, ce3.a(this.a, -1.0f));
            }
        } catch (Exception unused) {
        }
    }
}
