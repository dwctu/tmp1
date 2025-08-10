package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.lang.ref.WeakReference;

/* compiled from: BundleGetting.java */
/* renamed from: com.huawei.hms.scankit.p.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0354i {
    private static final String a = "i";
    private WeakReference<Context> b;

    public C0354i(Context context) {
        this.b = new WeakReference<>(context);
    }

    public final Bundle a() {
        if (this.b.get() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", this.b.get().getPackageName() == null ? "camera.cannot.get.package.name" : this.b.get().getPackageName());
        bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.appid, "com.huawei.hms.ml.camera");
        bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.mlSdkVersion, "ml-computer-vision:".concat("1.0.2.300"));
        bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.appName, a(this.b.get()));
        bundle.putBoolean(MLApplicationSetting.BundleKeyConstants.AppInfo.openHa, Settings.Secure.getInt(this.b.get().getContentResolver(), "hw_app_analytics_state", 0) == 1);
        bundle.putString("countryCode", new C0350h(this.b.get(), false).a());
        return bundle;
    }

    private static String a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
