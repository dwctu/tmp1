package com.google.firebase.database.core.utilities;

import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

/* loaded from: classes2.dex */
public class Tree<T> {
    private ChildKey name;
    private TreeNode<T> node;
    private Tree<T> parent;

    public interface TreeFilter<T> {
        boolean filterTreeNode(Tree<T> tree);
    }

    public interface TreeVisitor<T> {
        void visitTree(Tree<T> tree);
    }

    public Tree(ChildKey childKey, Tree<T> tree, TreeNode<T> treeNode) {
        this.name = childKey;
        this.parent = tree;
        this.node = treeNode;
    }

    private void updateChild(ChildKey childKey, Tree<T> tree) {
        boolean zIsEmpty = tree.isEmpty();
        boolean zContainsKey = this.node.children.containsKey(childKey);
        if (zIsEmpty && zContainsKey) {
            this.node.children.remove(childKey);
            updateParents();
        } else {
            if (zIsEmpty || zContainsKey) {
                return;
            }
            this.node.children.put(childKey, tree.node);
            updateParents();
        }
    }

    private void updateParents() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            tree.updateChild(this.name, this);
        }
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter) {
        return forEachAncestor(treeFilter, false);
    }

    public void forEachChild(TreeVisitor<T> treeVisitor) {
        for (Object obj : this.node.children.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            treeVisitor.visitTree(new Tree<>((ChildKey) entry.getKey(), this, (TreeNode) entry.getValue()));
        }
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor) {
        forEachDescendant(treeVisitor, false, false);
    }

    public ChildKey getName() {
        return this.name;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public Path getPath() {
        if (this.parent == null) {
            return this.name != null ? new Path(this.name) : Path.getEmptyPath();
        }
        Utilities.hardAssert(this.name != null);
        return this.parent.getPath().child(this.name);
    }

    public T getValue() {
        return this.node.value;
    }

    public boolean hasChildren() {
        return !this.node.children.isEmpty();
    }

    public boolean isEmpty() {
        TreeNode<T> treeNode = this.node;
        return treeNode.value == null && treeNode.children.isEmpty();
    }

    public TreeNode<T> lastNodeOnPath(Path path) {
        TreeNode<T> treeNode = this.node;
        ChildKey front = path.getFront();
        while (front != null) {
            TreeNode<T> treeNode2 = treeNode.children.containsKey(front) ? treeNode.children.get(front) : null;
            if (treeNode2 == null) {
                return treeNode;
            }
            path = path.popFront();
            TreeNode<T> treeNode3 = treeNode2;
            front = path.getFront();
            treeNode = treeNode3;
        }
        return treeNode;
    }

    public void setValue(T t) {
        this.node.value = t;
        updateParents();
    }

    public Tree<T> subTree(Path path) {
        ChildKey front = path.getFront();
        Tree<T> tree = this;
        while (front != null) {
            Tree<T> tree2 = new Tree<>(front, tree, tree.node.children.containsKey(front) ? tree.node.children.get(front) : new TreeNode<>());
            path = path.popFront();
            front = path.getFront();
            tree = tree2;
        }
        return tree;
    }

    public String toString() {
        return toString("");
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter, boolean z) {
        for (Tree<T> tree = z ? this : this.parent; tree != null; tree = tree.parent) {
            if (treeFilter.filterTreeNode(tree)) {
                return true;
            }
        }
        return false;
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor, boolean z) {
        forEachDescendant(treeVisitor, z, false);
    }

    public String toString(String str) {
        ChildKey childKey = this.name;
        String strAsString = childKey == null ? "<anon>" : childKey.asString();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(strAsString);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(this.node.toString(str + "\t"));
        return sb.toString();
    }

    public void forEachDescendant(final TreeVisitor<T> treeVisitor, boolean z, final boolean z2) {
        if (z && !z2) {
            treeVisitor.visitTree(this);
        }
        forEachChild(new TreeVisitor<T>() { // from class: com.google.firebase.database.core.utilities.Tree.1
            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<T> tree) {
                tree.forEachDescendant(treeVisitor, true, z2);
            }
        });
        if (z && z2) {
            treeVisitor.visitTree(this);
        }
    }

    public Tree() {
        this(null, null, new TreeNode());
    }
}
