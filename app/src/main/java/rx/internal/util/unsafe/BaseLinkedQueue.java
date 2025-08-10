package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class BaseLinkedQueue<E> extends BaseLinkedQueueConsumerNodeRef<E> {
    public long p00;
    public long p01;
    public long p02;
    public long p03;
    public long p04;
    public long p05;
    public long p06;
    public long p07;
    public long p30;
    public long p31;
    public long p32;
    public long p33;
    public long p34;
    public long p35;
    public long p36;
    public long p37;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeLvNext;
        LinkedQueueNode<E> linkedQueueNodeLvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> linkedQueueNodeLvProducerNode = lvProducerNode();
        int i = 0;
        while (linkedQueueNodeLvConsumerNode != linkedQueueNodeLvProducerNode && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeLvNext = linkedQueueNodeLvConsumerNode.lvNext();
            } while (linkedQueueNodeLvNext == null);
            i++;
            linkedQueueNodeLvConsumerNode = linkedQueueNodeLvNext;
        }
        return i;
    }
}
