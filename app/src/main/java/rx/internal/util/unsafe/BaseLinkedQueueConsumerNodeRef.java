package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: classes5.dex */
public abstract class BaseLinkedQueueConsumerNodeRef<E> extends BaseLinkedQueuePad1<E> {
    public static final long C_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode;
    }

    public final LinkedQueueNode<E> lvConsumerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
    }

    public final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
