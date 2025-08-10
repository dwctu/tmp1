package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
/* loaded from: classes2.dex */
public final class zzr implements AuthResult {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    @NonNull
    @SafeParcelable.Field(getter = "getUser", id = 1)
    private zzx zza;

    @Nullable
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", id = 2)
    private zzp zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getOAuthCredential", id = 3)
    private com.google.firebase.auth.zze zzc;

    public zzr(zzx zzxVar) {
        zzx zzxVar2 = (zzx) Preconditions.checkNotNull(zzxVar);
        this.zza = zzxVar2;
        List listZzo = zzxVar2.zzo();
        this.zzb = null;
        for (int i = 0; i < listZzo.size(); i++) {
            if (!TextUtils.isEmpty(((zzt) listZzo.get(i)).zza())) {
                this.zzb = new zzp(((zzt) listZzo.get(i)).getProviderId(), ((zzt) listZzo.get(i)).zza(), zzxVar.zzs());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzp(zzxVar.zzs());
        }
        this.zzc = zzxVar.zzj();
    }

    @SafeParcelable.Constructor
    public zzr(@NonNull @SafeParcelable.Param(id = 1) zzx zzxVar, @Nullable @SafeParcelable.Param(id = 2) zzp zzpVar, @Nullable @SafeParcelable.Param(id = 3) com.google.firebase.auth.zze zzeVar) {
        this.zza = zzxVar;
        this.zzb = zzpVar;
        this.zzc = zzeVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
