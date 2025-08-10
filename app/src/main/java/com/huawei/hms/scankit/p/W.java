package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes3.dex */
public final class W extends Y {
    private static final Y[] a = new Y[0];
    private final Y[] b;

    public W(Map<EnumC0312d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0312d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new X(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new Q(false));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new S());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new P());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new V());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new O());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new X(map));
            arrayList.add(new Q());
            arrayList.add(new O());
            arrayList.add(new S());
            arrayList.add(new P());
            arrayList.add(new V());
        }
        this.b = (Y[]) arrayList.toArray(a);
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        for (Y y : this.b) {
            try {
                return y.a(i, c0413x, map);
            } catch (C0309a unused) {
            }
        }
        throw C0309a.a();
    }
}
