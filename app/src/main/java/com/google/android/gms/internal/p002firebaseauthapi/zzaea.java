package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaea {
    private static final Class zza;
    private static final zzaep zzb;
    private static final zzaep zzc;
    private static final zzaep zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzaer();
    }

    public static zzaep zzA() {
        return zzc;
    }

    public static zzaep zzB() {
        return zzd;
    }

    public static Object zzC(int i, List list, zzacl zzaclVar, Object obj, zzaep zzaepVar) {
        if (zzaclVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                if (zzaclVar.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    obj = zzD(i, iIntValue, obj, zzaepVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzaclVar.zza()) {
                    obj = zzD(i, iIntValue2, obj, zzaepVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static Object zzD(int i, int i2, Object obj, zzaep zzaepVar) {
        if (obj == null) {
            obj = zzaepVar.zzf();
        }
        zzaepVar.zzl(obj, i, i2);
        return obj;
    }

    public static void zzE(zzabv zzabvVar, Object obj, Object obj2) {
        zzabvVar.zza(obj2);
        throw null;
    }

    public static void zzF(zzaep zzaepVar, Object obj, Object obj2) {
        zzaepVar.zzo(obj, zzaepVar.zze(zzaepVar.zzd(obj), zzaepVar.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzach.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzI(zzadh zzadhVar, Object obj, Object obj2, long j) {
        zzaez.zzs(obj, j, zzadh.zzc(zzaez.zzf(obj, j), zzaez.zzf(obj2, j)));
    }

    public static void zzJ(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzc(i, list, z);
    }

    public static void zzK(int i, List list, zzabq zzabqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zze(i, list);
    }

    public static void zzL(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzg(i, list, z);
    }

    public static void zzM(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzj(i, list, z);
    }

    public static void zzN(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzl(i, list, z);
    }

    public static void zzO(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzn(i, list, z);
    }

    public static void zzP(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzp(i, list, z);
    }

    public static void zzQ(int i, List list, zzabq zzabqVar, zzady zzadyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzabqVar.zzq(i, list.get(i2), zzadyVar);
        }
    }

    public static void zzR(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzs(i, list, z);
    }

    public static void zzS(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzu(i, list, z);
    }

    public static void zzT(int i, List list, zzabq zzabqVar, zzady zzadyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzabqVar.zzv(i, list.get(i2), zzadyVar);
        }
    }

    public static void zzU(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzx(i, list, z);
    }

    public static void zzV(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzz(i, list, z);
    }

    public static void zzW(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzB(i, list, z);
    }

    public static void zzX(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzD(i, list, z);
    }

    public static void zzY(int i, List list, zzabq zzabqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzG(i, list);
    }

    public static void zzZ(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzI(i, list, z);
    }

    public static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzabp.zzE(i << 3) + 1);
    }

    public static void zzaa(int i, List list, zzabq zzabqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzabqVar.zzK(i, list, z);
    }

    private static zzaep zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzaep) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List list) {
        return list.size();
    }

    public static int zzc(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzD = size * zzabp.zzD(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzD += zzabp.zzw((zzabe) list.get(i2));
        }
        return iZzD;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzabp.zzD(i));
    }

    public static int zze(List list) {
        int iZzy;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            iZzy = 0;
            while (i < size) {
                iZzy += zzabp.zzy(zzaciVar.zze(i));
                i++;
            }
        } else {
            iZzy = 0;
            while (i < size) {
                iZzy += zzabp.zzy(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzy;
    }

    public static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzabp.zzE(i << 3) + 4);
    }

    public static int zzg(List list) {
        return list.size() * 4;
    }

    public static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzabp.zzE(i << 3) + 8);
    }

    public static int zzi(List list) {
        return list.size() * 8;
    }

    public static int zzj(int i, List list, zzady zzadyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzx = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzx += zzabp.zzx(i, (zzadm) list.get(i2), zzadyVar);
        }
        return iZzx;
    }

    public static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzabp.zzD(i));
    }

    public static int zzl(List list) {
        int iZzy;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            iZzy = 0;
            while (i < size) {
                iZzy += zzabp.zzy(zzaciVar.zze(i));
                i++;
            }
        } else {
            iZzy = 0;
            while (i < size) {
                iZzy += zzabp.zzy(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzy;
    }

    public static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzabp.zzD(i));
    }

    public static int zzn(List list) {
        int iZzF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzadb) {
            zzadb zzadbVar = (zzadb) list;
            iZzF = 0;
            while (i < size) {
                iZzF += zzabp.zzF(zzadbVar.zze(i));
                i++;
            }
        } else {
            iZzF = 0;
            while (i < size) {
                iZzF += zzabp.zzF(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzF;
    }

    public static int zzo(int i, Object obj, zzady zzadyVar) {
        if (!(obj instanceof zzacs)) {
            return zzabp.zzE(i << 3) + zzabp.zzA((zzadm) obj, zzadyVar);
        }
        int iZzE = zzabp.zzE(i << 3);
        int iZza = ((zzacs) obj).zza();
        return iZzE + zzabp.zzE(iZza) + iZza;
    }

    public static int zzp(int i, List list, zzady zzadyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzD = zzabp.zzD(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iZzD += obj instanceof zzacs ? zzabp.zzz((zzacs) obj) : zzabp.zzA((zzadm) obj, zzadyVar);
        }
        return iZzD;
    }

    public static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzabp.zzD(i));
    }

    public static int zzr(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            iZzE = 0;
            while (i < size) {
                int iZze = zzaciVar.zze(i);
                iZzE += zzabp.zzE((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzE += zzabp.zzE((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzE;
    }

    public static int zzs(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzabp.zzD(i));
    }

    public static int zzt(List list) {
        int iZzF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzadb) {
            zzadb zzadbVar = (zzadb) list;
            iZzF = 0;
            while (i < size) {
                long jZze = zzadbVar.zze(i);
                iZzF += zzabp.zzF((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzF = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzF += zzabp.zzF((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzF;
    }

    public static int zzu(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzD = zzabp.zzD(i) * size;
        if (list instanceof zzacu) {
            zzacu zzacuVar = (zzacu) list;
            while (i2 < size) {
                Object objZzf = zzacuVar.zzf(i2);
                iZzD += objZzf instanceof zzabe ? zzabp.zzw((zzabe) objZzf) : zzabp.zzC((String) objZzf);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iZzD += obj instanceof zzabe ? zzabp.zzw((zzabe) obj) : zzabp.zzC((String) obj);
                i2++;
            }
        }
        return iZzD;
    }

    public static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzabp.zzD(i));
    }

    public static int zzw(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzabp.zzE(zzaciVar.zze(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzabp.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzE;
    }

    public static int zzx(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzabp.zzD(i));
    }

    public static int zzy(List list) {
        int iZzF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzadb) {
            zzadb zzadbVar = (zzadb) list;
            iZzF = 0;
            while (i < size) {
                iZzF += zzabp.zzF(zzadbVar.zze(i));
                i++;
            }
        } else {
            iZzF = 0;
            while (i < size) {
                iZzF += zzabp.zzF(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzF;
    }

    public static zzaep zzz() {
        return zzb;
    }
}
