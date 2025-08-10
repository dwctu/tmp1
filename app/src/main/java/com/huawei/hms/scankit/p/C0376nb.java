package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;

/* compiled from: HaLog60002.java */
/* renamed from: com.huawei.hms.scankit.p.nb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0376nb extends AbstractC0380ob {
    public C0376nb() {
        super(null, DynamicModuleInitializer.getContext());
    }

    public void a(Bundle bundle) {
        if (bundle == null || !a()) {
            return;
        }
        try {
            if (bundle.containsKey("scanType") && (bundle.get("scanType") instanceof Integer)) {
                bundle.putString("scanType", AbstractC0380ob.a(bundle.getInt("scanType")));
            }
            C0372mb c0372mb = new C0372mb(this);
            for (String str : bundle.keySet()) {
                c0372mb.put(str, String.valueOf(bundle.get(str)));
            }
            C0391rb.a().a("60002", c0372mb);
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b("HaLog60002", "RuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("HaLog60002", "Exception");
        }
    }
}
