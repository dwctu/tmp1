package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzact extends zzaap implements RandomAccess, zzacu {
    public static final zzacu zza;
    private static final zzact zzb;
    private final List zzc;

    static {
        zzact zzactVar = new zzact(10);
        zzb = zzactVar;
        zzactVar.zzb();
        zza = zzactVar;
    }

    public zzact() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzabe ? ((zzabe) obj).zzr(zzacn.zzb) : zzacn.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzacu) {
            collection = ((zzacu) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacm
    public final /* bridge */ /* synthetic */ zzacm zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzact(arrayList);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacu
    public final zzacu zze() {
        return zzc() ? new zzaeu(this) : this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacu
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzabe) {
            zzabe zzabeVar = (zzabe) obj;
            String strZzr = zzabeVar.zzr(zzacn.zzb);
            if (zzabeVar.zzk()) {
                this.zzc.set(i, strZzr);
            }
            return strZzr;
        }
        byte[] bArr = (byte[]) obj;
        String strZzh = zzacn.zzh(bArr);
        if (zzacn.zzi(bArr)) {
            this.zzc.set(i, strZzh);
        }
        return strZzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacu
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacu
    public final void zzi(zzabe zzabeVar) {
        zza();
        this.zzc.add(zzabeVar);
        ((AbstractList) this).modCount++;
    }

    public zzact(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzact(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
