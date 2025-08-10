package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV21.java */
@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public class c61 extends b61 {
    public static Intent f(@NonNull Context context) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (n51.c()) {
            intent.setData(m61.l(context));
        }
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean g(@NonNull Context context) {
        return m61.d(context, "android:get_usage_stats");
    }

    @Override // dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.PACKAGE_USAGE_STATS") ? g(context) : super.a(context, str);
    }

    @Override // dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.PACKAGE_USAGE_STATS")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.PACKAGE_USAGE_STATS") ? f(context) : super.c(context, str);
    }
}
