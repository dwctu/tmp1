package com.huawei.hms.scankit.p;

/* compiled from: Mode.java */
/* loaded from: classes3.dex */
public enum Va {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int[] l;
    private final int m;

    Va(int[] iArr, int i) {
        this.l = iArr;
        this.m = i;
    }

    public static Va a(int i) throws Exception {
        if (i == 0) {
            return TERMINATOR;
        }
        if (i == 1) {
            return NUMERIC;
        }
        if (i == 2) {
            return ALPHANUMERIC;
        }
        if (i == 3) {
            return STRUCTURED_APPEND;
        }
        if (i == 4) {
            return BYTE;
        }
        if (i == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i == 7) {
            return ECI;
        }
        if (i == 8) {
            return KANJI;
        }
        if (i == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i == 13) {
            return HANZI;
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw e;
        }
    }

    public int a(Ya ya) {
        int iE = ya.e();
        return this.l[iE <= 9 ? (char) 0 : iE <= 26 ? (char) 1 : (char) 2];
    }

    public int a() {
        return this.m;
    }
}
