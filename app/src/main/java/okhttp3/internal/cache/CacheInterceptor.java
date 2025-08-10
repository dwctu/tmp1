package okhttp3.internal.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.net.HttpHeaders;
import dc.ad4;
import dc.ee4;
import dc.fe4;
import dc.ge4;
import dc.nd4;
import dc.od4;
import dc.pd4;
import dc.qc4;
import dc.sc4;
import dc.wc4;
import dc.wd4;
import dc.yc4;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

/* loaded from: classes5.dex */
public final class CacheInterceptor implements sc4 {
    public final InternalCache cache;

    public CacheInterceptor(InternalCache internalCache) {
        this.cache = internalCache;
    }

    private ad4 cacheWritingResponse(final CacheRequest cacheRequest, ad4 ad4Var) throws IOException {
        ee4 ee4VarBody;
        if (cacheRequest == null || (ee4VarBody = cacheRequest.body()) == null) {
            return ad4Var;
        }
        final pd4 pd4VarSource = ad4Var.b().source();
        final od4 od4VarC = wd4.c(ee4VarBody);
        fe4 fe4Var = new fe4() { // from class: okhttp3.internal.cache.CacheInterceptor.1
            public boolean cacheRequestClosed;

            @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                pd4VarSource.close();
            }

            @Override // dc.fe4
            public long read(nd4 nd4Var, long j) throws IOException {
                try {
                    long j2 = pd4VarSource.read(nd4Var, j);
                    if (j2 != -1) {
                        nd4Var.m(od4VarC.a(), nd4Var.f0() - j2, j2);
                        od4VarC.l();
                        return j2;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        od4VarC.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // dc.fe4
            public ge4 timeout() {
                return pd4VarSource.timeout();
            }
        };
        String strM = ad4Var.m("Content-Type");
        long jContentLength = ad4Var.b().contentLength();
        ad4.a aVarA = ad4Var.A();
        aVarA.b(new RealResponseBody(strM, jContentLength, wd4.d(fe4Var)));
        return aVarA.c();
    }

    private static qc4 combine(qc4 qc4Var, qc4 qc4Var2) {
        qc4.a aVar = new qc4.a();
        int iH = qc4Var.h();
        for (int i = 0; i < iH; i++) {
            String strE = qc4Var.e(i);
            String strJ = qc4Var.j(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(strE) || !strJ.startsWith("1")) && (isContentSpecificHeader(strE) || !isEndToEnd(strE) || qc4Var2.c(strE) == null)) {
                Internal.instance.addLenient(aVar, strE, strJ);
            }
        }
        int iH2 = qc4Var2.h();
        for (int i2 = 0; i2 < iH2; i2++) {
            String strE2 = qc4Var2.e(i2);
            if (!isContentSpecificHeader(strE2) && isEndToEnd(strE2)) {
                Internal.instance.addLenient(aVar, strE2, qc4Var2.j(i2));
            }
        }
        return aVar.f();
    }

    public static boolean isContentSpecificHeader(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean isEndToEnd(String str) {
        return (HttpHeaders.CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    private static ad4 stripBody(ad4 ad4Var) {
        if (ad4Var == null || ad4Var.b() == null) {
            return ad4Var;
        }
        ad4.a aVarA = ad4Var.A();
        aVarA.b(null);
        return aVarA.c();
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException {
        InternalCache internalCache = this.cache;
        ad4 ad4Var = internalCache != null ? internalCache.get(aVar.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), aVar.request(), ad4Var).get();
        yc4 yc4Var = cacheStrategy.networkRequest;
        ad4 ad4Var2 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.cache;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (ad4Var != null && ad4Var2 == null) {
            Util.closeQuietly(ad4Var.b());
        }
        if (yc4Var == null && ad4Var2 == null) {
            ad4.a aVar2 = new ad4.a();
            aVar2.q(aVar.request());
            aVar2.o(wc4.HTTP_1_1);
            aVar2.g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
            aVar2.l("Unsatisfiable Request (only-if-cached)");
            aVar2.b(Util.EMPTY_RESPONSE);
            aVar2.r(-1L);
            aVar2.p(System.currentTimeMillis());
            return aVar2.c();
        }
        if (yc4Var == null) {
            ad4.a aVarA = ad4Var2.A();
            aVarA.d(stripBody(ad4Var2));
            return aVarA.c();
        }
        try {
            ad4 ad4VarProceed = aVar.proceed(yc4Var);
            if (ad4VarProceed == null && ad4Var != null) {
            }
            if (ad4Var2 != null) {
                if (ad4VarProceed.f() == 304) {
                    ad4.a aVarA2 = ad4Var2.A();
                    aVarA2.j(combine(ad4Var2.q(), ad4VarProceed.q()));
                    aVarA2.r(ad4VarProceed.O());
                    aVarA2.p(ad4VarProceed.K());
                    aVarA2.d(stripBody(ad4Var2));
                    aVarA2.m(stripBody(ad4VarProceed));
                    ad4 ad4VarC = aVarA2.c();
                    ad4VarProceed.b().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(ad4Var2, ad4VarC);
                    return ad4VarC;
                }
                Util.closeQuietly(ad4Var2.b());
            }
            ad4.a aVarA3 = ad4VarProceed.A();
            aVarA3.d(stripBody(ad4Var2));
            aVarA3.m(stripBody(ad4VarProceed));
            ad4 ad4VarC2 = aVarA3.c();
            if (this.cache != null) {
                if (okhttp3.internal.http.HttpHeaders.hasBody(ad4VarC2) && CacheStrategy.isCacheable(ad4VarC2, yc4Var)) {
                    return cacheWritingResponse(this.cache.put(ad4VarC2), ad4VarC2);
                }
                if (HttpMethod.invalidatesCache(yc4Var.g())) {
                    try {
                        this.cache.remove(yc4Var);
                    } catch (IOException unused) {
                    }
                }
            }
            return ad4VarC2;
        } finally {
            if (ad4Var != null) {
                Util.closeQuietly(ad4Var.b());
            }
        }
    }
}
