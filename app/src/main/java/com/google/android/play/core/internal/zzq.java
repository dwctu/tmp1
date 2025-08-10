package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public abstract class zzq extends zzl implements zzr {
    public zzq() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.internal.zzl
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzc((Bundle) zzm.zza(parcel, Bundle.CREATOR));
            return true;
        }
        if (i != 3) {
            return false;
        }
        zzb((Bundle) zzm.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
