package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    public static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    public static final int SPARSE_SHIFT;
    public final E[] buffer;
    public final long mask;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        SPARSE_SHIFT = iIntValue;
        int iArrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            REF_ELEMENT_SHIFT = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            REF_ELEMENT_SHIFT = iIntValue + 3;
        }
        REF_ARRAY_BASE = r2.arrayBaseOffset(Object[].class) + (32 << (REF_ELEMENT_SHIFT - iIntValue));
    }

    public ConcurrentCircularArrayQueue(int i) {
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = iRoundToPowerOfTwo - 1;
        this.buffer = (E[]) new Object[(iRoundToPowerOfTwo << SPARSE_SHIFT) + 64];
    }

    public final long calcElementOffset(long j) {
        return calcElementOffset(j, this.mask);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final E lpElement(long j) {
        return lpElement(this.buffer, j);
    }

    public final E lvElement(long j) {
        return lvElement(this.buffer, j);
    }

    public final void soElement(long j, E e) {
        soElement(this.buffer, j, e);
    }

    public final void spElement(long j, E e) {
        spElement(this.buffer, j, e);
    }

    public final long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }

    public final E lpElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j);
    }

    public final E lvElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j);
    }

    public final void soElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j, e);
    }

    public final void spElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putObject(eArr, j, e);
    }
}
