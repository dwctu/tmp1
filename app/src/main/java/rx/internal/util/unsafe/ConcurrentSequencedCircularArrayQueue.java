package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    public final long[] sequenceBuffer;

    static {
        if (8 != UnsafeAccess.UNSAFE.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        ELEMENT_SHIFT = ConcurrentCircularArrayQueue.SPARSE_SHIFT + 3;
        ARRAY_BASE = r1.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
    }

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        int i2 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[(i2 << ConcurrentCircularArrayQueue.SPARSE_SHIFT) + 64];
        for (long j = 0; j < i2; j++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j), j);
        }
    }

    public final long calcSequenceOffset(long j) {
        return ARRAY_BASE + ((j & this.mask) << ELEMENT_SHIFT);
    }

    public final long lvSequence(long[] jArr, long j) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j);
    }

    public final void soSequence(long[] jArr, long j, long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j, j2);
    }
}
