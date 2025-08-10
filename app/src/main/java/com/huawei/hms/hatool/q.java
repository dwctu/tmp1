package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class q implements s {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put(JivePropertiesExtension.ELEMENT, new JSONObject(this.c));
        return jSONObject;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("event");
        this.c = jSONObject.optString(JivePropertiesExtension.ELEMENT);
        this.c = d.a(this.c, d0.f().a());
        this.a = jSONObject.optString("type");
        this.d = jSONObject.optString("eventtime");
        this.e = jSONObject.optString("event_session_name");
        this.f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.d = str;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObjectA = a();
        jSONObjectA.put(JivePropertiesExtension.ELEMENT, d.b(this.c, d0.f().a()));
        return jSONObjectA;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.e = str;
    }
}
