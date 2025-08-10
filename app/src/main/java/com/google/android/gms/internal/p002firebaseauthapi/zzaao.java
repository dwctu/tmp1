package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaan;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzaao<MessageType extends zzaao<MessageType, BuilderType>, BuilderType extends zzaan<MessageType, BuilderType>> implements zzadm {
    public int zza = 0;

    public int zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final zzabe zzo() {
        try {
            int iZzs = zzs();
            zzabe zzabeVar = zzabe.zzb;
            byte[] bArr = new byte[iZzs];
            zzabp zzabpVarZzG = zzabp.zzG(bArr);
            zzF(zzabpVarZzG);
            zzabpVarZzG.zzI();
            return new zzabb(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public void zzp(int i) {
        throw null;
    }

    public final void zzq(OutputStream outputStream) throws IOException {
        zzabp zzabpVarZzH = zzabp.zzH(outputStream, zzabp.zzB(zzs()));
        zzF(zzabpVarZzH);
        zzabpVarZzH.zzN();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final byte[] zzr() {
        try {
            byte[] bArr = new byte[zzs()];
            zzabp zzabpVarZzG = zzabp.zzG(bArr);
            zzF(zzabpVarZzG);
            zzabpVarZzG.zzI();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
