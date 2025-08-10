package dc;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PanelUtil.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\rJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/utils/PanelUtil;", "", "()V", "lHeight", "", "pHeight", "clearData", "", "context", "Landroid/content/Context;", "getKeyBoardHeight", "hasMeasuredKeyboard", "", "hasMeasuredKeyboard$app_marketRelease", "hideKeyboard", "view", "Landroid/view/View;", "isPanelHeightBelowKeyboardHeight", "curPanelHeight", "setKeyBoardHeight", VideoCaptureFormat.keyHeight, "showKeyboard", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class du2 {

    @NotNull
    public static final du2 a = new du2();
    public static int b = -1;
    public static int c = -1;

    @JvmStatic
    public static final int a(@NotNull Context context) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zQ = bu2.q(context);
        if (zQ && (i2 = b) != -1) {
            return i2;
        }
        if (!zQ && (i = c) != -1) {
            return i;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ky_panel_name", 0);
        String str = zQ ? "keyboard_height_for_p" : "keyboard_height_for_l";
        int iA = bu2.a(context, zQ ? 230.0f : 198.0f);
        int i3 = sharedPreferences.getInt(str, iA);
        if (i3 != iA) {
            if (zQ) {
                b = i3;
            } else {
                c = i3;
            }
        }
        return i3;
    }

    @JvmStatic
    public static final boolean c(@NotNull Context context, @NotNull View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @JvmStatic
    public static final boolean d(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a.b(context) && a(context) > i;
    }

    @JvmStatic
    public static final boolean e(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(context) == i) {
            au2.g("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        }
        boolean zQ = bu2.q(context);
        if (zQ && b == i) {
            au2.g("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        }
        if (!zQ && c == i) {
            au2.g("PanelUtil#onGlobalLayout", "current KeyBoardHeight is equal，just ignore！");
            return false;
        }
        boolean zCommit = context.getSharedPreferences("ky_panel_name", 0).edit().putInt(zQ ? "keyboard_height_for_p" : "keyboard_height_for_l", i).commit();
        if (zCommit) {
            if (zQ) {
                b = i;
            } else {
                c = i;
            }
        }
        return zCommit;
    }

    @JvmStatic
    public static final boolean f(@NotNull Context context, @NotNull View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        view.requestFocus();
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return ((InputMethodManager) systemService).showSoftInput(view, 0);
    }

    public final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
        return (b == -1 && c == -1) ? false : true;
    }
}
