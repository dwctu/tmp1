package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class DataSnapshot {
    private final IndexedNode node;
    private final DatabaseReference query;

    public DataSnapshot(DatabaseReference databaseReference, IndexedNode indexedNode) {
        this.node = indexedNode;
        this.query = databaseReference;
    }

    @NonNull
    public DataSnapshot child(@NonNull String str) {
        return new DataSnapshot(this.query.child(str), IndexedNode.from(this.node.getNode().getChild(new Path(str))));
    }

    public boolean exists() {
        return !this.node.getNode().isEmpty();
    }

    @NonNull
    public Iterable<DataSnapshot> getChildren() {
        final Iterator<NamedNode> it = this.node.iterator();
        return new Iterable<DataSnapshot>() { // from class: com.google.firebase.database.DataSnapshot.1
            @Override // java.lang.Iterable
            public Iterator<DataSnapshot> iterator() {
                return new Iterator<DataSnapshot>() { // from class: com.google.firebase.database.DataSnapshot.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    @NonNull
                    public DataSnapshot next() {
                        NamedNode namedNode = (NamedNode) it.next();
                        return new DataSnapshot(DataSnapshot.this.query.child(namedNode.getName().asString()), IndexedNode.from(namedNode.getNode()));
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return this.node.getNode().getChildCount();
    }

    @Nullable
    public String getKey() {
        return this.query.getKey();
    }

    @Nullable
    public Object getPriority() {
        Object value = this.node.getNode().getPriority().getValue();
        return value instanceof Long ? Double.valueOf(((Long) value).longValue()) : value;
    }

    @NonNull
    public DatabaseReference getRef() {
        return this.query;
    }

    @Nullable
    public Object getValue() {
        return this.node.getNode().getValue();
    }

    public boolean hasChild(@NonNull String str) throws DatabaseException {
        if (this.query.getParent() == null) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return !this.node.getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.node.getNode().getChildCount() > 0;
    }

    public String toString() {
        return "DataSnapshot { key = " + this.query.getKey() + ", value = " + this.node.getNode().getValue(true) + " }";
    }

    @Nullable
    public Object getValue(boolean z) {
        return this.node.getNode().getValue(z);
    }

    @Nullable
    public <T> T getValue(@NonNull Class<T> cls) {
        return (T) CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), cls);
    }

    @Nullable
    public <T> T getValue(@NonNull GenericTypeIndicator<T> genericTypeIndicator) {
        return (T) CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), genericTypeIndicator);
    }
}
