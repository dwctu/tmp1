package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzkp {
    public static final zzkp zza;
    public static final zzkp zzb;
    public static final zzkp zzc;
    public static final zzkp zzd;
    public static final zzkp zze;
    public static final zzkp zzf;
    public static final zzkp zzg;
    public static final zzkp zzh;
    public static final zzkp zzi;
    public static final zzkp zzj;
    private static final /* synthetic */ zzkp[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzkp zzkpVar = new zzkp("VOID", 0, Void.class, Void.class, null);
        zza = zzkpVar;
        Class cls = Integer.TYPE;
        zzkp zzkpVar2 = new zzkp("INT", 1, cls, Integer.class, 0);
        zzb = zzkpVar2;
        zzkp zzkpVar3 = new zzkp("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzkpVar3;
        zzkp zzkpVar4 = new zzkp("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzkpVar4;
        zzkp zzkpVar5 = new zzkp("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzkpVar5;
        zzkp zzkpVar6 = new zzkp("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzkpVar6;
        zzkp zzkpVar7 = new zzkp("STRING", 6, String.class, String.class, "");
        zzg = zzkpVar7;
        zzkp zzkpVar8 = new zzkp("BYTE_STRING", 7, zzjd.class, zzjd.class, zzjd.zzb);
        zzh = zzkpVar8;
        zzkp zzkpVar9 = new zzkp("ENUM", 8, cls, Integer.class, null);
        zzi = zzkpVar9;
        zzkp zzkpVar10 = new zzkp("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzkpVar10;
        zzk = new zzkp[]{zzkpVar, zzkpVar2, zzkpVar3, zzkpVar4, zzkpVar5, zzkpVar6, zzkpVar7, zzkpVar8, zzkpVar9, zzkpVar10};
    }

    private zzkp(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzkp[] values() {
        return (zzkp[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
