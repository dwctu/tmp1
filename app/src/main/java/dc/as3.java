package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.databinding.DialogControlLinkResponseBinding;
import com.wear.util.MyApplication;
import dc.d83;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlLinkResponseControlDialog.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0007J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0010J\u000e\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u001eJ\u0010\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000104R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00066"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkResponseControlDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorSpan", "Landroid/text/style/ForegroundColorSpan;", "getColorSpan", "()Landroid/text/style/ForegroundColorSpan;", "doStr", "", "getDoStr", "()Ljava/lang/String;", "setDoStr", "(Ljava/lang/String;)V", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/widget/dialog/ControlLinkResponseControlDialog$Listener;", "getListener", "()Lcom/wear/widget/dialog/ControlLinkResponseControlDialog$Listener;", "setListener", "(Lcom/wear/widget/dialog/ControlLinkResponseControlDialog$Listener;)V", "mBinding", "Lcom/wear/databinding/DialogControlLinkResponseBinding;", "mType", "Lcom/wear/ui/longDistance/controlLink/control/ControlLinkPermissionControl$ControlType;", "popupWindow", "Landroid/widget/PopupWindow;", "str", "getStr", "style", "Landroid/text/SpannableStringBuilder;", "getStyle", "()Landroid/text/SpannableStringBuilder;", "setStyle", "(Landroid/text/SpannableStringBuilder;)V", "dismiss", "", "initView", "isShowing", "", "setColor", TtmlNode.START, "setType", "type", "showAsDropDown", "anchor", "Landroid/view/View;", "Listener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class as3 {

    @NotNull
    public final Context a;
    public DialogControlLinkResponseBinding b;

    @Nullable
    public a c;

    @Nullable
    public PopupWindow d;

    @Nullable
    public d83.d e;

    @NotNull
    public String f;

    @Nullable
    public SpannableStringBuilder g;
    public int h;

    @NotNull
    public final String i;

    @NotNull
    public final ForegroundColorSpan j;

    /* compiled from: ControlLinkResponseControlDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkResponseControlDialog$Listener;", "", "cancel", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void cancel();
    }

    /* compiled from: ControlLinkResponseControlDialog.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/wear/widget/dialog/ControlLinkResponseControlDialog$initView$action$1", "Ljava/lang/Runnable;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SetTextI18n"})
        public void run() {
            DialogControlLinkResponseBinding dialogControlLinkResponseBinding = as3.this.b;
            if (dialogControlLinkResponseBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                dialogControlLinkResponseBinding = null;
            }
            dialogControlLinkResponseBinding.d.postDelayed(this, 500L);
            as3 as3Var = as3.this;
            as3Var.h(as3Var.getH());
            as3 as3Var2 = as3.this;
            as3Var2.i(as3Var2.getH() + 1);
            if (as3.this.getH() == 4) {
                as3.this.i(0);
            }
        }
    }

    public as3(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.f = "...";
        String strE = ah4.e(R.string.control_link_waiting_toast);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.control_link_waiting_toast)");
        this.i = strE;
        this.j = new ForegroundColorSpan(0);
        d();
    }

    public static final void e(as3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.cancel();
        }
        this$0.b();
    }

    public final void b() {
        PopupWindow popupWindow = this.d;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: c, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @SuppressLint({"InflateParams"})
    public final void d() {
        DialogControlLinkResponseBinding dialogControlLinkResponseBindingC = DialogControlLinkResponseBinding.c(LayoutInflater.from(MyApplication.N()));
        Intrinsics.checkNotNullExpressionValue(dialogControlLinkResponseBindingC, "inflate(LayoutInflater.f…cation.getMyAppcation()))");
        this.b = dialogControlLinkResponseBindingC;
        PopupWindow popupWindow = new PopupWindow(this.a);
        this.d = popupWindow;
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding = null;
        if (popupWindow != null) {
            DialogControlLinkResponseBinding dialogControlLinkResponseBinding2 = this.b;
            if (dialogControlLinkResponseBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                dialogControlLinkResponseBinding2 = null;
            }
            popupWindow.setContentView(dialogControlLinkResponseBinding2.getRoot());
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
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding3 = this.b;
        if (dialogControlLinkResponseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkResponseBinding3 = null;
        }
        dialogControlLinkResponseBinding3.b.setOnClickListener(new View.OnClickListener() { // from class: dc.gq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                as3.e(this.a, view);
            }
        });
        b bVar = new b();
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding4 = this.b;
        if (dialogControlLinkResponseBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkResponseBinding4 = null;
        }
        dialogControlLinkResponseBinding4.d.setTag(bVar);
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding5 = this.b;
        if (dialogControlLinkResponseBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dialogControlLinkResponseBinding = dialogControlLinkResponseBinding5;
        }
        dialogControlLinkResponseBinding.d.post(bVar);
    }

    public final boolean f() {
        PopupWindow popupWindow = this.d;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void h(int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.i);
        this.g = spannableStringBuilder;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.append((CharSequence) this.f);
        }
        SpannableStringBuilder spannableStringBuilder2 = this.g;
        if (spannableStringBuilder2 != null) {
            spannableStringBuilder2.setSpan(this.j, this.i.length() + i, this.i.length() + 3, 17);
        }
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding = this.b;
        if (dialogControlLinkResponseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkResponseBinding = null;
        }
        dialogControlLinkResponseBinding.d.setText(this.g);
    }

    public final void i(int i) {
        this.h = i;
    }

    public final void j(@Nullable a aVar) {
        this.c = aVar;
    }

    public final void k(@NotNull d83.d type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.e = type;
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding = null;
        if (type == d83.d.live_control) {
            DialogControlLinkResponseBinding dialogControlLinkResponseBinding2 = this.b;
            if (dialogControlLinkResponseBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                dialogControlLinkResponseBinding2 = null;
            }
            dialogControlLinkResponseBinding2.c.setImageResource(R.drawable.icon_control_request_dialog);
            DialogControlLinkResponseBinding dialogControlLinkResponseBinding3 = this.b;
            if (dialogControlLinkResponseBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                dialogControlLinkResponseBinding = dialogControlLinkResponseBinding3;
            }
            dialogControlLinkResponseBinding.e.setText(ah4.e(R.string.message_notification_type_live));
            return;
        }
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding4 = this.b;
        if (dialogControlLinkResponseBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogControlLinkResponseBinding4 = null;
        }
        dialogControlLinkResponseBinding4.c.setImageResource(R.drawable.icon_control_request_sync_dialog);
        DialogControlLinkResponseBinding dialogControlLinkResponseBinding5 = this.b;
        if (dialogControlLinkResponseBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dialogControlLinkResponseBinding = dialogControlLinkResponseBinding5;
        }
        dialogControlLinkResponseBinding.e.setText(ah4.e(R.string.message_notification_type_sync));
    }

    public final void l(@Nullable View view) {
        try {
            PopupWindow popupWindow = this.d;
            if (popupWindow != null) {
                popupWindow.showAsDropDown(view, 0, ce3.a(this.a, -1.0f));
            }
        } catch (Exception unused) {
        }
    }
}
