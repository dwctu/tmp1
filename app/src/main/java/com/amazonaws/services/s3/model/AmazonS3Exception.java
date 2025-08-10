package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonServiceException;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public class AmazonS3Exception extends AmazonServiceException implements Serializable {
    private static final long serialVersionUID = 7573680383273658477L;
    private Map<String, String> additionalDetails;
    private String cloudFrontId;
    private final String errorResponseXml;
    private String extendedRequestId;

    public AmazonS3Exception(String str) {
        super(str);
        this.errorResponseXml = null;
    }

    public Map<String, String> l() {
        return this.additionalDetails;
    }

    public String m() {
        return this.extendedRequestId;
    }

    public void n(Map<String, String> map) {
        this.additionalDetails = map;
    }

    public void o(String str) {
        this.cloudFrontId = str;
    }

    public void p(String str) {
        this.extendedRequestId = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ", S3 Extended Request ID: " + m();
    }
}
