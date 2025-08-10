package com.huawei.hms.scankit.p;

import android.util.SparseArray;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: HaLog.java */
/* renamed from: com.huawei.hms.scankit.p.bb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0328bb extends SparseArray<String> {
    public C0328bb() {
        put(HmsScanBase.AZTEC_SCAN_TYPE, "AZTEC");
        put(HmsScanBase.CODABAR_SCAN_TYPE, "CODABAR");
        put(HmsScanBase.CODE39_SCAN_TYPE, "CODE39");
        put(HmsScanBase.CODE93_SCAN_TYPE, "CODE93");
        put(HmsScanBase.CODE128_SCAN_TYPE, "CODE128");
        put(HmsScanBase.DATAMATRIX_SCAN_TYPE, "DATAMATRIX");
        put(HmsScanBase.EAN8_SCAN_TYPE, "EAN8");
        put(HmsScanBase.EAN13_SCAN_TYPE, "EAN13");
        put(HmsScanBase.ITF14_SCAN_TYPE, "ITF14");
        put(HmsScanBase.PDF417_SCAN_TYPE, "PDF417");
        put(HmsScanBase.QRCODE_SCAN_TYPE, "QRCODE");
        put(HmsScanBase.UPCCODE_A_SCAN_TYPE, "UPCCODE_A");
        put(HmsScanBase.UPCCODE_E_SCAN_TYPE, "UPCCODE_E");
        put(HmsScanBase.FORMAT_UNKNOWN, AbstractC0380ob.a);
    }
}
