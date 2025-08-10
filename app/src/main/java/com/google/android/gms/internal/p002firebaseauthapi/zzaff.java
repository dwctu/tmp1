package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
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
public final class zzaff {
    public static final zzaff zza;
    public static final zzaff zzb;
    public static final zzaff zzc;
    public static final zzaff zzd;
    public static final zzaff zze;
    public static final zzaff zzf;
    public static final zzaff zzg;
    public static final zzaff zzh;
    public static final zzaff zzi;
    public static final zzaff zzj;
    public static final zzaff zzk;
    public static final zzaff zzl;
    public static final zzaff zzm;
    public static final zzaff zzn;
    public static final zzaff zzo;
    public static final zzaff zzp;
    public static final zzaff zzq;
    public static final zzaff zzr;
    private static final /* synthetic */ zzaff[] zzs;
    private final zzafg zzt;

    static {
        zzaff zzaffVar = new zzaff("DOUBLE", 0, zzafg.DOUBLE, 1);
        zza = zzaffVar;
        zzaff zzaffVar2 = new zzaff("FLOAT", 1, zzafg.FLOAT, 5);
        zzb = zzaffVar2;
        zzafg zzafgVar = zzafg.LONG;
        zzaff zzaffVar3 = new zzaff("INT64", 2, zzafgVar, 0);
        zzc = zzaffVar3;
        zzaff zzaffVar4 = new zzaff("UINT64", 3, zzafgVar, 0);
        zzd = zzaffVar4;
        zzafg zzafgVar2 = zzafg.INT;
        zzaff zzaffVar5 = new zzaff("INT32", 4, zzafgVar2, 0);
        zze = zzaffVar5;
        zzaff zzaffVar6 = new zzaff("FIXED64", 5, zzafgVar, 1);
        zzf = zzaffVar6;
        zzaff zzaffVar7 = new zzaff("FIXED32", 6, zzafgVar2, 5);
        zzg = zzaffVar7;
        zzaff zzaffVar8 = new zzaff("BOOL", 7, zzafg.BOOLEAN, 0);
        zzh = zzaffVar8;
        zzaff zzaffVar9 = new zzaff("STRING", 8, zzafg.STRING, 2);
        zzi = zzaffVar9;
        zzafg zzafgVar3 = zzafg.MESSAGE;
        zzaff zzaffVar10 = new zzaff("GROUP", 9, zzafgVar3, 3);
        zzj = zzaffVar10;
        zzaff zzaffVar11 = new zzaff("MESSAGE", 10, zzafgVar3, 2);
        zzk = zzaffVar11;
        zzaff zzaffVar12 = new zzaff("BYTES", 11, zzafg.BYTE_STRING, 2);
        zzl = zzaffVar12;
        zzaff zzaffVar13 = new zzaff("UINT32", 12, zzafgVar2, 0);
        zzm = zzaffVar13;
        zzaff zzaffVar14 = new zzaff("ENUM", 13, zzafg.ENUM, 0);
        zzn = zzaffVar14;
        zzaff zzaffVar15 = new zzaff("SFIXED32", 14, zzafgVar2, 5);
        zzo = zzaffVar15;
        zzaff zzaffVar16 = new zzaff("SFIXED64", 15, zzafgVar, 1);
        zzp = zzaffVar16;
        zzaff zzaffVar17 = new zzaff("SINT32", 16, zzafgVar2, 0);
        zzq = zzaffVar17;
        zzaff zzaffVar18 = new zzaff("SINT64", 17, zzafgVar, 0);
        zzr = zzaffVar18;
        zzs = new zzaff[]{zzaffVar, zzaffVar2, zzaffVar3, zzaffVar4, zzaffVar5, zzaffVar6, zzaffVar7, zzaffVar8, zzaffVar9, zzaffVar10, zzaffVar11, zzaffVar12, zzaffVar13, zzaffVar14, zzaffVar15, zzaffVar16, zzaffVar17, zzaffVar18};
    }

    private zzaff(String str, int i, zzafg zzafgVar, int i2) {
        this.zzt = zzafgVar;
    }

    public static zzaff[] values() {
        return (zzaff[]) zzs.clone();
    }

    public final zzafg zza() {
        return this.zzt;
    }
}
