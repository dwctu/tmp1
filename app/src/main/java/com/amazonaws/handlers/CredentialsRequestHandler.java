package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: classes.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {
    public AWSCredentials a;

    public void e(AWSCredentials aWSCredentials) {
        this.a = aWSCredentials;
    }
}
