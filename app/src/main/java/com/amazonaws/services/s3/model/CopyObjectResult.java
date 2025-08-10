package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CopyObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult, Serializable {
    private String etag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private boolean isRequesterCharged;
    private Date lastModifiedDate;
    private String versionId;

    @Override // com.amazonaws.services.s3.internal.S3VersionResult
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
        this.etag = str;
    }

    public void i(Date date) {
        this.lastModifiedDate = date;
    }
}
