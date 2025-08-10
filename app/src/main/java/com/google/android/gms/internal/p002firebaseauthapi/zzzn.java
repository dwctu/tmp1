package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "SendVerificationCodeRequestCreator")
/* loaded from: classes2.dex */
public final class zzzn extends AbstractSafeParcelable implements zzwo {
    public static final Parcelable.Creator<zzzn> CREATOR = new zzzo();

    @SafeParcelable.Field(getter = "getPhoneNumber", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getTimeoutInSeconds", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getForceNewSmsVerificationSession", id = 3)
    private final boolean zzc;

    @SafeParcelable.Field(getter = "getLanguageHeader", id = 4)
    private final String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", id = 5)
    private final String zze;

    @Nullable
    @SafeParcelable.Field(getter = "getRecaptchaToken", id = 6)
    private final String zzf;

    @SafeParcelable.Field(getter = "getIsGooglePlayServicesAvailable", id = 7)
    private final boolean zzg;

    @SafeParcelable.Field(getter = "getSafetyNetToken", id = 8)
    private final String zzh;

    @Nullable
    private zzyc zzi;

    @SafeParcelable.Constructor
    public zzzn(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str2, @Nullable @SafeParcelable.Param(id = 5) String str3, @Nullable @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) boolean z2, @Nullable @SafeParcelable.Param(id = 8) String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = j;
        this.zzc = z;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = str4;
        this.zzg = z2;
        this.zzh = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwo
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.zza);
        String str = this.zze;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            jSONObject.put("recaptchaToken", str2);
        }
        zzyc zzycVar = this.zzi;
        if (zzycVar != null) {
            jSONObject.put("autoRetrievalInfo", zzycVar.zza());
        }
        String str3 = this.zzh;
        if (str3 != null) {
            jSONObject.put("safetyNetToken", str3);
        }
        return jSONObject.toString();
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final void zze(zzyc zzycVar) {
        this.zzi = zzycVar;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return this.zzg;
    }
}
