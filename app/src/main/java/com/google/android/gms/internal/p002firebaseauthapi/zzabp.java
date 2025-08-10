package com.google.android.gms.internal.p002firebaseauthapi;

import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzabp extends zzaau {
    private static final Logger zza = Logger.getLogger(zzabp.class.getName());
    private static final boolean zzb = zzaez.zzx();
    public zzabq zze;

    private zzabp() {
    }

    public /* synthetic */ zzabp(zzabo zzaboVar) {
    }

    public static int zzA(zzadm zzadmVar, zzady zzadyVar) {
        zzaao zzaaoVar = (zzaao) zzadmVar;
        int iZzn = zzaaoVar.zzn();
        if (iZzn == -1) {
            iZzn = zzadyVar.zza(zzaaoVar);
            zzaaoVar.zzp(iZzn);
        }
        return zzE(iZzn) + iZzn;
    }

    public static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzafe.zzc(str);
        } catch (zzafd unused) {
            length = str.getBytes(zzacn.zzb).length;
        }
        return zzE(length) + length;
    }

    public static int zzD(int i) {
        return zzE(i << 3);
    }

    public static int zzE(int i) {
        if ((i & BluetoothGatt.GATT_NO_RESOURCES) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzF(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzabp zzG(byte[] bArr) {
        return new zzabl(bArr, 0, bArr.length);
    }

    public static zzabp zzH(OutputStream outputStream, int i) {
        return new zzabn(outputStream, i);
    }

    public static int zzw(zzabe zzabeVar) {
        int iZzd = zzabeVar.zzd();
        return zzE(iZzd) + iZzd;
    }

    @Deprecated
    public static int zzx(int i, zzadm zzadmVar, zzady zzadyVar) {
        int iZzE = zzE(i << 3);
        int i2 = iZzE + iZzE;
        zzaao zzaaoVar = (zzaao) zzadmVar;
        int iZzn = zzaaoVar.zzn();
        if (iZzn == -1) {
            iZzn = zzadyVar.zza(zzaaoVar);
            zzaaoVar.zzp(iZzn);
        }
        return i2 + iZzn;
    }

    public static int zzy(int i) {
        if (i >= 0) {
            return zzE(i);
        }
        return 10;
    }

    public static int zzz(zzacs zzacsVar) {
        int iZza = zzacsVar.zza();
        return zzE(iZza) + iZza;
    }

    public final void zzI() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzJ(String str, zzafd zzafdVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzafdVar);
        byte[] bytes = str.getBytes(zzacn.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzabm(e);
        }
    }

    public abstract void zzN() throws IOException;

    public abstract void zzO(byte b) throws IOException;

    public abstract void zzP(int i, boolean z) throws IOException;

    public abstract void zzQ(int i, zzabe zzabeVar) throws IOException;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaau
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(int i, zzadm zzadmVar, zzady zzadyVar) throws IOException;

    public abstract void zzo(int i, String str) throws IOException;

    public abstract void zzq(int i, int i2) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i, long j) throws IOException;

    public abstract void zzu(long j) throws IOException;
}
