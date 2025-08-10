package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FormatsList.java */
/* loaded from: classes3.dex */
public class Za {
    public static List<List<BarcodeFormat>> a(int i) {
        if (i <= 0) {
            i = 8191;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (i > 0) {
            BarcodeFormat[] barcodeFormatArr = {BarcodeFormat.CODE_128, BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODABAR, BarcodeFormat.DATA_MATRIX, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.ITF, BarcodeFormat.QR_CODE, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.PDF_417, BarcodeFormat.AZTEC};
            int[] iArr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            if ((iArr[8] & i) != 0) {
                arrayList.add(barcodeFormatArr[8]);
            }
            if ((iArr[11] & i) != 0) {
                arrayList3.add(barcodeFormatArr[11]);
            }
            for (int i2 = 0; i2 < 13; i2++) {
                if ((iArr[i2] & i) != 0 && i2 != 8 && i2 != 11) {
                    if (i2 == 4) {
                        arrayList5.add(barcodeFormatArr[i2]);
                    } else if (i2 == 12) {
                        arrayList4.add(barcodeFormatArr[i2]);
                    } else {
                        arrayList2.add(barcodeFormatArr[i2]);
                    }
                }
            }
        }
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(arrayList);
        arrayList6.add(arrayList2);
        arrayList6.add(arrayList3);
        arrayList6.add(arrayList5);
        arrayList6.add(arrayList4);
        return arrayList6;
    }
}
