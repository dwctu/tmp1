package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: UPCAWriter.java */
/* renamed from: com.huawei.hms.scankit.p.uc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0404uc implements Pb {
    private final C0389qc a = new C0389qc();

    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.a.a('0' + str, BarcodeFormat.EAN_13, i, i2, map);
    }
}
