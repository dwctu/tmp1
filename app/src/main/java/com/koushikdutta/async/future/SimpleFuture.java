package com.koushikdutta.async.future;

import com.koushikdutta.async.AsyncSemaphore;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import dc.z91;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class SimpleFuture<T> extends SimpleCancellable implements DependentFuture<T> {
    private Exception exception;
    private FutureCallbackInternal<T> internalCallback;
    private T result;
    private boolean silent;
    private AsyncSemaphore waiter;

    public interface FutureCallbackInternal<T> {
        void onCompleted(Exception exc, T t, FutureCallsite futureCallsite);
    }

    public static class FutureCallsite {
        public FutureCallbackInternal callback;
        public Exception e;
        public Object result;

        /* JADX WARN: Multi-variable type inference failed */
        public void loop() {
            while (true) {
                FutureCallbackInternal futureCallbackInternal = this.callback;
                if (futureCallbackInternal == 0) {
                    return;
                }
                Exception exc = this.e;
                Object obj = this.result;
                this.callback = null;
                this.e = null;
                this.result = null;
                futureCallbackInternal.onCompleted(exc, obj, this);
            }
        }
    }

    public SimpleFuture() {
    }

    public static /* synthetic */ void a(DoneCallback doneCallback, SimpleFuture simpleFuture, Exception e, Object obj, FutureCallsite futureCallsite) {
        if (e == null) {
            try {
                doneCallback.done(e, obj);
            } catch (Exception e2) {
                e = e2;
            }
        }
        simpleFuture.setComplete(e, obj, futureCallsite);
    }

    public static /* synthetic */ Future b(FailCallback failCallback, Exception exc) throws Exception {
        failCallback.fail(exc);
        return new SimpleFuture((Object) null);
    }

    public static /* synthetic */ Future c(FailConvertCallback failConvertCallback, Exception exc) throws Exception {
        return new SimpleFuture(failConvertCallback.fail(exc));
    }

    private boolean cancelInternal(boolean z) {
        FutureCallbackInternal<T> futureCallbackInternalHandleInternalCompleteLocked;
        if (!super.cancel()) {
            return false;
        }
        synchronized (this) {
            this.exception = new CancellationException();
            releaseWaiterLocked();
            futureCallbackInternalHandleInternalCompleteLocked = handleInternalCompleteLocked();
            this.silent = z;
        }
        handleCallbackUnlocked(null, futureCallbackInternalHandleInternalCompleteLocked);
        return true;
    }

    public static /* synthetic */ void d(SimpleFuture simpleFuture, FailRecoverCallback failRecoverCallback, Exception exc, Object obj, FutureCallsite futureCallsite) {
        if (exc == null) {
            simpleFuture.setComplete(exc, obj, futureCallsite);
            return;
        }
        try {
            simpleFuture.setComplete(failRecoverCallback.fail(exc), futureCallsite);
        } catch (Exception e) {
            simpleFuture.setComplete(e, null, futureCallsite);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(SimpleFuture simpleFuture, Exception exc, Object obj, FutureCallsite futureCallsite) {
        simpleFuture.setComplete(setComplete(exc, obj, futureCallsite) ? null : new CancellationException(), obj, futureCallsite);
    }

    private T getResultOrThrow() throws ExecutionException {
        if (this.exception == null) {
            return this.result;
        }
        throw new ExecutionException(this.exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(SimpleFuture simpleFuture, Exception exc, Object obj) {
        simpleFuture.setComplete((Exception) (setComplete(exc, obj, null) ? null : new CancellationException()));
    }

    private void handleCallbackUnlocked(FutureCallsite futureCallsite, FutureCallbackInternal<T> futureCallbackInternal) {
        if (this.silent || futureCallbackInternal == null) {
            return;
        }
        boolean z = false;
        if (futureCallsite == null) {
            z = true;
            futureCallsite = new FutureCallsite();
        }
        futureCallsite.callback = futureCallbackInternal;
        futureCallsite.e = this.exception;
        futureCallsite.result = this.result;
        if (z) {
            futureCallsite.loop();
        }
    }

    private FutureCallbackInternal<T> handleInternalCompleteLocked() {
        FutureCallbackInternal<T> futureCallbackInternal = this.internalCallback;
        this.internalCallback = null;
        return futureCallbackInternal;
    }

    public static /* synthetic */ void j(SuccessCallback successCallback, SimpleFuture simpleFuture, Exception e, Object obj, FutureCallsite futureCallsite) {
        if (e == null) {
            try {
                successCallback.success(obj);
            } catch (Exception e2) {
                e = e2;
            }
        }
        simpleFuture.setComplete(e, obj, futureCallsite);
    }

    public static /* synthetic */ void k(SimpleFuture simpleFuture, ThenFutureCallback thenFutureCallback, Exception exc, Object obj, FutureCallsite futureCallsite) {
        if (exc != null) {
            simpleFuture.setComplete(exc, null, futureCallsite);
            return;
        }
        try {
            simpleFuture.setComplete(thenFutureCallback.then(obj), futureCallsite);
        } catch (Exception e) {
            simpleFuture.setComplete(e, null, futureCallsite);
        }
    }

    public static /* synthetic */ Future l(ThenCallback thenCallback, Object obj) throws Exception {
        return new SimpleFuture(thenCallback.then(obj));
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return cancel();
    }

    public boolean cancelSilently() {
        return cancelInternal(true);
    }

    @Override // com.koushikdutta.async.future.Future
    public Future<T> done(final DoneCallback<T> doneCallback) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal(null, new FutureCallbackInternal() { // from class: dc.v91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.a(doneCallback, simpleFuture, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    public AsyncSemaphore ensureWaiterLocked() {
        if (this.waiter == null) {
            this.waiter = new AsyncSemaphore();
        }
        return this.waiter;
    }

    @Override // com.koushikdutta.async.future.Future
    public /* synthetic */ Future executorThread(Executor executor) {
        return z91.$default$executorThread(this, executor);
    }

    @Override // com.koushikdutta.async.future.Future
    public Future<T> fail(final FailCallback failCallback) {
        return failRecover(new FailRecoverCallback() { // from class: dc.m91
            @Override // com.koushikdutta.async.future.FailRecoverCallback
            public final Future fail(Exception exc) {
                return SimpleFuture.b(failCallback, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.future.Future
    public Future<T> failConvert(final FailConvertCallback<T> failConvertCallback) {
        return failRecover(new FailRecoverCallback() { // from class: dc.p91
            @Override // com.koushikdutta.async.future.FailRecoverCallback
            public final Future fail(Exception exc) {
                return SimpleFuture.c(failConvertCallback, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.future.Future
    public Future<T> failRecover(final FailRecoverCallback<T> failRecoverCallback) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal(null, new FutureCallbackInternal() { // from class: dc.t91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.d(this.a, failRecoverCallback, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                ensureWaiterLocked().acquire();
                return getResultOrThrow();
            }
            return getResultOrThrow();
        }
    }

    @Deprecated
    public Object getCallback() {
        return this.internalCallback;
    }

    public void releaseWaiterLocked() {
        AsyncSemaphore asyncSemaphore = this.waiter;
        if (asyncSemaphore != null) {
            asyncSemaphore.release();
            this.waiter = null;
        }
    }

    public void setCallback(final FutureCallback<T> futureCallback) {
        if (futureCallback == null) {
            setCallbackInternal(null, null);
        } else {
            setCallbackInternal(null, new FutureCallbackInternal() { // from class: dc.u91
                @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
                public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                    futureCallback.onCompleted(exc, obj);
                }
            });
        }
    }

    public void setCallbackInternal(FutureCallsite futureCallsite, FutureCallbackInternal<T> futureCallbackInternal) {
        synchronized (this) {
            this.internalCallback = futureCallbackInternal;
            if (isDone() || isCancelled()) {
                handleCallbackUnlocked(futureCallsite, handleInternalCompleteLocked());
            }
        }
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable
    public boolean setComplete() {
        return setComplete((SimpleFuture<T>) null);
    }

    public boolean setCompleteException(Exception exc) {
        return setComplete(exc, null, null);
    }

    public Future<T> setCompleteFuture(Future<T> future) {
        return setComplete(future, (FutureCallsite) null);
    }

    public boolean setCompleteValue(T t) {
        return setComplete(null, t, null);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.DependentCancellable
    public boolean setParent(Cancellable cancellable) {
        return super.setParent(cancellable);
    }

    @Override // com.koushikdutta.async.future.Future
    public Future<T> success(final SuccessCallback<T> successCallback) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal(null, new FutureCallbackInternal() { // from class: dc.n91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.j(successCallback, simpleFuture, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    @Override // com.koushikdutta.async.future.Future
    public <R> Future<R> then(final ThenFutureCallback<R, T> thenFutureCallback) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal(null, new FutureCallbackInternal() { // from class: dc.o91
            @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.k(this.a, thenFutureCallback, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    @Override // com.koushikdutta.async.future.Future
    public <R> Future<R> thenConvert(final ThenCallback<R, T> thenCallback) {
        return then(new ThenFutureCallback() { // from class: dc.r91
            @Override // com.koushikdutta.async.future.ThenFutureCallback
            public final Future then(Object obj) {
                return SimpleFuture.l(thenCallback, obj);
            }
        });
    }

    @Override // com.koushikdutta.async.future.Future
    public T tryGet() {
        return this.result;
    }

    @Override // com.koushikdutta.async.future.Future
    public Exception tryGetException() {
        return this.exception;
    }

    public SimpleFuture(T t) {
        setComplete((SimpleFuture<T>) t);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        return cancelInternal(this.silent);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable
    public SimpleFuture<T> reset() {
        super.reset();
        this.result = null;
        this.exception = null;
        this.waiter = null;
        this.internalCallback = null;
        this.silent = false;
        return this;
    }

    public boolean setComplete(Exception exc) {
        return setComplete(exc, null, null);
    }

    public boolean setComplete(T t) {
        return setComplete(null, t, null);
    }

    public SimpleFuture(Exception exc) {
        setComplete(exc);
    }

    public boolean setComplete(Exception exc, T t) {
        return setComplete(exc, t, null);
    }

    private boolean setComplete(Exception exc, T t, FutureCallsite futureCallsite) {
        synchronized (this) {
            if (!super.setComplete()) {
                return false;
            }
            this.result = t;
            this.exception = exc;
            releaseWaiterLocked();
            handleCallbackUnlocked(futureCallsite, handleInternalCompleteLocked());
            return true;
        }
    }

    public SimpleFuture(Future<T> future) {
        setComplete((Future) future);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                AsyncSemaphore asyncSemaphoreEnsureWaiterLocked = ensureWaiterLocked();
                if (asyncSemaphoreEnsureWaiterLocked.tryAcquire(j, timeUnit)) {
                    return getResultOrThrow();
                }
                throw new TimeoutException();
            }
            return getResultOrThrow();
        }
    }

    private Future<T> setComplete(Future<T> future, FutureCallsite futureCallsite) {
        setParent(future);
        final SimpleFuture simpleFuture = new SimpleFuture();
        if (future instanceof SimpleFuture) {
            ((SimpleFuture) future).setCallbackInternal(futureCallsite, new FutureCallbackInternal() { // from class: dc.s91
                @Override // com.koushikdutta.async.future.SimpleFuture.FutureCallbackInternal
                public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite2) {
                    this.a.g(simpleFuture, exc, obj, futureCallsite2);
                }
            });
        } else {
            future.setCallback(new FutureCallback() { // from class: dc.q91
                @Override // com.koushikdutta.async.future.FutureCallback
                public final void onCompleted(Exception exc, Object obj) {
                    this.a.i(simpleFuture, exc, obj);
                }
            });
        }
        return simpleFuture;
    }

    public Future<T> setComplete(Future<T> future) {
        return setComplete(future, (FutureCallsite) null);
    }
}
