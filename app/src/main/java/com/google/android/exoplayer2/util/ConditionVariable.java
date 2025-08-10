package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public class ConditionVariable {
    private final Clock clock;
    private boolean isOpen;

    public ConditionVariable() {
        this(Clock.DEFAULT);
    }

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public synchronized void blockUninterruptible() {
        boolean z = false;
        while (!this.isOpen) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean close() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }

    public synchronized boolean isOpen() {
        return this.isOpen;
    }

    public synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.clock = clock;
    }

    public synchronized boolean block(long j) throws InterruptedException {
        if (j <= 0) {
            return this.isOpen;
        }
        long jElapsedRealtime = this.clock.elapsedRealtime();
        long j2 = j + jElapsedRealtime;
        if (j2 < jElapsedRealtime) {
            block();
        } else {
            while (!this.isOpen && jElapsedRealtime < j2) {
                wait(j2 - jElapsedRealtime);
                jElapsedRealtime = this.clock.elapsedRealtime();
            }
        }
        return this.isOpen;
    }
}
