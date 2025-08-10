package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f {
    private static final String a = "f";
    private Map<String, List<String>> b;
    private byte[] c;
    private int d;
    private long e;
    private long f;
    private long g;
    private String h;
    private int i;
    private int j;
    private String k;
    private String l;
    private String m;
    private long n;
    private Exception o;
    private String p;
    private int q;

    public f(int i, Map<String, List<String>> map, byte[] bArr, long j) throws JSONException, NumberFormatException {
        this.d = 0;
        this.i = 2;
        this.j = 9001;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 0L;
        this.d = i;
        this.b = map;
        this.c = ByteBuffer.wrap(bArr).array();
        this.e = j;
        q();
    }

    public f(Exception exc, long j) {
        this.d = 0;
        this.i = 2;
        this.j = 9001;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 0L;
        this.o = exc;
        this.e = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.Map<java.lang.String, java.lang.String> r12) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.c.f.a(java.util.Map):void");
    }

    private void b(int i) {
        this.j = i;
    }

    private void b(String str) {
        this.m = str;
    }

    private void b(Map<String, String> map) throws NumberFormatException {
        if (map == null || map.size() <= 0) {
            Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        long j = 0;
        if (map.containsKey(HttpHeaders.RETRY_AFTER)) {
            String str = map.get(HttpHeaders.RETRY_AFTER);
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    Logger.w(a, "getRetryAfter addHeadersToResult NumberFormatException", e);
                }
            }
        }
        long j2 = j * 1000;
        Logger.v(a, "convert retry-afterTime{%s}", Long.valueOf(j2));
        c(j2);
    }

    private void c(int i) {
        this.i = i;
    }

    private void c(long j) {
        this.n = j;
    }

    private void c(String str) {
        this.k = str;
    }

    private void d(String str) {
        this.l = str;
    }

    private void e(String str) {
        this.h = str;
    }

    private void n() throws JSONException {
        String str = "isSuccess";
        if (!m()) {
            Logger.i(a, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            String strByte2Str = StringUtils.byte2Str(this.c);
            JSONObject jSONObject = new JSONObject(strByte2Str);
            int i = -1;
            if (jSONObject.has("isSuccess")) {
                i = jSONObject.getInt(str);
            } else if (jSONObject.has("resultCode")) {
                str = "resultCode";
                i = jSONObject.getInt(str);
            } else {
                Logger.e(a, "sth. wrong because server errorcode's key.");
            }
            c(i);
            boolean z = i == 0 && strByte2Str.contains("services");
            if (i != 1 && !z) {
                c(2);
                b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                c(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            } else {
                e(jSONObject.getJSONObject("services").toString());
                if (z) {
                    d(jSONObject.has("errorList") ? jSONObject.getString("errorList") : "");
                }
            }
        } catch (JSONException e) {
            Logger.w(a, "GrsResponse GrsResponse(String result) JSONException", e);
            c(2);
        }
    }

    private void o() throws NumberFormatException {
        if (m() || l()) {
            Map<String, String> mapP = p();
            try {
                if (m()) {
                    a(mapP);
                }
                if (l()) {
                    b(mapP);
                }
            } catch (JSONException e) {
                Logger.w(a, "parseHeader catch JSONException", e);
            }
        }
    }

    private Map<String, String> p() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.b;
        if (map2 == null || map2.size() <= 0) {
            Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.b.entrySet()) {
            map.put(entry.getKey(), entry.getValue().get(0));
        }
        return map;
    }

    private void q() throws JSONException, NumberFormatException {
        o();
        n();
    }

    public String a() {
        return this.m;
    }

    public void a(int i) {
        this.q = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(String str) {
        this.p = str;
    }

    public int b() {
        return this.d;
    }

    public void b(long j) {
        this.f = j;
    }

    public int c() {
        return this.j;
    }

    public Exception d() {
        return this.o;
    }

    public int e() {
        return this.i;
    }

    public long f() {
        return this.g;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public String i() {
        return this.h;
    }

    public long j() {
        return this.n;
    }

    public String k() {
        return this.p;
    }

    public boolean l() {
        return this.d == 503;
    }

    public boolean m() {
        return this.d == 200;
    }
}
