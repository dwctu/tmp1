package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.util.LinkedHashMap;

/* compiled from: HaLog.java */
/* renamed from: com.huawei.hms.scankit.p.ob, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0380ob {
    public static String a = "FORMAT_UNKNOWN";
    public static String b = "OTHER";
    public static SparseArray<String> c = new C0328bb();
    public static SparseArray<String> d = new C0332cb();
    public Context e;
    public LinkedHashMap<String, String> f = new LinkedHashMap<>();
    public volatile long g;

    public AbstractC0380ob(Bundle bundle, Context context) throws PackageManager.NameNotFoundException {
        this.e = context;
        b(bundle);
    }

    private void b(Bundle bundle) throws PackageManager.NameNotFoundException {
        try {
            String packageName = this.e.getPackageName();
            this.f.put("package", packageName);
            if (bundle == null || !bundle.containsKey(MLApplicationSetting.BundleKeyConstants.AppInfo.appid)) {
                this.f.put(MLApplicationSetting.BundleKeyConstants.AppInfo.appid, packageName);
            } else {
                this.f.put(MLApplicationSetting.BundleKeyConstants.AppInfo.appid, bundle.getString(MLApplicationSetting.BundleKeyConstants.AppInfo.appid));
            }
            PackageManager packageManager = this.e.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            this.f.put(MLApplicationSetting.BundleKeyConstants.AppInfo.appName, applicationInfo.loadLabel(packageManager).toString());
            this.f.put("version", a(applicationInfo.metaData));
            String strD = d();
            this.f.put("hmscoreVersion", strD);
            this.f.put("isHMSCore", EnvironmentCompat.MEDIA_UNKNOWN.equals(strD) ? "0" : "1");
        } catch (PackageManager.NameNotFoundException unused) {
            com.huawei.hms.scankit.util.a.b("HaLog", "PackageManager.NameNotFoundException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("HaLog", "initValue Exception");
        }
        try {
            this.f.put("sdkName", "scankit");
            this.f.put("algopt", b());
            this.f.put("isFullSdk", "LITESDK");
            this.f.put("cpAppVersion", c());
            if (f()) {
                this.f.put("apkVersion", EnvironmentCompat.MEDIA_UNKNOWN);
            } else {
                this.f.put("apkVersion", "1.0");
            }
            this.f.put(NotificationCompat.CATEGORY_SERVICE, "com.huawei.hms.scankit");
            this.f.put("operator", C0395sb.b(this.e));
            this.f.put("networkType", C0395sb.a(this.e));
            this.f.put("countryCode", C0395sb.a(this.e, false));
            this.f.put("deviceType", C0395sb.c());
            this.f.put("emuiVersion", C0395sb.d());
            this.f.put("androidVersion", C0395sb.a());
            this.f.put("deviceCategory", C0395sb.b());
        } catch (RuntimeException unused3) {
            com.huawei.hms.scankit.util.a.b("HaLog", "initValue RuntimeException");
        } catch (Exception unused4) {
            com.huawei.hms.scankit.util.a.b("HaLog", "initValue Exception");
        }
    }

    private String c() {
        try {
            return this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private String d() {
        try {
            return this.e.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private boolean e() {
        try {
            String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
            TelephonyManager telephonyManager = (TelephonyManager) this.e.getApplicationContext().getSystemService("phone");
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            String simCountryIso = telephonyManager.getSimCountryIso();
            if ("CN".equalsIgnoreCase(property) && "CN".equalsIgnoreCase(networkCountryIso)) {
                return "CN".equalsIgnoreCase(simCountryIso);
            }
            return false;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    private boolean f() {
        return true;
    }

    public boolean a() {
        if (com.huawei.hms.scankit.util.b.c(this.e)) {
            return false;
        }
        try {
            if (!f() && !e()) {
                if (Settings.Secure.getInt(this.e.getContentResolver(), "hw_app_analytics_state", 0) != 1) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static String a(int i) {
        return c.get(i, a);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle == null) {
            return "scankit:1.0.2.300";
        }
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (bundle.getString(str) != null) {
                return bundle.getString(str);
            }
        }
        return "scankit:1.0.2.300";
    }

    private String b() {
        return Build.VERSION.SDK_INT == 24 ? "lite-noso" : "lite";
    }

    public static String b(int i) {
        return d.get(i, b);
    }
}
