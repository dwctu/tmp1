package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzee extends zzga {
    public final /* synthetic */ zzef zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzee(zzef zzefVar, Class cls) {
        super(cls);
        this.zza = zzefVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzkz zzkzVar = (zzkz) zzadmVar;
        ECParameterSpec eCParameterSpecZzk = zzoz.zzk(zzeo.zzc(zzkzVar.zzd().zze().zzf()));
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzpb.zzf.zza("EC");
        keyPairGenerator.initialize(eCParameterSpecZzk);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        ECPoint w = eCPublicKey.getW();
        zzlh zzlhVarZzc = zzli.zzc();
        zzlhVarZzc.zzb(0);
        zzlhVarZzc.zza(zzkzVar.zzd());
        zzlhVarZzc.zzc(zzabe.zzn(w.getAffineX().toByteArray()));
        zzlhVarZzc.zzd(zzabe.zzn(w.getAffineY().toByteArray()));
        zzli zzliVar = (zzli) zzlhVarZzc.zzk();
        zzle zzleVarZzb = zzlf.zzb();
        zzleVarZzb.zzc(0);
        zzleVarZzb.zzb(zzliVar);
        zzleVarZzb.zza(zzabe.zzn(eCPrivateKey.getS().toByteArray()));
        return (zzlf) zzleVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzkz.zzc(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzef.zzi(4, 5, 3, zzbg.zza("AES128_GCM"), zzef.zza, 1));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzef.zzi(4, 5, 3, zzbg.zza("AES128_GCM"), zzef.zza, 3));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzef.zzi(4, 5, 4, zzbg.zza("AES128_GCM"), zzef.zza, 1));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzef.zzi(4, 5, 4, zzbg.zza("AES128_GCM"), zzef.zza, 3));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzef.zzi(4, 5, 4, zzbg.zza("AES128_GCM"), zzef.zza, 3));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzef.zzi(4, 5, 3, zzbg.zza("AES128_CTR_HMAC_SHA256"), zzef.zza, 1));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzef.zzi(4, 5, 3, zzbg.zza("AES128_CTR_HMAC_SHA256"), zzef.zza, 3));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzef.zzi(4, 5, 4, zzbg.zza("AES128_CTR_HMAC_SHA256"), zzef.zza, 1));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzef.zzi(4, 5, 4, zzbg.zza("AES128_CTR_HMAC_SHA256"), zzef.zza, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzeo.zza(((zzkz) zzadmVar).zzd());
    }
}
