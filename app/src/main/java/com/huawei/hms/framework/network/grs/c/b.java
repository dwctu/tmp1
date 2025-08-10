package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class b {
    public f a;
    private String b;
    private com.huawei.hms.framework.network.grs.c.a c;
    private int d;
    private Context e;
    private String f;
    private GrsBaseInfo g;
    private com.huawei.hms.framework.network.grs.a.c h;

    public enum a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public b(String str, int i, com.huawei.hms.framework.network.grs.c.a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.c cVar) {
        this.b = str;
        this.c = aVar;
        this.d = i;
        this.e = context;
        this.f = str2;
        this.g = grsBaseInfo;
        this.h = cVar;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private a h() {
        if (this.b.isEmpty()) {
            return a.GRSDEFAULT;
        }
        String strA = a(this.b);
        return strA.contains("1.0") ? a.GRSGET : strA.contains("2.0") ? a.GRSPOST : a.GRSDEFAULT;
    }

    public com.huawei.hms.framework.network.grs.c.a a() {
        return this.c;
    }

    public Context b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public com.huawei.hms.framework.network.grs.a.c f() {
        return this.h;
    }

    public Callable<f> g() {
        if (a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return a.GRSGET.equals(h()) ? new i(this.b, this.d, this.c, this.e, this.f, this.g) : new j(this.b, this.d, this.c, this.e, this.f, this.g, this.h);
    }
}
