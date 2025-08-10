package dc;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DisplayUtil.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010'\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/wear/ui/chat/pancel/helper/utils/DisplayUtil;", "", "()V", "compatSizeProxy", "Lcom/wear/ui/chat/pancel/helper/utils/DisplayUtil$CompatSizeProxy;", "contentViewCanDrawStatusBarArea", "", "window", "Landroid/view/Window;", "dip2px", "", "context", "Landroid/content/Context;", "dipValue", "", "getContentViewHeight", "getInternalDimensionSize", OrmLiteConfigUtil.RESOURCE_DIR_NAME, "Landroid/content/res/Resources;", "key", "", "getLocationOnScreen", "", "view", "Landroid/view/View;", "getLocationOnWindow", "getNavigationBarHeight", "getScreenHeightWithSystemUI", "getScreenHeightWithoutNavigationBar", "getScreenHeightWithoutSystemUI", "getScreenRealHeight", "getStatusBarHeight", "getToolbarHeight", "hasNavBar", "hasSystemUIFlag", "flag", "isFullScreen", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "isNavBarVisible", "isNavigationBarShow", "isPortrait", "setCompatSizeProxy", "", "proxy", "CompatSizeProxy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class bu2 {

    @NotNull
    public static final bu2 a = new bu2();

    @Nullable
    public static a b;

    /* compiled from: DisplayUtil.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/utils/DisplayUtil$CompatSizeProxy;", "", "dip2px", "", "context", "Landroid/content/Context;", "dipValue", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        int a(@NotNull Context context, float f);
    }

    @JvmStatic
    public static final int a(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = b;
        return aVar != null ? aVar.a(context, f) : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @JvmStatic
    @NotNull
    public static final int[] c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    @JvmStatic
    @NotNull
    public static final int[] d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    @JvmStatic
    public static final int e(@NotNull Context context, @NotNull Window window) {
        String string;
        Insets insets;
        int stableInsetBottom;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        bu2 bu2Var = a;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int iB = bu2Var.b(resources, "navigation_bar_height");
        String MANUFACTURER = Build.MANUFACTURER;
        int i = 0;
        if (MANUFACTURER == null) {
            string = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            int length = MANUFACTURER.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.compare((int) MANUFACTURER.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            string = MANUFACTURER.subSequence(i2, length + 1).toString();
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "samsung", false, 2, (Object) null)) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28 && i3 < 29) {
                WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null && (stableInsetBottom = rootWindowInsets.getStableInsetBottom()) < iB) {
                    return stableInsetBottom;
                }
            } else if (i3 > 29) {
                WindowInsetsCompat rootWindowInsets2 = ViewCompat.getRootWindowInsets(window.getDecorView());
                if (rootWindowInsets2 != null && (insets = rootWindowInsets2.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
                    i = insets.bottom;
                }
                if (i > iB) {
                    return i;
                }
            }
        }
        return iB;
    }

    @JvmStatic
    public static final int f(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return window.getDecorView().getHeight();
    }

    @JvmStatic
    public static final int g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    @JvmStatic
    public static final int h(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    @JvmStatic
    public static final int j(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    @JvmStatic
    public static final int k(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return window.getDecorView().findViewById(R.id.content).getTop();
    }

    @JvmStatic
    public static final boolean n(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @JvmStatic
    public static final boolean p(@NotNull Context context, @NotNull Window window) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        return a.o(context, window);
    }

    @JvmStatic
    public static final boolean q(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = context.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i == 2) {
                return false;
            }
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (point.x > point.y) {
                return false;
            }
        }
        return true;
    }

    public final int b(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final int i(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT < 17) {
            return f(window);
        }
        Object systemService = window.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final boolean l(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier != 0) {
            resources.getBoolean(identifier);
            String str = null;
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, "qemu.hw.mainkeys");
                if (objInvoke instanceof String) {
                    str = (String) objInvoke;
                }
            } catch (Throwable unused) {
            }
            if (!Intrinsics.areEqual(str, "1") && Intrinsics.areEqual(str, "0")) {
                return true;
            }
        } else if (!ViewConfiguration.get(context).hasPermanentMenuKey()) {
            return true;
        }
        return false;
    }

    public final boolean m(@NotNull Window window, int i) {
        Intrinsics.checkNotNullParameter(window, "window");
        return (window.getDecorView().getSystemUiVisibility() & i) == i;
    }

    public final boolean o(@NotNull Context context, @NotNull Window window) throws Resources.NotFoundException {
        boolean zL;
        String string;
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            zL = false;
            for (int i = 0; i < childCount; i++) {
                int id = viewGroup.getChildAt(i).getId();
                if (id != -1) {
                    try {
                        if (Intrinsics.areEqual("navigationBarBackground", context.getResources().getResourceEntryName(id)) && viewGroup.getChildAt(i).getVisibility() == 0) {
                            zL = true;
                        }
                    } catch (Exception e) {
                        String str = "error msg : " + e.getMessage();
                    }
                }
            }
            if (!zL && (viewFindViewById = viewGroup.findViewById(com.lovense.wear.R.id.immersion_navigation_bar_view)) != null && viewFindViewById.getVisibility() == 0) {
                zL = true;
            }
        } else {
            zL = false;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        if (MANUFACTURER == null) {
            string = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            int length = MANUFACTURER.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.compare((int) MANUFACTURER.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            string = MANUFACTURER.subSequence(i2, length + 1).toString();
        }
        String lowerCase = string.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        boolean zContains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "samsung", false, 2, (Object) null);
        if ((viewGroup == null || !zL) && zContains$default) {
            zL = l(context);
        }
        if (!zL) {
            return zL;
        }
        if (zContains$default && Build.VERSION.SDK_INT >= 17) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled") == 0) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return !m(window, 2);
    }
}
