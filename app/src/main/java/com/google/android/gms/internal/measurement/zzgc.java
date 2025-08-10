package com.google.android.gms.internal.measurement;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.List;
import org.bouncycastle.apache.bzip2.CBZip2OutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzgc extends zzke implements zzlm {
    public static final /* synthetic */ int zza = 0;
    private static final zzgc zze;
    private boolean zzA;
    private long zzC;
    private int zzD;
    private boolean zzG;
    private int zzJ;
    private int zzK;
    private int zzL;
    private long zzN;
    private long zzO;
    private int zzR;
    private zzgf zzT;
    private long zzV;
    private long zzW;
    private int zzZ;
    private boolean zzaa;
    private boolean zzac;
    private zzfy zzad;
    private int zzf;
    private int zzg;
    private int zzh;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzt;
    private long zzx;
    private long zzy;
    private zzkl zzi = zzke.zzbD();
    private zzkl zzj = zzke.zzbD();
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzs = "";
    private String zzu = "";
    private String zzv = "";
    private String zzw = "";
    private String zzz = "";
    private String zzB = "";
    private String zzE = "";
    private String zzF = "";
    private zzkl zzH = zzke.zzbD();
    private String zzI = "";
    private String zzM = "";
    private String zzP = "";
    private String zzQ = "";
    private String zzS = "";
    private zzkj zzU = zzke.zzbA();
    private String zzX = "";
    private String zzY = "";
    private String zzab = "";
    private String zzae = "";
    private zzkl zzaf = zzke.zzbD();
    private String zzag = "";

    static {
        zzgc zzgcVar = new zzgc();
        zze = zzgcVar;
        zzke.zzbJ(zzgc.class, zzgcVar);
    }

    private zzgc() {
    }

    public static /* synthetic */ void zzP(zzgc zzgcVar) {
        zzgcVar.zzf &= Integer.MAX_VALUE;
        zzgcVar.zzP = zze.zzP;
    }

    public static /* synthetic */ void zzQ(zzgc zzgcVar, int i) {
        zzgcVar.zzg |= 2;
        zzgcVar.zzR = i;
    }

    public static /* synthetic */ void zzR(zzgc zzgcVar, int i, zzfs zzfsVar) {
        zzfsVar.getClass();
        zzgcVar.zzbL();
        zzgcVar.zzi.set(i, zzfsVar);
    }

    public static /* synthetic */ void zzS(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzg |= 4;
        zzgcVar.zzS = str;
    }

    public static /* synthetic */ void zzT(zzgc zzgcVar, zzgf zzgfVar) {
        zzgfVar.getClass();
        zzgcVar.zzT = zzgfVar;
        zzgcVar.zzg |= 8;
    }

    public static /* synthetic */ void zzU(zzgc zzgcVar, Iterable iterable) {
        zzkj zzkjVar = zzgcVar.zzU;
        if (!zzkjVar.zzc()) {
            int size = zzkjVar.size();
            zzgcVar.zzU = zzkjVar.zzd(size == 0 ? 10 : size + size);
        }
        zzin.zzbt(iterable, zzgcVar.zzU);
    }

    public static /* synthetic */ void zzV(zzgc zzgcVar, zzfs zzfsVar) {
        zzfsVar.getClass();
        zzgcVar.zzbL();
        zzgcVar.zzi.add(zzfsVar);
    }

    public static /* synthetic */ void zzW(zzgc zzgcVar, long j) {
        zzgcVar.zzg |= 16;
        zzgcVar.zzV = j;
    }

    public static /* synthetic */ void zzX(zzgc zzgcVar, long j) {
        zzgcVar.zzg |= 32;
        zzgcVar.zzW = j;
    }

    public static /* synthetic */ void zzY(zzgc zzgcVar, String str) {
        zzgcVar.zzg |= 128;
        zzgcVar.zzY = str;
    }

    public static /* synthetic */ void zzZ(zzgc zzgcVar, Iterable iterable) {
        zzgcVar.zzbL();
        zzin.zzbt(iterable, zzgcVar.zzi);
    }

    public static /* synthetic */ void zzaA(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 8192;
        zzgcVar.zzw = str;
    }

    public static /* synthetic */ void zzaB(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 16384;
        zzgcVar.zzx = j;
    }

    public static /* synthetic */ void zzaC(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 32768;
        zzgcVar.zzy = 73000L;
    }

    public static /* synthetic */ void zzaD(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 65536;
        zzgcVar.zzz = str;
    }

    public static /* synthetic */ void zzaE(zzgc zzgcVar) {
        zzgcVar.zzf &= -65537;
        zzgcVar.zzz = zze.zzz;
    }

    public static /* synthetic */ void zzaF(zzgc zzgcVar, boolean z) {
        zzgcVar.zzf |= 131072;
        zzgcVar.zzA = z;
    }

    public static /* synthetic */ void zzaG(zzgc zzgcVar) {
        zzgcVar.zzf &= -131073;
        zzgcVar.zzA = false;
    }

    public static /* synthetic */ void zzaH(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 262144;
        zzgcVar.zzB = str;
    }

    public static /* synthetic */ void zzaI(zzgc zzgcVar) {
        zzgcVar.zzf &= -262145;
        zzgcVar.zzB = zze.zzB;
    }

    public static /* synthetic */ void zzaJ(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 524288;
        zzgcVar.zzC = j;
    }

    public static /* synthetic */ void zzaK(zzgc zzgcVar, int i) {
        zzgcVar.zzf |= 1048576;
        zzgcVar.zzD = i;
    }

    public static /* synthetic */ void zzaL(zzgc zzgcVar, String str) {
        zzgcVar.zzf |= 2097152;
        zzgcVar.zzE = str;
    }

    public static /* synthetic */ void zzaM(zzgc zzgcVar) {
        zzgcVar.zzf &= CBZip2OutputStream.CLEARMASK;
        zzgcVar.zzE = zze.zzE;
    }

    public static /* synthetic */ void zzaN(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 4194304;
        zzgcVar.zzF = str;
    }

    public static /* synthetic */ void zzaO(zzgc zzgcVar, boolean z) {
        zzgcVar.zzf |= 8388608;
        zzgcVar.zzG = z;
    }

    public static /* synthetic */ void zzaP(zzgc zzgcVar, Iterable iterable) {
        zzkl zzklVar = zzgcVar.zzH;
        if (!zzklVar.zzc()) {
            zzgcVar.zzH = zzke.zzbE(zzklVar);
        }
        zzin.zzbt(iterable, zzgcVar.zzH);
    }

    public static /* synthetic */ void zzaR(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 16777216;
        zzgcVar.zzI = str;
    }

    public static /* synthetic */ void zzaS(zzgc zzgcVar, int i) {
        zzgcVar.zzf |= 33554432;
        zzgcVar.zzJ = i;
    }

    public static /* synthetic */ void zzaT(zzgc zzgcVar, int i) {
        zzgcVar.zzf |= 1;
        zzgcVar.zzh = 1;
    }

    public static /* synthetic */ void zzaU(zzgc zzgcVar) {
        zzgcVar.zzf &= -268435457;
        zzgcVar.zzM = zze.zzM;
    }

    public static /* synthetic */ void zzaV(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 536870912;
        zzgcVar.zzN = j;
    }

    public static /* synthetic */ void zzaa(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzg |= 8192;
        zzgcVar.zzae = str;
    }

    public static /* synthetic */ void zzab(zzgc zzgcVar) {
        zzgcVar.zzg &= -8193;
        zzgcVar.zzae = zze.zzae;
    }

    public static /* synthetic */ void zzac(zzgc zzgcVar, Iterable iterable) {
        zzkl zzklVar = zzgcVar.zzaf;
        if (!zzklVar.zzc()) {
            zzgcVar.zzaf = zzke.zzbE(zzklVar);
        }
        zzin.zzbt(iterable, zzgcVar.zzaf);
    }

    public static /* synthetic */ void zzae(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzg |= 16384;
        zzgcVar.zzag = str;
    }

    public static /* synthetic */ void zzaf(zzgc zzgcVar, int i) {
        zzgcVar.zzbL();
        zzgcVar.zzi.remove(i);
    }

    public static /* synthetic */ void zzag(zzgc zzgcVar, int i, zzgl zzglVar) {
        zzglVar.getClass();
        zzgcVar.zzbM();
        zzgcVar.zzj.set(i, zzglVar);
    }

    public static /* synthetic */ void zzah(zzgc zzgcVar, zzgl zzglVar) {
        zzglVar.getClass();
        zzgcVar.zzbM();
        zzgcVar.zzj.add(zzglVar);
    }

    public static /* synthetic */ void zzai(zzgc zzgcVar, Iterable iterable) {
        zzgcVar.zzbM();
        zzin.zzbt(iterable, zzgcVar.zzj);
    }

    public static /* synthetic */ void zzaj(zzgc zzgcVar, int i) {
        zzgcVar.zzbM();
        zzgcVar.zzj.remove(i);
    }

    public static /* synthetic */ void zzak(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 2;
        zzgcVar.zzk = j;
    }

    public static /* synthetic */ void zzal(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 4;
        zzgcVar.zzl = j;
    }

    public static /* synthetic */ void zzam(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 8;
        zzgcVar.zzm = j;
    }

    public static /* synthetic */ void zzan(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 16;
        zzgcVar.zzn = j;
    }

    public static /* synthetic */ void zzao(zzgc zzgcVar) {
        zzgcVar.zzf &= -17;
        zzgcVar.zzn = 0L;
    }

    public static /* synthetic */ void zzap(zzgc zzgcVar, long j) {
        zzgcVar.zzf |= 32;
        zzgcVar.zzo = j;
    }

    public static /* synthetic */ void zzaq(zzgc zzgcVar) {
        zzgcVar.zzf &= -33;
        zzgcVar.zzo = 0L;
    }

    public static /* synthetic */ void zzar(zzgc zzgcVar, String str) {
        zzgcVar.zzf |= 64;
        zzgcVar.zzp = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;
    }

    public static /* synthetic */ void zzas(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 128;
        zzgcVar.zzq = str;
    }

    public static /* synthetic */ void zzat(zzgc zzgcVar) {
        zzgcVar.zzf &= -129;
        zzgcVar.zzq = zze.zzq;
    }

    public static /* synthetic */ void zzau(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 256;
        zzgcVar.zzr = str;
    }

    public static /* synthetic */ void zzav(zzgc zzgcVar) {
        zzgcVar.zzf &= -257;
        zzgcVar.zzr = zze.zzr;
    }

    public static /* synthetic */ void zzaw(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 512;
        zzgcVar.zzs = str;
    }

    public static /* synthetic */ void zzax(zzgc zzgcVar, int i) {
        zzgcVar.zzf |= 1024;
        zzgcVar.zzt = i;
    }

    public static /* synthetic */ void zzay(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 2048;
        zzgcVar.zzu = str;
    }

    public static /* synthetic */ void zzaz(zzgc zzgcVar, String str) {
        str.getClass();
        zzgcVar.zzf |= 4096;
        zzgcVar.zzv = str;
    }

    private final void zzbL() {
        zzkl zzklVar = this.zzi;
        if (zzklVar.zzc()) {
            return;
        }
        this.zzi = zzke.zzbE(zzklVar);
    }

    private final void zzbM() {
        zzkl zzklVar = this.zzj;
        if (zzklVar.zzc()) {
            return;
        }
        this.zzj = zzke.zzbE(zzklVar);
    }

    public static zzgb zzt() {
        return (zzgb) zze.zzbx();
    }

    public final String zzA() {
        return this.zzw;
    }

    public final String zzB() {
        return this.zzY;
    }

    public final String zzC() {
        return this.zzr;
    }

    public final String zzD() {
        return this.zzP;
    }

    public final String zzE() {
        return this.zzI;
    }

    public final String zzF() {
        return this.zzF;
    }

    public final String zzG() {
        return this.zzE;
    }

    public final String zzH() {
        return this.zzq;
    }

    public final String zzI() {
        return this.zzp;
    }

    public final String zzJ() {
        return this.zzz;
    }

    public final String zzK() {
        return this.zzae;
    }

    public final String zzL() {
        return this.zzs;
    }

    public final List zzM() {
        return this.zzH;
    }

    public final List zzN() {
        return this.zzi;
    }

    public final List zzO() {
        return this.zzj;
    }

    public final int zza() {
        return this.zzJ;
    }

    public final boolean zzaW() {
        return this.zzA;
    }

    public final boolean zzaX() {
        return this.zzG;
    }

    public final boolean zzaY() {
        return (this.zzf & 33554432) != 0;
    }

    public final boolean zzaZ() {
        return (this.zzf & 1048576) != 0;
    }

    public final int zzb() {
        return this.zzD;
    }

    public final boolean zzba() {
        return (this.zzf & 536870912) != 0;
    }

    public final boolean zzbb() {
        return (this.zzg & 128) != 0;
    }

    public final boolean zzbc() {
        return (this.zzf & 524288) != 0;
    }

    public final boolean zzbd() {
        return (this.zzg & 16) != 0;
    }

    public final boolean zzbe() {
        return (this.zzf & 8) != 0;
    }

    public final boolean zzbf() {
        return (this.zzf & 16384) != 0;
    }

    public final boolean zzbg() {
        return (this.zzf & 131072) != 0;
    }

    public final boolean zzbh() {
        return (this.zzf & 32) != 0;
    }

    public final boolean zzbi() {
        return (this.zzf & 16) != 0;
    }

    public final boolean zzbj() {
        return (this.zzf & 1) != 0;
    }

    public final boolean zzbk() {
        return (this.zzg & 2) != 0;
    }

    public final boolean zzbl() {
        return (this.zzf & 8388608) != 0;
    }

    public final boolean zzbm() {
        return (this.zzg & 8192) != 0;
    }

    public final boolean zzbn() {
        return (this.zzf & 4) != 0;
    }

    public final boolean zzbo() {
        return (this.zzf & 1024) != 0;
    }

    public final boolean zzbp() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzbq() {
        return (this.zzf & 32768) != 0;
    }

    public final int zzc() {
        return this.zzi.size();
    }

    public final int zzd() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzR;
    }

    public final int zzf() {
        return this.zzt;
    }

    public final int zzg() {
        return this.zzj.size();
    }

    public final long zzh() {
        return this.zzN;
    }

    public final long zzi() {
        return this.zzC;
    }

    public final long zzj() {
        return this.zzV;
    }

    public final long zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzke.zzbI(zze, "\u00014\u0000\u0002\u0001A4\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.", new Object[]{"zzf", "zzg", "zzh", "zzi", zzfs.class, "zzj", zzgl.class, "zzk", "zzl", "zzm", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzn", "zzG", "zzH", zzfo.class, "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", "zzZ", zzfk.zza, "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag"});
        }
        if (i2 == 3) {
            return new zzgc();
        }
        zzfj zzfjVar = null;
        if (i2 == 4) {
            return new zzgb(zzfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zze;
    }

    public final long zzm() {
        return this.zzx;
    }

    public final long zzn() {
        return this.zzo;
    }

    public final long zzo() {
        return this.zzn;
    }

    public final long zzp() {
        return this.zzl;
    }

    public final long zzq() {
        return this.zzk;
    }

    public final long zzr() {
        return this.zzy;
    }

    public final zzfs zzs(int i) {
        return (zzfs) this.zzi.get(i);
    }

    public final zzgl zzv(int i) {
        return (zzgl) this.zzj.get(i);
    }

    public final String zzw() {
        return this.zzS;
    }

    public final String zzx() {
        return this.zzv;
    }

    public final String zzy() {
        return this.zzB;
    }

    public final String zzz() {
        return this.zzu;
    }
}
