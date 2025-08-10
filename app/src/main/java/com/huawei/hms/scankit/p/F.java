package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.G;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes3.dex */
public /* synthetic */ class F {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[G.a.values().length];
        a = iArr;
        try {
            iArr[G.a.C40_ENCODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[G.a.TEXT_ENCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[G.a.ANSIX12_ENCODE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[G.a.EDIFACT_ENCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[G.a.BASE256_ENCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
