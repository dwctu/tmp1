package com.huawei.hms.scankit.p;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes3.dex */
public /* synthetic */ class La {
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
        try {
            a[Va.TERMINATOR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[Va.FNC1_FIRST_POSITION.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[Va.FNC1_SECOND_POSITION.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[Va.STRUCTURED_APPEND.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[Va.ECI.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[Va.HANZI.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
