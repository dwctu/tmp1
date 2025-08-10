package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzzd {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzzd zza(String str) throws UnsupportedEncodingException {
        try {
            zzzd zzzdVar = new zzzd();
            JSONObject jSONObject = new JSONObject(str);
            zzzdVar.zza = jSONObject.optString("iss");
            zzzdVar.zzb = jSONObject.optString("aud");
            zzzdVar.zzc = jSONObject.optString("sub");
            zzzdVar.zzd = Long.valueOf(jSONObject.optLong("iat"));
            zzzdVar.zze = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzzdVar;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                "Failed to read JwtToken from JSONObject. ".concat(e.toString());
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(e.toString()));
        }
    }

    public final Long zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzd;
    }
}
