package com.wear.network.protocol.cookie.cache;

import dc.ic4;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class SetCookieCache implements CookieCache {
    private Set<IdentifiableCookie> cookies = new HashSet();

    public class SetCookieCacheIterator implements Iterator<ic4> {
        private Iterator<IdentifiableCookie> iterator;

        public SetCookieCacheIterator() {
            this.iterator = SetCookieCache.this.cookies.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ic4 next() {
            return this.iterator.next().getCookie();
        }
    }

    @Override // com.wear.network.protocol.cookie.cache.CookieCache
    public void addAll(Collection<ic4> collection) {
        for (IdentifiableCookie identifiableCookie : IdentifiableCookie.decorateAll(collection)) {
            this.cookies.remove(identifiableCookie);
            this.cookies.add(identifiableCookie);
        }
    }

    @Override // com.wear.network.protocol.cookie.cache.CookieCache
    public void clear() {
        this.cookies.clear();
    }

    @Override // java.lang.Iterable
    public Iterator<ic4> iterator() {
        return new SetCookieCacheIterator();
    }
}
