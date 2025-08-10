package dc;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV31.java */
@RequiresApi(api = 31)
/* loaded from: classes2.dex */
public class i61 extends h61 {
    public static Intent v(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(m61.l(context));
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean w(@NonNull Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    @Override // dc.h61, dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.SCHEDULE_EXACT_ALARM") ? w(context) : (m61.h(str, "android.permission.BLUETOOTH_SCAN") || m61.h(str, "android.permission.BLUETOOTH_CONNECT") || m61.h(str, "android.permission.BLUETOOTH_ADVERTISE")) ? m61.f(context, str) : super.a(context, str);
    }

    @Override // dc.h61, dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.SCHEDULE_EXACT_ALARM")) {
            return false;
        }
        return (m61.h(str, "android.permission.BLUETOOTH_SCAN") || m61.h(str, "android.permission.BLUETOOTH_CONNECT") || m61.h(str, "android.permission.BLUETOOTH_ADVERTISE")) ? (m61.f(activity, str) || m61.v(activity, str)) ? false : true : (activity.getApplicationInfo().targetSdkVersion < 31 || !m61.h(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? super.b(activity, str) : (m61.f(activity, "android.permission.ACCESS_FINE_LOCATION") || m61.f(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? (m61.f(activity, str) || m61.v(activity, str)) ? false : true : (m61.v(activity, "android.permission.ACCESS_FINE_LOCATION") || m61.v(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
    }

    @Override // dc.h61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.SCHEDULE_EXACT_ALARM") ? v(context) : super.c(context, str);
    }
}
