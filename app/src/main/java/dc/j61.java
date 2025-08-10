package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV33.java */
@RequiresApi(api = 33)
/* loaded from: classes2.dex */
public class j61 extends i61 {
    @Override // dc.i61, dc.h61, dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        if (m61.h(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            return m61.f(context, "android.permission.BODY_SENSORS") && m61.f(context, "android.permission.BODY_SENSORS_BACKGROUND");
        }
        if (m61.h(str, "android.permission.POST_NOTIFICATIONS") || m61.h(str, "android.permission.NEARBY_WIFI_DEVICES") || m61.h(str, "android.permission.READ_MEDIA_IMAGES") || m61.h(str, "android.permission.READ_MEDIA_VIDEO") || m61.h(str, "android.permission.READ_MEDIA_AUDIO")) {
            return m61.f(context, str);
        }
        if (n51.b(context) >= 33) {
            if (m61.h(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            if (m61.h(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return m61.f(context, "android.permission.READ_MEDIA_IMAGES") && m61.f(context, "android.permission.READ_MEDIA_VIDEO") && m61.f(context, "android.permission.READ_MEDIA_AUDIO");
            }
        }
        return super.a(context, str);
    }

    @Override // dc.i61, dc.h61, dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            return !m61.f(activity, "android.permission.BODY_SENSORS") ? !m61.v(activity, "android.permission.BODY_SENSORS") : (m61.f(activity, str) || m61.v(activity, str)) ? false : true;
        }
        if (m61.h(str, "android.permission.POST_NOTIFICATIONS") || m61.h(str, "android.permission.NEARBY_WIFI_DEVICES") || m61.h(str, "android.permission.READ_MEDIA_IMAGES") || m61.h(str, "android.permission.READ_MEDIA_VIDEO") || m61.h(str, "android.permission.READ_MEDIA_AUDIO")) {
            return (m61.f(activity, str) || m61.v(activity, str)) ? false : true;
        }
        if (n51.b(activity) >= 33) {
            if (m61.h(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return false;
            }
            if (m61.h(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return (m61.f(activity, "android.permission.READ_MEDIA_IMAGES") || m61.v(activity, "android.permission.READ_MEDIA_IMAGES") || m61.f(activity, "android.permission.READ_MEDIA_VIDEO") || m61.v(activity, "android.permission.READ_MEDIA_VIDEO") || m61.f(activity, "android.permission.READ_MEDIA_AUDIO") || m61.v(activity, "android.permission.READ_MEDIA_AUDIO")) ? false : true;
            }
        }
        return super.b(activity, str);
    }

    @Override // dc.i61, dc.h61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.POST_NOTIFICATIONS") ? s51.a(context) : super.c(context, str);
    }
}
