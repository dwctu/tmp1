package rx.internal.util.unsafe;

import java.util.Objects;
import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    public long p30;
    public long p31;
    public long p32;
    public long p33;
    public long p34;
    public long p35;
    public long p36;
    public long p37;
    public long p40;
    public long p41;
    public long p42;
    public long p43;
    public long p44;
    public long p45;
    public long p46;

    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        long j = this.mask + 1;
        long[] jArr = this.sequenceBuffer;
        long jLvConsumerIndex = Long.MAX_VALUE;
        while (true) {
            long jLvProducerIndex = lvProducerIndex();
            long jCalcSequenceOffset = calcSequenceOffset(jLvProducerIndex);
            long jLvSequence = lvSequence(jArr, jCalcSequenceOffset) - jLvProducerIndex;
            if (jLvSequence == 0) {
                long j2 = jLvProducerIndex + 1;
                if (casProducerIndex(jLvProducerIndex, j2)) {
                    spElement(calcElementOffset(jLvProducerIndex), e);
                    soSequence(jArr, jCalcSequenceOffset, j2);
                    return true;
                }
            } else if (jLvSequence < 0) {
                long j3 = jLvProducerIndex - j;
                if (j3 <= jLvConsumerIndex) {
                    jLvConsumerIndex = lvConsumerIndex();
                    if (j3 <= jLvConsumerIndex) {
                        return false;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        long jLvConsumerIndex;
        E eLpElement;
        do {
            jLvConsumerIndex = lvConsumerIndex();
            eLpElement = lpElement(calcElementOffset(jLvConsumerIndex));
            if (eLpElement != null) {
                break;
            }
        } while (jLvConsumerIndex != lvProducerIndex());
        return eLpElement;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long jLvProducerIndex = -1;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            long jCalcSequenceOffset = calcSequenceOffset(jLvConsumerIndex);
            long j = jLvConsumerIndex + 1;
            long jLvSequence = lvSequence(jArr, jCalcSequenceOffset) - j;
            if (jLvSequence == 0) {
                if (casConsumerIndex(jLvConsumerIndex, j)) {
                    long jCalcElementOffset = calcElementOffset(jLvConsumerIndex);
                    E eLpElement = lpElement(jCalcElementOffset);
                    spElement(jCalcElementOffset, null);
                    soSequence(jArr, jCalcSequenceOffset, jLvConsumerIndex + this.mask + 1);
                    return eLpElement;
                }
            } else if (jLvSequence < 0 && jLvConsumerIndex >= jLvProducerIndex) {
                jLvProducerIndex = lvProducerIndex();
                if (jLvConsumerIndex == jLvProducerIndex) {
                    return null;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long jLvConsumerIndex = lvConsumerIndex();
        while (true) {
            long jLvProducerIndex = lvProducerIndex();
            long jLvConsumerIndex2 = lvConsumerIndex();
            if (jLvConsumerIndex == jLvConsumerIndex2) {
                return (int) (jLvProducerIndex - jLvConsumerIndex2);
            }
            jLvConsumerIndex = jLvConsumerIndex2;
        }
    }
}
