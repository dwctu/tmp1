package dc;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: KeyboardExt.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a\f\u0010\t\u001a\u00020\u0005*\u00020\nH\u0000\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0007*\u00020\b¨\u0006\r"}, d2 = {"getSoftInputHeight", "", "Landroid/app/Activity;", "Landroidx/fragment/app/Fragment;", "hasSoftInput", "", "hideSoftInput", "", "Landroid/widget/EditText;", "isSystemInsetsAnimationSupport", "Landroid/view/View;", "Landroid/view/Window;", "showSoftInput", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class cu2 {
    public static final void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        } else {
            WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(activity.getWindow().getDecorView());
            if (windowInsetsController != null) {
                windowInsetsController.hide(WindowInsetsCompat.Type.ime());
            }
        }
    }

    public static final boolean b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(view);
        return (windowInsetsController == null || windowInsetsController.getSystemBarsBehavior() == 0) ? false : true;
    }
}
