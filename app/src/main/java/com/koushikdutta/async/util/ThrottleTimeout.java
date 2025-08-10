package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.ValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ThrottleTimeout<T> extends TimeoutBase {
    public ValueCallback<List<T>> callback;
    public Object cancellable;
    public ThrottleMode throttleMode;
    public ArrayList<T> values;

    public enum ThrottleMode {
        Collect,
        Meter
    }

    public ThrottleTimeout(AsyncServer asyncServer, long j, ValueCallback<List<T>> valueCallback) {
        super(asyncServer, j);
        this.values = new ArrayList<>();
        this.throttleMode = ThrottleMode.Collect;
        this.callback = valueCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Object obj) {
        this.values.add(obj);
        if (this.throttleMode == ThrottleMode.Collect) {
            this.handlerish.removeAllCallbacks(this.cancellable);
            this.cancellable = this.handlerish.postDelayed(new Runnable() { // from class: dc.hb1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.runCallback();
                }
            }, this.delay);
        } else if (this.cancellable == null) {
            runCallback();
            this.cancellable = this.handlerish.postDelayed(new Runnable() { // from class: dc.hb1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.runCallback();
                }
            }, this.delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCallback() {
        this.cancellable = null;
        ArrayList arrayList = new ArrayList(this.values);
        this.values.clear();
        this.callback.onResult(arrayList);
    }

    public synchronized void postThrottled(final T t) {
        this.handlerish.post(new Runnable() { // from class: dc.ib1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(t);
            }
        });
    }

    public void setCallback(ValueCallback<List<T>> valueCallback) {
        this.callback = valueCallback;
    }

    public void setThrottleMode(ThrottleMode throttleMode) {
        this.throttleMode = throttleMode;
    }

    public ThrottleTimeout(Handler handler, long j, ValueCallback<List<T>> valueCallback) {
        super(handler, j);
        this.values = new ArrayList<>();
        this.throttleMode = ThrottleMode.Collect;
        this.callback = valueCallback;
    }
}
