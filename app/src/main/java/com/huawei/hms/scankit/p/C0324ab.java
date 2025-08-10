package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;

/* compiled from: CountryCodeBean.java */
/* renamed from: com.huawei.hms.scankit.p.ab, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0324ab {
    private static final String a = "ab";
    private String b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
    private String c;

    public C0324ab(Context context, boolean z) {
        this.c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        a(context, z);
        this.c = this.c.toUpperCase(Locale.ENGLISH);
    }

    private boolean b() {
        return !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.c);
    }

    public String a() {
        return this.c;
    }

    private void a(Context context, boolean z) {
        if (context != null) {
            try {
                this.c = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(a, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(a, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(a, "get CountryCode error");
            }
        }
    }
}
