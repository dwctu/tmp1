package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes2.dex */
public class CompoundHash {
    private final List<String> hashes;
    private final List<Path> posts;

    public static class CompoundHashBuilder {
        private int currentPathDepth;
        private final SplitStrategy splitStrategy;
        private StringBuilder optHashValueBuilder = null;
        private Stack<ChildKey> currentPath = new Stack<>();
        private int lastLeafDepth = -1;
        private boolean needsComma = true;
        private final List<Path> currentPaths = new ArrayList();
        private final List<String> currentHashes = new ArrayList();

        public CompoundHashBuilder(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
        }

        private void appendKey(StringBuilder sb, ChildKey childKey) {
            sb.append(Utilities.stringHashV2Representation(childKey.asString()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endChild() {
            this.currentPathDepth--;
            if (buildingRange()) {
                this.optHashValueBuilder.append(")");
            }
            this.needsComma = true;
        }

        private void endRange() throws NoSuchAlgorithmException {
            Utilities.hardAssert(buildingRange(), "Can't end range without starting a range!");
            for (int i = 0; i < this.currentPathDepth; i++) {
                this.optHashValueBuilder.append(")");
            }
            this.optHashValueBuilder.append(")");
            Path pathCurrentPath = currentPath(this.lastLeafDepth);
            this.currentHashes.add(Utilities.sha1HexDigest(this.optHashValueBuilder.toString()));
            this.currentPaths.add(pathCurrentPath);
            this.optHashValueBuilder = null;
        }

        private void ensureRange() {
            if (buildingRange()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            this.optHashValueBuilder = sb;
            sb.append("(");
            Iterator<ChildKey> it = currentPath(this.currentPathDepth).iterator();
            while (it.hasNext()) {
                appendKey(this.optHashValueBuilder, it.next());
                this.optHashValueBuilder.append(":(");
            }
            this.needsComma = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void finishHashing() throws NoSuchAlgorithmException {
            Utilities.hardAssert(this.currentPathDepth == 0, "Can't finish hashing in the middle processing a child");
            if (buildingRange()) {
                endRange();
            }
            this.currentHashes.add("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLeaf(LeafNode<?> leafNode) throws NoSuchAlgorithmException {
            ensureRange();
            this.lastLeafDepth = this.currentPathDepth;
            this.optHashValueBuilder.append(leafNode.getHashRepresentation(Node.HashVersion.V2));
            this.needsComma = true;
            if (this.splitStrategy.shouldSplit(this)) {
                endRange();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startChild(ChildKey childKey) {
            ensureRange();
            if (this.needsComma) {
                this.optHashValueBuilder.append(",");
            }
            appendKey(this.optHashValueBuilder, childKey);
            this.optHashValueBuilder.append(":(");
            if (this.currentPathDepth == this.currentPath.size()) {
                this.currentPath.add(childKey);
            } else {
                this.currentPath.set(this.currentPathDepth, childKey);
            }
            this.currentPathDepth++;
            this.needsComma = false;
        }

        public boolean buildingRange() {
            return this.optHashValueBuilder != null;
        }

        public int currentHashLength() {
            return this.optHashValueBuilder.length();
        }

        public Path currentPath() {
            return currentPath(this.currentPathDepth);
        }

        private Path currentPath(int i) {
            ChildKey[] childKeyArr = new ChildKey[i];
            for (int i2 = 0; i2 < i; i2++) {
                childKeyArr[i2] = this.currentPath.get(i2);
            }
            return new Path(childKeyArr);
        }
    }

    public static class SimpleSizeSplitStrategy implements SplitStrategy {
        private final long splitThreshold;

        public SimpleSizeSplitStrategy(Node node) {
            this.splitThreshold = Math.max(512L, (long) Math.sqrt(NodeSizeEstimator.estimateSerializedNodeSize(node) * 100));
        }

        @Override // com.google.firebase.database.snapshot.CompoundHash.SplitStrategy
        public boolean shouldSplit(CompoundHashBuilder compoundHashBuilder) {
            return ((long) compoundHashBuilder.currentHashLength()) > this.splitThreshold && (compoundHashBuilder.currentPath().isEmpty() || !compoundHashBuilder.currentPath().getBack().equals(ChildKey.getPriorityKey()));
        }
    }

    public interface SplitStrategy {
        boolean shouldSplit(CompoundHashBuilder compoundHashBuilder);
    }

    private CompoundHash(List<Path> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.posts = list;
        this.hashes = list2;
    }

    public static CompoundHash fromNode(Node node) {
        return fromNode(node, new SimpleSizeSplitStrategy(node));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processNode(Node node, final CompoundHashBuilder compoundHashBuilder) throws NoSuchAlgorithmException {
        if (node.isLeafNode()) {
            compoundHashBuilder.processLeaf((LeafNode) node);
            return;
        }
        if (node.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        }
        if (node instanceof ChildrenNode) {
            ((ChildrenNode) node).forEachChild(new ChildrenNode.ChildVisitor() { // from class: com.google.firebase.database.snapshot.CompoundHash.1
                @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
                public void visitChild(ChildKey childKey, Node node2) throws NoSuchAlgorithmException {
                    compoundHashBuilder.startChild(childKey);
                    CompoundHash.processNode(node2, compoundHashBuilder);
                    compoundHashBuilder.endChild();
                }
            }, true);
            return;
        }
        throw new IllegalStateException("Expected children node, but got: " + node);
    }

    public List<String> getHashes() {
        return Collections.unmodifiableList(this.hashes);
    }

    public List<Path> getPosts() {
        return Collections.unmodifiableList(this.posts);
    }

    public static CompoundHash fromNode(Node node, SplitStrategy splitStrategy) throws NoSuchAlgorithmException {
        if (node.isEmpty()) {
            return new CompoundHash(Collections.emptyList(), Collections.singletonList(""));
        }
        CompoundHashBuilder compoundHashBuilder = new CompoundHashBuilder(splitStrategy);
        processNode(node, compoundHashBuilder);
        compoundHashBuilder.finishHashing();
        return new CompoundHash(compoundHashBuilder.currentPaths, compoundHashBuilder.currentHashes);
    }
}
