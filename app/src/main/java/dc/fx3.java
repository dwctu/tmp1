package dc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Binary.java */
/* loaded from: classes4.dex */
public class fx3 {
    public static final Logger a = Logger.getLogger(fx3.class.getName());

    /* compiled from: Binary.java */
    public static class a {
        public hx3 a;
        public byte[][] b;
    }

    public static Object a(Object obj, List<byte[]> list) throws JSONException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e) {
                a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e);
                return null;
            }
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                } catch (JSONException e2) {
                    a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
            return jSONArray;
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, a(jSONObject3.get(next), list));
            } catch (JSONException e3) {
                a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e3);
                return null;
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject] */
    public static Object b(Object obj, byte[][] bArr) throws JSONException {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, b(jSONArray.get(i), bArr));
                } catch (JSONException e) {
                    a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int iOptInt = obj.optInt("num", -1);
                if (iOptInt < 0 || iOptInt >= bArr.length) {
                    return null;
                }
                return bArr[iOptInt];
            }
            Iterator<String> itKeys = obj.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    obj.put(next, b(obj.get(next), bArr));
                } catch (JSONException e2) {
                    a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
        }
        return obj;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static a c(hx3 hx3Var) {
        ArrayList arrayList = new ArrayList();
        hx3Var.d = a(hx3Var.d, arrayList);
        hx3Var.e = arrayList.size();
        a aVar = new a();
        aVar.a = hx3Var;
        aVar.b = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return aVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static hx3 d(hx3 hx3Var, byte[][] bArr) {
        hx3Var.d = b(hx3Var.d, bArr);
        hx3Var.e = -1;
        return hx3Var;
    }
}
