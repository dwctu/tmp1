package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int i) {
        super(i);
    }

    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    public final void svProducerIndexCache(long j) {
        this.producerIndexCache = j;
    }
}
