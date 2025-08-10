package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface DependentCancellable extends Cancellable {
    boolean setParent(Cancellable cancellable);
}
