package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public class SimpleCancellable implements DependentCancellable {
    public boolean cancelled;
    public boolean complete;
    private Cancellable parent;
    public static final Cancellable COMPLETED = new SimpleCancellable() { // from class: com.koushikdutta.async.future.SimpleCancellable.1
        {
            setComplete();
        }
    };
    public static final Cancellable CANCELLED = new SimpleCancellable() { // from class: com.koushikdutta.async.future.SimpleCancellable.2
        {
            cancel();
        }
    };

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        synchronized (this) {
            if (this.complete) {
                return false;
            }
            if (this.cancelled) {
                return true;
            }
            this.cancelled = true;
            Cancellable cancellable = this.parent;
            this.parent = null;
            if (cancellable != null) {
                cancellable.cancel();
            }
            cancelCleanup();
            cleanup();
            return true;
        }
    }

    public void cancelCleanup() {
    }

    public void cleanup() {
    }

    public void completeCleanup() {
    }

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean isCancelled() {
        boolean z;
        Cancellable cancellable;
        synchronized (this) {
            z = this.cancelled || ((cancellable = this.parent) != null && cancellable.isCancelled());
        }
        return z;
    }

    @Override // com.koushikdutta.async.future.Cancellable
    public boolean isDone() {
        return this.complete;
    }

    public Cancellable reset() {
        cancel();
        this.complete = false;
        this.cancelled = false;
        return this;
    }

    public boolean setComplete() {
        synchronized (this) {
            if (this.cancelled) {
                return false;
            }
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.parent = null;
            completeCleanup();
            cleanup();
            return true;
        }
    }

    @Override // com.koushikdutta.async.future.DependentCancellable
    public boolean setParent(Cancellable cancellable) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.parent = cancellable;
            return true;
        }
    }
}
