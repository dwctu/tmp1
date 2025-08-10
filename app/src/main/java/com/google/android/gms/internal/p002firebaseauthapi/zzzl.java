package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "ResetPasswordResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzzl extends AbstractSafeParcelable implements zzwp<zzzl> {

    @SafeParcelable.Field(getter = "getEmail", id = 2)
    private String zzb;

    @SafeParcelable.Field(getter = "getNewEmail", id = 3)
    private String zzc;

    @SafeParcelable.Field(getter = "getRequestType", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "getMfaInfo", id = 5)
    private zzze zze;
    private static final String zza = zzzl.class.getSimpleName();
    public static final Parcelable.Creator<zzzl> CREATOR = new zzzm();

    public zzzl() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.p002firebaseauthapi.zzwp zza(java.lang.String r17) throws com.google.android.gms.internal.p002firebaseauthapi.zzui {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "mfaInfo"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            r3.<init>(r2)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r4 = "email"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            r1.zzb = r4     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r4 = "newEmail"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            r1.zzc = r4     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r4 = "reqType"
            int r4 = r3.optInt(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            java.lang.String r6 = "REVERT_SECOND_FACTOR_ADDITION"
            java.lang.String r7 = "VERIFY_AND_CHANGE_EMAIL"
            java.lang.String r8 = "EMAIL_SIGNIN"
            java.lang.String r9 = "RECOVER_EMAIL"
            java.lang.String r10 = "VERIFY_EMAIL"
            java.lang.String r11 = "PASSWORD_RESET"
            r12 = 1
            if (r4 == r12) goto L47
            switch(r4) {
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L3f;
                case 8: goto L3d;
                default: goto L3b;
            }
        L3b:
            r4 = 0
            goto L48
        L3d:
            r4 = r6
            goto L48
        L3f:
            r4 = r7
            goto L48
        L41:
            r4 = r8
            goto L48
        L43:
            r4 = r9
            goto L48
        L45:
            r4 = r10
            goto L48
        L47:
            r4 = r11
        L48:
            r1.zzd = r4     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            if (r4 == 0) goto La4
            java.lang.String r4 = "requestType"
            java.lang.String r4 = r3.optString(r4)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            int r13 = r4.hashCode()     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            r15 = 4
            r5 = 3
            r14 = 2
            switch(r13) {
                case -1874510116: goto L89;
                case -1452371317: goto L81;
                case -1341836234: goto L79;
                case -1099157829: goto L71;
                case 870738373: goto L69;
                case 970484929: goto L61;
                default: goto L60;
            }
        L60:
            goto L91
        L61:
            boolean r6 = r4.equals(r9)
            if (r6 == 0) goto L91
            r6 = 4
            goto L92
        L69:
            boolean r6 = r4.equals(r8)
            if (r6 == 0) goto L91
            r6 = 2
            goto L92
        L71:
            boolean r6 = r4.equals(r7)
            if (r6 == 0) goto L91
            r6 = 3
            goto L92
        L79:
            boolean r6 = r4.equals(r10)
            if (r6 == 0) goto L91
            r6 = 0
            goto L92
        L81:
            boolean r6 = r4.equals(r11)
            if (r6 == 0) goto L91
            r6 = 1
            goto L92
        L89:
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L91
            r6 = 5
            goto L92
        L91:
            r6 = -1
        L92:
            if (r6 == 0) goto La1
            if (r6 == r12) goto La1
            if (r6 == r14) goto La1
            if (r6 == r5) goto La1
            if (r6 == r15) goto La1
            r5 = 5
            if (r6 == r5) goto La1
            r5 = 0
            goto La2
        La1:
            r5 = r4
        La2:
            r1.zzd = r5     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
        La4:
            boolean r4 = r3.has(r0)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            if (r4 == 0) goto Lb4
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            com.google.android.gms.internal.firebase-auth-api.zzze r0 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzb(r0)     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
            r1.zze = r0     // Catch: java.lang.NullPointerException -> Lb5 org.json.JSONException -> Lb7
        Lb4:
            return r1
        Lb5:
            r0 = move-exception
            goto Lb8
        Lb7:
            r0 = move-exception
        Lb8:
            java.lang.String r3 = com.google.android.gms.internal.p002firebaseauthapi.zzzl.zza
            com.google.android.gms.internal.firebase-auth-api.zzui r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaam.zza(r0, r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzzl.zza(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzwp");
    }

    @Nullable
    public final zzze zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zzb != null;
    }

    public final boolean zzg() {
        return this.zze != null;
    }

    public final boolean zzh() {
        return this.zzc != null;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    @SafeParcelable.Constructor
    public zzzl(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) zzze zzzeVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzzeVar;
    }
}
