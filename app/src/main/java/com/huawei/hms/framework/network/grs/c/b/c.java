package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c {
    private GrsBaseInfo a;
    private Context b;
    private Set<String> c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.a = grsBaseInfo;
        this.b = context;
    }

    private String e() throws JSONException {
        Set<String> setB = com.huawei.hms.framework.network.grs.b.b.a(this.b.getPackageName(), this.a).b();
        if (setB.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = setB.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() throws JSONException {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.b;
    }

    public void a(String str) {
        this.c.add(str);
    }

    public GrsBaseInfo b() {
        return this.a;
    }

    public String c() {
        return this.c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.c;
    }
}
