package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV26.java */
@RequiresApi(api = 26)
/* loaded from: classes2.dex */
public class e61 extends d61 {
    public static Intent n(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(m61.l(context));
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static Intent o(@NonNull Context context) {
        Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
        intent.setData(m61.l(context));
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean p(@NonNull Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }

    public static boolean q(@NonNull Context context) {
        return m61.d(context, "android:picture_in_picture");
    }

    @Override // dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.REQUEST_INSTALL_PACKAGES") ? p(context) : m61.h(str, "android.permission.PICTURE_IN_PICTURE") ? q(context) : (m61.h(str, "android.permission.READ_PHONE_NUMBERS") || m61.h(str, "android.permission.ANSWER_PHONE_CALLS")) ? m61.f(context, str) : super.a(context, str);
    }

    @Override // dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.REQUEST_INSTALL_PACKAGES") || m61.h(str, "android.permission.PICTURE_IN_PICTURE")) {
            return false;
        }
        return (m61.h(str, "android.permission.READ_PHONE_NUMBERS") || m61.h(str, "android.permission.ANSWER_PHONE_CALLS")) ? (m61.f(activity, str) || m61.v(activity, str)) ? false : true : super.b(activity, str);
    }

    @Override // dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.REQUEST_INSTALL_PACKAGES") ? n(context) : m61.h(str, "android.permission.PICTURE_IN_PICTURE") ? o(context) : super.c(context, str);
    }
}
