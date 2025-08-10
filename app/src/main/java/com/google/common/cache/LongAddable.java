package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}
