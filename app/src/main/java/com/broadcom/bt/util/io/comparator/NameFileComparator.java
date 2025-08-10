package com.broadcom.bt.util.io.comparator;

import com.broadcom.bt.util.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class NameFileComparator implements Comparator, Serializable {
    public static final Comparator NAME_COMPARATOR;
    public static final Comparator NAME_INSENSITIVE_COMPARATOR;
    public static final Comparator NAME_INSENSITIVE_REVERSE;
    public static final Comparator NAME_REVERSE;
    public static final Comparator NAME_SYSTEM_COMPARATOR;
    public static final Comparator NAME_SYSTEM_REVERSE;
    private final IOCase caseSensitivity;

    static {
        NameFileComparator nameFileComparator = new NameFileComparator();
        NAME_COMPARATOR = nameFileComparator;
        NAME_REVERSE = new ReverseComparator(nameFileComparator);
        NameFileComparator nameFileComparator2 = new NameFileComparator(IOCase.INSENSITIVE);
        NAME_INSENSITIVE_COMPARATOR = nameFileComparator2;
        NAME_INSENSITIVE_REVERSE = new ReverseComparator(nameFileComparator2);
        NameFileComparator nameFileComparator3 = new NameFileComparator(IOCase.SYSTEM);
        NAME_SYSTEM_COMPARATOR = nameFileComparator3;
        NAME_SYSTEM_REVERSE = new ReverseComparator(nameFileComparator3);
    }

    public NameFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.caseSensitivity.checkCompareTo(((File) obj).getName(), ((File) obj2).getName());
    }

    public NameFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }
}
