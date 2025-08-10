package com.amazonaws;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class SDKGlobalConfiguration {
    public static final AtomicLong a = new AtomicLong(0);

    public static long a() {
        return a.get();
    }

    public static void b(long j) {
        a.set(j);
    }
}
