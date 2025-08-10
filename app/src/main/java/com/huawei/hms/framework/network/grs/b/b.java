package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class b {
    private static Map<String, b> a = new ConcurrentHashMap(16);
    private a b;

    public b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        a(context, z);
        a.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        return a.get(str + grsBaseInfo.uniqueCode());
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        com.huawei.hms.framework.network.grs.local.model.a aVarA;
        b bVarA = a(context.getPackageName(), grsBaseInfo);
        if (bVarA == null || (aVarA = bVarA.a()) == null) {
            return;
        }
        Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
        aVarA.a();
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.b.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        return this.b.a(context, aVar, grsBaseInfo, str, str2, z);
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        return this.b.a(context, aVar, grsBaseInfo, str, z);
    }

    public void a(Context context, boolean z) {
        d dVar = new d(context, z);
        this.b = dVar;
        if (dVar.c()) {
            return;
        }
        this.b = new c(context, z);
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.b.a(grsBaseInfo);
    }

    public Set<String> b() {
        return this.b.b();
    }
}
