package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AmazonHttpClient {
    public static final Log e = LogFactory.c("com.amazonaws.request");
    public static final Log f = LogFactory.b(AmazonHttpClient.class);
    public final HttpClient a;
    public final ClientConfiguration b;
    public final HttpRequestFactory d = new HttpRequestFactory();
    public final RequestMetricCollector c = null;

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.b = clientConfiguration;
        this.a = httpClient;
    }

    public static String c(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    public static boolean l(HttpResponse httpResponse) {
        int iE = httpResponse.e();
        String str = httpResponse.c().get(HttpHeaders.LOCATION);
        return (iE != 307 || str == null || str.isEmpty()) ? false : true;
    }

    public void a(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().b(request, response, amazonClientException);
        }
    }

    public <T> void b(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(request, response);
        }
    }

    public <T> Response<T> d(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) throws Throwable {
        if (request.k() != null) {
            try {
                URI uriS = request.s();
                String str = request.k() + uriS.getHost();
                URIBuilder uRIBuilderB = URIBuilder.b(uriS);
                uRIBuilderB.c(str);
                request.t(uRIBuilderB.a());
            } catch (URISyntaxException e2) {
                Log log = f;
                if (log.isDebugEnabled()) {
                    log.e("Failed to prepend host prefix: " + e2.getMessage(), e2);
                }
            }
        }
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List<RequestHandler2> listO = o(request, executionContext);
        AWSRequestMetrics aWSRequestMetricsA = executionContext.a();
        Response<T> responseE = null;
        try {
            responseE = e(request, httpResponseHandler, httpResponseHandler2, executionContext);
            b(request, listO, responseE, aWSRequestMetricsA.c().c());
            return responseE;
        } catch (AmazonClientException e3) {
            a(request, responseE, listO, e3);
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c5 A[Catch: IOException -> 0x02cd, TRY_LEAVE, TryCatch #42 {IOException -> 0x02cd, blocks: (B:121:0x02bf, B:123:0x02c5), top: B:266:0x02bf }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03ad A[Catch: all -> 0x0433, TRY_ENTER, TryCatch #8 {all -> 0x0433, blocks: (B:208:0x03a3, B:211:0x03ad, B:212:0x03c3, B:214:0x0406, B:225:0x0432, B:174:0x0356, B:175:0x035b), top: B:241:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0406 A[Catch: all -> 0x0433, TRY_LEAVE, TryCatch #8 {all -> 0x0433, blocks: (B:208:0x03a3, B:211:0x03ad, B:212:0x03c3, B:214:0x0406, B:225:0x0432, B:174:0x0356, B:175:0x035b), top: B:241:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0438 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0432 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:292:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013b A[Catch: all -> 0x00e5, IOException -> 0x036f, Error -> 0x037e, RuntimeException -> 0x038a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x036f, blocks: (B:45:0x011f, B:47:0x0127, B:49:0x012c, B:50:0x0132, B:51:0x0133, B:53:0x013b, B:54:0x0153), top: B:237:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
    /* JADX WARN: Type inference failed for: r1v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.amazonaws.Response<T> e(com.amazonaws.Request<?> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r28, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r29, com.amazonaws.http.ExecutionContext r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1103
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.e(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    public RequestMetricCollector f() {
        return this.c;
    }

    public void finalize() throws Throwable {
        s();
        super.finalize();
    }

    public final String g(String str) {
        return str.substring(str.indexOf("(") + 1, str.contains(" + 15") ? str.indexOf(" + 15") : str.indexOf(" - 15"));
    }

    public AmazonServiceException h(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int iE = httpResponse.e();
        try {
            amazonServiceException = httpResponseHandler.a(httpResponse);
            e.a("Received error response: " + amazonServiceException.toString());
        } catch (Exception e2) {
            if (iE == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.j(request.getServiceName());
                amazonServiceException.k(413);
                amazonServiceException.h(AmazonServiceException.ErrorType.Client);
                amazonServiceException.f("Request entity too large");
            } else {
                if (iE != 503 || !"Service Unavailable".equalsIgnoreCase(httpResponse.f())) {
                    if (e2 instanceof IOException) {
                        throw ((IOException) e2);
                    }
                    throw new AmazonClientException("Unable to unmarshall error response (" + e2.getMessage() + "). Response Code: " + iE + ", Response Text: " + httpResponse.f() + ", Response Headers: " + httpResponse.c(), e2);
                }
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.j(request.getServiceName());
                amazonServiceException.k(503);
                amazonServiceException.h(AmazonServiceException.ErrorType.Service);
                amazonServiceException.f("Service unavailable");
            }
        }
        amazonServiceException.k(iE);
        amazonServiceException.j(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    public <T> T i(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics aWSRequestMetricsA = executionContext.a();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            aWSRequestMetricsA.g(field);
            try {
                AmazonWebServiceResponse<T> amazonWebServiceResponseA = httpResponseHandler.a(httpResponse);
                aWSRequestMetricsA.b(field);
                if (amazonWebServiceResponseA == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f());
                }
                Log log = e;
                if (log.isDebugEnabled()) {
                    log.a("Received successful response: " + httpResponse.e() + ", AWS Request ID: " + amazonWebServiceResponseA.a());
                }
                aWSRequestMetricsA.a(AWSRequestMetrics.Field.AWSRequestID, amazonWebServiceResponseA.a());
                return amazonWebServiceResponseA.b();
            } catch (Throwable th) {
                aWSRequestMetricsA.b(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (CRC32MismatchException e2) {
            throw e2;
        } catch (IOException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new AmazonClientException("Unable to unmarshall response (" + e4.getMessage() + "). Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f(), e4);
        }
    }

    public final <T extends Throwable> T j(T t, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.d(field);
        aWSRequestMetrics.a(field, t);
        return t;
    }

    public final boolean k(HttpResponse httpResponse) {
        int iE = httpResponse.e();
        return iE >= 200 && iE < 300;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[Catch: RuntimeException -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x003b, blocks: (B:4:0x0014, B:9:0x0020), top: B:21:0x0014 }] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m(com.amazonaws.http.HttpResponse r4, com.amazonaws.AmazonServiceException r5) {
        /*
            r3 = this;
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.util.Map r4 = r4.c()
            java.lang.String r1 = "Date"
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            r1 = 0
            if (r4 == 0) goto L20
            boolean r2 = r4.isEmpty()     // Catch: java.lang.RuntimeException -> L3b
            if (r2 == 0) goto L1b
            goto L20
        L1b:
            java.util.Date r4 = com.amazonaws.util.DateUtils.i(r4)     // Catch: java.lang.RuntimeException -> L39
            goto L2c
        L20:
            java.lang.String r4 = r5.getMessage()     // Catch: java.lang.RuntimeException -> L3b
            java.lang.String r4 = r3.g(r4)     // Catch: java.lang.RuntimeException -> L3b
            java.util.Date r4 = com.amazonaws.util.DateUtils.g(r4)     // Catch: java.lang.RuntimeException -> L39
        L2c:
            long r0 = r0.getTime()
            long r4 = r4.getTime()
            long r0 = r0 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r4
            return r0
        L39:
            r5 = move-exception
            goto L3d
        L3b:
            r5 = move-exception
            r4 = r1
        L3d:
            com.amazonaws.logging.Log r0 = com.amazonaws.http.AmazonHttpClient.f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to parse clock skew offset from response: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.f(r4, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.m(com.amazonaws.http.HttpResponse, com.amazonaws.AmazonServiceException):long");
    }

    public final long n(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) throws InterruptedException {
        int i2 = (i - 1) - 1;
        long jA = retryPolicy.a().a(amazonWebServiceRequest, amazonClientException, i2);
        Log log = f;
        if (log.isDebugEnabled()) {
            log.a("Retriable error detected, will retry in " + jA + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(jA);
            return jA;
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e2.getMessage(), e2);
        }
    }

    public List<RequestHandler2> o(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> listD = executionContext.d();
        if (listD == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : listD) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).e(executionContext.c());
            }
            requestHandler2.d(request);
        }
        return listD;
    }

    public void p(Request<?> request, Exception exc) throws IOException {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    public void q(Request<?> request) {
        RequestClientOptions requestClientOptionsD;
        String strC;
        String str = ClientConfiguration.l;
        AmazonWebServiceRequest amazonWebServiceRequestM = request.m();
        String strC2 = (amazonWebServiceRequestM == null || (requestClientOptionsD = amazonWebServiceRequestM.d()) == null || (strC = requestClientOptionsD.c(RequestClientOptions.Marker.USER_AGENT)) == null) ? str : c(str, strC);
        if (!str.equals(this.b.h())) {
            strC2 = c(strC2, this.b.h());
        }
        if (this.b.i() != null) {
            strC2 = this.b.i();
        }
        request.i("User-Agent", strC2);
    }

    public final boolean r(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int iB = this.b.b();
        if (iB < 0 || !retryPolicy.d()) {
            iB = retryPolicy.b();
        }
        if (i2 >= iB) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.c().a(amazonWebServiceRequest, amazonClientException, i2);
        }
        Log log = f;
        if (log.isDebugEnabled()) {
            log.a("Content not repeatable");
        }
        return false;
    }

    public void s() {
        this.a.shutdown();
    }
}
