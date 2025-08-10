package com.koushikdutta.async.future;

import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class FutureThread<T> extends SimpleFuture<T> {
    public FutureThread(FutureRunnable<T> futureRunnable) {
        this(futureRunnable, "FutureThread");
    }

    public FutureThread(ExecutorService executorService, final FutureRunnable<T> futureRunnable) {
        executorService.submit(new Runnable() { // from class: com.koushikdutta.async.future.FutureThread.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FutureThread.this.setComplete((FutureThread) futureRunnable.run());
                } catch (Exception e) {
                    FutureThread.this.setComplete(e);
                }
            }
        });
    }

    public FutureThread(final FutureRunnable<T> futureRunnable, String str) {
        new Thread(new Runnable() { // from class: com.koushikdutta.async.future.FutureThread.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FutureThread.this.setComplete((FutureThread) futureRunnable.run());
                } catch (Exception e) {
                    FutureThread.this.setComplete(e);
                }
            }
        }, str).start();
    }
}
