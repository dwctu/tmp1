package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TransferThreadPool {
    public static final Log a = LogFactory.b(TransferService.class);
    public static ExecutorService b;
    public static ExecutorService c;

    public static ExecutorService a(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static synchronized void b(int i) {
        a.a("Initializing the thread pool of size: " + i);
        int iMax = Math.max((int) Math.ceil(((double) i) / 2.0d), 1);
        if (b == null) {
            b = a(iMax);
        }
        if (c == null) {
            c = a(iMax);
        }
    }

    public static <T> Future<T> c(Callable<T> callable) {
        b(TransferUtilityOptions.b());
        return callable instanceof UploadPartTask ? c.submit(callable) : b.submit(callable);
    }
}
