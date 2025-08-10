package org.jivesoftware.smack.util;

/* loaded from: classes5.dex */
public class Async {
    public static Thread daemonThreadFrom(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public static Thread go(Runnable runnable) {
        Thread threadDaemonThreadFrom = daemonThreadFrom(runnable);
        threadDaemonThreadFrom.start();
        return threadDaemonThreadFrom;
    }

    public static Thread go(Runnable runnable, String str) {
        Thread threadDaemonThreadFrom = daemonThreadFrom(runnable);
        threadDaemonThreadFrom.setName(str);
        threadDaemonThreadFrom.start();
        return threadDaemonThreadFrom;
    }
}
