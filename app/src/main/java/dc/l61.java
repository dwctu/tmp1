package dc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: PermissionIntentManager.java */
/* loaded from: classes2.dex */
public final class l61 {
    @NonNull
    public static Intent a() {
        return new Intent("android.settings.SETTINGS");
    }

    @NonNull
    public static Intent b(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(m61.l(context));
        if (m61.a(context, intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
        if (m61.a(context, intent2)) {
            return intent2;
        }
        Intent intent3 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        return m61.a(context, intent3) ? intent3 : a();
    }

    @Nullable
    public static Intent c(Context context) {
        Intent intent = new Intent("com.oppo.safe.permission.PermissionTopActivity");
        Intent intentJ = j(context);
        if (!m61.a(context, intent)) {
            intent = null;
        }
        return m61.a(context, intentJ) ? o61.a(intent, intentJ) : intent;
    }

    @Nullable
    public static Intent d(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        Intent intent2 = new Intent();
        intent2.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        Intent intentE = e(context);
        String strD = n61.d();
        if (strD == null) {
            strD = "";
        }
        if (strD.startsWith("3.0")) {
            if (!m61.a(context, intent2)) {
                intent2 = null;
            }
            if (m61.a(context, intent)) {
                intent2 = o61.a(intent2, intent);
            }
        } else {
            if (!m61.a(context, intent)) {
                intent = null;
            }
            intent2 = m61.a(context, intent2) ? o61.a(intent, intent2) : intent;
        }
        return m61.a(context, intentE) ? o61.a(intent2, intentE) : intent2;
    }

    @Nullable
    public static Intent e(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.huawei.systemmanager");
        if (m61.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    @Nullable
    public static Intent f(Context context) {
        Intent intentPutExtra = new Intent().setAction("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName());
        Intent intentM = m(context);
        if (!m61.a(context, intentPutExtra)) {
            intentPutExtra = null;
        }
        return m61.a(context, intentM) ? o61.a(intentPutExtra, intentM) : intentPutExtra;
    }

    @Nullable
    public static Intent g(Context context) {
        return f(context);
    }

    @Nullable
    public static Intent h(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(m61.l(context));
        if (m61.a(context, intent)) {
            return intent;
        }
        return null;
    }

    @Nullable
    public static Intent i(Context context) {
        return h(context);
    }

    @Nullable
    public static Intent j(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (m61.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.color.safecenter");
        if (m61.a(context, launchIntentForPackage2)) {
            return launchIntentForPackage2;
        }
        Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage("com.oplus.safecenter");
        if (m61.a(context, launchIntentForPackage3)) {
            return launchIntentForPackage3;
        }
        return null;
    }

    @Nullable
    public static Intent k(Context context) {
        Intent intentL = l(context);
        if (m61.a(context, intentL)) {
            return intentL;
        }
        return null;
    }

    @Nullable
    public static Intent l(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (m61.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    @Nullable
    public static Intent m(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.miui.securitycenter");
        if (m61.a(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }
}
