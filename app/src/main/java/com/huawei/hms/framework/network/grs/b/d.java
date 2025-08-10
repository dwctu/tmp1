package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d extends a {
    public d(Context context, boolean z) {
        this.e = z;
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerV2", "appConfigName is" + appConfigName);
        if (a(TextUtils.isEmpty(appConfigName) ? "grs_app_global_route_config.json" : appConfigName, context, true) == 0) {
            this.d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int a(String str) throws JSONException {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.a.b(jSONObject.getString("name"));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", e);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0096 A[Catch: JSONException -> 0x00af, LOOP:1: B:43:0x0090->B:45:0x0096, LOOP_END, TryCatch #0 {JSONException -> 0x00af, blocks: (B:3:0x0010, B:7:0x001f, B:13:0x002d, B:16:0x0034, B:19:0x003c, B:21:0x0042, B:23:0x004d, B:25:0x0056, B:27:0x005f, B:33:0x0076, B:37:0x0081, B:39:0x0088, B:43:0x0090, B:45:0x0096, B:46:0x00a2, B:31:0x0070, B:36:0x007d, B:10:0x0026), top: B:53:0x0010 }] */
    @Override // com.huawei.hms.framework.network.grs.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(java.lang.String r13) throws org.json.JSONException {
        /*
            r12 = this;
            java.lang.String r0 = "countriesOrAreas"
            java.lang.String r1 = "countryOrAreaGroups"
            java.lang.String r2 = "LocalManagerV2"
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 16
            r3.<init>(r4)
            r12.b = r3
            r3 = -1
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> Laf
            r5.<init>(r13)     // Catch: org.json.JSONException -> Laf
            boolean r13 = r5.has(r1)     // Catch: org.json.JSONException -> Laf
            java.lang.String r6 = "countryGroups"
            r7 = 0
            if (r13 == 0) goto L1f
            goto L26
        L1f:
            boolean r13 = r5.has(r6)     // Catch: org.json.JSONException -> Laf
            if (r13 == 0) goto L2b
            r1 = r6
        L26:
            org.json.JSONArray r13 = r5.getJSONArray(r1)     // Catch: org.json.JSONException -> Laf
            goto L31
        L2b:
            java.lang.String r13 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config."
            com.huawei.hms.framework.common.Logger.e(r2, r13)     // Catch: org.json.JSONException -> Laf
            r13 = r7
        L31:
            if (r13 != 0) goto L34
            return r3
        L34:
            int r1 = r13.length()     // Catch: org.json.JSONException -> Laf
            r5 = 0
            if (r1 == 0) goto Lae
            r1 = 0
        L3c:
            int r6 = r13.length()     // Catch: org.json.JSONException -> Laf
            if (r1 >= r6) goto Lae
            org.json.JSONObject r6 = r13.getJSONObject(r1)     // Catch: org.json.JSONException -> Laf
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> Laf
            r8.<init>()     // Catch: org.json.JSONException -> Laf
            java.lang.String r9 = "id"
            java.lang.String r9 = r6.getString(r9)     // Catch: org.json.JSONException -> Laf
            r8.b(r9)     // Catch: org.json.JSONException -> Laf
            java.lang.String r9 = "name"
            java.lang.String r9 = r6.getString(r9)     // Catch: org.json.JSONException -> Laf
            r8.c(r9)     // Catch: org.json.JSONException -> Laf
            java.lang.String r9 = "description"
            java.lang.String r9 = r6.getString(r9)     // Catch: org.json.JSONException -> Laf
            r8.a(r9)     // Catch: org.json.JSONException -> Laf
            boolean r9 = r6.has(r0)     // Catch: org.json.JSONException -> Laf
            java.lang.String r10 = "countries"
            if (r9 == 0) goto L70
            r10 = r0
            goto L76
        L70:
            boolean r9 = r6.has(r10)     // Catch: org.json.JSONException -> Laf
            if (r9 == 0) goto L7b
        L76:
            org.json.JSONArray r6 = r6.getJSONArray(r10)     // Catch: org.json.JSONException -> Laf
            goto L81
        L7b:
            java.lang.String r6 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r2, r6)     // Catch: org.json.JSONException -> Laf
            r6 = r7
        L81:
            java.util.HashSet r9 = new java.util.HashSet     // Catch: org.json.JSONException -> Laf
            r9.<init>(r4)     // Catch: org.json.JSONException -> Laf
            if (r6 == 0) goto Lad
            int r10 = r6.length()     // Catch: org.json.JSONException -> Laf
            if (r10 != 0) goto L8f
            goto Lad
        L8f:
            r10 = 0
        L90:
            int r11 = r6.length()     // Catch: org.json.JSONException -> Laf
            if (r10 >= r11) goto La2
            java.lang.Object r11 = r6.get(r10)     // Catch: org.json.JSONException -> Laf
            java.lang.String r11 = (java.lang.String) r11     // Catch: org.json.JSONException -> Laf
            r9.add(r11)     // Catch: org.json.JSONException -> Laf
            int r10 = r10 + 1
            goto L90
        La2:
            r8.a(r9)     // Catch: org.json.JSONException -> Laf
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r6 = r12.b     // Catch: org.json.JSONException -> Laf
            r6.add(r8)     // Catch: org.json.JSONException -> Laf
            int r1 = r1 + 1
            goto L3c
        Lad:
            return r3
        Lae:
            return r5
        Laf:
            r13 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.w(r2, r0, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.b.d.b(java.lang.String):int");
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int e(String str) {
        return d(str);
    }
}
