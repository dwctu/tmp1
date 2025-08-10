package com.broadcom.bt.util.io.comparator;

import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class ExtensionFileComparator implements Comparator, Serializable {
    public static final Comparator EXTENSION_COMPARATOR;
    public static final Comparator EXTENSION_INSENSITIVE_COMPARATOR;
    public static final Comparator EXTENSION_INSENSITIVE_REVERSE;
    public static final Comparator EXTENSION_REVERSE;
    public static final Comparator EXTENSION_SYSTEM_COMPARATOR;
    public static final Comparator EXTENSION_SYSTEM_REVERSE;
    private final IOCase caseSensitivity;

    static {
        ExtensionFileComparator extensionFileComparator = new ExtensionFileComparator();
        EXTENSION_COMPARATOR = extensionFileComparator;
        EXTENSION_REVERSE = new ReverseComparator(extensionFileComparator);
        ExtensionFileComparator extensionFileComparator2 = new ExtensionFileComparator(IOCase.INSENSITIVE);
        EXTENSION_INSENSITIVE_COMPARATOR = extensionFileComparator2;
        EXTENSION_INSENSITIVE_REVERSE = new ReverseComparator(extensionFileComparator2);
        ExtensionFileComparator extensionFileComparator3 = new ExtensionFileComparator(IOCase.SYSTEM);
        EXTENSION_SYSTEM_COMPARATOR = extensionFileComparator3;
        EXTENSION_SYSTEM_REVERSE = new ReverseComparator(extensionFileComparator3);
    }

    public ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.caseSensitivity.checkCompareTo(FilenameUtils.getExtension(((File) obj).getName()), FilenameUtils.getExtension(((File) obj2).getName()));
    }

    public ExtensionFileComparator(IOCase iOCase) {
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }
}
