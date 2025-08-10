package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.d;
import java.io.Closeable;

/* loaded from: classes.dex */
public class b {
    private static final Uri a = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri b = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    public static AdvertisingIdClient.Info a(final Context context) {
        if (context == null || !a(context, a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        final d.a aVarA = d.a.a(context);
        String strA = aVarA.a();
        if (TextUtils.isEmpty(strA)) {
            e.a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVarA.c()) {
                        return;
                    }
                    aVarA.b();
                    aVarA.a(b.e(context));
                }
            });
            if (aVarA.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            aVarA.d();
            return null;
        }
        String strA2 = d.a(string, strA);
        if (!TextUtils.isEmpty(strA2)) {
            return new AdvertisingIdClient.Info(strA2, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strA2));
        }
        e.a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.b.2
            @Override // java.lang.Runnable
            public void run() {
                aVarA.a(b.e(context));
            }
        });
        return null;
    }

    private static boolean a(Context context, Uri uri) {
        Integer numB;
        if (context == null || uri == null || (numB = e.b(context)) == null || 30462100 > numB.intValue()) {
            return false;
        }
        return e.a(context, uri);
    }

    public static AdvertisingIdClient.Info b(Context context) {
        if (context == null || !c(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(b, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
                String string = cursorQuery.getString(columnIndexOrThrow);
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
                e.a(cursorQuery);
                return info;
            }
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            e.a(cursorQuery);
            return info2;
        } catch (Throwable th) {
            try {
                String str = "query oaid via provider ex: " + th.getClass().getSimpleName();
                e.a((Closeable) null);
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } catch (Throwable th2) {
                e.a((Closeable) null);
                throw th2;
            }
        }
    }

    public static boolean c(Context context) {
        return a(context, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(a, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
            }
            return "";
        } catch (Throwable th) {
            try {
                String str = "get remote key ex: " + th.getClass().getSimpleName();
                return "";
            } finally {
                e.a(cursorQuery);
            }
        }
    }
}
