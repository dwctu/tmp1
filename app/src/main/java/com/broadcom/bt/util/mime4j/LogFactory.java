package com.broadcom.bt.util.mime4j;

/* loaded from: classes.dex */
public final class LogFactory {
    private LogFactory() {
    }

    public static Log getLog(Class cls) {
        return new Log(cls);
    }
}
