package com.google.firebase.database.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public class JsonMapper {
    public static Map<String, Object> parseJson(String str) throws IOException {
        try {
            return unwrapJsonObject(new JSONObject(str));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static Object parseJsonValue(String str) throws IOException {
        try {
            return unwrapJson(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static String serializeJson(Map<String, Object> map) throws IOException {
        return serializeJsonValue(map);
    }

    public static String serializeJsonValue(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e) {
                throw new IOException("Could not serialize number", e);
            }
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            serializeJsonValue(obj, jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException e2) {
            throw new IOException("Failed to serialize JSON", e2);
        }
    }

    private static Object unwrapJson(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            return unwrapJsonObject((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return unwrapJsonArray((JSONArray) obj);
        }
        if (obj.equals(JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    private static List<Object> unwrapJsonArray(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(unwrapJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Map<String, Object> unwrapJsonObject(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, unwrapJson(jSONObject.get(next)));
        }
        return map;
    }

    private static void serializeJsonValue(Object obj, JSONStringer jSONStringer) throws JSONException, IOException {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                serializeJsonValue(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
            return;
        }
        if (obj instanceof Collection) {
            jSONStringer.array();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                serializeJsonValue(it.next(), jSONStringer);
            }
            jSONStringer.endArray();
            return;
        }
        jSONStringer.value(obj);
    }
}
