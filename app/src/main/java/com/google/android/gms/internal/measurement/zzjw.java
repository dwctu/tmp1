package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzjw {
    public static final zzjw zzA;
    public static final zzjw zzB;
    public static final zzjw zzC;
    public static final zzjw zzD;
    public static final zzjw zzE;
    public static final zzjw zzF;
    public static final zzjw zzG;
    public static final zzjw zzH;
    public static final zzjw zzI;
    public static final zzjw zzJ;
    public static final zzjw zzK;
    public static final zzjw zzL;
    public static final zzjw zzM;
    public static final zzjw zzN;
    public static final zzjw zzO;
    public static final zzjw zzP;
    public static final zzjw zzQ;
    public static final zzjw zzR;
    public static final zzjw zzS;
    public static final zzjw zzT;
    public static final zzjw zzU;
    public static final zzjw zzV;
    public static final zzjw zzW;
    public static final zzjw zzX;
    public static final zzjw zzY;
    private static final zzjw[] zzZ;
    public static final zzjw zza;
    private static final /* synthetic */ zzjw[] zzaa;
    public static final zzjw zzb;
    public static final zzjw zzc;
    public static final zzjw zzd;
    public static final zzjw zze;
    public static final zzjw zzf;
    public static final zzjw zzg;
    public static final zzjw zzh;
    public static final zzjw zzi;
    public static final zzjw zzj;
    public static final zzjw zzk;
    public static final zzjw zzl;
    public static final zzjw zzm;
    public static final zzjw zzn;
    public static final zzjw zzo;
    public static final zzjw zzp;
    public static final zzjw zzq;
    public static final zzjw zzr;
    public static final zzjw zzs;
    public static final zzjw zzt;
    public static final zzjw zzu;
    public static final zzjw zzv;
    public static final zzjw zzw;
    public static final zzjw zzx;
    public static final zzjw zzy;
    public static final zzjw zzz;
    private final zzkp zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzkp zzkpVar = zzkp.zze;
        zza = new zzjw("DOUBLE", 0, 0, 1, zzkpVar);
        zzkp zzkpVar2 = zzkp.zzd;
        zzb = new zzjw("FLOAT", 1, 1, 1, zzkpVar2);
        zzkp zzkpVar3 = zzkp.zzc;
        zzc = new zzjw("INT64", 2, 2, 1, zzkpVar3);
        zzd = new zzjw("UINT64", 3, 3, 1, zzkpVar3);
        zzkp zzkpVar4 = zzkp.zzb;
        zze = new zzjw("INT32", 4, 4, 1, zzkpVar4);
        zzf = new zzjw("FIXED64", 5, 5, 1, zzkpVar3);
        zzg = new zzjw("FIXED32", 6, 6, 1, zzkpVar4);
        zzkp zzkpVar5 = zzkp.zzf;
        zzh = new zzjw("BOOL", 7, 7, 1, zzkpVar5);
        zzkp zzkpVar6 = zzkp.zzg;
        zzi = new zzjw("STRING", 8, 8, 1, zzkpVar6);
        zzkp zzkpVar7 = zzkp.zzj;
        zzj = new zzjw("MESSAGE", 9, 9, 1, zzkpVar7);
        zzkp zzkpVar8 = zzkp.zzh;
        zzk = new zzjw("BYTES", 10, 10, 1, zzkpVar8);
        zzl = new zzjw("UINT32", 11, 11, 1, zzkpVar4);
        zzkp zzkpVar9 = zzkp.zzi;
        zzm = new zzjw("ENUM", 12, 12, 1, zzkpVar9);
        zzn = new zzjw("SFIXED32", 13, 13, 1, zzkpVar4);
        zzo = new zzjw("SFIXED64", 14, 14, 1, zzkpVar3);
        zzp = new zzjw("SINT32", 15, 15, 1, zzkpVar4);
        zzq = new zzjw("SINT64", 16, 16, 1, zzkpVar3);
        zzr = new zzjw("GROUP", 17, 17, 1, zzkpVar7);
        zzs = new zzjw("DOUBLE_LIST", 18, 18, 2, zzkpVar);
        zzt = new zzjw("FLOAT_LIST", 19, 19, 2, zzkpVar2);
        zzu = new zzjw("INT64_LIST", 20, 20, 2, zzkpVar3);
        zzv = new zzjw("UINT64_LIST", 21, 21, 2, zzkpVar3);
        zzw = new zzjw("INT32_LIST", 22, 22, 2, zzkpVar4);
        zzx = new zzjw("FIXED64_LIST", 23, 23, 2, zzkpVar3);
        zzy = new zzjw("FIXED32_LIST", 24, 24, 2, zzkpVar4);
        zzz = new zzjw("BOOL_LIST", 25, 25, 2, zzkpVar5);
        zzA = new zzjw("STRING_LIST", 26, 26, 2, zzkpVar6);
        zzB = new zzjw("MESSAGE_LIST", 27, 27, 2, zzkpVar7);
        zzC = new zzjw("BYTES_LIST", 28, 28, 2, zzkpVar8);
        zzD = new zzjw("UINT32_LIST", 29, 29, 2, zzkpVar4);
        zzE = new zzjw("ENUM_LIST", 30, 30, 2, zzkpVar9);
        zzF = new zzjw("SFIXED32_LIST", 31, 31, 2, zzkpVar4);
        zzG = new zzjw("SFIXED64_LIST", 32, 32, 2, zzkpVar3);
        zzH = new zzjw("SINT32_LIST", 33, 33, 2, zzkpVar4);
        zzI = new zzjw("SINT64_LIST", 34, 34, 2, zzkpVar3);
        zzJ = new zzjw("DOUBLE_LIST_PACKED", 35, 35, 3, zzkpVar);
        zzK = new zzjw("FLOAT_LIST_PACKED", 36, 36, 3, zzkpVar2);
        zzL = new zzjw("INT64_LIST_PACKED", 37, 37, 3, zzkpVar3);
        zzM = new zzjw("UINT64_LIST_PACKED", 38, 38, 3, zzkpVar3);
        zzN = new zzjw("INT32_LIST_PACKED", 39, 39, 3, zzkpVar4);
        zzO = new zzjw("FIXED64_LIST_PACKED", 40, 40, 3, zzkpVar3);
        zzP = new zzjw("FIXED32_LIST_PACKED", 41, 41, 3, zzkpVar4);
        zzQ = new zzjw("BOOL_LIST_PACKED", 42, 42, 3, zzkpVar5);
        zzR = new zzjw("UINT32_LIST_PACKED", 43, 43, 3, zzkpVar4);
        zzS = new zzjw("ENUM_LIST_PACKED", 44, 44, 3, zzkpVar9);
        zzT = new zzjw("SFIXED32_LIST_PACKED", 45, 45, 3, zzkpVar4);
        zzkp zzkpVar10 = zzkp.zzc;
        zzU = new zzjw("SFIXED64_LIST_PACKED", 46, 46, 3, zzkpVar10);
        zzV = new zzjw("SINT32_LIST_PACKED", 47, 47, 3, zzkpVar4);
        zzW = new zzjw("SINT64_LIST_PACKED", 48, 48, 3, zzkpVar10);
        zzX = new zzjw("GROUP_LIST", 49, 49, 2, zzkpVar7);
        zzY = new zzjw("MAP", 50, 50, 4, zzkp.zza);
        zzaa = new zzjw[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzA, zzB, zzC, zzD, zzE, zzF, zzG, zzH, zzI, zzJ, zzK, zzL, zzM, zzN, zzO, zzP, zzQ, zzR, zzS, zzT, zzU, zzV, zzW, zzX, zzY};
        zzjw[] zzjwVarArrValues = values();
        zzZ = new zzjw[zzjwVarArrValues.length];
        for (zzjw zzjwVar : zzjwVarArrValues) {
            zzZ[zzjwVar.zzac] = zzjwVar;
        }
    }

    private zzjw(String str, int i, int i2, int i3, zzkp zzkpVar) {
        this.zzac = i2;
        this.zzab = zzkpVar;
        zzkp zzkpVar2 = zzkp.zza;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            this.zzad = zzkpVar.zza();
        } else {
            this.zzad = null;
        }
        if (i3 == 1) {
            zzkpVar.ordinal();
        }
    }

    public static zzjw[] values() {
        return (zzjw[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }
}
