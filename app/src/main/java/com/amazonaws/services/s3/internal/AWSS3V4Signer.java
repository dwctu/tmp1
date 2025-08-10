package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AwsChunkedEncodingInputStream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.BinaryUtils;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AWSS3V4Signer extends AWS4Signer {
    public AWSS3V4Signer() {
        super(false);
    }

    public static long a(Request<?> request) throws IOException {
        InputStream content = request.getContent();
        if (!content.markSupported()) {
            throw new AmazonClientException("Failed to get content length");
        }
        long j = 0;
        byte[] bArr = new byte[4096];
        content.mark(-1);
        while (true) {
            int i = content.read(bArr);
            if (i == -1) {
                content.reset();
                return j;
            }
            j += i;
        }
    }

    public static boolean b(Request<?> request) {
        return (request.m() instanceof PutObjectRequest) || (request.m() instanceof UploadPartRequest);
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public String calculateContentHash(Request<?> request) throws NumberFormatException {
        long jA;
        request.i("x-amz-content-sha256", "required");
        if (!b(request)) {
            return super.calculateContentHash(request);
        }
        String str = request.getHeaders().get(HttpHeaders.CONTENT_LENGTH);
        if (str != null) {
            jA = Long.parseLong(str);
        } else {
            try {
                jA = a(request);
            } catch (IOException e) {
                throw new AmazonClientException("Cannot get the content-lenght of the request content.", e);
            }
        }
        request.i("x-amz-decoded-content-length", Long.toString(jA));
        request.i(HttpHeaders.CONTENT_LENGTH, Long.toString(AwsChunkedEncodingInputStream.p(jA)));
        return "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public String calculateContentHashPresign(Request<?> request) {
        return "UNSIGNED-PAYLOAD";
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public void processRequestPayload(Request<?> request, AWS4Signer.HeaderSigningResult headerSigningResult) {
        if (b(request)) {
            request.a(new AwsChunkedEncodingInputStream(request.getContent(), headerSigningResult.b(), headerSigningResult.a(), headerSigningResult.c(), BinaryUtils.a(headerSigningResult.d()), this));
        }
    }
}
