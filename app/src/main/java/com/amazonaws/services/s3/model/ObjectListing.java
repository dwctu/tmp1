package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ObjectListing implements Serializable {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private String marker;
    private int maxKeys;
    private String nextMarker;
    private String prefix;
    private List<S3ObjectSummary> objectSummaries = new ArrayList();
    private List<String> commonPrefixes = new ArrayList();

    public String a() {
        return this.bucketName;
    }

    public List<String> b() {
        return this.commonPrefixes;
    }

    public String c() {
        return this.nextMarker;
    }

    public List<S3ObjectSummary> d() {
        return this.objectSummaries;
    }

    public boolean e() {
        return this.isTruncated;
    }

    public void f(String str) {
        this.bucketName = str;
    }

    public void g(String str) {
        this.delimiter = str;
    }

    public void h(String str) {
        this.encodingType = str;
    }

    public void i(String str) {
        this.marker = str;
    }

    public void j(int i) {
        this.maxKeys = i;
    }

    public void k(String str) {
        this.nextMarker = str;
    }

    public void l(String str) {
        this.prefix = str;
    }

    public void m(boolean z) {
        this.isTruncated = z;
    }
}
