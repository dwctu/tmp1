package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

/* compiled from: CutoutUtil.java */
/* loaded from: classes5.dex */
public final class ek4 {
    public static void a(Context context, boolean z) {
        Activity activityL = gk4.l(context);
        if (activityL != null && Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activityL.getWindow().getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            activityL.getWindow().setAttributes(attributes);
        }
    }

    public static boolean b(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return c(activity) || d(activity) || e(activity) || f(activity);
        }
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects().size() <= 0) ? false : true;
    }

    public static boolean c(Activity activity) throws ClassNotFoundException {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean d(Activity activity) {
        if (Build.MANUFACTURER.equalsIgnoreCase("oppo")) {
            return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean e(Activity activity) throws ClassNotFoundException {
        if (!Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean f(Activity activity) throws ClassNotFoundException {
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
