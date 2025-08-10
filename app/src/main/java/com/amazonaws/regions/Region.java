package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Region {
    public final String a;
    public final String b;
    public final Map<String, String> c = new HashMap();
    public final Map<String, Boolean> d = new HashMap();
    public final Map<String, Boolean> e = new HashMap();

    public Region(String str, String str2) {
        this.a = str;
        if (str2 == null || str2.isEmpty()) {
            this.b = "amazonaws.com";
        } else {
            this.b = str2;
        }
    }

    public static Region e(String str) {
        return RegionUtils.a(str);
    }

    public String a() {
        return this.b;
    }

    public Map<String, Boolean> b() {
        return this.d;
    }

    public Map<String, Boolean> c() {
        return this.e;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return d().equals(((Region) obj).d());
        }
        return false;
    }

    public String f(String str) {
        return this.c.get(str);
    }

    public Map<String, String> g() {
        return this.c;
    }

    public boolean h(String str) {
        return this.c.containsKey(str);
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d();
    }
}
