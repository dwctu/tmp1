package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzbp extends zzbm implements zzbr {
    public zzbp(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbr
    public final Bundle zzd(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, bundle);
        Parcel parcelZzb = zzb(1, parcelZza);
        Bundle bundle2 = (Bundle) zzbo.zza(parcelZzb, Bundle.CREATOR);
        parcelZzb.recycle();
        return bundle2;
    }
}
