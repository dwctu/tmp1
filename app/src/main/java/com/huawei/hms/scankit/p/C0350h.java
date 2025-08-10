package com.huawei.hms.scankit.p;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;
import java.util.Objects;

/* compiled from: CountryCodeBean.java */
/* renamed from: com.huawei.hms.scankit.p.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0350h {
    private static final String a = "h";
    private String b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
    private String c;

    public C0350h(Context context, boolean z) {
        this.c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        b(context, z);
        this.c = this.c.toUpperCase(Locale.ENGLISH);
    }

    private void b(Context context, boolean z) {
        Objects.requireNonNull(context, "context must be not null.Please provide app's Context");
        try {
            d();
            if (e()) {
                return;
            }
            a(context, z);
            if (e()) {
                return;
            }
            c();
            e();
        } catch (Exception unused) {
        }
    }

    private void c() {
        this.c = a("get", "ro.product.locale.region", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
        this.b = GrsBaseInfo.CountryCodeSource.LOCALE_INFO;
        String str = "getLocaleCountryCode=" + this.c;
        if ("cn".equalsIgnoreCase(this.c)) {
            return;
        }
        this.c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        this.b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    private void d() {
        this.b = GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
        this.c = a("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
        String str = "getVendorCountry=" + this.c;
        if (!"eu".equalsIgnoreCase(this.c) && !"la".equalsIgnoreCase(this.c)) {
            b();
        } else {
            this.c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
            this.b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    private boolean e() {
        return !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.c);
    }

    public String a() {
        return this.c;
    }

    private void a(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                this.c = telephonyManager.getSimCountryIso();
                this.b = GrsBaseInfo.CountryCodeSource.SIM_COUNTRY;
                String str = "getSimCountryCode by not enableNetwork, countryCode=" + this.c;
            } else {
                this.c = telephonyManager.getNetworkCountryIso();
                this.b = GrsBaseInfo.CountryCodeSource.NETWORK_COUNTRY;
                String str2 = "getSimCountryCode by enableNetwork, countryCode=" + this.c;
            }
        }
        b();
    }

    private void b() {
        String str = this.c;
        if (str == null || str.length() != 2) {
            this.c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
            this.b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    private static String a(String str, String str2, String str3, String str4) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
            return str4;
        }
    }
}
