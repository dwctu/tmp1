package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.crypto.KeyGenerator;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfl {
    private zzbi zze;
    private zzfq zzf = null;
    private zzbj zza = null;
    private String zzb = null;
    private zzap zzc = null;
    private zzbf zzd = null;

    private final zzap zzh() throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT < 23) {
            String unused = zzfn.zzb;
            return null;
        }
        zzfp zzfpVar = new zzfp();
        boolean zZzc = zzfpVar.zzc(this.zzb);
        if (!zZzc) {
            try {
                String str = this.zzb;
                if (new zzfp().zzc(str)) {
                    throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
                }
                String strZza = zzpu.zza("android-keystore://", str);
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(strZza, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
                keyGenerator.generateKey();
            } catch (GeneralSecurityException | ProviderException unused2) {
                String unused3 = zzfn.zzb;
                return null;
            }
        }
        try {
            return zzfpVar.zza(this.zzb);
        } catch (GeneralSecurityException | ProviderException e) {
            if (zZzc) {
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzb), e);
            }
            String unused4 = zzfn.zzb;
            return null;
        }
    }

    private final zzbi zzi() throws GeneralSecurityException, IOException {
        zzap zzapVar = this.zzc;
        if (zzapVar != null) {
            try {
                return zzbi.zzf(zzbh.zzh(this.zzf, zzapVar));
            } catch (zzacp | GeneralSecurityException unused) {
                String unused2 = zzfn.zzb;
            }
        }
        return zzbi.zzf(zzar.zzb(this.zzf));
    }

    @Deprecated
    public final zzfl zzd(zzmz zzmzVar) {
        String strZzf = zzmzVar.zzf();
        byte[] bArrZzt = zzmzVar.zze().zzt();
        zzoa zzoaVarZzd = zzmzVar.zzd();
        int i = zzfn.zza;
        zzoa zzoaVar = zzoa.UNKNOWN_PREFIX;
        int iOrdinal = zzoaVarZzd.ordinal();
        int i2 = 4;
        if (iOrdinal == 1) {
            i2 = 1;
        } else if (iOrdinal == 2) {
            i2 = 2;
        } else if (iOrdinal == 3) {
            i2 = 3;
        } else if (iOrdinal != 4) {
            throw new IllegalArgumentException("Unknown output prefix type");
        }
        this.zzd = zzbf.zze(strZzf, bArrZzt, i2);
        return this;
    }

    public final zzfl zze(String str) {
        if (!str.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        this.zzb = str;
        return this;
    }

    public final zzfl zzf(Context context, String str, String str2) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        this.zzf = new zzfq(context, "GenericIdpKeyset", str2);
        this.zza = new zzfr(context, "GenericIdpKeyset", str2);
        return this;
    }

    public final synchronized zzfn zzg() throws GeneralSecurityException, IOException {
        zzbi zzbiVarZze;
        if (this.zzb != null) {
            this.zzc = zzh();
        }
        try {
            zzbiVarZze = zzi();
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(zzfn.zzb, 4)) {
                String unused = zzfn.zzb;
                String.format("keyset not found, will generate a new one. %s", e.getMessage());
            }
            if (this.zzd == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            zzbiVarZze = zzbi.zze();
            zzbiVarZze.zzc(this.zzd);
            zzbiVarZze.zzd(zzbiVarZze.zzb().zzd().zzb(0).zza());
            if (this.zzc != null) {
                zzbiVarZze.zzb().zzf(this.zza, this.zzc);
            } else {
                zzar.zza(zzbiVarZze.zzb(), this.zza);
            }
        }
        this.zze = zzbiVarZze;
        return new zzfn(this, null);
    }
}
