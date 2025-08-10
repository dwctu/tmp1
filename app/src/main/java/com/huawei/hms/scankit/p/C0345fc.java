package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;

/* compiled from: EncoderContext.java */
/* renamed from: com.huawei.hms.scankit.p.fc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0345fc {
    private final String a;
    private EnumC0361jc b;
    private Mb c;
    private Mb d;
    private final StringBuilder e;
    public int f;
    private int g;
    private C0357ic h;
    private int i;

    public C0345fc(String str) throws Exception {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                try {
                    throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                } catch (Exception e) {
                    throw e;
                }
            }
            sb.append(c);
        }
        this.a = sb.toString();
        this.b = EnumC0361jc.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    private int l() {
        return this.a.length() - this.i;
    }

    public void a(EnumC0361jc enumC0361jc) {
        this.b = enumC0361jc;
    }

    public StringBuilder b() {
        return this.e;
    }

    public char c() {
        return this.a.charAt(this.f);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return l() - this.f;
    }

    public C0357ic g() {
        return this.h;
    }

    public boolean h() {
        return this.f < l();
    }

    public void i() {
        this.g = -1;
    }

    public void j() {
        this.h = null;
    }

    public void k() {
        c(a());
    }

    public void a(Mb mb, Mb mb2) {
        this.c = mb;
        this.d = mb2;
    }

    public void b(int i) {
        this.g = i;
    }

    public void c(int i) {
        C0357ic c0357ic = this.h;
        if (c0357ic == null || i > c0357ic.a()) {
            this.h = C0357ic.a(i, this.b, this.c, this.d, true);
        }
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.e.append(str);
    }

    public void a(char c) {
        this.e.append(c);
    }

    public int a() {
        return this.e.length();
    }
}
