package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p002firebaseauthapi.zzpz;
import com.google.android.gms.internal.p002firebaseauthapi.zzyt;
import com.google.android.gms.internal.p002firebaseauthapi.zzzg;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "DefaultAuthUserInfoCreator")
/* loaded from: classes2.dex */
public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    @NonNull
    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final String zza;

    @NonNull
    @SafeParcelable.Field(getter = "getProviderId", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getPhotoUrlString", id = 4)
    private String zzd;

    @Nullable
    private Uri zze;

    @Nullable
    @SafeParcelable.Field(getter = "getEmail", id = 5)
    private final String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 6)
    private final String zzg;

    @SafeParcelable.Field(getter = "isEmailVerified", id = 7)
    private final boolean zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 8)
    private final String zzi;

    public zzt(zzyt zzytVar, String str) {
        Preconditions.checkNotNull(zzytVar);
        Preconditions.checkNotEmpty("firebase");
        this.zza = Preconditions.checkNotEmpty(zzytVar.zzo());
        this.zzb = "firebase";
        this.zzf = zzytVar.zzn();
        this.zzc = zzytVar.zzm();
        Uri uriZzc = zzytVar.zzc();
        if (uriZzc != null) {
            this.zzd = uriZzc.toString();
            this.zze = uriZzc;
        }
        this.zzh = zzytVar.zzs();
        this.zzi = null;
        this.zzg = zzytVar.zzp();
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    @NonNull
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    @NonNull
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzh);
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.zzi;
    }

    @Nullable
    public final String zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new zzpz(e);
        }
    }

    public zzt(zzzg zzzgVar) {
        Preconditions.checkNotNull(zzzgVar);
        this.zza = zzzgVar.zzd();
        this.zzb = Preconditions.checkNotEmpty(zzzgVar.zzf());
        this.zzc = zzzgVar.zzb();
        Uri uriZza = zzzgVar.zza();
        if (uriZza != null) {
            this.zzd = uriZza.toString();
            this.zze = uriZza;
        }
        this.zzf = zzzgVar.zzc();
        this.zzg = zzzgVar.zze();
        this.zzh = false;
        this.zzi = zzzgVar.zzg();
    }

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzt(@NonNull @SafeParcelable.Param(id = 1) String str, @NonNull @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 5) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 3) String str5, @Nullable @SafeParcelable.Param(id = 6) String str6, @SafeParcelable.Param(id = 7) boolean z, @Nullable @SafeParcelable.Param(id = 8) String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }
}
