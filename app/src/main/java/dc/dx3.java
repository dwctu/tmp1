package dc;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HasBinary.java */
/* loaded from: classes4.dex */
public class dx3 {
    public static final Logger a = Logger.getLogger(dx3.class.getName());

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    if (a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                        return true;
                    }
                } catch (JSONException e) {
                    a.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    if (a(jSONObject.get(itKeys.next()))) {
                        return true;
                    }
                } catch (JSONException e2) {
                    a.log(Level.WARNING, "An error occured while retrieving data from JSONObject", (Throwable) e2);
                }
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return a(obj);
    }
}
