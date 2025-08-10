package com.huawei.agconnect.config.a;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d implements b {
    private final JSONObject a;

    public d(InputStream inputStream) {
        this.a = a(inputStream);
    }

    private JSONObject a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new JSONObject(h.a(inputStream, "UTF-8"));
            } catch (IOException | JSONException unused) {
            }
        }
        return new JSONObject();
    }

    @Override // com.huawei.agconnect.config.a.b
    public String a(String str, String str2) throws JSONException {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] strArrSplit = str.split("/");
        try {
            JSONObject jSONObject = this.a;
            for (int i = 1; i < strArrSplit.length; i++) {
                if (i == strArrSplit.length - 1) {
                    str = jSONObject.get(strArrSplit[i]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(strArrSplit[i]);
            }
        } catch (JSONException unused) {
            String str3 = "JSONException when reading 'path': " + str;
        }
        return str2;
    }
}
