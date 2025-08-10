package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public class GeneratePresignedUrlRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private String contentMd5;
    private String contentType;
    private Map<String, String> customQueryParameters;
    private Date expiration;
    private String key;
    private String kmsCmkId;
    private HttpMethod method;
    private final Map<String, String> requestParameters;
    private ResponseHeaderOverrides responseHeaders;
    private String sseAlgorithm;
    private SSECustomerKey sseCustomerKey;
    private String versionId;
    private boolean zeroByteContent;
}
