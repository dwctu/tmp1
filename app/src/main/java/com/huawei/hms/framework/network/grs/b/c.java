package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.framework.common.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c extends a {
    public c(Context context, boolean z) {
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context, false) == 0) {
            this.d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int a(String str) throws JSONException {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.b(string);
            this.a.a(j);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", e);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073 A[Catch: JSONException -> 0x008d, LOOP:1: B:30:0x006d->B:32:0x0073, LOOP_END, TryCatch #0 {JSONException -> 0x008d, blocks: (B:7:0x000e, B:8:0x0019, B:10:0x001f, B:12:0x0033, B:14:0x003c, B:20:0x0054, B:24:0x005e, B:26:0x0065, B:30:0x006d, B:32:0x0073, B:33:0x007f, B:34:0x0086, B:18:0x004e, B:23:0x005b), top: B:42:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONArray r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            r9 = this;
            java.lang.String r10 = "countriesOrAreas"
            java.lang.String r0 = "LocalManagerV1"
            if (r11 == 0) goto L99
            int r1 = r11.length()
            if (r1 != 0) goto Le
            goto L99
        Le:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: org.json.JSONException -> L8d
            r2 = 16
            r1.<init>(r2)     // Catch: org.json.JSONException -> L8d
            java.util.Iterator r3 = r11.keys()     // Catch: org.json.JSONException -> L8d
        L19:
            boolean r4 = r3.hasNext()     // Catch: org.json.JSONException -> L8d
            if (r4 == 0) goto L8c
            java.lang.Object r4 = r3.next()     // Catch: org.json.JSONException -> L8d
            java.lang.String r4 = (java.lang.String) r4     // Catch: org.json.JSONException -> L8d
            com.huawei.hms.framework.network.grs.local.model.b r5 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> L8d
            r5.<init>()     // Catch: org.json.JSONException -> L8d
            r5.b(r4)     // Catch: org.json.JSONException -> L8d
            org.json.JSONObject r4 = r11.getJSONObject(r4)     // Catch: org.json.JSONException -> L8d
            java.lang.String r6 = "name"
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L8d
            r5.c(r6)     // Catch: org.json.JSONException -> L8d
            java.lang.String r6 = "description"
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L8d
            r5.a(r6)     // Catch: org.json.JSONException -> L8d
            r6 = 0
            boolean r7 = r4.has(r10)     // Catch: org.json.JSONException -> L8d
            java.lang.String r8 = "countries"
            if (r7 == 0) goto L4e
            r8 = r10
            goto L54
        L4e:
            boolean r7 = r4.has(r8)     // Catch: org.json.JSONException -> L8d
            if (r7 == 0) goto L59
        L54:
            org.json.JSONArray r6 = r4.getJSONArray(r8)     // Catch: org.json.JSONException -> L8d
            goto L5e
        L59:
            java.lang.String r4 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r0, r4)     // Catch: org.json.JSONException -> L8d
        L5e:
            java.util.HashSet r4 = new java.util.HashSet     // Catch: org.json.JSONException -> L8d
            r4.<init>(r2)     // Catch: org.json.JSONException -> L8d
            if (r6 == 0) goto L86
            int r7 = r6.length()     // Catch: org.json.JSONException -> L8d
            if (r7 != 0) goto L6c
            goto L86
        L6c:
            r7 = 0
        L6d:
            int r8 = r6.length()     // Catch: org.json.JSONException -> L8d
            if (r7 >= r8) goto L7f
            java.lang.Object r8 = r6.get(r7)     // Catch: org.json.JSONException -> L8d
            java.lang.String r8 = (java.lang.String) r8     // Catch: org.json.JSONException -> L8d
            r4.add(r8)     // Catch: org.json.JSONException -> L8d
            int r7 = r7 + 1
            goto L6d
        L7f:
            r5.a(r4)     // Catch: org.json.JSONException -> L8d
            r1.add(r5)     // Catch: org.json.JSONException -> L8d
            goto L19
        L86:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch: org.json.JSONException -> L8d
            r10.<init>()     // Catch: org.json.JSONException -> L8d
            return r10
        L8c:
            return r1
        L8d:
            r10 = move-exception
            java.lang.String r11 = "parse countryGroups failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.w(r0, r11, r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            return r10
        L99:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.b.c.a(org.json.JSONArray, org.json.JSONObject):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0099 A[Catch: JSONException -> 0x00b0, LOOP:1: B:41:0x0093->B:43:0x0099, LOOP_END, TryCatch #0 {JSONException -> 0x00b0, blocks: (B:3:0x0010, B:7:0x001f, B:13:0x002d, B:16:0x0034, B:18:0x003b, B:19:0x003f, B:21:0x0045, B:23:0x0059, B:25:0x0062, B:31:0x0079, B:35:0x0084, B:37:0x008b, B:41:0x0093, B:43:0x0099, B:44:0x00a5, B:29:0x0073, B:34:0x0080, B:10:0x0026), top: B:51:0x0010 }] */
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
            java.lang.String r2 = "LocalManagerV1"
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 16
            r3.<init>(r4)
            r12.b = r3
            r3 = -1
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lb0
            r5.<init>(r13)     // Catch: org.json.JSONException -> Lb0
            boolean r13 = r5.has(r1)     // Catch: org.json.JSONException -> Lb0
            java.lang.String r6 = "countryGroups"
            r7 = 0
            if (r13 == 0) goto L1f
            goto L26
        L1f:
            boolean r13 = r5.has(r6)     // Catch: org.json.JSONException -> Lb0
            if (r13 == 0) goto L2b
            r1 = r6
        L26:
            org.json.JSONObject r13 = r5.getJSONObject(r1)     // Catch: org.json.JSONException -> Lb0
            goto L31
        L2b:
            java.lang.String r13 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config."
            com.huawei.hms.framework.common.Logger.e(r2, r13)     // Catch: org.json.JSONException -> Lb0
            r13 = r7
        L31:
            if (r13 != 0) goto L34
            return r3
        L34:
            int r1 = r13.length()     // Catch: org.json.JSONException -> Lb0
            r5 = 0
            if (r1 == 0) goto Laf
            java.util.Iterator r1 = r13.keys()     // Catch: org.json.JSONException -> Lb0
        L3f:
            boolean r6 = r1.hasNext()     // Catch: org.json.JSONException -> Lb0
            if (r6 == 0) goto Laf
            java.lang.Object r6 = r1.next()     // Catch: org.json.JSONException -> Lb0
            java.lang.String r6 = (java.lang.String) r6     // Catch: org.json.JSONException -> Lb0
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> Lb0
            r8.<init>()     // Catch: org.json.JSONException -> Lb0
            r8.b(r6)     // Catch: org.json.JSONException -> Lb0
            org.json.JSONObject r6 = r13.getJSONObject(r6)     // Catch: org.json.JSONException -> Lb0
            java.lang.String r9 = "name"
            java.lang.String r9 = r6.getString(r9)     // Catch: org.json.JSONException -> Lb0
            r8.c(r9)     // Catch: org.json.JSONException -> Lb0
            java.lang.String r9 = "description"
            java.lang.String r9 = r6.getString(r9)     // Catch: org.json.JSONException -> Lb0
            r8.a(r9)     // Catch: org.json.JSONException -> Lb0
            boolean r9 = r6.has(r0)     // Catch: org.json.JSONException -> Lb0
            java.lang.String r10 = "countries"
            if (r9 == 0) goto L73
            r10 = r0
            goto L79
        L73:
            boolean r9 = r6.has(r10)     // Catch: org.json.JSONException -> Lb0
            if (r9 == 0) goto L7e
        L79:
            org.json.JSONArray r6 = r6.getJSONArray(r10)     // Catch: org.json.JSONException -> Lb0
            goto L84
        L7e:
            java.lang.String r6 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r2, r6)     // Catch: org.json.JSONException -> Lb0
            r6 = r7
        L84:
            java.util.HashSet r9 = new java.util.HashSet     // Catch: org.json.JSONException -> Lb0
            r9.<init>(r4)     // Catch: org.json.JSONException -> Lb0
            if (r6 == 0) goto Lae
            int r10 = r6.length()     // Catch: org.json.JSONException -> Lb0
            if (r10 != 0) goto L92
            goto Lae
        L92:
            r10 = 0
        L93:
            int r11 = r6.length()     // Catch: org.json.JSONException -> Lb0
            if (r10 >= r11) goto La5
            java.lang.Object r11 = r6.get(r10)     // Catch: org.json.JSONException -> Lb0
            java.lang.String r11 = (java.lang.String) r11     // Catch: org.json.JSONException -> Lb0
            r9.add(r11)     // Catch: org.json.JSONException -> Lb0
            int r10 = r10 + 1
            goto L93
        La5:
            r8.a(r9)     // Catch: org.json.JSONException -> Lb0
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r6 = r12.b     // Catch: org.json.JSONException -> Lb0
            r6.add(r8)     // Catch: org.json.JSONException -> Lb0
            goto L3f
        Lae:
            return r3
        Laf:
            return r5
        Lb0:
            r13 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.w(r2, r0, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.b.c.b(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009b A[Catch: JSONException -> 0x0106, LOOP:2: B:33:0x0095->B:35:0x009b, LOOP_END, TryCatch #0 {JSONException -> 0x0106, blocks: (B:3:0x000a, B:5:0x0013, B:6:0x001b, B:8:0x0022, B:10:0x0038, B:12:0x0041, B:14:0x0047, B:16:0x0050, B:17:0x0054, B:19:0x005a, B:25:0x0075, B:30:0x0081, B:32:0x0086, B:33:0x0095, B:35:0x009b, B:36:0x00b3, B:23:0x006f, B:28:0x007c, B:37:0x00c8, B:39:0x00d3, B:43:0x00e2, B:47:0x00ec, B:49:0x00f3, B:50:0x00fa, B:40:0x00d8, B:42:0x00de, B:46:0x00e9), top: B:56:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3 A[Catch: JSONException -> 0x0106, TryCatch #0 {JSONException -> 0x0106, blocks: (B:3:0x000a, B:5:0x0013, B:6:0x001b, B:8:0x0022, B:10:0x0038, B:12:0x0041, B:14:0x0047, B:16:0x0050, B:17:0x0054, B:19:0x005a, B:25:0x0075, B:30:0x0081, B:32:0x0086, B:33:0x0095, B:35:0x009b, B:36:0x00b3, B:23:0x006f, B:28:0x007c, B:37:0x00c8, B:39:0x00d3, B:43:0x00e2, B:47:0x00ec, B:49:0x00f3, B:50:0x00fa, B:40:0x00d8, B:42:0x00de, B:46:0x00e9), top: B:56:0x000a }] */
    @Override // com.huawei.hms.framework.network.grs.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e(java.lang.String r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.b.c.e(java.lang.String):int");
    }
}
