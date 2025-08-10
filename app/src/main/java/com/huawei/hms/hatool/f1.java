package com.huawei.hms.hatool;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f1 extends o {
    public String g = "";

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.d);
        jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.appid, this.a);
        jSONObject.put("hmac", this.g);
        jSONObject.put("chifer", this.f);
        jSONObject.put("timestamp", this.b);
        jSONObject.put("servicetag", this.c);
        jSONObject.put("requestid", this.e);
        return jSONObject;
    }

    public void g(String str) {
        this.g = str;
    }
}
