package dc;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* compiled from: NotificationPermissionCompat.java */
/* loaded from: classes2.dex */
public final class s51 {
    public static Intent a(@NonNull Context context) {
        Intent intent;
        if (n51.n()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else if (n51.j()) {
            intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        } else {
            intent = null;
        }
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean b(@NonNull Context context) {
        if (n51.m()) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (n51.i()) {
            return m61.e(context, "OP_POST_NOTIFICATION", 11);
        }
        return true;
    }
}
