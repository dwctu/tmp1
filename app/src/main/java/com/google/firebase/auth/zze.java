package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaaa;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
/* loaded from: classes2.dex */
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    @SafeParcelable.Field(getter = "getProvider", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getWebSignInCredential", id = 4)
    private final zzaaa zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getPendingToken", id = 5)
    private final String zze;

    @Nullable
    @SafeParcelable.Field(getter = "getSecret", id = 6)
    private final String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getRawNonce", id = 7)
    private final String zzg;

    @SafeParcelable.Constructor
    public zze(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) zzaaa zzaaaVar, @Nullable @SafeParcelable.Param(id = 5) String str4, @Nullable @SafeParcelable.Param(id = 6) String str5, @Nullable @SafeParcelable.Param(id = 7) String str6) {
        this.zza = com.google.android.gms.internal.p002firebaseauthapi.zzag.zzc(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaaaVar;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zze zzb(zzaaa zzaaaVar) {
        Preconditions.checkNotNull(zzaaaVar, "Must specify a non-null webSignInCredential");
        return new zze(null, null, null, zzaaaVar, null, null, null);
    }

    public static zze zzc(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zze(str, str2, str3, null, str4, str5, null);
    }

    public static zzaaa zzd(zze zzeVar, @Nullable String str) {
        Preconditions.checkNotNull(zzeVar);
        zzaaa zzaaaVar = zzeVar.zzd;
        return zzaaaVar != null ? zzaaaVar : new zzaaa(zzeVar.zzb, zzeVar.zzc, zzeVar.zza, null, zzeVar.zzf, null, str, zzeVar.zze, zzeVar.zzg);
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getSecret() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getSignInMethod() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zze(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
