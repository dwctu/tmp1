package org.bouncycastle.util;

/* loaded from: classes5.dex */
public interface Selector extends Cloneable {
    Object clone();

    boolean match(Object obj);
}
