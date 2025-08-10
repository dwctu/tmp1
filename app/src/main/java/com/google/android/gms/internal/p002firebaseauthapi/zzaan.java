package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaan;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzaan<MessageType extends zzaao<MessageType, BuilderType>, BuilderType extends zzaan<MessageType, BuilderType>> implements zzadl {
    @Override // 
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public abstract zzaan clone();

    public abstract zzaan zzg(zzaao zzaaoVar);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadl
    public final /* bridge */ /* synthetic */ zzadl zzh(zzadm zzadmVar) {
        if (zzH().getClass().isInstance(zzadmVar)) {
            return zzg((zzaao) zzadmVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
