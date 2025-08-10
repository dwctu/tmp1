package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class UploadPartRequest extends AmazonWebServiceRequest implements Serializable {
    private static final long serialVersionUID = 1;
    public transient InputStream a;
    private String bucketName;
    private File file;
    private long fileOffset;
    private int id;
    private boolean isLastPart;
    private boolean isRequesterPays;
    private String key;
    private int mainUploadId;
    private String md5Digest;
    private ObjectMetadata objectMetadata;
    private int partNumber;
    private long partSize;
    private SSECustomerKey sseCustomerKey;
    private String uploadId;

    public void A(boolean z) {
        this.isLastPart = z;
    }

    public UploadPartRequest B(String str) {
        this.bucketName = str;
        return this;
    }

    public UploadPartRequest C(File file) {
        x(file);
        return this;
    }

    public UploadPartRequest D(long j) {
        z(j);
        return this;
    }

    public UploadPartRequest E(int i) {
        this.id = i;
        return this;
    }

    public UploadPartRequest F(String str) {
        this.key = str;
        return this;
    }

    public UploadPartRequest G(boolean z) {
        A(z);
        return this;
    }

    public UploadPartRequest H(int i) {
        this.mainUploadId = i;
        return this;
    }

    public UploadPartRequest J(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartRequest K(long j) {
        this.partSize = j;
        return this;
    }

    public UploadPartRequest L(String str) {
        this.uploadId = str;
        return this;
    }

    public String k() {
        return this.bucketName;
    }

    public File l() {
        return this.file;
    }

    public long m() {
        return this.fileOffset;
    }

    public int n() {
        return this.id;
    }

    public InputStream o() {
        return this.a;
    }

    public String p() {
        return this.key;
    }

    public String q() {
        return this.md5Digest;
    }

    public ObjectMetadata r() {
        return this.objectMetadata;
    }

    public int s() {
        return this.partNumber;
    }

    public long t() {
        return this.partSize;
    }

    public SSECustomerKey u() {
        return this.sseCustomerKey;
    }

    public String v() {
        return this.uploadId;
    }

    public boolean w() {
        return this.isRequesterPays;
    }

    public void x(File file) {
        this.file = file;
    }

    public void z(long j) {
        this.fileOffset = j;
    }
}
