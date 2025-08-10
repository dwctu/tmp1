package com.google.android.gms.internal.p002firebaseauthapi;

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
/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzacq {
    public static final zzacq zza;
    public static final zzacq zzb;
    public static final zzacq zzc;
    public static final zzacq zzd;
    public static final zzacq zze;
    public static final zzacq zzf;
    public static final zzacq zzg;
    public static final zzacq zzh;
    public static final zzacq zzi;
    public static final zzacq zzj;
    private static final /* synthetic */ zzacq[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzacq zzacqVar = new zzacq("VOID", 0, Void.class, Void.class, null);
        zza = zzacqVar;
        Class cls = Integer.TYPE;
        zzacq zzacqVar2 = new zzacq("INT", 1, cls, Integer.class, 0);
        zzb = zzacqVar2;
        zzacq zzacqVar3 = new zzacq("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzacqVar3;
        zzacq zzacqVar4 = new zzacq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzacqVar4;
        zzacq zzacqVar5 = new zzacq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzacqVar5;
        zzacq zzacqVar6 = new zzacq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzacqVar6;
        zzacq zzacqVar7 = new zzacq("STRING", 6, String.class, String.class, "");
        zzg = zzacqVar7;
        zzacq zzacqVar8 = new zzacq("BYTE_STRING", 7, zzabe.class, zzabe.class, zzabe.zzb);
        zzh = zzacqVar8;
        zzacq zzacqVar9 = new zzacq("ENUM", 8, cls, Integer.class, null);
        zzi = zzacqVar9;
        zzacq zzacqVar10 = new zzacq("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzacqVar10;
        zzk = new zzacq[]{zzacqVar, zzacqVar2, zzacqVar3, zzacqVar4, zzacqVar5, zzacqVar6, zzacqVar7, zzacqVar8, zzacqVar9, zzacqVar10};
    }

    private zzacq(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzacq[] values() {
        return (zzacq[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
