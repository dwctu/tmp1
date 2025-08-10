package dc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
public final class ae0 {
    public static String a(String str) {
        return b(str, 4);
    }

    public static String b(String str, int i) {
        try {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '{') {
                    return new JSONObject(str).toString(i);
                }
                if (cCharAt == '[') {
                    return new JSONArray(str).toString(i);
                }
                if (!Character.isWhitespace(cCharAt)) {
                    return str;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }
}
