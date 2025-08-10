package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import dc.ad4;
import dc.qc4;
import dc.yc4;
import dc.zb4;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;

/* loaded from: classes5.dex */
public final class CacheStrategy {
    public final ad4 cacheResponse;
    public final yc4 networkRequest;

    public static class Factory {
        private int ageSeconds;
        public final ad4 cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        public final long nowMillis;
        private long receivedResponseMillis;
        public final yc4 request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j, yc4 yc4Var, ad4 ad4Var) {
            this.ageSeconds = -1;
            this.nowMillis = j;
            this.request = yc4Var;
            this.cacheResponse = ad4Var;
            if (ad4Var != null) {
                this.sentRequestMillis = ad4Var.O();
                this.receivedResponseMillis = ad4Var.K();
                qc4 qc4VarQ = ad4Var.q();
                int iH = qc4VarQ.h();
                for (int i = 0; i < iH; i++) {
                    String strE = qc4VarQ.e(i);
                    String strJ = qc4VarQ.j(i);
                    if ("Date".equalsIgnoreCase(strE)) {
                        this.servedDate = HttpDate.parse(strJ);
                        this.servedDateString = strJ;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(strE)) {
                        this.expires = HttpDate.parse(strJ);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(strE)) {
                        this.lastModified = HttpDate.parse(strJ);
                        this.lastModifiedString = strJ;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(strE)) {
                        this.etag = strJ;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(strE)) {
                        this.ageSeconds = okhttp3.internal.http.HttpHeaders.parseSeconds(strJ, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.receivedResponseMillis;
            return jMax + (j - this.sentRequestMillis) + (this.nowMillis - j);
        }

        private long computeFreshnessLifetime() {
            if (this.cacheResponse.e().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.expires != null) {
                Date date = this.servedDate;
                long time = this.expires.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.L().j().C() != null) {
                return 0L;
            }
            Date date2 = this.servedDate;
            long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.f() && this.cacheResponse.j() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            zb4 zb4VarB = this.request.b();
            if (zb4VarB.h() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            zb4 zb4VarE = this.cacheResponse.e();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (zb4VarB.d() != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(zb4VarB.d()));
            }
            long millis = 0;
            long millis2 = zb4VarB.f() != -1 ? TimeUnit.SECONDS.toMillis(zb4VarB.f()) : 0L;
            if (!zb4VarE.g() && zb4VarB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(zb4VarB.e());
            }
            if (!zb4VarE.h()) {
                long j = millis2 + jCacheResponseAge;
                if (j < millis + jComputeFreshnessLifetime) {
                    ad4.a aVarA = this.cacheResponse.A();
                    if (j >= jComputeFreshnessLifetime) {
                        aVarA.a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        aVarA.a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, aVarA.c());
                }
            }
            String str = this.etag;
            String str2 = HttpHeaders.IF_MODIFIED_SINCE;
            if (str != null) {
                str2 = HttpHeaders.IF_NONE_MATCH;
            } else if (this.lastModified != null) {
                str = this.lastModifiedString;
            } else {
                if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                }
                str = this.servedDateString;
            }
            qc4.a aVarF = this.request.e().f();
            Internal.instance.addLenient(aVarF, str2, str);
            yc4.a aVarH = this.request.h();
            aVarH.f(aVarF.f());
            return new CacheStrategy(aVarH.b(), this.cacheResponse);
        }

        private static boolean hasConditions(yc4 yc4Var) {
            return (yc4Var.c(HttpHeaders.IF_MODIFIED_SINCE) == null && yc4Var.c(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.e().d() == -1 && this.expires == null;
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.b().j()) ? candidate : new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(yc4 yc4Var, ad4 ad4Var) {
        this.networkRequest = yc4Var;
        this.cacheResponse = ad4Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.e().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCacheable(dc.ad4 r3, dc.yc4 r4) {
        /*
            int r0 = r3.f()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m(r0)
            if (r0 != 0) goto L5a
            dc.zb4 r0 = r3.e()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            dc.zb4 r0 = r3.e()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            dc.zb4 r0 = r3.e()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            dc.zb4 r3 = r3.e()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            dc.zb4 r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.isCacheable(dc.ad4, dc.yc4):boolean");
    }
}
