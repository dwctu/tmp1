package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ViewProcessor {
    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE = new NodeFilter.CompleteChildSource() { // from class: com.google.firebase.database.core.view.ViewProcessor.1
        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z) {
            return null;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }
    };
    private final NodeFilter filter;

    /* renamed from: com.google.firebase.database.core.view.ViewProcessor$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType;

        static {
            int[] iArr = new int[Operation.OperationType.values().length];
            $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType = iArr;
            try {
                iArr[Operation.OperationType.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache, List<Change> list) {
            this.viewCache = viewCache;
            this.changes = list;
        }
    }

    public static class WriteTreeCompleteChildSource implements NodeFilter.CompleteChildSource {
        private final Node optCompleteServerCache;
        private final ViewCache viewCache;
        private final WriteTreeRef writes;

        public WriteTreeCompleteChildSource(WriteTreeRef writeTreeRef, ViewCache viewCache, Node node) {
            this.writes = writeTreeRef;
            this.viewCache = viewCache;
            this.optCompleteServerCache = node;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode, boolean z) {
            Node completeServerSnap = this.optCompleteServerCache;
            if (completeServerSnap == null) {
                completeServerSnap = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(completeServerSnap, namedNode, z, index);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            CacheNode eventCache = this.viewCache.getEventCache();
            if (eventCache.isCompleteForChild(childKey)) {
                return eventCache.getNode().getImmediateChild(childKey);
            }
            Node node = this.optCompleteServerCache;
            return this.writes.calcCompleteChild(childKey, node != null ? new CacheNode(IndexedNode.from(node, KeyIndex.getInstance()), true, false) : this.viewCache.getServerCache());
        }
    }

    public ViewProcessor(NodeFilter nodeFilter) {
        this.filter = nodeFilter;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path path, ImmutableTree<Boolean> immutableTree, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        boolean zIsFiltered = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (immutableTree.getValue() == null) {
            CompoundWrite compoundWriteEmptyWrite = CompoundWrite.emptyWrite();
            Iterator<Map.Entry<Path, Boolean>> it = immutableTree.iterator();
            CompoundWrite compoundWriteAddWrite = compoundWriteEmptyWrite;
            while (it.hasNext()) {
                Path key = it.next().getKey();
                Path pathChild = path.child(key);
                if (serverCache.isCompleteForPath(pathChild)) {
                    compoundWriteAddWrite = compoundWriteAddWrite.addWrite(key, serverCache.getNode().getChild(pathChild));
                }
            }
            return applyServerMerge(viewCache, path, compoundWriteAddWrite, writeTreeRef, node, zIsFiltered, childChangeAccumulator);
        }
        if ((path.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(path)) {
            return applyServerOverwrite(viewCache, path, serverCache.getNode().getChild(path), writeTreeRef, node, zIsFiltered, childChangeAccumulator);
        }
        if (!path.isEmpty()) {
            return viewCache;
        }
        CompoundWrite compoundWriteEmptyWrite2 = CompoundWrite.emptyWrite();
        CompoundWrite compoundWriteAddWrite2 = compoundWriteEmptyWrite2;
        for (NamedNode namedNode : serverCache.getNode()) {
            compoundWriteAddWrite2 = compoundWriteAddWrite2.addWrite(namedNode.getName(), namedNode.getNode());
        }
        return applyServerMerge(viewCache, path, compoundWriteAddWrite2, writeTreeRef, node, zIsFiltered, childChangeAccumulator);
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        Utilities.hardAssert(compoundWrite.rootWrite() == null, "Can't have a merge that is an overwrite");
        CompoundWrite compoundWriteAddWrites = path.isEmpty() ? compoundWrite : CompoundWrite.emptyWrite().addWrites(path, compoundWrite);
        Node node2 = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> mapChildCompoundWrites = compoundWriteAddWrites.childCompoundWrites();
        ViewCache viewCacheApplyServerOverwrite = viewCache;
        for (Map.Entry<ChildKey, CompoundWrite> entry : mapChildCompoundWrites.entrySet()) {
            ChildKey key = entry.getKey();
            if (node2.hasChild(key)) {
                viewCacheApplyServerOverwrite = applyServerOverwrite(viewCacheApplyServerOverwrite, new Path(key), entry.getValue().apply(node2.getImmediateChild(key)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        ViewCache viewCacheApplyServerOverwrite2 = viewCacheApplyServerOverwrite;
        for (Map.Entry<ChildKey, CompoundWrite> entry2 : mapChildCompoundWrites.entrySet()) {
            ChildKey key2 = entry2.getKey();
            boolean z2 = !viewCache.getServerCache().isCompleteForChild(key2) && entry2.getValue().rootWrite() == null;
            if (!node2.hasChild(key2) && !z2) {
                viewCacheApplyServerOverwrite2 = applyServerOverwrite(viewCacheApplyServerOverwrite2, new Path(key2), entry2.getValue().apply(node2.getImmediateChild(key2)), writeTreeRef, node, z, childChangeAccumulator);
            }
        }
        return viewCacheApplyServerOverwrite2;
    }

    private ViewCache applyServerOverwrite(ViewCache viewCache, Path path, Node node, WriteTreeRef writeTreeRef, Node node2, boolean z, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode indexedNodeUpdateChild;
        CacheNode serverCache = viewCache.getServerCache();
        NodeFilter indexedFilter = this.filter;
        if (!z) {
            indexedFilter = indexedFilter.getIndexedFilter();
        }
        boolean z2 = true;
        if (path.isEmpty()) {
            indexedNodeUpdateChild = indexedFilter.updateFullNode(serverCache.getIndexedNode(), IndexedNode.from(node, indexedFilter.getIndex()), null);
        } else {
            if (!indexedFilter.filtersNodes() || serverCache.isFiltered()) {
                ChildKey front = path.getFront();
                if (!serverCache.isCompleteForPath(path) && path.size() > 1) {
                    return viewCache;
                }
                Path pathPopFront = path.popFront();
                Node nodeUpdateChild = serverCache.getNode().getImmediateChild(front).updateChild(pathPopFront, node);
                if (front.isPriorityChildName()) {
                    indexedNodeUpdateChild = indexedFilter.updatePriority(serverCache.getIndexedNode(), nodeUpdateChild);
                } else {
                    indexedNodeUpdateChild = indexedFilter.updateChild(serverCache.getIndexedNode(), front, nodeUpdateChild, pathPopFront, NO_COMPLETE_SOURCE, null);
                }
                if (!serverCache.isFullyInitialized() && !path.isEmpty()) {
                    z2 = false;
                }
                ViewCache viewCacheUpdateServerSnap = viewCache.updateServerSnap(indexedNodeUpdateChild, z2, indexedFilter.filtersNodes());
                return generateEventCacheAfterServerEvent(viewCacheUpdateServerSnap, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, viewCacheUpdateServerSnap, node2), childChangeAccumulator);
            }
            Utilities.hardAssert(!path.isEmpty(), "An empty path should have been caught in the other branch");
            ChildKey front2 = path.getFront();
            indexedNodeUpdateChild = indexedFilter.updateFullNode(serverCache.getIndexedNode(), serverCache.getIndexedNode().updateChild(front2, serverCache.getNode().getImmediateChild(front2).updateChild(path.popFront(), node)), null);
        }
        if (!serverCache.isFullyInitialized()) {
            z2 = false;
        }
        ViewCache viewCacheUpdateServerSnap2 = viewCache.updateServerSnap(indexedNodeUpdateChild, z2, indexedFilter.filtersNodes());
        return generateEventCacheAfterServerEvent(viewCacheUpdateServerSnap2, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, viewCacheUpdateServerSnap2, node2), childChangeAccumulator);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite compoundWrite, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        Utilities.hardAssert(compoundWrite.rootWrite() == null, "Can't have a merge that is an overwrite");
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        ViewCache viewCacheApplyUserOverwrite = viewCache;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            Path pathChild = path.child(next.getKey());
            if (cacheHasChild(viewCache, pathChild.getFront())) {
                viewCacheApplyUserOverwrite = applyUserOverwrite(viewCacheApplyUserOverwrite, pathChild, next.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        Iterator<Map.Entry<Path, Node>> it2 = compoundWrite.iterator();
        ViewCache viewCacheApplyUserOverwrite2 = viewCacheApplyUserOverwrite;
        while (it2.hasNext()) {
            Map.Entry<Path, Node> next2 = it2.next();
            Path pathChild2 = path.child(next2.getKey());
            if (!cacheHasChild(viewCache, pathChild2.getFront())) {
                viewCacheApplyUserOverwrite2 = applyUserOverwrite(viewCacheApplyUserOverwrite2, pathChild2, next2.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        return viewCacheApplyUserOverwrite2;
    }

    private ViewCache applyUserOverwrite(ViewCache viewCache, Path path, Node node, WriteTreeRef writeTreeRef, Node node2, ChildChangeAccumulator childChangeAccumulator) {
        Node node3;
        CacheNode eventCache = viewCache.getEventCache();
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writeTreeRef, viewCache, node2);
        if (path.isEmpty()) {
            return viewCache.updateEventSnap(this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(node, this.filter.getIndex()), childChangeAccumulator), true, this.filter.filtersNodes());
        }
        ChildKey front = path.getFront();
        if (front.isPriorityChildName()) {
            return viewCache.updateEventSnap(this.filter.updatePriority(viewCache.getEventCache().getIndexedNode(), node), eventCache.isFullyInitialized(), eventCache.isFiltered());
        }
        Path pathPopFront = path.popFront();
        Node immediateChild = eventCache.getNode().getImmediateChild(front);
        if (pathPopFront.isEmpty()) {
            node3 = node;
        } else {
            Node completeChild = writeTreeCompleteChildSource.getCompleteChild(front);
            if (completeChild == null) {
                node = EmptyNode.Empty();
            } else if (pathPopFront.getBack().isPriorityChildName() && completeChild.getChild(pathPopFront.getParent()).isEmpty()) {
                node3 = completeChild;
            } else {
                node = completeChild.updateChild(pathPopFront, node);
            }
            node3 = node;
        }
        return !immediateChild.equals(node3) ? viewCache.updateEventSnap(this.filter.updateChild(eventCache.getIndexedNode(), front, node3, pathPopFront, writeTreeCompleteChildSource, childChangeAccumulator), eventCache.isFullyInitialized(), this.filter.filtersNodes()) : viewCache;
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        Node nodeCalcCompleteChild;
        IndexedNode indexedNodeUpdateChild;
        Node nodeCalcCompleteEventCache;
        CacheNode eventCache = viewCache.getEventCache();
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        if (path.isEmpty()) {
            Utilities.hardAssert(viewCache.getServerCache().isFullyInitialized(), "If change path is empty, we must have complete server data");
            if (viewCache.getServerCache().isFiltered()) {
                Node completeServerSnap = viewCache.getCompleteServerSnap();
                if (!(completeServerSnap instanceof ChildrenNode)) {
                    completeServerSnap = EmptyNode.Empty();
                }
                nodeCalcCompleteEventCache = writeTreeRef.calcCompleteEventChildren(completeServerSnap);
            } else {
                nodeCalcCompleteEventCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            indexedNodeUpdateChild = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(nodeCalcCompleteEventCache, this.filter.getIndex()), childChangeAccumulator);
        } else {
            ChildKey front = path.getFront();
            if (front.isPriorityChildName()) {
                Utilities.hardAssert(path.size() == 1, "Can't have a priority with additional path components");
                Node nodeCalcEventCacheAfterServerOverwrite = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                indexedNodeUpdateChild = nodeCalcEventCacheAfterServerOverwrite != null ? this.filter.updatePriority(eventCache.getIndexedNode(), nodeCalcEventCacheAfterServerOverwrite) : eventCache.getIndexedNode();
            } else {
                Path pathPopFront = path.popFront();
                if (eventCache.isCompleteForChild(front)) {
                    Node nodeCalcEventCacheAfterServerOverwrite2 = writeTreeRef.calcEventCacheAfterServerOverwrite(path, eventCache.getNode(), viewCache.getServerCache().getNode());
                    nodeCalcCompleteChild = nodeCalcEventCacheAfterServerOverwrite2 != null ? eventCache.getNode().getImmediateChild(front).updateChild(pathPopFront, nodeCalcEventCacheAfterServerOverwrite2) : eventCache.getNode().getImmediateChild(front);
                } else {
                    nodeCalcCompleteChild = writeTreeRef.calcCompleteChild(front, viewCache.getServerCache());
                }
                Node node = nodeCalcCompleteChild;
                indexedNodeUpdateChild = node != null ? this.filter.updateChild(eventCache.getIndexedNode(), front, node, pathPopFront, completeChildSource, childChangeAccumulator) : eventCache.getIndexedNode();
            }
        }
        return viewCache.updateEventSnap(indexedNodeUpdateChild, eventCache.isFullyInitialized() || path.isEmpty(), this.filter.filtersNodes());
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        CacheNode serverCache = viewCache.getServerCache();
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(serverCache.getIndexedNode(), serverCache.isFullyInitialized() || path.isEmpty(), serverCache.isFiltered()), path, writeTreeRef, NO_COMPLETE_SOURCE, childChangeAccumulator);
    }

    private void maybeAddValueEvent(ViewCache viewCache, ViewCache viewCache2, List<Change> list) {
        CacheNode eventCache = viewCache2.getEventCache();
        if (eventCache.isFullyInitialized()) {
            boolean z = eventCache.getNode().isLeafNode() || eventCache.getNode().isEmpty();
            if (list.isEmpty() && viewCache.getEventCache().isFullyInitialized() && ((!z || eventCache.getNode().equals(viewCache.getCompleteEventSnap())) && eventCache.getNode().getPriority().equals(viewCache.getCompleteEventSnap().getPriority()))) {
                return;
            }
            list.add(Change.valueChange(eventCache.getIndexedNode()));
        }
    }

    public ProcessorResult applyOperation(ViewCache viewCache, Operation operation, WriteTreeRef writeTreeRef, Node node) {
        ViewCache viewCacheApplyServerOverwrite;
        ChildChangeAccumulator childChangeAccumulator = new ChildChangeAccumulator();
        int i = AnonymousClass2.$SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[operation.getType().ordinal()];
        if (i == 1) {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.getSource().isFromUser()) {
                viewCacheApplyServerOverwrite = applyUserOverwrite(viewCache, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, childChangeAccumulator);
            } else {
                Utilities.hardAssert(overwrite.getSource().isFromServer());
                viewCacheApplyServerOverwrite = applyServerOverwrite(viewCache, overwrite.getPath(), overwrite.getSnapshot(), writeTreeRef, node, overwrite.getSource().isTagged() || (viewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty()), childChangeAccumulator);
            }
        } else if (i == 2) {
            Merge merge = (Merge) operation;
            if (merge.getSource().isFromUser()) {
                viewCacheApplyServerOverwrite = applyUserMerge(viewCache, merge.getPath(), merge.getChildren(), writeTreeRef, node, childChangeAccumulator);
            } else {
                Utilities.hardAssert(merge.getSource().isFromServer());
                viewCacheApplyServerOverwrite = applyServerMerge(viewCache, merge.getPath(), merge.getChildren(), writeTreeRef, node, merge.getSource().isTagged() || viewCache.getServerCache().isFiltered(), childChangeAccumulator);
            }
        } else if (i == 3) {
            AckUserWrite ackUserWrite = (AckUserWrite) operation;
            viewCacheApplyServerOverwrite = !ackUserWrite.isRevert() ? ackUserWrite(viewCache, ackUserWrite.getPath(), ackUserWrite.getAffectedTree(), writeTreeRef, node, childChangeAccumulator) : revertUserWrite(viewCache, ackUserWrite.getPath(), writeTreeRef, node, childChangeAccumulator);
        } else {
            if (i != 4) {
                throw new AssertionError("Unknown operation: " + operation.getType());
            }
            viewCacheApplyServerOverwrite = listenComplete(viewCache, operation.getPath(), writeTreeRef, node, childChangeAccumulator);
        }
        ArrayList arrayList = new ArrayList(childChangeAccumulator.getChanges());
        maybeAddValueEvent(viewCache, viewCacheApplyServerOverwrite, arrayList);
        return new ProcessorResult(viewCacheApplyServerOverwrite, arrayList);
    }

    public ViewCache revertUserWrite(ViewCache viewCache, Path path, WriteTreeRef writeTreeRef, Node node, ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writeTreeRef, viewCache, node);
        IndexedNode indexedNode = viewCache.getEventCache().getIndexedNode();
        if (path.isEmpty() || path.getFront().isPriorityChildName()) {
            indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(viewCache.getServerCache().isFullyInitialized() ? writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap()) : writeTreeRef.calcCompleteEventChildren(viewCache.getServerCache().getNode()), this.filter.getIndex()), childChangeAccumulator);
        } else {
            ChildKey front = path.getFront();
            Node nodeCalcCompleteChild = writeTreeRef.calcCompleteChild(front, viewCache.getServerCache());
            if (nodeCalcCompleteChild == null && viewCache.getServerCache().isCompleteForChild(front)) {
                nodeCalcCompleteChild = indexedNode.getNode().getImmediateChild(front);
            }
            Node node2 = nodeCalcCompleteChild;
            if (node2 != null) {
                indexedNode = this.filter.updateChild(indexedNode, front, node2, path.popFront(), writeTreeCompleteChildSource, childChangeAccumulator);
            } else if (node2 == null && viewCache.getEventCache().getNode().hasChild(front)) {
                indexedNode = this.filter.updateChild(indexedNode, front, EmptyNode.Empty(), path.popFront(), writeTreeCompleteChildSource, childChangeAccumulator);
            }
            if (indexedNode.getNode().isEmpty() && viewCache.getServerCache().isFullyInitialized()) {
                Node nodeCalcCompleteEventCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                if (nodeCalcCompleteEventCache.isLeafNode()) {
                    indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(nodeCalcCompleteEventCache, this.filter.getIndex()), childChangeAccumulator);
                }
            }
        }
        return viewCache.updateEventSnap(indexedNode, viewCache.getServerCache().isFullyInitialized() || writeTreeRef.shadowingWrite(Path.getEmptyPath()) != null, this.filter.filtersNodes());
    }
}
