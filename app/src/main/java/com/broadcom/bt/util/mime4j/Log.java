package com.broadcom.bt.util.mime4j;

/* loaded from: classes.dex */
public class Log {
    private static final String LOG_TAG = "frameworks/mime4j";

    public Log(Class cls) {
    }

    private static String toString(Object obj, Throwable th) {
        String string = obj == null ? "(null)" : obj.toString();
        if (th == null) {
            return string;
        }
        return string + " " + th.getMessage();
    }

    public void debug(Object obj) {
        if (isDebugEnabled()) {
            toString(obj, null);
        }
    }

    public void error(Object obj) {
        toString(obj, null);
    }

    public void fatal(Object obj) {
        toString(obj, null);
    }

    public void info(Object obj) {
        if (isInfoEnabled()) {
            toString(obj, null);
        }
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isFatalEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isTraceEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public void trace(Object obj) {
        if (isTraceEnabled()) {
            toString(obj, null);
        }
    }

    public void warn(Object obj) {
        toString(obj, null);
    }

    public void error(Object obj, Throwable th) {
        toString(obj, th);
    }

    public void fatal(Object obj, Throwable th) {
        toString(obj, th);
    }

    public void warn(Object obj, Throwable th) {
        toString(obj, th);
    }

    public void debug(Object obj, Throwable th) {
        if (isDebugEnabled()) {
            toString(obj, th);
        }
    }

    public void info(Object obj, Throwable th) {
        if (isInfoEnabled()) {
            toString(obj, th);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (isTraceEnabled()) {
            toString(obj, th);
        }
    }
}
