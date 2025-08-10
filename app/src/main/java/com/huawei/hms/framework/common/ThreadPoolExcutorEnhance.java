package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableEnhance) {
            String parentName = ((RunnableEnhance) runnable).getParentName();
            int iLastIndexOf = parentName.lastIndexOf(RunnableEnhance.TRANCELOGO);
            if (iLastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, iLastIndexOf + 4);
            }
            String name = thread.getName();
            int iLastIndexOf2 = name.lastIndexOf(RunnableEnhance.TRANCELOGO);
            if (iLastIndexOf2 != -1) {
                name = StringUtils.substring(name, iLastIndexOf2 + 4);
            }
            thread.setName(parentName + RunnableEnhance.TRANCELOGO + name);
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new RunnableEnhance(runnable));
    }
}
