package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzeb {
    private static final com.google.android.play.core.internal.zzag zza = new com.google.android.play.core.internal.zzag("PackMetadataManager");
    private final zzbh zzb;
    private final zzed zzc;
    private final com.google.android.play.core.common.zza zzd;

    public zzeb(zzbh zzbhVar, zzed zzedVar, com.google.android.play.core.common.zza zzaVar) {
        this.zzb = zzbhVar;
        this.zzc = zzedVar;
        this.zzd = zzaVar;
    }

    public final String zza(String str) throws IOException {
        if (this.zzd.zza("assetOnlyUpdates") && this.zzb.zzG(str)) {
            int iZza = this.zzc.zza();
            zzbh zzbhVar = this.zzb;
            File fileZzk = zzbhVar.zzk(str, iZza, zzbhVar.zzc(str));
            try {
                if (!fileZzk.exists()) {
                    return String.valueOf(iZza);
                }
                FileInputStream fileInputStream = new FileInputStream(fileZzk);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    String property = properties.getProperty("moduleVersionTag");
                    return property == null ? String.valueOf(iZza) : property;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                zza.zzb("Failed to read pack version tag for pack %s", str);
            }
        }
        return "";
    }

    public final void zzb(String str, int i, long j, @Nullable String str2) throws IOException {
        if (str2 == null || str2.isEmpty()) {
            str2 = String.valueOf(i);
        }
        Properties properties = new Properties();
        properties.put("moduleVersionTag", str2);
        File fileZzk = this.zzb.zzk(str, i, j);
        fileZzk.getParentFile().mkdirs();
        fileZzk.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(fileZzk);
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
