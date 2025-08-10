package com.wear.network.protocol.cookie;

import com.wear.network.protocol.cookie.cache.CookieCache;
import com.wear.network.protocol.cookie.persistence.CookiePersistor;
import dc.ic4;
import dc.rc4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class PersistentCookieJar implements ClearableCookieJar {
    private static final String TAG = "[Cookies]";
    private CookieCache cache;
    private CookiePersistor persistor;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.cache = cookieCache;
        this.persistor = cookiePersistor;
        cookieCache.addAll(cookiePersistor.loadAll());
    }

    private static List<ic4> filterPersistentCookies(List<ic4> list) {
        ArrayList arrayList = new ArrayList();
        for (ic4 ic4Var : list) {
            String str = "=====cookie====" + ic4Var.toString();
            if (ic4Var.q()) {
                arrayList.add(ic4Var);
            }
        }
        return arrayList;
    }

    private static boolean isCookieExpired(ic4 ic4Var) {
        return ic4Var.d() < System.currentTimeMillis();
    }

    @Override // com.wear.network.protocol.cookie.ClearableCookieJar
    public synchronized void clear() {
        this.cache.clear();
        this.persistor.clear();
    }

    @Override // com.wear.network.protocol.cookie.ClearableCookieJar
    public synchronized void clearSession() {
        this.cache.clear();
        this.cache.addAll(this.persistor.loadAll());
    }

    @Override // com.wear.network.protocol.cookie.ClearableCookieJar, dc.jc4
    public synchronized List<ic4> loadForRequest(rc4 rc4Var) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator<ic4> it = this.cache.iterator();
        while (it.hasNext()) {
            ic4 next = it.next();
            if (isCookieExpired(next)) {
                arrayList2.add(next);
                it.remove();
            } else if (next.g(rc4Var)) {
                arrayList.add(next);
            }
        }
        this.persistor.removeAll(arrayList2);
        return arrayList;
    }

    @Override // com.wear.network.protocol.cookie.ClearableCookieJar, dc.jc4
    public synchronized void saveFromResponse(rc4 rc4Var, List<ic4> list) {
        this.cache.addAll(list);
        this.persistor.saveAll(filterPersistentCookies(list));
    }
}
