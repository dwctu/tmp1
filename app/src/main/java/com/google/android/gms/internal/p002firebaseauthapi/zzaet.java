package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaet implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzaeu zzb;

    public zzaet(zzaeu zzaeuVar) {
        this.zzb = zzaeuVar;
        this.zza = zzaeuVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
