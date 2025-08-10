package com.amazonaws.logging;

/* loaded from: classes.dex */
public interface Log {
    void a(Object obj);

    void b(Object obj);

    void c(Object obj, Throwable th);

    void d(Object obj);

    void e(Object obj, Throwable th);

    void f(Object obj, Throwable th);

    void g(Object obj);

    void h(Object obj);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();
}
