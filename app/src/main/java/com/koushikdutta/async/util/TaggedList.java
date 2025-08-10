package com.koushikdutta.async.util;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TaggedList<T> extends ArrayList<T> {
    private Object tag;

    public synchronized <V> V tag() {
        return (V) this.tag;
    }

    public synchronized <V> void tagNull(V v) {
        if (this.tag == null) {
            this.tag = v;
        }
    }

    public synchronized <V> void tag(V v) {
        this.tag = v;
    }
}
