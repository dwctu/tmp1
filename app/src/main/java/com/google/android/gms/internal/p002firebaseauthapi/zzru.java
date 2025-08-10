package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.EmailAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "SignInWithEmailLinkAidlRequestCreator")
/* loaded from: classes2.dex */
public final class zzru extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzru> CREATOR = new zzrv();

    @SafeParcelable.Field(getter = "getCredential", id = 1)
    private final EmailAuthCredential zza;

    @SafeParcelable.Constructor
    public zzru(@SafeParcelable.Param(id = 1) EmailAuthCredential emailAuthCredential) {
        this.zza = emailAuthCredential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final EmailAuthCredential zza() {
        return this.zza;
    }
}
