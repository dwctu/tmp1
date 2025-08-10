package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.UUID;

/* compiled from: HaLog60000.java */
/* renamed from: com.huawei.hms.scankit.p.fb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0344fb extends AbstractC0380ob {
    private int h;
    public String i;
    public String j;

    public C0344fb(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext().getApplicationContext());
        this.h = -1001;
        this.i = AbstractC0380ob.a;
        this.j = AbstractC0380ob.b;
        this.f.put("callTime", new C0336db(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(System.currentTimeMillis())));
        this.f.put("transId", UUID.randomUUID().toString());
        this.f.put("apiName", str);
    }

    private void g() {
        this.h = -1001;
        this.i = AbstractC0380ob.a;
        this.j = AbstractC0380ob.b;
    }

    public void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null) {
            this.h = hmsScanArr.length;
            for (HmsScan hmsScan : hmsScanArr) {
                this.i = AbstractC0380ob.a(hmsScan.scanType);
                this.j = AbstractC0380ob.b(hmsScan.scanTypeForm);
            }
        }
    }

    public void b() {
        this.g = System.currentTimeMillis();
    }

    public void c() {
        try {
            if (a()) {
                C0340eb c0340eb = new C0340eb(this);
                c0340eb.put("result", String.valueOf(this.h));
                c0340eb.put("costTime", String.valueOf(System.currentTimeMillis() - this.g));
                c0340eb.put("scanType", this.i);
                c0340eb.put("sceneType", this.j);
                C0391rb.a().a("60000", c0340eb);
                g();
            }
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.b("HaLog60000", "nullPoint");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("HaLog60000", "logEnd Exception");
        }
    }

    public void c(int i) {
        this.h = i;
    }
}
