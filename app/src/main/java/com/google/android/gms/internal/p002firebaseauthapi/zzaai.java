package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaai implements zzwo {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzaai() {
    }

    public static zzaai zzb(String str, String str2, boolean z) {
        zzaai zzaaiVar = new zzaai();
        zzaaiVar.zzb = Preconditions.checkNotEmpty(str);
        zzaaiVar.zzc = Preconditions.checkNotEmpty(str2);
        zzaaiVar.zzf = z;
        return zzaaiVar;
    }

    public static zzaai zzc(String str, String str2, boolean z) {
        zzaai zzaaiVar = new zzaai();
        zzaaiVar.zza = Preconditions.checkNotEmpty(str);
        zzaaiVar.zzd = Preconditions.checkNotEmpty(str2);
        zzaaiVar.zzf = z;
        return zzaaiVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwo
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put(XHTMLText.CODE, this.zzc);
        } else {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
