package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

/* loaded from: classes.dex */
public interface AmazonS3 {
    CompleteMultipartUploadResult a(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException;

    InitiateMultipartUploadResult b(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException;

    S3Object c(GetObjectRequest getObjectRequest) throws AmazonClientException;

    UploadPartResult d(UploadPartRequest uploadPartRequest) throws AmazonClientException;

    void e(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException;

    PutObjectResult f(PutObjectRequest putObjectRequest) throws AmazonClientException;
}
