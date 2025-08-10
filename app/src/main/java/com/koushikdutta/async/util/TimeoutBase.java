package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Cancellable;

/* loaded from: classes3.dex */
public class TimeoutBase {
    public long delay;
    public Handlerish handlerish;

    public interface Handlerish {
        void post(Runnable runnable);

        Object postDelayed(Runnable runnable, long j);

        void removeAllCallbacks(Object obj);
    }

    public TimeoutBase(final AsyncServer asyncServer, long j) {
        this.delay = j;
        this.handlerish = new Handlerish() { // from class: com.koushikdutta.async.util.TimeoutBase.1
            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public void post(Runnable runnable) {
                asyncServer.post(runnable);
            }

            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public Object postDelayed(Runnable runnable, long j2) {
                return asyncServer.postDelayed(runnable, j2);
            }

            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public void removeAllCallbacks(Object obj) {
                if (obj == null) {
                    return;
                }
                ((Cancellable) obj).cancel();
            }
        };
    }

    public void onCallback() {
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public TimeoutBase(final Handler handler, long j) {
        this.delay = j;
        this.handlerish = new Handlerish() { // from class: com.koushikdutta.async.util.TimeoutBase.2
            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public void post(Runnable runnable) {
                handler.post(runnable);
            }

            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public Object postDelayed(Runnable runnable, long j2) {
                handler.postDelayed(runnable, j2);
                return runnable;
            }

            @Override // com.koushikdutta.async.util.TimeoutBase.Handlerish
            public void removeAllCallbacks(Object obj) {
                if (obj == null) {
                    return;
                }
                handler.removeCallbacks((Runnable) obj);
            }
        };
    }
}
