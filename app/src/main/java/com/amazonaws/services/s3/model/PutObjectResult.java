package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

/* loaded from: classes.dex */
public class PutObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {
    @Override // com.amazonaws.services.s3.internal.S3VersionResult
    public void a(String str) {
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void c(String str) {
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void d(Date date) {
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(ObjectMetadata objectMetadata) {
    }
}
