package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.StringNode;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class NodeSizeEstimator {
    private static final int LEAF_PRIORITY_OVERHEAD = 24;

    private static long estimateLeafNodeSize(LeafNode<?> leafNode) {
        long length = 8;
        if (!(leafNode instanceof DoubleNode) && !(leafNode instanceof LongNode)) {
            if (leafNode instanceof BooleanNode) {
                length = 4;
            } else {
                if (!(leafNode instanceof StringNode)) {
                    throw new IllegalArgumentException("Unknown leaf node type: " + leafNode.getClass());
                }
                length = ((String) leafNode.getValue()).length() + 2;
            }
        }
        return leafNode.getPriority().isEmpty() ? length : length + 24 + estimateLeafNodeSize((LeafNode) leafNode.getPriority());
    }

    public static long estimateSerializedNodeSize(Node node) {
        if (node.isEmpty()) {
            return 4L;
        }
        if (node.isLeafNode()) {
            return estimateLeafNodeSize((LeafNode) node);
        }
        Utilities.hardAssert(node instanceof ChildrenNode, "Unexpected node type: " + node.getClass());
        long length = 1;
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            length = length + r5.getName().asString().length() + 4 + estimateSerializedNodeSize(it.next().getNode());
        }
        return !node.getPriority().isEmpty() ? length + 12 + estimateLeafNodeSize((LeafNode) node.getPriority()) : length;
    }

    public static int nodeCount(Node node) {
        int iNodeCount = 0;
        if (node.isEmpty()) {
            return 0;
        }
        if (node.isLeafNode()) {
            return 1;
        }
        Utilities.hardAssert(node instanceof ChildrenNode, "Unexpected node type: " + node.getClass());
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            iNodeCount += nodeCount(it.next().getNode());
        }
        return iNodeCount;
    }
}
