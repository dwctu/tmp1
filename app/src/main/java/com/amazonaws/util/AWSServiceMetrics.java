package com.amazonaws.util;

@Deprecated
/* loaded from: classes.dex */
public enum AWSServiceMetrics implements Object {
    HttpClientGetConnectionTime("HttpClient");

    private final String serviceName;

    AWSServiceMetrics(String str) {
        this.serviceName = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
