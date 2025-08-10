package com.google.firebase.auth;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class ActionCodeUrl {
    private static final Map zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    @Nullable
    private final String zze;

    @Nullable
    private final String zzf;

    @Nullable
    private final String zzg;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        zza = Collections.unmodifiableMap(map);
    }

    private ActionCodeUrl(String str) {
        String strZzb = zzb(str, "apiKey");
        String strZzb2 = zzb(str, "oobCode");
        String strZzb3 = zzb(str, "mode");
        if (strZzb == null || strZzb2 == null || strZzb3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.zzb = Preconditions.checkNotEmpty(strZzb);
        this.zzc = Preconditions.checkNotEmpty(strZzb2);
        this.zzd = Preconditions.checkNotEmpty(strZzb3);
        this.zze = zzb(str, "continueUrl");
        this.zzf = zzb(str, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.zzg = zzb(str, "tenantId");
    }

    @Nullable
    public static ActionCodeUrl parseLink(@Nullable String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    private static String zzb(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(Preconditions.checkNotEmpty(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    @NonNull
    public String getApiKey() {
        return this.zzb;
    }

    @Nullable
    public String getCode() {
        return this.zzc;
    }

    @Nullable
    public String getContinueUrl() {
        return this.zze;
    }

    @Nullable
    public String getLanguageCode() {
        return this.zzf;
    }

    public int getOperation() {
        Map map = zza;
        if (map.containsKey(this.zzd)) {
            return ((Integer) map.get(this.zzd)).intValue();
        }
        return 3;
    }

    @Nullable
    public final String zza() {
        return this.zzg;
    }
}
