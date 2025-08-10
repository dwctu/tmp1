package org.jivesoftware.smack.util;

import java.lang.Exception;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class EventManger<K, R, E extends Exception> {
    private final Map<K, Reference<R>> events = new ConcurrentHashMap();

    public interface Callback<E extends Exception> {
        void action() throws Exception;
    }

    public static class Reference<V> {
        public volatile V eventResult;

        private Reference() {
        }
    }

    public R performActionAndWaitForEvent(K k, long j, Callback<E> callback) throws Exception {
        Reference<R> reference = new Reference<>();
        this.events.put(k, reference);
        try {
            synchronized (reference) {
                callback.action();
                reference.wait(j);
            }
            return reference.eventResult;
        } finally {
            this.events.remove(k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean signalEvent(K k, R r) {
        Reference<R> reference = this.events.get(k);
        if (reference == null) {
            return false;
        }
        reference.eventResult = r;
        synchronized (reference) {
            reference.notifyAll();
        }
        return true;
    }
}
