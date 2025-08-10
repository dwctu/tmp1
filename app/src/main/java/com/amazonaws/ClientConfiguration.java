package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class ClientConfiguration {
    public static final String l = VersionInfoUtils.b();
    public static final RetryPolicy m = PredefinedRetryPolicies.b;
    public String b;
    public String h;
    public String a = l;
    public int c = -1;
    public RetryPolicy d = m;
    public Protocol e = Protocol.HTTPS;
    public int f = 15000;
    public int g = 15000;
    public TrustManager i = null;
    public boolean j = false;
    public boolean k = false;

    public int a() {
        return this.g;
    }

    public int b() {
        return this.c;
    }

    public Protocol c() {
        return this.e;
    }

    public RetryPolicy d() {
        return this.d;
    }

    public String e() {
        return this.h;
    }

    public int f() {
        return this.f;
    }

    public TrustManager g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public String i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }
}
