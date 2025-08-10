package com.broadcom.bt.util.io.comparator;

import com.broadcom.bt.util.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class PathFileComparator implements Comparator, Serializable {
    public static final Comparator PATH_COMPARATOR;
    public static final Comparator PATH_INSENSITIVE_COMPARATOR;
    public static final Comparator PATH_INSENSITIVE_REVERSE;
    public static final Comparator PATH_REVERSE;
    public static final Comparator PATH_SYSTEM_COMPARATOR;
    public static final Comparator PATH_SYSTEM_REVERSE;
    private final IOCase caseSensitivity;

    static {
        PathFileComparator pathFileComparator = new PathFileComparator();
        PATH_COMPARATOR = pathFileComparator;
        PATH_REVERSE = new ReverseComparator(pathFileComparator);
        PathFileComparator pathFileComparator2 = new PathFileComparator(IOCase.INSENSITIVE);
        PATH_INSENSITIVE_COMPARATOR = pathFileComparator2;
        PATH_INSENSITIVE_REVERSE = new ReverseComparator(pathFileComparator2);
        PathFileComparator pathFileComparator3 = new PathFileComparator(IOCase.SYSTEM);
        PATH_SYSTEM_COMPARATOR = pathFileComparator3;
        PATH_SYSTEM_REVERSE = new ReverseComparator(pathFileComparator3);
    }

    public PathFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.caseSensitivity.checkCompareTo(((File) obj).getPath(), ((File) obj2).getPath());
    }

    public PathFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }
}
