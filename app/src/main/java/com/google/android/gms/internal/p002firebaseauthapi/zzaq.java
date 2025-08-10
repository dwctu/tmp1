package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaq implements zzbj {
    private final OutputStream zza;

    private zzaq(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzbj zza(OutputStream outputStream) {
        return new zzaq(outputStream);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final void zzb(zzlq zzlqVar) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final void zzc(zznh zznhVar) throws IOException {
        try {
            zznhVar.zzq(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
