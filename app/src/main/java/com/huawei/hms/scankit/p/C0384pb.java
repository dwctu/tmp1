package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;

/* compiled from: HaUtil.java */
/* renamed from: com.huawei.hms.scankit.p.pb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0384pb {
    private static final String a = "pb";
    private static volatile Bundle b;

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.appid, string);
            } catch (RuntimeException | Exception unused) {
            }
            b = bundle;
        }
        return b;
    }
}
