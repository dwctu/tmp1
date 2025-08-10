package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.event.ProgressListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class GetObjectRequest extends AmazonWebServiceRequest implements Serializable {
    private ProgressListener generalProgressListener;
    private boolean isRequesterPays;
    private List<String> matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private List<String> nonmatchingEtagConstraints;
    private Integer partNumber;
    private long[] range;
    private ResponseHeaderOverrides responseHeaders;
    private S3ObjectIdBuilder s3ObjectIdBuilder;
    private SSECustomerKey sseCustomerKey;
    private Date unmodifiedSinceConstraint;

    public GetObjectRequest(String str, String str2) {
        this(str, str2, null);
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    public ProgressListener c() {
        return this.generalProgressListener;
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    public void h(ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    public String k() {
        return this.s3ObjectIdBuilder.a();
    }

    public String l() {
        return this.s3ObjectIdBuilder.b();
    }

    public List<String> m() {
        return this.matchingETagConstraints;
    }

    public Date n() {
        return this.modifiedSinceConstraint;
    }

    public List<String> o() {
        return this.nonmatchingEtagConstraints;
    }

    public long[] p() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public ResponseHeaderOverrides q() {
        return this.responseHeaders;
    }

    public SSECustomerKey r() {
        return this.sseCustomerKey;
    }

    public Date s() {
        return this.unmodifiedSinceConstraint;
    }

    public String t() {
        return this.s3ObjectIdBuilder.c();
    }

    public boolean u() {
        return this.isRequesterPays;
    }

    public void v(String str) {
        this.s3ObjectIdBuilder.d(str);
    }

    public void w(String str) {
        this.s3ObjectIdBuilder.e(str);
    }

    public void x(long j, long j2) {
        this.range = new long[]{j, j2};
    }

    public void z(String str) {
        this.s3ObjectIdBuilder.f(str);
    }

    public GetObjectRequest(String str, String str2, String str3) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        v(str);
        w(str2);
        z(str3);
    }
}
