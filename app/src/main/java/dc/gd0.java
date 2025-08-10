package dc;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import dc.ve0;

/* compiled from: AppUtils.java */
/* loaded from: classes.dex */
public final class gd0 {
    public static void a() {
        xe0.h();
        System.exit(0);
    }

    @NonNull
    public static String b() {
        return c(ve0.a().getPackageName());
    }

    @NonNull
    public static String c(String str) {
        if (xe0.K(str)) {
            return "";
        }
        try {
            PackageManager packageManager = ve0.a().getPackageManager();
            PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String d() {
        return ve0.a().getPackageName();
    }

    public static int e() {
        return f(ve0.a().getPackageName());
    }

    public static int f(String str) {
        if (xe0.K(str)) {
            return -1;
        }
        try {
            PackageManager packageManager = ve0.a().getPackageManager();
            PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NonNull
    public static String g() {
        return h(ve0.a().getPackageName());
    }

    @NonNull
    public static String h(String str) {
        if (xe0.K(str)) {
            return "";
        }
        try {
            PackageManager packageManager = ve0.a().getPackageManager();
            PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean i() {
        return j(ve0.a().getPackageName());
    }

    public static boolean j(String str) {
        if (xe0.K(str)) {
            return false;
        }
        try {
            PackageManager packageManager = ve0.a().getPackageManager();
            return ((Build.VERSION.SDK_INT >= 33 ? packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L)) : packageManager.getApplicationInfo(str, 0)).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean k(String str) {
        if (xe0.K(str)) {
            return false;
        }
        try {
            PackageManager packageManager = ve0.a().getPackageManager();
            return (Build.VERSION.SDK_INT >= 33 ? packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L)) : packageManager.getApplicationInfo(str, 0)).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void l(@NonNull ve0.c cVar) {
        xe0.b(cVar);
    }

    public static void m(boolean z) {
        Intent intentT = xe0.t(ve0.a().getPackageName());
        if (intentT == null) {
            de0.l("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        intentT.addFlags(335577088);
        ve0.a().startActivity(intentT);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void n(@NonNull ve0.c cVar) {
        xe0.P(cVar);
    }
}
