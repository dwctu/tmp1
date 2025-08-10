package dc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: StatusBarUtil.java */
/* loaded from: classes4.dex */
public class kg3 {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        return (identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0) + 12;
    }

    public static void b(Activity activity, boolean z) {
        View decorView = activity.getWindow().getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(1280);
            g(activity, ContextCompat.getColor(activity, R.color.status_night_bg));
        } else {
            decorView.setSystemUiVisibility(9216);
            g(activity, ContextCompat.getColor(activity, R.color.status_light_bg));
        }
    }

    public static boolean c(Activity activity, boolean z) {
        View decorView;
        if (Build.VERSION.SDK_INT < 23 || (decorView = activity.getWindow().getDecorView()) == null) {
            return false;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        if (decorView.getSystemUiVisibility() == i) {
            return true;
        }
        decorView.setSystemUiVisibility(i);
        return true;
    }

    public static boolean d(Activity activity, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            window.setAttributes(attributes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean e(Activity activity, boolean z) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Window window = activity.getWindow();
            Class<?> cls = activity.getWindow().getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setExtraFlags", cls3, cls3);
            declaredMethod.setAccessible(true);
            if (z) {
                declaredMethod.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                declaredMethod.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void f(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(android.R.id.content);
            if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
                return;
            }
            viewGroup.setFitsSystemWindows(z);
        }
    }

    public static void g(Activity activity, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            Window window = activity.getWindow();
            if (i2 >= 23) {
                window.setStatusBarColor(i);
                window.setNavigationBarColor(i);
                return;
            }
            return;
        }
        if (i2 >= 19) {
            j(activity);
            rg3 rg3Var = new rg3(activity);
            rg3Var.c(true);
            rg3Var.b(i);
        }
    }

    public static boolean h(Activity activity, int i, boolean z) {
        return i != 0 ? i != 1 ? c(activity, z) : d(activity, z) : e(activity, z);
    }

    public static boolean i(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            h(activity, 3, z);
        } else if (if3.f()) {
            h(activity, 0, z);
        } else {
            if (!if3.e()) {
                return false;
            }
            h(activity, 1, z);
        }
        return true;
    }

    @TargetApi(19)
    public static void j(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            if (i >= 23) {
                window.setStatusBarColor(0);
                return;
            }
            return;
        }
        if (i >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
    }

    @RequiresApi(api = 23)
    public static void k(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility((z ? 0 : 8192) | 1280);
            window.addFlags(Integer.MIN_VALUE);
            if (i >= 23) {
                window.setStatusBarColor(0);
                return;
            }
            return;
        }
        if (i >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
    }

    public static void l(Activity activity) {
        String str = "settingBarColor: " + MyApplication.m0;
        int i = MyApplication.m0;
        if (i == 0) {
            if (MyApplication.l0) {
                b(activity, true);
                return;
            } else {
                b(activity, false);
                return;
            }
        }
        if (i == 2) {
            b(activity, true);
        } else {
            b(activity, false);
        }
    }
}
