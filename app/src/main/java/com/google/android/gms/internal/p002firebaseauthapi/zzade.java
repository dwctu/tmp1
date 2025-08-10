package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzade implements zzadz {
    private static final zzadk zza = new zzadc();
    private final zzadk zzb;

    public zzade() {
        zzadk zzadkVar;
        zzadk[] zzadkVarArr = new zzadk[2];
        zzadkVarArr[0] = zzacc.zza();
        try {
            zzadkVar = (zzadk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzadkVar = zza;
        }
        zzadkVarArr[1] = zzadkVar;
        zzadd zzaddVar = new zzadd(zzadkVarArr);
        zzacn.zzf(zzaddVar, "messageInfoFactory");
        this.zzb = zzaddVar;
    }

    private static boolean zzb(zzadj zzadjVar) {
        return zzadjVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadz
    public final zzady zza(Class cls) {
        zzaea.zzG(cls);
        zzadj zzadjVarZzb = this.zzb.zzb(cls);
        return zzadjVarZzb.zzb() ? zzach.class.isAssignableFrom(cls) ? zzadq.zzc(zzaea.zzB(), zzabx.zzb(), zzadjVarZzb.zza()) : zzadq.zzc(zzaea.zzz(), zzabx.zza(), zzadjVarZzb.zza()) : zzach.class.isAssignableFrom(cls) ? zzb(zzadjVarZzb) ? zzadp.zzl(cls, zzadjVarZzb, zzads.zzb(), zzada.zze(), zzaea.zzB(), zzabx.zzb(), zzadi.zzb()) : zzadp.zzl(cls, zzadjVarZzb, zzads.zzb(), zzada.zze(), zzaea.zzB(), null, zzadi.zzb()) : zzb(zzadjVarZzb) ? zzadp.zzl(cls, zzadjVarZzb, zzads.zza(), zzada.zzd(), zzaea.zzz(), zzabx.zza(), zzadi.zza()) : zzadp.zzl(cls, zzadjVarZzb, zzads.zza(), zzada.zzd(), zzaea.zzA(), null, zzadi.zza());
    }
}
