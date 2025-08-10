package com.huawei.hms.scankit.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: HiAnalyticsLogUtils.java */
/* renamed from: com.huawei.hms.scankit.p.sb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0395sb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return "Unknown";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return subtypeName;
                }
                return "3G";
        }
    }

    public static String b() {
        return "";
    }

    public static String b(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Method declaredMethod = cls.getDeclaredMethod("get", String.class);
                Object[] objArr = new Object[1];
                objArr[0] = "ro.build.version.emui";
                return (String) declaredMethod.invoke(cls, objArr);
            } catch (RuntimeException | InvocationTargetException | Exception unused) {
                return "";
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused2) {
            return null;
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String a(Context context, boolean z) {
        return new C0324ab(context, z).a();
    }
}
