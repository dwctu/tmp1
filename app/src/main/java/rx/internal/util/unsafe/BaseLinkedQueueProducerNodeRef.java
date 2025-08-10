package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    public static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }

    public final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    public final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
