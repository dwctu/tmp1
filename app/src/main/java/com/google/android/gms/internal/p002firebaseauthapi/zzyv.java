package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "GetAccountInfoUserListCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzyv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyv> CREATOR = new zzyw();

    @SafeParcelable.Field(getter = "getUsers", id = 2)
    private final List zza;

    public zzyv() {
        this.zza = new ArrayList();
    }

    public static zzyv zza(zzyv zzyvVar) {
        Preconditions.checkNotNull(zzyvVar);
        List list = zzyvVar.zza;
        zzyv zzyvVar2 = new zzyv();
        if (list != null && !list.isEmpty()) {
            zzyvVar2.zza.addAll(list);
        }
        return zzyvVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final List zzb() {
        return this.zza;
    }

    @SafeParcelable.Constructor
    public zzyv(@SafeParcelable.Param(id = 2) List list) {
        List listUnmodifiableList;
        if (list == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list);
        }
        this.zza = listUnmodifiableList;
    }
}
