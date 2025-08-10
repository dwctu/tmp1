package com.broadcom.bt.util.io.comparator;

import com.broadcom.bt.util.io.FileUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class SizeFileComparator implements Comparator, Serializable {
    public static final Comparator SIZE_COMPARATOR;
    public static final Comparator SIZE_REVERSE;
    public static final Comparator SIZE_SUMDIR_COMPARATOR;
    public static final Comparator SIZE_SUMDIR_REVERSE;
    private final boolean sumDirectoryContents;

    static {
        SizeFileComparator sizeFileComparator = new SizeFileComparator();
        SIZE_COMPARATOR = sizeFileComparator;
        SIZE_REVERSE = new ReverseComparator(sizeFileComparator);
        SizeFileComparator sizeFileComparator2 = new SizeFileComparator(true);
        SIZE_SUMDIR_COMPARATOR = sizeFileComparator2;
        SIZE_SUMDIR_REVERSE = new ReverseComparator(sizeFileComparator2);
    }

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        long jSizeOfDirectory = (file.isDirectory() ? (this.sumDirectoryContents && file.exists()) ? FileUtils.sizeOfDirectory(file) : 0L : file.length()) - (file2.isDirectory() ? (this.sumDirectoryContents && file2.exists()) ? FileUtils.sizeOfDirectory(file2) : 0L : file2.length());
        if (jSizeOfDirectory < 0) {
            return -1;
        }
        return jSizeOfDirectory > 0 ? 1 : 0;
    }

    public SizeFileComparator(boolean z) {
        this.sumDirectoryContents = z;
    }
}
