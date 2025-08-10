package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: MultiFormatWriter.java */
/* loaded from: classes3.dex */
public /* synthetic */ class Nb {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BarcodeFormat.values().length];
        a = iArr;
        try {
            iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[BarcodeFormat.UPC_E.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[BarcodeFormat.EAN_13.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[BarcodeFormat.UPC_A.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[BarcodeFormat.QR_CODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[BarcodeFormat.CODE_39.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[BarcodeFormat.CODE_93.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[BarcodeFormat.CODE_128.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[BarcodeFormat.ITF.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[BarcodeFormat.PDF_417.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[BarcodeFormat.CODABAR.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            a[BarcodeFormat.AZTEC.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
