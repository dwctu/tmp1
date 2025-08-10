package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class AbstractPutObjectRequest extends AmazonWebServiceRequest implements Serializable {
    public transient InputStream a;
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedAcl;
    private File file;
    private String key;
    private ObjectMetadata metadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private String storageClass;
    private ObjectTagging tagging;

    public AbstractPutObjectRequest(String str, String str2, File file) {
        this.bucketName = str;
        this.key = str2;
        this.file = file;
    }

    public void A(CannedAccessControlList cannedAccessControlList) {
        this.cannedAcl = cannedAccessControlList;
    }

    public void B(InputStream inputStream) {
        this.a = inputStream;
    }

    public void C(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void D(String str) {
        this.redirectLocation = str;
    }

    public void E(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null && this.sseCustomerKey != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
        this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
    }

    public void F(SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey != null && this.sseAwsKeyManagementParams != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
    }

    public void G(String str) {
        this.storageClass = str;
    }

    public void H(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T J(AccessControlList accessControlList) {
        z(accessControlList);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T K(CannedAccessControlList cannedAccessControlList) {
        A(cannedAccessControlList);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T L(InputStream inputStream) {
        B(inputStream);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T M(ObjectMetadata objectMetadata) {
        C(objectMetadata);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T N(String str) {
        this.redirectLocation = str;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T P(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        E(sSEAwsKeyManagementParams);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T Q(SSECustomerKey sSECustomerKey) {
        F(sSECustomerKey);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractPutObjectRequest> T R(String str) {
        G(str);
        return this;
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    /* renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AbstractPutObjectRequest k() {
        return (AbstractPutObjectRequest) super.k();
    }

    public final <T extends AbstractPutObjectRequest> T l(T t) {
        b(t);
        ObjectMetadata objectMetadataS = s();
        return (T) t.J(m()).K(o()).L(q()).M(objectMetadataS == null ? null : objectMetadataS.clone()).N(t()).R(w()).P(u()).Q(v());
    }

    public AccessControlList m() {
        return this.accessControlList;
    }

    public String n() {
        return this.bucketName;
    }

    public CannedAccessControlList o() {
        return this.cannedAcl;
    }

    public File p() {
        return this.file;
    }

    public InputStream q() {
        return this.a;
    }

    public String r() {
        return this.key;
    }

    public ObjectMetadata s() {
        return this.metadata;
    }

    public String t() {
        return this.redirectLocation;
    }

    public SSEAwsKeyManagementParams u() {
        return this.sseAwsKeyManagementParams;
    }

    public SSECustomerKey v() {
        return this.sseCustomerKey;
    }

    public String w() {
        return this.storageClass;
    }

    public ObjectTagging x() {
        return this.tagging;
    }

    public void z(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }
}
