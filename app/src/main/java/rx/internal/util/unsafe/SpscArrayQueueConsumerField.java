package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    public static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
    public long consumerIndex;

    public SpscArrayQueueConsumerField(int i) {
        super(i);
    }
}
