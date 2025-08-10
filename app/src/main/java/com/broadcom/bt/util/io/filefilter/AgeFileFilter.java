package com.broadcom.bt.util.io.filefilter;

import com.broadcom.bt.util.io.FileUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter, com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean zIsFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        return this.acceptOlder ? !zIsFileNewer : zIsFileNewer;
    }

    @Override // com.broadcom.bt.util.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptOlder ? SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION : SimpleComparison.GREATER_THAN_OPERATION) + this.cutoff + ")";
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }
}
