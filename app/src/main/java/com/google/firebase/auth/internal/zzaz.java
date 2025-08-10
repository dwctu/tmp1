package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.broadcom.bt.util.io.FilenameUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p002firebaseauthapi.zzpz;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaz {
    private static final Logger zza = new Logger("JSONParser", new String[0]);

    @VisibleForTesting
    public static List zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objZzd = jSONArray.get(i);
            if (objZzd instanceof JSONArray) {
                objZzd = zza((JSONArray) objZzd);
            } else if (objZzd instanceof JSONObject) {
                objZzd = zzd((JSONObject) objZzd);
            }
            arrayList.add(objZzd);
        }
        return arrayList;
    }

    @NonNull
    public static Map zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List listZzd = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zzb(FilenameUtils.EXTENSION_SEPARATOR).zzd(str);
        if (listZzd.size() < 2) {
            zza.e("Invalid idToken ".concat(String.valueOf(str)), new Object[0]);
            return new HashMap();
        }
        try {
            Map mapZzc = zzc(new String(Base64Utils.decodeUrlSafeNoPadding((String) listZzd.get(1)), "UTF-8"));
            return mapZzc == null ? new HashMap() : mapZzc;
        } catch (UnsupportedEncodingException e) {
            zza.e("Unable to decode token", e, new Object[0]);
            return new HashMap();
        }
    }

    @Nullable
    public static Map zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzd(jSONObject);
            }
            return null;
        } catch (Exception e) {
            throw new zzpz(e);
        }
    }

    @VisibleForTesting
    public static Map zzd(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objZzd = jSONObject.get(next);
            if (objZzd instanceof JSONArray) {
                objZzd = zza((JSONArray) objZzd);
            } else if (objZzd instanceof JSONObject) {
                objZzd = zzd((JSONObject) objZzd);
            }
            arrayMap.put(next, objZzd);
        }
        return arrayMap;
    }
}
