package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.databinding.DialogTipSyncablePatternsBinding;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TipSyncablePatternsDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/wear/vibematevideo/ui/dialog/TipSyncablePatternsDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "xy", "", "(Landroid/content/Context;[I)V", "binding", "Lcom/wear/databinding/DialogTipSyncablePatternsBinding;", "getBinding", "()Lcom/wear/databinding/DialogTipSyncablePatternsBinding;", "binding$delegate", "Lkotlin/Lazy;", "getXy", "()[I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class wl3 extends Dialog {

    @NotNull
    public final int[] a;

    @NotNull
    public final Lazy b;

    /* compiled from: TipSyncablePatternsDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/DialogTipSyncablePatternsBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<DialogTipSyncablePatternsBinding> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DialogTipSyncablePatternsBinding invoke() {
            return DialogTipSyncablePatternsBinding.c(wl3.this.getLayoutInflater());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl3(@NotNull Context context, @NotNull int[] xy) {
        super(context, R.style.FulldialogNoAnimation);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(xy, "xy");
        this.a = xy;
        this.b = LazyKt__LazyJVMKt.lazy(new a());
    }

    public static final void c(wl3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @NotNull
    public final DialogTipSyncablePatternsBinding a() {
        return (DialogTipSyncablePatternsBinding) this.b.getValue();
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setContentView(a().getRoot());
        Window window = getWindow();
        if (window != null) {
            window.getAttributes().height = -1;
            window.getAttributes().width = -1;
        }
        a().getRoot().setOnClickListener(new View.OnClickListener() { // from class: dc.vl3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                wl3.c(this.a, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = a().b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int[] iArr = this.a;
        layoutParams2.leftMargin = iArr[0];
        layoutParams2.topMargin = iArr[1] - id0.b();
        a().b.setLayoutParams(layoutParams2);
        ll3.E().e0("pattern tip", "open", null, null, null);
    }
}
