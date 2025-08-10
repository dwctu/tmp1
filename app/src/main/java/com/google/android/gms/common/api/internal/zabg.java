package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes2.dex */
public abstract class zabg {
    private final zabf zaa;

    public zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    public abstract void zaa();

    public final void zab(zabi zabiVar) {
        Lock lock;
        zabiVar.zai.lock();
        try {
            if (zabiVar.zan != this.zaa) {
                lock = zabiVar.zai;
            } else {
                zaa();
                lock = zabiVar.zai;
            }
            lock.unlock();
        } catch (Throwable th) {
            zabiVar.zai.unlock();
            throw th;
        }
    }
}
