package com.broadcom.bt.util.io.filefilter;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter, com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z = file.length() < this.size;
        return this.acceptLarger ? !z : z;
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION : SimpleComparison.LESS_THAN_OPERATION) + this.size + ")";
    }

    public SizeFileFilter(long j, boolean z) {
        if (j < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j;
        this.acceptLarger = z;
    }
}
