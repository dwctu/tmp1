package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaav extends zzaax {
    public final /* synthetic */ zzabe zza;
    private int zzb = 0;
    private final int zzc;

    public zzaav(zzabe zzabeVar) {
        this.zza = zzabeVar;
        this.zzc = zzabeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaz
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
