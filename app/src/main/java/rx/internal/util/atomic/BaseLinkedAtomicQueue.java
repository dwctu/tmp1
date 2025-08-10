package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public abstract class BaseLinkedAtomicQueue<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference<>();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode.get();
    }

    public final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode.get();
    }

    public final LinkedQueueNode<E> lvConsumerNode() {
        return this.consumerNode.get();
    }

    public final LinkedQueueNode<E> lvProducerNode() {
        return this.producerNode.get();
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

    public final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    public final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode.lazySet(linkedQueueNode);
    }

    public final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }
}
