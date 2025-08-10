package com.amazonaws.services.s3;

import com.amazonaws.AbortedException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressReportingInputStream;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.internal.AWSS3V4Signer;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazonaws.services.s3.internal.S3ExecutionContext;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazonaws.services.s3.internal.S3ObjectResponseHandler;
import com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler;
import com.amazonaws.services.s3.internal.S3Signer;
import com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.model.transform.HeadBucketResultHandler;
import com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.util.ServiceClientHolderInputStream;
import com.amazonaws.util.ValidationUtils;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.koushikdutta.async.http.body.DocumentBody;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class AmazonS3Client extends AmazonWebServiceClient implements AmazonS3 {
    public static Log r = LogFactory.b(AmazonS3Client.class);
    public static final Map<String, String> s;
    public final S3ErrorResponseHandler k;
    public final S3XmlResponseHandler<Void> l;
    public S3ClientOptions m;
    public final AWSCredentialsProvider n;
    public volatile String o;
    public int p;
    public final CompleteMultipartUploadRetryCondition q;

    static {
        AwsSdkMetrics.addAll(Arrays.asList(S3ServiceMetric.b()));
        SignerFactory.e("AWSS3V4SignerType", AWSS3V4Signer.class);
        s = Collections.synchronizedMap(new LinkedHashMap<String, String>(300, 1.1f, true) { // from class: com.amazonaws.services.s3.AmazonS3Client.1
            private static final long serialVersionUID = 23453;

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 300;
            }
        });
    }

    @Deprecated
    public AmazonS3Client() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public static void A(Request<?> request, String str, String str2) {
        if (str2 != null) {
            request.i(str, str2);
        }
    }

    public static void B(Request<?> request, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides == null) {
            return;
        }
        responseHeaderOverrides.k();
        throw null;
    }

    public static void C(Request<?> request, String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        request.i(str, ServiceUtils.d(list));
    }

    public static boolean X(String str) throws NumberFormatException {
        int i;
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
            }
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }

    public static void Z(Request<?> request, ObjectMetadata objectMetadata) {
        Map<String, Object> mapW = objectMetadata.w();
        if (mapW.get("x-amz-server-side-encryption-aws-kms-key-id") != null && !ObjectMetadata.a.equals(mapW.get("x-amz-server-side-encryption"))) {
            throw new IllegalArgumentException("If you specify a KMS key id for server side encryption, you must also set the SSEAlgorithm to ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION");
        }
        if (mapW != null) {
            for (Map.Entry<String, Object> entry : mapW.entrySet()) {
                request.i(entry.getKey(), entry.getValue().toString());
            }
        }
        Date dateU = objectMetadata.u();
        if (dateU != null) {
            request.i(HttpHeaders.EXPIRES, DateUtils.d(dateU));
        }
        Map<String, String> mapE = objectMetadata.E();
        if (mapE != null) {
            for (Map.Entry<String, String> entry2 : mapE.entrySet()) {
                String key = entry2.getKey();
                String value = entry2.getValue();
                if (key != null) {
                    key = key.trim();
                }
                if (value != null) {
                    value = value.trim();
                }
                if (!"x-amz-tagging".equals(key)) {
                    request.i("x-amz-meta-" + key, value);
                }
            }
        }
    }

    public static void a0(Request<?> request, boolean z) {
        if (z) {
            request.i("x-amz-request-payer", "requester");
        }
    }

    public static void b0(Request<?> request, SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey == null) {
            return;
        }
        sSECustomerKey.a();
        throw null;
    }

    public static void c0(Request<?> request, SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null) {
            A(request, "x-amz-server-side-encryption", sSEAwsKeyManagementParams.b());
            A(request, "x-amz-server-side-encryption-aws-kms-key-id", sSEAwsKeyManagementParams.a());
        }
    }

    public static void y(Request<? extends AmazonWebServiceRequest> request, AccessControlList accessControlList) {
        Set<Grant> setB = accessControlList.b();
        HashMap map = new HashMap();
        for (Grant grant : setB) {
            if (!map.containsKey(grant.b())) {
                map.put(grant.b(), new LinkedList());
            }
            ((Collection) map.get(grant.b())).add(grant.a());
        }
        for (Permission permission : Permission.values()) {
            if (map.containsKey(permission)) {
                Collection<Grantee> collection = (Collection) map.get(permission);
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (Grantee grantee : collection) {
                    if (z) {
                        sb.append(", ");
                    } else {
                        z = true;
                    }
                    sb.append(grantee.getTypeIdentifier());
                    sb.append("=");
                    sb.append("\"");
                    sb.append(grantee.getIdentifier());
                    sb.append("\"");
                }
                request.i(permission.getHeaderName(), sb.toString());
            }
        }
    }

    public static void z(Request<?> request, String str, Date date) {
        if (date != null) {
            request.i(str, ServiceUtils.c(date));
        }
    }

    public final long D(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        inputStream.mark(-1);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    inputStream.reset();
                    return j;
                }
                j += i;
            } catch (IOException e) {
                throw new AmazonClientException("Could not calculate content length.", e);
            }
        }
    }

    public final URI E(URI uri, String str) {
        try {
            return new URI(uri.getScheme() + "://" + str + "." + uri.getAuthority());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid bucket name: " + str, e);
        }
    }

    public final ExecutionContext F(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new S3ExecutionContext(this.e, t(amazonWebServiceRequest) || AmazonWebServiceClient.r(), this);
    }

    public <X extends AmazonWebServiceRequest> Request<X> G(String str, String str2, X x, HttpMethodName httpMethodName) {
        return H(str, str2, x, httpMethodName, null);
    }

    public <X extends AmazonWebServiceRequest> Request<X> H(String str, String str2, X x, HttpMethodName httpMethodName, URI uri) {
        DefaultRequest defaultRequest = new DefaultRequest(x, "Amazon S3");
        if (this.m.a()) {
            defaultRequest.m();
            uri = this.m.c() ? RuntimeHttpUtils.a("s3-accelerate.dualstack.amazonaws.com", this.c) : RuntimeHttpUtils.a("s3-accelerate.amazonaws.com", this.c);
        } else if (this.m.c()) {
            uri = RuntimeHttpUtils.a(String.format("s3.dualstack.%s.amazonaws.com", P()), this.c);
        }
        defaultRequest.p(httpMethodName);
        e0(defaultRequest, str, str2, uri);
        return defaultRequest;
    }

    @Deprecated
    public final S3Signer I(Request<?> request, String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        if (str != null) {
            str3 = str + "/";
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return new S3Signer(request.n().toString(), sb.toString());
    }

    public Signer J(Request<?> request, String str, String str2) {
        Signer signerP = p(this.m.a() ? this.a : request.s());
        if (!V()) {
            if ((signerP instanceof AWSS3V4Signer) && Y(request)) {
                String str3 = this.o == null ? s.get(str) : this.o;
                if (str3 != null) {
                    e0(request, str, str2, RuntimeHttpUtils.a(RegionUtils.a(str3).f("s3"), this.c));
                    AWSS3V4Signer aWSS3V4Signer = (AWSS3V4Signer) signerP;
                    f0(aWSS3V4Signer, str3);
                    return aWSS3V4Signer;
                }
                if (request.m() instanceof GeneratePresignedUrlRequest) {
                    return I(request, str, str2);
                }
            }
            String strQ = q() == null ? this.o == null ? s.get(str) : this.o : q();
            if (strQ != null) {
                AWSS3V4Signer aWSS3V4Signer2 = new AWSS3V4Signer();
                f0(aWSS3V4Signer2, strQ);
                return aWSS3V4Signer2;
            }
        }
        return signerP instanceof S3Signer ? I(request, str, str2) : signerP;
    }

    public final String K(String str) {
        Map<String, String> map = s;
        String strM = map.get(str);
        if (strM == null) {
            if (r.isDebugEnabled()) {
                r.a("Bucket region cache doesn't have an entry for " + str + ". Trying to get bucket region from Amazon S3.");
            }
            strM = M(str);
            if (strM != null) {
                map.put(str, strM);
            }
        }
        if (r.isDebugEnabled()) {
            r.a("Region for " + str + " is " + strM);
        }
        return strM;
    }

    public final void L(ProgressListenerCallbackExecutor progressListenerCallbackExecutor, int i) {
        if (progressListenerCallbackExecutor == null) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.c(i);
        progressListenerCallbackExecutor.c(progressEvent);
    }

    public final String M(String str) {
        String strA = null;
        try {
            strA = ((HeadBucketResult) U(H(str, null, new HeadBucketRequest(str), HttpMethodName.HEAD, new URI("https://s3-us-west-1.amazonaws.com")), new HeadBucketResultHandler(), str, null)).a();
        } catch (AmazonS3Exception e) {
            if (e.l() != null) {
                strA = e.l().get("x-amz-bucket-region");
            }
        } catch (URISyntaxException unused) {
            r.g("Error while creating URI");
        }
        if (strA == null && r.isDebugEnabled()) {
            r.a("Not able to derive region of the " + str + " from the HEAD Bucket requests.");
        }
        return strA;
    }

    public final String N(String str) {
        if (str == null || !str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    public final String O(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public String P() {
        String authority = this.a.getAuthority();
        if ("s3.amazonaws.com".equals(authority)) {
            return "us-east-1";
        }
        Matcher matcher = Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
        try {
            matcher.matches();
            return RegionUtils.a(matcher.group(1)).d();
        } catch (Exception e) {
            throw new IllegalStateException("No valid region has been specified. Unable to return region name", e);
        }
    }

    public final String Q() {
        String strQ = q();
        return strQ == null ? this.o : strQ;
    }

    public URL R(String str, String str2) {
        DefaultRequest defaultRequest = new DefaultRequest("Amazon S3");
        d0(defaultRequest, str, str2);
        return ServiceUtils.a(defaultRequest);
    }

    @Deprecated
    public final void S() {
        v("s3.amazonaws.com");
        this.i = "s3";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
        this.e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
    }

    public final void T(com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration) {
        if (this.n == null) {
            throw new IllegalArgumentException("Credentials cannot be null. Credentials is required to sign the request");
        }
        if (region == null) {
            throw new IllegalArgumentException("Region cannot be null. Region is required to sign the request");
        }
        this.c = clientConfiguration;
        this.i = "s3";
        v("s3.amazonaws.com");
        w(region);
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
        this.e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
        r.a("initialized with endpoint = " + this.a);
    }

    public final <X, Y extends AmazonWebServiceRequest> X U(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, String str, String str2) {
        AmazonWebServiceRequest amazonWebServiceRequestM = request.m();
        ExecutionContext executionContextF = F(amazonWebServiceRequestM);
        AWSRequestMetrics aWSRequestMetricsA = executionContextF.a();
        request.h(aWSRequestMetricsA);
        aWSRequestMetricsA.g(AWSRequestMetrics.Field.ClientExecuteTime);
        Response<?> responseD = null;
        try {
            try {
                request.f(this.f);
                if (!request.getHeaders().containsKey("Content-Type")) {
                    request.i("Content-Type", DfuBaseService.MIME_TYPE_OCTET_STREAM);
                }
                if (str != null) {
                    request.m();
                    if (Y(request)) {
                        K(str);
                    }
                }
                AWSCredentials credentials = this.n.getCredentials();
                if (amazonWebServiceRequestM.e() != null) {
                    credentials = amazonWebServiceRequestM.e();
                }
                executionContextF.g(J(request, str, str2));
                executionContextF.f(credentials);
                responseD = this.d.d(request, httpResponseHandler, this.k, executionContextF);
                return (X) responseD.a();
            } catch (AmazonS3Exception e) {
                if (e.e() == 301 && e.l() != null) {
                    String str3 = e.l().get("x-amz-bucket-region");
                    s.put(str, str3);
                    e.g("The bucket is in this region: " + str3 + ". Please use this region to retry the request");
                }
                throw e;
            }
        } finally {
            j(aWSRequestMetricsA, request, responseD);
        }
    }

    public final boolean V() {
        ClientConfiguration clientConfiguration = this.c;
        return (clientConfiguration == null || clientConfiguration.e() == null) ? false : true;
    }

    public final boolean W(URI uri) {
        return uri.getHost().endsWith("s3.amazonaws.com");
    }

    public final boolean Y(Request<?> request) {
        return W(request.s()) && Q() == null;
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public CompleteMultipartUploadResult a(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException {
        ValidationUtils.a(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
        String strK = completeMultipartUploadRequest.k();
        String strL = completeMultipartUploadRequest.l();
        String strN = completeMultipartUploadRequest.n();
        ValidationUtils.a(strK, "The bucket name parameter must be specified when completing a multipart upload");
        ValidationUtils.a(strL, "The key parameter must be specified when completing a multipart upload");
        ValidationUtils.a(strN, "The upload ID parameter must be specified when completing a multipart upload");
        ValidationUtils.a(completeMultipartUploadRequest.m(), "The part ETags parameter must be specified when completing a multipart upload");
        int i = 0;
        while (true) {
            Request requestG = G(strK, strL, completeMultipartUploadRequest, HttpMethodName.POST);
            requestG.g("uploadId", strN);
            a0(requestG, completeMultipartUploadRequest.o());
            byte[] bArrA = RequestXmlFactory.a(completeMultipartUploadRequest.m());
            requestG.i("Content-Type", DocumentBody.CONTENT_TYPE);
            requestG.i(HttpHeaders.CONTENT_LENGTH, String.valueOf(bArrA.length));
            requestG.a(new ByteArrayInputStream(bArrA));
            XmlResponsesSaxParser.CompleteMultipartUploadHandler completeMultipartUploadHandler = (XmlResponsesSaxParser.CompleteMultipartUploadHandler) U(requestG, new ResponseHeaderHandlerChain(new Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream>() { // from class: com.amazonaws.services.s3.model.transform.Unmarshallers$CompleteMultipartUploadResultUnmarshaller
                @Override // com.amazonaws.transform.Unmarshaller
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public XmlResponsesSaxParser.CompleteMultipartUploadHandler a(InputStream inputStream) throws Exception {
                    return new XmlResponsesSaxParser().j(inputStream);
                }
            }, new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3VersionHeaderHandler(), new S3RequesterChargedHeaderHandler()), strK, strL);
            if (completeMultipartUploadHandler.o() != null) {
                return completeMultipartUploadHandler.o();
            }
            int i2 = i + 1;
            if (!h0(completeMultipartUploadRequest, completeMultipartUploadHandler.n(), i)) {
                throw completeMultipartUploadHandler.n();
            }
            i = i2;
        }
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public InitiateMultipartUploadResult b(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException {
        ValidationUtils.a(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.l(), "The bucket name parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.n(), "The key parameter must be specified when initiating a multipart upload");
        Request<?> requestG = G(initiateMultipartUploadRequest.l(), initiateMultipartUploadRequest.n(), initiateMultipartUploadRequest, HttpMethodName.POST);
        requestG.g("uploads", null);
        if (initiateMultipartUploadRequest.r() != null) {
            requestG.i("x-amz-storage-class", initiateMultipartUploadRequest.r().toString());
        }
        if (initiateMultipartUploadRequest.o() != null) {
            requestG.i("x-amz-website-redirect-location", initiateMultipartUploadRequest.o());
        }
        if (initiateMultipartUploadRequest.k() != null) {
            y(requestG, initiateMultipartUploadRequest.k());
        } else if (initiateMultipartUploadRequest.m() != null) {
            requestG.i("x-amz-acl", initiateMultipartUploadRequest.m().toString());
        }
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.objectMetadata;
        if (objectMetadata != null) {
            Z(requestG, objectMetadata);
        }
        A(requestG, "x-amz-tagging", k0(initiateMultipartUploadRequest.s()));
        a0(requestG, initiateMultipartUploadRequest.t());
        b0(requestG, initiateMultipartUploadRequest.q());
        c0(requestG, initiateMultipartUploadRequest.p());
        g0(requestG);
        requestG.a(new ByteArrayInputStream(new byte[0]));
        return (InitiateMultipartUploadResult) U(requestG, new ResponseHeaderHandlerChain(new Unmarshaller<InitiateMultipartUploadResult, InputStream>() { // from class: com.amazonaws.services.s3.model.transform.Unmarshallers$InitiateMultipartUploadResultUnmarshaller
            @Override // com.amazonaws.transform.Unmarshaller
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InitiateMultipartUploadResult a(InputStream inputStream) throws Exception {
                return new XmlResponsesSaxParser().k(inputStream).m();
            }
        }, new ServerSideEncryptionHeaderHandler()), initiateMultipartUploadRequest.l(), initiateMultipartUploadRequest.n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amazonaws.services.s3.AmazonS3
    public S3Object c(GetObjectRequest getObjectRequest) throws AmazonClientException {
        ValidationUtils.a(getObjectRequest, "The GetObjectRequest parameter must be specified when requesting an object");
        ValidationUtils.a(getObjectRequest.k(), "The bucket name parameter must be specified when requesting an object");
        ValidationUtils.a(getObjectRequest.l(), "The key parameter must be specified when requesting an object");
        Request requestG = G(getObjectRequest.k(), getObjectRequest.l(), getObjectRequest, HttpMethodName.GET);
        if (getObjectRequest.t() != null) {
            requestG.g("versionId", getObjectRequest.t());
        }
        long[] jArrP = getObjectRequest.p();
        if (jArrP != null) {
            String str = "bytes=" + Long.toString(jArrP[0]) + Constants.FILENAME_SEQUENCE_SEPARATOR;
            if (jArrP[1] >= 0) {
                str = str + Long.toString(jArrP[1]);
            }
            requestG.i(HttpHeaders.RANGE, str);
        }
        a0(requestG, getObjectRequest.u());
        B(requestG, getObjectRequest.q());
        z(requestG, HttpHeaders.IF_MODIFIED_SINCE, getObjectRequest.n());
        z(requestG, HttpHeaders.IF_UNMODIFIED_SINCE, getObjectRequest.s());
        C(requestG, HttpHeaders.IF_MATCH, getObjectRequest.m());
        C(requestG, HttpHeaders.IF_NONE_MATCH, getObjectRequest.o());
        b0(requestG, getObjectRequest.r());
        ProgressListenerCallbackExecutor progressListenerCallbackExecutorD = ProgressListenerCallbackExecutor.d(getObjectRequest.c());
        try {
            S3Object s3Object = (S3Object) U(requestG, new S3ObjectResponseHandler(), getObjectRequest.k(), getObjectRequest.l());
            s3Object.m(getObjectRequest.k());
            s3Object.p(getObjectRequest.l());
            ServiceClientHolderInputStream serviceClientHolderInputStream = new ServiceClientHolderInputStream(s3Object.f(), this);
            if (progressListenerCallbackExecutorD != null) {
                ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(serviceClientHolderInputStream, progressListenerCallbackExecutorD);
                progressReportingInputStream.p(true);
                progressReportingInputStream.q(this.p);
                L(progressListenerCallbackExecutorD, 2);
                serviceClientHolderInputStream = progressReportingInputStream;
            }
            s3Object.q(new S3ObjectInputStream(new LengthCheckInputStream(serviceClientHolderInputStream, s3Object.j().o(), true)));
            return s3Object;
        } catch (AmazonS3Exception e) {
            if (e.e() == 412 || e.e() == 304) {
                L(progressListenerCallbackExecutorD, 16);
                return null;
            }
            L(progressListenerCallbackExecutorD, 8);
            throw e;
        }
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public UploadPartResult d(UploadPartRequest uploadPartRequest) throws IOException, AmazonClientException {
        InputStream inputSubstream;
        ValidationUtils.a(uploadPartRequest, "The request parameter must be specified when uploading a part");
        String strK = uploadPartRequest.k();
        String strP = uploadPartRequest.p();
        String strV = uploadPartRequest.v();
        int iS = uploadPartRequest.s();
        long jT = uploadPartRequest.t();
        ValidationUtils.a(strK, "The bucket name parameter must be specified when uploading a part");
        ValidationUtils.a(strP, "The key parameter must be specified when uploading a part");
        ValidationUtils.a(strV, "The upload ID parameter must be specified when uploading a part");
        ValidationUtils.a(Integer.valueOf(iS), "The part number parameter must be specified when uploading a part");
        ValidationUtils.a(Long.valueOf(jT), "The part size parameter must be specified when uploading a part");
        Request requestG = G(strK, strP, uploadPartRequest, HttpMethodName.PUT);
        requestG.g("uploadId", strV);
        requestG.g("partNumber", Integer.toString(iS));
        ObjectMetadata objectMetadataR = uploadPartRequest.r();
        if (objectMetadataR != null) {
            Z(requestG, objectMetadataR);
        }
        requestG.i(HttpHeaders.CONTENT_LENGTH, Long.toString(jT));
        a0(requestG, uploadPartRequest.w());
        b0(requestG, uploadPartRequest.u());
        if (uploadPartRequest.o() != null) {
            inputSubstream = uploadPartRequest.o();
        } else {
            if (uploadPartRequest.l() == null) {
                throw new IllegalArgumentException("A File or InputStream must be specified when uploading part");
            }
            try {
                inputSubstream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.l()), uploadPartRequest.m(), jT, true);
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("The specified file doesn't exist", e);
            }
        }
        if (uploadPartRequest.q() == null && !ServiceUtils.h(uploadPartRequest, this.m) && inputSubstream.markSupported()) {
            try {
                A(requestG, HttpHeaders.CONTENT_MD5, Md5Utils.d(inputSubstream));
                inputSubstream.reset();
            } catch (Exception e2) {
                throw new AmazonClientException("Unable to calculate MD5 hash: " + e2.getMessage(), e2);
            }
        }
        ProgressListenerCallbackExecutor progressListenerCallbackExecutorD = ProgressListenerCallbackExecutor.d(uploadPartRequest.c());
        if (progressListenerCallbackExecutorD != null) {
            ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(inputSubstream, progressListenerCallbackExecutorD);
            progressReportingInputStream.q(this.p);
            L(progressListenerCallbackExecutorD, 1024);
            inputSubstream = progressReportingInputStream;
        }
        try {
            try {
                requestG.a(inputSubstream);
                ObjectMetadata objectMetadata = (ObjectMetadata) U(requestG, new S3MetadataResponseHandler(), strK, strP);
                L(progressListenerCallbackExecutorD, 2048);
                UploadPartResult uploadPartResult = new UploadPartResult();
                uploadPartResult.i(objectMetadata.r());
                uploadPartResult.j(iS);
                uploadPartResult.f(objectMetadata.z());
                uploadPartResult.b(objectMetadata.B());
                uploadPartResult.g(objectMetadata.C());
                uploadPartResult.e(objectMetadata.G());
                if (inputSubstream != null) {
                    try {
                        inputSubstream.close();
                    } catch (Exception unused) {
                    }
                }
                return uploadPartResult;
            } catch (Throwable th) {
                if (inputSubstream != null) {
                    try {
                        inputSubstream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (AmazonClientException e3) {
            L(progressListenerCallbackExecutorD, 4096);
            throw e3;
        }
    }

    public void d0(Request<?> request, String str, String str2) {
        e0(request, str, str2, null);
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public void e(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException {
        ValidationUtils.a(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.k(), "The bucket name parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.l(), "The key parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.m(), "The upload ID parameter must be specified when aborting a multipart upload");
        String strK = abortMultipartUploadRequest.k();
        String strL = abortMultipartUploadRequest.l();
        Request requestG = G(strK, strL, abortMultipartUploadRequest, HttpMethodName.DELETE);
        requestG.g("uploadId", abortMultipartUploadRequest.m());
        a0(requestG, abortMultipartUploadRequest.n());
        U(requestG, this.l, strK, strL);
    }

    public void e0(Request<?> request, String str, String str2, URI uri) {
        if (uri == null) {
            uri = this.a;
        }
        if (i0(uri, str)) {
            r.a("Using virtual style addressing. Endpoint = " + uri);
            request.t(E(uri, str));
            request.c(N(str2));
        } else {
            r.a("Using path style addressing. Endpoint = " + uri);
            request.t(uri);
            if (str != null) {
                request.c(O(str, str2));
            }
        }
        r.a("Key: " + str2 + "; Request: " + request);
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public PutObjectResult f(PutObjectRequest putObjectRequest) throws IOException, AmazonClientException {
        InputStream inputStream;
        ValidationUtils.a(putObjectRequest, "The PutObjectRequest parameter must be specified when uploading an object");
        String strN = putObjectRequest.n();
        String strR = putObjectRequest.r();
        ObjectMetadata objectMetadataS = putObjectRequest.s();
        InputStream inputStreamQ = putObjectRequest.q();
        ProgressListenerCallbackExecutor progressListenerCallbackExecutorD = ProgressListenerCallbackExecutor.d(putObjectRequest.c());
        if (objectMetadataS == null) {
            objectMetadataS = new ObjectMetadata();
        }
        ValidationUtils.a(strN, "The bucket name parameter must be specified when uploading an object");
        ValidationUtils.a(strR, "The key parameter must be specified when uploading an object");
        boolean zH = ServiceUtils.h(putObjectRequest, this.m);
        InputStream repeatableFileInputStream = inputStreamQ;
        if (putObjectRequest.p() != null) {
            File fileP = putObjectRequest.p();
            objectMetadataS.L(fileP.length());
            boolean z = objectMetadataS.p() == null;
            if (objectMetadataS.q() == null) {
                objectMetadataS.N(Mimetypes.a().b(fileP));
            }
            if (z && !zH) {
                try {
                    objectMetadataS.M(Md5Utils.c(fileP));
                } catch (Exception e) {
                    throw new AmazonClientException("Unable to calculate MD5 hash: " + e.getMessage(), e);
                }
            }
            try {
                repeatableFileInputStream = new RepeatableFileInputStream(fileP);
            } catch (FileNotFoundException e2) {
                throw new AmazonClientException("Unable to find file to upload", e2);
            }
        }
        Request<?> requestG = G(strN, strR, putObjectRequest, HttpMethodName.PUT);
        if (putObjectRequest.m() != null) {
            y(requestG, putObjectRequest.m());
        } else if (putObjectRequest.o() != null) {
            requestG.i("x-amz-acl", putObjectRequest.o().toString());
        }
        if (putObjectRequest.w() != null) {
            requestG.i("x-amz-storage-class", putObjectRequest.w());
        }
        InputStream byteArrayInputStream = repeatableFileInputStream;
        if (putObjectRequest.t() != null) {
            requestG.i("x-amz-website-redirect-location", putObjectRequest.t());
            byteArrayInputStream = repeatableFileInputStream;
            if (repeatableFileInputStream == null) {
                g0(requestG);
                byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
            }
        }
        A(requestG, "x-amz-tagging", k0(putObjectRequest.x()));
        a0(requestG, putObjectRequest.T());
        b0(requestG, putObjectRequest.v());
        Long l = (Long) objectMetadataS.x(HttpHeaders.CONTENT_LENGTH);
        if (l != null) {
            long jLongValue = l.longValue();
            inputStream = byteArrayInputStream;
            if (jLongValue >= 0) {
                LengthCheckInputStream lengthCheckInputStream = new LengthCheckInputStream(byteArrayInputStream, jLongValue, false);
                requestG.i(HttpHeaders.CONTENT_LENGTH, l.toString());
                inputStream = lengthCheckInputStream;
            }
        } else if (byteArrayInputStream.markSupported()) {
            requestG.i(HttpHeaders.CONTENT_LENGTH, String.valueOf(D(byteArrayInputStream)));
            inputStream = byteArrayInputStream;
        } else {
            r.g("No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors.");
            ByteArrayInputStream byteArrayInputStreamJ0 = j0(byteArrayInputStream);
            requestG.i(HttpHeaders.CONTENT_LENGTH, String.valueOf(byteArrayInputStreamJ0.available()));
            requestG.o(true);
            inputStream = byteArrayInputStreamJ0;
        }
        if (progressListenerCallbackExecutorD != null) {
            ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(inputStream, progressListenerCallbackExecutorD);
            progressReportingInputStream.q(this.p);
            L(progressListenerCallbackExecutorD, 2);
            inputStream = progressReportingInputStream;
        }
        if (objectMetadataS.q() == null) {
            objectMetadataS.N(DfuBaseService.MIME_TYPE_OCTET_STREAM);
        }
        Z(requestG, objectMetadataS);
        c0(requestG, putObjectRequest.u());
        requestG.a(inputStream);
        try {
            try {
                ObjectMetadata objectMetadata = (ObjectMetadata) U(requestG, new S3MetadataResponseHandler(), strN, strR);
                try {
                    inputStream.close();
                } catch (AbortedException unused) {
                } catch (Exception e3) {
                    r.e("Unable to cleanly close input stream: " + e3.getMessage(), e3);
                }
                L(progressListenerCallbackExecutorD, 4);
                PutObjectResult putObjectResult = new PutObjectResult();
                putObjectResult.a(objectMetadata.F());
                putObjectResult.f(objectMetadata.z());
                putObjectResult.b(objectMetadata.B());
                putObjectResult.g(objectMetadata.C());
                putObjectResult.d(objectMetadata.s());
                putObjectResult.c(objectMetadata.t());
                putObjectResult.i(objectMetadata.r());
                putObjectResult.j(objectMetadata);
                putObjectResult.e(objectMetadata.G());
                putObjectResult.h(objectMetadata.p());
                return putObjectResult;
            } catch (AmazonClientException e4) {
                L(progressListenerCallbackExecutorD, 8);
                throw e4;
            }
        } finally {
        }
    }

    public final void f0(AWSS3V4Signer aWSS3V4Signer, String str) {
        aWSS3V4Signer.setServiceName(o());
        aWSS3V4Signer.setRegionName(str);
    }

    public final void g0(Request<?> request) {
        request.i(HttpHeaders.CONTENT_LENGTH, String.valueOf(0));
    }

    public final boolean h0(AmazonWebServiceRequest amazonWebServiceRequest, AmazonS3Exception amazonS3Exception, int i) {
        RetryPolicy retryPolicyD = this.c.d();
        if (retryPolicyD == null || retryPolicyD.c() == null || retryPolicyD == PredefinedRetryPolicies.a) {
            return false;
        }
        return this.q.a(amazonWebServiceRequest, amazonS3Exception, i);
    }

    public final boolean i0(URI uri, String str) {
        return (this.m.d() || !BucketNameUtils.isDNSBucketName(str) || X(uri.getHost())) ? false : true;
    }

    public final ByteArrayInputStream j0(InputStream inputStream) throws IOException {
        int i = 262144;
        byte[] bArr = new byte[262144];
        int i2 = 0;
        while (i > 0) {
            try {
                int i3 = inputStream.read(bArr, i2, i);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
                i -= i3;
            } catch (IOException e) {
                throw new AmazonClientException("Failed to read from inputstream", e);
            }
        }
        if (inputStream.read() != -1) {
            throw new AmazonClientException("Input stream exceeds 256k buffer.");
        }
        inputStream.close();
        return new ByteArrayInputStream(bArr, 0, i2);
    }

    public final String k0(ObjectTagging objectTagging) {
        if (objectTagging == null || objectTagging.a() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Tag> it = objectTagging.a().iterator();
        while (it.hasNext()) {
            Tag next = it.next();
            sb.append(S3HttpUtils.b(next.a(), false));
            sb.append('=');
            sb.append(S3HttpUtils.b(next.b(), false));
            if (it.hasNext()) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void v(String str) {
        if (str.endsWith("s3-accelerate.amazonaws.com")) {
            throw new IllegalStateException("To enable accelerate mode, please use AmazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());");
        }
        super.v(str);
        if (str.endsWith("s3.amazonaws.com")) {
            return;
        }
        this.o = AwsHostNameUtils.a(this.a.getHost(), "s3");
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void w(com.amazonaws.regions.Region region) {
        super.w(region);
        this.o = region.d();
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.k = new S3ErrorResponseHandler();
        this.l = new S3XmlResponseHandler<>(null);
        this.m = new S3ClientOptions();
        this.p = 1024;
        this.q = new CompleteMultipartUploadRetryCondition();
        this.n = aWSCredentialsProvider;
        S();
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, com.amazonaws.regions.Region region) {
        this(aWSCredentials, region, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration) {
        this(aWSCredentials, region, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this(new StaticCredentialsProvider(aWSCredentials), region, clientConfiguration, httpClient);
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.k = new S3ErrorResponseHandler();
        this.l = new S3XmlResponseHandler<>(null);
        this.m = new S3ClientOptions();
        this.p = 1024;
        this.q = new CompleteMultipartUploadRetryCondition();
        this.n = aWSCredentialsProvider;
        T(region, clientConfiguration);
    }
}
