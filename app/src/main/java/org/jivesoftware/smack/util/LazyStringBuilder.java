package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class LazyStringBuilder implements Appendable, CharSequence {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private String cache;
    private final List<CharSequence> list = new ArrayList(20);

    private void invalidateCache() {
        this.cache = null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        String str = this.cache;
        if (str != null) {
            return str.charAt(i);
        }
        for (CharSequence charSequence : this.list) {
            if (i < charSequence.length()) {
                return charSequence.charAt(i);
            }
            i -= charSequence.length();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.CharSequence
    public int length() {
        String str = this.cache;
        if (str != null) {
            return str.length();
        }
        int length = 0;
        Iterator<CharSequence> it = this.list.iterator();
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return toString().subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.cache == null) {
            StringBuilder sb = new StringBuilder(length());
            Iterator<CharSequence> it = this.list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            this.cache = sb.toString();
        }
        return this.cache;
    }

    public LazyStringBuilder append(LazyStringBuilder lazyStringBuilder) {
        this.list.addAll(lazyStringBuilder.list);
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(CharSequence charSequence) {
        this.list.add(charSequence);
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(CharSequence charSequence, int i, int i2) {
        this.list.add(charSequence.subSequence(i, i2));
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(char c) {
        this.list.add(Character.toString(c));
        invalidateCache();
        return this;
    }
}
