package com.huawei.hms.scankit.aiscan.common;

import java.util.List;

/* compiled from: DecoderResult.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0313e {
    private final byte[] a;
    private int b;
    private final String c;
    private final List<byte[]> d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;

    public C0313e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.b;
    }

    public void b(Integer num) {
        this.f = num;
    }

    public byte[] c() {
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public C0313e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i2;
        this.j = i;
    }

    public void a(int i) {
        this.b = i;
    }

    public Object b() {
        return this.h;
    }

    public void a(Integer num) {
        this.g = num;
    }

    public void a(Object obj) {
        this.h = obj;
    }
}
