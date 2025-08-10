package com.koushikdutta.async.future;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class Continuation extends SimpleCancellable implements ContinuationCallback, Runnable, Cancellable {
    public CompletedCallback callback;
    public Runnable cancelCallback;
    private boolean inNext;
    public LinkedList<ContinuationCallback> mCallbacks;
    public boolean started;
    private boolean waiting;

    public Continuation() {
        this(null);
    }

    private ContinuationCallback hook(ContinuationCallback continuationCallback) {
        if (continuationCallback instanceof DependentCancellable) {
            ((DependentCancellable) continuationCallback).setParent(this);
        }
        return continuationCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.inNext) {
            return;
        }
        while (this.mCallbacks.size() > 0 && !this.waiting && !isDone() && !isCancelled()) {
            ContinuationCallback continuationCallbackRemove = this.mCallbacks.remove();
            try {
                try {
                    this.inNext = true;
                    this.waiting = true;
                    continuationCallbackRemove.onContinue(this, wrap());
                } catch (Exception e) {
                    reportCompleted(e);
                }
            } finally {
                this.inNext = false;
            }
        }
        if (this.waiting || isDone() || isCancelled()) {
            return;
        }
        reportCompleted(null);
    }

    private CompletedCallback wrap() {
        return new CompletedCallback() { // from class: com.koushikdutta.async.future.Continuation.2
            public boolean mThisCompleted;

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (this.mThisCompleted) {
                    return;
                }
                this.mThisCompleted = true;
                Continuation.this.waiting = false;
                if (exc == null) {
                    Continuation.this.next();
                } else {
                    Continuation.this.reportCompleted(exc);
                }
            }
        };
    }

    public Continuation add(ContinuationCallback continuationCallback) {
        this.mCallbacks.add(hook(continuationCallback));
        return this;
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.cancelCallback;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public CompletedCallback getCallback() {
        return this.callback;
    }

    public Runnable getCancelCallback() {
        return this.cancelCallback;
    }

    public Continuation insert(ContinuationCallback continuationCallback) {
        this.mCallbacks.add(0, hook(continuationCallback));
        return this;
    }

    @Override // com.koushikdutta.async.callback.ContinuationCallback
    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
        setCallback(completedCallback);
        start();
    }

    public void reportCompleted(Exception exc) {
        CompletedCallback completedCallback;
        if (setComplete() && (completedCallback = this.callback) != null) {
            completedCallback.onCompleted(exc);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        start();
    }

    public void setCallback(CompletedCallback completedCallback) {
        this.callback = completedCallback;
    }

    public void setCancelCallback(Runnable runnable) {
        this.cancelCallback = runnable;
    }

    public Continuation start() {
        if (this.started) {
            throw new IllegalStateException("already started");
        }
        this.started = true;
        next();
        return this;
    }

    public Continuation(CompletedCallback completedCallback) {
        this(completedCallback, null);
    }

    public Continuation add(final DependentFuture dependentFuture) {
        dependentFuture.setParent(this);
        add(new ContinuationCallback() { // from class: com.koushikdutta.async.future.Continuation.3
            @Override // com.koushikdutta.async.callback.ContinuationCallback
            public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                dependentFuture.get();
                completedCallback.onCompleted(null);
            }
        });
        return this;
    }

    public void setCancelCallback(final Cancellable cancellable) {
        if (cancellable == null) {
            this.cancelCallback = null;
        } else {
            this.cancelCallback = new Runnable() { // from class: com.koushikdutta.async.future.Continuation.1
                @Override // java.lang.Runnable
                public void run() {
                    cancellable.cancel();
                }
            };
        }
    }

    public Continuation(CompletedCallback completedCallback, Runnable runnable) {
        this.mCallbacks = new LinkedList<>();
        this.cancelCallback = runnable;
        this.callback = completedCallback;
    }
}
