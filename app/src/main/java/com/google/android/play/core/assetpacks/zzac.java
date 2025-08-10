package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzac extends com.google.android.play.core.internal.zzah {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Map zzb;
    public final /* synthetic */ com.google.android.play.core.tasks.zzi zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzaw zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzaw zzawVar, com.google.android.play.core.tasks.zzi zziVar, List list, Map map, com.google.android.play.core.tasks.zzi zziVar2, List list2) {
        super(zziVar);
        this.zze = zzawVar;
        this.zza = list;
        this.zzb = map;
        this.zzc = zziVar2;
        this.zzd = list2;
    }

    @Override // com.google.android.play.core.internal.zzah
    public final void zza() {
        ArrayList arrayListZzv = zzaw.zzv(this.zza);
        try {
            com.google.android.play.core.internal.zzu zzuVar = (com.google.android.play.core.internal.zzu) this.zze.zzf.zze();
            String str = this.zze.zzc;
            Bundle bundleZzn = zzaw.zzn(this.zzb);
            zzaw zzawVar = this.zze;
            zzuVar.zzl(str, arrayListZzv, bundleZzn, new zzav(zzawVar, this.zzc, zzawVar.zzd, zzawVar.zze, this.zzd));
        } catch (RemoteException e) {
            zzaw.zza.zzc(e, "startDownload(%s)", this.zza);
            this.zzc.zzd(new RuntimeException(e));
        }
    }
}
