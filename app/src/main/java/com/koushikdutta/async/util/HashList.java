package com.koushikdutta.async.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/* loaded from: classes3.dex */
public class HashList<T> {
    public Hashtable<String, TaggedList<T>> internal = new Hashtable<>();

    public synchronized void add(String str, T t) {
        ArrayList<T> taggedList = get(str);
        if (taggedList == null) {
            taggedList = new TaggedList<>();
            this.internal.put(str, taggedList);
        }
        taggedList.add(t);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean contains(java.lang.String r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            java.util.ArrayList r1 = r0.get(r1)     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto Lf
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L12
            if (r1 <= 0) goto Lf
            r1 = 1
            goto L10
        Lf:
            r1 = 0
        L10:
            monitor-exit(r0)
            return r1
        L12:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.util.HashList.contains(java.lang.String):boolean");
    }

    public synchronized ArrayList<T> get(String str) {
        return this.internal.get(str);
    }

    public Set<String> keySet() {
        return this.internal.keySet();
    }

    public synchronized T pop(String str) {
        TaggedList<T> taggedList = this.internal.get(str);
        if (taggedList == null) {
            return null;
        }
        if (taggedList.size() == 0) {
            return null;
        }
        return taggedList.remove(taggedList.size() - 1);
    }

    public synchronized ArrayList<T> remove(String str) {
        return this.internal.remove(str);
    }

    public synchronized boolean removeItem(String str, T t) {
        TaggedList<T> taggedList = this.internal.get(str);
        if (taggedList == null) {
            return false;
        }
        taggedList.remove(t);
        return taggedList.size() == 0;
    }

    public synchronized int size() {
        return this.internal.size();
    }

    public synchronized <V> V tag(String str) {
        TaggedList<T> taggedList = this.internal.get(str);
        if (taggedList == null) {
            return null;
        }
        return (V) taggedList.tag();
    }

    public synchronized <V> void tag(String str, V v) {
        TaggedList<T> taggedList = this.internal.get(str);
        if (taggedList == null) {
            taggedList = new TaggedList<>();
            this.internal.put(str, taggedList);
        }
        taggedList.tag(v);
    }
}
