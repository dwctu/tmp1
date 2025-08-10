package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes3.dex */
public final class X extends Y {
    private final AbstractC0335da[] a;

    public X(Map<EnumC0312d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0312d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new T());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new Z());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new U());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new C0339ea());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new T());
            arrayList.add(new U());
            arrayList.add(new C0339ea());
        }
        this.a = (AbstractC0335da[]) arrayList.toArray(new AbstractC0335da[arrayList.size()]);
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        Iterator<int[]> it = AbstractC0335da.b(c0413x).iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            for (AbstractC0335da abstractC0335da : this.a) {
                try {
                    com.huawei.hms.scankit.aiscan.common.x xVarA = abstractC0335da.a(i, c0413x, next, map);
                    boolean z = xVarA.b() == BarcodeFormat.EAN_13 && xVarA.i().charAt(0) == '0';
                    Collection collection = map == null ? null : (Collection) map.get(EnumC0312d.POSSIBLE_FORMATS);
                    return (z && (collection == null || collection.contains(BarcodeFormat.UPC_A))) ? new com.huawei.hms.scankit.aiscan.common.x(xVarA.i().substring(1), xVarA.g(), xVarA.h(), BarcodeFormat.UPC_A) : xVarA;
                } catch (C0309a unused) {
                }
            }
        }
        throw C0309a.a();
    }
}
