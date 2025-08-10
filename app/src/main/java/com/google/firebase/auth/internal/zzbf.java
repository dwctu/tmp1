package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.safetynet.SafetyNetApi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbf {
    private static final String zza = "zzbf";

    private zzbf() {
    }

    public static boolean zza(@NonNull SafetyNetApi.AttestationResponse attestationResponse) {
        zzbe zzbeVarZza;
        if (attestationResponse == null || TextUtils.isEmpty(attestationResponse.getJwsResult()) || (zzbeVarZza = zzbe.zza(attestationResponse.getJwsResult())) == null || !zzbeVarZza.zzc()) {
            return false;
        }
        if (TextUtils.isEmpty(zzbeVarZza.zzb())) {
            return true;
        }
        "SafetyNet Attestation has advice: \n".concat(String.valueOf(zzbeVarZza.zzb()));
        return false;
    }
}
