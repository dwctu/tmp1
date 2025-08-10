package com.amazonaws.services.s3.internal;

/* loaded from: classes.dex */
public abstract class SSEResultBase implements ServerSideEncryptionResult {
    private String sseAlgorithm;
    private String sseCustomerAlgorithm;
    private String sseCustomerKeyMD5;

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void b(String str) {
        this.sseCustomerAlgorithm = str;
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void f(String str) {
        this.sseAlgorithm = str;
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void g(String str) {
        this.sseCustomerKeyMD5 = str;
    }
}
