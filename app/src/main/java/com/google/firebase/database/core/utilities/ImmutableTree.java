package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>> {
    private static final ImmutableTree EMPTY;
    private static final ImmutableSortedMap EMPTY_CHILDREN;
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> children;
    private final T value;

    public interface TreeVisitor<T, R> {
        R onNodeValue(Path path, T t, R r);
    }

    static {
        ImmutableSortedMap immutableSortedMapEmptyMap = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
        EMPTY_CHILDREN = immutableSortedMapEmptyMap;
        EMPTY = new ImmutableTree(null, immutableSortedMapEmptyMap);
    }

    public ImmutableTree(T t, ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap) {
        this.value = t;
        this.children = immutableSortedMap;
    }

    public static <V> ImmutableTree<V> emptyInstance() {
        return EMPTY;
    }

    public boolean containsMatchingValue(Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return true;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            if (it.next().getValue().containsMatchingValue(predicate)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImmutableTree.class != obj.getClass()) {
            return false;
        }
        ImmutableTree immutableTree = (ImmutableTree) obj;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap == null ? immutableTree.children != null : !immutableSortedMap.equals(immutableTree.children)) {
            return false;
        }
        T t = this.value;
        T t2 = immutableTree.value;
        return t == null ? t2 == null : t.equals(t2);
    }

    public Path findRootMostMatchingPath(Path path, Predicate<? super T> predicate) {
        ChildKey front;
        ImmutableTree<T> immutableTree;
        Path pathFindRootMostMatchingPath;
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return Path.getEmptyPath();
        }
        if (path.isEmpty() || (immutableTree = this.children.get((front = path.getFront()))) == null || (pathFindRootMostMatchingPath = immutableTree.findRootMostMatchingPath(path.popFront(), predicate)) == null) {
            return null;
        }
        return new Path(front).child(pathFindRootMostMatchingPath);
    }

    public Path findRootMostPathWithValue(Path path) {
        return findRootMostMatchingPath(path, Predicate.TRUE);
    }

    public <R> R fold(R r, TreeVisitor<? super T, R> treeVisitor) {
        return (R) fold(Path.getEmptyPath(), treeVisitor, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void foreach(TreeVisitor<T, Void> treeVisitor) {
        fold(Path.getEmptyPath(), treeVisitor, null);
    }

    public T get(Path path) {
        if (path.isEmpty()) {
            return this.value;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.get(path.popFront());
        }
        return null;
    }

    public ImmutableTree<T> getChild(ChildKey childKey) {
        ImmutableTree<T> immutableTree = this.children.get(childKey);
        return immutableTree != null ? immutableTree : emptyInstance();
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        int iHashCode = (t != null ? t.hashCode() : 0) * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        return iHashCode + (immutableSortedMap != null ? immutableSortedMap.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.value == null && this.children.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Path, T>> iterator() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() { // from class: com.google.firebase.database.core.utilities.ImmutableTree.2
            @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
            public /* bridge */ /* synthetic */ Void onNodeValue(Path path, Object obj, Void r3) {
                return onNodeValue2(path, (Path) obj, r3);
            }

            /* renamed from: onNodeValue, reason: avoid collision after fix types in other method */
            public Void onNodeValue2(Path path, T t, Void r4) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(path, t));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public T leafMostValue(Path path) {
        return leafMostValueMatching(path, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t = this.value;
        T t2 = (t == null || !predicate.evaluate(t)) ? null : this.value;
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.children.get(it.next());
            if (immutableTree == null) {
                return t2;
            }
            T t3 = immutableTree.value;
            if (t3 != null && predicate.evaluate(t3)) {
                t2 = immutableTree.value;
            }
        }
        return t2;
    }

    public ImmutableTree<T> remove(Path path) {
        if (path.isEmpty()) {
            return this.children.isEmpty() ? emptyInstance() : new ImmutableTree<>(null, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree = this.children.get(front);
        if (immutableTree == null) {
            return this;
        }
        ImmutableTree<T> immutableTreeRemove = immutableTree.remove(path.popFront());
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMapRemove = immutableTreeRemove.isEmpty() ? this.children.remove(front) : this.children.insert(front, immutableTreeRemove);
        return (this.value == null && immutableSortedMapRemove.isEmpty()) ? emptyInstance() : new ImmutableTree<>(this.value, immutableSortedMapRemove);
    }

    public T rootMostValue(Path path) {
        return rootMostValueMatching(path, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return this.value;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.children.get(it.next());
            if (immutableTree == null) {
                return null;
            }
            T t2 = immutableTree.value;
            if (t2 != null && predicate.evaluate(t2)) {
                return immutableTree.value;
            }
        }
        return null;
    }

    public ImmutableTree<T> set(Path path, T t) {
        if (path.isEmpty()) {
            return new ImmutableTree<>(t, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTreeEmptyInstance = this.children.get(front);
        if (immutableTreeEmptyInstance == null) {
            immutableTreeEmptyInstance = emptyInstance();
        }
        return new ImmutableTree<>(this.value, this.children.insert(front, immutableTreeEmptyInstance.set(path.popFront(), t)));
    }

    public ImmutableTree<T> setTree(Path path, ImmutableTree<T> immutableTree) {
        if (path.isEmpty()) {
            return immutableTree;
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTreeEmptyInstance = this.children.get(front);
        if (immutableTreeEmptyInstance == null) {
            immutableTreeEmptyInstance = emptyInstance();
        }
        ImmutableTree<T> tree = immutableTreeEmptyInstance.setTree(path.popFront(), immutableTree);
        return new ImmutableTree<>(this.value, tree.isEmpty() ? this.children.remove(front) : this.children.insert(front, tree));
    }

    public ImmutableTree<T> subtree(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        return immutableTree != null ? immutableTree.subtree(path.popFront()) : emptyInstance();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            sb.append(next.getKey().asString());
            sb.append("=");
            sb.append(next.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public Collection<T> values() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() { // from class: com.google.firebase.database.core.utilities.ImmutableTree.1
            @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
            public /* bridge */ /* synthetic */ Void onNodeValue(Path path, Object obj, Void r3) {
                return onNodeValue2(path, (Path) obj, r3);
            }

            /* renamed from: onNodeValue, reason: avoid collision after fix types in other method */
            public Void onNodeValue2(Path path, T t, Void r3) {
                arrayList.add(t);
                return null;
            }
        });
        return arrayList;
    }

    private <R> R fold(Path path, TreeVisitor<? super T, R> treeVisitor, R r) {
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            r = (R) next.getValue().fold(path.child(next.getKey()), treeVisitor, r);
        }
        Object obj = this.value;
        return obj != null ? treeVisitor.onNodeValue(path, obj, r) : r;
    }

    public ImmutableTree(T t) {
        this(t, EMPTY_CHILDREN);
    }
}
