package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "PhoneAuthCredentialCreator")
/* loaded from: classes2.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {

    @NonNull
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzae();

    @Nullable
    @SafeParcelable.Field(getter = "getSessionInfo", id = 1)
    private String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getSmsCode", id = 2)
    private String zzb;

    @SafeParcelable.Field(getter = "getHasVerificationProof", id = 3)
    private boolean zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "getAutoCreate", id = 5)
    private boolean zze;

    @Nullable
    @SafeParcelable.Field(getter = "getTemporaryProof", id = 6)
    private String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getMfaEnrollmentId", id = 7)
    private String zzg;

    @SafeParcelable.Constructor
    public PhoneAuthCredential(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z, @Nullable @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) boolean z2, @Nullable @SafeParcelable.Param(id = 6) String str4, @Nullable @SafeParcelable.Param(id = 7) String str5) {
        boolean z3 = false;
        if ((z && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) || ((z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) || ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4))))) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = z2;
        this.zzf = str4;
        this.zzg = str5;
    }

    @NonNull
    public static PhoneAuthCredential zzc(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential(str, str2, false, null, true, null, null);
    }

    @NonNull
    public static PhoneAuthCredential zzd(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential(null, null, false, str, true, str2, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getSignInMethod() {
        return "phone";
    }

    @Nullable
    public String getSmsCode() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public final AuthCredential zza() {
        return clone();
    }

    @NonNull
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final PhoneAuthCredential clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    @NonNull
    public final PhoneAuthCredential zze(boolean z) {
        this.zze = false;
        return this;
    }

    @Nullable
    public final String zzf() {
        return this.zzd;
    }

    @Nullable
    public final String zzg() {
        return this.zza;
    }

    @Nullable
    public final String zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zze;
    }
}
