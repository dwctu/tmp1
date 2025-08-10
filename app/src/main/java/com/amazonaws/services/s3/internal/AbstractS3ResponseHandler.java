package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
    public static final Log a = LogFactory.b(S3MetadataResponseHandler.class);
    public static final Set<String> b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("Date");
        hashSet.add(HttpHeaders.SERVER);
        hashSet.add("x-amz-request-id");
        hashSet.add("x-amz-id-2");
        hashSet.add("X-Amz-Cf-Id");
        hashSet.add(HttpHeaders.CONNECTION);
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return false;
    }

    public AmazonWebServiceResponse<T> c(HttpResponse httpResponse) {
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        String str = httpResponse.c().get("x-amz-request-id");
        String str2 = httpResponse.c().get("x-amz-id-2");
        String str3 = httpResponse.c().get("X-Amz-Cf-Id");
        HashMap map = new HashMap();
        map.put("AWS_REQUEST_ID", str);
        map.put("HOST_ID", str2);
        map.put("CLOUD_FRONT_ID", str3);
        amazonWebServiceResponse.c(new S3ResponseMetadata(map));
        return amazonWebServiceResponse;
    }

    public void d(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Map.Entry<String, String> entry : httpResponse.c().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("x-amz-meta-")) {
                objectMetadata.i(key.substring(11), entry.getValue());
            } else if (b.contains(key)) {
                a.a(String.format("%s is ignored.", key));
            } else if (key.equalsIgnoreCase(HttpHeaders.LAST_MODIFIED)) {
                try {
                    objectMetadata.P(key, ServiceUtils.f(entry.getValue()));
                } catch (Exception e) {
                    a.f("Unable to parse last modified date: " + entry.getValue(), e);
                }
            } else if (key.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                try {
                    objectMetadata.P(key, Long.valueOf(Long.parseLong(entry.getValue())));
                } catch (NumberFormatException e2) {
                    a.f("Unable to parse content length: " + entry.getValue(), e2);
                }
            } else if (key.equalsIgnoreCase(HttpHeaders.ETAG)) {
                objectMetadata.P(key, ServiceUtils.g(entry.getValue()));
            } else if (key.equalsIgnoreCase(HttpHeaders.EXPIRES)) {
                try {
                    objectMetadata.Q(DateUtils.i(entry.getValue()));
                } catch (Exception e3) {
                    a.f("Unable to parse http expiration date: " + entry.getValue(), e3);
                }
            } else if (key.equalsIgnoreCase("x-amz-expiration")) {
                new ObjectExpirationHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-restore")) {
                new ObjectRestoreHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-request-charged")) {
                new S3RequesterChargedHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-mp-parts-count")) {
                try {
                    objectMetadata.P(key, Integer.valueOf(Integer.parseInt(entry.getValue())));
                } catch (NumberFormatException e4) {
                    throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e4.getMessage(), e4);
                }
            } else {
                objectMetadata.P(key, entry.getValue());
            }
        }
    }
}
