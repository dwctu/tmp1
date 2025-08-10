package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class InitiateMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedACL;
    private boolean isRequesterPays;
    private String key;
    public ObjectMetadata objectMetadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private StorageClass storageClass;
    private ObjectTagging tagging;

    public InitiateMultipartUploadRequest(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public InitiateMultipartUploadRequest A(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        v(sSEAwsKeyManagementParams);
        return this;
    }

    public InitiateMultipartUploadRequest B(ObjectTagging objectTagging) {
        w(objectTagging);
        return this;
    }

    public AccessControlList k() {
        return this.accessControlList;
    }

    public String l() {
        return this.bucketName;
    }

    public CannedAccessControlList m() {
        return this.cannedACL;
    }

    public String n() {
        return this.key;
    }

    public String o() {
        return this.redirectLocation;
    }

    public SSEAwsKeyManagementParams p() {
        return this.sseAwsKeyManagementParams;
    }

    public SSECustomerKey q() {
        return this.sseCustomerKey;
    }

    public StorageClass r() {
        return this.storageClass;
    }

    public ObjectTagging s() {
        return this.tagging;
    }

    public boolean t() {
        return this.isRequesterPays;
    }

    public void u(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public void v(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null && this.sseCustomerKey != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
        this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
    }

    public void w(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public InitiateMultipartUploadRequest x(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
        return this;
    }

    public InitiateMultipartUploadRequest z(ObjectMetadata objectMetadata) {
        u(objectMetadata);
        return this;
    }
}
