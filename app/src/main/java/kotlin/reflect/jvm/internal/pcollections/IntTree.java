package kotlin.reflect.jvm.internal.pcollections;

/* loaded from: classes4.dex */
public final class IntTree<V> {
    public static final IntTree<Object> EMPTYNODE = new IntTree<>();
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    private IntTree() {
        this.size = 0;
        this.key = 0L;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private long minKey() {
        IntTree<V> intTree = this.left;
        return intTree.size == 0 ? this.key : intTree.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        return (intTree == this.left && intTree2 == this.right) ? this : rebalanced(this.key, this.value, intTree, intTree2);
    }

    private IntTree<V> withKey(long j) {
        return (this.size == 0 || j == this.key) ? this : new IntTree<>(j, this.value, this.left, this.right);
    }

    public V get(long j) {
        if (this.size == 0) {
            return null;
        }
        long j2 = this.key;
        return j < j2 ? this.left.get(j - j2) : j > j2 ? this.right.get(j - j2) : this.value;
    }

    public IntTree<V> minus(long j) {
        if (this.size == 0) {
            return this;
        }
        long j2 = this.key;
        if (j < j2) {
            return rebalanced(this.left.minus(j - j2), this.right);
        }
        if (j > j2) {
            return rebalanced(this.left, this.right.minus(j - j2));
        }
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            IntTree<V> intTree2 = this.right;
            return intTree2.withKey(intTree2.key + j2);
        }
        IntTree<V> intTree3 = this.right;
        if (intTree3.size == 0) {
            return intTree.withKey(intTree.key + j2);
        }
        long jMinKey = intTree3.minKey();
        long j3 = this.key;
        long j4 = jMinKey + j3;
        V v = this.right.get(j4 - j3);
        IntTree<V> intTreeMinus = this.right.minus(j4 - this.key);
        IntTree<V> intTreeWithKey = intTreeMinus.withKey((intTreeMinus.key + this.key) - j4);
        IntTree<V> intTree4 = this.left;
        return rebalanced(j4, v, intTree4.withKey((intTree4.key + this.key) - j4), intTreeWithKey);
    }

    public IntTree<V> plus(long j, V v) {
        if (this.size == 0) {
            return new IntTree<>(j, v, this, this);
        }
        long j2 = this.key;
        return j < j2 ? rebalanced(this.left.plus(j - j2, v), this.right) : j > j2 ? rebalanced(this.left, this.right.plus(j - j2, v)) : v == this.value ? this : new IntTree<>(j, v, this.left, this.right);
    }

    private static <V> IntTree<V> rebalanced(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        int i = ((IntTree) intTree).size;
        int i2 = ((IntTree) intTree2).size;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                IntTree<V> intTree3 = ((IntTree) intTree).left;
                IntTree<V> intTree4 = ((IntTree) intTree).right;
                if (((IntTree) intTree4).size < ((IntTree) intTree3).size * 2) {
                    long j2 = ((IntTree) intTree).key;
                    return new IntTree<>(j2 + j, ((IntTree) intTree).value, intTree3, new IntTree(-j2, v, intTree4.withKey(((IntTree) intTree4).key + j2), intTree2));
                }
                IntTree<V> intTree5 = ((IntTree) intTree4).left;
                IntTree<V> intTree6 = ((IntTree) intTree4).right;
                long j3 = ((IntTree) intTree4).key;
                long j4 = ((IntTree) intTree).key + j3 + j;
                V v2 = ((IntTree) intTree4).value;
                IntTree intTree7 = new IntTree(-j3, ((IntTree) intTree).value, intTree3, intTree5.withKey(((IntTree) intTree5).key + j3));
                long j5 = ((IntTree) intTree).key;
                long j6 = ((IntTree) intTree4).key;
                return new IntTree<>(j4, v2, intTree7, new IntTree((-j5) - j6, v, intTree6.withKey(((IntTree) intTree6).key + j6 + j5), intTree2));
            }
            if (i2 >= i * 5) {
                IntTree<V> intTree8 = ((IntTree) intTree2).left;
                IntTree<V> intTree9 = ((IntTree) intTree2).right;
                if (((IntTree) intTree8).size < ((IntTree) intTree9).size * 2) {
                    long j7 = ((IntTree) intTree2).key;
                    return new IntTree<>(j7 + j, ((IntTree) intTree2).value, new IntTree(-j7, v, intTree, intTree8.withKey(((IntTree) intTree8).key + j7)), intTree9);
                }
                IntTree<V> intTree10 = ((IntTree) intTree8).left;
                IntTree<V> intTree11 = ((IntTree) intTree8).right;
                long j8 = ((IntTree) intTree8).key;
                long j9 = ((IntTree) intTree2).key;
                long j10 = j8 + j9 + j;
                V v3 = ((IntTree) intTree8).value;
                IntTree intTree12 = new IntTree((-j9) - j8, v, intTree, intTree10.withKey(((IntTree) intTree10).key + j8 + j9));
                long j11 = ((IntTree) intTree8).key;
                return new IntTree<>(j10, v3, intTree12, new IntTree(-j11, ((IntTree) intTree2).value, intTree11.withKey(((IntTree) intTree11).key + j11), intTree9));
            }
        }
        return new IntTree<>(j, v, intTree, intTree2);
    }

    private IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j;
        this.value = v;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }
}
