package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzpb {
    public static final zzpb zza;
    public static final zzpb zzb;
    public static final zzpb zzc;
    public static final zzpb zzd;
    public static final zzpb zze;
    public static final zzpb zzf;
    public static final zzpb zzg;
    private static final Logger zzh = Logger.getLogger(zzpb.class.getName());
    private static final List zzi;
    private static final boolean zzj;
    private final zzpj zzk;

    static {
        if (zzdw.zzb()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt");
            zzj = false;
        } else if (zzpt.zza()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
            zzj = true;
        } else {
            zzi = new ArrayList();
            zzj = true;
        }
        zza = new zzpb(new zzpc());
        zzb = new zzpb(new zzpg());
        zzc = new zzpb(new zzpi());
        zzd = new zzpb(new zzph());
        zze = new zzpb(new zzpd());
        zzf = new zzpb(new zzpf());
        zzg = new zzpb(new zzpe());
    }

    public zzpb(zzpj zzpjVar) {
        this.zzk = zzpjVar;
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Iterator it = zzi.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zzk.zza(str, (Provider) it.next());
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (zzj) {
            return this.zzk.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
