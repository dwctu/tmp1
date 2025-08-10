package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AbortMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;
    private String uploadId;

    public AbortMultipartUploadRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
    }

    public String k() {
        return this.bucketName;
    }

    public String l() {
        return this.key;
    }

    public String m() {
        return this.uploadId;
    }

    public boolean n() {
        return this.isRequesterPays;
    }
}
