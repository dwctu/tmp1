package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "a";
    private GrsBaseInfo b;
    private com.huawei.hms.framework.network.grs.a.a c;
    private m d;
    private com.huawei.hms.framework.network.grs.a.c e;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    public static class C0051a implements com.huawei.hms.framework.network.grs.b {
        public String a;
        public Map<String, String> b;
        public IQueryUrlsCallBack c;
        public Context d;
        public GrsBaseInfo e;
        public com.huawei.hms.framework.network.grs.a.a f;

        public C0051a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar) {
            this.a = str;
            this.b = map;
            this.c = iQueryUrlsCallBack;
            this.d = context;
            this.e = grsBaseInfo;
            this.f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.b;
            if (map != null && !map.isEmpty()) {
                this.c.onCallBackSuccess(this.b);
            } else {
                if (this.b != null) {
                    this.c.onCallBackFail(-3);
                    return;
                }
                Logger.i(a.a, "access local config for return a domain.");
                this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.b.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.c.f fVar) throws JSONException {
            Map<String, String> mapA = a.a(fVar.i(), this.a);
            if (mapA.isEmpty()) {
                Map<String, String> map = this.b;
                if (map != null && !map.isEmpty()) {
                    this.c.onCallBackSuccess(this.b);
                    return;
                } else if (this.b != null) {
                    this.c.onCallBackFail(-5);
                    return;
                } else {
                    Logger.i(a.a, "access local config for return a domain.");
                    mapA = com.huawei.hms.framework.network.grs.b.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true);
                }
            }
            this.c.onCallBackSuccess(mapA);
        }
    }

    public static class b implements com.huawei.hms.framework.network.grs.b {
        public String a;
        public String b;
        public IQueryUrlCallBack c;
        public String d;
        public Context e;
        public GrsBaseInfo f;
        public com.huawei.hms.framework.network.grs.a.a g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = iQueryUrlCallBack;
            this.d = str3;
            this.e = context;
            this.f = grsBaseInfo;
            this.g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.d)) {
                this.c.onCallBackSuccess(this.d);
            } else {
                if (!TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackFail(-3);
                    return;
                }
                Logger.i(a.a, "access local config for return a domain.");
                this.c.onCallBackSuccess(com.huawei.hms.framework.network.grs.b.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.c.f fVar) {
            String strA = a.a(fVar.i(), this.a, this.b);
            if (TextUtils.isEmpty(strA)) {
                if (!TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackSuccess(this.d);
                    return;
                } else if (!TextUtils.isEmpty(this.d)) {
                    this.c.onCallBackFail(-5);
                    return;
                } else {
                    Logger.i(a.a, "access local config for return a domain.");
                    strA = com.huawei.hms.framework.network.grs.b.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true);
                }
            }
            this.c.onCallBackSuccess(strA);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar, m mVar, com.huawei.hms.framework.network.grs.a.c cVar) {
        this.b = grsBaseInfo;
        this.c = aVar;
        this.d = mVar;
        this.e = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    private String a(String str, String str2, com.huawei.hms.framework.network.grs.a.b bVar, Context context) {
        String strA = this.c.a(this.b, str, str2, bVar, context);
        if (TextUtils.isEmpty(strA)) {
            return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.b).a(context, this.c, this.b, str, str2, false);
        }
        Logger.i(a, "get url from sp is not empty.");
        com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
        return strA;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).getJSONObject(str2).getString(str3);
        } catch (JSONException e) {
            Logger.w(a, "Method{getServiceNameUrl} query url from SP occur an JSONException", e);
            return "";
        }
    }

    public static Map<String, Map<String, String>> a(String str) {
        HashMap map = new HashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(a, "isSpExpire jsonValue is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, a(jSONObject.getJSONObject(string)));
            }
            return map;
        } catch (JSONException e) {
            Logger.w(a, "getServicesUrlsMap occur a JSONException", e);
            return map;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.a.b bVar, Context context) {
        Map<String, String> mapA = this.c.a(this.b, str, bVar, context);
        if (mapA == null || mapA.isEmpty()) {
            return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.b).a(context, this.c, this.b, str, false);
        }
        Logger.i(a, "get url from sp is not empty.");
        com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
        return mapA;
    }

    public static Map<String, String> a(String str, String str2) throws JSONException {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.v(a, "isSpExpire jsonValue is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(str2);
            if (jSONObject == null) {
                Logger.v(a, "getServiceNameUrls jsObject null.");
                return map;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, jSONObject.get(string).toString());
            }
            return map;
        } catch (JSONException e) {
            Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", e);
            return map;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap(16);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, jSONObject.get(string).toString());
            }
            return map;
        } catch (JSONException e) {
            Logger.w(a, "getServiceUrls occur a JSONException", e);
            return map;
        }
    }

    private void a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        this.d.a(new com.huawei.hms.framework.network.grs.c.b.c(this.b, context), new C0051a(str, map, iQueryUrlsCallBack, context, this.b, this.c), str, this.e);
    }

    public String a(Context context, String str) {
        com.huawei.hms.framework.network.grs.c.f fVarA = this.d.a(new com.huawei.hms.framework.network.grs.c.b.c(this.b, context), str, this.e);
        return fVarA == null ? "" : fVarA.i();
    }

    public String a(String str, String str2, Context context) {
        com.huawei.hms.framework.network.grs.a.b bVar = new com.huawei.hms.framework.network.grs.a.b();
        String strA = a(str, str2, bVar, context);
        if (bVar.a() && !TextUtils.isEmpty(strA)) {
            Logger.v(a, "get unexpired cache localUrl{%s}", strA);
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            return strA;
        }
        String strA2 = a(a(context, str), str, str2);
        if (!TextUtils.isEmpty(strA2)) {
            Logger.i(a, "get url is from remote server");
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            return strA2;
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        Logger.i(a, "access local config for return a domain.");
        return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.b).a(context, this.c, this.b, str, str2, true);
    }

    public Map<String, String> a(String str, Context context) throws JSONException {
        com.huawei.hms.framework.network.grs.a.b bVar = new com.huawei.hms.framework.network.grs.a.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (bVar.a() && mapA != null && !mapA.isEmpty()) {
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            return mapA;
        }
        Map<String, String> mapA2 = a(a(context, str), str);
        if (!mapA2.isEmpty()) {
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            return mapA2;
        }
        if (mapA == null || !mapA.isEmpty()) {
            return mapA;
        }
        Logger.i(a, "access local config for return a domain.");
        return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.b).a(context, this.c, this.b, str, true);
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        com.huawei.hms.framework.network.grs.a.b bVar = new com.huawei.hms.framework.network.grs.a.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (!bVar.a()) {
            a(str, mapA, iQueryUrlsCallBack, context);
        } else if (mapA == null || mapA.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        com.huawei.hms.framework.network.grs.a.b bVar = new com.huawei.hms.framework.network.grs.a.b();
        String strA = a(str, str2, bVar, context);
        if (!bVar.a()) {
            this.d.a(new com.huawei.hms.framework.network.grs.c.b.c(this.b, context), new b(str, str2, iQueryUrlCallBack, strA, context, this.b, this.c), str, this.e);
        } else if (TextUtils.isEmpty(strA)) {
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            com.huawei.hms.framework.network.grs.b.b.a(context, this.b);
            iQueryUrlCallBack.onCallBackSuccess(strA);
        }
    }
}
