package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/* loaded from: classes.dex */
public class S3ObjectResponseHandler extends AbstractS3ResponseHandler<S3Object> {
    @Override // com.amazonaws.services.s3.internal.AbstractS3ResponseHandler, com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return true;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<S3Object> a(HttpResponse httpResponse) throws Exception {
        S3Object s3Object = new S3Object();
        AmazonWebServiceResponse<S3Object> amazonWebServiceResponseC = c(httpResponse);
        if (httpResponse.c().get("x-amz-website-redirect-location") != null) {
            s3Object.x(httpResponse.c().get("x-amz-website-redirect-location"));
        }
        if (httpResponse.c().get("x-amz-request-charged") != null) {
            s3Object.e(true);
        }
        if (httpResponse.c().get("x-amz-tagging-count") != null) {
            s3Object.A(Integer.valueOf(Integer.parseInt(httpResponse.c().get("x-amz-tagging-count"))));
        }
        d(httpResponse, s3Object.j());
        s3Object.q(new S3ObjectInputStream(httpResponse.b()));
        amazonWebServiceResponseC.d(s3Object);
        return amazonWebServiceResponseC;
    }
}
