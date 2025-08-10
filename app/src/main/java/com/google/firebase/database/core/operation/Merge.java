package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class Merge extends Operation {
    private final CompoundWrite children;

    public Merge(OperationSource operationSource, Path path, CompoundWrite compoundWrite) {
        super(Operation.OperationType.Merge, operationSource, path);
        this.children = compoundWrite;
    }

    public CompoundWrite getChildren() {
        return this.children;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation operationForChild(ChildKey childKey) {
        if (!this.path.isEmpty()) {
            if (this.path.getFront().equals(childKey)) {
                return new Merge(this.source, this.path.popFront(), this.children);
            }
            return null;
        }
        CompoundWrite compoundWriteChildCompoundWrite = this.children.childCompoundWrite(new Path(childKey));
        if (compoundWriteChildCompoundWrite.isEmpty()) {
            return null;
        }
        return compoundWriteChildCompoundWrite.rootWrite() != null ? new Overwrite(this.source, Path.getEmptyPath(), compoundWriteChildCompoundWrite.rootWrite()) : new Merge(this.source, Path.getEmptyPath(), compoundWriteChildCompoundWrite);
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", getPath(), getSource(), this.children);
    }
}
