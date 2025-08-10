package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.b.d;
import com.huawei.hms.framework.network.grs.d.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "a";
    private static d b;

    public static synchronized d a(Context context) {
        d dVar = b;
        if (dVar != null) {
            return dVar;
        }
        String strA = c.a("grs_sdk_server_config.json", context);
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA).getJSONObject("grs_server");
            JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
            if (jSONArray != null && jSONArray.length() > 0) {
                arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.get(i).toString());
                }
            }
            d dVar2 = new d();
            b = dVar2;
            dVar2.a(arrayList);
            b.b(jSONObject.getString("grs_query_endpoint_1.0"));
            b.a(jSONObject.getString("grs_query_endpoint_2.0"));
            b.a(jSONObject.getInt("grs_query_timeout"));
        } catch (JSONException e) {
            Logger.w(a, "getGrsServerBean catch JSONException", e);
        }
        return b;
    }
}
