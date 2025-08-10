package com.google.android.gms.internal.p002firebaseauthapi;

import com.broadcom.bt.util.io.FilenameUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzzc {
    public static long zza(String str) {
        Preconditions.checkNotEmpty(str);
        List listZzd = zzaf.zzb(FilenameUtils.EXTENSION_SEPARATOR).zzd(str);
        if (listZzd.size() < 2) {
            throw new RuntimeException("Invalid idToken ".concat(String.valueOf(str)));
        }
        try {
            zzzd zzzdVarZza = zzzd.zza(new String(Base64Utils.decodeUrlSafeNoPadding((String) listZzd.get(1)), "UTF-8"));
            return zzzdVarZza.zzb().longValue() - zzzdVarZza.zzc().longValue();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
