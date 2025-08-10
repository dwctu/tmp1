package com.broadcom.bt.util.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class LastModifiedFileComparator implements Comparator, Serializable {
    public static final Comparator LASTMODIFIED_COMPARATOR;
    public static final Comparator LASTMODIFIED_REVERSE;

    static {
        LastModifiedFileComparator lastModifiedFileComparator = new LastModifiedFileComparator();
        LASTMODIFIED_COMPARATOR = lastModifiedFileComparator;
        LASTMODIFIED_REVERSE = new ReverseComparator(lastModifiedFileComparator);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        long jLastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
        if (jLastModified < 0) {
            return -1;
        }
        return jLastModified > 0 ? 1 : 0;
    }
}
