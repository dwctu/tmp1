package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: classes.dex */
public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {
    public String a;

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
    }

    public String h() {
        return this.a;
    }

    public void i(String str) {
        this.a = str;
    }

    public void j(int i) {
    }
}
