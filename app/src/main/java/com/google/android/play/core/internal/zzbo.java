package com.google.android.play.core.internal;

import java.io.File;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzbo implements zzbd {
    @Override // com.google.android.play.core.internal.zzbd
    public final boolean zza(Object obj, File file, File file2) {
        try {
            return !((Boolean) zzbw.zzf(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
