package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzhx {
    public final String zza;
    public final Uri zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final zzie zzi;

    public zzhx(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzhx(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzie zzieVar) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z;
        this.zzf = false;
        this.zzg = z3;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzhx zza() {
        return new zzhx(null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, null);
    }

    public final zzhx zzb() {
        if (this.zzc.isEmpty()) {
            return new zzhx(null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzia zzc(String str, double d) {
        return new zzhv(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzia zzd(String str, long j) {
        return new zzht(this, str, Long.valueOf(j), true);
    }

    public final zzia zze(String str, String str2) {
        return new zzhw(this, str, str2, true);
    }

    public final zzia zzf(String str, boolean z) {
        return new zzhu(this, str, Boolean.valueOf(z), true);
    }
}
