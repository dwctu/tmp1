package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0363ka;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.ja, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public /* synthetic */ class C0359ja {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[C0363ka.a.values().length];
        a = iArr;
        try {
            iArr[C0363ka.a.ALPHA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[C0363ka.a.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[C0363ka.a.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[C0363ka.a.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[C0363ka.a.ALPHA_SHIFT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[C0363ka.a.PUNCT_SHIFT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
