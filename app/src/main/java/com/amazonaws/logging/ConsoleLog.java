package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public final class ConsoleLog implements Log {
    public final String a;
    public LogFactory.Level b = null;

    public ConsoleLog(String str) {
        this.a = str;
    }

    @Override // com.amazonaws.logging.Log
    public void a(Object obj) {
        if (isDebugEnabled()) {
            l(LogFactory.Level.DEBUG, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void b(Object obj) {
        if (isInfoEnabled()) {
            l(LogFactory.Level.INFO, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void c(Object obj, Throwable th) {
        if (isErrorEnabled()) {
            l(LogFactory.Level.ERROR, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void d(Object obj) {
        if (isErrorEnabled()) {
            l(LogFactory.Level.ERROR, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void e(Object obj, Throwable th) {
        if (isDebugEnabled()) {
            l(LogFactory.Level.DEBUG, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void f(Object obj, Throwable th) {
        if (k()) {
            l(LogFactory.Level.WARN, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void g(Object obj) {
        if (k()) {
            l(LogFactory.Level.WARN, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void h(Object obj) {
        if (j()) {
            l(LogFactory.Level.TRACE, obj, null);
        }
    }

    public final LogFactory.Level i() {
        LogFactory.Level level = this.b;
        return level != null ? level : LogFactory.a();
    }

    @Override // com.amazonaws.logging.Log
    public boolean isDebugEnabled() {
        return i() == null || i().getValue() <= LogFactory.Level.DEBUG.getValue();
    }

    @Override // com.amazonaws.logging.Log
    public boolean isErrorEnabled() {
        return i() == null || i().getValue() <= LogFactory.Level.ERROR.getValue();
    }

    @Override // com.amazonaws.logging.Log
    public boolean isInfoEnabled() {
        return i() == null || i().getValue() <= LogFactory.Level.INFO.getValue();
    }

    public boolean j() {
        return i() == null || i().getValue() <= LogFactory.Level.TRACE.getValue();
    }

    public boolean k() {
        return i() == null || i().getValue() <= LogFactory.Level.WARN.getValue();
    }

    public final void l(LogFactory.Level level, Object obj, Throwable th) {
        System.out.printf("%s/%s: %s\n", this.a, level.name(), obj);
        if (th != null) {
            System.out.println(th.toString());
        }
    }
}
