package dc;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV23.java */
@RequiresApi(api = 23)
/* loaded from: classes2.dex */
public class d61 extends c61 {
    public static Intent h(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(m61.l(context));
        if (!m61.a(context, intent)) {
            intent = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        }
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static Intent i(@NonNull Context context) {
        Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
        intent.setData(m61.l(context));
        if (n61.k() || n61.l()) {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        }
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static Intent j(@NonNull Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(m61.l(context));
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean k(@NonNull Context context) {
        return ((PowerManager) context.getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static boolean l(@NonNull Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGranted();
    }

    public static boolean m(@NonNull Context context) {
        if (n51.l()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    @Override // dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        if (!n51.f()) {
            if (m61.h(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.a(context, str);
            }
            if (m61.h(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return m61.f(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (m61.h(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                return m61.f(context, "android.permission.BODY_SENSORS");
            }
            if (m61.h(str, "android.permission.READ_MEDIA_IMAGES") || m61.h(str, "android.permission.READ_MEDIA_VIDEO") || m61.h(str, "android.permission.READ_MEDIA_AUDIO")) {
                return m61.f(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!n51.e()) {
            if (m61.h(str, "android.permission.BLUETOOTH_SCAN")) {
                return m61.f(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (m61.h(str, "android.permission.BLUETOOTH_CONNECT") || m61.h(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                return true;
            }
        }
        if (!n51.d() && m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            return m61.f(context, "android.permission.READ_EXTERNAL_STORAGE") && m61.f(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!n51.c()) {
            if (m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return m61.f(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (m61.h(str, "android.permission.ACTIVITY_RECOGNITION")) {
                return true;
            }
            if (m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                return m61.f(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (!n51.o() && m61.h(str, "android.permission.ACCEPT_HANDOVER")) {
            return true;
        }
        if (!n51.n()) {
            if (m61.h(str, "android.permission.ANSWER_PHONE_CALLS")) {
                return true;
            }
            if (m61.h(str, "android.permission.READ_PHONE_NUMBERS")) {
                return m61.f(context, "android.permission.READ_PHONE_STATE");
            }
        }
        return (m61.h(str, "com.android.permission.GET_INSTALLED_APPS") || m61.h(str, "android.permission.POST_NOTIFICATIONS")) ? super.a(context, str) : m61.q(str) ? m61.h(str, "android.permission.WRITE_SETTINGS") ? m(context) : m61.h(str, "android.permission.ACCESS_NOTIFICATION_POLICY") ? l(context) : m61.h(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? k(context) : super.a(context, str) : m61.f(context, str);
    }

    @Override // dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (!n51.f()) {
            if (m61.h(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.b(activity, str);
            }
            if (m61.h(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return (m61.f(activity, "android.permission.ACCESS_FINE_LOCATION") || m61.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (m61.h(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                return (m61.f(activity, "android.permission.BODY_SENSORS") || m61.v(activity, "android.permission.BODY_SENSORS")) ? false : true;
            }
            if (m61.h(str, "android.permission.READ_MEDIA_IMAGES") || m61.h(str, "android.permission.READ_MEDIA_VIDEO") || m61.h(str, "android.permission.READ_MEDIA_AUDIO")) {
                return (m61.f(activity, "android.permission.READ_EXTERNAL_STORAGE") || m61.v(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
            }
        }
        if (!n51.e()) {
            if (m61.h(str, "android.permission.BLUETOOTH_SCAN")) {
                return (m61.f(activity, "android.permission.ACCESS_FINE_LOCATION") || m61.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (m61.h(str, "android.permission.BLUETOOTH_CONNECT") || m61.h(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                return false;
            }
        }
        if (!n51.c()) {
            if (m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return (m61.f(activity, "android.permission.ACCESS_FINE_LOCATION") || m61.v(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (m61.h(str, "android.permission.ACTIVITY_RECOGNITION")) {
                return false;
            }
            if (m61.h(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                return (m61.f(activity, "android.permission.READ_EXTERNAL_STORAGE") || m61.v(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
            }
        }
        if (!n51.o() && m61.h(str, "android.permission.ACCEPT_HANDOVER")) {
            return false;
        }
        if (!n51.n()) {
            if (m61.h(str, "android.permission.ANSWER_PHONE_CALLS")) {
                return false;
            }
            if (m61.h(str, "android.permission.READ_PHONE_NUMBERS")) {
                return (m61.f(activity, "android.permission.READ_PHONE_STATE") || m61.v(activity, "android.permission.READ_PHONE_STATE")) ? false : true;
            }
        }
        return (m61.h(str, "com.android.permission.GET_INSTALLED_APPS") || m61.h(str, "android.permission.POST_NOTIFICATIONS")) ? super.b(activity, str) : (m61.q(str) || m61.f(activity, str) || m61.v(activity, str)) ? false : true;
    }

    @Override // dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.WRITE_SETTINGS") ? j(context) : m61.h(str, "android.permission.ACCESS_NOTIFICATION_POLICY") ? i(context) : m61.h(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? h(context) : super.c(context, str);
    }
}
