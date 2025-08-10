package com.broadcom.bt.util.io.filefilter;

import java.io.File;

/* loaded from: classes.dex */
public abstract class AbstractFileFilter implements IOFileFilter {
    @Override // com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public String toString() {
        String name = getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf > 0 ? name.substring(iLastIndexOf + 1) : name;
    }

    @Override // com.broadcom.bt.util.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }
}
