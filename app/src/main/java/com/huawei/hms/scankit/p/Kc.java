package com.huawei.hms.scankit.p;

/* compiled from: Encoder.java */
/* loaded from: classes3.dex */
public /* synthetic */ class Kc {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Va.values().length];
        a = iArr;
        try {
            iArr[Va.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[Va.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[Va.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[Va.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
