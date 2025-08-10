package com.amazonaws.mobileconnectors.s3.transferutility;

/* loaded from: classes.dex */
public interface TransferListener {
    void a(int i, TransferState transferState);

    void b(int i, long j, long j2);

    void c(int i, Exception exc);
}
