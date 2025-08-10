package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaaw implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzabe zzabeVar = (zzabe) obj;
        zzabe zzabeVar2 = (zzabe) obj2;
        zzaav zzaavVar = new zzaav(zzabeVar);
        zzaav zzaavVar2 = new zzaav(zzabeVar2);
        while (zzaavVar.hasNext() && zzaavVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzaavVar.zza() & 255).compareTo(Integer.valueOf(zzaavVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzabeVar.zzd()).compareTo(Integer.valueOf(zzabeVar2.zzd()));
    }
}
