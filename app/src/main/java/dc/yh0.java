package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: OAIDRom.java */
/* loaded from: classes.dex */
public final class yh0 {
    public static boolean a() {
        return !TextUtils.isEmpty(t("ro.build.uiversion", ""));
    }

    public static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean c() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean d(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e() {
        return t("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean f() {
        return !TextUtils.isEmpty(t("ro.build.version.emui", ""));
    }

    public static boolean g() {
        return !TextUtils.isEmpty(t("ro.build.freeme.label", ""));
    }

    public static boolean h() {
        return Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean i() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean j() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean k() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean l() {
        return !TextUtils.isEmpty(t("ro.miui.ui.version.name", ""));
    }

    public static boolean m() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean o() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean p() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(t("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean q() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean r() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(t("ro.vivo.os.version", ""));
    }

    public static boolean s() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static String t(String str, String str2) throws ClassNotFoundException {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            xh0.a("System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
