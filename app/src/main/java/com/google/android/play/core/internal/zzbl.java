package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzbl implements zzaz {
    @Override // com.google.android.play.core.internal.zzaz
    public final void zza(ClassLoader classLoader, Set set) {
        zzbk.zzc(classLoader, set, new zzbi());
    }

    @Override // com.google.android.play.core.internal.zzaz
    public final boolean zzb(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzbk.zzd(classLoader, file, file2, z, "zip");
    }
}
