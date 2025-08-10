package com.amazonaws.services.s3.model;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class PutObjectRequest extends AbstractPutObjectRequest implements Serializable {
    private boolean isRequesterPays;

    public PutObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: S, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public PutObjectRequest clone() {
        return (PutObjectRequest) l((PutObjectRequest) super.clone());
    }

    public boolean T() {
        return this.isRequesterPays;
    }

    public void U(boolean z) {
        this.isRequesterPays = z;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest J(AccessControlList accessControlList) {
        super.J(accessControlList);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest K(CannedAccessControlList cannedAccessControlList) {
        super.K(cannedAccessControlList);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest L(InputStream inputStream) {
        super.L(inputStream);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest M(ObjectMetadata objectMetadata) {
        super.M(objectMetadata);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest N(String str) {
        super.N(str);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest P(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        super.P(sSEAwsKeyManagementParams);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest Q(SSECustomerKey sSECustomerKey) {
        super.Q(sSECustomerKey);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public PutObjectRequest R(String str) {
        super.R(str);
        return this;
    }
}
