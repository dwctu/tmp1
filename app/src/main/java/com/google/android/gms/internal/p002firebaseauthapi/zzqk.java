package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "CreateUserWithEmailAndPasswordAidlRequestCreator")
/* loaded from: classes2.dex */
public final class zzqk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqk> CREATOR = new zzql();

    @SafeParcelable.Field(getter = "getEmail", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getPassword", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", id = 3)
    private final String zzc;

    @SafeParcelable.Constructor
    public zzqk(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }
}
