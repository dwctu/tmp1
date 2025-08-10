package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "LinkFederatedCredentialAidlRequestCreator")
/* loaded from: classes2.dex */
public final class zzqy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqy> CREATOR = new zzqz();

    @SafeParcelable.Field(getter = "getCachedState", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getVerifyAssertionRequest", id = 2)
    private final zzaaa zzb;

    @SafeParcelable.Constructor
    public zzqy(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) zzaaa zzaaaVar) {
        this.zza = str;
        this.zzb = zzaaaVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzaaa zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
