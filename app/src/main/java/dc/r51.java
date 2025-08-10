package dc;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: NotificationListenerPermissionCompat.java */
/* loaded from: classes2.dex */
public final class r51 {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent a(@androidx.annotation.NonNull android.content.Context r6) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            boolean r0 = dc.n51.d()
            r1 = 0
            if (r0 == 0) goto L52
            dc.l51 r0 = dc.m61.k(r6)
            if (r0 == 0) goto L30
            java.util.List<dc.l51$d> r0 = r0.f
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L14:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L31
            java.lang.Object r3 = r0.next()
            dc.l51$d r3 = (dc.l51.d) r3
            java.lang.String r4 = r3.b
            java.lang.String r5 = "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE"
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 != 0) goto L2b
            goto L14
        L2b:
            if (r2 == 0) goto L2e
            goto L30
        L2e:
            r2 = r3
            goto L14
        L30:
            r2 = r1
        L31:
            if (r2 == 0) goto L52
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS"
            r0.<init>(r3)
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r2 = r2.a
            r3.<init>(r6, r2)
            java.lang.String r2 = r3.flattenToString()
            java.lang.String r3 = "android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME"
            r0.putExtra(r3, r2)
            boolean r2 = dc.m61.a(r6, r0)
            if (r2 != 0) goto L51
            goto L52
        L51:
            r1 = r0
        L52:
            if (r1 != 0) goto L68
            boolean r0 = dc.n51.k()
            java.lang.String r1 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            if (r0 == 0) goto L62
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r1)
            goto L67
        L62:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r1)
        L67:
            r1 = r0
        L68:
            boolean r0 = dc.m61.a(r6, r1)
            if (r0 != 0) goto L72
            android.content.Intent r1 = dc.l61.b(r6)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.r51.a(android.content.Context):android.content.Intent");
    }

    public static boolean b(@NonNull Context context) throws ClassNotFoundException {
        if (!n51.h()) {
            return true;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        for (String str : string.split(SignatureImpl.INNER_SEP)) {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (TextUtils.equals(componentNameUnflattenFromString.getPackageName(), context.getPackageName())) {
                try {
                    Class.forName(componentNameUnflattenFromString.getClassName());
                    return true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
