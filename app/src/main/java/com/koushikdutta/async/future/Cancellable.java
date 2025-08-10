package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface Cancellable {
    boolean cancel();

    boolean isCancelled();

    boolean isDone();
}
