package org.jivesoftware.smack.util;

import android.text.TextUtils;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.util.WearUtils;
import dc.hu3;
import dc.nd3;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class JidTransformUtil {
    private static final String TAG = "org.jivesoftware.smack.util.JidTransformUtil";
    private static Map<String, String> jidMap = new HashMap();
    private static String x;
    private static String y;

    public static void setXY(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String string = new JSONObject(str).getString("ii");
            if (string.contains(Constants.FILENAME_SEQUENCE_SEPARATOR)) {
                String[] strArrSplit = string.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
                x = strArrSplit[0];
                y = strArrSplit[1];
            } else {
                String str2 = "Invalid format for xy: " + string;
            }
        } catch (JSONException e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public static String transform(String str, boolean z, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(x) || TextUtils.isEmpty(y) || i != 100) {
            return str;
        }
        if (str.contains("conference." + hu3.x().getServiceName()) || TextUtils.equals(str, hu3.x().getServiceName())) {
            return str;
        }
        if (str.contains("!!!") && str.contains("_w")) {
            return str;
        }
        if (!z) {
            if (str.contains(hu3.x().getServiceName())) {
                return str;
            }
            if (!jidMap.containsValue(str)) {
                String strB = nd3.b(str, x, y);
                jidMap.put(strB, str);
                return strB;
            }
            for (Map.Entry<String, String> entry : jidMap.entrySet()) {
                if (TextUtils.equals(str, entry.getValue())) {
                    return entry.getKey();
                }
            }
            return str;
        }
        if (!WearUtils.G2(WearUtils.X(str))) {
            return str;
        }
        if (jidMap.containsKey(str)) {
            String str2 = "encrypt====> data:" + str + ", encryptData:" + jidMap.get(str);
            return jidMap.get(str);
        }
        String strM = nd3.m(str, x, y);
        jidMap.put(str, strM);
        String str3 = "encrypt====> data:" + str + ", encryptData:" + strM;
        return strM;
    }
}
