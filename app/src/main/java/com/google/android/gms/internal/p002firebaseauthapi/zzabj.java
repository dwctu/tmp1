package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzabj implements zzadx {
    private final zzabi zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzabj(zzabi zzabiVar) {
        zzacn.zzf(zzabiVar, "input");
        this.zza = zzabiVar;
        zzabiVar.zzc = this;
    }

    private final Object zzP(zzady zzadyVar, zzabu zzabuVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            Object objZze = zzadyVar.zze();
            zzadyVar.zzh(objZze, this, zzabuVar);
            zzadyVar.zzf(objZze);
            if (this.zzb == this.zzc) {
                return objZze;
            }
            throw zzacp.zzg();
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzQ(zzady zzadyVar, zzabu zzabuVar) throws IOException {
        int iZze = ((zzabg) this.zza).zze();
        zzabi zzabiVar = this.zza;
        if (zzabiVar.zza >= zzabiVar.zzb) {
            throw new zzacp("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzc = zzabiVar.zzc(iZze);
        Object objZze = zzadyVar.zze();
        this.zza.zza++;
        zzadyVar.zzh(objZze, this, zzabuVar);
        zzadyVar.zzf(objZze);
        this.zza.zzm(0);
        r5.zza--;
        this.zza.zzn(iZzc);
        return objZze;
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzb() != i) {
            throw zzacp.zzi();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzacp.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzacp.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzacp.zzg();
        }
    }

    public static zzabj zzq(zzabi zzabiVar) {
        zzabj zzabjVar = zzabiVar.zzc;
        return zzabjVar != null ? zzabjVar : new zzabj(zzabiVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzA(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzadb)) {
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZze = ((zzabg) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Long.valueOf(((zzabg) this.zza).zzg()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabg) this.zza).zzg()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzadb zzadbVar = (zzadb) list;
        int i2 = this.zzb & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZze2 = ((zzabg) this.zza).zze();
            zzU(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzadbVar.zzf(((zzabg) this.zza).zzg());
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        do {
            zzadbVar.zzf(((zzabg) this.zza).zzg());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzB(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzacb)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZze = ((zzabg) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzabg) this.zza).zzd())));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i != 5) {
                throw zzacp.zza();
            }
            do {
                list.add(Float.valueOf(Float.intBitsToFloat(((zzabg) this.zza).zzd())));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzacb zzacbVar = (zzacb) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZze2 = ((zzabg) this.zza).zze();
            zzT(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzacbVar.zze(Float.intBitsToFloat(((zzabg) this.zza).zzd()));
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        if (i2 != 5) {
            throw zzacp.zza();
        }
        do {
            zzacbVar.zze(Float.intBitsToFloat(((zzabg) this.zza).zzd()));
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    @Deprecated
    public final void zzC(List list, zzady zzadyVar, zzabu zzabuVar) throws IOException {
        int iZzf;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzacp.zza();
        }
        do {
            list.add(zzP(zzadyVar, zzabuVar));
            zzabi zzabiVar = this.zza;
            if (zzabiVar.zzp() || this.zzd != 0) {
                return;
            } else {
                iZzf = zzabiVar.zzf();
            }
        } while (iZzf == i);
        this.zzd = iZzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzD(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzaciVar.zzf(((zzabg) this.zza).zze());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzaciVar.zzf(((zzabg) this.zza).zze());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzE(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzadb)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Long.valueOf(((zzabg) this.zza).zzh()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabg) this.zza).zzh()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzadb zzadbVar = (zzadb) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzadbVar.zzf(((zzabg) this.zza).zzh());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzadbVar.zzf(((zzabg) this.zza).zzh());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzF(List list, zzady zzadyVar, zzabu zzabuVar) throws IOException {
        int iZzf;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzacp.zza();
        }
        do {
            list.add(zzQ(zzadyVar, zzabuVar));
            zzabi zzabiVar = this.zza;
            if (zzabiVar.zzp() || this.zzd != 0) {
                return;
            } else {
                iZzf = zzabiVar.zzf();
            }
        } while (iZzf == i);
        this.zzd = iZzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzG(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZze = ((zzabg) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Integer.valueOf(((zzabg) this.zza).zzd()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i != 5) {
                throw zzacp.zza();
            }
            do {
                list.add(Integer.valueOf(((zzabg) this.zza).zzd()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZze2 = ((zzabg) this.zza).zze();
            zzT(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzaciVar.zzf(((zzabg) this.zza).zzd());
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        if (i2 != 5) {
            throw zzacp.zza();
        }
        do {
            zzaciVar.zzf(((zzabg) this.zza).zzd());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzH(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzadb)) {
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZze = ((zzabg) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Long.valueOf(((zzabg) this.zza).zzg()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabg) this.zza).zzg()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzadb zzadbVar = (zzadb) list;
        int i2 = this.zzb & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZze2 = ((zzabg) this.zza).zze();
            zzU(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzadbVar.zzf(((zzabg) this.zza).zzg());
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        do {
            zzadbVar.zzf(((zzabg) this.zza).zzg());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzI(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Integer.valueOf(zzabi.zzs(((zzabg) this.zza).zze())));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Integer.valueOf(zzabi.zzs(((zzabg) this.zza).zze())));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzaciVar.zzf(zzabi.zzs(((zzabg) this.zza).zze()));
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzaciVar.zzf(zzabi.zzs(((zzabg) this.zza).zze()));
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzJ(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzadb)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Long.valueOf(zzabi.zzt(((zzabg) this.zza).zzh())));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Long.valueOf(zzabi.zzt(((zzabg) this.zza).zzh())));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzadb zzadbVar = (zzadb) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzadbVar.zzf(zzabi.zzt(((zzabg) this.zza).zzh()));
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzadbVar.zzf(zzabi.zzt(((zzabg) this.zza).zzh()));
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int iZzf;
        int iZzf2;
        if ((this.zzb & 7) != 2) {
            throw zzacp.zza();
        }
        if (!(list instanceof zzacu) || z) {
            do {
                list.add(z ? zzu() : zzt());
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzacu zzacuVar = (zzacu) list;
        do {
            zzacuVar.zzi(zzp());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzL(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzaciVar.zzf(((zzabg) this.zza).zze());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzaciVar.zzf(((zzabg) this.zza).zze());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzM(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzadb)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Long.valueOf(((zzabg) this.zza).zzh()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabg) this.zza).zzh()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzadb zzadbVar = (zzadb) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzadbVar.zzf(((zzabg) this.zza).zzh());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzadbVar.zzf(((zzabg) this.zza).zzh());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final boolean zzO() throws IOException {
        int i;
        zzabi zzabiVar = this.zza;
        if (zzabiVar.zzp() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzabiVar.zzr(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final double zza() throws IOException {
        zzS(1);
        return Double.longBitsToDouble(((zzabg) this.zza).zzg());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final float zzb() throws IOException {
        zzS(5);
        return Float.intBitsToFloat(((zzabg) this.zza).zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzc() throws IOException {
        int iZzf = this.zzd;
        if (iZzf != 0) {
            this.zzb = iZzf;
            this.zzd = 0;
        } else {
            iZzf = this.zza.zzf();
            this.zzb = iZzf;
        }
        if (iZzf == 0 || iZzf == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzf >>> 3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zze() throws IOException {
        zzS(0);
        return ((zzabg) this.zza).zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzf() throws IOException {
        zzS(5);
        return ((zzabg) this.zza).zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzg() throws IOException {
        zzS(0);
        return ((zzabg) this.zza).zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzh() throws IOException {
        zzS(5);
        return ((zzabg) this.zza).zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzi() throws IOException {
        zzS(0);
        return zzabi.zzs(((zzabg) this.zza).zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final int zzj() throws IOException {
        zzS(0);
        return ((zzabg) this.zza).zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final long zzk() throws IOException {
        zzS(1);
        return ((zzabg) this.zza).zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final long zzl() throws IOException {
        zzS(0);
        return ((zzabg) this.zza).zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final long zzm() throws IOException {
        zzS(1);
        return ((zzabg) this.zza).zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final long zzn() throws IOException {
        zzS(0);
        return zzabi.zzt(((zzabg) this.zza).zzh());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final long zzo() throws IOException {
        zzS(0);
        return ((zzabg) this.zza).zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final zzabe zzp() throws IOException {
        zzS(2);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    @Deprecated
    public final Object zzr(zzady zzadyVar, zzabu zzabuVar) throws IOException {
        zzS(3);
        return zzP(zzadyVar, zzabuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final Object zzs(zzady zzadyVar, zzabu zzabuVar) throws IOException {
        zzS(2);
        return zzQ(zzadyVar, zzabuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final String zzt() throws IOException {
        zzS(2);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final String zzu() throws IOException {
        zzS(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzv(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaat)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Boolean.valueOf(this.zza.zzq()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzq()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaat zzaatVar = (zzaat) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzaatVar.zze(this.zza.zzq());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzaatVar.zze(this.zza.zzq());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzw(List list) throws IOException {
        int iZzf;
        if ((this.zzb & 7) != 2) {
            throw zzacp.zza();
        }
        do {
            list.add(zzp());
            zzabi zzabiVar = this.zza;
            if (zzabiVar.zzp()) {
                return;
            } else {
                iZzf = zzabiVar.zzf();
            }
        } while (iZzf == this.zzb);
        this.zzd = iZzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzx(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzabr)) {
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZze = ((zzabg) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzabg) this.zza).zzg())));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzabg) this.zza).zzg())));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzabr zzabrVar = (zzabr) list;
        int i2 = this.zzb & 7;
        if (i2 != 1) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZze2 = ((zzabg) this.zza).zze();
            zzU(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzabrVar.zze(Double.longBitsToDouble(((zzabg) this.zza).zzg()));
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        do {
            zzabrVar.zze(Double.longBitsToDouble(((zzabg) this.zza).zzg()));
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzy(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzacp.zza();
                }
                int iZzb = this.zza.zzb() + ((zzabg) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabg) this.zza).zze()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 != 0) {
            if (i2 != 2) {
                throw zzacp.zza();
            }
            int iZzb2 = this.zza.zzb() + ((zzabg) this.zza).zze();
            do {
                zzaciVar.zzf(((zzabg) this.zza).zze());
            } while (this.zza.zzb() < iZzb2);
            zzR(iZzb2);
            return;
        }
        do {
            zzaciVar.zzf(((zzabg) this.zza).zze());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadx
    public final void zzz(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (!(list instanceof zzaci)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZze = ((zzabg) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    list.add(Integer.valueOf(((zzabg) this.zza).zzd()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i != 5) {
                throw zzacp.zza();
            }
            do {
                list.add(Integer.valueOf(((zzabg) this.zza).zzd()));
                zzabi zzabiVar = this.zza;
                if (zzabiVar.zzp()) {
                    return;
                } else {
                    iZzf = zzabiVar.zzf();
                }
            } while (iZzf == this.zzb);
            this.zzd = iZzf;
            return;
        }
        zzaci zzaciVar = (zzaci) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZze2 = ((zzabg) this.zza).zze();
            zzT(iZze2);
            int iZzb2 = this.zza.zzb() + iZze2;
            do {
                zzaciVar.zzf(((zzabg) this.zza).zzd());
            } while (this.zza.zzb() < iZzb2);
            return;
        }
        if (i2 != 5) {
            throw zzacp.zza();
        }
        do {
            zzaciVar.zzf(((zzabg) this.zza).zzd());
            zzabi zzabiVar2 = this.zza;
            if (zzabiVar2.zzp()) {
                return;
            } else {
                iZzf2 = zzabiVar2.zzf();
            }
        } while (iZzf2 == this.zzb);
        this.zzd = iZzf2;
    }
}
