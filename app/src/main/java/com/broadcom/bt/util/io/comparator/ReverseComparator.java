package com.broadcom.bt.util.io.comparator;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class ReverseComparator implements Comparator, Serializable {
    private final Comparator delegate;

    public ReverseComparator(Comparator comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.delegate = comparator;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.delegate.compare(obj2, obj);
    }
}
