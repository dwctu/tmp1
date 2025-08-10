package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;

/* loaded from: classes3.dex */
public class IdleTimeout extends TimeoutBase {
    public Runnable callback;
    public Object cancellable;

    public IdleTimeout(AsyncServer asyncServer, long j) {
        super(asyncServer, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.handlerish.removeAllCallbacks(this.cancellable);
    }

    public void cancel() {
        this.handlerish.post(new Runnable() { // from class: dc.gb1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    public void reset() {
        this.handlerish.removeAllCallbacks(this.cancellable);
        this.cancellable = this.handlerish.postDelayed(this.callback, this.delay);
    }

    public void setTimeout(Runnable runnable) {
        this.callback = runnable;
    }

    public IdleTimeout(Handler handler, long j) {
        super(handler, j);
    }
}
