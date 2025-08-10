package rx.internal.util;

import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes5.dex */
public class RxRingBuffer implements Subscription {
    public static final int SIZE;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        int i = PlatformDependent.isAndroid() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    private RxRingBuffer(Queue<Object> queue, int i) {
        this.queue = queue;
        this.size = i;
    }

    public static RxRingBuffer getSpmcInstance() {
        return UnsafeAccess.isUnsafeAvailable() ? new RxRingBuffer(true, SIZE) : new RxRingBuffer();
    }

    public static RxRingBuffer getSpscInstance() {
        return UnsafeAccess.isUnsafeAvailable() ? new RxRingBuffer(false, SIZE) : new RxRingBuffer();
    }

    public boolean accept(Object obj, Observer observer) {
        return NotificationLite.accept(observer, obj);
    }

    public Throwable asError(Object obj) {
        return NotificationLite.getError(obj);
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> queue = this.queue;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public Object getValue(Object obj) {
        return NotificationLite.getValue(obj);
    }

    public boolean isCompleted(Object obj) {
        return NotificationLite.isCompleted(obj);
    }

    public boolean isEmpty() {
        Queue<Object> queue = this.queue;
        return queue == null || queue.isEmpty();
    }

    public boolean isError(Object obj) {
        return NotificationLite.isError(obj);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.queue == null;
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.completed();
        }
    }

    public void onError(Throwable th) {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.error(th);
        }
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.queue;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(NotificationLite.next(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public Object peek() {
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                return null;
            }
            Object objPeek = queue.peek();
            Object obj = this.terminalState;
            if (objPeek == null && obj != null && queue.peek() == null) {
                objPeek = obj;
            }
            return objPeek;
        }
    }

    public Object poll() {
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                return null;
            }
            Object objPoll = queue.poll();
            Object obj = this.terminalState;
            if (objPoll == null && obj != null && queue.peek() == null) {
                this.terminalState = null;
                objPoll = obj;
            }
            return objPoll;
        }
    }

    public synchronized void release() {
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        release();
    }

    private RxRingBuffer(boolean z, int i) {
        this.queue = z ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
        this.size = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RxRingBuffer() {
        int i = SIZE;
        this(new SpscAtomicArrayQueue(i), i);
    }
}
