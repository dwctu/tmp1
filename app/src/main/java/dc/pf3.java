package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.wear.util.MyApplication;

/* compiled from: PackageUtils.java */
/* loaded from: classes4.dex */
public class pf3 {
    public static boolean a(Context context, String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean d(Context context) {
        return b(context) == c(context);
    }

    public static void e(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo("com.lovense.vibemate", 0) == null) {
                eg3.i(MyApplication.N(), "isInstall_vibemate", 1);
                return;
            }
            if (eg3.f(MyApplication.N(), "isInstall_vibemate", 1) != 0) {
                eh3.a().c();
            }
            eg3.i(MyApplication.N(), "isInstall_vibemate", 0);
        } catch (Exception e) {
            eg3.i(MyApplication.N(), "isInstall_vibemate", 1);
            e.printStackTrace();
        }
    }
}
