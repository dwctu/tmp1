package com.koushikdutta.async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AsyncSemaphore {
    public Semaphore semaphore = new Semaphore(0);

    public void acquire() throws InterruptedException {
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.semaphore.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable runnableRemove = orCreateThreadQueue.remove();
                if (runnableRemove == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.semaphore.tryAcquire()) {
                        return;
                    }
                } else {
                    runnableRemove.run();
                }
            }
        } finally {
            orCreateThreadQueue.waiter = asyncSemaphore;
        }
    }

    public void release() {
        this.semaphore.release();
        ThreadQueue.release(this);
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) throws InterruptedException {
        long jConvert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.semaphore.tryAcquire()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable runnableRemove = orCreateThreadQueue.remove();
                if (runnableRemove != null) {
                    runnableRemove.run();
                } else {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), jConvert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.semaphore.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - jCurrentTimeMillis >= jConvert) {
                        return false;
                    }
                }
            }
        } finally {
            orCreateThreadQueue.waiter = asyncSemaphore;
        }
    }
}
