package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CompleteMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;
    private List<PartETag> partETags;
    private String uploadId;

    public CompleteMultipartUploadRequest() {
        this.partETags = new ArrayList();
    }

    public String k() {
        return this.bucketName;
    }

    public String l() {
        return this.key;
    }

    public List<PartETag> m() {
        return this.partETags;
    }

    public String n() {
        return this.uploadId;
    }

    public boolean o() {
        return this.isRequesterPays;
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        this.partETags = new ArrayList();
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
        this.partETags = list;
    }
}
