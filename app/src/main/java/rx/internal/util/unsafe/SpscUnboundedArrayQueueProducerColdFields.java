package rx.internal.util.unsafe;

/* compiled from: SpscUnboundedArrayQueue.java */
/* loaded from: classes5.dex */
public abstract class SpscUnboundedArrayQueueProducerColdFields<E> extends SpscUnboundedArrayQueueProducerFields<E> {
    public E[] producerBuffer;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public long producerMask;
}
