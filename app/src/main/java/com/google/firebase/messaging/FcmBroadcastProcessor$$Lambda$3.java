package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$3 implements Executor {
    public static final Executor $instance = new FcmBroadcastProcessor$$Lambda$3();

    private FcmBroadcastProcessor$$Lambda$3() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
