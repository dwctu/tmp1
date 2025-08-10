package com.koushikdutta.async.future;

import com.koushikdutta.async.future.Futures;
import com.koushikdutta.async.future.SimpleFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Futures {
    /* JADX INFO: Access modifiers changed from: private */
    public static <T, F> void loopUntil(final Iterator<F> it, final ThenFutureCallback<T, F> thenFutureCallback, final SimpleFuture<T> simpleFuture, Exception e) {
        while (it.hasNext()) {
            try {
                Future<T> futureThen = thenFutureCallback.then(it.next());
                simpleFuture.getClass();
                futureThen.success(new SuccessCallback() { // from class: dc.w91
                    @Override // com.koushikdutta.async.future.SuccessCallback
                    public final void success(Object obj) {
                        simpleFuture.setComplete((SimpleFuture) obj);
                    }
                }).fail(new FailCallback() { // from class: dc.k91
                    @Override // com.koushikdutta.async.future.FailCallback
                    public final void fail(Exception exc) {
                        Futures.loopUntil(it, thenFutureCallback, simpleFuture, exc);
                    }
                });
                return;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            simpleFuture.setComplete(new Exception("empty list"));
        } else {
            simpleFuture.setComplete(e);
        }
    }

    public static <T> Future<List<T>> waitAll(final List<Future<T>> list) {
        final ArrayList arrayList = new ArrayList();
        final SimpleFuture simpleFuture = new SimpleFuture();
        if (list.isEmpty()) {
            simpleFuture.setComplete((SimpleFuture) arrayList);
            return simpleFuture;
        }
        list.get(0).setCallback(new FutureCallback<T>() { // from class: com.koushikdutta.async.future.Futures.1
            public int count = 0;

            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, T t) {
                arrayList.add(t);
                int i = this.count + 1;
                this.count = i;
                if (i < list.size()) {
                    ((Future) list.get(this.count)).setCallback(this);
                } else {
                    simpleFuture.setComplete((SimpleFuture) arrayList);
                }
            }
        });
        return simpleFuture;
    }

    public static <T, F> Future<T> loopUntil(Iterable<F> iterable, ThenFutureCallback<T, F> thenFutureCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        loopUntil(iterable.iterator(), thenFutureCallback, simpleFuture, null);
        return simpleFuture;
    }

    public static <T> Future<List<T>> waitAll(Future<T>... futureArr) {
        return waitAll(Arrays.asList(futureArr));
    }

    public static <T, F> Future<T> loopUntil(F[] fArr, ThenFutureCallback<T, F> thenFutureCallback) {
        return loopUntil(Arrays.asList(fArr), thenFutureCallback);
    }
}
