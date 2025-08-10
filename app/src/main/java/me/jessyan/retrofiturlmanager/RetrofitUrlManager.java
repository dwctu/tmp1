package me.jessyan.retrofiturlmanager;

import android.text.TextUtils;
import dc.ad4;
import dc.rc4;
import dc.sc4;
import dc.vc4;
import dc.yc4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.retrofiturlmanager.parser.DefaultUrlParser;
import me.jessyan.retrofiturlmanager.parser.UrlParser;

/* loaded from: classes5.dex */
public class RetrofitUrlManager {
    private static final boolean DEPENDENCY_OKHTTP;
    private static final String DOMAIN_NAME = "Domain-Name";
    public static final String DOMAIN_NAME_HEADER = "Domain-Name: ";
    private static final String GLOBAL_DOMAIN_NAME = "me.jessyan.retrofiturlmanager.globalDomainName";
    public static final String IDENTIFICATION_IGNORE = "#url_ignore";
    public static final String IDENTIFICATION_PATH_SIZE = "#baseurl_path_size=";
    private static final String TAG = "RetrofitUrlManager";
    private rc4 baseUrl;
    private boolean debug;
    private boolean isRun;
    private final Map<String, rc4> mDomainNameHub;
    private final sc4 mInterceptor;
    private final List<onUrlChangeListener> mListeners;
    private UrlParser mUrlParser;
    private int pathSize;

    public static class RetrofitUrlManagerHolder {
        private static final RetrofitUrlManager INSTANCE = new RetrofitUrlManager();

        private RetrofitUrlManagerHolder() {
        }
    }

    static {
        boolean z;
        try {
            Class.forName("dc.vc4");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        DEPENDENCY_OKHTTP = z;
    }

    public static final RetrofitUrlManager getInstance() {
        return RetrofitUrlManagerHolder.INSTANCE;
    }

    private Object[] listenersToArray() {
        Object[] array;
        synchronized (this.mListeners) {
            array = this.mListeners.size() > 0 ? this.mListeners.toArray() : null;
        }
        return array;
    }

    private void notifyListener(yc4 yc4Var, String str, Object[] objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                ((onUrlChangeListener) obj).onUrlChangeBefore(yc4Var.j(), str);
            }
        }
    }

    private String obtainDomainNameFromHeaders(yc4 yc4Var) {
        List<String> listD = yc4Var.d(DOMAIN_NAME);
        if (listD == null || listD.size() == 0) {
            return null;
        }
        if (listD.size() <= 1) {
            return yc4Var.c(DOMAIN_NAME);
        }
        throw new IllegalArgumentException("Only one Domain-Name in the headers");
    }

    private yc4 pruneIdentification(yc4.a aVar, String str) {
        String[] strArrSplit = str.split(IDENTIFICATION_IGNORE);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(str2);
        }
        aVar.k(stringBuffer.toString());
        return aVar.b();
    }

    public void clearAllDomain() {
        this.mDomainNameHub.clear();
    }

    public synchronized int domainSize() {
        return this.mDomainNameHub.size();
    }

    public synchronized rc4 fetchDomain(String str) {
        Utils.checkNotNull(str, "domainName cannot be null");
        return this.mDomainNameHub.get(str);
    }

    public rc4 getBaseUrl() {
        return this.baseUrl;
    }

    public synchronized rc4 getGlobalDomain() {
        return this.mDomainNameHub.get(GLOBAL_DOMAIN_NAME);
    }

    public int getPathSize() {
        return this.pathSize;
    }

    public synchronized boolean haveDomain(String str) {
        return this.mDomainNameHub.containsKey(str);
    }

    public boolean isAdvancedModel() {
        return this.baseUrl != null;
    }

    public boolean isRun() {
        return this.isRun;
    }

    public yc4 processRequest(yc4 yc4Var) {
        rc4 globalDomain;
        if (yc4Var == null) {
            return yc4Var;
        }
        yc4.a aVarH = yc4Var.h();
        String string = yc4Var.j().toString();
        if (string.contains(IDENTIFICATION_IGNORE)) {
            return pruneIdentification(aVarH, string);
        }
        String strObtainDomainNameFromHeaders = obtainDomainNameFromHeaders(yc4Var);
        Object[] objArrListenersToArray = listenersToArray();
        if (TextUtils.isEmpty(strObtainDomainNameFromHeaders)) {
            notifyListener(yc4Var, GLOBAL_DOMAIN_NAME, objArrListenersToArray);
            globalDomain = getGlobalDomain();
        } else {
            notifyListener(yc4Var, strObtainDomainNameFromHeaders, objArrListenersToArray);
            globalDomain = fetchDomain(strObtainDomainNameFromHeaders);
            aVarH.i(DOMAIN_NAME);
        }
        if (globalDomain == null) {
            return aVarH.b();
        }
        rc4 url = this.mUrlParser.parseUrl(globalDomain, yc4Var.j());
        if (this.debug) {
            String str = "The new url is { " + url.toString() + " }, old url is { " + yc4Var.j().toString() + " }";
        }
        if (objArrListenersToArray != null) {
            for (Object obj : objArrListenersToArray) {
                ((onUrlChangeListener) obj).onUrlChanged(url, yc4Var.j());
            }
        }
        aVarH.l(url);
        return aVarH.b();
    }

    public void putDomain(String str, String str2) {
        Utils.checkNotNull(str, "domainName cannot be null");
        Utils.checkNotNull(str2, "domainUrl cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.put(str, Utils.checkUrl(str2));
        }
    }

    public void registerUrlChangeListener(onUrlChangeListener onurlchangelistener) {
        Utils.checkNotNull(onurlchangelistener, "listener cannot be null");
        synchronized (this.mListeners) {
            this.mListeners.add(onurlchangelistener);
        }
    }

    public void removeDomain(String str) {
        Utils.checkNotNull(str, "domainName cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.remove(str);
        }
    }

    public void removeGlobalDomain() {
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.remove(GLOBAL_DOMAIN_NAME);
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setGlobalDomain(String str) {
        Utils.checkNotNull(str, "globalDomain cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.put(GLOBAL_DOMAIN_NAME, Utils.checkUrl(str));
        }
    }

    public String setPathSizeOfUrl(String str, int i) {
        Utils.checkNotNull(str, "url cannot be null");
        if (i < 0) {
            throw new IllegalArgumentException("pathSize must be >= 0");
        }
        return str + IDENTIFICATION_PATH_SIZE + i;
    }

    public void setRun(boolean z) {
        this.isRun = z;
    }

    public String setUrlNotChange(String str) {
        Utils.checkNotNull(str, "url cannot be null");
        return str + IDENTIFICATION_IGNORE;
    }

    public void setUrlParser(UrlParser urlParser) {
        Utils.checkNotNull(urlParser, "parser cannot be null");
        this.mUrlParser = urlParser;
    }

    public void startAdvancedModel(String str) {
        Utils.checkNotNull(str, "baseUrl cannot be null");
        startAdvancedModel(Utils.checkUrl(str));
    }

    public void unregisterUrlChangeListener(onUrlChangeListener onurlchangelistener) {
        Utils.checkNotNull(onurlchangelistener, "listener cannot be null");
        synchronized (this.mListeners) {
            this.mListeners.remove(onurlchangelistener);
        }
    }

    public vc4.b with(vc4.b bVar) {
        Utils.checkNotNull(bVar, "builder cannot be null");
        bVar.a(this.mInterceptor);
        return bVar;
    }

    private RetrofitUrlManager() {
        this.isRun = true;
        this.debug = false;
        this.mDomainNameHub = new HashMap();
        this.mListeners = new ArrayList();
        if (!DEPENDENCY_OKHTTP) {
            throw new IllegalStateException("Must be dependency Okhttp");
        }
        DefaultUrlParser defaultUrlParser = new DefaultUrlParser();
        defaultUrlParser.init(this);
        setUrlParser(defaultUrlParser);
        this.mInterceptor = new sc4() { // from class: me.jessyan.retrofiturlmanager.RetrofitUrlManager.1
            @Override // dc.sc4
            public ad4 intercept(sc4.a aVar) throws IOException {
                return !RetrofitUrlManager.this.isRun() ? aVar.proceed(aVar.request()) : aVar.proceed(RetrofitUrlManager.this.processRequest(aVar.request()));
            }
        };
    }

    public synchronized void startAdvancedModel(rc4 rc4Var) {
        Utils.checkNotNull(rc4Var, "baseUrl cannot be null");
        this.baseUrl = rc4Var;
        this.pathSize = rc4Var.v();
        if ("".equals(rc4Var.t().get(r3.size() - 1))) {
            this.pathSize--;
        }
    }
}
