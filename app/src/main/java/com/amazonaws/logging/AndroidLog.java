package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public class AndroidLog implements Log {
    public final String a;
    public LogFactory.Level b = null;

    public AndroidLog(String str) {
        this.a = str;
    }

    @Override // com.amazonaws.logging.Log
    public void a(Object obj) {
        if (i() == null || i().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void b(Object obj) {
        if (i() == null || i().getValue() <= LogFactory.Level.INFO.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void c(Object obj, Throwable th) {
        if (i() == null || i().getValue() <= LogFactory.Level.ERROR.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void d(Object obj) {
        if (i() == null || i().getValue() <= LogFactory.Level.ERROR.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void e(Object obj, Throwable th) {
        if (i() == null || i().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void f(Object obj, Throwable th) {
        if (i() == null || i().getValue() <= LogFactory.Level.WARN.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void g(Object obj) {
        if (i() == null || i().getValue() <= LogFactory.Level.WARN.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void h(Object obj) {
        if (i() == null || i().getValue() <= LogFactory.Level.TRACE.getValue()) {
            obj.toString();
        }
    }

    public final LogFactory.Level i() {
        LogFactory.Level level = this.b;
        return level != null ? level : LogFactory.a();
    }

    @Override // com.amazonaws.logging.Log
    public boolean isDebugEnabled() {
        return android.util.Log.isLoggable(this.a, 3) && (i() == null || i().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public boolean isErrorEnabled() {
        return android.util.Log.isLoggable(this.a, 6) && (i() == null || i().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public boolean isInfoEnabled() {
        return android.util.Log.isLoggable(this.a, 4) && (i() == null || i().getValue() <= LogFactory.Level.INFO.getValue());
    }
}
