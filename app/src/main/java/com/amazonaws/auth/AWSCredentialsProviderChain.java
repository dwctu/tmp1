package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class AWSCredentialsProviderChain implements AWSCredentialsProvider {
    public static final Log d = LogFactory.b(AWSCredentialsProviderChain.class);
    public List<AWSCredentialsProvider> a = new LinkedList();
    public boolean b = true;
    public AWSCredentialsProvider c;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : aWSCredentialsProviderArr) {
            this.a.add(aWSCredentialsProvider);
        }
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        AWSCredentials credentials;
        AWSCredentialsProvider aWSCredentialsProvider;
        if (this.b && (aWSCredentialsProvider = this.c) != null) {
            return aWSCredentialsProvider.getCredentials();
        }
        for (AWSCredentialsProvider aWSCredentialsProvider2 : this.a) {
            try {
                credentials = aWSCredentialsProvider2.getCredentials();
            } catch (Exception e) {
                d.a("Unable to load credentials from " + aWSCredentialsProvider2.toString() + ": " + e.getMessage());
            }
            if (credentials.a() != null && credentials.b() != null) {
                d.a("Loading credentials from " + aWSCredentialsProvider2.toString());
                this.c = aWSCredentialsProvider2;
                return credentials;
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }
}
