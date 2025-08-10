package com.koushikdutta.async;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class SelectorWrapper implements Closeable {
    private Selector selector;
    public AtomicBoolean isWaking = new AtomicBoolean(false);
    public Semaphore semaphore = new Semaphore(0);

    public SelectorWrapper(Selector selector) {
        this.selector = selector;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.selector.close();
    }

    public Selector getSelector() {
        return this.selector;
    }

    public boolean isOpen() {
        return this.selector.isOpen();
    }

    public Set<SelectionKey> keys() {
        return this.selector.keys();
    }

    public void select() throws IOException {
        select(0L);
    }

    public int selectNow() throws IOException {
        return this.selector.selectNow();
    }

    public Set<SelectionKey> selectedKeys() {
        return this.selector.selectedKeys();
    }

    public boolean waitForSelect() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            try {
                this.semaphore.tryAcquire(10L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }

    public void wakeupOnce() {
        boolean z = !this.semaphore.tryAcquire();
        this.selector.wakeup();
        if (z) {
            return;
        }
        if (this.isWaking.getAndSet(true)) {
            this.selector.wakeup();
            return;
        }
        try {
            waitForSelect();
            this.selector.wakeup();
        } finally {
            this.isWaking.set(false);
        }
    }

    public void select(long j) throws IOException {
        try {
            this.semaphore.drainPermits();
            this.selector.select(j);
        } finally {
            this.semaphore.release(Integer.MAX_VALUE);
        }
    }
}
