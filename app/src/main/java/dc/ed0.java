package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.ve0;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: ActivityUtils.java */
/* loaded from: classes.dex */
public final class ed0 {
    public static void a(@Nullable ve0.a aVar) {
        xe0.a(aVar);
    }

    public static void b() {
        c(false);
    }

    public static void c(boolean z) {
        for (WeakReference<Activity> weakReference : xe0.m()) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().finish();
                if (!z) {
                    weakReference.get().overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static String d(@NonNull String str) {
        if (xe0.K(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = ve0.a().getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? "" : listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static Activity e() {
        return xe0.A();
    }

    public static Context f() {
        if (!xe0.F()) {
            return ve0.a();
        }
        Activity activityE = e();
        return activityE == null ? ve0.a() : activityE;
    }

    public static boolean g(Activity activity) {
        return (activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) ? false : true;
    }

    public static boolean h(Intent intent) {
        return ve0.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void i(@Nullable ve0.a aVar) {
        xe0.O(aVar);
    }

    public static boolean j(@NonNull Intent intent) {
        return k(intent, f(), null);
    }

    public static boolean k(Intent intent, Context context, Bundle bundle) {
        if (!h(intent)) {
            de0.l("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivity(intent);
        } else {
            context.startActivity(intent, bundle);
        }
        return true;
    }
}
