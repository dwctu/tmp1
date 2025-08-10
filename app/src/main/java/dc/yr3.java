package dc;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.databinding.DialogControlLinkPermissionBinding;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlLinkPermissionDialog.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkPermissionDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "describe", "", "showCanel", "", "(Landroid/content/Context;Ljava/lang/String;Z)V", "getDescribe", "()Ljava/lang/String;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "getListener", "()Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "setListener", "(Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;)V", "mBinding", "Lcom/wear/databinding/DialogControlLinkPermissionBinding;", "getMBinding", "()Lcom/wear/databinding/DialogControlLinkPermissionBinding;", "mBinding$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Listener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"InflateParams"})
/* loaded from: classes4.dex */
public final class yr3 extends Dialog {

    @Nullable
    public final String a;
    public final boolean b;

    @Nullable
    public a c;

    @NotNull
    public final Lazy d;

    /* compiled from: ControlLinkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkPermissionDialog$Listener;", "", "cancel", "", "ok", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void cancel();
    }

    /* compiled from: ControlLinkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/DialogControlLinkPermissionBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<DialogControlLinkPermissionBinding> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DialogControlLinkPermissionBinding invoke() {
            return DialogControlLinkPermissionBinding.a(LayoutInflater.from(this.$context).inflate(R.layout.dialog_control_link_permission, (ViewGroup) null, false));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr3(@NotNull Context context, @Nullable String str, boolean z) {
        super(context, R.style.Dialog_Fragment_Fullscreen);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = str;
        this.b = z;
        this.d = LazyKt__LazyJVMKt.lazy(new b(context));
    }

    public static final void d(yr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismiss();
    }

    public static final void e(yr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.cancel();
        }
        this$0.dismiss();
    }

    public final DialogControlLinkPermissionBinding a() {
        return (DialogControlLinkPermissionBinding) this.d.getValue();
    }

    public final void f(@Nullable a aVar) {
        this.c = aVar;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(a().getRoot());
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        setCanceledOnTouchOutside(false);
        a().d.setText(this.a);
        if (this.b) {
            a().b.setVisibility(0);
        } else {
            a().b.setVisibility(8);
        }
        a().c.setOnClickListener(new View.OnClickListener() { // from class: dc.cq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                yr3.d(this.a, view);
            }
        });
        a().b.setOnClickListener(new View.OnClickListener() { // from class: dc.dq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                yr3.e(this.a, view);
            }
        });
    }
}
