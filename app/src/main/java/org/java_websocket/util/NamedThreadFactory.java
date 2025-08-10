package org.java_websocket.util;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String threadPrefix;

    public NamedThreadFactory(String str) {
        this.threadPrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.defaultThreadFactory.newThread(runnable);
        threadNewThread.setName(this.threadPrefix + Constants.FILENAME_SEQUENCE_SEPARATOR + this.threadNumber);
        return threadNewThread;
    }
}
