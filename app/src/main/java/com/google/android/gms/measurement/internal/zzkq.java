package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzkq implements zzeq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzkz zzb;

    public zzkq(zzkz zzkzVar, String str) {
        this.zzb = zzkzVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzeq
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i, th, bArr, this.zza);
    }
}
