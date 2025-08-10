package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class CacheNode {
    private final boolean filtered;
    private final boolean fullyInitialized;
    private final IndexedNode indexedNode;

    public CacheNode(IndexedNode indexedNode, boolean z, boolean z2) {
        this.indexedNode = indexedNode;
        this.fullyInitialized = z;
        this.filtered = z2;
    }

    public IndexedNode getIndexedNode() {
        return this.indexedNode;
    }

    public Node getNode() {
        return this.indexedNode.getNode();
    }

    public boolean isCompleteForChild(ChildKey childKey) {
        return (isFullyInitialized() && !this.filtered) || this.indexedNode.getNode().hasChild(childKey);
    }

    public boolean isCompleteForPath(Path path) {
        return path.isEmpty() ? isFullyInitialized() && !this.filtered : isCompleteForChild(path.getFront());
    }

    public boolean isFiltered() {
        return this.filtered;
    }

    public boolean isFullyInitialized() {
        return this.fullyInitialized;
    }
}
