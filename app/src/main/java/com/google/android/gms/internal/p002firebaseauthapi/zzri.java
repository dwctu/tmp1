package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "SendVerificationCodeAidlRequestCreator")
/* loaded from: classes2.dex */
public final class zzri extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzri> CREATOR = new zzrj();

    @SafeParcelable.Field(getter = "getSendVerificationCodeRequest", id = 1)
    private final zzzn zza;

    @SafeParcelable.Constructor
    public zzri(@SafeParcelable.Param(id = 1) zzzn zzznVar) {
        this.zza = zzznVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzzn zza() {
        return this.zza;
    }
}
