package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CompleteMultipartUploadResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, Serializable {
    private String bucketName;
    private String eTag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private boolean isRequesterCharged;
    private String key;
    private String location;
    private String versionId;

    public void a(String str) {
        this.versionId = str;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void c(String str) {
        this.expirationTimeRuleId = str;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void d(Date date) {
        this.expirationTime = date;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
        this.isRequesterCharged = z;
    }

    public void h(String str) {
        this.bucketName = str;
    }

    public void i(String str) {
        this.eTag = str;
    }

    public void j(String str) {
        this.key = str;
    }

    public void k(String str) {
        this.location = str;
    }
}
