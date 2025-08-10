package dc;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV29.java */
@RequiresApi(api = 29)
/* loaded from: classes2.dex */
public class g61 extends f61 {
    public static boolean s() {
        return Environment.isExternalStorageLegacy();
    }

    @Override // dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        if (m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return r(context) && m61.f(context, "android.permission.ACCESS_MEDIA_LOCATION");
        }
        if (m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || m61.h(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return m61.f(context, str);
        }
        if (n51.d() || !m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || s()) {
            return super.a(context, str);
        }
        return false;
    }

    @Override // dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return !m61.f(activity, "android.permission.ACCESS_FINE_LOCATION") ? !m61.v(activity, "android.permission.ACCESS_FINE_LOCATION") : (m61.f(activity, str) || m61.v(activity, str)) ? false : true;
        }
        if (m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return (!r(activity) || m61.f(activity, str) || m61.v(activity, str)) ? false : true;
        }
        if (m61.h(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return (m61.f(activity, str) || m61.v(activity, str)) ? false : true;
        }
        if (n51.d() || !m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || s()) {
            return super.b(activity, str);
        }
        return true;
    }

    public final boolean r(@NonNull Context context) {
        return (!n51.f() || n51.b(context) < 33) ? (!n51.d() || n51.b(context) < 30) ? m61.f(context, "android.permission.READ_EXTERNAL_STORAGE") : m61.f(context, "android.permission.READ_EXTERNAL_STORAGE") || a(context, "android.permission.MANAGE_EXTERNAL_STORAGE") : m61.f(context, "android.permission.READ_MEDIA_IMAGES") || a(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
    }
}
