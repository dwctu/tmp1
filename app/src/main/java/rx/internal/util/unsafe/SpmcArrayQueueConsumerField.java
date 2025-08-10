package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class SpmcArrayQueueConsumerField<E> extends SpmcArrayQueueL2Pad<E> {
    public static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public SpmcArrayQueueConsumerField(int i) {
        super(i);
    }

    public final boolean casHead(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j, j2);
    }

    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }
}
