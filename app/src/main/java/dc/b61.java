package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV19.java */
@RequiresApi(api = 19)
/* loaded from: classes2.dex */
public class b61 extends a61 {
    @Override // dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.SYSTEM_ALERT_WINDOW") ? p61.b(context) : m61.h(str, "com.android.permission.GET_INSTALLED_APPS") ? o51.b(context) : m61.h(str, "android.permission.NOTIFICATION_SERVICE") ? s51.b(context) : (n51.f() || !m61.h(str, "android.permission.POST_NOTIFICATIONS")) ? super.a(context, str) : s51.b(context);
    }

    @Override // dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.SYSTEM_ALERT_WINDOW")) {
            return false;
        }
        if (m61.h(str, "com.android.permission.GET_INSTALLED_APPS")) {
            return o51.d(activity);
        }
        if (m61.h(str, "android.permission.NOTIFICATION_SERVICE")) {
            return false;
        }
        if (n51.f() || !m61.h(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.b(activity, str);
        }
        return false;
    }

    @Override // dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.SYSTEM_ALERT_WINDOW") ? p61.a(context) : m61.h(str, "com.android.permission.GET_INSTALLED_APPS") ? o51.a(context) : m61.h(str, "android.permission.NOTIFICATION_SERVICE") ? s51.a(context) : (n51.f() || !m61.h(str, "android.permission.POST_NOTIFICATIONS")) ? super.c(context, str) : s51.a(context);
    }
}
