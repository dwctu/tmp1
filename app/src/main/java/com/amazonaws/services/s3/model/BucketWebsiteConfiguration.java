package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class BucketWebsiteConfiguration implements Serializable {
    private String errorDocument;
    private String indexDocumentSuffix;
    private RedirectRule redirectAllRequestsTo;
    private List<RoutingRule> routingRules = new LinkedList();

    public BucketWebsiteConfiguration() {
    }

    public List<RoutingRule> a() {
        return this.routingRules;
    }

    public void b(String str) {
        this.errorDocument = str;
    }

    public void c(String str) {
        this.indexDocumentSuffix = str;
    }

    public void d(RedirectRule redirectRule) {
        this.redirectAllRequestsTo = redirectRule;
    }

    public BucketWebsiteConfiguration(String str) {
        this.indexDocumentSuffix = str;
    }
}
