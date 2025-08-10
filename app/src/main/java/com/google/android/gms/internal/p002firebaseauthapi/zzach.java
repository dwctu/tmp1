package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzacd;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzach<MessageType extends zzach<MessageType, BuilderType>, BuilderType extends zzacd<MessageType, BuilderType>> extends zzaao<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    public zzaeq zzc = zzaeq.zzc();
    public int zzd = -1;

    public static Object zzC(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzD(zzadm zzadmVar, String str, Object[] objArr) {
        return new zzadw(zzadmVar, str, objArr);
    }

    public static void zzE(Class cls, zzach zzachVar) {
        zzb.put(cls, zzachVar);
    }

    private static zzach zza(zzach zzachVar) throws zzacp {
        if (zzachVar == null || zzachVar.zzG()) {
            return zzachVar;
        }
        zzacp zzacpVarZza = new zzaeo(zzachVar).zza();
        zzacpVarZza.zzh(zzachVar);
        throw zzacpVarZza;
    }

    private static zzach zzb(zzach zzachVar, byte[] bArr, int i, int i2, zzabu zzabuVar) throws zzacp {
        zzach zzachVar2 = (zzach) zzachVar.zzj(4, null, null);
        try {
            zzady zzadyVarZzb = zzadu.zza().zzb(zzachVar2.getClass());
            zzadyVarZzb.zzi(zzachVar2, bArr, 0, i2, new zzaar(zzabuVar));
            zzadyVarZzb.zzf(zzachVar2);
            if (zzachVar2.zza == 0) {
                return zzachVar2;
            }
            throw new RuntimeException();
        } catch (zzacp e) {
            e.zzh(zzachVar2);
            throw e;
        } catch (zzaeo e2) {
            zzacp zzacpVarZza = e2.zza();
            zzacpVarZza.zzh(zzachVar2);
            throw zzacpVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzacp) {
                throw ((zzacp) e3.getCause());
            }
            zzacp zzacpVar = new zzacp(e3);
            zzacpVar.zzh(zzachVar2);
            throw zzacpVar;
        } catch (IndexOutOfBoundsException unused) {
            zzacp zzacpVarZzi = zzacp.zzi();
            zzacpVarZzi.zzh(zzachVar2);
            throw zzacpVarZzi;
        }
    }

    public static zzach zzv(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzach zzachVar = (zzach) map.get(cls);
        if (zzachVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzachVar = (zzach) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzachVar == null) {
            zzachVar = (zzach) ((zzach) zzaez.zze(cls)).zzj(6, null, null);
            if (zzachVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzachVar);
        }
        return zzachVar;
    }

    public static zzach zzw(zzach zzachVar, zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        zzabi zzabiVarZzh = zzabeVar.zzh();
        zzach zzachVar2 = (zzach) zzachVar.zzj(4, null, null);
        try {
            zzady zzadyVarZzb = zzadu.zza().zzb(zzachVar2.getClass());
            zzadyVarZzb.zzh(zzachVar2, zzabj.zzq(zzabiVarZzh), zzabuVar);
            zzadyVarZzb.zzf(zzachVar2);
            try {
                zzabiVarZzh.zzm(0);
                zza(zzachVar2);
                return zzachVar2;
            } catch (zzacp e) {
                e.zzh(zzachVar2);
                throw e;
            }
        } catch (zzacp e2) {
            e2.zzh(zzachVar2);
            throw e2;
        } catch (zzaeo e3) {
            zzacp zzacpVarZza = e3.zza();
            zzacpVarZza.zzh(zzachVar2);
            throw zzacpVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzacp) {
                throw ((zzacp) e4.getCause());
            }
            zzacp zzacpVar = new zzacp(e4);
            zzacpVar.zzh(zzachVar2);
            throw zzacpVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzacp) {
                throw ((zzacp) e5.getCause());
            }
            throw e5;
        }
    }

    public static zzach zzx(zzach zzachVar, byte[] bArr, zzabu zzabuVar) throws zzacp {
        zzach zzachVarZzb = zzb(zzachVar, bArr, 0, bArr.length, zzabuVar);
        zza(zzachVarZzb);
        return zzachVarZzb;
    }

    public static zzacm zzy() {
        return zzadv.zze();
    }

    public static zzacm zzz(zzacm zzacmVar) {
        int size = zzacmVar.size();
        return zzacmVar.zzd(size == 0 ? 10 : size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzadu.zza().zzb(getClass()).zzj(this, (zzach) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzb = zzadu.zza().zzb(getClass()).zzb(this);
        this.zza = iZzb;
        return iZzb;
    }

    public final String toString() {
        return zzado.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final /* synthetic */ zzadl zzA() {
        return (zzacd) zzj(5, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final /* synthetic */ zzadl zzB() {
        zzacd zzacdVar = (zzacd) zzj(5, null, null);
        zzacdVar.zzj(this);
        return zzacdVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zzF(zzabp zzabpVar) throws IOException {
        zzadu.zza().zzb(getClass()).zzn(this, zzabq.zza(zzabpVar));
    }

    public final boolean zzG() {
        byte bByteValue = ((Byte) zzj(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzadu.zza().zzb(getClass()).zzk(this);
        zzj(2, true != zZzk ? null : this, null);
        return zZzk;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadn
    public final /* synthetic */ zzadm zzH() {
        return (zzach) zzj(6, null, null);
    }

    public abstract Object zzj(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaao
    public final int zzn() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaao
    public final void zzp(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final int zzs() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int iZza = zzadu.zza().zzb(getClass()).zza(this);
        this.zzd = iZza;
        return iZza;
    }

    public final zzacd zzt() {
        return (zzacd) zzj(5, null, null);
    }

    public final zzacd zzu() {
        zzacd zzacdVar = (zzacd) zzj(5, null, null);
        zzacdVar.zzj(this);
        return zzacdVar;
    }
}
