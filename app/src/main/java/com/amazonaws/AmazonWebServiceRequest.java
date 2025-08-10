package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.metrics.RequestMetricCollector;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceRequest implements Cloneable {
    private AmazonWebServiceRequest cloneSource;
    private AWSCredentials credentials;
    private ProgressListener generalProgressListener;
    private final RequestClientOptions requestClientOptions = new RequestClientOptions();

    @Deprecated
    private RequestMetricCollector requestMetricCollector;

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceRequest clone() {
        try {
            AmazonWebServiceRequest amazonWebServiceRequest = (AmazonWebServiceRequest) super.clone();
            amazonWebServiceRequest.g(this);
            return amazonWebServiceRequest;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    public final <T extends AmazonWebServiceRequest> T b(T t) {
        t.h(this.generalProgressListener);
        t.i(this.requestMetricCollector);
        return t;
    }

    public ProgressListener c() {
        return this.generalProgressListener;
    }

    public RequestClientOptions d() {
        return this.requestClientOptions;
    }

    public AWSCredentials e() {
        return this.credentials;
    }

    @Deprecated
    public RequestMetricCollector f() {
        return this.requestMetricCollector;
    }

    public final void g(AmazonWebServiceRequest amazonWebServiceRequest) {
        this.cloneSource = amazonWebServiceRequest;
    }

    public void h(ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    @Deprecated
    public void i(RequestMetricCollector requestMetricCollector) {
        this.requestMetricCollector = requestMetricCollector;
    }
}
