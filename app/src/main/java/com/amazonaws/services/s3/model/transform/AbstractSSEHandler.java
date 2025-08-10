package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* loaded from: classes.dex */
public abstract class AbstractSSEHandler extends AbstractHandler implements ServerSideEncryptionResult {
    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void b(String str) {
        ServerSideEncryptionResult serverSideEncryptionResultM = m();
        if (serverSideEncryptionResultM != null) {
            serverSideEncryptionResultM.b(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void f(String str) {
        ServerSideEncryptionResult serverSideEncryptionResultM = m();
        if (serverSideEncryptionResultM != null) {
            serverSideEncryptionResultM.f(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void g(String str) {
        ServerSideEncryptionResult serverSideEncryptionResultM = m();
        if (serverSideEncryptionResultM != null) {
            serverSideEncryptionResultM.g(str);
        }
    }

    public abstract ServerSideEncryptionResult m();
}
