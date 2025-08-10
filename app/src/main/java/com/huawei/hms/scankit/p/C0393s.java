package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0397t;

/* compiled from: Decoder.java */
/* renamed from: com.huawei.hms.scankit.p.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public /* synthetic */ class C0393s {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[C0397t.a.values().length];
        a = iArr;
        try {
            iArr[C0397t.a.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[C0397t.a.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[C0397t.a.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[C0397t.a.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[C0397t.a.DIGIT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
