package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.lovense.wear.R;
import com.wear.databinding.PopupRouletteNoToyBinding;
import com.wear.main.account.login.LoginActivity;
import dc.kn3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RouletteNoToyPopup.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"showNoLoginDialog", "", "context", "Landroid/content/Context;", "showNoToyPopupWindow", "parentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "view", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qy2 {

    /* compiled from: RouletteNoToyPopup.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/discover/roulette/popup/RouletteNoToyPopupKt$showNoLoginDialog$dialog$1", "Lcom/wear/widget/CommonDialog$ClickListener;", "doCancel", "", "doConfirm", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements kn3.d {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.s(this.a, LoginActivity.class);
        }
    }

    public static final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        kn3 kn3Var = new kn3(context, ah4.e(R.string.offline_notification), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new a(context));
        kn3Var.show();
        kn3Var.p();
    }

    public static final void c(@NotNull View parentView, @NotNull LayoutInflater inflater, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(view, "view");
        PopupRouletteNoToyBinding popupRouletteNoToyBindingC = PopupRouletteNoToyBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(popupRouletteNoToyBindingC, "inflate(inflater)");
        final PopupWindow popupWindow = new PopupWindow(popupRouletteNoToyBindingC.getRoot(), -1, -1);
        popupWindow.setClippingEnabled(false);
        parentView.getLocationInWindow(new int[2]);
        popupRouletteNoToyBindingC.b.setY(r1[1]);
        popupRouletteNoToyBindingC.getRoot().setOnClickListener(new View.OnClickListener() { // from class: dc.py2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                qy2.d(popupWindow, view2);
            }
        });
        popupWindow.showAtLocation(parentView, 17, 0, 0);
    }

    public static final void d(PopupWindow popupWindow, View view) {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        popupWindow.dismiss();
    }
}
