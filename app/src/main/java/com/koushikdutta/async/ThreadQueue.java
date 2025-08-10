package com.koushikdutta.async;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public class ThreadQueue extends LinkedList<Runnable> {
    private static final WeakHashMap<Thread, ThreadQueue> mThreadQueues = new WeakHashMap<>();
    public Semaphore queueSemaphore = new Semaphore(0);
    public AsyncSemaphore waiter;

    public static ThreadQueue getOrCreateThreadQueue(Thread thread) {
        ThreadQueue threadQueue;
        WeakHashMap<Thread, ThreadQueue> weakHashMap = mThreadQueues;
        synchronized (weakHashMap) {
            threadQueue = weakHashMap.get(thread);
            if (threadQueue == null) {
                threadQueue = new ThreadQueue();
                weakHashMap.put(thread, threadQueue);
            }
        }
        return threadQueue;
    }

    public static void release(AsyncSemaphore asyncSemaphore) {
        WeakHashMap<Thread, ThreadQueue> weakHashMap = mThreadQueues;
        synchronized (weakHashMap) {
            for (ThreadQueue threadQueue : weakHashMap.values()) {
                if (threadQueue.waiter == asyncSemaphore) {
                    threadQueue.queueSemaphore.release();
                }
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        boolean zAdd;
        synchronized (this) {
            zAdd = super.add((ThreadQueue) runnable);
        }
        return zAdd;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this) {
            zRemove = super.remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable remove() {
        synchronized (this) {
            if (isEmpty()) {
                return null;
            }
            return (Runnable) super.remove();
        }
    }
}
