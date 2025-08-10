package dc;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.wear.bean.Toy;
import dc.ho3;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LDRControl.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001c\u0010\u000f\u001a\u00020\b*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e\"\"\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"ldrControlGuildDialogWeakReference", "Ljava/lang/ref/WeakReference;", "Lcom/wear/widget/bubble/BubbleDialog;", "getLdrControlGuildDialogWeakReference", "()Ljava/lang/ref/WeakReference;", "setLdrControlGuildDialogWeakReference", "(Ljava/lang/ref/WeakReference;)V", "dismissLDRControlGuildDialog", "", "isShowLDRControlGuild", "", "context", "Landroid/content/Context;", "toy", "Lcom/wear/bean/Toy;", "showLDRControlGuildDialog", "Landroidx/fragment/app/FragmentActivity;", "view", "Landroid/view/View;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ua2 {

    @Nullable
    public static WeakReference<ho3> a;

    public static final void a() {
        ho3 ho3Var;
        WeakReference<ho3> weakReference = a;
        if (weakReference == null || (ho3Var = weakReference.get()) == null || !ho3Var.isShowing()) {
            return;
        }
        ho3Var.dismiss();
    }

    public static final boolean b(Context context, Toy toy) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!eg3.d(context, "isShowLDRControlGuildDialog:" + toy.getAddress(), true)) {
            return true;
        }
        eg3.j(context, "isShowLDRControlGuildDialog:" + toy.getAddress(), false);
        return false;
    }

    public static final void e(@NotNull final FragmentActivity fragmentActivity, @NotNull final View view, @Nullable Toy toy) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (toy == null) {
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (b(context, toy)) {
            return;
        }
        final ho3 ho3Var = new ho3(fragmentActivity, toy);
        a = new WeakReference<>(ho3Var);
        view.postDelayed(new Runnable() { // from class: dc.ha2
            @Override // java.lang.Runnable
            public final void run() {
                ua2.f(ho3Var, view, fragmentActivity);
            }
        }, 300L);
    }

    public static final void f(ho3 bubbleDialog, View view, FragmentActivity this_showLDRControlGuildDialog) {
        Intrinsics.checkNotNullParameter(bubbleDialog, "$bubbleDialog");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this_showLDRControlGuildDialog, "$this_showLDRControlGuildDialog");
        bubbleDialog.r();
        bubbleDialog.p(ho3.f.TOP);
        bubbleDialog.l(view);
        bubbleDialog.q(false, true);
        bubbleDialog.o(ce3.a(this_showLDRControlGuildDialog, 2.0f));
        bubbleDialog.m(ce3.a(this_showLDRControlGuildDialog, 200.0f), -2, 0);
        bubbleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.ia2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ua2.g(dialogInterface);
            }
        });
        bubbleDialog.show();
    }

    public static final void g(DialogInterface dialogInterface) {
        a = null;
    }
}
