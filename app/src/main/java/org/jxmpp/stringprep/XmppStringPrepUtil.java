package org.jxmpp.stringprep;

import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.LruCache;

/* loaded from: classes5.dex */
public class XmppStringPrepUtil {
    private static XmppStringprep xmppStringprep;
    private static final Cache<String, String> NODEPREP_CACHE = new LruCache(100);
    private static final Cache<String, String> DOMAINPREP_CACHE = new LruCache(100);
    private static final Cache<String, String> RESOURCEPREP_CACHE = new LruCache(100);

    public static String domainprep(String str) throws XmppStringprepException {
        if (xmppStringprep == null) {
            return str;
        }
        throwIfEmptyString(str);
        Cache<String, String> cache = DOMAINPREP_CACHE;
        String str2 = cache.get(str);
        if (str2 != null) {
            return str2;
        }
        String strDomainprep = xmppStringprep.domainprep(str);
        cache.put(str, strDomainprep);
        return strDomainprep;
    }

    public static String localprep(String str) throws XmppStringprepException {
        if (xmppStringprep == null) {
            return str;
        }
        throwIfEmptyString(str);
        Cache<String, String> cache = NODEPREP_CACHE;
        String str2 = cache.get(str);
        if (str2 != null) {
            return str2;
        }
        String strLocalprep = xmppStringprep.localprep(str);
        cache.put(str, strLocalprep);
        return strLocalprep;
    }

    public static String resourceprep(String str) throws XmppStringprepException {
        if (xmppStringprep == null) {
            return str;
        }
        throwIfEmptyString(str);
        Cache<String, String> cache = RESOURCEPREP_CACHE;
        String str2 = cache.get(str);
        if (str2 != null) {
            return str2;
        }
        String strResourceprep = xmppStringprep.resourceprep(str);
        cache.put(str, strResourceprep);
        return strResourceprep;
    }

    public static void setMaxCacheSizes(int i) {
        NODEPREP_CACHE.setMaxCacheSize(i);
        DOMAINPREP_CACHE.setMaxCacheSize(i);
        RESOURCEPREP_CACHE.setMaxCacheSize(i);
    }

    public static void setXmppStringprep(XmppStringprep xmppStringprep2) {
        xmppStringprep = xmppStringprep2;
    }

    private static void throwIfEmptyString(String str) throws XmppStringprepException {
        if (str.length() == 0) {
            throw new XmppStringprepException(str, "Argument can't be the empty string");
        }
    }
}
