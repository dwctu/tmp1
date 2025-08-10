package com.wear.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public class ANRWatchDog extends Thread {
    public static int b = -1;
    public static int c;
    public Handler a = new a(this);

    public static class ANRException extends RuntimeException {
        public ANRException() {
            super("应用程序无响应，快来改BUG啊！！");
            setStackTrace(Looper.getMainLooper().getThread().getStackTrace());
        }
    }

    public class a extends Handler {
        public a(ANRWatchDog aNRWatchDog) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ANRWatchDog.c();
            ANRWatchDog.c %= Integer.MAX_VALUE;
        }
    }

    public static /* synthetic */ int c() {
        int i = c;
        c = i + 1;
        return i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        while (true) {
            this.a.sendEmptyMessage(0);
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = c;
            if (i == b) {
                throw new ANRException();
            }
            b = i;
        }
    }
}
