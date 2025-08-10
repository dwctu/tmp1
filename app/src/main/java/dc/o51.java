package dc;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: GetInstalledAppsPermissionCompat.java */
/* loaded from: classes2.dex */
public final class o51 {
    public static Intent a(@NonNull Context context) {
        if (n61.m()) {
            return o61.a(n61.n() ? l61.f(context) : null, l61.b(context));
        }
        return l61.b(context);
    }

    public static boolean b(@NonNull Context context) {
        if (!n51.i()) {
            return true;
        }
        if (n51.l() && e(context)) {
            return m61.f(context, "com.android.permission.GET_INSTALLED_APPS");
        }
        if (n61.m() && c() && n61.n()) {
            return m61.e(context, "OP_GET_INSTALLED_APPS", 10022);
        }
        return true;
    }

    public static boolean c() throws NoSuchFieldException {
        if (!n51.i()) {
            return true;
        }
        try {
            Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_GET_INSTALLED_APPS");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean d(@NonNull Activity activity) {
        if (!n51.i()) {
            return false;
        }
        if (n51.l() && e(activity)) {
            return (m61.f(activity, "com.android.permission.GET_INSTALLED_APPS") || m61.v(activity, "com.android.permission.GET_INSTALLED_APPS")) ? false : true;
        }
        if (n61.m() && c() && n61.n()) {
            return !b(activity);
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean e(Context context) throws PackageManager.NameNotFoundException {
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);
            if (permissionInfo != null) {
                return n51.o() ? permissionInfo.getProtection() == 1 : (permissionInfo.protectionLevel & 15) == 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
