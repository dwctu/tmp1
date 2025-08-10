package com.google.firebase.database.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ThreadPoolEventTarget implements EventTarget {
    private final ThreadPoolExecutor executor;

    public ThreadPoolEventTarget(final ThreadFactory threadFactory, final ThreadInitializer threadInitializer) {
        this.executor = new ThreadPoolExecutor(1, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.google.firebase.database.core.ThreadPoolEventTarget.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = threadFactory.newThread(runnable);
                threadInitializer.setName(threadNewThread, "FirebaseDatabaseEventTarget");
                threadInitializer.setDaemon(threadNewThread, true);
                return threadNewThread;
            }
        });
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void postEvent(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
