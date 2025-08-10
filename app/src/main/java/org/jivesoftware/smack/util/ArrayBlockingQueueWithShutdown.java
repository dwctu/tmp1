package org.jivesoftware.smack.util;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public class ArrayBlockingQueueWithShutdown<E> extends AbstractQueue<E> implements BlockingQueue<E> {
    private int count;
    private volatile boolean isShutdown;
    private final E[] items;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private int putIndex;
    private int takeIndex;

    public class Itr implements Iterator<E> {
        private int lastRet = -1;
        private int nextIndex;
        private E nextItem;

        public Itr() {
            if (ArrayBlockingQueueWithShutdown.this.count == 0) {
                this.nextIndex = -1;
            } else {
                this.nextIndex = ArrayBlockingQueueWithShutdown.this.takeIndex;
                this.nextItem = (E) ArrayBlockingQueueWithShutdown.this.items[ArrayBlockingQueueWithShutdown.this.takeIndex];
            }
        }

        private void checkNext() {
            if (this.nextIndex == ArrayBlockingQueueWithShutdown.this.putIndex) {
                this.nextIndex = -1;
                this.nextItem = null;
                return;
            }
            E e = (E) ArrayBlockingQueueWithShutdown.this.items[this.nextIndex];
            this.nextItem = e;
            if (e == null) {
                this.nextIndex = -1;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i = this.nextIndex;
                if (i < 0) {
                    throw new NoSuchElementException();
                }
                this.lastRet = i;
                E e = this.nextItem;
                this.nextIndex = ArrayBlockingQueueWithShutdown.this.inc(i);
                checkNext();
                return e;
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i = this.lastRet;
                if (i < 0) {
                    throw new IllegalStateException();
                }
                this.lastRet = -1;
                int i2 = ArrayBlockingQueueWithShutdown.this.takeIndex;
                ArrayBlockingQueueWithShutdown.this.removeAt(i);
                if (i == i2) {
                    i = ArrayBlockingQueueWithShutdown.this.takeIndex;
                }
                this.nextIndex = i;
                checkNext();
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }
    }

    public ArrayBlockingQueueWithShutdown(int i) {
        this(i, false);
    }

    private static final void checkNotNull(Object obj) {
        java.util.Objects.requireNonNull(obj);
    }

    private final void checkNotShutdown() throws InterruptedException {
        if (this.isShutdown) {
            throw new InterruptedException();
        }
    }

    private final E extract() {
        E[] eArr = this.items;
        int i = this.takeIndex;
        E e = eArr[i];
        eArr[i] = null;
        this.takeIndex = inc(i);
        this.count--;
        this.notFull.signal();
        return e;
    }

    private final boolean hasElements() {
        return !hasNoElements();
    }

    private final boolean hasNoElements() {
        return this.count == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int inc(int i) {
        int i2 = i + 1;
        if (i2 == this.items.length) {
            return 0;
        }
        return i2;
    }

    private final void insert(E e) {
        E[] eArr = this.items;
        int i = this.putIndex;
        eArr[i] = e;
        this.putIndex = inc(i);
        this.count++;
        this.notEmpty.signal();
    }

    private final boolean isFull() {
        return this.count == this.items.length;
    }

    private final boolean isNotFull() {
        return !isFull();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAt(int i) {
        int i2 = this.takeIndex;
        if (i == i2) {
            this.items[i2] = null;
            this.takeIndex = inc(i2);
        } else {
            while (true) {
                int iInc = inc(i);
                if (iInc == this.putIndex) {
                    break;
                }
                E[] eArr = this.items;
                eArr[i] = eArr[iInc];
                i = iInc;
            }
            this.items[i] = null;
            this.putIndex = i;
        }
        this.count--;
        this.notFull.signal();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        checkNotNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            int iInc = this.takeIndex;
            int i = 0;
            while (i < this.count) {
                collection.add(this.items[iInc]);
                this.items[iInc] = null;
                iInc = inc(iInc);
                i++;
            }
            if (i > 0) {
                this.count = 0;
                this.putIndex = 0;
                this.takeIndex = 0;
                this.notFull.signalAll();
            }
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isShutdown() {
        this.lock.lock();
        try {
            return this.isShutdown;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        this.lock.lock();
        try {
            return new Itr();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        boolean z;
        checkNotNull(e);
        this.lock.lock();
        try {
            if (isFull() || this.isShutdown) {
                z = false;
            } else {
                insert(e);
                z = true;
            }
            return z;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        this.lock.lock();
        try {
            return hasNoElements() ? null : this.items[this.takeIndex];
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        this.lock.lock();
        try {
            return hasNoElements() ? null : extract();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        this.lock.lockInterruptibly();
        while (isFull()) {
            try {
                try {
                    this.notFull.await();
                    checkNotShutdown();
                } catch (InterruptedException e2) {
                    this.notFull.signal();
                    throw e2;
                }
            } finally {
                this.lock.unlock();
            }
        }
        insert(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.items.length - this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public void shutdown() {
        this.lock.lock();
        try {
            this.isShutdown = true;
            this.notEmpty.signalAll();
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        this.lock.lock();
        try {
            return this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public void start() {
        this.lock.lock();
        try {
            this.isShutdown = false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (hasNoElements()) {
                try {
                    this.notEmpty.await();
                    checkNotShutdown();
                } catch (InterruptedException e) {
                    this.notEmpty.signal();
                    throw e;
                }
            }
            return extract();
        } finally {
            this.lock.unlock();
        }
    }

    public ArrayBlockingQueueWithShutdown(int i, boolean z) {
        this.isShutdown = false;
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = (E[]) new Object[i];
        ReentrantLock reentrantLock = new ReentrantLock(z);
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        checkNotNull(e);
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                if (isNotFull()) {
                    insert(e);
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                try {
                    nanos = this.notFull.awaitNanos(nanos);
                    checkNotShutdown();
                } catch (InterruptedException e2) {
                    this.notFull.signal();
                    throw e2;
                }
            } finally {
                this.lock.unlock();
            }
        }
        return z;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E eExtract;
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (true) {
                if (hasElements()) {
                    eExtract = extract();
                    break;
                }
                if (nanos <= 0) {
                    eExtract = null;
                    break;
                }
                try {
                    nanos = this.notEmpty.awaitNanos(nanos);
                    checkNotShutdown();
                } catch (InterruptedException e) {
                    this.notEmpty.signal();
                    throw e;
                }
            }
            return eExtract;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        checkNotNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        if (i <= 0) {
            return 0;
        }
        this.lock.lock();
        try {
            int iInc = this.takeIndex;
            int i3 = this.count;
            if (i >= i3) {
                i = i3;
            }
            while (i2 < i) {
                collection.add(this.items[iInc]);
                this.items[iInc] = null;
                iInc = inc(iInc);
                i2++;
            }
            if (i2 > 0) {
                this.count -= i2;
                this.takeIndex = iInc;
                this.notFull.signalAll();
            }
            return i2;
        } finally {
            this.lock.unlock();
        }
    }
}
