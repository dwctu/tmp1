package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzat implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzau zzb;

    public zzat(zzau zzauVar) {
        this.zzb = zzauVar;
        this.zza = zzauVar.zza.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.zza.next();
    }
}
